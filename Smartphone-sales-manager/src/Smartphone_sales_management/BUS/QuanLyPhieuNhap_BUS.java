/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyPhieuNhap_DAO;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Vuong
 */
public class QuanLyPhieuNhap_BUS {

    QuanLyPhieuNhap_DAO qlpn = new QuanLyPhieuNhap_DAO();

    public ArrayList getDanhSachPhieuNhap(String keyWord) {
        ArrayList dssp = new ArrayList();
        ArrayList dsspOfficial = new ArrayList<>();
        dssp = qlpn.getDanhSachPhieuNhap_DAO();
        if (keyWord == "") {
            return dssp;
        } else {

            for (Object x : dssp) {
                Vector y = (Vector) x;
                String masp = Integer.toString((int) y.get(0));
                String name = (String) y.get(1);
                if (masp.contains(keyWord) || name.contains(keyWord)) {
                    {
                        dsspOfficial.add(y);
                    }

                }
            }
            return dsspOfficial;
        }
    }

}
