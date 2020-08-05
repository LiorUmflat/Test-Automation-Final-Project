package Utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listeners extends CommonOps implements ITestListener
{
    public void onFinish(ITestContext arg0)
    {
        System.out.println("------------------- End Execution -------------------");
    }

    public void onStart(ITestContext arg0)
    {
        System.out.println("------------------- Start Execution -------------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0)
    {
        System.out.println("------------------- Test: "+arg0.getName()+" partially failed -------------------");
    }

    public void onTestFailure(ITestResult arg0)
    {
        System.out.println("------------------- Test: "+arg0.getName()+" Failed -------------------");
        if(!getData("PlatformName").equalsIgnoreCase("api"))
        {
            SaveScreenshot();
        }
    }

    public void onTestSkipped(ITestResult arg0)
    {
        System.out.println("------------------- Starting Test: "+ arg0.getName()+"-------------------");
    }

    public void onTestStart(ITestResult arg0)
    {
        System.out.println("------------------- Starting Test: "+arg0.getName()+"-------------------");
    }

    public void onTestSuccess(ITestResult arg0)
    {
        System.out.println("------------------- Test: "+arg0.getName()+" passed -------------------");
    }

    @Attachment(value = "page Screenshot", type="image/png")
    public byte[] SaveScreenshot()
    {
        if(getData("PlatformName").equalsIgnoreCase("web"))
        {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        else if (getData("PlatformName").equalsIgnoreCase("mobile"))
        {
            return ((TakesScreenshot) androidMobileDriver).getScreenshotAs(OutputType.BYTES);
        }
        else
        {
            return null;
        }
    }
}
