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
import javax.swing.JOptionPane;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class LoiNhuanBanHang_DAO {

    DBConnect db = new DBConnect();
    ResultSet rs = null;

    public ArrayList getLoiNhuanBanHang_NgayBan() {
        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {
            String query = "select donhang.Ngayban,count(donhang.Madh) as Soluongdon,sum(donhang.SoLuong) as Soluong,sum(donhang.Tongtien) as Tongtien,sum(Von.Gianhap) as Von  from donhang, (select chitietdonhang.Madh,giasanpham.Gianhap  from chitietdonhang,giasanpham where chitietdonhang.Magiasp=giasanpham.Magiasp) Von where  donhang.Madh=Von.Madh and donhang.Trangthai=\"Hoàn Thành\" group by(Ngayban)";
            PreparedStatement stm = db.getConnection().prepareStatement(query);
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getDate("Ngayban"));
                a.add(rs.getInt("Soluongdon"));
                a.add(rs.getInt("Soluong"));
                a.add((int) rs.getDouble("Tongtien"));
                a.add(rs.getInt("Von"));
                dssp.add(a);
                i++;
            }
            return dssp;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lÕi");
        } finally {
            db.closeConnection();
        }
        return dssp;
    }

    public ArrayList getLoiNhuanBanHang_HangHoa() {
        ArrayList dssp = new ArrayList();
        db.setupConnection();
        String query = "select  chitietdonhang.Masp,sanpham.Tensp, sum(chitietdonhang.Soluong) as Tongso,sum(chitietdonhang.Soluong*chitietdonhang.giaban)as TienHang,sum(chitietdonhang.giasaukm)as TienSauKM ,sum(giasanpham.Gianhap*chitietdonhang.Soluong)as TienVon from giasanpham,sanpham,chitietdonhang,donhang where sanpham.Masp=chitietdonhang.Masp and  chitietdonhang.Madh=donhang.Madh and giasanpham.Magiasp=chitietdonhang.Magiasp and donhang.Trangthai='Hoàn Thành' group by(Masp)";
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query);
            rs = stm.executeQuery(query);
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getInt("Masp"));
                a.add(rs.getString("Tensp"));
                a.add(rs.getInt("Tongso"));
                a.add(rs.getInt("TienHang"));
                a.add(rs.getInt("TienSauKm"));
                a.add((int)rs.getDouble("TienVon"));
                dssp.add(a);
                i++;
            }
            return dssp;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "lÕi");
        } finally {
            db.closeConnection();
        }
        return dssp;

    }

    public JDBCCategoryDataset getDataHangHoa_BieuDo() {
        
        ArrayList dssp = new ArrayList();
        JDBCCategoryDataset dataset;
        db.setupConnection();
//        DBConnect db = new DBConnect();
//        ResultSet rs = null;
//        db.setupConnection();

        try {
            String query= "select a.Tensp,(a.TienSauKM - a.TienVon) as LoiNhuan from (select  chitietdonhang.Masp,sanpham.Tensp, sum(chitietdonhang.Soluong) as Tongso,sum(chitietdonhang.Soluong*chitietdonhang.giaban)as TienHang,sum(chitietdonhang.giasaukm)as TienSauKM ,sum(giasanpham.Gianhap*chitietdonhang.Soluong)as TienVon from giasanpham,sanpham,chitietdonhang,donhang where sanpham.Masp=chitietdonhang.Masp and  chitietdonhang.Madh=donhang.Madh and giasanpham.Magiasp=chitietdonhang.Magiasp and donhang.Trangthai='Hoàn Thành' group by(Masp)) as a order by LoiNhuan desc limit 10;";
            dataset = new JDBCCategoryDataset(db.getConnection());
            dataset.executeQuery(query);
        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }
        return dataset;
    }

    public JDBCCategoryDataset getDataNgayBan_BieuDo(String dateStart, String dateEnd) {
        JDBCCategoryDataset dataset;
        db.setupConnection();
        try {
            System.out.println(dateStart);
            String query = "select a.Ngayban,(a.Tongtien-a.Von) as LoiNhuan from (select donhang.Ngayban,count(donhang.Madh) as Soluongdon,sum(donhang.SoLuong) as Soluong,sum(donhang.Tongtien) as Tongtien,sum(Von.Gianhap) as Von  from donhang, (select chitietdonhang.Madh,giasanpham.Gianhap  from chitietdonhang,giasanpham where chitietdonhang.Magiasp=giasanpham.Magiasp) Von where  donhang.Madh=Von.Madh and donhang.Ngayban >\""+dateStart+"\" and donhang.Ngayban < \""+dateEnd+"\" and donhang.Trangthai=\"Hoàn Thành\" group by(Ngayban)) as a order by LoiNhuan desc limit 10";
            dataset = new JDBCCategoryDataset(db.getConnection());
                        System.out.println(query);

            dataset.executeQuery(query);
        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }
        return dataset;
        
    }

}
