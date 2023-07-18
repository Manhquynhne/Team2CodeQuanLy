package ShowInf;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class HienThiView extends JFrame {

    private JPanel contentPane;
    public static HienThiView frame;
    private JTextField textField;
    private static Second second;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    frame = new HienThiView();

                    frame.setLocationRelativeTo(null);
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
    public HienThiView() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 655, 440);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton buttonHienThi = new JButton("HIỂN THỊ THÔNG TIN");
        ActionListener ac = new Controller(this);
        buttonHienThi.addActionListener(ac);
        buttonHienThi.setFont(new Font("Times New Roman", Font.BOLD, 25));
        buttonHienThi.setBounds(160, 334, 317, 39);


        contentPane.add(buttonHienThi);

    }

    public void hienThiGiaoDien() {
        second = new Second();
        second.setLocationRelativeTo(null);
        second.setVisible(true);
    }

    public static String docDuLieu(String path) {
        File f = new File(path);
        try {

            List<String> allText = Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);


            StringBuilder data = new StringBuilder();
            for (String string : allText) {
                data.append(string).append("<br>");
            }

            return data.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void hienThiButton() {
        String data = docDuLieu("D:\\Nội dung\\Chim công.txt");
        second.labelHienThiSecond.setText("<html><font face='Times New Roman' size='5'" + data + "</html>");

    }
    public static void docDuLieuTable() {
        String filePath = "D:\\Nội dung\\Animal.txt";
        DefaultTableModel model_table1 = (DefaultTableModel) second.table.getModel();

        while (model_table1.getRowCount() > 0) {
            model_table1.removeRow(model_table1.getRowCount() - 1);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                model_table1.addRow(data);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  static void hienThiChimCanhCut() {	//test trước 1 cái thoiii nha
        ImageIcon icon = new ImageIcon("C:\\Users\\nguye\\Downloads\\canhCut.jpg");
        // Duyên muốn hiển thị video mà hk đc... lỗi quài lun =((
        String title = "THÔNG TIN CHI TIẾT";
        String rs = docDuLieu("D:\\Nội dung\\Chim cánh cụt.txt");
        String mess = "<html><font face='Times New Roman' size='4'" + rs + "</html>";
        JOptionPane.showMessageDialog(null, mess, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
