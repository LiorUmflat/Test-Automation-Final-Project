package Utilities;

import WorkFlows.electronFlows;
import WorkFlows.mobileFlows;
import WorkFlows.webFlows;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends base
{
    //java parse xml file method:
    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc=null;
        File fXmlFile=new File("./Configurations/DataConfig.xml");
        DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        try
        {
            dBuilder=dbFactory.newDocumentBuilder();
            doc=dBuilder.parse(fXmlFile);
        }

        catch(Exception e){

            System.out.println("Exception in reading XML file: "+e);

        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public void initBrowser()
    {
        if(getData("BrowserType").equalsIgnoreCase("chrome"))
        {
            driver = initChrome();
        }
        else if(getData("BrowserType").equalsIgnoreCase("firefox"))
        {
            driver =initFF();
        }
        else if (getData("BrowserType").equalsIgnoreCase("IE"))
        {
            driver =initIE();
        }
        else
        {
            throw new RuntimeException("Invalid platform name");
        }

        driver.manage().window().maximize();
        driver.get(getData("URL"));
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(getData("timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Integer.parseInt(getData("timeout")));
    }

    public WebDriver initChrome()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public WebDriver initFF()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public WebDriver initIE()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }
    public void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try
        {
            androidMobileDriver =  new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
        }
        catch (Exception e)
        {
            System.out.println("Cannot Connect To Appium Server, See Details: " + e);
        }
        androidMobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeout")),TimeUnit.SECONDS);

    }

    public void initAPI()
    {
        RestAssured.baseURI = getData("URLApi");
        httpRequest = RestAssured.given();
    }

    public void initElectron()
    {
        System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions",opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeout")),TimeUnit.SECONDS);
        action = new Actions(driver);
    }

    @BeforeClass
    public void StartSession()
    {
        if(getData("PlatformName").equalsIgnoreCase("web"))
        {
            initBrowser();
        }
        else if (getData("PlatformName").equalsIgnoreCase("mobile"))
        {
            initMobile();
        }
        else if (getData("PlatformName").equalsIgnoreCase("api"))
        {
            initAPI();
        }
        else if (getData("PlatformName").equalsIgnoreCase("electron"))
        {
            initElectron();
        }
        else
            throw new RuntimeException("Invalid platform name");
        managePages.init();

    }

    @AfterMethod
    public void afterMethod()
    {
        if(getData("PlatformName").equalsIgnoreCase("web"))
        {
            driver.get(getData("URLAfterLogin"));
        }
        if(getData("PlatformName").equalsIgnoreCase("electron"))
        {
            electronFlows.EmptyListOfTasks();
        }
    }

    @AfterClass
    public void EndSession()
    {
        if(getData("PlatformName").equalsIgnoreCase("web"))
        {
            driver.quit();
        }
        else if (getData("PlatformName").equalsIgnoreCase("mobile"))
        {
            androidMobileDriver.quit();
        }
        else //else=API that doesn't got driver/androidMobileDriver
        {

        }
    }
}
