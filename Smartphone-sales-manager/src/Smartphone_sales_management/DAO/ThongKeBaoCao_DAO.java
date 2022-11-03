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
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

/**
 *
 * @author Vuong
 */
public class ThongKeBaoCao_DAO {

    DBConnect db = new DBConnect();
    ResultSet rs = null;

    public void Test() {

    }

    public ArrayList getDoanhThuBanHang_HangHoa() {
        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select sanpham.Tensp , chitietdonhang.Masp, sum(chitietdonhang.Soluong) as Tongso from sanpham,chitietdonhang,donhang where sanpham.Masp=chitietdonhang.Masp and  chitietdonhang.Madh=donhang.Madh and donhang.Trangthai='Đã xử lí' group by(Masp)");
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getInt("Masp"));
                a.add(rs.getString("Tensp"));
                a.add(rs.getString("Tongso"));
                dssp.add(a);
                i++;
            }

            return dssp;
        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }

    }

    public ArrayList getDoanhThuBanHang_KhachHang() {
        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select khachhang.Makh,khachhang.Tenkh , count(donhang.Madh) as Sodon,sum(donhang.SoLuong) as Soluong from khachhang, donhang where donhang.Trangthai=\"Đã xử lí\" and khachhang.Makh=donhang.Makh group by(donhang.Makh)");
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getInt("Makh"));
                a.add(rs.getString("Tenkh"));
                a.add(rs.getString("Sodon"));
                a.add(rs.getString("Soluong"));
                dssp.add(a);
                i++;
            }

            return dssp;
        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }

    }

}
