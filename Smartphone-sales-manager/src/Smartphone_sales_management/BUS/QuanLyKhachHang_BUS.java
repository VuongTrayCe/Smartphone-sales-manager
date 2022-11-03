/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLiKhachHang_DAO;
import Smartphone_sales_management.UI.Model.Model_ChiTietKM;
import Smartphone_sales_management.UI.Model.Model_KhachHang;
import java.util.ArrayList;

/**
 *
 * @author Hiep
 */
public class QuanLyKhachHang_BUS {
    private ArrayList<Model_KhachHang> dskh = null;
    private QuanLiKhachHang_DAO qlkh = new QuanLiKhachHang_DAO();

public ArrayList<Model_KhachHang> getDanhSachKhachHang(){
            this.dskh = qlkh.getDanhSachKhachHang_DAO();
            return dskh;
    
}
public boolean AddKhachHang(Model_KhachHang KhachHang){
    boolean isSuccess = false;
    if(KhachHang !=null){
        qlkh.inserKhachHang(KhachHang);
    }
    return isSuccess;
    }

public boolean deleteKhachHang(int Makh){
    boolean isSuccess = false;
    
    for(Model_KhachHang kh:dskh){
        if(kh.getMakh()== Makh){
            dskh.remove(kh);
            qlkh.deleteKhachHang(Makh);
            isSuccess = true;
            break;
            
        }
    }
    return isSuccess;
}
public boolean updateKhachHang(Model_KhachHang KhachHang){
    boolean isSuccess = false;
    qlkh.updatekhachhang(KhachHang);
    
    return isSuccess;
}
public boolean addkh(Model_KhachHang KhachHang) {
     boolean isSuccess = false;
        if(KhachHang != null){
        qlkh.insertKhachHang(KhachHang);
        }
        
        return isSuccess;
    }

    public boolean ExistsKhachHang(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getSoTTMakh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
