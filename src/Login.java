import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;  
public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT INFORMATION SYSTEM");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(138, 75, 62, 14);
		frame.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(210, 72, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(138, 100, 52, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(210, 97, 86, 20);
		frame.getContentPane().add(passwordField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(210, 129, 86, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("---Select---");
		comboBox.addItem("Admin");
		comboBox.addItem("Student");
		comboBox.addItem("Professor");
		
		JButton btnLogin = new JButton("Login In");
		btnLogin.setBounds(138, 168, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {   
				Change_password change= new Change_password();
				change.changePassword();
				
			}
		});
		btnChangePassword.setBounds(251, 168, 131, 23);
		frame.getContentPane().add(btnChangePassword);
		btnLogin.addActionListener(new ActionListener() {
			  
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;  
				PreparedStatement stmt = null;  
			      ResultSet rs = null;  
				try {
				 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
				         "databaseName=sis_db;user=sa;password=jyotsna";  
				 con = DriverManager.getConnection(connectionUrl);  
				
				 // Create and execute an SQL statement that returns some data.
				 String SQL = "SELECT * FROM login_1 where username=? and password=?";  
		        //stmt = con.createStatement();  
		        stmt=con.prepareStatement(SQL);
		        stmt.setString(1,textField.getText());
		        stmt.setString(2,passwordField_1.getText());
		        rs = stmt.executeQuery();
		        if(rs.next())
		        {
		        	//JOptionPane.showMessageDialog(null, "Username and password successfull");
		        	
		        	   if( (comboBox.getSelectedItem()== "Admin") && (textField.getText().equals("admin"))  )
					   {
						 Admin ad= new Admin();
						 ad.newScreen();
					    }	
		        	   else if((comboBox.getSelectedItem()== "Student") && (textField.getText().equals("student")))
						{
							Student student= new Student();
							student.newScreen1();
						}
		        	   else if((comboBox.getSelectedItem()== "Professor") && (textField.getText().equals("professor")))
						{
							Professor prof=new Professor();
							prof.newScreen2();
							//prof.initialize().lblNewLabel="prof";
						}
		        	   else
		        		   JOptionPane.showMessageDialog(null, "Wrong username");   
		             }
		        else
		        {
		        	 JOptionPane.showMessageDialog(null, "Username and password Not Correct");
		        }
				}
				 catch (Exception e) {  
					 JOptionPane.showMessageDialog(null,e);
			      }  
			}
			});
	}
}
