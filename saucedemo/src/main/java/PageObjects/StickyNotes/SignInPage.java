package PageObjects.StickyNotes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInPage
{
    @FindBy(how = How.XPATH, using = "//*[@AutomationId='Account_0']")
    public static WebElement btn_Account;

    @FindBy(how = How.XPATH, using = "//*[@AutomationId='ContinueButton']")
    public static WebElement btn_SignIn;
}
