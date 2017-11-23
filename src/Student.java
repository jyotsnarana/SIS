import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Student extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newScreen1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
					window.frame.setVisible(true);
					//window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("STUDENT");
		
		
		JButton btnTranscript = new JButton("Transcript");
		btnTranscript.setVerticalAlignment(SwingConstants.TOP);
		btnTranscript.setEnabled(true);
		btnTranscript.setBackground(Color.LIGHT_GRAY);
		btnTranscript.setBounds(42, 101, 134, 23);
		btnTranscript.addActionListener(new ActionListener() 
		{
			  
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Transcript.transcript();
			}	
			});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnTranscript);
		
		JButton btnViewGrades = new JButton("View Grades");
		btnViewGrades.setBounds(42, 135, 134, 23);
		frame.getContentPane().add(btnViewGrades);
		
		JButton btnNewButton = new JButton("Tutition Fee");
		btnNewButton.setBounds(42, 169, 134, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnViewGrades.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {

						ViewGrades.viewGrades();
						}
				});
		
		btnNewButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0) {

//				Tutition_fee fee= new Tutition_fee();
//				fee.tutitionFee();
				Tutition_fee.main(null);
				}
		});
	}
}