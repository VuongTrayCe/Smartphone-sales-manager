/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyBanHang_DAO;
import Smartphone_sales_management.DTO.Model_BanHang_HoaDon;
import Smartphone_sales_management.DTO.Model_KhachHang;
import Smartphone_sales_management.UI.Model.Model_GioHang;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

/**
 *
 * @author Vuong
 */
public class QuanLyBanHang_BUS {

    QuanLyBanHang_DAO qlbh = new QuanLyBanHang_DAO();

    public QuanLyBanHang_BUS() {
    }

    // Hàm lấy tất cã sản phẩm đang được bán
    public ArrayList getDanhSachSanPham(String keyWord) {
        ArrayList dspn = new ArrayList();
        ArrayList dsspOfficial = new ArrayList<>();
        dspn = qlbh.getDanhSachSanPham_DAO();
        if (keyWord == "") {
            return dspn;
        } else {
            
            for (Object x : dspn) {
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

        return dsctsp;
    }
    
    // Tạo hóa đơn và lưu vào database
    public void addDonHang(ArrayList data) {
//        qlbh.addDonHang_DAO(data);       
             JDialog a = new  JDialog();
             a.setVisible(true);
              
             a.setTitle("Thông tin đơn  hàng");
    }

    public ArrayList getALLKhachHang() {
        ArrayList dskh = new ArrayList();
        dskh = qlbh.getALLkhachHang();
        return dskh;
    }

    public void InsertDonHang() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void InsertDonHang(Model_BanHang_HoaDon hoadon, ArrayList<Model_GioHang> data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getMakh(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void addKhachHang(Model_KhachHang model_khachhang) {
        
        qlbh.insertKhachHang(model_khachhang);
    }

}
