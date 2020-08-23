package PageObjects.Netflix;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPageInitPopup
{
    @FindBy(how = How.NAME,using = "אישור")
    public static WebElement btn_confirm;
}
