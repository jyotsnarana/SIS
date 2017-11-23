
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Professor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newScreen2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Professor window = new Professor();
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
	public Professor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Professor");
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Post Grades");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(123, 81, 206, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnChangeGrades = new JButton("Change Grades");
		btnChangeGrades.setBounds(123, 134, 206, 23);
		frame.getContentPane().add(btnChangeGrades);
		btnChangeGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangeGrade.changeGrade();
			}
		});
	
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(36, 25, 337, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
