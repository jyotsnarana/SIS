

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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

public class Transcript {

	private JFrame frame;
	private JTable table;
	

	/**
	 * showing the transcript of the student.
	 * using database table "transcript"
	 * @author jyotsna
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

			 String SQL = "SELECT * FROM transcript";  
		        stmt = con.createStatement();  
		        rs = stmt.executeQuery(SQL);
		        transcriptlist list;
		        while(rs.next())
		        {
		        	list=new transcriptlist(rs.getString("Term"), rs.getString("Course"), rs.getString("Description"), rs.getString("Grade"), rs.getString("GPA"), rs.getString("Term_GPA"));
		        	usersList.add(list);
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
		ArrayList<transcriptlist> list_1= userList();
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		Object[] row=new Object[6];
		for(int i=0;i<list_1.size();i++)
		{
			row[0]=list_1.get(i).getterm();
			row[1]=list_1.get(i).getcourse();
			row[2]=list_1.get(i).getdescription();
			row[3]=list_1.get(i).getgrade();
			row[4]=list_1.get(i).getGPA();
			row[5]=list_1.get(i).getterm_GPA();
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
		frame.setResizable(false);
		frame.setTitle("Unofficial Transcript");
		
		table = new JTable();
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setLocation(0, 11);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Term", "Course", "Description", "Grade", "GPA", "Term_GPA"},
			},
			new String[] {
				"Term", "Course", "Description", "Grade", "GPA", "Term_GPA"
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
