import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.sql.*;
import java.util.ArrayList;

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
public class Transcript implements connectURL {

	private JFrame frame;
	private JTable table;
	

	/**
	 * Launch the application.
	
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

	public ArrayList<transcriptlist> userList(){
		ArrayList<transcriptlist> usersList=new ArrayList<>();
		Connection con = null;  
	      Statement stmt = null;  
	      ResultSet rs = null;  
		try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			 String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
			         "databaseName=sis_db;user=sa;password=jyotsna";  
			 con = DriverManager.getConnection(connectionUrl);  
			 String SQL = "SELECT * FROM transcript";  
		        stmt = con.createStatement();  
		        rs = stmt.executeQuery(SQL);
		        transcriptlist list;
		        while(rs.next())
		        {
		        	list=new transcriptlist(rs.getString("Term"), rs.getString("Course"), rs.getString("Description"), rs.getString("Grade"), rs.getString("GPA"));
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
		ArrayList<transcriptlist> list_1= userList();
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		Object[] row=new Object[8];
		for(int i=0;i<list_1.size();i++)
		{
			row[0]=list_1.get(i).getterm();
			row[1]=list_1.get(i).getcourse();
			row[2]=list_1.get(i).getdescription();
			row[3]=list_1.get(i).getgrade();
			row[4]=list_1.get(i).getGPA();
			model.addRow(row);
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings("serial")
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 603, 332);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setLocation(0, 11);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Term", "Course", "Description", "Grade", "GPA"},
			},
			new String[] {
				"Term", "Course", "Description", "Grade", "GPA"
			}
		));
		table.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setSize(591,239);
		frame.getContentPane().add(table);
		
		JScrollPane js= new JScrollPane();
		table.add(js);
		
	}
}
