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
	 * @author jyotsna
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

			        	String SQL = "SELECT * FROM register_student" ;
				        stmt = con.createStatement();  
				        rs = stmt.executeQuery(SQL);
				        registerList list;
				        while(rs.next())
				        {
				        	list=new registerList(rs.getString("Term"), rs.getString("Course"), rs.getString("Description"), rs.getString("Professor"), rs.getString("Start date"), rs.getString("End date"), rs.getString("Start time"), rs.getString("End time"), rs.getString("Vacancy"));
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
			row[0]=list_1.get(i).getterm();
			row[1]=list_1.get(i).getcourse();
			row[2]=list_1.get(i).getdescription();
			row[3]=list_1.get(i).getprofessor();
			row[4]=list_1.get(i).getstartdate();
			row[5]=list_1.get(i).getenddate();
			row[6]=list_1.get(i).getstarttime();
			row[7]=list_1.get(i).getendtime();
			row[8]=list_1.get(i).getvacancy();
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
				"Term","Course", "Description", "Professor", "Start", "End", "Start Time", "End Time", "Vacancy"
			}
		));
		
		table_1.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table_1);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				       if (course.equalsIgnoreCase("INSE6260  "))
				       {
				    	   JOptionPane.showMessageDialog(null, "Cannot register");  
				       }
				       else {
				    	  // String SQL = "INSERT INTO addcourse (Term, Course, Description) VALUES ('"+term+"','"+course+"','"+description+"') " ;
				    	   String SQL= "INSERT INTO addcourse(Term, Course, Description) SELECT t1.Term, t1.Course, t1.Description FROM register_student t1  WHERE NOT EXISTS(SELECT Term   FROM addcourse t2    WHERE t2.Term = t1.Term)";
					    Statement   stmt = con.createStatement();  
					    stmt.executeUpdate(SQL);
					  
				       }
			     
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Course already taken"); 
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
