/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DTO;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Vuong
 */
public class Model_BanHang_ChiTietHoaDon {

    private int masp;
    private int madh;
    private int mactkm;
    private String icon;
    private int machitietbaohanh;
    private int magiasp;
    private int soluong;
    private int giaban;
    private int giasaukm;
    private String tensp;
    private int phantramkhuyenmai;
    private String thoigianbaohanh;

    public Model_BanHang_ChiTietHoaDon(int masp, int madh, int mactkm, String icon, int machitietbaohanh, int magiasp, int soluong, int giaban, String tensp, int phantramkhuyenmai, String thoigianbaohanh) {
        this.masp = masp;
        this.madh = madh;
        this.mactkm = mactkm;
        this.icon = icon;
        this.machitietbaohanh = machitietbaohanh;
        this.magiasp = magiasp;
        this.soluong = soluong;
        this.giaban = giaban;
        this.tensp = tensp;
        this.phantramkhuyenmai = phantramkhuyenmai;
        this.thoigianbaohanh = thoigianbaohanh;
    }
    
    
//    
//    public Model_BanHang_ChiTietHoaDon(int masp, int madh, int mactkm, int machitietbaohanh, int magiasp, int soluong, int giaban, String tensp, int phantramkhuyenmai, String thoigianbaohanh) {
//        this.masp = masp;
//        this.madh = madh;
//        this.mactkm = mactkm;
//        this.machitietbaohanh = machitietbaohanh;
//        this.magiasp = magiasp;
//        this.soluong = soluong;
//        this.giaban = giaban;
//        this.giasaukm = giasaukm;
//        this.tensp = tensp;
//        this.phantramkhuyenmai = phantramkhuyenmai;
//        this.thoigianbaohanh = thoigianbaohanh;
//    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public int getTongTien() {
        int x =this.soluong * getGiasaukm();
        return x;
    }

    public Icon toIcon(String url) {
        return new ImageIcon(getClass().getResource(url));
    }

    public String getTensp() {
        return tensp;
    }

    public int getPhantramkhuyenmai() {
        return phantramkhuyenmai;
    }

    public String getThoigianbaohanh() {
        return thoigianbaohanh;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setPhantramkhuyenmai(int phantramkhuyenmai) {
        this.phantramkhuyenmai = phantramkhuyenmai;
    }

    public void setThoigianbaohanh(String thoigianbaohanh) {
        this.thoigianbaohanh = thoigianbaohanh;
    }

    public void setMactkm(int mactkm) {
        this.mactkm = mactkm;
    }

    public void setMachitietbaohanh(int machitietbaohanh) {
        this.machitietbaohanh = machitietbaohanh;
    }

    public void setMagiasp(int magiasp) {
        this.magiasp = magiasp;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getMactkm() {
        return mactkm;
    }

    public int getMachitietbaohanh() {
        return machitietbaohanh;
    }

    public int getMagiasp() {
        return magiasp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public void setMadh(int madh) {
        this.madh = madh;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getMasp() {
        return masp;
    }

    public int getMadh() {
        return madh;
    }

    public int getGiaban() {
        return giaban;
    }

    public int getGiasaukm() {
        int i = (int) (getGiaban() * ((100 - getPhantramkhuyenmai()) * 1.0 / 100));
        return i;
    }

}
