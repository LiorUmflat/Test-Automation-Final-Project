package Extensions;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class APIActions extends CommonOps
{
    @Step("GET the DATA from the Server")
    public static Response GetDataFromServer(String paramsValues)
    {
        response = httpRequest.get(paramsValues);
        return response;
    }

    @Step("Extract value according to path from JSON format")
    public static String ExtractFromJson(Response response,String path)
    {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }

    @Step("POST data to server")
    public static void POST(JSONObject params, String resource)
    {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
        System.out.println(response.prettyPrint());
    }

    @Step("update data in server")
    public static void PUT(JSONObject params, String resource)
    {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
        System.out.println(response.prettyPrint());
    }

    @Step("Delete data from server")
    public static void DELETE(String id)
    {
        response = httpRequest.delete("/"+id);
    }
}
