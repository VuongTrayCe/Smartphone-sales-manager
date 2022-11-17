/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import Smartphone_sales_management.DBConnect;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Vuong
 */
public class testGetID {

    DBConnect db = new DBConnect();
    ResultSet rs = null;

    public int test() throws SQLException {
        int id=-1;
      Boolean success;
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("insert into khuyenmai(Tenkm,Ptkm,Trangthai) values(\"tesst\",30,\"T\")",Statement.RETURN_GENERATED_KEYS);
//            System.out.println(model_khachhang.getTenkhachhang());
//            System.out.println(model_khachhang.getCmnd());
//            System.out.println(model_khachhang.getDiachi());
//            System.out.println(model_khachhang.getEmail());
//            System.out.println(model_khachhang.getSdt());
//            System.out.println(model_khachhang.getNgaytao());

            success = db.sqlUpdate(stm);
            if(success==true)
            {
                 rs = stm.getGeneratedKeys();
                if(rs.next())
                    id= rs.getInt(1);

            }
//            JOptionPane.showMessageDialog(null, "Thêm thành công!!");

        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyQuyenTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
        return id;
    }

}
