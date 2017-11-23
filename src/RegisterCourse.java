import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractButton;
import javax.swing.JButton;

public class RegisterCourse {
    
	public JButton btnGo;
	public  JComboBox comboBox;
	private JFrame frame;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterCourse window = new RegisterCourse();
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
	public RegisterCourse() {
		initialize();
		show_list();
	}

	public ArrayList<registerList> userList(){
		ArrayList<registerList> usersList=new ArrayList<>();
		
		
		btnGo.addActionListener(new ActionListener() {
			  
			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				        Connection con = null;  
					      Statement stmt = null;  
					      ResultSet rs = null;
		try 
		{
			
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			 String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
			         "databaseName=sis_db;user=sa;password=jyotsna";  
			 con = DriverManager.getConnection(connectionUrl);  
			
			 
			        if (comboBox.equals("WINTER18")) {
			        	String SQL = "SELECT * FROM register_student where Term= 'winter18'";  
				        stmt = con.createStatement();  
				        rs = stmt.executeQuery(SQL);
				        registerList list;
				        while(rs.next())
				        {
				        	list=new registerList(rs.getString("Term"), rs.getString("Course"), rs.getString("Description"), rs.getString("Professor"), rs.getString("Start date"), rs.getString("End date"), rs.getString("Start time"), rs.getString("End time"), rs.getString("Vacancy"));
				        	usersList.add(list);
				        }
				
					 }
			         else if (comboBox.equals("SUMMER18")) {
			        	 String SQL = "SELECT * FROM register_student where Term= 'summer18'";  
					        stmt = con.createStatement();  
					        rs = stmt.executeQuery(SQL);
					        registerList list;
					        while(rs.next())
					        {
					        	list=new registerList(rs.getString("Term"), rs.getString("Course"), rs.getString("Description"), rs.getString("Professor"), rs.getString("Start date"), rs.getString("End date"), rs.getString("Start time"), rs.getString("End time"), rs.getString("Vacancy"));
					        	usersList.add(list);
					        }
					
						 }
			         else if (comboBox.equals("FALL18"))
			         {
			        	 String SQL = "SELECT * FROM register_student where Term= 'fall18'";  
					        stmt = con.createStatement();  
					        rs = stmt.executeQuery(SQL);
					        registerList list;
					        while(rs.next())
					        {
					        	list=new registerList(rs.getString("Term"), rs.getString("Course"), rs.getString("Description"), rs.getString("Professor"), rs.getString("Start date"), rs.getString("End date"), rs.getString("Start time"), rs.getString("End time"), rs.getString("Vacancy"));
					        	usersList.add(list);
					        }
					
						 }
			 }     
		catch (Exception e) {  
	        e.printStackTrace();  
	     }
			         }
	      }
			 );

		
		return usersList;
	}
	
	
	
	
	  

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
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	    comboBox = new JComboBox();
		comboBox.setBounds(207, 11, 84, 20);
		frame.getContentPane().add(comboBox);
		//comboBox.addItem("---Select---");
		comboBox.addItem("WINTER18");
		comboBox.addItem("SUMMER18");
		comboBox.addItem("FALL18");
		
		JLabel lblTerm = new JLabel("Term");
		lblTerm.setBounds(136, 14, 46, 14);
		frame.getContentPane().add(lblTerm);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 414, 116);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Term","Course", "Description", "Professor", "Start", "End", "Start Time", "End Time", "Vacancy"
			}
		));
		scrollPane.setViewportView(table_1);
		
		JButton btnGo = new JButton("Go");
		btnGo.setBounds(301, 10, 46, 23);
		frame.getContentPane().add(btnGo);
		
				

	}
}
