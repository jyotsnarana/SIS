import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdvisorRegisterCourses extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    public static String StudentId;

    /**
     * Launch the application.
     */
    public static void main() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdvisorRegisterCourses frame = new AdvisorRegisterCourses();
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
    public AdvisorRegisterCourses() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
                StudentId = textField.getText();
                RegisterCourse.main();
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
