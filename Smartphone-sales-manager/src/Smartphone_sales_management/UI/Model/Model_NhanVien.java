/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.UI.Model;

/**
 *
 * @author lehongthai
 */
public class Model_NhanVien {
    private String MaNV;
    private String TenNV;
    private String SoCCCD;
    private String Tuoi;
    private String DiaChi;
    private String ChucDanh;
    private String TrangThai;

    public Model_NhanVien() {
        
    }

    public Model_NhanVien(String MaNV, String TenNV, String SoCCCD, String Tuoi, String DiaChi, String ChucDanh, String TrangThai) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.SoCCCD = SoCCCD;
        this.Tuoi = Tuoi;
        this.DiaChi = DiaChi;
        this.ChucDanh = ChucDanh;
        this.TrangThai = TrangThai;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getSoCCCD() {
        return SoCCCD;
    }

    public void setSoCCCD(String SoCCCD) {
        this.SoCCCD = SoCCCD;
    }

    public String getTuoi() {
        return Tuoi;
    }

    public void setTuoi(String Tuoi) {
        this.Tuoi = Tuoi;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getChucDanh() {
        return ChucDanh;
    }

    public void setChucDanh(String ChucDanh) {
        this.ChucDanh = ChucDanh;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    public String[] toArrayString() {
		return new String[] {MaNV,TenNV,SoCCCD,Tuoi,DiaChi,ChucDanh,TrangThai};
	}
}
