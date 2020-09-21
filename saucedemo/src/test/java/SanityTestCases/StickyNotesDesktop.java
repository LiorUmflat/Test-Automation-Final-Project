package SanityTestCases;

import Extensions.uiActions;
import Extensions.verifications;
import Utilities.CommonOps;
import WorkFlows.desktopFlows;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

@Listeners(Utilities.listeners.class)
public class StickyNotesDesktop extends CommonOps
{
    @Test(description = "Test 01: login to Sticky Notes")
    @Description("Test Description: login to Sticky Notes and verify user is logged in")
    public void test01_login() throws InterruptedException
    {
        desktopFlows.login();
        Thread.sleep(2000);
        uiActions.clickElement(mainPageSticky.btn_settings);
        verifications.verifyElementText(settingsPageSticky.btn_signout,"צא");
    }

    @Test(description = "Test 02: add new note")
    @Description("Test Description: add new note and verify it had been added")
    public void test02_addNewNote() throws MalformedURLException
    {
        desktopFlows.addNewNote("ליאור");
    }

    @Test(description = "Test 03: logout of Sticky Notes")
    @Description("Test Description: logout of Sticky Notes and verify user is logged out")
    public void test03_logout() throws InterruptedException
    {
        desktopFlows.logout();
        Thread.sleep(2000);
        verifications.verifyElementText(settingsPageSticky.btn_signIn,"היכנס");
    }


}
