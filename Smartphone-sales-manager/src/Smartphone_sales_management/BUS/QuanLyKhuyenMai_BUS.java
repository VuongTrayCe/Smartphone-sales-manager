/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyKhuyenMai_DAO;
import Smartphone_sales_management.UI.Model.Model_KhuyenMai;
import Smartphone_sales_management.UI.Model.Model_ChiTietKM;
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

    public boolean Addkhuyenmai(Model_KhuyenMai khuyenmai) {
        boolean isSuccess = false;
        if (khuyenmai != null) {
            qlkm.insertKhuyenMai(khuyenmai);
        }
        return isSuccess;
    }

    public boolean deleteKhuyenMai(int Makm) {
        boolean isSuccess = false;

        for (Model_KhuyenMai km : dskm) {
            if (km.getMakm() == Makm) {
                dskm.remove(km);
                qlkm.deleteKhuyenMai(Makm);
                isSuccess = true;
                break;
            }
        }
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

    public boolean deleteChiTietKM(int MachiTietkm) {
        boolean isSuccess = false;
        for (Model_ChiTietKM ctkm : dsctkm) {
            if (ctkm.getMachitietkhuyenmai() == MachiTietkm) {
                dsctkm.remove(ctkm);
                qlkm.deleteChiTietKM(MachiTietkm);
                isSuccess = true;
                break;
            }
        }
        return isSuccess;
    }
    
     public boolean updateChiTietKM(Model_ChiTietKM ChiTietKM) {
        boolean isSuccess = false;
        qlkm.updateChiTietKM(ChiTietKM);
        return isSuccess;
    }
}
