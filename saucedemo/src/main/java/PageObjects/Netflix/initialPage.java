package PageObjects.Netflix;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class initialPage
{
    @FindBy(how = How.NAME,using = "היכנס")
    public static WebElement btn_enter;
}
