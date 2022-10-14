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
    private int MaNV;
    private String TenNV;
    private int SoCCCD;
    private int Tuoi;
    private String DiaChi;
    private String ChucDanh;
    private String TrangThai;

    public Model_NhanVien() {
        
    }

    public Model_NhanVien(int MaNV, String TenNV, int SoCCCD, int Tuoi, String DiaChi, String ChucDanh, String TrangThai) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.SoCCCD = SoCCCD;
        this.Tuoi = Tuoi;
        this.DiaChi = DiaChi;
        this.ChucDanh = ChucDanh;
        this.TrangThai = TrangThai;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public int getSoCCCD() {
        return SoCCCD;
    }

    public void setSoCCCD(int SoCCCD) {
        this.SoCCCD = SoCCCD;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int Tuoi) {
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
		return new String[] {Integer.toString(MaNV),TenNV,Integer.toString(SoCCCD),Integer.toString(Tuoi),DiaChi,ChucDanh,TrangThai};
	}
   
    @Override
    public Model_NhanVien clone(){
        return new Model_NhanVien(MaNV,TenNV,SoCCCD,Tuoi,DiaChi,ChucDanh,TrangThai);
    }
}
