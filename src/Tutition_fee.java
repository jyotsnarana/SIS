import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	 * @author Parisa
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
}
