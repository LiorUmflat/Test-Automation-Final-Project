package PageObjects.Netflix;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage
{
    @FindBy(how = How.NAME , using="אפשרויות נוספות")
    public static WebElement btn_moreOptions;
}
