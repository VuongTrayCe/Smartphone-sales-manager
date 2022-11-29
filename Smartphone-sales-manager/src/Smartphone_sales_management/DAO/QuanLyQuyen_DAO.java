/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;
import Smartphone_sales_management.DBConnect;
import Smartphone_sales_management.DTO.Model_Quyen;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Dell
 */
public class QuanLyQuyen_DAO {
    DBConnect db = new DBConnect();
    ResultSet rs = null;
    // Thêm một nhân viên

    public ArrayList getDanhsachQuyen() {
        ArrayList ds = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT quyen_tk.Maquyentk,quyen_tk.Matk,quyen_tk.Maquyen\n" +
            "FROM quyen_tk"
                    );
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getInt("Maquyentk"));
                
                a.add(rs.getInt("Matk"));
                
                a.add(rs.getInt("Maquyen"));
                
                
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
    public ArrayList layDanhSachMaTk() {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT taikhoan.Matk \n"
                    + "FROM taikhoan");
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add(rs.getString("Matk"));
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
    public ArrayList layDanhSachMaQuyen() {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT quyen.Maquyen,quyen.Tenquyen \n"
                    + "FROM quyen");
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add(rs.getString("Maquyen"));
                    a.add(rs.getString("Tenquyen"));
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
    public boolean themQuyen(Model_Quyen Quyen) throws SQLException{
         boolean success = true;
         db.setupConnection();
         try{
              String sql = ("INSERT INTO quyen_tk(Matk,Maquyen)\n"
                    + "VALUES(?,?)");
              PreparedStatement stm;
              stm = db.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
              stm.setInt(1, Quyen.getMatk());
              System.out.println( Quyen.getMatk()+"123");
              stm.setInt(2, Quyen.getMaQuyen());
              System.out.println( Quyen.getMaQuyen()+"456");
              stm.executeUpdate();
         }catch (SQLException e) {
            e.printStackTrace();
            return success = false;
        } finally {
            db.closeConnection();
        }
         return success;
     }
}
