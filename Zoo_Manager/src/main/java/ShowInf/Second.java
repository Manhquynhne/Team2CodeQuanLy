package ShowInf;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

public class Second extends JFrame {

	private JPanel contentPane;
	public JLabel labelHienThiSecond;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton buttonTable;

	/**
	 * Launch the application.
	 */
	public static Second frameSecond;
	public JTable table;
	private JLabel lblNewLabel;

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


	}
}
