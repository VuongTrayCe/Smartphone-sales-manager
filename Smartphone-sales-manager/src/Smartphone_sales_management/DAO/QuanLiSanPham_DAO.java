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
                    + "INNER JOIN giasanpham ON giasanpham.Masp = sanpham.Masp\n"
                    + "ORDER BY sanpham.Masp ASC");
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

    public ArrayList layDanhSachChiTietSanPham(int Masp) {
        ArrayList result = new ArrayList();
        db.setupConnection();
        System.out.println(Masp);
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT sanpham.Masp, sanpham.Tensp, giasanpham.Giaban, sanpham.soluong, sanpham.MauSac, sanpham.Namsx, baohanh.Thoigianbaohanh, khuyenmai.Ptkm,sanpham.TrangThai,sanpham.ThongSo,sanpham.Icon\n"
                    + "FROM sanpham\n"
                    + "INNER JOIN giasanpham ON giasanpham.Masp = sanpham.Masp AND sanpham.Masp = ?\n"
                    + "INNER JOIN chitietbaohanh ON chitietbaohanh.Masp = sanpham.Masp\n"
                    + "INNER JOIN baohanh ON baohanh.Mabaohanh = chitietbaohanh.Mabaohanh\n"
                    + "INNER JOIN chitietkhuyenmai ON chitietkhuyenmai.Masp = sanpham.Masp\n"
                    + "INNER JOIN khuyenmai ON khuyenmai.Makm = chitietkhuyenmai.Machitietkhuyenmai");
            stm.setInt(1, Masp);
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt(1));
                    System.out.println("123");
                    result.add(rs.getString(2));
                    result.add(rs.getDouble(3));
                    result.add(rs.getInt(4));
                    result.add(rs.getString(5));
                    result.add(rs.getInt(6));
                    result.add(rs.getInt(7));
                    result.add(rs.getDouble(8));
                    result.add(rs.getString(9));
                    result.add(rs.getString(10));
                    result.add(rs.getString(11));
                }
            }
            return result;

        } catch (Exception e) {
            return null;
        } finally {
            db.closeConnection();
        }

    }

    public ArrayList layMadh() {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT sanpham.Masp\n"
                    + "FROM sanpham\n"
                    + "ORDER BY sanpham.Masp ASC");
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt("Masp"));
                }
            }
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            db.closeConnection();
        }
    }

    public ArrayList layMadh2(String tenTrangThai) {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT sanpham.Masp\n"
                    + "FROM sanpham\n"
                    + "WHERE sanpham.TrangThai = ?"
                    + "ORDER BY sanpham.Masp ASC");
            stm.setString(1, tenTrangThai);
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt("Masp"));
                }
            }
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            db.closeConnection();
        }
    }

}
