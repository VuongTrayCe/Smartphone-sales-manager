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
import com.mysql.cj.MessageBuilder;
import com.mysql.cj.protocol.Message;
import java.util.Vector;

public class QuanLyTaiKhoan_DAO {

    DBConnect db = new DBConnect();
    ResultSet rs = null;
    // Thêm một nhân viên

    public ArrayList getDanhsachTaiKhoan() {
        ArrayList ds = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT taikhoan.Matk , taikhoan.Manv, taikhoan.Tendangnhap, taikhoan.Matkhau\n"
                    + "FROM taikhoan");
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getInt("Matk"));
                a.add(rs.getInt("Manv"));
                a.add(rs.getString("Tendangnhap"));
                a.add(rs.getString("Matkhau"));
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
                    model.setTrangthai(rs.getString(5));

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
            PreparedStatement stm = db.getConnection().prepareStatement("select Matk from taikhoan");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt("Matk"));
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

    public ArrayList getThongTinTaiKhoan() {
        ArrayList dstk = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select taikhoan.Tendangnhap, taikhoan.Matkhau from taikhoan");
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getString("Tendangnhap"));

                a.add(rs.getString("Matkhau"));
                dstk.add(a);
                i++;
            }
            return dstk;
        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }

    }

    public ArrayList getALLAccount(){
        ArrayList dstk = new ArrayList();
        db.setupConnection();
        try {
            
            PreparedStatement stm = db.getConnection().prepareStatement("select taikhoan.Tendangnhap, taikhoan.Matkhau from taikhoan");
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getString("Tendangnhap"));
                    
                a.add(rs.getString("Matkhau"));
 
                dstk.add(a);
            }
            return dstk;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            db.closeConnection();
        }
return dstk;
    }

}
