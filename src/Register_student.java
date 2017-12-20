import java.awt.EventQueue;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register_student {

	private JTable table_1;
	private JFrame frame;
	private JButton btnAdd;
	String term, course, description;
	private JButton btnBack;

	/**
	 * Student registration done by student only
	 * uses database table "register_student"
	 * update database table "addcourse"
	 * @author jyotsna, parisanikzad
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_student window = new Register_student();
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
	public Register_student() {
		initialize();
		show_list();
	}

	/**
	 * connection string used to connect to the database.
	 * @return arraylist of registerlist
	 */
	public ArrayList<registerList> userList(){
		ArrayList<registerList> usersList=new ArrayList<>();
		
		
		
			
				        Connection con = null;  
					      Statement stmt = null;  
					      ResultSet rs = null;
		try 
		{

						con = new SQLConnection().getConnection();

			        	String SQL = "SELECT * FROM course" ;
				        stmt = con.createStatement();  
				        rs = stmt.executeQuery(SQL);
				        registerList list;
				        while(rs.next())
				        {
//				        	list=new registerList(rs.getString("Term"), rs.getString("Course"), rs.getString("Description"), rs.getString("Professor"), rs.getString("Start date"), rs.getString("End date"), rs.getString("Start time"), rs.getString("End time"), rs.getString("Vacancy"));
							list=new registerList(rs.getString("CourseId"), rs.getString("CourseName"), rs.getString("Semester"), rs.getString("Professor"), rs.getString("Time"), rs.getString("Room"), rs.getString("Capacity"));
				        	usersList.add(list);
				        }
			
			 }     
		catch (Exception e) {  
	        e.printStackTrace();  
	     }
	return usersList;
	}


	/**
	 * showing contents of the database in jtable
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
	 * adding connection string in add button to update the "addcourse" database table
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Course Registration");
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 46, 434, 134);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Course Id","Course Name", "Semester", "Professor", "Time", "Room", "Capacity"
			}
		));
		
		table_1.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table_1);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int rowNum= table_1.getSelectedRow();
					String SelectCourseId=(String) table_1.getValueAt(rowNum, 0);
					String SelectSemester=(String) table_1.getValueAt(rowNum, 2);

					Connection con = new SQLConnection().getConnection();

					String SQL1 = "select * from course Where CourseId='"+SelectCourseId+"' AND Semester='"+SelectSemester+"'";
					Statement   stmt1 = con.createStatement();
					ResultSet   rs1 = stmt1.executeQuery(SQL1);

					int courseIdentifier = 0;
					String CourseId = null;
					String CourseName = null;
					String Grade = "NA";
					Double Point= 0.0;
					String Semester = null;
					String Time = null;
					while(rs1.next()) {
//						INSE expcetion
						if(rs1.getString("CourseId").equals("INSE6260")) {
							throw new Exception("Not_take_INSE");
						}

						courseIdentifier= rs1.getInt("Id");
						CourseId = rs1.getString("CourseId");
						CourseName = rs1.getString("CourseName");
						Semester = rs1.getString("Semester");
						Time = rs1.getString("Time");
					}

					String SQL3 = "SELECT * FROM student_course s JOIN course c ON c.id = s.CourseId WHERE s.StudentId = '" + currentUser.id + "'";// AND  CourseId =" + courseIdentifier + "";
					Statement   stmt3 = con.createStatement();
					ResultSet   rs3 = stmt3.executeQuery(SQL3);

					while(rs3.next()) {
						if(rs3.getInt("CourseId") == courseIdentifier && rs3.getInt("StudentId") == currentUser.id) {
							throw new Exception("already_taken");
						}

						System.out.println(Time);
						System.out.println(Semester);
						System.out.println(rs3.getString("Time"));
						System.out.println(rs3.getString("Semester"));
						//	Time conflict exception
						if(Time.equalsIgnoreCase(rs3.getString("Time")) && Semester.equalsIgnoreCase(rs3.getString("Semester"))) {
							throw new Exception("time_conflict");
						}

					}

	//				Student class taken
					String SQL2=  "INSERT INTO student_course(StudentId, CourseId) VALUES ( '" + currentUser.id + "', " + courseIdentifier + ")";
					Statement   stmt2 = con.createStatement();
					stmt2.executeUpdate(SQL2);

					// tuition fee add
					String SQL4=  "INSERT INTO tuition(StudentId, Semester, CourseId, amount) VALUES ( '" + currentUser.id + "', '" + Semester + "', " + courseIdentifier + ", 500.00)";
					Statement   stmt4 = con.createStatement();
					stmt4.executeUpdate(SQL4);

					// Student new record
//					TODO REMOVE row IF course is drop
					String SQL5=  "INSERT INTO student_record(StudentId, CourseId, CourseName, Grade, point, Semester) VALUES ( '" + currentUser.id + "', '"+ CourseId +"', '"+ CourseName +"', '"+ Grade+"' , "+ Point +", '" + Semester + "')";
					Statement   stmt5 = con.createStatement();
					stmt5.executeUpdate(SQL5);

				}catch(Exception ex) {
					if(ex.getMessage().equals("Not_take_INSE")) {
						JOptionPane.showMessageDialog(null, "INSE Course! Please contact Advisor!");
					} else if(ex.getMessage().equals("already_taken")) {
						JOptionPane.showMessageDialog(null, "Course already taken");
					} else if(ex.getMessage().equals("time_conflict")) {
						JOptionPane.showMessageDialog(null, "There is a time conflict for this course");
					} else{
						ex.printStackTrace();
//						JOptionPane.showMessageDialog(null, "Course already taken");
					}
				}
			
			}
		});
		btnAdd.setBounds(171, 191, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student.newScreen1();
				frame.dispose();
			}
		});
		btnBack.setBounds(345, 237, 89, 23);
		frame.getContentPane().add(btnBack);
	}

}
