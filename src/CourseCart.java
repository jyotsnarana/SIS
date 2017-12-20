import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CourseCart {

	private JFrame frame;
	private JTable table_1;
	private JButton btnDrop;
	String courseId, courseName, semester, professor, time, room, capacity;
	private JButton btnBack;
	private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	/**
	 * Course cart added for student frame
	 * database table "addcourse" used to show the courses taken.
	 * @author jyotsna
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseCart window = new CourseCart();
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
	public CourseCart() {
		initialize();
		show_list();
	}

	/**
	 * connection string to connect to the database
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

			        	String SQL = "SELECT c.*, sc.StudentId FROM student_course sc JOIN course c ON c.id = sc.CourseId WHERE StudentId =" + currentUser.id;
				        stmt = con.createStatement();  
				        rs = stmt.executeQuery(SQL);
				        addCourse list;
				        while(rs.next())
				        {
				        	list=new addCourse(rs.getString("CourseId"), rs.getString("CourseName"), rs.getString("Semester"), rs.getString("Professor"), rs.getString("Time"), rs.getString("Room"), rs.getString("Capacity"));
				        	usersList.add(list);
				        }
			
			 }     
		catch (Exception e) {  
	        e.printStackTrace();  
	     }
	return usersList;
	}


	/**
	 * showing the contents of the database table on to the jtable
	 */
	public void show_list()
	{
		ArrayList<addCourse> list_1= userList();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		Object[] row=new Object[7];
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
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Student Cart");
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 414, 116);
		frame.getContentPane().add(scrollPane);
		
		

		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"CourseId", "CourseName", "Semester", "Professor", "Time", "Room", "Capacity"
			}
		));
		
		table_1.setRowSelectionAllowed(true);
		
		scrollPane.setViewportView(table_1);
		
		btnDrop = new JButton("Drop");
		btnDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int rowNum = table_1.getSelectedRow();
					String SelectCourseId = (String) table_1.getValueAt(rowNum, 0);
					String SelectSemester = (String) table_1.getValueAt(rowNum, 2);

					Connection con = SQLConnection.getConnection();

					String SQL1 = "select * FROM course WHERE CourseId= '" + SelectCourseId + "' AND Semester = '" + SelectSemester + "'";
					Statement stmt1 = con.createStatement();
					ResultSet rs1 = stmt1.executeQuery(SQL1);


					int courseIdentifier = 0;
					String CourseId = null;
					String Semester = null;
					while (rs1.next()) {
						courseIdentifier = rs1.getInt("Id");
						CourseId = rs1.getString("CourseId");
						Semester = rs1.getString("Semester");
					}

					Date now = new Date();
					System.out.println(now);
					Date parseDate = sdf.parse("2017-11-15");
					System.out.println(parseDate);

//					HashMap<String, String> discDate = new HashMap<String, String>();
//					discDate.put("Fall17", "2017-11-15");
//					discDate.put("Winter18", "2018-02-15");
//					discDate.put("Summer18", "2018-06-15");

					// Remove Student record if its not too late
					if(now.before(parseDate)) {
//						delete the course
						String SQL = "DELETE FROM student_course WHERE CourseId= '" + courseIdentifier + "' AND StudentId='" + currentUser.id + "'";
						Statement stmt = con.createStatement();
						stmt.executeUpdate(SQL);

						// tuition fee drop
						String SQL2 = "DELETE FROM tuition WHERE  StudentId = '" + currentUser.id + "' AND Semester = '" + Semester + "' AND CourseId = " + courseIdentifier + "";
						Statement stmt2 = con.createStatement();
						stmt2.executeUpdate(SQL2);

						String SQL3 = "DELETE FROM student_record WHERE StudentId = '" + currentUser.id + "' AND CourseId = '" + CourseId + "' AND Semester = '" + Semester + "'";
						Statement stmt3 = con.createStatement();
						stmt3.executeUpdate(SQL3);
					} else {
						// TODO Update student_record if its past due
						String SQL4 = "UPDATE student_record SET Grade = 'DISC', point = 0 WHERE StudentId = '" + currentUser.id + "' AND CourseId = '" + CourseId + "' AND Semester = '" + Semester + "'";
						Statement stmt4 = con.createStatement();
						stmt4.executeUpdate(SQL4);
												JOptionPane.showMessageDialog(null, "The course is counted as discontinued");
//						To message.
//						throw new Exception();
					}

				} catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "The course is counted as discontinued");
				}
			}
		});
		btnDrop.setBounds(167, 192, 89, 23);
		frame.getContentPane().add(btnDrop);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student.newScreen1();
				frame.dispose();
			}
		});
		btnBack.setBounds(345, 237, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
