package SanityTestCases;

import Extensions.uiActions;
import Extensions.verifications;
import Utilities.CommonOps;
import WorkFlows.electronFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class TodolistElectron extends CommonOps
{
    @Test(description = "Test 01: add new task")
    @Description("Test Description: add new task and verify it was added to the list of tasks")
    public void test01_AddNewTask()
    {
        electronFlows.AddNewTask("lior");
        Extensions.verifications.verifyInt(electronFlows.countNumOfTasks(),1);
    }

    @Test(description = "Test 02: add 2 new tasks")
    @Description("Test Description: add 2 new tasks and verify they were added to the list of tasks")
    public void test02_AddNewTask()
    {
        electronFlows.AddNewTask("Lior");
        electronFlows.AddNewTask("Tamar");
        Extensions.verifications.verifyInt(electronFlows.countNumOfTasks(),2);
    }

    @Test(description = "Test 03: mark task as completed")
    @Description("Test Description: mark task as completed and verify it has V sign")
    public void test03_markTaskAsCompleted()
    {
        electronFlows.AddNewTask("Lior");
        electronFlows.AddNewTask("Tamar");
        electronFlows.AddNewTask("Yaki");
        electronFlows.markTaskAsCompleted("Tamar");

        verifications.VerifyWebElementInListContainTag(mainPageToDoList.list_markAsCompletedIcons,"path",mainPageToDoList.txt_tasksNames, "Tamar");
    }

    @Test(description = "Test 04: mark all task as completed")
    @Description("Test Description: mark all task as completed and verify they has V sign")
    public void test04_markAllTaskAsCompleted()
    {
        electronFlows.AddNewTask("Lior");
        electronFlows.AddNewTask("Tamar");
        electronFlows.AddNewTask("Yaki");
        electronFlows.markAllTaskAsCompleted();

        verifications.verifyInt(electronFlows.tasksMarkedAsCompleted(mainPageToDoList.list_markAsCompletedIcons),3);
    }

    @Test(description = "Test 05: delete one task from the list")
    @Description("Test Description: delete one task from the list and verify it was deleted")
    public void test05_deleteTaskFromTheList() throws InterruptedException
    {
        electronFlows.AddNewTask("Lior");
        electronFlows.AddNewTask("Tamar");
        electronFlows.AddNewTask("Yaki");

        electronFlows.deleteTask("Tamar");

        verifications.verifySizeOfWebElementList(mainPageToDoList.list_tasks,"2");
        verifications.verifyWebElementListContainsOrNotContainsText(mainPageToDoList.txt_tasksNames,"Tamar",false);
        softAssertion.assertAll();
    }

}
