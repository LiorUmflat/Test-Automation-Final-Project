package PageObjects.Spotify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class googleSmartLockChooseAccountPopup
{
    @FindBy(how = How.ID,using = "cancel")
    public static WebElement btn_noOfTheAboveOptions;
}
