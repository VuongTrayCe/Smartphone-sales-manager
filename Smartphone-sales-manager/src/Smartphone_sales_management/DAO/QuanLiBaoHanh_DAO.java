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
                    + "                    FROM chitietbaohanh\n"
                    + "                    WHERE chitietbaohanh.TrangThai =\"T\"");
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

    public ArrayList layctOfctBH(int Mactbh) {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT chitietbaohanh.Mabaohanh, chitietbaohanh.Masp\n"
                    + "FROM chitietbaohanh\n"
                    + "WHERE chitietbaohanh.Machitietbaohanh = ?");
            stm.setInt(1, Mactbh);
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt(1));
                    result.add(rs.getInt(2));
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
            stm.setString(1, model.getThoigianbh());
            stm.setString(2, model.getTrangthai());
            stm.setInt(3, model.getMabh());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return success = false;
        } finally {
            db.closeConnection();
        }
        return success;
    }

    public ArrayList dsMasp() {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT sanpham.Masp\n"
                    + "FROM sanpham");
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt(1));
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

    public boolean themCTDH(ModelBaoHanh model) {
        db.setupConnection();
        boolean success = true;
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("INSERT INTO chitietbaohanh(chitietbaohanh.Mabaohanh,chitietbaohanh.Masp,chitietbaohanh.TrangThai)\n"
                    + "VALUES	(?,?,\"T\")");
            stm.setInt(1, model.getMabh());
            stm.setInt(2, model.getMasp());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return success = false;
        } finally {
            db.closeConnection();
        }
        return success;
    }

    public int chitietbaohanh(ModelBaoHanh model) {
        db.setupConnection();
        int result = -1;
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT chitietbaohanh.Machitietbaohanh\n"
                    + "FROM chitietbaohanh\n"
                    + "WHERE chitietbaohanh.Mabaohanh = ? AND chitietbaohanh.Masp = ? AND chitietbaohanh.TrangThai = \"T\"");
            stm.setInt(1, model.getMabh());
            stm.setInt(2, model.getMasp());
            rs = stm.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    result = (int) rs.getInt(1);
                }
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            db.closeConnection();
        }
    }

    public boolean xoaCTBH(int Mactbh) {
        db.setupConnection();
        boolean success = true;
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("UPDATE chitietbaohanh\n"
                    + "SET chitietbaohanh.TrangThai = \"F\" WHERE chitietbaohanh.Machitietbaohanh = ?");
            stm.setInt(1, Mactbh);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return success = false;
        } finally {
            db.closeConnection();
        }
        return success;
    }

    public ArrayList getDanhSachBaoHanh_DAO() {
        db.setupConnection();
        ArrayList result = new ArrayList();
        String query = "select chitietdonhang.Masp, donhang.Makh, sanpham.Tensp,khachhang.Tenkh,donhang.Ngayban,baohanh.Thoigianbaohanh from baohanh,chitietbaohanh,sanpham,chitietdonhang,donhang,khachhang where chitietdonhang.Madh=donhang.Madh and chitietdonhang.Masp=sanpham.Masp and donhang.Makh=khachhang.Makh and chitietdonhang.Machitietbaohanh=chitietbaohanh.Machitietbaohanh and chitietbaohanh.Mabaohanh=baohanh.Mabaohanh and donhang.Trangthai='Hoàn Thành'";
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query);
            rs = stm.executeQuery();
            int i = 1;
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add((i));
                    a.add(rs.getInt("Masp"));
                    a.add(rs.getInt("Makh"));
                    a.add(rs.getString("Tensp"));
                    a.add(rs.getString("Tenkh"));
                    a.add(rs.getDate("Ngayban"));
                    a.add(rs.getString("Thoigianbaohanh"));
                    result.add(a);
                    i++;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        } finally {
            db.closeConnection();
        }
        return result;
    }

    public ArrayList getALLBaoHanhTheoTrangThai(String trangthai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
