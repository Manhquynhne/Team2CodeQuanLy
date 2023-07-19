package ShowInf;


import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.util.Duration;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;


public class HienThiView extends JFrame {

    private JPanel contentPane;
    public static HienThiView frame;
    private JTextField textField;
    private static Second second;
    private static final int WINDOWS_WIDTH = 1208;
    private static final int WINDOWS_HEIGHT = 720;
    private static final int PADDING_UNIT = 16;

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
        String data = docDuLieu("D:\\Nội dung\\Chim công.txt"); // đổi cái này lại luôn nhỉ
        second.labelHienThiSecond.setText("<html><font face='Times New Roman' size='5'" + data + "</html>");

    }
    public static void docDuLieuTable() {
        String filePath = "Zoo_Manager/src/main/resources/Animal.txt";
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

    public static double getColumSize(int count){
        return (WINDOWS_WIDTH / 12f) * count;
    }

    public static void hienThiChimCanhCut() {	//test trước 1 cái thoiii nha
        // Duyên muốn hiển thị video mà hk đc... lỗi quài lun =((
        String title = "THÔNG TIN CHI TIẾT";
        String rs = docDuLieu("Zoo_Manager/src/main/resources/Chim cánh cụt.txt");
        String mess = "<html><font face='Times New Roman' size='4'" + rs + "</html>";

        EventQueue.invokeLater(() -> {
            // Tạo JFrame
            JFrame frame = new JFrame(title);
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
                String videoPath = "Zoo_Manager/src/main/resources/penguins_720p.mp4";
                Media media = new Media(new File(videoPath).toURI().toString());

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
                Text text = new Text("Cánh cụt bé tẹo");
                try {
                    text.setFont(javafx.scene.text.Font.font("Times New Roman", FontWeight.BOLD, text.getFont().getSize() * 2));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                // Thêm button
                Button buttonClose = new Button("Kết thúc");
                BorderPane borderPane = new BorderPane();
                borderPane.setBottom(buttonClose);
                BorderPane.setAlignment(buttonClose, Pos.BOTTOM_CENTER);
                //TODO: Thêm action cho nút

                // Thêm các thành phần khác vào view
                root.getChildren().add(text);
                root.getChildren().add(mediaView);
                root.getChildren().add(borderPane);
                VBox.setMargin(text, new Insets(PADDING_UNIT, 0, 0, 0));
                VBox.setVgrow(borderPane, javafx.scene.layout.Priority.ALWAYS);
                VBox.setMargin(borderPane, new Insets(0, 0, PADDING_UNIT, 0));

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
                Scene sceneRight = new Scene(layoutStack, getColumSize(8), WINDOWS_HEIGHT);

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
}
