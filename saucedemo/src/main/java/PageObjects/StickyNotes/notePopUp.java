package PageObjects.StickyNotes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class notePopUp
{
    @FindBy(how = How.NAME, using = "עורך פתקים")
    public static WebElement txtbox_note;
}
