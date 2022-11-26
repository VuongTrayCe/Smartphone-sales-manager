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
        String query = "select phieunhap.Mancc,nhacungcap.Tenncc,count(phieunhap.Maphieunhap) as SoPhieu, sum(phieunhap.SoLuong) as SoLuong, sum(phieunhap.TongTien) as TongTien from phieunhap,nhacungcap where phieunhap.Mancc=nhacungcap.Mancc and phieunhap.Trangthai=\"Hoàn Thành\" group by(phieunhap.Mancc)";
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(query);
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getInt("Mancc"));
                a.add(rs.getString("Tenncc"));
                a.add(rs.getInt("SoPhieu"));
                a.add(rs.getInt("SoLuong"));
                a.add((int) rs.getDouble("TongTien"));
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

    public ArrayList getChiPhiPhieuNhap_HangHoa2() {
        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select sanpham.Masp,sanpham.Tensp,count(chitietphieunhap.MaChiTietPhieuNhap)as SoLanNhap,sum(chitietphieunhap.Soluong) as SoLuong,sum(chitietphieunhap.GiaNhap*chitietphieunhap.Soluong) as TongTien from chitietphieunhap, sanpham,phieunhap where phieunhap.Trangthai=\"Hoàn Thành\" and sanpham.Masp=chitietphieunhap.Masp and phieunhap.Maphieunhap=chitietphieunhap.Maphieunhap group by(chitietphieunhap.Masp)");
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
        try {
            String query = "select phieunhap.NgayNhap,count(phieunhap.Maphieunhap)as TongPhieu, sum(phieunhap.SoLuong) as TongSoLuong, sum(TongTien) as TongTien from phieunhap group by(phieunhap.NgayNhap)";
            PreparedStatement stm = db.getConnection().prepareStatement(query);
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getDate("NgayNhap"));
                a.add(rs.getInt("TongPhieu"));
                a.add(rs.getInt("TongSoLuong"));
                a.add((int) rs.getDouble("TongTien"));
                a.add("VND");
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

    public ArrayList getChiPhiPhieuNhap_Detail_NhaCungCap(int parseInt) {
        
         ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {
            String query="select phieunhap.Maphieunhap, phieunhap.NgayNhap,phieunhap.SoLuong,phieunhap.TongTien from phieunhap where phieunhap.Mancc=? and phieunhap.Trangthai=\"Hoàn Thành\"";
            PreparedStatement stm = db.getConnection().prepareStatement(query);
            stm.setInt(1, parseInt);
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getInt("Maphieunhap"));
                a.add(rs.getString("NgayNhap"));
                a.add(rs.getInt("SoLuong"));
                a.add((int)rs.getDouble("TongTien"));
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
