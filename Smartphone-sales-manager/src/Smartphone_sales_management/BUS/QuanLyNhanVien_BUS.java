/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyNhanVien_DAO;
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
    QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
    public QuanLyNhanVien_BUS(){
    
    }
    public ArrayList getDanhSachNhanVien(String keyWord){
        ArrayList dsnv = new ArrayList();
        ArrayList dsnvOfficial = new ArrayList<>();
        dsnv = qlnv.getDanhSachNhanVien_DAO();
        if (keyWord == "") {
            return dsnv;
        } else {
            for (Object x : dsnv) {
                Vector y = (Vector) x;
                String manv = Integer.toString((int) y.get(0));
                if (manv.contains(keyWord)) {
                    dsnvOfficial.add(y);
                }
            }
        }
        return dsnvOfficial;

    }
}
