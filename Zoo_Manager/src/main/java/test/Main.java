package test;//
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
        String regnum;
        String clas;
        String infraclass;
        String branch;
        String ordo;
        String familia;
        String information;
        try {
            FileReader fr = new FileReader("D:\\JAVA code\\Team2CodeQuanLy\\Zoo_Manager\\src\\main\\java\\test\\canhCut.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
               String a[] = line.split(";");
                name= a[0];
                regnum = a[1];
                clas = a[2];
                infraclass = a[3];
                branch = a[4];
                ordo = a[5];
                familia = a[6];
                information = a[7];
                Animal animal = new Animal(name,regnum,clas,infraclass,branch,ordo,familia,information);
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

