package test;// TimKiem.java
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class timKiem {

    // hàm kiểm tra xem chuỗi này có phải là số hay chuỗi số không, hay là chuỗi kí tự sau đó phân ra từng hàm tìm kiếm riêng đối với chuỗi số và chuỗi kí tự.
    public static List<Animal> timKiemTheoChuoi(List<Animal> animals, String tenCanTim) {
        List<Animal> foundAnimals = new ArrayList<>();
            boolean timThay = false;

            for (Animal animal : animals) {
                if (animal.getName().toLowerCase().contains(tenCanTim.toLowerCase())
                        || animal.getRegnum().toLowerCase().contains(tenCanTim.toLowerCase())
                        || animal.getClas().toLowerCase().contains(tenCanTim.toLowerCase())
                        || animal.getInfraclass().toLowerCase().contains(tenCanTim.toLowerCase())
                        || animal.getBranch().toLowerCase().contains(tenCanTim.toLowerCase())
                        || animal.getOrdo().toLowerCase().contains(tenCanTim.toLowerCase())
                        || animal.getFamilia().toLowerCase().contains(tenCanTim.toLowerCase())
                        || animal.getInformation().toLowerCase().contains(tenCanTim.toLowerCase())) {
                    foundAnimals.add(animal);
                }

            if (!timThay) {
                System.out.println("Không tìm thấy loài chim có tên chứa: " + tenCanTim);
            }
        }
            return foundAnimals;
    }
    public static void xuat(Animal animal) {

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("THÔNG TIN LOÀI CHIM CẦN TÌM")
                .append("\nTên: ").append(animal.getName())
                .append("\nBộ: ").append(animal.getRegnum())
                .append("\nNghành: ").append(animal.getClas())
                .append("\nLớp: ").append(animal.getInfraclass())
                .append("\nNhánh: ").append(animal.getBranch())
                .append("\nHọ: ").append(animal.getOrdo())
                .append("\nChi: ").append(animal.getFamilia())
                .append("\n").append(animal.getInformation())
                .append("\n----------------------\n");

        System.out.println(resultBuilder.toString());

        JFrame frame = new JFrame("Thông tin Loài Chim Tìm Được");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setText(resultBuilder.toString());

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        frame.setVisible(true);


    /*    System.out.println("THÔNG TIN LOÀI CHIM CẦN TÌM");
        System.out.println("Tên: " + animal.getName());
        System.out.println("Bộ: " + animal.getRegnum());
        System.out.println("Nghành: " + animal.getClas());
        System.out.println("Lớp: " + animal.getInfraclass());
        System.out.println("Nhánh: " + animal.getBranch());
        System.out.println("Họ: " + animal.getOrdo());
        System.out.println("Chi: " + animal.getFamilia());
        System.out.println(animal.getInformation());
        System.out.println("----------------------");*/
    }
}