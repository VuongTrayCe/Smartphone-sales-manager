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
    private double giaban;
    private String chitiet;
    private String icon;
    private int ptkm;
    private String baohanh;
    private int masp;
    private int makm;
    private int mabh;
    private int machitietkhuyenmai;
    private int machitietbaohanh;
    private int magiasanpham;

    public void setMagiasanpham(int magiasanpham) {
        this.magiasanpham = magiasanpham;
    }

    public int getMagiasanpham() {
        return magiasanpham;
    }

    public void setMachitietkhuyenmai(int machitietkhuyenmai) {
        this.machitietkhuyenmai = machitietkhuyenmai;
    }

    public void setMachitietbaohanh(int machitietbaohanh) {
        this.machitietbaohanh = machitietbaohanh;
    }

    public int getMachitietkhuyenmai() {
        return machitietkhuyenmai;
    }

    public int getMachitietbaohanh() {
        return machitietbaohanh;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public void setMakm(int makm) {
        this.makm = makm;
    }

    public void setMabh(int mabh) {
        this.mabh = mabh;
    }

    public int getMasp() {
        return masp;
    }

    public int getMakm() {
        return makm;
    }

    public int getMabh() {
        return mabh;
    }

    public String getBaohanh() {
        return baohanh;
    }

    public void setBaohanh(String baohanh) {
        this.baohanh = baohanh;
    }

    public void setPtkm(int ptkm) {
        this.ptkm = ptkm;
    }

    public int getPtkm() {
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

    public int getGiaban() {
        return (int)giaban;
    }

    public String getChitiet() {
        return chitiet;
    }

    public String getIcon() {
        char tem = '\\';
        return icon.replace(tem,'/');
    }
    
}
