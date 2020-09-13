package PageObjects.StickyNotes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class signOutPopUp
{
    @FindBy(how = How.XPATH, using = "//*[@AutomationId='YesButton']")
    public static WebElement btn_signout;
}
