/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DTO;



/**
 *
 * @author lehongthai
 */
public class Model_ChiTietKM {
    private int Machitietkhuyenmai;
    private int MaSP;
    private String TenSP;
    private int MaKM;
    private String TrangThai;

    public Model_ChiTietKM() {
    }

    public Model_ChiTietKM(int Machitietkhuyenmai, int MaSP,String TenSP, int MaKM, String TrangThai) {
        this.Machitietkhuyenmai = Machitietkhuyenmai;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MaKM = MaKM;
        this.TrangThai = TrangThai;
    }

    public int getMachitietkhuyenmai() {
        return Machitietkhuyenmai;
    }

    public void setMachitietkhuyenmai(int Machitietkhuyenmai) {
        this.Machitietkhuyenmai = Machitietkhuyenmai;
    }

    public int getMaSP() {
        return MaSP;
    }

    public void setMaSP(int MaSP) {
        this.MaSP = MaSP;
    }
    public void setTenSP(String TenSP){
        this.TenSP = TenSP;
    }
    public String getTenSP(){
        return TenSP;
    }
    public int getMaKM() {
        return MaKM;
    }

    public void setMaKM(int MaKM) {
        this.MaKM = MaKM;
    }
    public void setTrangThai(String TrangThai){
        this.TrangThai = TrangThai;
    }
    public String getTrangThai(){
        return TrangThai;
    }
    public  String[] toArrayString(){
        return new String[] {Integer.toString(Machitietkhuyenmai),Integer.toString(MaSP),TenSP,Integer.toString(MaKM),TrangThai};
        
      }
}
    

