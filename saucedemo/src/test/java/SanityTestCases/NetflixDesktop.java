package SanityTestCases;

import Utilities.CommonOps;
import WorkFlows.desktopFlows;
import WorkFlows.electronFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class NetflixDesktop extends CommonOps
{
    @Test(description = "Test 01: login to Netflix")
    @Description("Test Description: login to netflix and verify the main page display by verifying the more options sign")
    public void test01_loginToNetflix()
    {
        desktopFlows.login("yaki.um@gmail.com","qwer1234");
        Extensions.verifications.verifyElementText(mainPageNetflix.btn_moreOptions,"...");
    }
}
