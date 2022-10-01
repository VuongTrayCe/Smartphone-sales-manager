/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import Smartphone_sales_management.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Vuong
 */
public class QuanLyBanHang_DAO {
  DBConnect db = new DBConnect();;
    ResultSet rs = null;
        
    public ArrayList getDanhSachSanPham_DAO() {
        
        ArrayList dssp  = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from sanpham");
            rs =  stm.executeQuery();
                while (rs.next()) {
                    Vector a = new Vector();
                     a.add(rs.getInt("Masp"));
                     a.add(rs.getString("Tensp"));
                     a.add(rs.getString("Loaisp"));
                     a.add(rs.getString("Mausac"));
                     dssp.add(a);
                }
              
            return dssp;
        }catch (SQLException ex) {
            return null;
        }finally{
            db.closeConnection();
        }
        
    }
    
}
