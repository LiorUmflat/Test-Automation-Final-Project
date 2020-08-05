package WorkFlows;

import Extensions.uiActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class electronFlows extends CommonOps
{
    @Step("add new task to the list of tasks")
    public static void AddNewTask(String taskName)
    {
        Extensions.uiActions.clickElement(mainPageToDoList.txt_inputTB);
        Extensions.uiActions.sendKeysToElement(mainPageToDoList.txt_inputTB,taskName);
        Extensions.uiActions.sendKeyToElement(mainPageToDoList.txt_inputTB, Keys.ENTER);
    }

    @Step("count the number of tasks")
    public static int countNumOfTasks()
    {
        return mainPageToDoList.list_tasks.size();
    }

    @Step("empty list of tasks")
    public static void EmptyListOfTasks()
    {
        int numofTasks = countNumOfTasks();
        for (int i=0;i<numofTasks;i++)
        {
            action.moveToElement(mainPageToDoList.btn_x.get(0)).click().build().perform();
        }
    }

    @Step("mark task as completed")
    public static void markTaskAsCompleted(String taskName)
    {
        int counter=0;
        for(WebElement name:mainPageToDoList.txt_tasksNames)
        {
            if(name.getText().equals(taskName))
            {
                uiActions.clickElement(mainPageToDoList.list_markAsCompletedIcons.get(counter));
            }
            counter++;
        }
    }

    @Step("mark all task as completed")
    public static void markAllTaskAsCompleted()
    {
        uiActions.clickElement(mainPageToDoList.btn_markAllTaskAsCompleted);
    }

    @Step("count tasks marked as completed")
    public static int tasksMarkedAsCompleted(List<WebElement> tasks)
    {
        int counter=0;
        for(WebElement task:tasks)
        {
            if(task.findElements(By.tagName("path")).size()!=0)
            {
                counter++;
            }
        }
        return counter;
    }

    @Step("delete task from the list of tasks")
    public static void deleteTask(String taskName)
    {
        int numofTasks = countNumOfTasks();
        for (int i=0;i<numofTasks;i++)
        {
            if(mainPageToDoList.txt_tasksNames.get(i).getText().equals(taskName))
            {
                action.moveToElement(mainPageToDoList.btn_x.get(i)).click().build().perform();
                break;
            }
        }
    }

}
