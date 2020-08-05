package PageObjects.Spotify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class songsYouLikePage
{
    @FindBy(how = How.ID,using = "text1")
    public static List<WebElement> list_songs;
}
