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

public class Student extends JFrame {

	private JFrame frame;
	private JTable table_1;
	/**
	 * Launch the application.
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

	public ArrayList<addCourse> userList(){
		ArrayList<addCourse> usersList=new ArrayList<>();
		
		
		
			
				        Connection con = null;  
					      Statement stmt = null;  
					      ResultSet rs = null;
		try 
		{
			
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			 String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
			         "databaseName=sis_db;user=sa;password=jyotsna";  
			 con = DriverManager.getConnection(connectionUrl);  
			
			 
			       
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
		this.setTitle("STUDENT");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(193, 71, 210, 142);
		frame.getContentPane().add(scrollPane);
		
		JButton btnTranscript = new JButton("Transcript");
		btnTranscript.setVerticalAlignment(SwingConstants.TOP);
		btnTranscript.setEnabled(true);
		btnTranscript.setBackground(Color.LIGHT_GRAY);
		btnTranscript.setBounds(10, 122, 134, 23);
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
		
		JButton btnViewGrades = new JButton("View Grades");
		btnViewGrades.setBounds(10, 156, 134, 23);
		frame.getContentPane().add(btnViewGrades);
		
		JButton btnNewButton = new JButton("Tutition Fee");
		btnNewButton.setBounds(10, 190, 134, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCourseCart = new JButton("Course Cart");
		btnCourseCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CourseCart.main(null);
			}
		});
		btnCourseCart.setBounds(10, 88, 134, 23);
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
		
		btnViewGrades.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {

						ViewGrades.viewGrades();
						}
				});
		
		btnNewButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {

//				Tutition_fee fee= new Tutition_fee();
//				fee.tutitionFee();
				Tutition_fee.main(null);
				}
		});
	}
}