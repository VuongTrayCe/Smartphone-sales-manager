/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLiSanPham_DAO;
import Smartphone_sales_management.DTO.Model_SanPham;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class QuanLiSanPham_BUS {

    QuanLiSanPham_DAO qlsp = new QuanLiSanPham_DAO();

    public ArrayList layDanhSachSanPham(String keyWord, String tenTrangThai) {
        ArrayList dsspOffical = new ArrayList();
        ArrayList dssp = new ArrayList();
        ArrayList dsspTrangThai = new ArrayList();
        dsspTrangThai = qlsp.layDanhSachSanPhamTheoTrangThai(tenTrangThai);
        dssp = qlsp.layDanhSachSanPham();
        if (tenTrangThai.equals("All")) {
            if (keyWord == "") {
                return dssp;
            } else {
                for (Object x : dssp) {
                    Vector y = (Vector) x;
                    String masp = Integer.toString((int) y.get(0));
                    if (masp.contains(keyWord)) {
                        dsspOffical.add(y);
                    }
                }
                return dsspOffical;
            }
        } else {
            if (keyWord == "") {
                return dsspTrangThai;
            } else {
                for (Object x1 : dsspTrangThai) {
                    Vector y = (Vector) x1;
                    String maSP = Integer.toString((int) y.get(0));
                    if (maSP.contains(keyWord)) {
                        dsspOffical.add(y);
                    }
                }
                return dsspOffical;
            }
        }
    }

//    public ArrayList layChitietSanPham(int selectedIndex, String tenTrangThai) {
//
//        ArrayList dsctsp = new ArrayList();
//        ArrayList MaspList = new ArrayList();
//        if (tenTrangThai.equals("All")) {
//            MaspList = qlsp.layMadh();
//        } else {
//            MaspList = qlsp.layMadh2(tenTrangThai);
//        }
//        try {
//            dsctsp = qlsp.layDanhSachChiTietSanPham((int) MaspList.get(selectedIndex));
////            System.out.println(dsctsp.size());
//        } catch (Exception e) {
//            return null;
//        }
////        System.out.println(dsctsp);     
//        return dsctsp;
//    }
    public ArrayList layctsp_BUS(int Masp) {
        ArrayList ctsp = new ArrayList();
        try {
            ctsp = qlsp.layDanhSachChiTietSanPham(Masp);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ctsp;
    }

    public boolean themSP(Model_SanPham model) throws SQLException {
        try {
            int id = qlsp.themSanPham(model);
            qlsp.themGiaSP(id, model);
            qlsp.themKM(id, model);
            qlsp.themBH(id, model);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList layDSNCC() {
        ArrayList result = new ArrayList();
        result = qlsp.layDSNCC();
        return result;
    }

    public boolean xoaSP(int maSp) {
        try {
            qlsp.xoaSP(maSp);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean kiemTraTrangThaiSP(int maSp) {
        ArrayList trangThai = qlsp.layDanhSachChiTietSanPham(maSp);
        String temp = trangThai.get(8).toString();
        System.out.println(maSp);
        System.out.println(temp);
        if (temp.equals("F")) {
            return false;
        }
        return true;
    }

    public boolean suaSP(Model_SanPham model) {
//        if (qlsp.suaSP(model) && qlsp.suaGiasp(model) && qlsp.suaBH(model) && qlsp.suaKM(model)) {
//            return true;
//        }
//        return false;

        if (qlsp.suaSP(model)) {
            JOptionPane.showMessageDialog(null, "Sua thanh cong123");
                   
            int mactgia = qlsp.layCTgia(model);
            if (qlsp.suaGiasp(mactgia)) {
                int masp = model.getMasp();
                qlsp.themGiaSP(masp, model);
                if (qlsp.suaBH(model) && qlsp.suaKM(model)) {
                    return true;
                } else {
                    System.out.println("sua bao hanh or km loi");
                }
            } else {
                System.out.println("sua gia loi");
            }

        } else {
            System.out.println("Sua san pham loi~");
        }
        return false;
    }
// BUS khuyen mai

    public ArrayList layDanhSachKM() {
        ArrayList dskm = new ArrayList();
        dskm = qlsp.layDanhSachKM();
        return dskm;
    }
//   BUS bao hanh 

    public ArrayList layDanhSachBH() {
        ArrayList dsbh = new ArrayList();
        dsbh = qlsp.layDanhSachBH();
        return dsbh;
    }

    public ArrayList<String> getAllSP() {
        ArrayList danhsachsanpham = new ArrayList();
        danhsachsanpham = qlsp.getALLSanPham();
        return danhsachsanpham;
    }

}
