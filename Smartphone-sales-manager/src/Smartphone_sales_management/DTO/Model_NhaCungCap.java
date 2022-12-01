/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DTO;

/**
 *
 * @author lehongthai
 */
public class Model_NhaCungCap {
    private int Macc;
    private String Tenncc;
    private String SDT;
    private String DiaChi;
    private String TrangThai;

    public Model_NhaCungCap() {
    }

    public int getMacc() {
        return Macc;
    }

    public void setMacc(int Macc) {
        this.Macc = Macc;
    }

    public String getTenncc() {
        return Tenncc;
    }

    public void setTenncc(String Tenncc) {
        this.Tenncc = Tenncc;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    public  String[] toArrayString(){
        return new String[] {Integer.toString(Macc),Tenncc,SDT,DiaChi,TrangThai};
        
      }
}
