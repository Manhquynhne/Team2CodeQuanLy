package Icon_timKiem.src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;


public class BaoBaoView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaoBaoView frame = new BaoBaoView();
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
	public BaoBaoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(84, 82, 216, 50);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton buttonTim = new JButton("Tìm");
//		ActionListener ac = new BaoBaoControll(this);// add cái xử lí sự kiện cho cái nút tìm
//		buttonTim.addActionListener(ac);
		buttonTim.setFont(new Font("Times New Roman", Font.BOLD, 30));
		buttonTim.setBounds(332, 83, 110, 34);
		contentPane.add(buttonTim);

		BaoBaoControll controller = new BaoBaoControll(this);// add cái xử lí sự kiện cho cái nút tìm
		buttonTim.addActionListener(controller);
	}

	public String getThongTinCanTim() {
		return textField.getText();
	}
}
