/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyTaiKhoan_DAO;
import Smartphone_sales_management.UI.Model.Model_TaiKhoan;
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

    public QuanLyTaiKhoan_BUS() {
    }

    public ArrayList layDanhSachTaiKhoan(String keyWord) {
        ArrayList dstk = new ArrayList();
        ArrayList dstkOfficial = new ArrayList();
        dstk = qltk.getDanhsachTaiKhoan();
//        System.out.println(dstk);
        if (keyWord == "") {
            return dstk;
        } else {
            for (Object x : dstk) {
                Vector y = (Vector) x;
                String matk = Integer.toString((int) y.get(0));
                if (matk.contains(keyWord)) {
                    dstkOfficial.add(y);
                }
            }
            return dstkOfficial;
        }
    }
      public ArrayList layDanhSachTaiKhoan2(String keyWord) {
        ArrayList dstk = new ArrayList();
        ArrayList dstkOfficial = new ArrayList();
        dstk = qltk.getDanhsachTaiKhoan2();
//        System.out.println(dstk);
        if (keyWord == "") {
            return dstk;
        } else {
            for (Object x : dstk) {
                Vector y = (Vector) x;
                String matk = Integer.toString((int) y.get(0));
                if (matk.contains(keyWord)) {
                    dstkOfficial.add(y);
                }
            }
            return dstkOfficial;
        }
    }

//    public ArrayList getDanhSachChiTiet1TaiKhoan(int selectedIndex) {
//        ArrayList dscttk = new ArrayList();
//        ArrayList MaTKList = new ArrayList<>();
//        MaTKList = qltk.getMa();
//        try {
//            dscttk = qltk.getDanhSachChiTiet1TaiKhoan_DAO((int) MaTKList.get(selectedIndex));
//        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_BUS.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return dscttk;
//    }
    public boolean themTK(Model_TaiKhoan Taikhoan) throws SQLException {
        qltk.XoaTaiKhoanCu(Taikhoan.getMaNhanVien());
        if (qltk.themTaiKhoan(Taikhoan)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean xoaTK(int Matk) {
        try {
            qltk.xoaTK(Matk);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean SuaTaiKhoan(Model_TaiKhoan model) {
        if (qltk.suaTK(model)) {
            return true;
        }
        return false;
    }

    public ArrayList layDanhSachNV() {
        ArrayList dsnv = new ArrayList();
        dsnv = qltk.layDanhSachNV();
        return dsnv;
    }

    public int KiemTraDangNhap(String username, String pwd) {
        int check = 0;
        Boolean checkUsername = false;
        Boolean checkPwd = false;

        ArrayList data = new ArrayList();
        data = qltk.getALLAccount();
        for (Object object : data) {
            Vector dataRow = (Vector) object;
            String username2 = dataRow.get(1).toString();
            String pass = dataRow.get(2).toString();
            if (username.equals(username2) && pwd.equals(pass)) {
                checkUsername = true;
                return (int) dataRow.get(0);
            }
        }
        return check;
    }
    public ArrayList layDanhSachChiTietTai(int Matk) {
        ArrayList data = new ArrayList();
        data = qltk.layDanhSachChiTietTK(Matk);
        return data;
    }
    public ArrayList getALLQuyenTK(int manv) {
        return qltk.getALLQuyenTk(manv);
    }

    public String getTenNv(int l) {
        return qltk.getTennv(l);
    }

    public boolean CheckTenDangNhap(String Tendangnhap) {
        ArrayList dataTenDangNhap = qltk.getTenDangNhap();
        for (Object object : dataTenDangNhap) {
            String UserName = (String) object;
            if(UserName.equals(Tendangnhap))
            {
                return false;
            }
            
        }
        return true;
    }
}
