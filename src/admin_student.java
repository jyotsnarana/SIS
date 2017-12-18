import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_student {

	private JFrame frame;
	private JTextField textField;

	/**
	 * frame used to get studentid by admin to access the account of student.
	 * @author jyotsna
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_student window = new admin_student();
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
	public admin_student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Student Login");
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setBounds(187, 76, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblStudentid = new JLabel("StudentID:");
		lblStudentid.setBounds(111, 79, 66, 14);
		frame.getContentPane().add(lblStudentid);

		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student.newScreen1();
			}
		});
		btnGo.setBounds(152, 146, 89, 23);
		frame.getContentPane().add(btnGo);
	}
}
