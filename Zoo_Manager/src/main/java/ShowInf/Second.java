package ShowInf;

import Home.AnimalManagementInterface;

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
		setBounds(100, 100, 750, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ActionListener ac = new Controller(this);
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(74, 100, 600, 500);
		contentPane.add(scrollPane_1);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã", "Tên" }));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		table.getSelectionModel().addListSelectionListener(new Controller(this));
		table.setRowHeight(30);
		

		scrollPane_1.setViewportView(table);

		buttonTable = new JButton("HIỂN THỊ DANH SÁCH");
		buttonTable.addActionListener(ac);
		buttonTable.setFont(new Font("Times New Roman", Font.BOLD, 25));
		buttonTable.setBounds(200, 650, 300, 39);
		contentPane.add(buttonTable);



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

	public static String docDuLieu(String path) {

		//TODO: LẤY ĐƯỜNG DẪN TƯƠNG ĐỐI
//		String value = new File(fileName).getAbsolutePath();
//		char find = '\\';
//		char rep = '/';
//		String kq = value.replace(find, rep);
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

	public static void docDuLieuTable() {
		String filePath = "Zoo_Manager/src/main/resources/Animal.txt";
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

	public static void hienThiChimCanhCut() {
		String title = "THÔNG TIN CHIM CÁNH CỤT";
		String rs = docDuLieu("Zoo_Manager/src/main/resources/chimcanhcut.txt");
		String mess = "<html><font face='Times New Roman' size='4'" + rs + "</html>";
		AnimalManagementInterface.hienThiVideo("Zoo_Manager/src/main/resources/penguins_720p.mp4",title,mess);
	}
	public static void hienThiChimChaoMao() {
		String title = "THÔNG TIN CHIM CHÀO MÀO";
		String rs = docDuLieu("Zoo_Manager/src/main/resources/chimchaomao.txt");
		String mess = "<html><font face='Times New Roman' size='4'" + rs + "</html>";
		AnimalManagementInterface.hienThiVideo("Zoo_Manager/src/main/resources/chaomao.mp4",title,mess);
	}
	public static void hienThiChimCong() {
		String title = "THÔNG TIN CHIM CÔNG";
		String rs = docDuLieu("Zoo_Manager/src/main/resources/chimhoetrung.txt");
		String mess = "<html><font face='Times New Roman' size='4'" + rs + "</html>";
		AnimalManagementInterface.hienThiVideo("Zoo_Manager/src/main/resources/bird_-_86001 (1080p).mp4",title,mess);
	}
	public static void hienThiChimHoetRung() {
		String title = "THÔNG TIN CHIM HOÉT RỪNG";
		String rs = docDuLieu("Zoo_Manager/src/main/resources/chimhoetrung.txt");
		String mess = "<html><font face='Times New Roman' size='4'" + rs + "</html>";
		AnimalManagementInterface.hienThiVideo("Zoo_Manager/src/main/resources/hoetRung.mp4",title,mess);
	}
	public static void hienThiChimHongHac() {
		String title = "THÔNG TIN CHIM HỒNG HẠC";
		String rs = docDuLieu("Zoo_Manager/src/main/resources/chimhonghac.txt");
		String mess = "<html><font face='Times New Roman' size='4'" + rs + "</html>";
		AnimalManagementInterface.hienThiVideo("Zoo_Manager/src/main/resources/hongHac.mp4",title,mess);
	}
	public static void hienThiChimHongHoang() {
		String title = "THÔNG TIN CHIM HỒNG HOÀNG";
		String rs = docDuLieu("Zoo_Manager/src/main/resources/chimhonghoan.txt");
		String mess = "<html><font face='Times New Roman' size='4'" + rs + "</html>";
		AnimalManagementInterface.hienThiVideo("Zoo_Manager/src/main/resources/hongHoang.mp4",title,mess);
	}
	public static void hienThiChimRuoiOng() {
		String title = "THÔNG TIN CHIM RUỒI ONG";
		String rs = docDuLieu("Zoo_Manager/src/main/resources/chimruoiong.txt");
		String mess = "<html><font face='Times New Roman' size='4'" + rs + "</html>";
		AnimalManagementInterface.hienThiVideo("Zoo_Manager/src/main/resources/ruoiOng.mp4",title,mess);
	}
	public static void hienThiChimSeuDauDo() {
		String title = "THÔNG TIN CHIM SẾU ĐẦU ĐỎ";
		String rs = docDuLieu("Zoo_Manager/src/main/resources/chimseudaudo.txt");
		String mess = "<html><font face='Times New Roman' size='4'" + rs + "</html>";
		AnimalManagementInterface.hienThiVideo("Zoo_Manager/src/main/resources/seuDauDo.mp4",title,mess);
	}
	public static void hienThiChimCoDo() {
		String title = "THÔNG TIN CHIM CỔ ĐỎ";
		String rs = docDuLieu("Zoo_Manager/src/main/resources/chimcodo.txt");
		String mess = "<html><font face='Times New Roman' size='4'" + rs + "</html>";
		AnimalManagementInterface.hienThiVideo("Zoo_Manager/src/main/resources/coDo.mp4",title,mess);
	}
	public static void hienThiChimVetMacaw() {
		String title = "THÔNG TIN CHIM VẸT MACAW";
		String rs = docDuLieu("Zoo_Manager/src/main/resources/chimvetmacaw.txt");
		String mess = "<html><font face='Times New Roman' size='4'" + rs + "</html>";
		AnimalManagementInterface.hienThiVideo("Zoo_Manager/src/main/resources/vetMaCaw.mp4",title,mess);
	}





}
