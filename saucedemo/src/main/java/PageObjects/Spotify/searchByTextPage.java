package PageObjects.Spotify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class searchByTextPage
{
    @FindBy(how = How.ID, using = "query")
    public static WebElement txt_searchTextBox;

    @FindBy(how = How.ID,using = "row_view")
    public static List<WebElement> list_songs;

}
