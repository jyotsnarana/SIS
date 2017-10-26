import java.io.*;
import java.sql.*;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*class  connectionTest
{
    public static void main(String[] args) 
    {
         Calendar cal = new GregorianCalendar();

         //String name="cmscim";
                 Connection conn = null;

         String url = "jdbc:sqlserver://localhost\\MSSQLSERVER01:1433;databasename=sis_db";
         String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
         String userName = "sa"; 
         String password ="jyotsna";
         Statement stmt;
         try
         {

         Class.forName(driver);//.newInstance();
         conn = DriverManager.getConnection(url,userName,password);
         String query = "select * from Log";
         stmt = conn.createStatement();
         int flag = stmt.executeUpdate(query);
         System.out.println("flag = "+flag); 
         conn.close();
        System.out.println("");
         } catch (Exception e) {
         e.printStackTrace();
         }

    }
} */