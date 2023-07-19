package Home;

import Home.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class hihi extends JFrame {
	private JPanel homePanel, searchPanel, listPanel;
	private JButton homeButton, searchButton, listButton;
	private JTextField searchField;
	private JList<Animal> animalJList;
	private DefaultListModel<Animal> animalListModel;
	private List<Animal> animalList;

	public hihi() {
		// Thiết lập chung của cửa sổ
		setTitle("Giao diện quản lý thú");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setLocationRelativeTo(null);

		animalList = new ArrayList<>();
		animalListModel = new DefaultListModel<>();

		// Tạo các trang giao diện
		createHomePanel();
		createSearchPanel();
		createListPanel();

		// Hiển thị trang chủ ban đầu
		showHome();

		// Hiển thị cửa sổ
		setVisible(true);
	}

	private void createHomePanel() {
		homePanel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Trang chủ - Chào mừng bạn đến với quản lý thú!");
		label.setHorizontalAlignment(JLabel.CENTER);
		homePanel.add(label, BorderLayout.CENTER);

		// Nút "Tìm kiếm"
		searchButton = new JButton("Tìm kiếm");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showSearch();
			}
		});
		homePanel.add(searchButton, BorderLayout.NORTH);

		// Nút "Hiển thị danh sách"
		listButton = new JButton("Hiển thị danh sách");
		listButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		homePanel.add(listButton, BorderLayout.CENTER);

		// Nút "Home"
		homeButton = new JButton("Home");
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showHome();
			}
		});
		homePanel.add(homeButton, BorderLayout.SOUTH);
	}

	private void createSearchPanel() {
		searchPanel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Trang tìm kiếm - Nhập từ khóa để tìm thú:");
		label.setHorizontalAlignment(JLabel.CENTER);
		searchPanel.add(label, BorderLayout.NORTH);

		searchField = new JTextField(20);
		searchPanel.add(searchField, BorderLayout.CENTER);

		JButton searchButton = new JButton("Tìm kiếm");
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				performSearch();
			}
		});
		searchPanel.add(searchButton, BorderLayout.SOUTH);
	}

	private void createListPanel() {
		listPanel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("Trang danh sách thú - Hiển thị kết quả tìm kiếm:");
		label.setHorizontalAlignment(JLabel.CENTER);
		listPanel.add(label, BorderLayout.NORTH);

		animalJList = new JList<>(animalListModel);
		JScrollPane scrollPane = new JScrollPane(animalJList);
		listPanel.add(scrollPane, BorderLayout.CENTER);

		// Nút "Home" để quay lại trang chủ
		JButton homeButton = new JButton("Home");
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showHome();
			}
		});
		listPanel.add(homeButton, BorderLayout.SOUTH);
	}

	private void showHome() {
		setContentPane(homePanel);
		invalidate();
		validate();
	}

	private void showSearch() {
		setContentPane(searchPanel);
		invalidate();
		validate();
	}

	private void performSearch() {
		String keyword = searchField.getText();
		// Thực hiện tìm kiếm ở đây...
		// Ví dụ: Lấy kết quả tìm kiếm và cập nhật danh sách thú
		List<Animal> searchResult = new ArrayList<>();
		for (Animal animal : animalList) {
			if (animal.getName().toLowerCase().contains(keyword.toLowerCase())) {
				searchResult.add(animal);
			}
		}
		updateAnimalList(searchResult);
		showList();
	}

	private void showList() {
		setContentPane(listPanel);
		invalidate();
		validate();
	}

	private void updateAnimalList(List<Animal> newList) {
		animalListModel.clear();
		for (Animal animal : newList) {
			animalListModel.addElement(animal);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new hihi();
			}
		});
	}
}
