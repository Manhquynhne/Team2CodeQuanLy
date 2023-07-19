//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package test;


public class Animal {
    private int ID;
    private String Name;
    private int Age;
    private String tenLoai;
    private String xuatXu;
    private String ngayDen;
    private String tinhTrangSucKhoe;
    private String noiLamViec;
    private String thucAn;
    private double luongCaloHapThuNgay;

    public Animal(int ID, String Name, int Age, String tenLoai, String xuatXu, String ngayDen, String tinhTrangSucKhoe, String noiLamViec, String thucAn, double luongCaloHapThuNgay) {
        this.ID = ID;
        this.Name = Name;
        this.Age = Age;
        this.tenLoai = tenLoai;
        this.xuatXu = xuatXu;
        this.ngayDen = ngayDen;
        this.tinhTrangSucKhoe = tinhTrangSucKhoe;
        this.noiLamViec = noiLamViec;
        this.thucAn = thucAn;
        this.luongCaloHapThuNgay = luongCaloHapThuNgay;
    }

    public int getID(){
        return ID;
    }
    public String getName(){
        return Name;
    }
    public int getAge(){
        return Age;
    }
    public String getTenLoai(){
        return tenLoai;
    }
    public String getXuatXu(){
        return xuatXu;
    }
    public String getNgayDen(){
        return ngayDen;
    }
    public String getTinhTrangSucKhoe(){
        return tinhTrangSucKhoe;
    }
    public String getNoiLamViec(){
        return noiLamViec;
    }
    public String getThucAn(){
        return thucAn;
    }
    public double getLuongCaloHapThuNgay() {
        return luongCaloHapThuNgay;
    }
}

