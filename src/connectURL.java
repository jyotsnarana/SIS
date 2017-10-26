import java.sql.*;  

public interface connectURL {  

  /* public static void main(String[] args) {  

      // Create a variable for the connection string.  
      String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
         "databaseName=sis_db;user=sa;password=jyotsna";  */

      // Declare the JDBC objects.  
      Connection con = null;  
      Statement stmt = null;  
      ResultSet rs = null;  

      
      default void connection() {
      try {  
         // Establish the connection.  
    	 
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
         String connectionUrl = null;
		Connection con = DriverManager.getConnection(connectionUrl);  
      }
         // Create and execute an SQL statement that returns some data.  
     /*    String SQL = "SELECT * FROM student";  
         stmt = con.createStatement();  
         rs = stmt.executeQuery(SQL);  */

         // Iterate through the data in the result set and display it.  
        /* while (rs.next()) {  
            System.out.println(rs.getString(1) + " " + rs.getString(2));  
         }  
      }  */

      // Handle any errors that may have occurred.  
      catch (Exception e) {  
         e.printStackTrace();  
      }  
      finally {  
         if (rs != null) try { rs.close(); } catch(Exception e) {}  
         if (stmt != null) try { stmt.close(); } catch(Exception e) {}  
         if (con != null) try { con.close(); } catch(Exception e) {}  
      }  
      }
}  