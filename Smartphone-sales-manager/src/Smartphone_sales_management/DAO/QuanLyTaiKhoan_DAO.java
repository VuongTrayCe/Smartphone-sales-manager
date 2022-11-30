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
import Smartphone_sales_management.DTO.Model_SanPham;
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
                    + "FROM taikhoan\n"
                    + "WHERE taikhoan.TrangThai='T'");
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

    public ArrayList getDanhsachTaiKhoan2() {
        ArrayList ds = new ArrayList<>();
        db.setupConnection();
        try {
            String query = "SELECT taikhoan.Matk , taikhoan.Manv,nhanvien.Tennv,taikhoan.Tendangnhap, taikhoan.Matkhau\n" +
"FROM taikhoan,nhanvien\n" +
"WHERE taikhoan.TrangThai=\"T\" and nhanvien.Manv=taikhoan.Manv;";
            PreparedStatement stm = db.getConnection().prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getInt("Matk"));
                a.add(rs.getInt("Manv"));
                a.add(rs.getString("Tennv"));
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
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT Matk from taikhoan");
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

    public boolean themTaiKhoan(Model_TaiKhoan Taikhoan) throws SQLException {
        boolean success = true;
        db.setupConnection();
        try {
            String sql = ("INSERT INTO taikhoan(Matk,Manv,Tendangnhap,Matkhau,TrangThai)\n"
                    + "VALUES(?,?,?,?,\"T\")");
            PreparedStatement stm;
            stm = db.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setInt(1, Taikhoan.getMaTaiKhoan());
            stm.setInt(2, Taikhoan.getMaNhanVien());
            stm.setString(3, Taikhoan.getTaiKhoan());
            stm.setString(4, Taikhoan.getMatKhau());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return success = false;
        } finally {
            db.closeConnection();
        }
        return success;
    }

    public ArrayList layDanhSachNV() {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT nhanvien.Manv,nhanvien.Tennv \n"
                    + "FROM nhanvien");
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add(rs.getString("Tennv"));
                    a.add(rs.getInt("Manv"));
                    result.add(a);
                }
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return null;
    }

    public void themNV(int Matk, Model_TaiKhoan model) {
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("INSERT INTO Taikhoan(Matk,Manv,TrangThai)\n"
                    + "VALUES (?,?,\"T\")");
            stm.setInt(1, Matk);
            stm.setInt(2, model.getMaNhanVien());
            //     stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }

    public void xoaTK(int Matk) {
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("UPDATE taikhoan\n"
                    + "SET taikhoan.TrangThai = \"F\" WHERE taikhoan.Matk = ?;");
            stm.setInt(1, Matk);
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }

    public boolean suaTK(Model_TaiKhoan model) {
        db.setupConnection();
        boolean success = true;
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("UPDATE taikhoan "
                    + "SET taikhoan.Tendangnhap = ? , taikhoan.Matkhau = ?  "
                    + "WHERE taikhoan.Matk = ?");

            stm.setString(1, model.getTaiKhoan());
            stm.setString(2, model.getMatKhau());
            stm.setInt(3, model.getMaTaiKhoan());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return success = false;
        } finally {
            db.closeConnection();
        }
        return success;
    }

    public ArrayList getThongTinTaiKhoan() {
        ArrayList dstk = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select taikhoan.Tendangnhap, taikhoan.Matkhau from taikhoan where taikhoan.TrangThai='T'");
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

    public ArrayList getALLAccount() {
        ArrayList dstk = new ArrayList();
        db.setupConnection();
        try {

            PreparedStatement stm = db.getConnection().prepareStatement("select taikhoan.Manv,taikhoan.Tendangnhap, taikhoan.Matkhau from taikhoan where taikhoan.TrangThai='T'");
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getInt("Manv"));
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

    public ArrayList layDanhSachChiTietTK(int Matk) {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT taikhoan.Matk,nhanvien.Tennv,taikhoan.Tendangnhap,taikhoan.Matkhau \n"
                    + "FROM taikhoan,nhanvien\n"
                    + "WHERE taikhoan.Manv = nhanvien.Manv AND taikhoan.Matk = ? ");
            stm.setInt(1, Matk);
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt(1));
                    result.add(rs.getString(2));
                    result.add(rs.getString(3));
                    result.add(rs.getString(4));
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

    public ArrayList getALLQuyenTk(int manv) {
        ArrayList dstk = new ArrayList();
        db.setupConnection();
        try {
            String query = "select quyen.Tenquyen from quyen,taikhoan,quyen_tk,nhanvien where taikhoan.Matk = quyen_tk.Matk and quyen_tk.Maquyen=quyen.Maquyen and taikhoan.Manv=nhanvien.Manv and nhanvien.Manv=?";
            PreparedStatement stm = db.getConnection().prepareStatement(query);
            stm.setInt(1, manv);
            rs = stm.executeQuery();
            while (rs.next()) {
                dstk.add(rs.getString("Tenquyen"));
            }
            return dstk;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            db.closeConnection();
        }
        return dstk;
    }

    public String getTennv(int l) {
         String tennv="";
        db.setupConnection();
        try {
            String query = "select nhanvien.Tennv from nhanvien where nhanvien.Manv=?";
            PreparedStatement stm = db.getConnection().prepareStatement(query);
            stm.setInt(1,l);
            rs = stm.executeQuery();
            while (rs.next()) {
                tennv = rs.getString("Tennv");
            }
            return tennv;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            db.closeConnection();
        }
        return tennv;
    }

    public void XoaTaiKhoanCu(int maNhanVien) {
        
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("UPDATE taikhoan,nhanvien\n"
                    + "SET taikhoan.TrangThai = \"F\" WHERE taikhoan.Manv = nhanvien.Manv and nhanvien.Manv=?");
            stm.setInt(1, maNhanVien);
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }

    public ArrayList getTenDangNhap() {
        
         ArrayList data = new ArrayList();
        db.setupConnection();
        try {
            String query = "select taikhoan.Tendangnhap from taikhoan where taikhoan.TrangThai='T'";
            PreparedStatement stm = db.getConnection().prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                data.add(rs.getString("Tendangnhap"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            db.closeConnection();
        }
        return data;
        
    }
}
