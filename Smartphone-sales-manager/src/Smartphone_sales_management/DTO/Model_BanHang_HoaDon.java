/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

        
package Smartphone_sales_management.DTO;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Vuong
 */
public class Model_BanHang_HoaDon {
    private int makh;
    private int manv;
    private String ngayban; 
    private int soluong;
    private int tongtien;
    private int diemapdung;
    private int diemthuong;
    private String trangthai;

    public String getNgayban() {
        return ngayban;
    }

    public int getSoluong() {
        return soluong;
    }

    public int getDiemapdung() {
        return diemapdung;
    }

    public int getDiemthuong() {
        return diemthuong;
    }

    public void setNgayban(String ngayban) {
        this.ngayban = ngayban;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setDiemapdung(int diemapdung) {
        this.diemapdung = diemapdung;
    }

    public void setDiemthuong(int diemthuong) {
        this.diemthuong = diemthuong;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getMakh() {
        return makh;
    }

    public int getManv() {
        return manv;
    }
    public int getTongtien() {
        return tongtien;
    }

    public String getTrangthai() {
        return trangthai;
    }
    
}
