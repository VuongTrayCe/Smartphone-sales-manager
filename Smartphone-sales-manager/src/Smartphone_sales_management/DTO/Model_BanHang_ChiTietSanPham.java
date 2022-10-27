/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DTO;

/**
 *
 * @author Vuong
 */
public class Model_BanHang_ChiTietSanPham {
    private String tensp;
    private String loaisp;
    private int sl;
    private String namsx;
    private String tenncc;
    private Double giaban;
    private String chitiet;
    private String icon;
    private float ptkm;

    public void setPtkm(float ptkm) {
        this.ptkm = ptkm;
    }

    public float getPtkm() {
        return ptkm;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public void setNamsx(String namsx) {
        this.namsx = namsx;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public void setGiaban(Double giaban) {
        this.giaban = giaban;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTensp() {
        return tensp;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public int getSl() {
        return sl;
    }

    public String getNamsx() {
        return namsx;
    }

    public String getTenncc() {
        return tenncc;
    }

    public Double getGiaban() {
        return giaban;
    }

    public String getChitiet() {
        return chitiet;
    }

    public String getIcon() {
        char tem = '\\';
        return icon.replace(tem,'/');
    }
    
}
