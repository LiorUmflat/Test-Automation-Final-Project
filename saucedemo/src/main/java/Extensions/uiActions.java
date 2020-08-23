package Extensions;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.rmi.server.ExportException;

public class uiActions extends CommonOps
{
    @Step("click on an element")
    public static void clickElement(WebElement elem)
    {
        if(!getData("PlatformName").equalsIgnoreCase("mobile") && !getData("PlatformName").equalsIgnoreCase("electron") && !getData("PlatformName").equalsIgnoreCase("desktop"))
        {
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        }
        elem.click();
    }

    @Step("enter string to an element")
    public static void sendKeysToElement(WebElement elem,String keys)
    {
        if(!getData("PlatformName").equalsIgnoreCase("mobile") && !getData("PlatformName").equalsIgnoreCase("electron") && !getData("PlatformName").equalsIgnoreCase("desktop"))
        {
            wait.until(ExpectedConditions.visibilityOf(elem));
        }
        elem.sendKeys(keys);
    }

    @Step("send Key to element")
    public static void sendKeyToElement(WebElement elem, Keys key)
    {
        if(!getData("PlatformName").equalsIgnoreCase("mobile") && !getData("PlatformName").equalsIgnoreCase("electron"))
        {
            wait.until(ExpectedConditions.visibilityOf(elem));
        }
        elem.sendKeys(key);
    }

    @Step("update drop down box")
    public static void updateDropDownBox(WebElement elem, String selection)
    {
        if(!getData("PlatformName").equalsIgnoreCase("mobile"))
        {
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        }
        Select dropdown = new Select(elem);
        dropdown.selectByVisibleText(selection);
    }

    @Step("swipe down until element is found and click it")
    public static void swipeTillElementIsFoundAndClickIt(String direction, String offset, String SwipeTime, String locator, String ElementIndex,String delay, String maxOfRounds  )
    {
        androidMobileDriver.executeScript("client:client.swipeWhileNotFound(\""+direction+"\","+offset+","+SwipeTime+",\"NATIVE\",\""+locator+"\","+ElementIndex+","+delay+","+maxOfRounds+",true)");
    }


}
