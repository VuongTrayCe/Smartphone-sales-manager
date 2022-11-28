/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DTO;

/**
 *
 * @author Dell
 */
public class Model_Quyen {
    private int MaQuyen;
    private int Matk;
    private String TenQuyen;
     
    public int getMaQuyem() {
        return MaQuyen;
    }

    public void setMaNV(int Maquyen) {
        this.MaQuyen = Maquyen;
    }
    public int getMatk() {
        return Matk;
    }

    public void setMatk(int MaTk) {
        this.Matk = MaTk;
    }

    public String getTenQuyen() {
        return TenQuyen;
    }

    public void setTenNV(String TenQuyen) {
        this.TenQuyen = TenQuyen;
    }
}
