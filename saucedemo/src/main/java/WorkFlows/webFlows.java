package WorkFlows;

import Extensions.dbAction;
import Extensions.uiActions;
import PageObjects.saucedemo.loginPage;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class webFlows extends CommonOps
{
    @Step("login to the site with db credentials")
    public static void loginDB()
    {
        List<String> cred = dbAction.getCredentials("SELECT UserName, Password FROM credentials WHERE id='2'");
        uiActions.sendKeysToElement(loginsaucedemo.txt_userName,cred.get(0));
        uiActions.sendKeysToElement(loginsaucedemo.txt_password,cred.get(1));
        uiActions.clickElement(loginsaucedemo.btn_login);
    }

    @Step("add or remove item to/from cart")
    public static void addOrRemoveItemFromCart(WebElement item)
    {
        uiActions.clickElement(item);
    }

    @Step("move to cart page")
    public static void moveToCartPage()
    {
        uiActions.clickElement(mainPagesaucedemo.img_cart);
    }

    @Step("add the first item to the cart and remove it from cart page")
    public static void AddAndRemoveFirstItemFromCart()
    {
        addOrRemoveItemFromCart(mainPagesaucedemo.btn_addToCart.get(0));
        moveToCartPage();
        addOrRemoveItemFromCart(cartPagesaucedemo.btn_remove.get(0));
    }

    @Step("logout the site")
    public static void Logout()
    {
        uiActions.clickElement(mainPagesaucedemo.btn_buregerMenu);
        uiActions.clickElement(mainPagesaucedemo.btn_logout);
    }

}
