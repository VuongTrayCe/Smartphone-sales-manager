/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DTO;

/**
 *
 * @author Vuong
 */
public class Model_PhieuNhap_ChiTiet {
    
    
    private int masp;
    private String tensp;
    private int mapn;
    private int gianhap;
    private int soluong;

    public Model_PhieuNhap_ChiTiet(int masp,String tensp, int mapn, int gianhap, int soluong) {
        this.masp = masp;
        this.mapn = mapn;
        this.tensp=tensp;
        this.gianhap = gianhap;
        this.soluong = soluong;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public void setMapn(int mapn) {
        this.mapn = mapn;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getMasp() {
        return masp;
    }

    public int getMapn() {
        return mapn;
    }

    public int getGianhap() {
        return gianhap;
    }

    public int getSoluong() {
        return soluong;
    }
    
}
