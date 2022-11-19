/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import Smartphone_sales_management.DBConnect;
import Smartphone_sales_management.DTO.ModelBaoHanh;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class QuanLiBaoHanh_DAO {

    DBConnect db = new DBConnect();
    ResultSet rs = null;

    public ArrayList layDanhSachBaoHanh() {
        ArrayList dsbh = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT baohanh.Mabaohanh, baohanh.Thoigianbaohanh, baohanh.Trangthai\n"
                    + "FROM baohanh");
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add(rs.getInt(1));
                    a.add(rs.getString(2));
                    a.add(rs.getString(3));
                    dsbh.add(a);
                }
            }
            return dsbh;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            db.closeConnection();
        }
    }

    public ArrayList layDanhSachCTBH() {
        ArrayList dsctbh = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT chitietbaohanh.Machitietbaohanh, chitietbaohanh.Mabaohanh, chitietbaohanh.Masp\n"
                    + "FROM chitietbaohanh");
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add(rs.getInt(1));
                    a.add(rs.getInt(2));
                    a.add(rs.getInt(3));
                    dsctbh.add(a);
                }
            }
            return dsctbh;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            db.closeConnection();
        }
    }

    public ArrayList layctBH(int Mabh) {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT baohanh.Thoigianbaohanh,baohanh.Trangthai\n"
                    + "FROM baohanh\n"
                    + "WHERE baohanh.Mabaohanh = ?");
            stm.setInt(1, Mabh);
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString(1));
                    result.add(rs.getString(2));
                }
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            db.closeConnection();
        }
    }

    public boolean themBH(ModelBaoHanh model) {
        db.setupConnection();
        boolean success = true;
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("INSERT INTO baohanh(Thoigianbaohanh,Trangthai)\n"
                    + "VALUES (?,?)");
            stm.setString(1, model.getThoigianbh());
            stm.setString(2, model.getTrangthai());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
            return success;
        } finally {
            db.closeConnection();
        }
        return success;
    }

    public boolean xoaBH(int Mabh) {
        db.setupConnection();
        boolean success = true;
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("UPDATE baohanh\n"
                    + "SET baohanh.Trangthai = \"F\" WHERE baohanh.Mabaohanh = ?");
            stm.setInt(1, Mabh);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return success = false;
        } finally {
            db.closeConnection();
        }
        return success;
    }

    public boolean suaBH(ModelBaoHanh model) {
        db.setupConnection();
        boolean success = true;
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("UPDATE baohanh\n"
                    + "SET baohanh.Thoigianbaohanh = ? ,baohanh.Trangthai = ? WHERE baohanh.Mabaohanh = ?");
            stm.setString(1,model.getThoigianbh());
            stm.setString(2,model.getTrangthai());
            stm.setInt(3,model.getMabh());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return success = false;
        } finally {
            db.closeConnection();
        }
        return success;
    }
}
