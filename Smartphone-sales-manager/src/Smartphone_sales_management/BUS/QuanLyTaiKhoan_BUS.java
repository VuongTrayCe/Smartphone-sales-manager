/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyTaiKhoan_DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows10
 */
public class QuanLyTaiKhoan_BUS {
    QuanLyTaiKhoan_DAO qltk = new QuanLyTaiKhoan_DAO();
    
    public ArrayList layDanhSachTaiKhoan(String keyWord) {
        ArrayList dstk = new ArrayList();
        ArrayList dstkOfficial = new ArrayList();
        dstk = qltk.getDanhsachTaiKhoan();
        if (keyWord == "") {
            return dstk;
        } else {
            for (Object x : dstk) {
                Vector y = (Vector) x;
                String manv = Integer.toString((int) y.get(0));
                if (manv.contains(keyWord)) {
                    dstkOfficial.add(y);
                }
            }
        }
        return dstkOfficial;
    }
    public ArrayList getDanhSachChiTiet1TaiKhoan(int selectedIndex) {
        ArrayList dscttk = new ArrayList();
        ArrayList MaNVList = new ArrayList<>();
        MaNVList = qltk.getMa();
        try {
            dscttk = qltk.getDanhSachChiTiet1TaiKhoan_DAO((int) MaNVList.get(selectedIndex));
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyTaiKhoan_BUS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dscttk;
    }
}
    

   
    
