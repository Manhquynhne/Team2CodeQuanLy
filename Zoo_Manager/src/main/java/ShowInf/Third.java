package ShowInf;

import Home.AnimalManagementInterface;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Third extends JFrame {

    private JLabel labelBS;

    private JPanel contentPane;
    public JLabel labelSLSK;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Third frame = new Third();
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
    public Third() {
        setTitle("THÔNG TIN SỐ LIỆU SỨC KHỎE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1010, 601);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 524, 544);
        contentPane.add(scrollPane);

        labelSLSK = new JLabel("New label");
        labelSLSK.setFont(new Font("Times New Roman", Font.PLAIN, 18));

        labelBS = new JLabel();
        labelBS.setBounds(570, 27, 539, 540);
        contentPane.add(labelBS);

        labelBS.setIcon(new ImageIcon("Zoo_Manager/src/main/resources/BS.jpg"));


        scrollPane.setViewportView(labelSLSK);
    }
}
