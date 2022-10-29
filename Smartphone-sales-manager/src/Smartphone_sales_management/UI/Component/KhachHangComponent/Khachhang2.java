/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.UI.Component.KhachHangComponent;

/**
 *
 * @author Hiep
 */
public class Khachhang2 {
    private String maKh, tenKH, email, soDT, diaChi;
    private int gioiTinh;

    public Khachhang2() {
    }

    public Khachhang2(String maKh, String tenKH, String email, String soDT, String diaChi, int gioiTinh) {
        this.maKh = maKh;
        this.tenKH = tenKH;
        this.email = email;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
}
