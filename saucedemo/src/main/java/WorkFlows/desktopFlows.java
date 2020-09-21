package WorkFlows;

import Extensions.uiActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import java.net.MalformedURLException;

public class desktopFlows extends CommonOps
{
    @Step("login to Sticky Notes")
    public static void login()
    {
        uiActions.clickElement(mainPageSticky.btn_settings);
        uiActions.clickElement(settingsPageSticky.btn_signIn);
        uiActions.clickElement(SignInPageSticky.btn_Account);
        uiActions.clickElement(SignInPageSticky.btn_SignIn);
    }

    @Step("logout of Sticky Notes")
    public static void logout()
    {
        uiActions.clickElement(mainPageSticky.btn_settings);
        uiActions.clickElement(settingsPageSticky.btn_signout);
        uiActions.clickElement(signOutPopUpSticky.btn_signout);
    }

    @Step("return to main page")
    public static void returnToMainPage()
    {
        //if settings page display return to the main window
        if(settingsPageSticky.btn_help.isDisplayed())
        {
            uiActions.clickElement(settingsPageSticky.btn_backToMain);
        }
    }

    @Step("add new note")
    public static void addNewNote(String note) throws MalformedURLException
    {
        System.out.println("before clicking + button:" + driver.getWindowHandle());
        uiActions.clickElement(mainPageSticky.btn_AddNote);
        System.out.println("after clicking + button:" + driver.getWindowHandle());
        driver.switchTo().window(driver.getWindowHandles().iterator().next());
        System.out.println("after switching to the next window:" + driver.getWindowHandle());
        uiActions.sendKeysToElement(notePopUpSticky.txtbox_note,note);
    }
}
