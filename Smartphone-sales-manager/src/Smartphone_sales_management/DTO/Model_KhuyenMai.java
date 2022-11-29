/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DTO;

/**
 *
 * @author lehongthai
 */
public class Model_KhuyenMai {
    private int Makm;
    private String Tenkm;
    private int phantramkm;
    private String Trangthai;


    public Model_KhuyenMai() {
    }

    public Model_KhuyenMai(int Makm, String Tenkm, int phantramkm, String Trangthai) {

        this.Makm = Makm;
        this.Tenkm = Tenkm;
        this.phantramkm = phantramkm;
        this.Trangthai = Trangthai;
    }

    public int getMakm() {
        return Makm;
    }

    public void setMakm(int Makm) {
        this.Makm = Makm;
    }

    public String getTenkm() {
        return Tenkm;
    }

    public void setTenkm(String Tenkm) {
        this.Tenkm = Tenkm;
    }

    public int getPhantramkm() {
        return phantramkm;
    }

    public void setPhantramkm(int phantramkm) {
        this.phantramkm = phantramkm;
    }

    public String getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(String Trangthai) {
        this.Trangthai = Trangthai;
    }
    public String[] toArrayString(){
        return new String[] {Integer.toString(Makm),Tenkm,Integer.toString(phantramkm),Trangthai};
    }
     
}
