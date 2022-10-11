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
import java.util.Vector;

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
                a.setMaNV(rs.getString("Manv"));
                a.setTenNV(rs.getString("Tennv"));
                a.setSoCCCD(rs.getString("SoCCCD"));
                a.setTuoi(rs.getString("Tuoi"));
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
		Connection conn = db.getConnection();
		String sqlString = "insert into nhanvien values (?, ?, ?, ?, ?,?,?)";

		try {
			preparedStatement = conn.prepareStatement(sqlString);

			preparedStatement.setString(1, NhanVien.getMaNV());
			preparedStatement.setString(2, NhanVien.getTenNV());
			preparedStatement.setString(3, NhanVien.getTuoi());
                        preparedStatement.setString(4, NhanVien.getSoCCCD());
                        preparedStatement.setString(5, NhanVien.getDiaChi());
                        preparedStatement.setString(6, NhanVien.getChucDanh());
                        preparedStatement.setString(7, NhanVien.getTrangThai());
                        
                        

			preparedStatement.executeUpdate();

			isSuccess = true;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				conn.close();
				preparedStatement.close();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

		return isSuccess;
	}
}
