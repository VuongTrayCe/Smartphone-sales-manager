/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyBanHang_DAO;
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
        ArrayList dssp = new ArrayList();
        ArrayList dsspOfficial = new ArrayList<>();
        dssp = qlbh.getDanhSachSanPham_DAO();
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

}
