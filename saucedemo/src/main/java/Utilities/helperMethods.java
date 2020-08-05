package Utilities;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;

public class helperMethods extends CommonOps
{
    public static void TakeElementScreenShot(WebElement imageElement, String imageName)
    {

        ImageScreenShot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,imageElement);
        try
        {
            ImageIO.write(ImageScreenShot.getImage(), "png", new File(getData("ImageRepo") + imageName + ".png"));
        }
        catch(Exception e)
        {
            System.out.println("Error writing image file, see details: "+ e);
        }
    }
}
