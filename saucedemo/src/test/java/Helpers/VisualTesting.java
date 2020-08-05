package Helpers;

import Utilities.CommonOps;
import Utilities.helperMethods;
import org.testng.annotations.Test;


public class VisualTesting extends CommonOps
{
    @Test
    public void createScreenShot()
    {
        helperMethods.TakeElementScreenShot(loginsaucedemo.img_robot,"robotImage_ver01");
    }
}
