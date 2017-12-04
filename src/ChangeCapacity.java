import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ChangeCapacity extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeCapacity window = new ChangeCapacity();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChangeCapacity() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Change Capacity");
		frame.getContentPane().setLayout(null);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(110, 84, 46, 14);
		frame.getContentPane().add(lblCourse);
		
		JLabel lblNewCapacity = new JLabel("New Capacity");
		lblNewCapacity.setBounds(97, 133, 86, 14);
		frame.getContentPane().add(lblNewCapacity);
		
		textField = new JTextField();
		textField.setBounds(193, 130, 102, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;  
				Statement stmt = null;  
				     // ResultSet rs = null;  
					try 
					{
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
					 		String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
					         "databaseName=sis_db;user=sa;password=jyotsna";  
					 		con = DriverManager.getConnection(connectionUrl);  
					
					 		// Create and execute an SQL statement that returns some data.
					 		String SQL = "update capacity set Capacity= "+ textField.getText() +" where Course = '"+textField_1.getText().toUpperCase()+"' ";
					 		stmt = con.createStatement(); 
					 	
			        		stmt.executeUpdate(SQL);
			        		JOptionPane.showMessageDialog(null, "Database updated");
			       }
					catch (Exception e1)
					{  
						 JOptionPane.showMessageDialog(null,e1);
				      }  
				}
		
		});
		btnUpdate.setBounds(148, 182, 115, 23);
		frame.getContentPane().add(btnUpdate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(193, 81, 115, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
