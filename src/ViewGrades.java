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
					ViewGrades frame = new ViewGrades();
					frame.setVisible(true);
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
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(209, 24, 103, 20);
		contentPane.add(comboBox);
		comboBox.addItem("---Select---");
		comboBox.addItem("Winter 2016");
		comboBox.addItem("Summer 2016");
		comboBox.addItem("Fall 2016");
		comboBox.addItem("Winter 2017");
		comboBox.addItem("Summer 2017");
		comboBox.addItem("Fall 2017");
		ArrayList<transcriptlist> list_1= userList();
		DefaultTableModel model=(DefaultTableModel)table_view.getModel();
		Object[] row=new Object[8];
//		if(comboBox.getSelectedItem()=="---Select---")
//			{
//				row[0]="Null";
//				row[1]="Null";
//				row[2]="Null";
//				row[3]="Null";
//				model.addRow(row);	
//			}
		
		if(comboBox.getSelectedItem() == "Winter 2016")
			{
				for(int i=0;i<11;)
					{
						for(int j=0; ((list_1.get(i).getterm()).equals("Winter16"));j++,i++)
						{
							row[0]=list_1.get(j).getcourse();
							row[1]=list_1.get(j).getdescription();
							row[2]=list_1.get(j).getgrade();
							row[3]=list_1.get(j).getgrade_Points();
							model.addRow(row);
						}
					}
			
			}
	}
	
	
	@SuppressWarnings("unchecked")
	public void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		
		JLabel lblSelectTerm = new JLabel("Select Term:");
		lblSelectTerm.setBounds(96, 27, 103, 14);
		contentPane.add(lblSelectTerm);
		
		table_view = new JTable();
		table_view.setModel(new DefaultTableModel(
			new Object[][] {
				{"Course", "Description", "Grades", "Grade Points"},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table_view.setBounds(29, 76, 377, 148);
		contentPane.add(table_view);
	}
}
