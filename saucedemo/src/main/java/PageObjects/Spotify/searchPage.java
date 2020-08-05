package PageObjects.Spotify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class searchPage
{
    @FindBy(how = How.ID, using = "find_search_field")
    public static WebElement btn_searchBox;
}
