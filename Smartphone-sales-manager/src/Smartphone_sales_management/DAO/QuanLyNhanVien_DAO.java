/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import Smartphone_sales_management.DBConnect;
import Smartphone_sales_management.DTO.Model_NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            PreparedStatement stm = db.getConnection().prepareStatement("select * from NhanVien where Trangthai = 'T'");
            rs = stm.executeQuery();
            while (rs.next()) {
                Model_NhanVien a = new Model_NhanVien();
                a.setMaNV(rs.getInt("Manv"));
                a.setTenNV(rs.getString("Tennv"));
                a.setSoCCCD(rs.getInt("SoCCCD"));
                a.setTuoi(rs.getInt("Tuoi"));
                a.setDiaChi(rs.getString("DiaChi"));
                a.setChucDanh(rs.getString("Chucdanh"));
//                a.setTrangThai(rs.getString("Trangthai"));
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
                   String sqlString = ("insert into nhanvien(Tennv,SoCCCD,Tuoi,Diachi,ChucDanh,TrangThai) values (?,?,?,?,?,?)");
		try {
			preparedStatement = db.getConnection().prepareStatement(sqlString);
//                        preparedStatement.setInt(1, NhanVien.getMaNV());
			preparedStatement.setString(1, NhanVien.getTenNV());
                        preparedStatement.setInt(2, NhanVien.getSoCCCD());
                        preparedStatement.setInt(3, NhanVien.getTuoi());
                        preparedStatement.setString(4, NhanVien.getDiaChi());
                        preparedStatement.setString(5, NhanVien.getChucDanh());
                        preparedStatement.setString(6, NhanVien.getTrangThai());
                        
                        

			int n = preparedStatement.executeUpdate();
                        if (n != 0) {
                     JOptionPane.showMessageDialog(null, "Th??m d??? li???u th??nh c??ng", "Th??ng b??o",
                        JOptionPane.INFORMATION_MESSAGE);
			isSuccess = true;
                        }
		}
		catch(SQLException ex) {
			 System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Th??m d??? li???u th???t b???i", "L???i", JOptionPane.ERROR_MESSAGE);
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
    public boolean deleteNhanVien(Model_NhanVien NhanVien) {
		boolean isSuccess = false;
		db.setupConnection();
			String sqlString = "update nhanvien set  TrangThai = ? where Manv=?";

		try {
			preparedStatement = db.getConnection().prepareStatement(sqlString);

			preparedStatement.setString(1, NhanVien.getTrangThai());
                        preparedStatement.setInt(2,NhanVien.getMaNV());

                        int n = preparedStatement.executeUpdate();
                        if (n != 0) {
                        JOptionPane.showMessageDialog(null, "X??a d??? li???u th??nh c??ng", "Th??ng b??o",
                        JOptionPane.INFORMATION_MESSAGE);
			isSuccess = true;
                        }
		}
		catch(SQLException ex) {
			 System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "X??a d??? li???u th???t b???i", "L???i", JOptionPane.ERROR_MESSAGE);
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
                     JOptionPane.showMessageDialog(null, "Update d??? li???u th??nh c??ng", "Th??ng b??o",
                        JOptionPane.INFORMATION_MESSAGE);
			isSuccess = true;
                        }
		}
		catch(SQLException ex) {
			 System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Th??m d??? li???u th???t b???i", "L???i", JOptionPane.ERROR_MESSAGE);
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
