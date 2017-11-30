

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Admin extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
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
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("ADMIN");
		frame.getContentPane().setLayout(null);
		JLabel lblAdmin = new JLabel("");
		lblAdmin.setBounds(0, 0, 434, 261);
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblAdmin);
		
		JButton btnViewTranscript = new JButton("View Transcript");
		btnViewTranscript.setBounds(27, 186, 144, 23);
		frame.getContentPane().add(btnViewTranscript);
		
		JButton btnChangeClassCapacity = new JButton("Change Class Capacity");
		btnChangeClassCapacity.setBounds(27, 152, 144, 23);
		frame.getContentPane().add(btnChangeClassCapacity);
		
		JButton btnRegisterCourses = new JButton("Register Courses");
		btnRegisterCourses.setBounds(27, 118, 144, 23);
		frame.getContentPane().add(btnRegisterCourses);
		btnViewTranscript.addActionListener(new ActionListener() 
		{
			  
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				ViewStudentTranscript.main();
			}	
			});
		btnChangeClassCapacity.addActionListener(new ActionListener() 
		{
			  
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				ChangeCapacity.main(null);
			}	
			});
		btnRegisterCourses.addActionListener(new ActionListener() 
		{
			  
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				RegisterCourse.main();
			}	
			});
	}
}
