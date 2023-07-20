package test;// TimKiem.java
import java.util.List;

public class timKiem {

    // hàm kiểm tra xem chuỗi này có phải là số hay chuỗi số không, hay là chuỗi kí tự sau đó phân ra từng hàm tìm kiếm riêng đối với chuỗi số và chuỗi kí tự.
    public static List<Animal> timKiemTheoChuoi(List<Animal> animals, String tenCanTim) {
            timKiemTenLoaiChim(animals, tenCanTim);
        return animals;
    }

    //
    private static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void timKiemTenLoaiChim(List<Animal> animals, String tenCanTim) {
        boolean timThay = false;

        for (Animal animal : animals) {
            if (animal.getName().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue; // tìm tiếp những con vật khác xem có giống thông tin cần tìm không.
            }  else if (animal.getName().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getRegnum().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getClas().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getInfraclass().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getBranch().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getOrdo().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getFamilia().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getInformation().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy loài chim có tên chứa: " + tenCanTim);
        }
    }

    public static void xuat(Animal animal) {
        System.out.println("THÔNG TIN LOÀI CHIM CẦN TÌM");
        System.out.println("Tên: " + animal.getName());
        System.out.println("Bộ: " + animal.getRegnum());
        System.out.println("Nghành: " + animal.getClas());
        System.out.println("Lớp: " + animal.getInfraclass());
        System.out.println("Nhánh: " + animal.getBranch());
        System.out.println("Họ: " + animal.getOrdo());
        System.out.println("Chi: " + animal.getFamilia());
        System.out.println(animal.getInformation());
        System.out.println("----------------------");
    }
}