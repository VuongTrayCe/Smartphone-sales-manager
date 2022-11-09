/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLiDonHang_DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class QuanLyDonHang_BUS {

    QuanLiDonHang_DAO qldh = new QuanLiDonHang_DAO();

    public QuanLyDonHang_BUS() {

    }

    public ArrayList layDanhSachDonHang(String keyWord, String tenTrangThai) {
        ArrayList dsdh = new ArrayList();
        ArrayList dsdhOfficial = new ArrayList();
        ArrayList dsdhtt = new ArrayList();
        dsdh = qldh.layDanhSachDonHang_DAO();
        if (tenTrangThai == "ALL") {
            if (keyWord == "") {
                return dsdh;
            } else {
                for (Object x : dsdh) {
                    Vector y = (Vector) x;
                    String madh = Integer.toString((int) y.get(0));
                    if (madh.contains(keyWord)) {
                        dsdhOfficial.add(y);
                    }
                }
                return dsdhOfficial;
            }
        } else {
            if (keyWord == "") {
                return dsdhtt = qldh.getDanhSachDonHangTheoTrangThai(tenTrangThai);
            } else {
                for (Object x : dsdhtt) {
                    Vector y = (Vector) x;
                    String madh = Integer.toString((int) y.get(0));
                    if (madh.contains(keyWord)) {
                        dsdhOfficial.add(y);
                    }
                }
                return dsdhOfficial;
            }
        }
    }


    public ArrayList layctdh(int Madh) {
        ArrayList ctdh = new ArrayList();
        try {
            ctdh = qldh.layDanhSachChiTietDonHang(Madh);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ctdh;
    }

    public void updateHuyDonHang(int Madh) {
        qldh.updateHuyDonHang(Madh);
    }

    public void updateXacNhanDonHang(int Madh) {
        qldh.updateXacNhanDonHang(Madh);
    }
}
