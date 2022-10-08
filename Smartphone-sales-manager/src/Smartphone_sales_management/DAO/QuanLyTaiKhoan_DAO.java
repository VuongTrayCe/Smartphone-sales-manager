/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Smartphone_sales_management.DBConnect;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuanLyTaiKhoan_DAO {
        DBConnect db = new DBConnect();
    ResultSet rs = null;
    // Thêm một nhân viên
    public ArrayList getDanhsachTaiKhoan()
    {
    ArrayList<String> result = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from TaiKhoan");
            
            rs =  stm.executeQuery();
                while (rs.next()) {
                     result.add(rs.getString("Manv"));
                     result.add(rs.getString("Taikhoan"));
                     result.add(rs.getString("Matkhau"));
                     result.add(rs.getString("quyen"));
                     result.add(rs.getString("TrangThai"));
                    

                }
                for (String string : result) {
                    System.out.println(string);
                
            }
            return result;
        }catch (SQLException ex) {
            return null;
        }finally{
            db.closeConnection();
        }
}
     public ArrayList getDanhSachChiTiet1TaiKhoan_DAO(int selectedIndex) throws SQLException {

        ArrayList result = new ArrayList();
        db.setupConnection();

        try {

            PreparedStatement stm = db.getConnection().prepareStatement("select taikhoan.Manv,taikhoan.Taikhoan,taikhoan.Matkhau,taikhoan.quyen,taikhoan.TrangThai"
                    + "from Manv,Taikhoan,Matkhau, quyen,TrangThai "
                    + "where taikhoan.Manv=? and taikhoan.Manv=nhavien.Manv") ;
            stm.setInt(1, selectedIndex);
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString(1));
                    result.add(rs.getString(2));
                    result.add(rs.getString(3));
                    result.add(rs.getString(4));
                    result.add(rs.getString(5));
                    




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