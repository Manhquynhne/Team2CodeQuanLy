package test;// TimKiem.java
import java.util.List;

public class timKiem {

    // hàm kiểm tra xem chuỗi này có phải là số hay chuỗi số không, hay là chuỗi kí tự sau đó phân ra từng hàm tìm kiếm riêng đối với chuỗi số và chuỗi kí tự.
    public static List<Animal> timKiemTheoChuoi(List<Animal> animals, String tenCanTim) {
        if (isNumber(tenCanTim)) {
            timKiemTheoCalo(animals, tenCanTim);
        } else {
            timKiemTenLoaiChim(animals, tenCanTim);
        }
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
            }  else if (animal.getGioi().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getNghanh().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getLop().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getBo().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getHo().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getChi().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getLoai().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            } else if (animal.getChiTiet().toLowerCase().contains(tenCanTim)) {
                xuat(animal);
                timThay = true;
                continue;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy loài chim có tên chứa: " + tenCanTim);
        }
    }

    public static void timKiemTheoCalo(List<Animal> animals, String tenCanTim) {
        try {
            double calo = Double.parseDouble(tenCanTim);
            boolean timThay = false;

            for (Animal animal : animals) {
                if (Double.compare(animal.getLuongCaloHapThuNgay(), calo) == 0) {
                    xuat(animal);
                    timThay = true;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Đã nhập không phải là lượng calo hấp thụ/ngày.");
        }
    }

    public static void xuat(Animal animal) {
        System.out.println("THÔNG TIN LOÀI CHIM CẦN TÌM");
        System.out.println("Tên: " + animal.getName());
        System.out.println("Bộ: " + animal.getGioi());
        System.out.println("Nghành: " + animal.getNghanh());
        System.out.println("Lớp: " + animal.getLop());
        System.out.println("Bộ: " + animal.getBo());
        System.out.println("Họ: " + animal.getHo());
        System.out.println("Chi: " + animal.getChi());
        System.out.println("Loai: " + animal.getLoai());
        System.out.println(animal.getChiTiet());
        System.out.println("Lượng calo hấp thụ/ngày: " + animal.getLuongCaloHapThuNgay());
        System.out.println("----------------------");
    }
}