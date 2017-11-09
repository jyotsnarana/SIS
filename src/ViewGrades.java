import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewGrades extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTable table_view;
	//private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void viewGrades() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewGrades window = new ViewGrades();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewGrades() {
		initialize();
		show_view();
	}
	
	public ArrayList<transcriptlist> userList(){
		ArrayList<transcriptlist> users_List=new ArrayList<>();
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
		        	list=new transcriptlist(rs.getString("Term"), rs.getString("Course"), rs.getString("Description"), rs.getString("Grade"), rs.getString("GPA"), rs.getString("Grade Points"));
		        	users_List.add(list);
		        }
		}
		 catch (Exception e) {  
	         e.printStackTrace();  
	      }
		return users_List;
	}
	
	@SuppressWarnings("unchecked")
	public void show_view()
	{
		
		
			
			}
	
	
	
	@SuppressWarnings("unchecked")
	public void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Professor");
		frame.getContentPane().setLayout(null);
	
		@SuppressWarnings("rawtypes")
		String items[]= {"Winter2016","Summer2016","Fall2016","Winter2017","Summer2017","Fall2017"};
		JComboBox comboBox_1 = new JComboBox(items);
		comboBox_1.setBounds(209, 24, 103, 20);
		frame.getContentPane().add(comboBox_1);
		contentPane.add(comboBox_1);
		//comboBox.addItem("---Select---");
//		comboBox_1.addItem("Winter2016");
//		comboBox_1.addItem("Summer2016");
//		comboBox_1.addItem("Fall2016");
//		comboBox_1.addItem("Winter2017");
//		comboBox_1.addItem("Summer2017");
//		comboBox_1.addItem("Fall2017");
//		
		JLabel lblSelectTerm = new JLabel("Select Term:");
		lblSelectTerm.setBounds(96, 27, 103, 14);
		contentPane.add(lblSelectTerm);
		
		table_view = new JTable();
		table_view.setModel(new DefaultTableModel(
			new Object[][] {
				{"Course", "Description", "Grades", "Grade Points"},
			},
			new String[] {
				"Course", "Description", "Grades", "Grade Points"
			}
		));
		table_view.setBounds(29, 76, 377, 148);
		frame.getContentPane().add(table_view);
		
		ArrayList<transcriptlist> list_1= userList();
		DefaultTableModel model=(DefaultTableModel)table_view.getModel();
		Object[] row=new Object[10];
		comboBox_1.setSelectedIndex(-1);
		for(int i=0;i<list_1.size();i++)
		{
	
		if( list_1.get(i).getterm().equalsIgnoreCase("Winter16  ") && comboBox_1.getSelectedItem() == "Winter2016")
						{
							row[0]=list_1.get(i).getcourse();
							row[1]=list_1.get(i).getdescription();
							row[2]=list_1.get(i).getgrade();
							row[3]=list_1.get(i).getgrade_Points();
							model.addRow(row);	
							 System.out.println(comboBox_1.getSelectedItem());
						}
			
		 if(list_1.get(i).getterm().equalsIgnoreCase("Summer16  ") && comboBox_1.getItemAt(i) == "Summer2016")
			{
				row[0]=list_1.get(i).getcourse();
				row[1]=list_1.get(i).getdescription();
				row[2]=list_1.get(i).getgrade();
				row[3]=list_1.get(i).getgrade_Points();
				model.addRow(row);		
				System.out.println(row[0]);
			}
					}
	}
}
