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

    public ArrayList layDanhSachDonHang(String keyWord, int selectedIndex) {
        ArrayList dsdh = new ArrayList();
        ArrayList dsdhOfficial = new ArrayList();
        dsdh = qldh.layDanhSachDonHang_DAO();
        if (selectedIndex == 0) {
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

        }

        if (selectedIndex == 1) {
            if (keyWord == "") {
                for (Object x : dsdh) {
                    Vector y = (Vector) x;
                    String trangthai =((String) y.get(3));
                    if (trangthai.equals("T")) {
                        dsdhOfficial.add(y);
                    }
                }
                return dsdhOfficial;
            } else {
                for (Object x : dsdh) {
                    Vector y = (Vector) x;
                    String madh = Integer.toString((int) y.get(0));
                   String trangthai =((String) y.get(3));
                    if (madh.contains(keyWord) && trangthai.equals("T")) {
                        dsdhOfficial.add(y);
                    }
                }
                return dsdhOfficial;

            }
        }

        if (selectedIndex == 2) {
            if (keyWord == "") {
                for (Object x : dsdh) {
                    Vector y = (Vector) x;
                    String trangthai =((String) y.get(3));
                    if (trangthai.equals("F")) {
                        dsdhOfficial.add(y);
                    }
                }
                return dsdhOfficial;
            } else {
                for (Object x : dsdh) {
                    Vector y = (Vector) x;
                    String madh = Integer.toString((int) y.get(0));
                   String trangthai =((String) y.get(3));
                    if (madh.contains(keyWord) && trangthai.equals("F")) {
                        dsdhOfficial.add(y);
                    }
                }
                return dsdhOfficial;

            }
        }
        
        
        return null;

    }

public ArrayList layDanhSachChiTietDonHang(int selectedIndex) {
        ArrayList dsctdh = new ArrayList();
        ArrayList MaDHList = new ArrayList();
        MaDHList = qldh.layMadh();
        System.out.println(MaDHList);
        try {
            dsctdh = qldh.layDanhSachChiTietDonHang((int) MaDHList.get(selectedIndex));

} catch (SQLException ex) {
            Logger.getLogger(QuanLyDonHang_BUS.class  

.getName()).log(Level.SEVERE, null, ex);
        }

        return dsctdh;
    }
}
