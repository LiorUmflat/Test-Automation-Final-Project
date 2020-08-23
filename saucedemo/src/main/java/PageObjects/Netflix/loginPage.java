package PageObjects.Netflix;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage
{
    @FindBy(how = How.NAME,using = "אימייל")
    public static WebElement txt_email;

    @FindBy(how = How.NAME,using = "סיסמה")
    public static WebElement txt_password;

    @FindBy(how = How.NAME,using = "היכנס")
    public static WebElement btn_enter;
}
