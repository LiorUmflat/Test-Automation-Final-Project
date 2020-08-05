package SanityTestCases;

import Extensions.verifications;
import Utilities.CommonOps;
import WorkFlows.mobileFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.security.cert.Extension;

@Listeners(Utilities.listeners.class)
public class SpotifyMobile extends CommonOps
{
    public String songToPlay="";

    @Test(description = "login to Spotify")
    @Description("Test Description: login to Spotify and verify main page is displayed (by verifying settings button is displayed)")
    public void test01_login()
    {
        mobileFlows.login("lior.hammer@gmail.com","300686979");
        verifications.verifyElementIsDisplayed(mainPageSpotify.btn_settings);
    }

    @Test(description = "search song and play it")
    @Description("Test Description: search song, play it and verify the player contain the song with option to pause")
    public void test02_searchSongAndPlayIt()
    {
        songToPlay = "hit the road jack";
        mobileFlows.searchSongAndPlayIt(songToPlay);
        verifications.verifyElementIsDisplayed(playerSpotify.player);
        verifications.verifyElementContainText(playerSpotify.title_playingSong,songToPlay);
        verifications.verifyElementAttributeText(playerSpotify.btn_playPause,"contentDescription","השהיה");
        Extensions.uiActions.clickElement(playerSpotify.btn_playPause);
    }

    @Test(description = "pause playing song")
    @Description("Test Description: pause the playing song and verify player pause icon is changing to play icon")
    public void test03_pausePlayingSong()
    {
        songToPlay = "iris";
        mobileFlows.searchSongAndPlayIt(songToPlay);
        Extensions.uiActions.clickElement(playerSpotify.btn_playPause);
        verifications.verifyElementAttributeText(playerSpotify.btn_playPause,"contentDescription","נגן");
    }

    @Test(description = "add song to favorites from player section")
    @Description("Test Description: add song to favorites from player section and verified it had been added")
    public void test04_addSongToFavoritesFromPlayer()
    {
        songToPlay = "don't let me down";
        mobileFlows.searchSongAndPlayIt(songToPlay);
        Extensions.uiActions.clickElement(playerSpotify.btn_addToFavorties);
        verifications.verifyElementAttributeText(playerSpotify.btn_addToFavorties,"contentDescription","סימון 'לא אהבתי'");
        mobileFlows.enterSongsYouLiked();
        Extensions.uiActions.clickElement(playerSpotify.btn_playPause);
        verifications.verifyWebElementListContainsOrNotContainsText(songsYouLikePageSpotify.list_songs,songToPlay,true);
        Extensions.uiActions.clickElement(playerSpotify.btn_addToFavorties);
    }

    @Test(description = "remove songs from favorites in player section")
    @Description("Test Description: remove songs from favorites in player section and verify it was removed")
    public void test05_removeSongsFromFavorites()
    {
        songToPlay = "we will rock you";
        mobileFlows.searchSongAndPlayIt(songToPlay);
        Extensions.uiActions.clickElement(playerSpotify.btn_addToFavorties);
        Extensions.uiActions.clickElement(playerSpotify.btn_addToFavorties);
        mobileFlows.enterSongsYouLiked();
        Extensions.uiActions.clickElement(playerSpotify.btn_playPause);
        verifications.verifyWebElementListContainsOrNotContainsText(songsYouLikePageSpotify.list_songs,songToPlay,false);

    }

    @Test(description = "logout from the app")
    @Description("Test Description: logout from the app and verify the initial page is display")
    public void test06_logout()
    {
        mobileFlows.logout();
        verifications.verifyElementIsDisplayed(initialPageSpotify.btn_entrance);
    }
}
