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
						"Semester","Tuition Fee", "Due Date", "Paid", "Debt"
				}
		));

		table_1.setRowSelectionAllowed(true);
		scrollPane.setViewportView(table_1);


		JLabel lblCardno = new JLabel("CardNo.");
		lblCardno.setBounds(41, 150, 70, 14);
		frame.getContentPane().add(lblCardno);

		JLabel lbldigitno = new JLabel("3-digitNo.");
		lbldigitno.setBounds(41, 175, 70, 14);
		frame.getContentPane().add(lbldigitno);

		JLabel lblAmount = new JLabel("Amount ");
		lblAmount.setBounds(41, 200, 70, 14);
		frame.getContentPane().add(lblAmount);

		card_Field = new JTextField();
		card_Field.setColumns(10);
		card_Field.setBounds(171, 147, 231, 20);
		frame.getContentPane().add(card_Field);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(171, 172, 70, 20);
		frame.getContentPane().add(textField_2);

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
                 int t_fee= (Integer.valueOf(label.getText()).intValue())-(Integer.valueOf(textField_3.getText()).intValue());
				 label.setText(String.valueOf(t_fee));
				 JOptionPane.showMessageDialog(null, "Sucessfull Payment");

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
			String SQL = "SELECT SUM(amount)  AS tuition, Semester FROM tuition WHERE StudentId='"+currentUser.id+"' GROUP BY Semester";
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			addTuition list;
			while(rs.next())
			{
				list=new addTuition(rs.getString("Semester"), rs.getFloat("tuition"));
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

			String SQL2 = "SELECT * FROM payment WHERE StudentId='"+currentUser.id+"' ";
			stmt2 = con.createStatement();
			rs2 = stmt2.executeQuery(SQL2);
			addPayment list2;
			while(rs2.next())
			{
				list2=new addPayment(rs2.getString("StudentId"), rs2.getFloat("Paid"), rs2.getFloat("Debt"));
				usersList2.add(list2);
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
		float debt, paid;



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
//			System.out.println(dueDate);
			row[0]=list_1.get(i).getSemester();
			row[1]=list_1.get(i).getTuition();
			row[2]=dueDate;

			model.addRow(row);
		}
	}

}
