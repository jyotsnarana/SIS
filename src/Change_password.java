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
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Change_password extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField_;
	private JFrame frame;

	/**
	 * Change password frame used to change the password for users
	 * Updates the database table "login"
	 * @author jyotsna
	 */
	public static void changePassword() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_password window = new Change_password();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * connection string to update the database.
	 */
	public Change_password() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Change Password");
		
		JLabel Username = new JLabel("Username:");
		Username.setSize(68, 14);
		Username.setHorizontalAlignment(SwingConstants.LEFT);
		Username.setLocation(91, 37);
		frame.getContentPane().add(Username);
		
		textField = new JTextField();
		textField.setBounds(206, 34, 111, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("New Password:");
		lblPassword.setBounds(88, 95, 89, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField_ = new JPasswordField();
		passwordField_.setBounds(206, 92, 111, 20);
		frame.getContentPane().add(passwordField_);
		
		JButton btnChange = new JButton("Change");
		btnChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection con = null;  
			Statement stmt = null;  
			     // ResultSet rs = null;  
				try 
				{
						con = new SQLConnection().getConnection();

						// Create and execute an SQL statement that returns some data.
				 		String SQL = "update students set Password= "+Integer.valueOf(passwordField_.getText()).intValue()+" where StrudentName = '"+textField.getText()+"' ";
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
		btnChange.setBounds(162, 168, 89, 23);
		frame.getContentPane().add(btnChange);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);
				frame.dispose();
				
			}
		});
		btnBack.setBounds(340, 227, 76, 23);
		frame.getContentPane().add(btnBack);
	}
}
