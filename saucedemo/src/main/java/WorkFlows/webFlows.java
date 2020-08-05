package WorkFlows;

import Extensions.uiActions;
import PageObjects.saucedemo.loginPage;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class webFlows extends CommonOps
{
    @Step("login to the site")
    public static void login(String username, String password)
    {
        uiActions.sendKeysToElement(loginsaucedemo.txt_userName,username);
        uiActions.sendKeysToElement(loginsaucedemo.txt_password,password);
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
