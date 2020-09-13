package PageObjects.StickyNotes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class settingsPage
{
    @FindBy(how = How.XPATH, using = "//*[@AutomationId='SignInButton']")
    public static WebElement btn_signIn;

    @FindBy(how = How.NAME, using = "צא")
    public static WebElement btn_signout;

    @FindBy(how = How.NAME, using = "הקודם")
    public static WebElement btn_backToMain;

    @FindBy(how = How.NAME, using = "עזרה")
    public static WebElement btn_help;
}
