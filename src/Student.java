import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class Student extends JFrame {

	private JFrame frame;
	private JTable table_1;
	/**
	 * student login frame
	 * using addcourse class to show the contents in the table
	 * @see addcourse
	 * @author jyotsna
	 */
	public static void newScreen1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
					window.frame.setVisible(true);
					//window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Student() {
		initialize();
		show_list();
	}

	/**
	 * connection string used to connect to the SQL Server
	 * @return arraylist of addcourse
	 */
	public ArrayList<addCourse> userList(){
		ArrayList<addCourse> usersList=new ArrayList<>();
		
		
		
			
				        Connection con = null;  
					      Statement stmt = null;  
					      ResultSet rs = null;
		try 
		{

						con = new SQLConnection().getConnection();

			        	String SQL = "SELECT * FROM addcourse" ;
				        stmt = con.createStatement();  
				        rs = stmt.executeQuery(SQL);
				        addCourse list;
				        while(rs.next())
				        {
				        	list=new addCourse(rs.getString("Term"), rs.getString("Course"), rs.getString("Description"));
				        	usersList.add(list);
				        }
			
			 }     
		catch (Exception e) {  
	        e.printStackTrace();  
	     }
	return usersList;
	}

	/**
	 * showing the contents of database in the jtable
	 */
	public void show_list()
	{
		ArrayList<addCourse> list_1= userList();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		Object[] row=new Object[9];
		for(int i=0;i<list_1.size();i++)
		{
			row[0]=list_1.get(i).getterm();
			row[1]=list_1.get(i).getcourse();
			row[2]=list_1.get(i).getdescription();
			model.addRow(row);
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("STUDENT");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 71, 280, 142);
		frame.getContentPane().add(scrollPane);
		
		JButton btnTranscript = new JButton("Transcript");
		btnTranscript.setVerticalAlignment(SwingConstants.TOP);
		btnTranscript.setEnabled(true);
		btnTranscript.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnTranscript.setBounds(10, 142, 134, 23);
		btnTranscript.addActionListener(new ActionListener() 
		{
			  
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Transcript.transcript();
			}	
			});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnTranscript);
		
		JButton btnNewButton = new JButton("Tutition Fee");
		btnNewButton.setBounds(10, 176, 134, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCourseCart = new JButton("Course Cart");
		btnCourseCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CourseCart.main(null);
				frame.dispose();
			}
		});
		btnCourseCart.setBounds(10, 108, 134, 23);
		frame.getContentPane().add(btnCourseCart);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Term","Course", "Description"
			}
		));
		
		table_1.setRowSelectionAllowed(true);
		
		scrollPane.setViewportView(table_1);
		
		JLabel lblCoursesRegistered = new JLabel("Courses Registered");
		lblCoursesRegistered.setBounds(219, 46, 134, 14);
		frame.getContentPane().add(lblCoursesRegistered);
		
		JButton btnRegisterCourses = new JButton("Register Courses");
		btnRegisterCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register_student.main(null);
				frame.dispose();
			}
		});
		btnRegisterCourses.setBounds(10, 74, 134, 23);
		frame.getContentPane().add(btnRegisterCourses);
		
		btnNewButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Tutition_fee.main(null);
				frame.dispose();
				}
		});
	}
}