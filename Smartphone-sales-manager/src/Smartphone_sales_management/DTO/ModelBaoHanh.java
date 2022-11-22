/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DTO;

/**
 *
 * @author Admin
 */
public class ModelBaoHanh {

    private String thoigianbh;
    private String trangthai;
    private int Mabh;
    private int Masp;

    public int getMasp() {
        return Masp;
    }

    public void setMasp(int Masp) {
        this.Masp = Masp;
    }
    
    public int getMabh() {
        return Mabh;
    }

    public void setMabh(int Mabh) {
        this.Mabh = Mabh;
    }

    public String getThoigianbh() {
        return thoigianbh;
    }

    public void setThoigianbh(String thoigianbh) {
        this.thoigianbh = thoigianbh;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

}
