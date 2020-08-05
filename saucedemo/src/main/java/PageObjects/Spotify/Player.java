package PageObjects.Spotify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Player
{
    @FindBy (how = How.ID,using = "now_playing_bar_layout")
    public static WebElement player;

    @FindBy(how = How.ID, using = "track_title")
    public static WebElement title_playingSong;

    @FindBy(how = How.ID, using = "play_pause_button")
    public static WebElement btn_playPause;

    @FindBy(how = How.ID, using = "heart_button")
    public static WebElement btn_addToFavorties;
}
