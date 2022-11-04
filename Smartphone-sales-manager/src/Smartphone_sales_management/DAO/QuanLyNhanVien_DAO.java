/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import Smartphone_sales_management.DBConnect;
import Smartphone_sales_management.UI.Model.Model_NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author lehongthai
 */
public class QuanLyNhanVien_DAO {

    DBConnect db = new DBConnect();
    private PreparedStatement preparedStatement;
    ResultSet rs = null;

    public ArrayList<Model_NhanVien> getDanhSachNhanVien_DAO() {

        ArrayList<Model_NhanVien> dsnv = new ArrayList<Model_NhanVien>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from NhanVien ");
            rs = stm.executeQuery();
            while (rs.next()) {
                Model_NhanVien a = new Model_NhanVien();
                a.setMaNV(rs.getInt("Manv"));
                a.setTenNV(rs.getString("Tennv"));
                a.setSoCCCD(rs.getInt("SoCCCD"));
                a.setTuoi(rs.getInt("Tuoi"));
                a.setDiaChi(rs.getString("DiaChi"));
                a.setChucDanh(rs.getString("Chucdanh"));
                a.setTrangThai(rs.getString("Trangthai"));
                dsnv.add(a);

            }
            return dsnv;
        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }
    }
    public boolean insertNhanVien(Model_NhanVien NhanVien) {
		boolean isSuccess = false;
                 db.setupConnection();
		String sqlString = "insert into nhanvien values ( ?,?, ?, ?, ?, ?,? )";
		try {
			preparedStatement = db.getConnection().prepareStatement(sqlString);
                        preparedStatement.setInt(1, NhanVien.getMaNV());
			preparedStatement.setString(2, NhanVien.getTenNV());
                        preparedStatement.setInt(3, NhanVien.getSoCCCD());
                        preparedStatement.setInt(4, NhanVien.getTuoi());
                        preparedStatement.setString(5, NhanVien.getDiaChi());
                        preparedStatement.setString(6, NhanVien.getChucDanh());
                        preparedStatement.setString(7, NhanVien.getTrangThai());
                        
                        

			int n = preparedStatement.executeUpdate();
                        if (n != 0) {
                     JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
			isSuccess = true;
                        }
		}
		catch(SQLException ex) {
			 System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			try {
                                   db.closeConnection();
				preparedStatement.close();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

		return isSuccess;
	}
    public boolean deleteNhanVien(int MaNV) {
		boolean isSuccess = false;
		db.setupConnection();
		String sqlString = "delete from nhanvien where MaNV=?";

		try {
			preparedStatement = db.getConnection().prepareStatement(sqlString);

			preparedStatement.setInt(1, MaNV);

                        int n = preparedStatement.executeUpdate();
                        if (n != 0) {
                        JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
			isSuccess = true;
                        }
		}
		catch(SQLException ex) {
			 System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Xóa dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			try {
				db.closeConnection();
				preparedStatement.close();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

		return isSuccess;
	}
       public boolean updateNhanVien(Model_NhanVien NhanVien) {
		boolean isSuccess = false;
                db.setupConnection();
		String sqlString = "update nhanvien set TenNV = ?, SoCCCD = ?, Tuoi = ?, DiaChi = ?, ChucDanh = ? where Manv=?";

		try {
			preparedStatement = db.getConnection().prepareStatement(sqlString);

			preparedStatement.setString(1, NhanVien.getTenNV());
			preparedStatement.setInt(2, NhanVien.getSoCCCD());
			preparedStatement.setInt(3, NhanVien.getTuoi());
                        preparedStatement.setString(4, NhanVien.getDiaChi());
			preparedStatement.setString(5, NhanVien.getChucDanh());
                        preparedStatement.setInt(6,NhanVien.getMaNV());

                        int n = preparedStatement.executeUpdate();
                        if (n != 0) {
                     JOptionPane.showMessageDialog(null, "Update dữ liệu thành công", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
			isSuccess = true;
                        }
		}
		catch(SQLException ex) {
			 System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			try {
                                   db.closeConnection();
				preparedStatement.close();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

		return isSuccess;
	}
    
}
