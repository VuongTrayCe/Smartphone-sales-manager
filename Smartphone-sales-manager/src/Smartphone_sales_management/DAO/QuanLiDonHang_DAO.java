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
public class QuanLiDonHang_DAO {

    DBConnect dbConnect = new DBConnect();
    ResultSet rs = null;

    public ArrayList layDanhSachDonHang_DAO() {
        ArrayList dsdh = new ArrayList();
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Madh, donhang.Ngayban, donhang.SoLuong, donhang.Tongtien, donhang.Trangthai\n"
                    + "FROM	donhang ");
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getInt("Madh"));
                a.add(rs.getDate("Ngayban"));
                a.add(rs.getInt("SoLuong"));
                a.add(rs.getInt("Tongtien"));
                a.add(rs.getString("Trangthai"));
                dsdh.add(a);
            }
            return dsdh;
        } catch (SQLException e) {
            return null;
        } finally {
            dbConnect.closeConnection();
        }
    }

    public ArrayList layDanhSachChiTietDonHang(int Madh) throws SQLException {
        ArrayList result = new ArrayList();
        dbConnect.setupConnection();

        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Madh, sanpham.Tensp, sanpham.Loaisp,chitietdonhang.Soluong, khuyenmai.Ptkm,baohanh.Thoigianbaohanh, chitietdonhang.giaban, chitietdonhang.giasaukm,donhang.Trangthai\n"
                    + "FROM donhang\n"
                    + "INNER JOIN chitietdonhang ON chitietdonhang.Madh = donhang.Madh AND donhang.Madh = ?\n"
                    + "INNER JOIN sanpham ON sanpham.Masp = chitietdonhang.Masp\n"
                    + "INNER JOIN chitietkhuyenmai ON chitietkhuyenmai.Masp = sanpham.Masp\n"
                    + "INNER JOIN khuyenmai ON khuyenmai.Makm = chitietkhuyenmai.Makm \n"
                    + "INNER JOIN chitietbaohanh ON chitietbaohanh.Masp = sanpham.Masp\n"
                    + "INNER JOIN baohanh ON baohanh.Mabaohanh = chitietbaohanh.Mabaohanh");
            stm.setInt(1, Madh);
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add(rs.getInt(1));
                    a.add(rs.getString(2));
                    a.add(rs.getString(3));
                    a.add(rs.getInt(4));
                    a.add(rs.getInt(5));
                    a.add(rs.getString(6));
                    a.add(rs.getDouble(7));
                    a.add(rs.getDouble(8));
                    a.add(rs.getString(9));
                    result.add(a);
                }
            }

            return result;
        } catch (SQLException e) {
            return null;
        } finally {
            dbConnect.closeConnection();
        }

    }

    public ArrayList layMadh() {
        ArrayList result = new ArrayList();
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Madh\n"
                    + "FROM donhang\n"
                    + "ORDER BY donhang.Madh ASC");
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt("Madh"));
                }
            }

        } catch (SQLException e) {
            return null;
        } finally {
            dbConnect.closeConnection();
        }
        return result;
    }

    public ArrayList getDanhSachDonHangTheoTrangThai(int indexTrangThai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList layMadh2(String tenTrangThai) {
        ArrayList result = new ArrayList();
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Madh\n"
                    + "FROM donhang\n where donhang.Trangthai = ?"
                    + "ORDER BY donhang.Madh ASC");
            stm.setString(1, tenTrangThai);
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt("Madh"));
                }
            }

        } catch (SQLException e) {
            return null;
        } finally {
            dbConnect.closeConnection();
        }
        return result;
    }

    public ArrayList getDanhSachDonHangTheoTrangThai(String tenTrangThai) {

        ArrayList dsdh = new ArrayList();
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Madh, donhang.Ngayban, donhang.SoLuong, donhang.Tongtien, donhang.Trangthai\n"
                    + "FROM	donhang where donhang.Trangthai = ? ");
            stm.setString(1, tenTrangThai);
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getInt("Madh"));
                a.add(rs.getDate("Ngayban"));
                a.add(rs.getInt("SoLuong"));
                a.add(rs.getInt("Tongtien"));
                a.add(rs.getString("Trangthai"));
                dsdh.add(a);
            }
            return dsdh;
        } catch (SQLException e) {
            return null;
        } finally {
            dbConnect.closeConnection();
        }

    }

    public void updateHuyDonHang(int Madh) {
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("UPDATE donhang\n"
                    + "SET donhang.Trangthai = \"Hủy đơn\"\n"
                    + "WHERE donhang.Madh = ?");
            stm.setInt(1, Madh);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.closeConnection();
        }
    }

    public void updateXacNhanDonHang(int Madh) {
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("UPDATE donhang\n"
                    + "SET donhang.Trangthai = \"Đã xử lí\"\n"
                    + "WHERE donhang.Madh = ?");
            stm.setInt(1, Madh);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.closeConnection();
        }
    }

}
