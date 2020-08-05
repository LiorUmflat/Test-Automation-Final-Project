package PageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage
{
    @FindBy(how = How.ID, using = "user-name")
    public static WebElement txt_userName;

    @FindBy(how = How.ID, using = "password")
    public static WebElement txt_password;

    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    public static WebElement btn_login;

    @FindBy(how = How.CLASS_NAME,using = "bot_column")
    public static WebElement img_robot;


}
