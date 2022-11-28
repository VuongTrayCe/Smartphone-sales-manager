/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;
import Smartphone_sales_management.DBConnect;
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
                System.out.println(rs.getInt("Maquyentk"));
                a.add(rs.getInt("Matk"));
                System.out.println(rs.getInt("Matk"));
                a.add(rs.getInt("Maquyen"));
                System.out.println(rs.getInt("Maquyen"));
                
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
}
