/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyKhuyenMai_DAO;
import Smartphone_sales_management.DTO.Model_KhuyenMai;
import Smartphone_sales_management.DTO.Model_ChiTietKM;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lehongthai
 */
public class QuanLyKhuyenMai_BUS {

    private ArrayList<Model_KhuyenMai> dskm = null;
    private ArrayList<Model_ChiTietKM> dsctkm = null;
    private QuanLyKhuyenMai_DAO qlkm = new QuanLyKhuyenMai_DAO();

    public ArrayList<Model_KhuyenMai> getDanhSachKhuyenMai() {
        this.dskm = qlkm.getDanhSachKhuyenMai_DAO();
        return dskm;
    }

    public ArrayList<Model_ChiTietKM> getDanhSachKMChiTiet() {
        this.dsctkm = qlkm.getDanhSachChiTietKM_DAO();
        return dsctkm;
    }
      
    public ArrayList getAllKM(){
        ArrayList danhsachkm = new ArrayList();
         danhsachkm = qlkm.getALLKhuyenMai();
        return danhsachkm;
    }
  
      public boolean ExistsCTKM(int masp,int makm) {
		boolean isExists = false;	

		for(Model_ChiTietKM CTKM : dsctkm) {
			if (CTKM.getMaSP()== masp && CTKM.getMaKM() == makm) {
				isExists = true;
				break;
			}
		}

		return isExists;
	}
      
      public boolean exitmakm(int masp){
          boolean isExists = false;
          for(Model_ChiTietKM CTKM : dsctkm){
              if(CTKM.getMaSP()== masp && CTKM.getTrangThai().equals("T")){
                  isExists = true;
                  break;
              }
          }
          return isExists;
      }
     
    public boolean Addkhuyenmai(Model_KhuyenMai khuyenmai) {
        boolean isSuccess = false;
        if (khuyenmai != null) {
            qlkm.insertKhuyenMai(khuyenmai);
        }
        return isSuccess;
    }

    public boolean deleteKhuyenMai(Model_KhuyenMai KhuyenMai) {
        boolean isSuccess = false;

        qlkm.deleteKhuyenMai(KhuyenMai);
        
        return isSuccess;
    }

    public boolean updateKhuyenMai(Model_KhuyenMai KhuyenMai) {
        boolean isSuccess = false;
        qlkm.updatekm(KhuyenMai);
        return isSuccess;
    }

    public boolean insertChiTietKM(Model_ChiTietKM ChiTietKM) {
        boolean isSuccess = false;
        if (qlkm != null) {
            qlkm.InsertCTKM(ChiTietKM);
        }
        return isSuccess;
    }

    public boolean deleteChiTietKM(Model_ChiTietKM ChiTietKM) {
        boolean isSuccess = false;
        qlkm.deleteChiTietKM(ChiTietKM);
        return isSuccess;
    }
    
     public boolean updateChiTietKM(Model_ChiTietKM ChiTietKM) {
        boolean isSuccess = false;
        qlkm.updateChiTietKM(ChiTietKM);
        return isSuccess;
    }
     
      public ArrayList<Model_ChiTietKM> timKiemTheoMaCTKM(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_ChiTietKM> ctkmds = new ArrayList<>();
        for (Model_ChiTietKM ctkm : dsctkm) {
            String MaCTKM = Integer.toString(ctkm.getMachitietkhuyenmai());
            if (MaCTKM.contains(tuKhoa)) {
                ctkmds.add(ctkm);
            }
        }
        return ctkmds;
    }
     
      public ArrayList<Model_ChiTietKM> timKiemTheoTenSP(String tuKhoa){
          tuKhoa = tuKhoa.toLowerCase();
          ArrayList<Model_ChiTietKM> ctkmds = new ArrayList<>();
          for(Model_ChiTietKM ctkm : dsctkm){
              String Tensp = ctkm.getTenSP().toLowerCase();
              if(Tensp.contains(tuKhoa)) {
                    ctkmds.add(ctkm);
                }
          }
      return ctkmds;
      }
      
       public ArrayList<Model_KhuyenMai> timKiemTheoMaKM(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_KhuyenMai> kmds = new ArrayList<>();
        for (Model_KhuyenMai km : dskm) {
            String MaNV = Integer.toString(km.getMakm());
            if (MaNV.contains(tuKhoa)) {
                kmds.add(km);
            }
        }
        return kmds;
    }
       
          public ArrayList<Model_KhuyenMai> timKiemTheoPhanTramKM(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_KhuyenMai> kmds = new ArrayList<>();
        for (Model_KhuyenMai km : dskm) {
            String PhanTramKM = Float.toString(km.getPhantramkm());
            if (PhanTramKM.contains(tuKhoa)) {
                kmds.add(km);
            }
        }
        return kmds;
    }
          
              public ArrayList<Model_KhuyenMai> timKiemTheoTenKM(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_KhuyenMai> kmds = new ArrayList<>();
        for (Model_KhuyenMai km : dskm) {
            String Tenkm = km.getTenkm();
            if (Tenkm.contains(tuKhoa)) {
                kmds.add(km);
            }
        }
        return kmds;
    }
              
          public ArrayList<Model_ChiTietKM> timKiemMaCTKMNangCao(String tuKhoaA, String tuKhoaB){
        ArrayList<Model_ChiTietKM> ctkmds = new ArrayList<>();
        for(Model_ChiTietKM ctkm : dsctkm){
            int mactkm = ctkm.getMachitietkhuyenmai();
            int min = Integer.parseInt(tuKhoaA);
            int max = Integer.parseInt(tuKhoaB);
            if( min <= mactkm && mactkm <= max){
                ctkmds.add(ctkm);
            }
        }
        return ctkmds;
    }
          
             public ArrayList<Model_ChiTietKM> timKiemMaspNangCao(String tuKhoaA, String tuKhoaB){
        ArrayList<Model_ChiTietKM> ctkmds = new ArrayList<>();
        for(Model_ChiTietKM ctkm : dsctkm){
            int masp = (ctkm.getMaSP());
            int min = Integer.parseInt(tuKhoaA);
            int max = Integer.parseInt(tuKhoaB);
            if( min <= masp && masp <= max){
                ctkmds.add(ctkm);
            }
        }
        return ctkmds;
    }
             
                  public ArrayList<Model_KhuyenMai> timKiemMaKmNangCao(String tuKhoaA, String tuKhoaB){
        ArrayList<Model_KhuyenMai> kmds = new ArrayList<>();
        for(Model_KhuyenMai km : dskm){
            int makm = km.getMakm();
            int min = Integer.parseInt(tuKhoaA);
            int max = Integer.parseInt(tuKhoaB);
            if( min <= makm && makm <= max){
                kmds.add(km);
            }
        }
        return kmds;
    }
   
}


  