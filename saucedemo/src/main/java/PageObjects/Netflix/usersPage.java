package PageObjects.Netflix;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class usersPage
{
    @FindBy(how = How.NAME,using = "מי צופה ב-Netflix?")
    public static WebElement txt_WhosWatchingNetflix;

    @FindBy(how = How.NAME,using = "yaki.um")
    public static WebElement btn_yakiUser;
}
