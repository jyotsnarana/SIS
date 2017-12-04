import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Tutition_fee extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField card_Field;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * frame used to pay the tutition fee by the student.
	 * @author jyotsna
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
		
		JLabel lblNewLabel = new JLabel("DUE:");
		lblNewLabel.setBounds(41, 77, 36, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(41, 126, 70, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblCardno = new JLabel("CardNo.");
		lblCardno.setBounds(41, 150, 70, 14);
		frame.getContentPane().add(lblCardno);
		
		JLabel lbldigitno = new JLabel("3-digitNo.");
		lbldigitno.setBounds(41, 175, 70, 14);
		frame.getContentPane().add(lbldigitno);
		
		JLabel lblAmount = new JLabel("Amount ");
		lblAmount.setBounds(41, 200, 70, 14);
		frame.getContentPane().add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(171, 123, 231, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
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
		
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setBounds(31, 34, 70, 14);
		frame.getContentPane().add(lblStudentId);
		
		textField_4 = new JTextField();
		textField_4.setBounds(171, 31, 121, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Go");
		btnNewButton_1.setBounds(302, 30, 59, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student.newScreen1();
				frame.dispose();
			}
		});
		btnBack.setBounds(345, 237, 89, 23);
		frame.getContentPane().add(btnBack);
		btnNewButton_1.addActionListener(new ActionListener() {
			  
			@Override
			public void actionPerformed(ActionEvent arg0) {
		if(textField_4.getText().equalsIgnoreCase("40013246")) 
		{
			label.setText("6500");
		}
		else if(textField_4.getText().equalsIgnoreCase("40014804"))
		{
			label.setText("650");
		}
			}
		});
		btnNewButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
                 int t_fee= (Integer.valueOf(label.getText()).intValue())-(Integer.valueOf(textField_3.getText()).intValue());
				 label.setText(String.valueOf(t_fee));
				 JOptionPane.showMessageDialog(null, "Sucessfull Payment"); 
				// textField_3.disable();
				}
			
		});
	}
}
