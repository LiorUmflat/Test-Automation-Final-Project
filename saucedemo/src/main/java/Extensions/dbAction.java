package Extensions;

import Utilities.CommonOps;
import io.qameta.allure.Step;

import javax.smartcardio.CommandAPDU;
import java.util.ArrayList;
import java.util.List;

public class dbAction extends CommonOps
{
    @Step("get credentials from DB")
    public static List<String> getCredentials(String query)
    {
        List<String> credentials = new ArrayList<String>();
        try
        {
            rs = stms.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        }
        catch (Exception e)
        {
            System.out.println("error occurred while printing table data . see details: "+ e);
        }
        return credentials;
    }
}
