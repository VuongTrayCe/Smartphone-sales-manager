/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Smartphone_sales_management.DBConnect;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Smartphone_sales_management.UI.Model.Model_TaiKhoan;
import java.util.Vector;

public class QuanLyTaiKhoan_DAO {

    DBConnect db = new DBConnect();
    ResultSet rs = null;
    // Thêm một nhân viên

    public ArrayList getDanhsachTaiKhoan() {
        ArrayList ds = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT taikhoan.Matk , taikhoan.Manv, taikhoan.Tendangnhap, taikhoan.Matkhau, taikhoan.TrangThai\n"
                    + "FROM taikhoan");
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getInt("Matk"));
                a.add(rs.getInt("Manv"));
                a.add(rs.getString("Tendangnhap"));
                a.add(rs.getString("Matkhau")) ;
                a.add(rs.getString("TrangThai"));
                ds.add(a);
            }
            System.out.println(rs);
            return ds;
        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }
    }

    public ArrayList getDanhSachChiTiet1TaiKhoan_DAO(int selectedIndex) throws SQLException {

        ArrayList result = new ArrayList();
        db.setupConnection();

        try {

            PreparedStatement stm = db.getConnection().prepareStatement("SELECT taikhoan.Matk , taikhoan.Manv, taikhoan.Tendangnhap, taikhoan.Matkhau, taikhoan.TrangThai\n"
                    + "FROM taikhoan");
            stm.setInt(1, selectedIndex);
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    Model_TaiKhoan model = new Model_TaiKhoan();
                    model.setMaTaiKhoan(rs.getInt(1));
                    model.setMaNhanVien(rs.getInt(2));
                    model.setTaiKhoan(rs.getString(3));
                    model.setMatKhau(rs.getString(4));
                    model.setQuyen(rs.getInt(5));

                }
            }
        } catch (SQLException e) {
            return null;
        } finally {
            db.closeConnection();
        }

        return result;
    }

    public ArrayList getMa() {

        ArrayList result = new ArrayList<>();
        db.setupConnection();

        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select Manv from nhanvien");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt("Manv"));
                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi");
        } finally {
            db.closeConnection();
        }
        return result;
    }

}
