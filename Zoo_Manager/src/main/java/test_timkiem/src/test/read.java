package test;//
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
            FileReader fr = new FileReader("D:\\JAVA code\\test_timkiem\\zoo.txt");
            BufferedReader br = new BufferedReader(fr);
            while(true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }

                String[] a = line.split(";");
                int ma = Integer.parseInt(a[0]);
                String ten = a[1];
                int age = Integer.parseInt(a[2]);
                String loai = a[3];
                String xuat = a[4];
                String ngay = a[5];
                String tinhtrang = a[6];
                String work = a[7];
                String food = a[8];
                Double calo = Double.parseDouble(a[9]);
                list.add(new test.Animal(ma, ten, age, loai, xuat, ngay, tinhtrang, work, food, calo));
            }
        } catch (Exception var18) {
        }
    return list;
    }
}
