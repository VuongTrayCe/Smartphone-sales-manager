/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.UI.Model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Vuong
 */



public class Model_GioHang {
    private int masp;
    private int makhuyenmai;
    private int mabaohanh;
    private String Name;
    private String Loai;
    private String giatien;
    private int Soluong;
    private String Icon;
    private int khuyenmai;
    private String baohanh;

    
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
    
    
    public void setMasp(int masp) {
        this.masp = masp;
    }

    public void setMakhuyenmai(int makhuyenmai) {
        this.makhuyenmai = makhuyenmai;
    }

    public void setMabaohanh(int mabaohanh) {
        this.mabaohanh = mabaohanh;
    }

    public int getMasp() {
        return masp;
    }

    public int getMakhuyenmai() {
        return makhuyenmai;
    }

    public int getMabaohanh() {
        return mabaohanh;
    }
    
    
    
    
    GioHangType type;
    public static enum GioHangType
    {
        MENU, EMPTY
    
    
    }

    public Model_GioHang(String Name, String Loai, int Soluong, String Icon,GioHangType type,String giatien,int khuyenmai,String baohanh,int masp,int makm,int mabh) {
        this.Name = Name;
        this.Loai = Loai;
        this.Soluong = Soluong;
        this.Icon = Icon;
        this.type = type;
        this.giatien=giatien;
        this.khuyenmai=khuyenmai;
        this.baohanh=baohanh;
        this.masp=masp;
        this.makhuyenmai=makm;
        this.mabaohanh=mabh;

        
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public void setKhuyenmai(int khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    public void setBaohanh(String baohanh) {
        this.baohanh = baohanh;
    }

    public void setType(GioHangType type) {
        this.type = type;
    }

    public int getKhuyenmai() {
        return khuyenmai;
    }

    public String getBaohanh() {
        return baohanh;
    }
    
    public Double getTongTien()
    {
        Double x = this.Soluong* Double.parseDouble(this.giatien.split(" ")[0]);
        System.out.println(x);
        return x;
    }
    public String getGiatien() {
        return giatien;
    }

    public GioHangType getType() {
        return type;
    }
    
    public Model_GioHang()
    {
        
    }

    public String getName() {
        return Name;
    }

    public String getLoai() {
        return Loai;
    }

    public int getSoluong() {
        return Soluong;
    }

    public String getIcon() {
        return Icon;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }
    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public void setIcon(String Icon) {
        this.Icon = Icon;
    }
     public Icon toIcon(String url)
    {
     return  new ImageIcon(getClass().getResource(url));
    }
    
}
