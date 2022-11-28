/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;
import Smartphone_sales_management.DBConnect;
import Smartphone_sales_management.UI.Component.KhachHanggComponent.KhachHangg;
import Smartphone_sales_management.UI.Model.Model_KhachHang;
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
 * @author Hiep
 */
public class QuanLiKhachHang_DAO {
     DBConnect db = new DBConnect();
    private PreparedStatement preparedStatement;
    ResultSet rs = null;
    private Iterable<Model_KhachHang> dskh;
    
    public ArrayList<Model_KhachHang> getDanhSachKhachHang_DAO(){
        
        ArrayList<Model_KhachHang> dskh = new ArrayList<Model_KhachHang>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from khachhang where TrangThai='T'");
            rs = stm.executeQuery();
            while (rs.next()) {
                Model_KhachHang a = new Model_KhachHang();
                a.setMakh(rs.getInt("Makh"));
                a.setTenkh(rs.getString("Tenkh"));
                a.setCmnd(rs.getString("Cmnd"));
                a.setSDT(rs.getString("SDT"));
                a.setDiaChi(rs.getString("DiaChi"));
                a.setEmail(rs.getString("Email"));
                a.setNgaytao(rs.getString("Ngaytao"));
                a.setDiemso(rs.getInt("Diemso"));
                a.setTrangThai(rs.getString("TrangThai"));
                dskh.add(a);
                
            }
             return dskh;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.closeConnection();
        }
        return null;
    }
    public boolean inserKhachHang(Model_KhachHang KhachHang) {
        boolean isSuccess = false;
        db.setupConnection();
        String sqlString = "insert into khachhang(Tenkh,Cmnd,SDT,DiaChi,Email,Ngaytao,Diemso,TrangThai) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            preparedStatement = db.getConnection().prepareStatement(sqlString);
         //   preparedStatement.setInt(1, KhachHang.getMakh());
//            preparedStatement.setString(1, KhachHang.getTenkh());
//            preparedStatement.setString(2, KhachHang.getCmnd());
//            preparedStatement.setInt(3, KhachHang.getSDT());
//            preparedStatement.setString(4, KhachHang.getDiaChi());
//            preparedStatement.setString(5, KhachHang.getEmail());
//            preparedStatement.setString(6, KhachHang.getNgaytao());
//            preparedStatement.setInt(7, KhachHang.getDiemso());
//            preparedStatement.setString(8, KhachHang.getTrangThai());
            
             preparedStatement.setString(1, KhachHang.getTenkh());
            preparedStatement.setString(2, KhachHang.getCmnd());
            preparedStatement.setString(3, KhachHang.getSDT());
            preparedStatement.setString(4, KhachHang.getDiaChi());
            preparedStatement.setString(5, KhachHang.getEmail());
            preparedStatement.setString(6, KhachHang.getNgaytao());
            preparedStatement.setInt(7, KhachHang.getDiemso());
            preparedStatement.setString(8, KhachHang.getTrangThai());
            
            int n = preparedStatement.executeUpdate();
            if (n != 0) {
                JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công", "Thông báo", 
                        JOptionPane.INFORMATION_MESSAGE);
                isSuccess = true;
            }
            
            }
        catch(SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
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
    public boolean deleteKhachHang(Model_KhachHang KhachHang) {
        boolean isSuccess = false;
        db.setupConnection();
        String sqlString = "update khachhang set TrangThai = ? where Makh=?";
        
        try {
            preparedStatement = db.getConnection().prepareStatement(sqlString);
            
            preparedStatement.setString(1, KhachHang.getTrangThai());
            preparedStatement.setInt(2, KhachHang.getMakh());
            
            int n = preparedStatement.executeUpdate();
            if ( n !=0) {
                JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
                isSuccess = true;
            }
        }
        catch(SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Xóa dữ liệu thất bại", "Lỗi", 
                    JOptionPane.ERROR_MESSAGE);
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
    
    public boolean updatekhachhang(Model_KhachHang khachhang) {
        boolean isSuccess = false;
        System.out.println(khachhang.getMakh());
        System.out.println(khachhang.getTenkh());
        System.out.println(khachhang.getCmnd());
        System.out.println(khachhang.getSDT());
        System.out.println(khachhang.getDiaChi());
        System.out.println(khachhang.getEmail());
        System.out.println(khachhang.getNgaytao());
        System.out.println(khachhang.getDiemso());
        System.out.println(khachhang.getTrangThai());
        db.setupConnection();
        String sqlString = "update khachhang set  Tenkh = ?, Cmnd = ?, SDT = ?,DiaChi = ?, Email = ?, Ngaytao = ?, Diemso = ?, TrangThai = ? where Makh=?";
        
        try {
            preparedStatement = db.getConnection().prepareStatement(sqlString);
            
            preparedStatement.setString(1, khachhang.getTenkh());
            preparedStatement.setString(2, khachhang.getCmnd());
            preparedStatement.setString(3, khachhang.getSDT());
            preparedStatement.setString(4, khachhang.getDiaChi());
            preparedStatement.setString(5, khachhang.getEmail());
            preparedStatement.setString(6, khachhang.getNgaytao());
            preparedStatement.setInt(7, khachhang.getDiemso());
            preparedStatement.setString(8, khachhang.getTrangThai());
            preparedStatement.setInt(9, khachhang.getMakh());
            
            int n = preparedStatement.executeUpdate();
            if (n !=0){
                JOptionPane.showMessageDialog(null, "Üpdate dữ liệu thành công", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
                isSuccess = true;
            }
        }
        catch(SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            
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
      public boolean insertKhachHang(Model_KhachHang KhachHang) {
		boolean isSuccess = false;
                 db.setupConnection();
		String sqlString = "insert into khachhang values (?, ?, ?, ? )";
		try {
			preparedStatement = db.getConnection().prepareStatement(sqlString);
                        preparedStatement.setInt(1, KhachHang.getMakh());
			preparedStatement.setString(2, KhachHang.getTenkh());
                        preparedStatement.setString(3, KhachHang.getCmnd());
                        preparedStatement.setString(4, KhachHang.getSDT());
                        preparedStatement.setString(5, KhachHang.getDiaChi());
                        preparedStatement.setString(6, KhachHang.getEmail());
                        preparedStatement.setString(7, KhachHang.getNgaytao());
                        preparedStatement.setInt(8, KhachHang.getDiemso());
                        preparedStatement.setString(9, KhachHang.getTrangThai());
                        
                        
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
}
