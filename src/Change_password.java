import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Change_password extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField_;


	/**
	 * Launch the application.
	 */
	public static void changePassword() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_password frame = new Change_password();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Change_password() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Change Password");
		
		JLabel Username = new JLabel("Username:");
		Username.setSize(68, 14);
		Username.setHorizontalAlignment(SwingConstants.LEFT);
		Username.setLocation(29, 37);
		contentPane.add(Username);
		
		textField = new JTextField();
		textField.setBounds(141, 34, 111, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("New Password:");
		lblPassword.setBounds(29, 95, 89, 14);
		contentPane.add(lblPassword);
		
		passwordField_ = new JPasswordField();
		passwordField_.setBounds(141, 92, 111, 20);
		contentPane.add(passwordField_);
		
		JButton btnChange = new JButton("Change");
		btnChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
				 		String SQL = "update login_1 set password= "+Integer.valueOf(passwordField_.getText()).intValue()+" where username = '"+textField.getText()+"' ";
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
		btnChange.setBounds(70, 160, 89, 23);
		contentPane.add(btnChange);
	}
}
