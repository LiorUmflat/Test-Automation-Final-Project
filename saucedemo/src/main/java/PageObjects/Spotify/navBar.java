package PageObjects.Spotify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class navBar
{
    @FindBy(how = How.XPATH, using = "//*[@content-desc='מסך הבית']")
    public static WebElement btn_mainPage;

    @FindBy(how = How.XPATH,using = "//*[@content-desc='חיפוש']")
    public static WebElement btn_search;

    @FindBy(how = How.XPATH,using = "//*[@content-desc='הספרייה שלכם']")
    public static WebElement btn_yourLibrary;
}
