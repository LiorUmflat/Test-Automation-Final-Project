package WorkFlows;

import Extensions.dbAction;
import Utilities.CommonOps;
import io.qameta.allure.Step;
//remove the following from notes when testing mobile app
//import net.sourceforge.htmlunit.corejs.javascript.tools.shell.QuitAction;
//import org.boon.Str;

import java.security.cert.Extension;
import java.util.List;

public class mobileFlows extends CommonOps
{
    @Step("login to spotify with credentials from DB")
    public static void loginDB()
    {
        List<String> cred = dbAction.getCredentials("SELECT UserName, Password FROM credentials WHERE id='3'");
        Extensions.uiActions.clickElement(initialPageSpotify.btn_entrance);
        Extensions.uiActions.clickElement(chooseAccountPopupSpotify.btn_noOfTheAboveOptions);
        Extensions.uiActions.sendKeysToElement(loginPageSpotify.txt_username,cred.get(0));
        Extensions.uiActions.sendKeysToElement(loginPageSpotify.txt_password,cred.get(1));
        Extensions.uiActions.clickElement(loginPageSpotify.btn_login);
    }

    @Step("search song and play it")
    public static void searchSongAndPlayIt(String song)
    {
        Extensions.uiActions.clickElement(navBarSpotify.btn_search);
        Extensions.uiActions.clickElement(searchPageSpotify.btn_searchBox);
        Extensions.uiActions.sendKeysToElement(searchByTextPageSpotify.txt_searchTextBox,song);
        Extensions.uiActions.clickElement(searchByTextPageSpotify.list_songs.get(0));
    }

    @Step("enter 'your libray'->'songs you liked'")
    public static void enterSongsYouLiked()
    {
        Extensions.uiActions.clickElement(navBarSpotify.btn_yourLibrary);
        Extensions.uiActions.clickElement(yourLibraryPageSpotify.btn_songsYouLike);
    }

    @Step("logout")
    public static void logout()
    {
        Extensions.uiActions.clickElement(navBarSpotify.btn_mainPage);
        Extensions.uiActions.clickElement(mainPageSpotify.btn_settings);
        Extensions.uiActions.swipeTillElementIsFoundAndClickIt("Down","500","500",settingsPageSpotify.btn_logoutLocator,"0","500","7");
    }
}
