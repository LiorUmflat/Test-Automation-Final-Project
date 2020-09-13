package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        //web:
        loginsaucedemo = PageFactory.initElements(driver,PageObjects.saucedemo.loginPage.class);
        mainPagesaucedemo = PageFactory.initElements(driver,PageObjects.saucedemo.mainPage.class);
        cartPagesaucedemo = PageFactory.initElements(driver,PageObjects.saucedemo.cartPage.class);

        //mobile:
        initialPageSpotify = PageFactory.initElements(androidMobileDriver,PageObjects.Spotify.initialPage.class);
        chooseAccountPopupSpotify = PageFactory.initElements(androidMobileDriver,PageObjects.Spotify.googleSmartLockChooseAccountPopup.class);
        loginPageSpotify = PageFactory.initElements(androidMobileDriver,PageObjects.Spotify.loginPage.class);
        mainPageSpotify = PageFactory.initElements(androidMobileDriver,PageObjects.Spotify.mainPage.class);
        settingsPageSpotify = PageFactory.initElements(androidMobileDriver,PageObjects.Spotify.settingsPage.class);
        searchPageSpotify = PageFactory.initElements(androidMobileDriver,PageObjects.Spotify.searchPage.class);
        searchByTextPageSpotify = PageFactory.initElements(androidMobileDriver,PageObjects.Spotify.searchByTextPage.class);
        playerSpotify = PageFactory.initElements(androidMobileDriver,PageObjects.Spotify.Player.class);
        navBarSpotify = PageFactory.initElements(androidMobileDriver,PageObjects.Spotify.navBar.class);
        yourLibraryPageSpotify = PageFactory.initElements(androidMobileDriver,PageObjects.Spotify.yourLibraryPage.class);
        songsYouLikePageSpotify = PageFactory.initElements(androidMobileDriver,PageObjects.Spotify.songsYouLikePage.class);

        //electron
        mainPageToDoList = PageFactory.initElements(driver,PageObjects.Todolist.mainPage.class);

        //desktop
        mainPageSticky = PageFactory.initElements(driver,PageObjects.StickyNotes.mainPage.class);
        settingsPageSticky = PageFactory.initElements(driver,PageObjects.StickyNotes.settingsPage.class);
        SignInPageSticky = PageFactory.initElements(driver,PageObjects.StickyNotes.SignInPage.class);
        signOutPopUpSticky = PageFactory.initElements(driver,PageObjects.StickyNotes.signOutPopUp.class);
        notePopUpSticky = PageFactory.initElements(driver,PageObjects.StickyNotes.notePopUp.class);
    }
}
