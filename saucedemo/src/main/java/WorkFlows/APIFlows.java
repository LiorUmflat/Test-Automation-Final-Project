package WorkFlows;

import Extensions.APIActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

import java.util.List;

public class APIFlows extends CommonOps
{
    @Step("get the Students from the server")
    public static void GetTheStudents()
    {
        response = APIActions.GetDataFromServer("/list");
        //System.out.println(response.prettyPrint());
    }

    @Step("get student by it's index")
    public static String GetStudent(String studentIndex)
    {
        GetTheStudents();
        return APIActions.ExtractFromJson(response,"["+studentIndex+"]");
    }
    @Step("get the students ID's")
    public static void GetStudentsIDs()
    {
        GetTheStudents();
        StudentsIDs = APIActions.ExtractFromJson(response,"id").split(",");
    }

    @Step("add new student to server")
    public static void AddNewStudent(String FirstName, String LastName, String email,String programme, List<String> courses)
    {
        requestParams.put("firstName",FirstName);
        requestParams.put("lastName",LastName);
        requestParams.put("email",email);
        requestParams.put("programme",programme);
        requestParams.put("courses",courses);
        APIActions.POST(requestParams,"");
    }

    @Step("update student data in server")
    public static void updateStudent(String FirstName, String LastName, String email,String programme, List<String> courses,String id)
    {
        requestParams.put("firstName",FirstName);
        requestParams.put("lastName",LastName);
        requestParams.put("email",email);
        requestParams.put("programme",programme);
        requestParams.put("courses",courses);
        APIActions.PUT(requestParams,"/"+id);
    }

    @Step("delete student from the server")
    public static void deleteStudent(String id)
    {
        APIActions.DELETE(id);
        System.out.println("student was deleted");
    }
}
