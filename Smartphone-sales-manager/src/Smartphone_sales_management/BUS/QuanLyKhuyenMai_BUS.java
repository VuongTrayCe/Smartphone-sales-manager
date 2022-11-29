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
                       
    public ArrayList<Model_KhuyenMai> timKiemKM(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_KhuyenMai> kmds = new ArrayList<>();
        for (Model_KhuyenMai km : dskm) {
            String Makm = Integer.toString(km.getMakm());
            String tenkm = km.getTenkm();
            String ptkm = Float.toString(km.getPhantramkm());
            if (Makm.contains(tuKhoa) || tenkm.contains(tuKhoa) || ptkm.contains(tuKhoa)) {
                kmds.add(km);
            }
        }
        return kmds;
    }
    
      public ArrayList<Model_ChiTietKM> timKiemCTKM(String tuKhoa) {
        tuKhoa = tuKhoa.toLowerCase();
        ArrayList<Model_ChiTietKM> ctkmds = new ArrayList<>();
        for (Model_ChiTietKM ctkm : dsctkm) {
            String mactkm = Integer.toString(ctkm.getMachitietkhuyenmai());
            String masp = Integer.toString(ctkm.getMaSP());
            String tensp = ctkm.getTenSP();
             String makm = Integer.toString(ctkm.getMaKM());
            if (mactkm.contains(tuKhoa) || masp.contains(tuKhoa) || tensp.contains(tuKhoa) || makm.contains(tuKhoa)) {
                ctkmds.add(ctkm);
            }
        }
        return ctkmds;
    }
}


  