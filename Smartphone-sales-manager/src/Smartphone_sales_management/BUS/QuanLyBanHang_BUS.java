/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyBanHang_DAO;
import java.util.ArrayList;

/**
 *
 * @author Vuong
 */
public class QuanLyBanHang_BUS {
    QuanLyBanHang_DAO  qlbh = new QuanLyBanHang_DAO();

    public QuanLyBanHang_BUS() {
    }
    
    public ArrayList getDanhSachSanPham()
    {
        ArrayList dssp = new ArrayList();
        dssp = qlbh.getDanhSachSanPham_DAO();
        return dssp;
    }
    
}
