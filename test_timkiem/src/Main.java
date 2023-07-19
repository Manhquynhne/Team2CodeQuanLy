//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import test.Animal;
import test.timKiem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        int ID;
        String name;
        int age;
        String loai;
        String xuat;
        String ngay;
        String tinhtrang;
        String work;
        String food;
        Double calo;
        try {
            FileReader fr = new FileReader("D:\\JAVA code\\test_timkiem\\zoo.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
               String a[] = line.split(";");
                ID = Integer.parseInt(a[0]);
                name= a[1];
                age= Integer.parseInt(a[2]);
                loai=a[3];
                xuat=a[4];
                ngay=a[5];
                tinhtrang=a[6];
                work=a[7];
                food=a[8];
                calo = Double.parseDouble(a[9]);
                Animal animal = new Animal(ID,name,age,loai,xuat,ngay,tinhtrang,work,food,calo);
                animals.add(animal);
            }

            br.close();

        }catch (Exception e) {}

    /*    for (Animal animal : animals) {
            System.out.println("ID: " + animal.getID());
            System.out.println("Tên: " + animal.getName());
            System.out.println("Tuổi: " + animal.getAge());
            System.out.println("Loài: " + animal.getTenLoai());
            System.out.println("Xuất xứ: " + animal.getXuatXu());
            System.out.println("Ngày đến: " + animal.getNgayDen());
            System.out.println("Tình trạng: " + animal.getTinhTrangSucKhoe());
            System.out.println("Nơi làm việc: " + animal.getNoiLamViec());
            System.out.println("Lượng thức ăn tiêu thụ: " + animal.getThucAn());
            System.out.println("Lượng calo hấp thụ/ngày: " + animal.getluongCaloHapThuNgay());
            System.out.println("----------------------");
        }*/

        // Tìm kiếm loài chim cụ thể
        System.out.print("Nhập tên loài chim cần tìm: ");
        Scanner sc = new Scanner(System.in);
        String tenCanTim = sc.nextLine();
        timKiem.timKiemTheoChuoi(animals, tenCanTim);
    }
}

