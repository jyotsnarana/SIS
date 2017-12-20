import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Tutition_fee extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField card_Field;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public float debt = 0;



	private JTable table_1;
	/**
	 * frame used to pay the tutition fee by the student.
	 * @author Parisanikzad
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tutition_fee window = new Tutition_fee();
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
	public Tutition_fee() {
		initialize();
		show_list();
	}

	public void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Tutition Fee");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0,0, 434, 134);
		frame.getContentPane().add(scrollPane);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Semester","Tuition Fee", "Due Date",
				}
		));

		table_1.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table_1);

		JLabel lblAmount = new JLabel("Amount ");
		lblAmount.setBounds(41, 200, 70, 14);
		frame.getContentPane().add(lblAmount);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(171, 197, 86, 20);
		frame.getContentPane().add(textField_3);

		JButton btnNewButton = new JButton("Pay");
		btnNewButton.setBounds(168, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel label = new JLabel();
		label.setBounds(176, 85, 46, 14);
		frame.getContentPane().add(label);


		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student.newScreen1();
				frame.dispose();
			}
		});
		btnBack.setBounds(345, 237, 89, 23);
		frame.getContentPane().add(btnBack);


		btnNewButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String amount = textField_3.getText();

				Connection con = null;
				Statement stmt2 = null;
				try
				{
					con = new SQLConnection().getConnection();

					String SQL2 = "INSERT INTO payment(StudentId, Paid) VALUES('"+currentUser.id+"', " + Float.parseFloat(amount) + ")";
					stmt2 = con.createStatement();
					stmt2.executeUpdate(SQL2);


					label.setText(String.valueOf(amount));
					JOptionPane.showMessageDialog(null, "Sucessfull Payment");

				}
				catch (Exception e) {
					e.printStackTrace();
				}

			}

		});
	}

	public ArrayList<addTuition> userList(){
		ArrayList<addTuition> usersList=new ArrayList<>();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Statement stmt2 = null;
		ResultSet rs2 = null;
		try
		{
			con = new SQLConnection().getConnection();

//			String SQL = "SELECT c.* FROM student_course sc JOIN course c ON c.id = sc.CourseId WHERE StudentId = " + currentUser.id;
			String SQL = "SELECT SUM(amount) AS tuition, Semester FROM tuition WHERE StudentId='"+currentUser.id+"' GROUP BY Semester";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			addTuition list;
			while(rs.next())
			{
				list=new addTuition(rs.getString("Semester"), rs.getFloat("tuition"));
				debt = debt + rs.getFloat("tuition");
				usersList.add(list);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public ArrayList<addPayment> userList2(){
		ArrayList<addPayment> usersList2=new ArrayList<>();

		Connection con = null;
		Statement stmt2 = null;
		ResultSet rs2 = null;
		try
		{
			con = new SQLConnection().getConnection();

//			tuitiion = 3000; query
//			already_paid = 500; query
//			tuition - already_paid = debt 2500


			String SQL2 = "SELECT StudentId, SUM(paid) AS paid FROM payment WHERE StudentId='"+currentUser.id+"' GROUP BY StudentId		";
			stmt2 = con.createStatement();
			rs2 = stmt2.executeQuery(SQL2);
			addPayment list2;

			if(rs2.isBeforeFirst()) {
				while(rs2.next())
				{
					list2=new addPayment(rs2.getString("StudentId"), rs2.getFloat("paid"));
					usersList2.add(list2);
				}
			}


		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return usersList2;
	}

	public void show_list()
	{
		ArrayList<addTuition> list_1= userList();
		ArrayList<addPayment> list_2= userList2();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		Object[] row=new Object[3];
		String dueDate = null;
		float paid;



		for(int i=0;i<list_1.size();i++)
		{
			System.out.println(list_1.get(i).getSemester());

			if(list_1.get(i).getSemester().equalsIgnoreCase("Winter18")){
				dueDate = "January 31";
			}else if(list_1.get(i).getSemester().equalsIgnoreCase("Summer18")){
				dueDate = "May 31";
			}else if(list_1.get(i).getSemester().equalsIgnoreCase("Fall17")){
				dueDate = "September 31";
			};

			System.out.println(dueDate);

			row[0]=list_1.get(i).getSemester();
			row[1]=list_1.get(i).getTuition();
			row[2]=dueDate;

			model.addRow(row);
		}

//		insert empty rows
		for(int i=0;i<2;i++){
			row[0]="";
			row[1]="";
			row[2]="";
			model.addRow(row);
		}
System.out.println("DEBT: " + debt);
		if(!list_2.isEmpty()){
			System.out.println(list_2.get(0).getPaid());
			System.out.println((debt - list_2.get(0).getPaid()));
			float debt2 = (debt - list_2.get(0).getPaid());
			row[0]="Paid: " + list_2.get(0).getPaid();
			row[1]="";
			row[2]="Debt: " + String.valueOf(debt2) + " $";
		} else {
			row[0]="Paid: 0.00 $";
			row[1]="";
			row[2]="Debt: " + debt + " $";
		}
		model.addRow(row);

	}

}
