import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Tutition_fee extends JFrame {
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
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
		frame.setTitle("Tutition Fee");
		
		JLabel lblNewLabel = new JLabel("DUE:");
		lblNewLabel.setBounds(41, 11, 36, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(41, 78, 70, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblCardno = new JLabel("CardNo.");
		lblCardno.setBounds(41, 109, 70, 14);
		frame.getContentPane().add(lblCardno);
		
		JLabel lbldigitno = new JLabel("3-digitNo.");
		lbldigitno.setBounds(41, 134, 70, 14);
		frame.getContentPane().add(lbldigitno);
		
		JLabel lblAmount = new JLabel("Amount ");
		lblAmount.setBounds(41, 159, 70, 14);
		frame.getContentPane().add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(171, 75, 231, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(171, 106, 231, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(171, 131, 70, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(171, 159, 86, 20);
		frame.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.setBounds(171, 209, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("234");
		label.setBounds(171, 19, 46, 14);
		frame.getContentPane().add(label);
		
		btnNewButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {
                // String t_fee= (Integer.valueOf(label.getText()).intValue())-(Integer.valueOf(textField_3.getText()).intValue());
				 //label.setText(t_fee);
				}
		});
	}
}
