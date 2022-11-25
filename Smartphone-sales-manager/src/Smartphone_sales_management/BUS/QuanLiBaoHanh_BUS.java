/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLiBaoHanh_DAO;
import Smartphone_sales_management.DTO.ModelBaoHanh;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class QuanLiBaoHanh_BUS {
    QuanLiBaoHanh_DAO qlbh_DAO = new QuanLiBaoHanh_DAO();
   public ArrayList layDSBH_BUS() {
       ArrayList dsbh = new ArrayList();
       dsbh = qlbh_DAO.layDanhSachBaoHanh();
       return dsbh;
   }
   public ArrayList layDSCTBH_BUS() {
       ArrayList dsctbh = new ArrayList();
       dsctbh = qlbh_DAO.layDanhSachCTBH();
       return dsctbh;
   }
   
   public ArrayList layctbh (int Mabh) {
       ArrayList ctbh = new ArrayList();
       ctbh = qlbh_DAO.layctBH(Mabh);
       return ctbh;
   }
   
    public ArrayList layctOfctbh (int Mactbh) {
       ArrayList ctbh = new ArrayList();
       ctbh = qlbh_DAO.layctOfctBH(Mactbh);
       return ctbh;
   }
   public boolean themBH(ModelBaoHanh model) {
       if(qlbh_DAO.themBH(model)) {
           return true;
       }
       return false;
   }
   
   public boolean xoaBH(int Mabh) {
       if(qlbh_DAO.xoaBH(Mabh)) {
           return true;
       }
       return false;
   }
   public boolean suaBH(ModelBaoHanh model) {
       if(qlbh_DAO.suaBH(model)) {
           return true;
       }
       return false;
   }
   public ArrayList dsMasp() {
       ArrayList dssp = new ArrayList();
       dssp = qlbh_DAO.dsMasp();
       return dssp;
   }
   public boolean themCTBH(ModelBaoHanh model) {
       if(qlbh_DAO.themCTDH(model)) {
           return true;
       } return false;
   }
   public int layMactbh (ModelBaoHanh model) {
       int result = -1;
       result = qlbh_DAO.chitietbaohanh(model);
       return result;
   }
   
   public boolean xoaCTBH(int Mactbh) {
       if(qlbh_DAO.xoaCTBH(Mactbh)) {
           return true;
       } return false;
   }

    public ArrayList getDanhSachSanPhamBaoHanh(String keyWord, String trangthai) {
        
        ArrayList dsbh = new ArrayList();
        ArrayList dsspOfficial = new ArrayList<>();
        dsbh = qlbh_DAO.getDanhSachBaoHanh_DAO();
        if (keyWord == "" && trangthai.equals("ALL")) {
            return dsbh;
        }
        if (keyWord != "" && trangthai.equals("ALL")) {
            for (Object x : dsbh) {
                Vector y = (Vector) x;
                String mapn = Integer.toString((int) y.get(1));
                String tenncc = y.get(3).toString();
//                String name = (String) y.get(1);
                if (mapn.contains(keyWord) || tenncc.contains(keyWord)) {
                    {
                        dsspOfficial.add(y);
                    }

                }
            }
            return dsspOfficial;
        }
        if (trangthai.equals("ALL") != true) {
            dsbh = qlbh_DAO.getALLBaoHanhTheoTrangThai(trangthai);

            if (keyWord == "") {
                return dsbh;
            } else {
                for (Object x : dsbh) {
                    Vector y = (Vector) x;
                    String mapn = Integer.toString((int) y.get(1));
                    String tenncc = y.get(3).toString();
//                String name = (String) y.get(1);
                    if (mapn.contains(keyWord) || tenncc.contains(keyWord)) {
                        {
                            dsspOfficial.add(y);
                        }

                    }
                }
            }
        }
        return dsspOfficial;

    }
}
