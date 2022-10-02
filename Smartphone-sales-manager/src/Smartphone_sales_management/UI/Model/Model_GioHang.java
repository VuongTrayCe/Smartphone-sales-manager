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
    
    private String Name;
    private String Loai;
    private String giatien;
    private String Soluong;
    private String Icon;
    
    
    
    
    GioHangType type;
    public static enum GioHangType
    {
        MENU, EMPTY
    
    
    }

    public Model_GioHang(String Name, String Loai, String Soluong, String Icon,GioHangType type,String giatien) {
        this.Name = Name;
        this.Loai = Loai;
        this.Soluong = Soluong;
        this.Icon = Icon;
        this.type = type;
        this.giatien=giatien;

        
    }
    public Double getTongTien()
    {
        Double x = Integer.parseInt(this.Soluong)* Double.parseDouble(this.giatien.split("")[0]);
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

    public String getSoluong() {
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
    public void setSoluong(String Soluong) {
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
