/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import Smartphone_sales_management.DBConnect;
import Smartphone_sales_management.UI.Component.KhachHangComponent.Khachhang2;
import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Hiep
 */
public class QuanLyKhachHang_DAO {
    public boolean insert(Khachhang2 stud) throws Exception{
        String sql = "ïnsert into khachhang(maKh, tenKH, email, gioiTinh, DiaChi) values(?, ?, ?, ?, ?)";
        try(
                
            pstmt.setString(1, stud.getMaKh());
            pstmt.setString(2, stud.getTenKH());
            pstmt.setString(3, stud.getEmail());
            pstmt.setInt(4, stud.getGioiTinh());
            pstmt.setString(5, stud.getDiaChi());
            
            return pstmt.executeUpdate() > 0;
        }
    }                   
}

