import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;

public class RegisterCourse {
    
	public JButton btnGo;
	private JFrame frame;
	private JTable table_1;
	private JTextField textField;
	private JButton btnAdd;
	String term, course, description;
	private JButton btnDrop;
	/**
	 * Registration of course by admin
	 * uses database table "register_student"
	 * update database table "addcourse"
	 * @author jyotsna
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterCourse window = new RegisterCourse();
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
	public RegisterCourse() {
		initialize();
		show_list();
	}

	/**
	 * connection string for retrieving data from register_student database
	 * @return array of rows in register_student
	 */
	public ArrayList<registerList> userList(){
		ArrayList<registerList> usersList=new ArrayList<>();
		
		
		
			
				        Connection con = null;  
					      Statement stmt = null;  
					      ResultSet rs = null;
		try 
		{

						con = new SQLConnection().getConnection();
			
			 
			       
//			        	String SQL = "SELECT * FROM register_student" ;
						String SQL = "SELECT * FROM schedule JOIN courses on courseId = courses.Id" ;
						System.out.println(SQL);
				        stmt = con.createStatement();  
				        rs = stmt.executeQuery(SQL);
				        registerList list;
				        while(rs.next())
				        {

				        	list=new registerList(rs.getString("CourseId"), rs.getString("CourseName"), rs.getString("Semester"), rs.getString("Professor"), rs.getString("Time"), rs.getString("Room"), rs.getString("Capacity"));
//							list=new registerList(rs.getString("CourseId"), rs.getString("CourseName"), rs.getString("Semester"), rs.getString("Time"), rs.getString("Room"), rs.getString("Capacity"));
							usersList.add(list);
				        }
			
			 }     
		catch (Exception e) {  
	        e.printStackTrace();  
	     }
	return usersList;
	}


	/**
	 * showing the contents of register_student database
	 */
	public void show_list()
	{
		ArrayList<registerList> list_1= userList();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		Object[] row=new Object[9];
		for(int i=0;i<list_1.size();i++)
		{
			row[0]=list_1.get(i).getCourseId();
			row[1]=list_1.get(i).getCourseName();
			row[2]=list_1.get(i).getSemester();
			row[3]=list_1.get(i).getProfessor();
			row[4]=list_1.get(i).getTime();
			row[5]=list_1.get(i).getRoom();
			row[6]=list_1.get(i).getCapacity();
			model.addRow(row);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * updating the addcourse database
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Courses");

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 46, 434, 141);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Term","Course", "Description", "Professor", "Start", "End", "Start Time", "End Time", "Vacancy"
			}
		));
		
		table_1.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table_1);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(173, 198, 89, 23);
		frame.getContentPane().add(btnAdd);
		
//		btnDrop = new JButton("Drop");
//		btnDrop.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				admin_student.main(null);
//			}
//		});
//		btnDrop.setBounds(297, 198, 89, 23);
//		frame.getContentPane().add(btnDrop);

		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int rowNum= table_1.getSelectedRow();
				String Course=(String) table_1.getValueAt(rowNum, 1);

					Connection con = new SQLConnection().getConnection();
				
				String SQL1 = "select * from register_student Where Course='"+Course+"'" ;
			    Statement   stmt1 = con.createStatement();  
			     ResultSet   rs1 = stmt1.executeQuery(SQL1);
			     
			   
			     
			     while(rs1.next()) {
			    	 term= rs1.getString("Term");
			    	 course= rs1.getString("Course");
			    	 description= rs1.getString("Description");
			    	 System.out.println(course);
			     }
				      
				       // String SQL = "INSERT INTO addcourse (Term, Course, Description) VALUES ('"+term+"','"+course+"','"+description+"') " ;
				        String SQL= "INSERT INTO addcourse(Term, Course, Description) SELECT t1.Term, t1.Course, t1.Description FROM register_student t1  WHERE NOT EXISTS(SELECT Term   FROM addcourse t2    WHERE t2.Term = t1.Term)";
				        		  
				        		                   
				        		                  
					    Statement   stmt = con.createStatement();  
					    stmt.executeUpdate(SQL);
					   
				       
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Course not added");  	
				}
			}
		});
	}
}
