import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CourseCart {

	private JFrame frame;
	private JTable table_1;

	/**
	 * Launch the application.
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Student Cart");
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 414, 116);
		frame.getContentPane().add(scrollPane);
		
		
//		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null},
//			},
//			new String[] {
//				"Term", "Course", "Description"
//			}
//		));
//		table.setBounds(295, 187, -182, -131);
//		table.setRowSelectionAllowed(true);
//		//scrollPane.setViewportView(table);
//		frame.getContentPane().add(table);
		
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
	}
}
