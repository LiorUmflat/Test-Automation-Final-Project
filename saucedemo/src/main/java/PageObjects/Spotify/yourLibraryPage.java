package PageObjects.Spotify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class yourLibraryPage
{
    @FindBy (how = How.XPATH, using = "//*[@text='שירים שאהבתם']")
    public static WebElement btn_songsYouLike;
}
