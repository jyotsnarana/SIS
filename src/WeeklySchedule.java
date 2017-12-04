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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WeeklySchedule {

	private JFrame frame;
	private JTable table_1;
	private JButton btnBack;
	/**
	 * frame to show the weekly schedule of the professor
	 * uses database table "capacity"
	 * @author jyotsna
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeeklySchedule window = new WeeklySchedule();
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
	public WeeklySchedule() {
		initialize();
		show_list();
	}
	
	/**
	 * connection string used to extract contents from the capacity table.
	 * @return rows from table capacity
	 */
	public ArrayList<capacitylist> userList(){
		ArrayList<capacitylist> usersList=new ArrayList<>();
		Connection con = null;  
	      Statement stmt = null;  
	      ResultSet rs = null;  
		try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			 String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
			         "databaseName=sis_db;user=sa;password=jyotsna";  
			 con = DriverManager.getConnection(connectionUrl);  
			 String SQL = "SELECT * FROM capacity";  
		        stmt = con.createStatement();  
		        rs = stmt.executeQuery(SQL);
		        capacitylist list;
		        while(rs.next())
		        {
		        	list=new capacitylist( rs.getString("Course"), rs.getString("Description"), rs.getString("Schedule"), rs.getString("Time"), rs.getString("Room"), rs.getString("Capacity"));
		        	usersList.add(list);
		        }
		}
		 catch (Exception e) {  
	         e.printStackTrace();  
	      }
		return usersList;
	}
	
	
	/**
	 * showing contents of database table capacity
	 */
	public void show_list()
	{
		ArrayList<capacitylist> list_1= userList();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		Object[] row=new Object[6];
		for(int i=0;i<list_1.size();i++)
		{
			row[0]=list_1.get(i).getcourse();
			row[1]=list_1.get(i).getdescription();
			row[2]=list_1.get(i).getschedule();
			row[3]=list_1.get(i).gettime();
			row[4]=list_1.get(i).getroom();
			row[5]=list_1.get(i).getcapacity();
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
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Weekly Schedule");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 155);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Course", "Description", "Schedule", "Time", "Room", "Capacity"
			}
		));
		
		table_1.setRowSelectionAllowed(true);
		
		scrollPane.setViewportView(table_1);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Professor.newScreen2();
				frame.dispose();
			}
		});
		btnBack.setBounds(329, 237, 89, 23);
		frame.getContentPane().add(btnBack);
	}

}
