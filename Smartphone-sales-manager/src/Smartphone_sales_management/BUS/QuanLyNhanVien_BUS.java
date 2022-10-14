/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyNhanVien_DAO;
import Smartphone_sales_management.UI.Model.Model_NhanVien;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lehongthai
 */
public class QuanLyNhanVien_BUS {
//    private QuanLyNhanVien_DAO nhanvienDAO;
//    private ArrayList<Model_NhanVien> dsnv;
    QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
    public QuanLyNhanVien_BUS(){
    
    }
    public ArrayList<Model_NhanVien> getDanhSachNhanVien(String keyWord){
//        ArrayList<Model_NhanVien> dsnv = new ArrayList<Model_NhanVien>();
   
        return qlnv.getDanhSachNhanVien_DAO();

    }
    public  void AddNhanVien(Model_NhanVien nhanvien){
        qlnv.insertNhanVien(nhanvien);
        
    }
    public int getSoTTMANV(){
        return this.getDanhSachNhanVien("").size()+1;
    }
    
//	public boolean deleteNhanVien(String MaNV) {
//		boolean isSuccess = false;
//
//		for(int i = 0; i < dsnv.size(); ++i) {
//			if(dsnv.get(i).getMaNV().equals(MaNV)) {
//				dsnv.remove(i);
//				qlnv.deleteNhanVien(MaNV);
//			}
//		}
//		return isSuccess;
//	}
}
