/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.UI.Model;

/**
 *
 * @author lehongthai
 */
public class Model_ChiTietKM {
    private int Machitietkhuyenmai;
    private int MaSP;
    private int MaKM;
    private String TrangThai;

    public Model_ChiTietKM() {
    }

    public Model_ChiTietKM(int Machitietkhuyenmai, int MaSP, int MaKM, String TrangThai) {
        this.Machitietkhuyenmai = Machitietkhuyenmai;
        this.MaSP = MaSP;
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
        return new String[] {Integer.toString(Machitietkhuyenmai),Integer.toString(MaSP),Integer.toString(MaKM),TrangThai};
        
      }
}
    

