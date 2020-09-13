package PageObjects.StickyNotes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage
{
    @FindBy(how = How.XPATH, using = "//*[@AutomationId='SettingsButton']")
    public static WebElement btn_settings;

    @FindBy(how = How.NAME, using = "פתק חדש")
    public static WebElement btn_AddNote;
}
