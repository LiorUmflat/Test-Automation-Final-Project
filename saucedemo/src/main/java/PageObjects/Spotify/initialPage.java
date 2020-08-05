package PageObjects.Spotify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class initialPage
{
    @FindBy(how = How.XPATH,using = "//*[@text='כניסה']")
    public static WebElement btn_entrance;
}
