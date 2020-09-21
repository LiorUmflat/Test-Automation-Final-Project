package Utilities;

import java.sql.DriverManager;

public class managaeDB extends CommonOps
{
    public static void initConnection(String DBUrl, String user, String password)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DBUrl,user,password);
            stms = con.createStatement();

        } catch (Exception e)
        {
            System.out.println("error occurred while connecting to DB. see details: "+e);
        }
    }

    public static void closeConnection()
    {
        try
        {con.close();}
        catch (Exception e)
        {
            System.out.println("error occurred while closing the DB. see details: "+e);
        }
    }
}
