package test;// TimKiem.java
import test.Animal;
import java.util.List;
import java.util.Objects;

public class timKiem {

    // hàm kiểm tra xem chuỗi này có phải là số hay chuỗi số không, hay là chuỗi kí tự sau đó phân ra từng hàm tìm kiếm riêng đối với chuỗi số và chuỗi kí tự.
    public static void timKiemTheoChuoi(List<Animal> animals, String tenCanTim) {
        if (isNumber(tenCanTim)) {
            timKiemTheoID(animals, tenCanTim);
            timKiemTheoTuoi(animals, tenCanTim);
            timKiemTheoCalo(animals, tenCanTim);
        } else {
            timKiemTenLoaiChim(animals, tenCanTim);
        }
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
                } else if (animal.getTenLoai().toLowerCase().contains(tenCanTim)) {
                    xuat(animal);
                    timThay = true;
                    continue;
                } else if (animal.getNoiLamViec().toLowerCase().contains(tenCanTim)) {
                    xuat(animal);
                    timThay = true;
                    continue;
                } else if (animal.getXuatXu().toLowerCase().contains(tenCanTim)) {
                    xuat(animal);
                    timThay = true;
                    continue;
                } else if (animal.getNgayDen().contains(tenCanTim)) {
                    xuat(animal);
                    timThay = true;
                    continue;
                } else if (animal.getThucAn().toLowerCase().contains(tenCanTim)) {
                    xuat(animal);
                    timThay = true;
                    continue;
                } else if (animal.getTinhTrangSucKhoe().toLowerCase().contains(tenCanTim)) {
                    xuat(animal);
                    timThay = true;
                    continue;
                }

            }

        if (!timThay) {
            System.out.println("Không tìm thấy loài chim có tên chứa: " + tenCanTim);
        }
    }

    public static void timKiemTheoID(List<Animal> animals, String tenCanTim) {
        try {
            int ID = Integer.parseInt(tenCanTim);
            boolean timThay = false;

            for (Animal animal : animals) {
                if (animal.getID() == ID) {
                    xuat(animal);
                    timThay = true;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Đã nhập không phải là ID.");
        }
    }

    public static void timKiemTheoTuoi(List<Animal> animals, String tenCanTim) {
        try {
            int tuoi = Integer.parseInt(tenCanTim);
            boolean timThay = false;

            for (Animal animal : animals) {
                if (animal.getAge() == tuoi) {
                    xuat(animal);
                    timThay = true;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Đã nhập không phải là tuổi.");
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
        System.out.println("ID: " + animal.getID());
        System.out.println("Tên: " + animal.getName());
        System.out.println("Tuổi: " + animal.getAge());
        System.out.println("Loài: " + animal.getTenLoai());
        System.out.println("Xuất xứ: " + animal.getXuatXu());
        System.out.println("Ngày đến: " + animal.getNgayDen());
        System.out.println("Tình trạng: " + animal.getTinhTrangSucKhoe());
        System.out.println("Nơi làm việc: " + animal.getNoiLamViec());
        System.out.println("Lượng thức ăn tiêu thụ: " + animal.getThucAn());
        System.out.println("Lượng calo hấp thụ/ngày: " + animal.getLuongCaloHapThuNgay());
        System.out.println("----------------------");
    }
}