package Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class base
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Screenshot ImageScreenShot;
    public static ImageDiff diff;
    public static ImageDiffer imageDiff = new ImageDiffer();
    public static SoftAssert softAssertion = new SoftAssert();

    public static AndroidDriver<AndroidElement> androidMobileDriver;
    DesiredCapabilities dc = new DesiredCapabilities();

    //web
    public static PageObjects.saucedemo.loginPage loginsaucedemo;
    public static PageObjects.saucedemo.mainPage mainPagesaucedemo;
    public static PageObjects.saucedemo.cartPage cartPagesaucedemo;

    //mobile
    public static PageObjects.Spotify.initialPage initialPageSpotify;
    public static PageObjects.Spotify.googleSmartLockChooseAccountPopup chooseAccountPopupSpotify;
    public static PageObjects.Spotify.loginPage loginPageSpotify;
    public static PageObjects.Spotify.mainPage mainPageSpotify;
    public static PageObjects.Spotify.settingsPage settingsPageSpotify;
    public static PageObjects.Spotify.searchPage searchPageSpotify;
    public static PageObjects.Spotify.searchByTextPage searchByTextPageSpotify;
    public static PageObjects.Spotify.Player playerSpotify;
    public static PageObjects.Spotify.navBar navBarSpotify;
    public static PageObjects.Spotify.yourLibraryPage yourLibraryPageSpotify;
    public static PageObjects.Spotify.songsYouLikePage songsYouLikePageSpotify;

    //api
    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParams = new JSONObject();
    public static JsonPath jp;
    public static String lastID;
    public static String [] StudentsIDs;

    //electron
    public static PageObjects.Todolist.mainPage mainPageToDoList;
    public static Actions action;

    //desktop
    public static PageObjects.Netflix.initialPage initialPageNetflix;
    public static PageObjects.Netflix.loginPage loginPageNetflix;
    public static PageObjects.Netflix.usersPage usersPageNetflix;
    public static PageObjects.Netflix.mainPageInitPopup mainPageInitPopupNetflix;
    public static PageObjects.Netflix.mainPage mainPageNetflix;
}
