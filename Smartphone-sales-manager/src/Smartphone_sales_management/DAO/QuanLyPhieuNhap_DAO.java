/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import Smartphone_sales_management.DBConnect;
import Smartphone_sales_management.DTO.Model_PhieuNhap;
import Smartphone_sales_management.DTO.Model_PhieuNhap_ChiTiet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.sql.Statement;

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
            PreparedStatement stm = db.getConnection().prepareStatement("select phieunhap.Maphieunhap,phieunhap.NgayNhap,nhacungcap.Tenncc as Nhacungcap,phieunhap.SoLuong,phieunhap.TongTien,phieunhap.Trangthai from phieunhap,nhacungcap where phieunhap.Mancc=nhacungcap.Mancc");
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add((i));
                a.add(rs.getInt("Maphieunhap"));
                a.add(rs.getString("NgayNhap"));
                a.add(rs.getString("Nhacungcap"));
                a.add(rs.getInt("SoLuong"));
                a.add((int) rs.getDouble("TongTien"));
                a.add("VND");
                a.add(rs.getString("Trangthai"));

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

    // lấy chi tiết phiếu nhập hàng
    public ArrayList getChiTietPhieuNhap_DAO(int Mapn) {

        ArrayList result = new ArrayList();
        db.setupConnection();
        try {

            PreparedStatement stm = db.getConnection().prepareStatement("select chitietphieunhap.Masp, sanpham.Tensp, chitietphieunhap.GiaNhap,chitietphieunhap.Soluong,(chitietphieunhap.GiaNhap*chitietphieunhap.Soluong) as TongTien from chitietphieunhap,phieunhap,sanpham where phieunhap.Maphieunhap=chitietphieunhap.Maphieunhap and sanpham.Masp=chitietphieunhap.Masp and phieunhap.Maphieunhap=?");
            stm.setInt(1, Mapn);
            rs = db.sqlQry(stm);
            int i = 1;
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add(i);
                    a.add(rs.getInt("Masp"));

                    a.add(rs.getString("Tensp"));

                    a.add(rs.getInt("GiaNhap"));
                    a.add(rs.getInt("SoLuong"));

                    a.add(rs.getInt("TongTien"));

                    result.add(a);

                    i++;
//                    System.out.println("Vuo");

//                    System.out.println(model.getTenncc());
//                    model.setMakm(rs.getInt(11));
//                    model.setMabh(rs.getInt(12));
//
//                    System.out.println(model.getMabh());
                }
            }
        } catch (SQLException e) {
            return null;
        } finally {
            db.closeConnection();
        }

        return result;

    }

    // Hàm lấy tất cã nhà cung cấp hiện có ( Mã, Tên).
    public ArrayList getALLNhaCungCap() {

        ArrayList result = new ArrayList<>();
        db.setupConnection();
        try {

            PreparedStatement stm = db.getConnection().prepareStatement("select Mancc,Tenncc  from nhacungcap where nhacungcap.TrangThai='T' ");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {

                    Vector a = new Vector();
                    a.add(rs.getInt("Mancc"));
                    a.add(rs.getString("Tenncc"));
                    result.add(a);
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

    // Lấy tất cã sản phẩm
    public ArrayList getALLSanPham(int mancc) {

        ArrayList result = new ArrayList<>();
        db.setupConnection();
        try {

            PreparedStatement stm = db.getConnection().prepareStatement("select Masp,Tensp  from sanpham,nhacungcap where nhacungcap.TrangThai='T' and sanpham.Mancc=nhacungcap.Mancc and nhacungcap.Mancc=?");
            stm.setInt(1, mancc);
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {

                    Vector a = new Vector();
                    a.add(rs.getInt("Masp"));
                    a.add(rs.getString("Tensp"));
                    result.add(a);
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

    // Thêm một phiếu nhập hàng
    public int AddPhieuNhapHang(Model_PhieuNhap modelPhieuNhap) {

        boolean isSuccess = false;
        int id = 0;
        db.setupConnection();
        String sqlString = ("insert into phieunhap(Manv,Mancc,SoLuong,NgayNhap,TongTien,Trangthai) values (?,?,?,?,?,?)");
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, modelPhieuNhap.getManv());
            stm.setInt(2, modelPhieuNhap.getMancc());
            stm.setInt(3, modelPhieuNhap.getSoluong());
            stm.setString(4, modelPhieuNhap.getNgaynhap());
            stm.setDouble(5, modelPhieuNhap.getTongtien());
            stm.setString(6, "Đang Xử Lý");
            isSuccess = db.sqlUpdate(stm);
            if (isSuccess == true) {
                rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {

        }
        return id;
    }

    // Thêm một chi tiết phiếu nhập
    public void AddChiTietPhieuNhap(Model_PhieuNhap_ChiTiet model_PhieuNhap_ChiTiet) {

        boolean isSuccess = false;
        db.setupConnection();
        String sqlString = ("insert into chitietphieunhap(Masp,Maphieunhap,GiaNhap,Soluong) values (?,?,?,?)");
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(sqlString);
            stm.setInt(1, model_PhieuNhap_ChiTiet.getMasp());
            stm.setInt(2, model_PhieuNhap_ChiTiet.getMapn());
            stm.setInt(3, model_PhieuNhap_ChiTiet.getGianhap());
            stm.setInt(4, model_PhieuNhap_ChiTiet.getSoluong());
            isSuccess = db.sqlUpdate(stm);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {

        }
    }

    // Lấy tất cã phiếu nhập theo trạng thái
    public ArrayList getALLPhieuNhapTheoTrangThai(String tranngthai) {

        ArrayList dsnp = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select phieunhap.Maphieunhap,phieunhap.NgayNhap,nhacungcap.Tenncc as Nhacungcap,phieunhap.SoLuong,phieunhap.TongTien,phieunhap.Trangthai from phieunhap,nhacungcap where phieunhap.Mancc=nhacungcap.Mancc and phieunhap.Trangthai=?");
            stm.setString(1, tranngthai);
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add((i));
                a.add(rs.getInt("Maphieunhap"));
                a.add(rs.getString("NgayNhap"));
                a.add(rs.getString("Nhacungcap"));
                a.add(rs.getInt("SoLuong"));
                a.add((int) rs.getDouble("TongTien"));
                a.add("VND");
                a.add(rs.getString("Trangthai"));

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

    // Update trạng thái phiếu nhập
    public Boolean UpdatePhieuNhap(int Mapn, String trangthai) {

        boolean isSuccess = false;
        db.setupConnection();
        String sqlString = ("UPDATE phieunhap SET Trangthai = ? WHERE phieunhap.Maphieunhap=?;");
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(sqlString);
            stm.setString(1, trangthai);
            stm.setInt(2, Mapn);
            isSuccess = db.sqlUpdate(stm);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {

        }
        return isSuccess;
    }
    // Lấy mã nhà cung cấp theo phiếu nhập

    public int getMaNCC(int mapn) {

        int mancc = 0;
        db.setupConnection();
        try {

            PreparedStatement stm = db.getConnection().prepareStatement("select Mancc from phieunhap where phieunhap.Maphieunhap=?");
            stm.setInt(1, mapn);
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    mancc = rs.getInt("Mancc");

                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi");
        } finally {
            db.closeConnection();
        }
        return mancc;

    }
    // Update Số lượng sản phẩm

    public void UpdateSLSanPham(int masp, int sl, int mancc) {

        boolean isSuccess = false;
        String sqlString = "UPDATE sanpham SET soluong=? WHERE sanpham.Masp=? and sanpham.Mancc=?;";
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(sqlString);
            stm.setInt(1, sl);
            stm.setInt(2, masp);
            stm.setInt(3, mancc);
            System.out.println(masp);

            isSuccess = db.sqlUpdate(stm);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {

        }
    }
    // Lấy số lượng hiện tại có trong kho của sản phẩm

    public int getSLHT(int masp) {

        int sl = 0;
        db.setupConnection();
        try {

            PreparedStatement stm = db.getConnection().prepareStatement("select sanpham.soluong from sanpham where sanpham.Masp=?");
            stm.setInt(1, masp);
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    sl = rs.getInt("soluong");
                    System.out.println("So Luong Hien Tai");

                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi");
        } finally {
            db.closeConnection();
        }
        return sl;
    }

    public int getGiaBanHienTai(int masp) {

        int giabanhientai = 0;
        db.setupConnection();
        try {
            String query = "select giasanpham.Giaban from giasanpham where giasanpham.Masp=? and giasanpham.TrangThai='T'";
            PreparedStatement stm = db.getConnection().prepareStatement(query);
            stm.setInt(1, masp);
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    giabanhientai = (int) rs.getDouble("Giaban");
                    System.out.println("Gia Ban Hien Tai");

                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi");
        } finally {
            db.closeConnection();
        }
        return giabanhientai;
    }

    public int getGiaNhapHienTai(int masp) {

        int gianhaphientai = 0;
        db.setupConnection();
        try {

            PreparedStatement stm = db.getConnection().prepareStatement("select giasanpham.Gianhap from giasanpham where giasanpham.Masp=? and giasanpham.TrangThai='T'");
            stm.setInt(1, masp);
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    gianhaphientai = (int) rs.getDouble("Gianhap");
                    System.out.println("Gia Nhap Hien Tai");

                }
            }
        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Lỗi");
        } finally {
            db.closeConnection();
        }
        return gianhaphientai;
    }

    public void UpdateGiaSanPham(int masp, int gianhap, int giaBanHienTai, String ngayupdate) {
        boolean isSuccess = false;
        db.setupConnection();
        String sqlString = ("insert into giasanpham(Masp,Gianhap,Giaban,Ngayupdate,TrangThai) values (?,?,?,?,?)");
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(sqlString);
            stm.setInt(1, masp);
            stm.setInt(2, gianhap);
            stm.setInt(3, giaBanHienTai);
            stm.setString(4, ngayupdate);
            stm.setString(5, "T");
            System.out.println("Update gia san pham");

            isSuccess = db.sqlUpdate(stm);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {

        }
    }

    public void UpdateTrangThaiGiaSanPham(int masp) {

        boolean isSuccess = false;
        db.setupConnection();
        String sqlString = ("update giasanpham SET TrangThai='F' where giasanpham.Masp=?");
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(sqlString);
            stm.setInt(1, masp);
            isSuccess = db.sqlUpdate(stm);
                        System.out.println("Update Trang thai san pham");

        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {

        }

    }

}
