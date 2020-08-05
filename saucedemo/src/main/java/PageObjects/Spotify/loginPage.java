package PageObjects.Spotify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage
{
    @FindBy(how = How.ID,using = "username_text")
    public static WebElement txt_username;

    @FindBy(how = How.ID,using = "password_text")
    public static WebElement txt_password;

    @FindBy(how = How.ID,using = "login_button")
    public static WebElement btn_login;
}
