package PageObjects.Spotify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage
{
    @FindBy(how = How.XPATH, using = "//*[@text='הושמעו לאחרונה']")
    public static WebElement title_recentlyPlayed;

    @FindBy(how = How.XPATH,using = "//*[@content-desc='הגדרות']")
    public static WebElement btn_settings;


}
