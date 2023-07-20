package test;
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class read {

    public static List<test.Animal> loadAnimal() {
        String line = "";
        List<test.Animal> list = new ArrayList();

        try {
            FileReader fr = new FileReader("D:\\JAVA code\\Team2CodeQuanLy\\Zoo_Manager\\src\\main\\java\\test_timkiem\\canhCut.txt");
            BufferedReader br = new BufferedReader(fr);
            while(true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }

                String[] a = line.split(";");
                String ten = a[0];
                String gioi = a[1];
                String nghanh = a[2];
                String lop = a[3];
                String bo = a[4];
                String ho = a[5];
                String chi = a[6];
                String loai = a[7];
                String chiTiet = a[8];
                Double calo = Double.parseDouble(a[9]);
                list.add(new test.Animal(ten, gioi, nghanh, lop, bo, ho, chi, loai, chiTiet, calo));
            }
        } catch (Exception var18) {
        }
        return list;
    }
}
