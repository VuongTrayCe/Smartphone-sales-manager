/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLiSanPham_DAO;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class QuanLiSanPham_BUS {

    QuanLiSanPham_DAO qlsp = new QuanLiSanPham_DAO();

    public ArrayList layDanhSachSanPham(String keyWord, int selectedIndex) {
        ArrayList dsspOffical = new ArrayList();
        ArrayList dssp = new ArrayList();
        dssp = qlsp.layDanhSachSanPham();
        if (selectedIndex == 0) {
            if (keyWord == "") {
                return dssp;
            } else {
                for (Object x : dssp) {
                    Vector y = (Vector) x;
                    String masp = Integer.toString((int) y.get(0));
                    String tenSp = (String) y.get(1);
                    if (masp.contains(keyWord) || tenSp.contains(keyWord)) {
                        dsspOffical.add(y);
                    }
                }
                return dsspOffical;
            }
        }
        if (selectedIndex == 1) {
            if (keyWord == "") {
                for (Object x : dssp) {
                    Vector y = (Vector) x;
                    String tenTrangThai = (String) y.get(5);
                    if (tenTrangThai.equals("T")) {
                        dsspOffical.add(y);
                    }
                }
                return dsspOffical;
            } else {
                for (Object x : dssp) {
                    Vector y = (Vector) x;
                    String masp = Integer.toString((int) y.get(0));
                    String tenTrangThai = (String) y.get(5);
                    String tenSp = (String) y.get(1);
                    if (masp.contains(keyWord) || tenSp.contains(keyWord) && tenTrangThai.equals("T")) {
                        dsspOffical.add(y);
                    }

                }
                return dsspOffical;
            }
        }

        if (selectedIndex == 2) {
            if (keyWord == "") {
                for (Object x : dssp) {
                    Vector y = (Vector) x;
                    String tenTrangThai = (String) y.get(5);
                    if (tenTrangThai.equals("F")) {
                        dsspOffical.add(y);
                    }
                }
                return dsspOffical;
            } else {
                for (Object x : dssp) {
                    Vector y = (Vector) x;
                    String masp = Integer.toString((int) y.get(0));
                    String tenTrangThai = (String) y.get(5);
                    String tenSp = (String) y.get(1);
                    if (masp.contains(keyWord) || tenSp.contains(keyWord) && tenTrangThai.equals("F")) {
                        dsspOffical.add(y);
                    }
                }
                return dsspOffical;
            }
        }
        return null;
    }

    public ArrayList layChitietSanPham(int selectedIndex, String tenTrangThai) {
        System.out.println(selectedIndex);
        System.out.println(tenTrangThai);
        ArrayList dsctsp = new ArrayList();
        ArrayList MaspList = new ArrayList();
        if (tenTrangThai.equals("All")) {
            MaspList = qlsp.layMadh();
        } else {
            MaspList = qlsp.layMadh2(tenTrangThai);
        }
        try {
            dsctsp = qlsp.layDanhSachChiTietSanPham((int) MaspList.get(selectedIndex));
//            System.out.println(dsctsp.size());
        } catch (Exception e) {
            return null;
        }
//        System.out.println(dsctsp);
        return dsctsp;
    }
}
