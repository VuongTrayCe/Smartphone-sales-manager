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

    public ArrayList getDoanhThuBanHang_NgayBan() {

        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select donhang.Ngayban,count(Madh) as Soluongdon,sum(donhang.SoLuong) as Soluong,sum(donhang.Tongtien) as Tongtien from donhang where donhang.Trangthai=\"Đã xử lí\" group by(Ngayban)");
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getDate("Ngayban"));
                a.add(rs.getInt("Soluongdon"));
                a.add(rs.getInt("Soluong"));
                a.add(rs.getInt("Tongtien"));
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

    public ArrayList getDoanhThuBanHang_NgayBan_Detail(String NgayBan) {

        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {

            PreparedStatement stm = db.getConnection().prepareStatement("select khachhang.Tenkh,donhang.SoLuong,donhang.Soluongdiem, donhang.Tongtien from donhang,khachhang where khachhang.Makh=donhang.Makh and donhang.Ngayban=? and donhang.Trangthai=\"Đã xử lí\";");
            stm.setString(1, NgayBan);
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getString("Tenkh"));
                a.add(rs.getInt("SoLuong"));
                a.add(rs.getInt("Soluongdiem"));
                a.add(rs.getInt("Tongtien"));
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

    public ArrayList getDoanhThuBanHang_KhachHang_Detail(int makh) {
        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {

            PreparedStatement stm = db.getConnection().prepareStatement("select donhang.Madh,donhang.Ngayban,donhang.SoLuong,donhang.Soluongdiem,donhang.Tongtien from donhang where donhang.Makh=?");
            stm.setInt(1, makh);
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add(i);
                a.add(rs.getInt("Madh"));
                a.add(rs.getString("Ngayban"));
                a.add(rs.getInt("SoLuong"));
                a.add(rs.getInt("Soluongdiem"));
                a.add(rs.getInt("Tongtien"));
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

    // Lấy dữ liệu để tạo biểu đồ cột
    public JDBCCategoryDataset getHangHoa_BieuDo() {
        ArrayList dssp = new ArrayList();
        JDBCCategoryDataset dataset;
        db.setupConnection();
//        DBConnect db = new DBConnect();
//        ResultSet rs = null;
//        db.setupConnection();

        try {
            dataset = new JDBCCategoryDataset(db.getConnection());
            dataset.executeQuery("select sanpham.Tensp,sum(chitietdonhang.Soluong)as SoLuong from chitietdonhang, sanpham,donhang where sanpham.Masp=chitietdonhang.Masp and donhang.Madh=chitietdonhang.Madh and donhang.Trangthai=\"Đã xử lí\" group by(chitietdonhang.Masp)");

        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }
        return dataset;

    }

    public JDBCCategoryDataset getKhachHang_BieuDo_KhachHang() {
        ArrayList dssp = new ArrayList();
        JDBCCategoryDataset dataset;
        db.setupConnection();
//        DBConnect db = new DBConnect();
//        ResultSet rs = null;
//        db.setupConnection();

        try {
            dataset = new JDBCCategoryDataset(db.getConnection());
            dataset.executeQuery("select khachhang.Tenkh,sum(SoLuong)as SL from donhang,khachhang where donhang.Trangthai=\"Đã xử lí\" and khachhang.Makh=donhang.Makh group by(donhang.Makh) order by SL desc limit 5;");
        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }
        return dataset;

    }

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

}
