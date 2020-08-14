package PageObjects.Todolist;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class mainPage
{
    @FindBy (how = How.CLASS_NAME,using = "input_b5pqF")
    public static WebElement txt_inputTB;

    @FindBy (how = How.CLASS_NAME,using = "view_2Ow90")
    public static List<WebElement> list_tasks;

    @FindBy (how = How.CLASS_NAME,using = "destroy_19w1q")
    public static List<WebElement> btn_x;

    @FindBy (how = How.CLASS_NAME,using = "toggleIconsWrapper_2kpi8")
    public static List<WebElement> list_markAsCompletedIcons;

    @FindBy (how = How.CLASS_NAME,using = "label_5i8SP")
    public static List<WebElement> txt_tasksNames;

    @FindBy (how = How.CLASS_NAME,using = "allCompletedIconWrapper_2rCqr")
    public static WebElement btn_markAllTaskAsCompleted;

    @FindBy (how = How.CLASS_NAME,using = "completed_bHv-Q")
    public static List<WebElement> list_completedTasks;

}
