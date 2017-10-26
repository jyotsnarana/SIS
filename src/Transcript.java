import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.sql.*;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JPanel; 
public class Transcript implements connectURL {

	private JFrame frame;

	/**
	 * Launch the application.
	
	 */
	public static void transcript()  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transcript window = new Transcript();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Transcript() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(74, 56, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(74, 127, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		 Connection con = null;  
	      Statement stmt = null;  
	      ResultSet rs = null;  
		try {
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
		 String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
		         "databaseName=sis_db;user=sa;password=jyotsna";  
		 con = DriverManager.getConnection(connectionUrl);  
		
		 // Create and execute an SQL statement that returns some data.
		 String SQL = "SELECT * FROM student";  
        stmt = con.createStatement();  
        rs = stmt.executeQuery(SQL);
		}
		 catch (Exception e) {  
	         e.printStackTrace();  
	      }
		 while(rs.next())
		 {
			lblNewLabel.setText(rs.getString(1));
			lblNewLabel_1.setText(rs.getString(2));
		 }
		 
		
	}
}
