import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewStudentTranscript extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudentTranscript frame = new ViewStudentTranscript();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewStudentTranscript() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnView = new JButton("View");
		btnView.setBounds(149, 136, 89, 23);
		contentPane.add(btnView);
		btnView.addActionListener(new ActionListener() 
		{
			  
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Transcript.transcript();
			}	
			});
		
		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setBounds(99, 72, 76, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(197, 69, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
