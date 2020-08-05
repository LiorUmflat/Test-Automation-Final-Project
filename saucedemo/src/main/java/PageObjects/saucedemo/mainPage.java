package PageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class mainPage
{

    @FindBy(how = How.CLASS_NAME,using = "product_label")
    public static WebElement label_headline;

    @FindBy(how = How.CLASS_NAME,using = "product_sort_container")
    public static WebElement dropdown_productSort;

    @FindBy(how = How.CLASS_NAME,using = "inventory_item_price")
    public static List<WebElement> label_itemsPrice;

    @FindBy(how = How.CLASS_NAME,using = "btn_primary")
    public static List<WebElement> btn_addToCart;

    @FindBy(how = How.CLASS_NAME,using = "shopping_cart_badge")
    public static WebElement img_cartBadge;

    @FindBy(how = How.CLASS_NAME,using = "fa-shopping-cart")
    public static WebElement img_cart;

    @FindBy(how = How.CLASS_NAME,using = "bm-burger-button")
    public static WebElement btn_buregerMenu;

    @FindBy(how = How.ID,using = "logout_sidebar_link")
    public static WebElement btn_logout;
}
