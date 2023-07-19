package ShowInf;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class Second extends JFrame {


	public JTextField textFieldTim;
	private JPanel contentPane;
	public static JLabel labelHienThiSecond;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton buttonTable;

	/**
	 * Launch the application.
	 */
	public static Second frameSecond;
	public static JTable table;
	private Third third;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					frameSecond = new Second();

					frameSecond.setLocationRelativeTo(null);
					frameSecond.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Second() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1432, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Hiển thị ");
		btnNewButton.setBackground(new Color(255, 255, 255));
		ActionListener ac = new Controller(this);
		btnNewButton.addActionListener(ac);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(1058, 651, 124, 39);
		contentPane.add(btnNewButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(793, 96, 615, 516);
		contentPane.add(scrollPane);

		labelHienThiSecond = new JLabel("Thông tin");
		scrollPane.setViewportView(labelHienThiSecond);
		labelHienThiSecond.setBackground(new Color(64, 0, 64));
		labelHienThiSecond.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(74, 203, 589, 289);
		contentPane.add(scrollPane_1);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã", "Tên" }));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		table.getSelectionModel().addListSelectionListener(new Controller(this));
		table.setRowHeight(30);
		

		scrollPane_1.setViewportView(table);

		buttonTable = new JButton("TABLE");
		buttonTable.addActionListener(ac);
		buttonTable.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		buttonTable.setBounds(242, 653, 111, 39);
		contentPane.add(buttonTable);

		JLabel labelThongBao = new JLabel("*Chọn chim cánh cụt thoiii nha mấy kia ch làm=)) *");
		labelThongBao.setForeground(new Color(0, 0, 204));
		labelThongBao.setBackground(new Color(0, 206, 209));
		labelThongBao.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		labelThongBao.setBounds(298, 173, 366, 20);
		contentPane.add(labelThongBao);

		JLabel labelThongBaoThem = new JLabel("*Chỗ này mn có ý tưởng jk hk... tui mún để video vào mà hk đc =((((( *");
		labelThongBaoThem.setForeground(new Color(0, 0, 204));
		labelThongBaoThem.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		labelThongBaoThem.setBounds(956, 57, 455, 20);

		contentPane.add(labelThongBaoThem);

		JButton buttonHome = new JButton("Home");
		buttonHome.setFont(new Font("Times New Roman", Font.BOLD, 25));
		buttonHome.addActionListener(ac);
		buttonHome.setBounds(10, 10, 96, 35);
		getContentPane().add(buttonHome);

	}
	public void hienThiGiaoDienSLSK() {
		third = new Third();
		third.setLocationRelativeTo(null);
		third.setVisible(true);
	}

	public static String docDuLieu(String fileName) {

		String value = new File(fileName).getAbsolutePath();
		char find = '\\';
		char rep = '/';
		String kq = value.replace(find, rep);
		File f = new File(kq);
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
		String result = docDuLieu("Chim cánh cụt.txt");
		labelHienThiSecond.setText("<html><font face='Times New Roman' size='5'" + result + "</html>");

	}
//	public static String getThongTinCanTim() {
//		String kq = second.textFieldTim.getText();
//		return kq;
//	}

	public static void docDuLieuTable() {
		String filePath = "D:\\Nội dung\\Animal.txt";
		DefaultTableModel model_table1 = (DefaultTableModel)  table.getModel();

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

	public void hienThiSLSK() {
		String result = docDuLieu("slskchim.txt");
		third.labelSLSK.setText("<html><font face='Times New Roman' size='5'" + result + "</html>");
	}
	public static void hienThiChimCanhCut() { // test trước 1 cái thoiii nha
		ImageIcon icon = new ImageIcon("C:\\Users\\nguye\\Downloads\\canhCut.jpg");
		// Duyên muốn hiển thị video mà hk đc... lỗi quài lun =((
		String title = "THÔNG TIN CHI TIẾT";
		String rs = docDuLieu("Chim cánh cụt.txt");
		String mess = "<html><font face='Times New Roman' size='4'" + rs + "</html>";
		JOptionPane.showMessageDialog(null, mess, title, JOptionPane.INFORMATION_MESSAGE, icon);
	}
}
