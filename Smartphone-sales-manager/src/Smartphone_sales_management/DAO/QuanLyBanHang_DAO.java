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
import Smartphone_sales_management.DTO.Model_BanHang_ChiTietSanPham;
import Smartphone_sales_management.DTO.Model_KhachHang;
import javax.swing.JOptionPane;

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

            PreparedStatement stm = db.getConnection().prepareStatement("select sanpham.Tensp,sanpham.Loaisp,sanpham.soluong,sanpham.Namsx,nhacungcap.Tenncc,giasanpham.Giaban,sanpham.Icon,sanpham.ThongSo,khuyenmai.Ptkm,baohanh.Thoigianbaohanh "
                    + "from sanpham,chitietphieunhap,nhacungcap, phieunhap,giasanpham,khuyenmai,chitietkhuyenmai,baohanh,chitietbaohanh "
                    + "where sanpham.Masp=? and baohanh.Mabaohanh=chitietbaohanh.Mabaohanh and sanpham.Masp=chitietbaohanh.Masp and khuyenmai.Makm=chitietkhuyenmai.Makm and sanpham.Masp=chitietkhuyenmai.Masp and khuyenmai.Trangthai='T' and sanpham.TrangThai='T' and giasanpham.TrangThai='T' and sanpham.Masp=chitietphieunhap.Masp and chitietphieunhap.Maphieunhap=phieunhap.Maphieunhap and phieunhap.Mancc=nhacungcap.Mancc and sanpham.Masp=giasanpham.Masp");
            stm.setInt(1, selectedIndex);
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    Model_BanHang_ChiTietSanPham model = new Model_BanHang_ChiTietSanPham();
                    model.setTensp(rs.getString(1));
                    model.setLoaisp(rs.getString(2));
                    model.setSl(rs.getInt(3));
                    model.setNamsx(rs.getString(4));
                    model.setTenncc(rs.getString(5));
                    model.setGiaban(rs.getDouble(6));
                    model.setIcon(rs.getString(7));
                    model.setChitiet(rs.getString(8));
                    model.setPtkm(rs.getInt(9));
                    model.setBaohanh(rs.getString(10));
                    result.add(model);
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

    public ArrayList getALLkhachHang() {
        ArrayList result = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select Tenkh  from khachhang where khachhang.TrangThai='T' ");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString("Tenkh"));
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
    // Thêm một khách hàng mới

    public void insertKhachHang(Model_KhachHang model_khachhang) {
        Boolean success;
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("insert into khachhang(Tenkh,Cmnd,SDT,DiaChi,Email,Ngaytao,Diemso,TrangThai)  values (?,?,?,?,?,?,?,?)");
            stm.setString(1, model_khachhang.getTenkhachhang());
            stm.setString(2, model_khachhang.getCmnd());
            stm.setString(3,(model_khachhang.getSdt()));
            stm.setString(4, model_khachhang.getDiachi());
            stm.setString(5, model_khachhang.getEmail());
            stm.setString(6, model_khachhang.getNgaytao());
            stm.setInt(7, model_khachhang.getDiemso());
            stm.setString(8, "T");
            System.out.println(model_khachhang.getTenkhachhang());
                        System.out.println(model_khachhang.getCmnd());
            System.out.println(model_khachhang.getDiachi());
            System.out.println(model_khachhang.getEmail());
            System.out.println(model_khachhang.getSdt());
            System.out.println(model_khachhang.getNgaytao());

            success = db.sqlUpdate(stm);
//            JOptionPane.showMessageDialog(null, "Thêm thành công!!");

        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyQuyenTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
    }

}
