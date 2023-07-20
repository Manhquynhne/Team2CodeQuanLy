package Home;


import test.timKiem;
import test.Animal;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.util.Duration;



import ShowInf.Second;
import ShowInf.Third;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AnimalManagementInterface extends JFrame {
    private static final int WINDOWS_WIDTH = 1208;
    private static final int WINDOWS_HEIGHT = 720;
    private static final int PADDING_UNIT = 16;
    private JPanel homePanel, searchPanel, listPanel;
    private JButton healthButton, searchButton, listButton,  staffButton;
    private JTextField searchField;
    private JList<Animal> animalJList;
    private DefaultListModel<Animal> animalListModel;
    private List<Animal> animalList;
    Second second;


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
        searchButton.setIcon(new ImageIcon("Zoo_Manager/src/main/resources/5.jpg"));
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
        listButton.setIcon(new ImageIcon("Zoo_Manager/src/main/resources/6.jpg"));
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

        // Nút SLSK
        healthButton = new JButton("");
        healthButton.setBackground(new Color(128, 255, 255));


        healthButton.setIcon(new ImageIcon("Zoo_Manager/src/main/resources/slsk.jpg"));
        healthButton.setBounds(113, 252, 117, 111);
        healthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Third third = new Third();
                third.setLocationRelativeTo(null);
                third.setTitle("THÔNG TIN SỐ LIỆU SỨC KHỎE");
                third.setVisible(true);
                String result = second.docDuLieu("Zoo_Manager/src/main/resources/slsk.txt");
                third.labelSLSK.setText("<html><font face='Times New Roman' size='5'" + result + "</html>");
            }
        });
        homePanel.add(healthButton);

        //nhân viên
        staffButton = new JButton("");
        staffButton.setIcon(new ImageIcon("Zoo_Manager/src/main/resources/13.jpg"));
        staffButton.setBackground(new Color(128, 255, 255));
        staffButton.setBounds(240, 252, 117, 111);
        homePanel.add(staffButton);
        staffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("Zoo_Manager/src/main/resources/nhanVien.jpg");
                String title = "THÔNG TIN NHÂN VIÊN";
                String rs = second.docDuLieu("Zoo_Manager/src/main/resources/infonhanvien.text.txt");
                String mess = "<html><font face='Times New Roman' size='5'" + rs + "</html>";
                JOptionPane.showMessageDialog(null, mess, title, JOptionPane.INFORMATION_MESSAGE,icon);

            }
        });

        //hình nền
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("Zoo_Manager/src/main/resources/9.jpg"));
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
        timKiemTheoChuoi(keyword);
        // Ví dụ: Lấy kết quả tìm kiếm và cập nhật danh sách thú
   //     List<Animal> searchResult = new ArrayList<>();
        List<Animal> searchResult = timKiem.timKiemTheoChuoi(animalList, keyword);

   /*     for (Animal animal : animalList) {
            if (animal.getName().toLowerCase().contains(keyword.toLowerCase())) {
                searchResult.add(animal);
            }
        }*/
        updateAnimalList(searchResult);
        showList();
    }

    public void timKiemTheoChuoi(String thongTinCanTim) {
        timKiem.timKiemTheoChuoi(animalList, thongTinCanTim);
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

    public static double getColumSize(int count) {
        return (WINDOWS_WIDTH / 12f) * count;
    }

    public static void hienThiVideo(String path, String title, String mess) {
        EventQueue.invokeLater(() -> {
            // Tạo JFrame
            JFrame frame = new JFrame("THÔNG TIN CHI TIẾT");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT);

            // Tạo một JFXPanel để nhúng Scene JavaFX vào JFrame
            JFXPanel fxPanelLeft = new JFXPanel();
            frame.add(fxPanelLeft, BorderLayout.LINE_START);

            // Thêm nội dung bên phải
            JFXPanel fxPanelRight = new JFXPanel();
            frame.add(fxPanelRight, BorderLayout.LINE_END);

            // Hiển thị JFrame
            frame.setVisible(true);

            // Khởi chạy nền JavaFX
            Platform.runLater(() -> {

                // Tạo một đối tượng Media với đường dẫn tới file video

                Media media = new Media(new File(path).toURI().toString());

                // Tạo một đối tượng MediaPlayer từ Media
                MediaPlayer mediaPlayer = new MediaPlayer(media);

                // Đặt sự kiện khi video kết thúc
                mediaPlayer.setOnEndOfMedia(() -> {
                    mediaPlayer.seek(Duration.ZERO); // Quay lại thời gian ban đầu
                    mediaPlayer.play(); // Chơi video lại
                });

                // Tạo một đối tượng MediaView để hiển thị video
                MediaView mediaView = new MediaView(mediaPlayer);
                mediaView.setFitWidth(getColumSize(4) - PADDING_UNIT * 2);

                // Tạo một đối tượng StackPane để chứa MediaView
                VBox root = new VBox();
                root.setAlignment(Pos.TOP_CENTER); // Đặt căn giữa theo chiều ngang
                root.setSpacing(10);

                // TODO: Cần chỉnh lại nội dung
                Text text = new Text(title);
                try {
                    text.setFont(javafx.scene.text.Font.font("Times New Roman", FontWeight.SEMI_BOLD, text.getFont().getSize() * 2));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                // Thêm button
//                Button buttonClose = new Button("Kết thúc");
//                BorderPane borderPane = new BorderPane();
//                borderPane.setBottom(buttonClose);
//                BorderPane.setAlignment(buttonClose, Pos.BOTTOM_CENTER);
                //TODO: Thêm action cho nút

                // Thêm các thành phần khác vào view
                root.getChildren().add(text);
                root.getChildren().add(mediaView);
              //  root.getChildren().add(borderPane);
                VBox.setMargin(text, new Insets(PADDING_UNIT, 0, 0, 0));
//                VBox.setVgrow(borderPane, javafx.scene.layout.Priority.ALWAYS);
//                VBox.setMargin(borderPane, new Insets(0, 0, PADDING_UNIT, 0));

                // Tạo một Scene với VBOX làm nội dung
                Scene scene = new Scene(root, getColumSize(4), WINDOWS_HEIGHT);

                // Đặt Scene vào JFXPanel
                fxPanelLeft.setScene(scene);

                // Bắt đầu phát video
                mediaPlayer.play();

                // Show nội dung bài viết
                WebView contentView = new WebView();

                contentView.getEngine().loadContent(mess);

//                // TODO: Tạo một ScrollPane và đặt WebView làm nội dung
//                ScrollPane scrollPane = new ScrollPane(); // Không chạy được rồi :|
//                scrollPane.setContent(contentView);

                StackPane layoutStack = new StackPane();
//                layoutVbox.setAlignment(Pos.TOP_LEFT); // Đặt căn giữa theo chiều ngang
                layoutStack.getChildren().add(contentView);
                Scene sceneRight = new Scene(layoutStack, getColumSize(7), WINDOWS_HEIGHT);

//                 Đặt chiều cao của WebView để lấp đầy chiều cao của không gian hiển thị
                layoutStack.setMinHeight(scene.getHeight());
                layoutStack.setMaxHeight(scene.getHeight());
                contentView.setMaxHeight(scene.getHeight());
                contentView.setMinHeight(scene.getHeight());

                // Xử lý sự kiện khi kích thước của cửa sổ thay đổi
                scene.heightProperty().addListener((observable, oldValue, newValue) -> {
                    layoutStack.setMinHeight(newValue.doubleValue());
                    layoutStack.setMaxHeight(newValue.doubleValue());
                    contentView.setMinHeight(newValue.doubleValue());
                    contentView.setMaxHeight(newValue.doubleValue());
                });

                fxPanelRight.setScene(sceneRight);
            });
        });
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
