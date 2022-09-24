/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import Smartphone_sales_management.DBConnect;
//import static gasstation_management.Main.DATETIME_FORMATTER;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vuong
 */
public class QuanLyNhanVien_DAO {
    DBConnect db = new DBConnect();
    ResultSet rs = null;
    // Thêm một nhân viên
    public ArrayList getMotNhanVien(String manv)
    {
    ArrayList<String> result = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from NhanVien ");
            stm.setString(1,manv);
            rs =  stm.executeQuery();
                while (rs.next()) {
                     result.add(rs.getString("Manv"));
                     result.add(rs.getString("Tennv"));
                     result.add(rs.getString("SoCCCD"));
                     result.add(rs.getString("Tuoi"));
                     result.add(rs.getString("DiaChi"));
                     result.add(rs.getString("Chucdanh"));
                     result.add(rs.getString("Trangthai"));

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
}