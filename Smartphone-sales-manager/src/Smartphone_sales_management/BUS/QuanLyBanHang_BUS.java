/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyBanHang_DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuong
 */
public class QuanLyBanHang_BUS {

    QuanLyBanHang_DAO qlbh = new QuanLyBanHang_DAO();

    public QuanLyBanHang_BUS() {
    }

    // Hàm lấy tất cã sản phẩm đang được bán
    public ArrayList getDanhSachSanPham() {
        ArrayList dssp = new ArrayList();
        dssp = qlbh.getDanhSachSanPham_DAO();
        return dssp;
    }

    // Hàm lấy chi tiết sản phẩm được chọn
    public ArrayList getDanhSachChiTiet1SanPham(int selectedIndex) {
        ArrayList dsctsp = new ArrayList();
        ArrayList MaSPList = new ArrayList<>();
        MaSPList = qlbh.getMapn();
        try {
            dsctsp = qlbh.getDanhSachChiTiet1SanPham_DAO((int) MaSPList.get(selectedIndex));
        } catch (SQLException ex) {
            Logger.getLogger(QuanLyBanHang_BUS.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Object object : dsctsp) {
            System.out.println(object);
            System.out.println("Vuong");
        }
        return dsctsp;
    }

}
