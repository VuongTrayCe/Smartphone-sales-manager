/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import Smartphone_sales_management.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class QuanLiSanPham_DAO {

    DBConnect db = new DBConnect();
    ResultSet rs = null;

    public ArrayList layDanhSachSanPham() {
        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT sanpham.Masp, sanpham.Tensp,sanpham.Loaisp, giasanpham.Giaban,sanpham.soluong,sanpham.TrangThai\n"
                    + "FROM sanpham\n"
                    + "INNER JOIN giasanpham ON giasanpham.Masp = sanpham.Masp");
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getInt("MaSP"));
                a.add(rs.getString("TenSp"));
                a.add(rs.getString("LoaiSp"));
                a.add(rs.getDouble("GiaBan"));
                a.add(rs.getInt("SoLuong"));
                a.add(rs.getString("TrangThai"));
                dssp.add(a);
            }
            return dssp;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            db.closeConnection();
        }
    }
    
//    public ArrayList layDanhSachChiTietSanPham(int Masp) {
//        
//    }

}
