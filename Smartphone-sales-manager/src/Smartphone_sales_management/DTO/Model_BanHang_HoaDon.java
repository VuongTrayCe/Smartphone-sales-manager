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
    private LocalDateTime time ; 
    private int sl;
    private int tongtien;
    private String trangthai;

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setSl(int sl) {
        this.sl = sl;
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

    public LocalDateTime getTime() {
        return time;
    }

    public int getSl() {
        return sl;
    }

    public int getTongtien() {
        return tongtien;
    }

    public String getTrangthai() {
        return trangthai;
    }
    
}
