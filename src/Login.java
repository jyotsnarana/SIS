
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	 * Login page for login to the system
	 * @author jyotsna
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
	 * using sql server connection to connect to the server where data stored for authentication.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
//		currentUser cu = null;

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT INFORMATION SYSTEM");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 434, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(109, 75, 75, 14);
		frame.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(194, 72, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(109, 100, 75, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(194, 97, 86, 20);
		frame.getContentPane().add(passwordField_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(169, 125, 86, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("---Select---");
		comboBox.addItem("Admin");
		comboBox.addItem("Student");
		comboBox.addItem("Professor");
		
		JButton btnLogin = new JButton("Login In");
		btnLogin.setBounds(95, 156, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {   
				Change_password change= new Change_password();
				change.changePassword();
				frame.dispose();
				
			}
		});
		btnChangePassword.setBounds(226, 156, 131, 23);
		frame.getContentPane().add(btnChangePassword);
		btnLogin.addActionListener(new ActionListener() {
			  
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;  
				PreparedStatement stmt = null;  
			      ResultSet rs = null;  
				try {
					con = new SQLConnection().getConnection();

				 // Create and execute an SQL statement that returns some data.
				 String SQL = "SELECT * FROM students where StrudentName=? and Password=?";

		        stmt=con.prepareStatement(SQL);
		        stmt.setString(1,textField.getText());
		        stmt.setString(2,passwordField_1.getText());
		        rs = stmt.executeQuery();
		        if(rs.next())
		        {
		        	//JOptionPane.showMessageDialog(null, "Username and password successfull");

		        	   if( (comboBox.getSelectedItem()== "Admin") && (textField.getText().equals("admin"))  )
					   {
						 Admin.newScreen();
					   }
		        	   else if(comboBox.getSelectedItem()== "Student")
						{
							currentUser cu = new currentUser("student", rs.getString("StrudentName"), rs.getInt("StudentId"));
							Student.newScreen1();
						}
		        	   else if((comboBox.getSelectedItem()== "Professor") && (textField.getText().equals("professor")))
						{
							Professor.newScreen2();
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
