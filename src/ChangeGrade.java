import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeGrade extends JFrame {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Changing grade by professor only.
	 * updates the database table "soen6441".
	 * @author jyotsna
	 */
	public static void changeGrade() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeGrade window = new ChangeGrade();
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
	public ChangeGrade() {
		initialize();
	}
	
	/**
	 * initialize the frame
	 * connection string to connect to the database.
	 */
  public void initialize()
  {
	  	frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Change Grade");
		
		JLabel lblNewLabel = new JLabel("Term");
		lblNewLabel.setBounds(80, 37, 75, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(80, 62, 75, 14);
		frame.getContentPane().add(lblCourse);
		
		JLabel lblStudentid = new JLabel("StudentId");
		lblStudentid.setBounds(80, 92, 75, 14);
		frame.getContentPane().add(lblStudentid);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(80, 117, 75, 14);
		frame.getContentPane().add(lblGrade);
		
		JButton btnNewButton = new JButton("update");
		btnNewButton.setBounds(139, 160, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(176, 34, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(176, 59, 86, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 89, 86, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(176, 114, 86, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Professor.newScreen2();
				frame.dispose();
			}
		});
		btnBack.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnBack);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection con = null;
			Statement stmt = null;
			if((textField_3.getText().toString().trim().length()== 0) && (textField_2.getText().toString().trim().length()== 0 ))
    		{
    			JOptionPane.showMessageDialog(null, "Fill the fields for updation");	
    		}else {
				try 
				{
						con = new SQLConnection().getConnection();

						// Create and execute an SQL statement that returns some data.
						// TODO remove hardcode value of soen6441 make it dynamic
				 		String SQL = "update soen6441 set Grade= '"+ textField_3.getText().toUpperCase() +"' where StudentID = '"+textField_2.getText()+"' ";
				 		stmt = con.createStatement(); 
				 	    System.out.println(textField_3.getText());
		        		stmt.executeUpdate(SQL);
		        		JOptionPane.showMessageDialog(null, "Database updated");
		        		}
		       
				catch (Exception e1)
				{  
					 JOptionPane.showMessageDialog(null,e1);
			    }  
	 		}
			}
		});
  }
}
