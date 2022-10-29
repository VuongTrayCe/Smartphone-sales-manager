/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLiDonHang_DAO;
import Smartphone_sales_management.DAO.QuanLyNhanVien_DAO;
import Smartphone_sales_management.UI.Component.NhanVienComponent.NhanVienGUI;
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
    private ArrayList<Model_NhanVien> dsnv = null;
    private QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
//    public QuanLyNhanVien_BUS(){
//        this.dsnv = qlnv.getDanhSachNhanVien_DAO();
//    }
    public ArrayList<Model_NhanVien> getDanhSachNhanVien(){
        this.dsnv = qlnv.getDanhSachNhanVien_DAO();
        return dsnv;

    }
    public  boolean AddNhanVien(Model_NhanVien nhanvien){
        boolean isSuccess = false;
        if(nhanvien != null){
        qlnv.insertNhanVien(nhanvien);
        }
        return isSuccess;
    }
    public int getSoTTMANV(){
       return this.getDanhSachNhanVien().size()+1;
          
    }
    
	public boolean deleteNhanVien(int Manv) {
		boolean isSuccess = false;

		for(Model_NhanVien nv:dsnv) {
			if(nv.getMaNV() == Manv) {
				dsnv.remove(nv);
				qlnv.deleteNhanVien(Manv);
                                isSuccess = true;
				break;
			}
		}
                return isSuccess;
       }
        public boolean updateNhanVien(Model_NhanVien nhanvien){
            boolean isSuccess = false;
            qlnv.updateNhanVien(nhanvien);
//      
        return isSuccess;
     }
        
        public boolean ExistsNhanVien(String cccd) {
		boolean isExists = false;	

		for(Model_NhanVien nhanVien : dsnv) {
			if (nhanVien.getSoCCCD().equals(cccd)) {
				isExists = true;
				break;
			}
		}

		return isExists;
	}
        
        
         public ArrayList<Model_NhanVien> timKiemTheoMaNV(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_NhanVien> nvds = new ArrayList<>();
        for (Model_NhanVien nv : dsnv) {
            String MaNV = Integer.toString(nv.getMaNV());
            if (MaNV.contains(tuKhoa)) {
                nvds.add(nv);
            }
        }
        return nvds;
    }
           public ArrayList<Model_NhanVien> timKiemTheoTen(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_NhanVien> nvds = new ArrayList<>();
        for (Model_NhanVien nv : dsnv) {
            String Tennv = nv.getTenNV().toLowerCase();
            if (Tennv.contains(tuKhoa)) {
                nvds.add(nv);
            }
        }
        return nvds;
    }
             public ArrayList<Model_NhanVien> timKiemTheocccd(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_NhanVien> nvds = new ArrayList<>();
        for (Model_NhanVien nv : dsnv) {
            String  cccd = nv.getSoCCCD().toLowerCase();
            if (cccd.contains(tuKhoa)) {
                nvds.add(nv);
            }
        }
        return nvds;
    }
               public ArrayList<Model_NhanVien> timKiemTheoDiaChi(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_NhanVien> nvds = new ArrayList<>();
        for (Model_NhanVien nv : dsnv) {
            String  diachi = nv.getDiaChi().toLowerCase();
            if (diachi.contains(tuKhoa)) {
                nvds.add(nv);
            }
        }
        return nvds;
    }
          public ArrayList<Model_NhanVien> timKiemTheoTuoi(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_NhanVien> nvds = new ArrayList<>();
        for (Model_NhanVien nv : dsnv) {
            String  Tuoi = Integer.toString(nv.getTuoi());
            if (Tuoi.contains(tuKhoa)) {
                nvds.add(nv);
            }
        }
        return nvds;
    }
            public ArrayList<Model_NhanVien> timKiemTheoChucDanh(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_NhanVien> nvds = new ArrayList<>();
        for (Model_NhanVien nv : dsnv) {
            String Chucdanh = nv.getChucDanh().toLowerCase();
            if (Chucdanh.contains(tuKhoa)) {
                nvds.add(nv);
            }
        }
        return nvds;
    }
          public ArrayList<Model_NhanVien> timKiemMaNVNangCao(String tuKhoaA, String tuKhoaB){
        ArrayList<Model_NhanVien> nvds = new ArrayList<>();
        for(Model_NhanVien nv : dsnv){
            int Manv = nv.getMaNV();
            int min = Integer.parseInt(tuKhoaA);
            int max = Integer.parseInt(tuKhoaB);
            if( min <= Manv && Manv <= max){
                nvds.add(nv);
            }
        }
        return nvds;
    }
                public ArrayList<Model_NhanVien> timKiemTuoiNangCao(String tuKhoaA, String tuKhoaB){
        ArrayList<Model_NhanVien> nvds = new ArrayList<>();
        for(Model_NhanVien nv : dsnv){
            int Tuoi = nv.getTuoi();
            int min = Integer.parseInt(tuKhoaA);
            int max = Integer.parseInt(tuKhoaB);
            if( min <= Tuoi && Tuoi <= max){
                nvds.add(nv);
            }
        }
        return nvds;
    }
}

      

