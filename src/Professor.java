import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblProfessor = new JLabel("Professor");
		lblProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblProfessor, BorderLayout.CENTER);
	}

}
