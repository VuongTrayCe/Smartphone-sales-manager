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
public class QuanLyPhieuNhap_DAO {

    DBConnect db = new DBConnect();
    ResultSet rs = null;

    public ArrayList getDanhSachPhieuNhap_DAO() {

        ArrayList dsnp = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select phieunhap.Maphieunhap,phieunhap.NgayNhap,nhacungcap.Tenncc as Nhacungcap,phieunhap.SoLuong,phieunhap.TongTien from phieunhap,nhacungcap where phieunhap.Mancc=nhacungcap.Mancc");
            rs = stm.executeQuery();
            int  i=1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add((i));
                a.add(rs.getInt("Maphieunhap"));
                a.add(rs.getString("NgayNhap"));
                a.add(rs.getString("Nhacungcap"));
                a.add(rs.getInt("SoLuong"));
                a.add(rs.getString("TongTien"));

                dsnp.add(a);
                i++;
            }

            return dsnp;
        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }

    }

}
