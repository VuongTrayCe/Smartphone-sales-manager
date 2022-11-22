/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;
import Smartphone_sales_management.DBConnect;
import Smartphone_sales_management.DTO.Model_NhaCungCap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;
/**
 *
 * @author lehongthai
 */
public class QuanLyNhaCungCap_DAO {
     DBConnect db = new DBConnect();
    private PreparedStatement preparedStatement;
    ResultSet rs = null;

    public ArrayList<Model_NhaCungCap> getDanhSachNhaCC_DAO() {

        ArrayList<Model_NhaCungCap> dsncc = new ArrayList<Model_NhaCungCap>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from nhacungcap where TrangThai='T'");
            rs = stm.executeQuery();
            while (rs.next()) {
                Model_NhaCungCap a = new Model_NhaCungCap();
                a.setMacc(rs.getInt("Mancc"));
                a.setTenncc(rs.getString("Tenncc"));
                a.setSDT(rs.getInt("SDT"));
                a.setDiaChi(rs.getString("DiaChi"));
                a.setDiaChi(rs.getString("DiaChi"));
                dsncc.add(a);

            }
            return dsncc;
        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }
    }
    public boolean insertNhaCC(Model_NhaCungCap NhaCungCap) {
		boolean isSuccess = false;
                 db.setupConnection();
                   String sqlString = ("insert into nhacungcap(Tenncc,SDT,Diachi,TrangThai) values (?,?,?,?)");
		try {
			preparedStatement = db.getConnection().prepareStatement(sqlString);
//                        preparedStatement.setInt(1, NhanVien.getMaNV());
			preparedStatement.setString(1, NhaCungCap.getTenncc());
                        preparedStatement.setInt(2, NhaCungCap.getSDT());
                        preparedStatement.setString(3, NhaCungCap.getDiaChi());
                        preparedStatement.setString(4, NhaCungCap.getTrangThai());
                        
                        

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
    public boolean deleteNhacc(Model_NhaCungCap NhaCC) {
		boolean isSuccess = false;
		db.setupConnection();
			String sqlString = "update nhacungcap set  TrangThai = ? where Mancc=?";

		try {
			preparedStatement = db.getConnection().prepareStatement(sqlString);

			preparedStatement.setString(1, NhaCC.getTrangThai());
                        preparedStatement.setInt(2,NhaCC.getMacc());

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
       public boolean updateNhaCC(Model_NhaCungCap NhaCungCap) {
		boolean isSuccess = false;
                db.setupConnection();
		String sqlString = "update nhacungcap set Tenncc = ?, SDT = ?, DiaChi = ?  where Mancc=?";

		try {
			preparedStatement = db.getConnection().prepareStatement(sqlString);

			preparedStatement.setString(1, NhaCungCap.getTenncc());
			preparedStatement.setInt(2, NhaCungCap.getSDT());
                        preparedStatement.setString(3, NhaCungCap.getDiaChi());
                        preparedStatement.setInt(4,NhaCungCap.getMacc());

                        int n = preparedStatement.executeUpdate();
                        if (n != 0) {
                     JOptionPane.showMessageDialog(null, "Update dữ liệu thành công", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
			isSuccess = true;
                        }
		}
		catch(SQLException ex) {
			 System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Update dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
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
