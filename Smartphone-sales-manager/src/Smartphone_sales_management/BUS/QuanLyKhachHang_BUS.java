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

public boolean deleteKhachHang(int makh){
    boolean isSuccess = false;
    
    for(Model_KhachHang kh : dskh){
        if(kh.getMakh()== makh){
            dskh.remove(kh);
            qlkh.deleteKhachHang(makh);
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
//public boolean ExistsKhachHang(int Cmnd) {
//		boolean isExists = false;	
//
//		for(Model_KhachHang khachHang : dskh) {
//			pif (khachHang.getCmnd()== Cmnd) {
//				isExists = true;
//				break;
//			}
//		}
//
//		return isExists;
//	}
//        
        
         public ArrayList<Model_KhachHang> timKiemTheoMaKh(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_KhachHang> khds = new ArrayList<>();
        for (Model_KhachHang kh : dskh) {
            String MaKh = Integer.toString(kh.getMakh());
            if (MaKh.contains(tuKhoa)) {
                khds.add(kh);
            }
        }
        return khds;
    }
           public ArrayList<Model_KhachHang> timKiemTheoTen(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_KhachHang> khds = new ArrayList<>();
        for (Model_KhachHang kh : dskh) {
            String TenKh = kh.getTenkh().toLowerCase();
            if (TenKh.contains(tuKhoa)) {
                khds.add(kh);
            }
        }
        return khds;
    }

               public ArrayList<Model_KhachHang> timKiemTheoDiaChi(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_KhachHang> khds = new ArrayList<>();
        for (Model_KhachHang kh : dskh) {
            String  Diachi = kh.getDiaChi().toLowerCase();
            if (Diachi.contains(tuKhoa)) {
                khds.add(kh);
            }
        }
        return khds;
    }
         
          public ArrayList<Model_KhachHang> timKiemMaNVNangCao(String tuKhoaA, String tuKhoaB){
        ArrayList<Model_KhachHang> khds = new ArrayList<>();
        for(Model_KhachHang kh : dskh){
            int Makh = kh.getMakh();
            int min = Integer.parseInt(tuKhoaA);
            int max = Integer.parseInt(tuKhoaB);
            if( min <= Makh && Makh <= max){
                khds.add(kh);
            }
        }
        return khds;
    }
                public ArrayList<Model_KhachHang> timKiemTuoiNangCao(String tuKhoaA, String tuKhoaB){
        ArrayList<Model_KhachHang> khds = new ArrayList<>();
        for(Model_KhachHang kh : dskh){
            int SĐT = kh.getSDT();
            int min = Integer.parseInt(tuKhoaA);
            int max = Integer.parseInt(tuKhoaB);
            if( min <= SĐT && SĐT <= max){
                khds.add(kh);
            }
        }
        return khds;
    }
}


