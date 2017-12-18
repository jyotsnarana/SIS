import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {
    private static String urlstring = "jdbc:sqlserver://0.0.0.0:1433; databaseName=sis2_db;user=sa;password=reallyStrongPwd123";
//    private static String urlstring = "jdbc:sqlserver://localhost:1433; databaseName=sis_db;user=sa;password=jyotsna;"
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try {
                con = DriverManager.getConnection(urlstring);
            } catch (Exception ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return con;
    }
}