package PageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class cartPage
{
    @FindBy (how = How.CLASS_NAME,using = "cart_item_label")
    public static List<WebElement> items;

    @FindBy(how = How.CLASS_NAME,using = "cart_button")
    public static List<WebElement> btn_remove;

}
