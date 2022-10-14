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
public class QuanLyBanHang_DAO {

    DBConnect db = new DBConnect();
    ;
    ResultSet rs = null;

    public ArrayList getDanhSachSanPham_DAO() {

        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select * from sanpham");
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getInt("Masp"));
                a.add(rs.getString("Tensp"));
                a.add(rs.getString("Loaisp"));
                a.add(rs.getString("Mausac"));
                dssp.add(a);
            }

            return dssp;
        } catch (SQLException ex) {
            return null;
        } finally {
            db.closeConnection();
        }

    }

    // Hàm truy vấn đến Database để lấy chi tiết của sản phẩm
    public ArrayList getDanhSachChiTiet1SanPham_DAO(int selectedIndex) throws SQLException {

        ArrayList result = new ArrayList();
        db.setupConnection();
        try {

            PreparedStatement stm = db.getConnection().prepareStatement("select sanpham.Tensp,sanpham.Loaisp,sanpham.soluong,sanpham.Namsx,nhacungcap.Tenncc,giasanpham.Giaban,sanpham.Icon,sanpham.ThongSo,khuyenmai.Ptkm "
                    + "from sanpham,chitietphieunhap,nhacungcap, phieunhap,giasanpham,khuyenmai,chitietkhuyenmai "
                    + "where sanpham.Masp=? and khuyenmai.Makm=chitietkhuyenmai.Makm and sanpham.Masp=chitietkhuyenmai.Masp and khuyenmai.Trangthai='T' and sanpham.TrangThai='T' and giasanpham.TrangThai='T' and sanpham.Masp=chitietphieunhap.Masp and chitietphieunhap.Maphieunhap=phieunhap.Maphieunhap and phieunhap.Mancc=nhacungcap.Mancc and sanpham.Masp=giasanpham.Masp");
            stm.setInt(1, selectedIndex);
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString(1));
                    result.add(rs.getString(2));
                    result.add(rs.getInt(3));
                    result.add(rs.getString(4));
                    result.add(rs.getString(5));
                    result.add(rs.getString(6));
                    result.add(rs.getString(7));
                    result.add(rs.getString(8));
                    result.add(rs.getInt(9));
                }
            }
        } catch (SQLException e) {
            return null;
        } finally {
            db.closeConnection();
        }

        return result;
    }

    // Lấy tất cã mã sản phẩm đang được bán trong hệ thống
    public ArrayList getMapn() {

        ArrayList result = new ArrayList<>();
        db.setupConnection();

        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select Masp from sanpham");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt("Masp"));
                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi");
        } finally {
            db.closeConnection();
        }
        return result;
    }

}
