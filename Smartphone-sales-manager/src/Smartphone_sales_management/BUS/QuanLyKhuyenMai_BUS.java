/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyKhuyenMai_DAO;
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
      QuanLyKhuyenMai_DAO qlkm = new QuanLyKhuyenMai_DAO();
    public QuanLyKhuyenMai_BUS(){
    
    }
    public ArrayList getDanhSachKhuyenMai(String keyWord){
        ArrayList dskm = new ArrayList();
        ArrayList dskmOfficial = new ArrayList<>();
        dskm = qlkm.getDanhSachKhuyenMai_DAO();
        if (keyWord == "") {
            return dskm;
        } else {
            for (Object x : dskm) {
                Vector y = (Vector) x;
                String Makm = Integer.toString((int) y.get(0));
                if (Makm.contains(keyWord)) {
                    dskmOfficial.add(y);
                }
            }
        }
        return dskmOfficial;

    }
}
