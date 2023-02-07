/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import Smartphone_sales_management.DBConnect;
import Smartphone_sales_management.DTO.Model_BanHang_ChiTietHoaDon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import Smartphone_sales_management.DTO.Model_BanHang_ChiTietSanPham;
import Smartphone_sales_management.DTO.Model_BanHang_HoaDon;
import Smartphone_sales_management.DTO.Model_KhachHang;
import java.sql.Statement;
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
            PreparedStatement stm = db.getConnection().prepareStatement("select * from sanpham where sanpham.Trangthai='T'");
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
//                                                            System.out.println("âfasf");
            String query = "select sanpham.Tensp,sanpham.Loaisp,sanpham.soluong,sanpham.Namsx,nhacungcap.Tenncc,giasanpham.Giaban,sanpham.Icon,sanpham.ThongSo,khuyenmai.Ptkm,baohanh.Thoigianbaohanh,khuyenmai.Makm,baohanh.Mabaohanh,chitietkhuyenmai.Machitietkhuyenmai,chitietbaohanh.Machitietbaohanh,giasanpham.Magiasp from sanpham,nhacungcap,giasanpham,khuyenmai,chitietkhuyenmai,baohanh,chitietbaohanh where sanpham.Masp=? and nhacungcap.Mancc=sanpham.Mancc and baohanh.Mabaohanh=chitietbaohanh.Mabaohanh and sanpham.Masp=chitietbaohanh.Masp and khuyenmai.Makm=chitietkhuyenmai.Makm and sanpham.Masp=chitietkhuyenmai.Masp and khuyenmai.Trangthai='T' and sanpham.TrangThai='T' and giasanpham.TrangThai='T'  and sanpham.Masp=giasanpham.Masp and chitietkhuyenmai.TrangThai='T' and chitietbaohanh.TrangThai='T'";
            PreparedStatement stm = db.getConnection().prepareStatement(query);
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
                    model.setMakm(rs.getInt(11));
                    model.setMabh(rs.getInt(12));
                    model.setMasp(selectedIndex);
                    model.setMachitietkhuyenmai(rs.getInt(13));
                    model.setMachitietbaohanh(rs.getInt(14));
                    model.setMagiasanpham(rs.getInt(15));

                    result.add(model);

//                    model.setMakm(rs.getInt(11));
//                    model.setMabh(rs.getInt(12));
//
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
            PreparedStatement stm = db.getConnection().prepareStatement("select khachhang.Makh,Tenkh,Diemso  from khachhang where khachhang.TrangThai='T' ");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add(rs.getString("Makh"));
                    a.add(rs.getString("Tenkh"));
                    a.add(rs.getInt("Diemso"));
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
    // Thêm một khách hàng mới

    public void insertKhachHang(Model_KhachHang model_khachhang) {
        Boolean success;
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("insert into khachhang(Tenkh,Cmnd,SDT,DiaChi,Email,Ngaytao,Diemso,TrangThai)  values (?,?,?,?,?,?,?,?)");
            stm.setString(1, model_khachhang.getTenkhachhang());
            stm.setString(2, model_khachhang.getCmnd());
            stm.setString(3, (model_khachhang.getSdt()));
            stm.setString(4, model_khachhang.getDiachi());
            stm.setString(5, model_khachhang.getEmail());
            stm.setString(6, model_khachhang.getNgaytao());
            stm.setInt(7, model_khachhang.getDiemso());
            stm.setString(8, "T");
//            System.out.println(model_khachhang.getTenkhachhang());
//            System.out.println(model_khachhang.getCmnd());
//            System.out.println(model_khachhang.getDiachi());
//            System.out.println(model_khachhang.getEmail());
//            System.out.println(model_khachhang.getSdt());
//            System.out.println(model_khachhang.getNgaytao());

            success = db.sqlUpdate(stm);
//            JOptionPane.showMessageDialog(null, "Thêm thành công!!");

        } catch (SQLException ex) {
//            Logger.getLogger(QuanLyQuyenTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            db.closeConnection();
        }
    }

    public int AddHoaDon(Model_BanHang_HoaDon hoadon) {
        
        boolean isSuccess = false;
        int id = 0;
        db.setupConnection();
        String sqlString = ("insert into donhang(Makh,Manv,Ngayban,SoLuong,Tongtien,Diemapdung,Diemthuong,Trangthai) values (?,?,?,?,?,?,?,?)");
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(sqlString, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, hoadon.getMakh());
            stm.setInt(2, hoadon.getManv());
            stm.setString(3, hoadon.getNgayban());
            stm.setInt(4, hoadon.getSoluong());
            stm.setInt(5, hoadon.getTongtien());
            stm.setInt(6, hoadon.getDiemapdung());
            stm.setInt(7, hoadon.getDiemthuong());
            stm.setString(8,"Đặt Hàng");

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

    public void AddChiTietHoaDon(Model_BanHang_ChiTietHoaDon model) {
        
        boolean isSuccess = false;
        db.setupConnection();
        String sqlString = ("insert into chitietdonhang (Masp,Madh,Machitietkhuyenmai,Machitietbaohanh,Magiasp,Soluong,giaban,giasaukm) values(?,?,?,?,?,?,?,?);");
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(sqlString);
            stm.setInt(1, model.getMasp());
            stm.setInt(2, model.getMadh());
            stm.setInt(3, model.getMactkm());
            stm.setInt(4, model.getMachitietbaohanh());
            stm.setInt(5, model.getMagiasp());
            stm.setInt(6, model.getSoluong());
            stm.setInt(7, model.getGiaban());
            stm.setInt(8, model.getGiasaukm());
            isSuccess = db.sqlUpdate(stm);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {

        }
        
    }

    public void updateDiemKhachHang(int makh,int i) {
        
        boolean isSuccess = false;
        db.setupConnection();
        String sqlString = ("UPDATE khachhang SET Diemso=? WHERE khachhang.Makh=?");
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(sqlString);
            stm.setInt(1,i);
            stm.setInt(2,makh);
            isSuccess = db.sqlUpdate(stm);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {

        }
    }

    public void updateSoLuongSanPham(int masp, int soluong) {
        
         boolean isSuccess = false;
        db.setupConnection();
        String sqlString = ("UPDATE sanpham SET soluong=? WHERE sanpham.Masp=?");
        try {
            PreparedStatement stm = db.getConnection().prepareStatement(sqlString);
            stm.setInt(1,soluong);
            stm.setInt(2,masp);
            isSuccess = db.sqlUpdate(stm);
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Thêm dữ liệu thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } finally {

        }
    }

    public int getSoLuongSanPhamHienTai(int masp) {
        
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

}
