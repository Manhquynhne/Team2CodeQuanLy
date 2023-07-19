package Home;

import ShowInf.HienThiView;
import ShowInf.Second;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AnimalManagementInterface extends JFrame {
    private JPanel homePanel, searchPanel, listPanel;
    private JButton homeButton, searchButton, listButton;
    private JTextField searchField;
    private JList<Animal> animalJList;
    private DefaultListModel<Animal> animalListModel;
    private List<Animal> animalList;
    private JButton homeButton_1;

    public AnimalManagementInterface() {
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
        homePanel = new JPanel();
        homePanel.setLayout(null);
        JLabel label = new JLabel("Trang chủ - Chào mừng bạn đến với quản lý thú!");
        label.setBounds(0, 0, 0, 0);
        label.setHorizontalAlignment(JLabel.CENTER);
        homePanel.add(label);

        // Nút "Tìm kiếm"
        searchButton = new JButton("");
        searchButton.setBackground(new Color(128, 255, 255));
        searchButton.setIcon(new ImageIcon("D:\\5.png"));
        searchButton.setBounds(356, 252, 130, 111);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSearch();
            }
        });
        homePanel.add(searchButton);

        // Nút "Hiển thị danh sách"
        listButton = new JButton("");
        listButton.setIcon(new ImageIcon("D:\\12.png"));
        listButton.setForeground(new Color(0, 0, 0));
        listButton.setBackground(new Color(128, 255, 255));
        listButton.setBounds(0, 252, 117, 111);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showList();
            }
        });
        homePanel.add(listButton);

        // Nút "Home"
        homeButton = new JButton("");
        homeButton.setBackground(new Color(128, 255, 255));
        homeButton.setIcon(new ImageIcon("D:\\4.png"));
        homeButton.setBounds(113, 252, 117, 111);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showHome();
            }
        });
        homePanel.add(homeButton);
         homeButton_1 = new JButton("");
         homeButton_1.setIcon(new ImageIcon("D:\\13.jpg"));
         homeButton_1.setBackground(new Color(128, 255, 255));
        homeButton_1.setBounds(240, 252, 117, 111);
        homePanel.add(homeButton_1);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nguye\\Documents\\Zalo Received Files\\9.jpg"));
        lblNewLabel.setBounds(0, 0, 486, 363);
        homePanel.add(lblNewLabel);
        
       
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

    public void showHome() {
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
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Second frame = new Second();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
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
                new AnimalManagementInterface();
            }
        });
    }
}
