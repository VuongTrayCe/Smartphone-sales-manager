/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DTO;

/**
 *
 * @author Admin
 */
public class Model_SanPham {

    private int masp;
    private String tenSp;
    private String loaiSp;
    private int soLuong;
    private String mauSac;
    private String namSX;
    private String trangThai;
    private String icon;
    private String thongSo;
    private Double gia;
    private String ngayTao;
    private int Makm;
    private int Mabh;

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getMakm() {
        return Makm;
    }

    public void setMakm(int Makm) {
        this.Makm = Makm;
    }

    public int getMabh() {
        return Mabh;
    }

    public void setMabh(int Mabh) {
        this.Mabh = Mabh;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getNamSX() {
        return namSX;
    }

    public void setNamSX(String namSX) {
        this.namSX = namSX;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getIcon() {
        char temp = '/';
        return icon.replace(temp, '\\');
    }

    public void setIcon(String icon) {
        this.icon = icon;

    }

    public String getThongSo() {
        return thongSo;
    }

    public void setThongSo(String thongSo) {
        this.thongSo = thongSo;
    }

}
