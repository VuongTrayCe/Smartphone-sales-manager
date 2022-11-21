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
public class ThongKeBaoCaoNhapHang_DAO {
      DBConnect db = new DBConnect();
    ResultSet rs = null;
 public ArrayList getChiPhiPhieuNhap_NhaCungCap() {
        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select phieunhap.Mancc,nhacungcap.Tenncc,count(phieunhap.Maphieunhap) as SoPhieu, sum(phieunhap.SoLuong) as SoLuong, sum(phieunhap.TongTien) as TongTien from phieunhap,nhacungcap where phieunhap.Mancc=nhacungcap.Mancc and phieunhap.Trangthai=\"T\" group by(phieunhap.Mancc)");
            int i = 1;
                        rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getInt("Mancc"));
                a.add(rs.getString("Tenncc"));
                a.add(rs.getInt("SoPhieu"));
                a.add(rs.getInt("SoLuong"));
                a.add((int)rs.getDouble("TongTien"));
//                System.out.println(rs.getFloat("TongTien"));
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

    public ArrayList getChiPhiPhieuNhap_HangHoa2() {
        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select sanpham.Masp,sanpham.Tensp,count(chitietphieunhap.MaChiTietPhieuNhap)as SoLanNhap,sum(chitietphieunhap.Soluong) as SoLuong,sum(chitietphieunhap.GiaNhap*chitietphieunhap.Soluong) as TongTien from chitietphieunhap, sanpham,phieunhap where phieunhap.Trangthai=\"T\" and sanpham.Masp=chitietphieunhap.Masp and phieunhap.Maphieunhap=chitietphieunhap.Maphieunhap group by(chitietphieunhap.Masp)");
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getInt("Masp"));

                a.add(rs.getString("Tensp"));
                a.add(rs.getInt("SoLanNhap"));

                a.add(rs.getInt("SoLuong"));
                a.add(rs.getString("TongTien"));
                a.add("VND");
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
    
    
      public ArrayList getChiPhiPhieuNhap_NgayBan() {
        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {String query = "select phieunhap.NgayNhap,count(phieunhap.Maphieunhap), sum(phieunhap.SoLuong) as TongSoLuong, sum(TongTien) as TongTien from phieunhap group by(phieunhap.NgayNhap)";
            PreparedStatement stm = db.getConnection().prepareStatement(query);
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getString("Ngayban"));
                a.add(rs.getString("Tensp"));
                a.add(rs.getInt("SoLanNhap"));

                a.add(rs.getInt("SoLuong"));
                a.add(rs.getString("TongTien"));
                a.add("VND");
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
