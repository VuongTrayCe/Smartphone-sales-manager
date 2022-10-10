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
public class QuanLyKhuyenMai_DAO {
     DBConnect db = new DBConnect();
    ResultSet rs = null;

    public ArrayList getDanhSachKhuyenMai_DAO() {

        ArrayList dskm = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from khuyenmai");
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getString(1));
                a.add(rs.getString(2));
                a.add(rs.getString(3));
                a.add(rs.getString(4));
                dskm.add(a);

            }
//            return dskm;
        } catch (SQLException ex) {
//            return null;
               ex.printStackTrace();
        } finally {
            db.closeConnection();
        }
         return dskm;
    }
}
