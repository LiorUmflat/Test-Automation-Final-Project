package SanityTestCases;

import Extensions.APIActions;
import Extensions.verifications;
import Utilities.CommonOps;
import WorkFlows.APIFlows;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Listeners(Utilities.listeners.class)
public class StudentsAPI extends CommonOps
{
    @Test(description = "Get The Students from the server")
    @Description("Test Description: get the Students from the server and verify 100 Students Exists")
    public void test_01_GetStudents()
    {
        APIFlows.GetStudentsIDs();
        verifications.verifyInt(StudentsIDs.length,100);
    }

    @Test(description = "Add new student to the server")
    @Description("Test Description: add new student to server and verify 101 students Exists")
    public void test_02_AddStudent()
    {
        List<String> courses = Arrays.asList("Java","Selenium","appium");
        APIFlows.AddNewStudent("Lior","Umflat","lior.hammer@gmail.com","Automation",courses);
        APIFlows.GetStudentsIDs();
        verifications.verifyInt(StudentsIDs.length,101);
        lastID = StudentsIDs[StudentsIDs.length-1];
        lastID = lastID.substring(0,lastID.length()-1);
    }

    @Test(description = "update the last added student in the server")
    @Description("Test Description: update the last added student in the server and verify the data was updated")
    public void test_03_updateStudent()
    {
        String studentDataBeforeUpdate = APIFlows.GetStudent("100");
        List<String> courses = Arrays.asList("Java","Rest API","C++");
        APIFlows.updateStudent("Lior", "Hammer","lior.hammer@gmail.com","Automation",courses,lastID);
        String studentDataAfterUpdate = APIFlows.GetStudent("100");
        verifications.verifyTextIsNotEqual(studentDataBeforeUpdate,studentDataAfterUpdate);
    }

    @Test(description = "delete the last added student from the server")
    @Description("Test Description: delete the last added student from the server and verify 100 students exists")
    public void test_04_deleteStudent()
    {
        APIFlows.deleteStudent(lastID);
        APIFlows.GetStudentsIDs();
        verifications.verifyInt(StudentsIDs.length,100);
    }

}
