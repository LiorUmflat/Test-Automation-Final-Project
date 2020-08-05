package SanityTestCases;

import Extensions.uiActions;
import Extensions.verifications;
import Utilities.CommonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Utilities.listeners.class)
public class saucedemoWeb extends CommonOps
{
    @Test(description = "login to the site")
    @Description("login to the site and verify the main page is display")
    public void test01_login()
    {
        webFlows.login("standard_user","secret_sauce");
        verifications.verifyElementText(mainPagesaucedemo.label_headline,"Products");
    }

    @Test(description = "sort products from low to high")
    @Description("sort the products from low to high and verify they are sorted correctly")
    public void test02_sortProductsByLowToHigh()
    {
        uiActions.updateDropDownBox(mainPagesaucedemo.dropdown_productSort,"Price (low to high)");
        verifications.VerifyItemsSortedFromLowToHigh(mainPagesaucedemo.label_itemsPrice);
    }

    @Test(description = "add item to cart")
    @Description("add the first item to cart and verify it been added")
    public void test03_addItemToChart()
    {
        webFlows.addOrRemoveItemFromCart(mainPagesaucedemo.btn_addToCart.get(0));
        verifications.verifyElementText(mainPagesaucedemo.img_cartBadge,"1");
        webFlows.moveToCartPage();
        verifications.verifySizeOfWebElementList(cartPagesaucedemo.items,"1");
        //remove the item before the test ends
        webFlows.addOrRemoveItemFromCart(cartPagesaucedemo.btn_remove.get(0));
    }

    @Test(description = "add item and remove it from cart page")
    @Description("add the first item to cart and remove it from cart page")
    public void test04_addItemAndRemoveItFromCartPage()
    {
        webFlows.AddAndRemoveFirstItemFromCart();
        //verify the cart is empty
        verifications.verifySizeOfWebElementList(cartPagesaucedemo.items,"0");
    }

    @Test(description = "logout of the site")
    @Description("logout of the site and verify login page display")
    public void test05_logout()
    {
        webFlows.Logout();
        verifications.verifyElementIsDisplayed(loginsaucedemo.txt_userName);
    }

    @Test(description = "verify robot image")
    @Description("verify login page robot image")
    public void test06_verifyRobotImage()
    {
        webFlows.Logout();
        verifications.visualElement(loginsaucedemo.img_robot,"robotImage_ver01");
    }


}
