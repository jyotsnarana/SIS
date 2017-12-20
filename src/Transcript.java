

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.text.DecimalFormat;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class Transcript {

	private JFrame frame;
	private JTable table;
	public HashMap<String, Float> semesterGPA = new HashMap<String, Float>();
	public Float cGPA;

	/**
	 * showing the transcript of the student.
	 * using database table "transcript"
	 * @author Parisa
	 */
	public static void transcript()  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transcript window = new Transcript();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * connecting database
	 * @throws SQLException
	 */
	public Transcript() throws SQLException {
		initialize();
		show_list();
	}

	/**
	 * connection string to connect to the database and retreiving the rows from transcript
	 * @return rows from transcript table
	 */
	public ArrayList<transcriptlist> userList(){
		ArrayList<transcriptlist> usersList=new ArrayList<>();
		Connection con = null;
	      Statement stmt = null;
	      ResultSet rs = null;

		try {
			con = new SQLConnection().getConnection();

			String SQLCGPA = "SELECT AVG(point) AS cgpa FROM student_record WHERE StudentId='"+currentUser.id+"' AND point != 0";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLCGPA);

			while(rs.next())
			{
				System.out.println("Cumulative GPA: " +rs.getFloat("cgpa"));
				cGPA = rs.getFloat("cgpa");
			}

			String SQLGPA = "SELECT AVG(point) AS gpa, Semester FROM student_record WHERE StudentId='"+currentUser.id+"' AND point != 0 GROUP BY Semester";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLGPA);

			while(rs.next())
			{
				semesterGPA.put(rs.getString("Semester"), rs.getFloat("gpa"));
			}

			System.out.println("SEMESTER GPA: " + semesterGPA.get("Winter17"));

			String SQL = "SELECT * FROM student_record WHERE StudentId='"+currentUser.id+"'AND Semester='Winter17'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			transcriptlist list;
		        while(rs.next())
		        {
					list=new transcriptlist(rs.getString("StudentId"), rs.getString("CourseId"), rs.getString("CourseName"), rs.getString("Grade"), rs.getFloat("Point"), rs.getString("Semester"));
		        	usersList.add(list);
		        }

			// Summer 2017 semester
			String SQL2 = "SELECT * FROM student_record WHERE StudentId='"+currentUser.id+"'AND Semester='Summer17'";

			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL2);
			transcriptlist list2;
			while(rs.next())
			{
				list2=new transcriptlist(rs.getString("StudentId"), rs.getString("CourseId"), rs.getString("CourseName"), rs.getString("Grade"), rs.getFloat("Point"), rs.getString("Semester"));
				usersList.add(list2);
			}

			// Fall 2017 semester
			String SQL3 = "SELECT * FROM student_record WHERE StudentId='"+currentUser.id+"'AND Semester='Fall17'";

			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL3);
			transcriptlist list3;
			while(rs.next())
			{
				list3=new transcriptlist(rs.getString("StudentId"), rs.getString("CourseId"), rs.getString("CourseName"), rs.getString("Grade"), rs.getFloat("Point"), rs.getString("Semester"));
				usersList.add(list3);
			}

			// Winter 2018 semester
			String SQL4 = "SELECT * FROM student_record WHERE StudentId='"+currentUser.id+"'AND Semester='Winter18'";

			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL4);
			transcriptlist list4;
			while(rs.next())
			{
				list4=new transcriptlist(rs.getString("StudentId"), rs.getString("CourseId"), rs.getString("CourseName"), rs.getString("Grade"), rs.getFloat("Point"), rs.getString("Semester"));
				usersList.add(list4);
			}

			// Summer 2018 semester
			String SQL5 = "SELECT * FROM student_record WHERE StudentId='"+currentUser.id+"'AND Semester='Summer18'";

			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL5);
			transcriptlist list5;
			while(rs.next())
			{
				list5=new transcriptlist(rs.getString("StudentId"), rs.getString("CourseId"), rs.getString("CourseName"), rs.getString("Grade"), rs.getFloat("Point"), rs.getString("Semester"));
				usersList.add(list5);
			}

		}
		 catch (Exception e) {
	         e.printStackTrace();
	      }
		return usersList;
	}

	/**
	 * showing the contents of transcript table.
	 */
	public void show_list()
	{
		String currentSemester = "";
		ArrayList<transcriptlist> list_1= userList();
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		Object[] row=new Object[3];
		DecimalFormat df = new DecimalFormat("#.00");
			for(int i=0;i<list_1.size();i++)
			{
				if(!currentSemester.equalsIgnoreCase(list_1.get(i).getSemester())){
					row[0]="";
					row[1]="";
					row[2]="";
					model.addRow(row);
					row[0]=list_1.get(i).getSemester();
					row[1]="";
					try{
						row[2] = "GPA: " + df.format(semesterGPA.get(list_1.get(i).getSemester()));
					} catch(Exception ex) {
						row[2]="GPA: "+ df.format(0.0);
					}

					model.addRow(row);
				}
					row[0]=list_1.get(i).getCourseId();
					row[1]=list_1.get(i).getCourseName();
					row[2]=list_1.get(i).getGrade();

				currentSemester = list_1.get(i).getSemester();
				model.addRow(row);
			}

			row[0]="";
			row[1]="";
			row[2]="";model.addRow(row);
			row[0]="";
			row[1]="";
			row[2]="";model.addRow(row);
			row[0]="";
			row[1]="";
			row[2]="";model.addRow(row);
			row[0]="";
			row[1]="CGPA: " + df.format(cGPA);
			row[2]="";

			model.addRow(row);

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException
	 */
	@SuppressWarnings("serial")
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 603, 839);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		String title = "Unofficial Transcript		" +"Student Name: "+currentUser.name+"		"+"Student Id: "+currentUser.id;
				frame.setTitle(title);

		table = new JTable();
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setLocation(0, 11);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Course Id", "Course Name", "Grade"},
			},
			new String[] {
					"Course Id", "Course Name", "Grade"
			}
		));
		table.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setSize(591,739);
		frame.getContentPane().add(table);

		JScrollPane js= new JScrollPane();
		table.add(js);

	}
}
