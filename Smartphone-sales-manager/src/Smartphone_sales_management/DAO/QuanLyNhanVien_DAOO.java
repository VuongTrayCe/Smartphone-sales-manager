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
 * @author lehongthai
 */
public class QuanLyNhanVien_DAOO {

    DBConnect db = new DBConnect();
    ResultSet rs = null;

    public ArrayList getDanhSachNhanVien_DAOO() {

        ArrayList dsnv = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from NhanVien ");
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getString("Manv"));
                a.add(rs.getString("Tennv"));
                a.add(rs.getString("SoCCCD"));
                a.add(rs.getString("Tuoi"));
                a.add(rs.getString("DiaChi"));
                a.add(rs.getString("Chucdanh"));
                a.add(rs.getString("Trangthai"));
                dsnv.add(a);

            }
            return dsnv;
        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }
    }
}
