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
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Madh, donhang.Ngayban,SUM((giasanpham.Giaban - giasanpham.Giaban * khuyenmai.`%km` / 100) * chitietdonhang.Soluong) AS \"TongTien\",donhang.Trangthai \n"
                    + "FROM donhang\n"
                    + "INNER JOIN chitietdonhang ON chitietdonhang.Madh = donhang.Madh \n"
                    + "INNER JOIN sanpham ON sanpham.Masp = chitietdonhang.Masp\n"
                    + "INNER JOIN giasanpham ON giasanpham.Masp = sanpham.masp\n"
                    + "INNER JOIN chitietkhuyenmai ON chitietkhuyenmai.Masp = sanpham.Masp\n"
                    + "INNER JOIN khuyenmai ON khuyenmai.Makm = chitietkhuyenmai.Makm\n"
                    + "GROUP BY Madh ");
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                //Tao ra vector de luu du lieu cua tung thuoc tinh
                a.add(rs.getInt("Madh"));

                a.add(rs.getDate("Ngayban"));
                a.add(rs.getInt("Tongtien"));
                a.add(rs.getString("Trangthai"));
                dsdh.add(a);
            }
            for (Object object : dsdh) {
                System.out.println(object);
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
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Trangthai, sanpham.Tensp, sanpham.Loaisp,chitietdonhang.Soluong,khuyenmai.`%km`,baohanh.Ngaybatdau, baohanh.Ngayketthuc,giasanpham.Giaban,(giasanpham.Giaban - giasanpham.Giaban * khuyenmai.`%km`/ 100) AS \"Gia sau khuyen mai\"\n"
                    + "FROM donhang\n"
                    + "INNER JOIN chitietdonhang ON donhang.Madh = chitietdonhang.Madh AND donhang.Madh = ? \n"
                    + "INNER JOIN sanpham ON sanpham.Masp = chitietdonhang.Masp \n"
                    + "INNER JOIN chitietkhuyenmai ON chitietkhuyenmai.Masp = sanpham.Masp\n"
                    + "INNER JOIN khuyenmai ON khuyenmai.Makm = chitietkhuyenmai.Makm\n"
                    + "INNER JOIN chitietbaohanh ON chitietbaohanh.Masp = sanpham.Masp\n"
                    + "INNER JOIN baohanh ON baohanh.Mabaohanh = chitietbaohanh.Mabaohanh\n"
                    + "INNER JOIN giasanpham ON giasanpham.Masp = sanpham.Masp");
            stm.setInt(1, Madh);
            rs = stm.executeQuery();
            System.out.println(rs);
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add(rs.getString(1));
                    a.add(rs.getString(2));
                    a.add(rs.getString(3));
                    a.add(rs.getInt(4));
                    a.add(rs.getString(5));
                    a.add(rs.getString(6));
                    a.add(rs.getString(7));
                    a.add(rs.getInt(8));
                    a.add(rs.getInt(9));
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
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT Madh FROM donhang");
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
}
