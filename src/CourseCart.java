import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CourseCart {

	private JFrame frame;
	private JTable table_1;
	private JButton btnDrop;
	String term, course, description;
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


	/**
	 * showing the contents of the database table on to the jtable
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
				"Term","Course", "Description"
			}
		));
		
		table_1.setRowSelectionAllowed(true);
		
		scrollPane.setViewportView(table_1);
		
		btnDrop = new JButton("Drop");
		btnDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					int rowNum= table_1.getSelectedRow();
				String Course=(String) table_1.getValueAt(rowNum, 1);
				
				 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
				 String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
				         "databaseName=sis_db;user=sa;password=jyotsna";  
				Connection con = DriverManager.getConnection(connectionUrl);  
				
				String SQL1 = "select * from register_student Where Course='"+Course+"'" ;
			    Statement   stmt1 = con.createStatement();  
			     ResultSet   rs1 = stmt1.executeQuery(SQL1);
			     
			   
			     
			     while(rs1.next()) {
			    	 term= rs1.getString("Term");
			    	 course= rs1.getString("Course");
			    	 description= rs1.getString("Description");
			    	 System.out.println(course);
			     }
				       
				        String SQL = "DELETE FROM addcourse WHERE Course= '"+course+"'" ;
					    Statement   stmt = con.createStatement();  
					    stmt.executeUpdate(SQL);
					        
					       
				
				
				}catch(Exception ex) {
					//JOptionPane.showMessageDialog(null, "Course already taken");
				}
			}
		});
		btnDrop.setBounds(167, 192, 89, 23);
		frame.getContentPane().add(btnDrop);
	}
}
