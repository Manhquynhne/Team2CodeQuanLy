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
            FileReader fr = new FileReader("D:\\JAVA code\\Team2CodeQuanLy\\Zoo_Manager\\src\\main\\java\\test\\canhCut.txt");
            BufferedReader br = new BufferedReader(fr);
            while(true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }

                String[] a = line.split(";");
                String name = a[0];
                String regnum = a[1];
                String clas = a[2];
                String infraclass = a[3];
                String branch = a[4];
                String ordo = a[5];
                String familia = a[6];
                String information = a[7];
                list.add(new test.Animal(name,regnum,clas,infraclass,branch,ordo,familia,information));
            }
        } catch (Exception var18) {
        }
        return list;
    }
}
