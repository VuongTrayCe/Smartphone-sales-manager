/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DTO;

/**
 *
 * @author Vuong
 */
public class Model_PhieuNhap {
    
    private int manv; 
    private int mancc;
    private int soluong;
    private String ngaynhap;
    private double tongtien;
    private String trangthai;
    public Model_PhieuNhap(int manv, int mancc, int soluong, String ngaynhap, double tongtien) {
        this.manv = manv;
        this.mancc = mancc;
        this.soluong = soluong;
        this.ngaynhap = ngaynhap;
        this.tongtien = tongtien;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public void setMancc(int mancc) {
        this.mancc = mancc;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getManv() {
        return manv;
    }

    public int getMancc() {
        return mancc;
    }

    public int getSoluong() {
        return soluong;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public double getTongtien() {
        return tongtien;
    }

    public String getTrangthai() {
        return trangthai;
    }
             
    
}
