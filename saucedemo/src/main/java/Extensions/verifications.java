package Extensions;

import Utilities.CommonOps;
import WorkFlows.electronFlows;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class verifications extends CommonOps
{

    @Step("verify element text is equal to a given text")
    public static void verifyElementText(WebElement elem,String text)
    {
        Assert.assertEquals(elem.getText(),text);
    }

    @Step("verify items are sorted from low to high")
    public static void VerifyItemsSortedFromLowToHigh(List<WebElement> items)
    {
        //set flag to true, if it will change to false the list is not sorted from low to high.
        boolean flag=true;

        for(int i=0;i<items.size()-1;i++)
        {
            if(Double.parseDouble(items.get(i).getText().substring(1))>Double.parseDouble(items.get(i+1).getText().substring(1)))
            {
                flag=false;
            }
        }
        Assert.assertTrue(flag);
    }

    @Step("verify the size of List<WebElement> is equal to a given expected amount")
    public static void verifySizeOfWebElementList(List<WebElement> items,String expectedAmountOfItems)
    {
        Assert.assertEquals(Integer.toString(items.size()),expectedAmountOfItems);
    }

    @Step("verify WebElement is displayed")
    public static void verifyElementIsDisplayed(WebElement elem)
    {
        Assert.assertTrue(elem.isDisplayed());
    }

    @Step("verify WebElement contain a given text")
    public static void verifyElementContainText(WebElement elem,String text)
    {
        Assert.assertTrue(elem.getText().toLowerCase().contains(text.toLowerCase()));
    }

    @Step("verify WebElement attribute is equal to a given text")
    public static void verifyElementAttributeText(WebElement elem,String Attribute,String text)
    {
        Assert.assertEquals(elem.getAttribute(Attribute),text);
    }

    @Step("verify List<WebElement> contains or not contains a given text")
    public static void verifyWebElementListContainsOrNotContainsText(List<WebElement> elemList,String text,boolean containsOrNot)
    {
        boolean flag=false;
        for(WebElement elem:elemList)
        {
            if(elem.getText().toLowerCase().contains(text.toLowerCase()))
            {
                flag=true;
            }
        }
        if(containsOrNot == false)
        {
            Assert.assertFalse(flag);
        }
        else
        {
            Assert.assertTrue(flag);
        }
    }

    @Step("verify 2 given texts are equal")
    public static void verifyText(String actual, String expected)
    {
        Assert.assertEquals(expected,actual);
    }

    @Step("verify 2 given texts are Not equal")
    public static void verifyTextIsNotEqual(String actual, String expected)
    {
        Assert.assertNotEquals(actual,expected);
    }

    @Step("verify if WebElement in List<WebElement> has a specific tag and if it has an inside element with text that is equal to a desired text")
    public static void VerifyWebElementInListContainTag(List<WebElement> elemList,String elemText,String tag, String Textxpath)
    {
        boolean flag=false;
        for(int i=0;i< elemList.size();i++)
        {
            if(elemList.get(i).findElements(By.tagName(tag)).size()!=0 && elemList.get(i).findElements(By.xpath(Textxpath)).get(i).getText().equals(elemText))
            {
                flag=true;
            }
        }
        Assert.assertTrue(flag);
    }

    @Step("verify element visually")
    public static void visualElement(WebElement imageElement, String ExpectedImageName)
    {
        BufferedImage expectedImage = null;
        try
        {
            expectedImage = ImageIO.read(new File(getData("ImageRepo") + ExpectedImageName + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error Reading Image File");
        }

        Screenshot imageScreenShot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,imageElement);
        BufferedImage actualImage = imageScreenShot.getImage();
        diff = imageDiff.makeDiff(actualImage,expectedImage);
        //if there is no difference the test will pass
        Assert.assertFalse(diff.hasDiff(),"images are not the same");
    }

}
