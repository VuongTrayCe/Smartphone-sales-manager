/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import Smartphone_sales_management.DBConnect;
import Smartphone_sales_management.DTO.Model_SanPham;
import com.mysql.cj.xdevapi.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class QuanLiSanPham_DAO {

    DBConnect db = new DBConnect();
    ResultSet rs = null;

    public ArrayList layDanhSachSanPham() {
        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT sanpham.Masp, sanpham.Tensp,sanpham.Loaisp, giasanpham.Giaban,sanpham.soluong,sanpham.TrangThai\n"
                    + "                    FROM sanpham\n"
                    + "                    INNER JOIN giasanpham ON giasanpham.Masp = sanpham.Masp \n"
                    + "ORDER BY sanpham.Masp ASC");
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getInt("MaSP"));
                a.add(rs.getString("TenSp"));
                a.add(rs.getString("LoaiSp"));
                a.add(rs.getDouble("GiaBan"));
                a.add(rs.getInt("SoLuong"));
                a.add(rs.getString("TrangThai"));
                dssp.add(a);
            }
            return dssp;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            db.closeConnection();
        }
    }

    public ArrayList layDanhSachSanPhamTheoTrangThai(String tenTrangThai) {
        ArrayList dssp = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT sanpham.Masp, sanpham.Tensp,sanpham.Loaisp, giasanpham.Giaban,sanpham.soluong,sanpham.TrangThai\n"
                    + "                    FROM sanpham\n"
                    + "                    INNER JOIN giasanpham ON giasanpham.Masp = sanpham.Masp AND sanpham.TrangThai = ?\n"
                    + "                    ORDER BY sanpham.Masp ASC");
            stm.setString(1, tenTrangThai);
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getInt("MaSP"));
                a.add(rs.getString("TenSp"));
                a.add(rs.getString("LoaiSp"));
                a.add(rs.getDouble("GiaBan"));
                a.add(rs.getInt("SoLuong"));
                a.add(rs.getString("TrangThai"));
                dssp.add(a);
            }
            return dssp;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            db.closeConnection();
        }
    }

    public ArrayList layDanhSachChiTietSanPham(int Masp) {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT sanpham.Masp, sanpham.Tensp, giasanpham.Giaban, sanpham.soluong, sanpham.MauSac, sanpham.Namsx, baohanh.Thoigianbaohanh, khuyenmai.Ptkm,sanpham.TrangThai,sanpham.ThongSo,sanpham.Icon,khuyenmai.Makm,baohanh.Mabaohanh,khuyenmai.Tenkm,sanpham.Loaisp\n "
                    + "FROM sanpham\n "
                    + "INNER JOIN giasanpham ON giasanpham.Masp = sanpham.Masp AND sanpham.Masp = ?\n "
                    + "INNER JOIN chitietbaohanh ON chitietbaohanh.Masp = sanpham.Masp\n "
                    + "INNER JOIN baohanh ON baohanh.Mabaohanh = chitietbaohanh.Mabaohanh\n "
                    + "INNER JOIN chitietkhuyenmai ON chitietkhuyenmai.Masp = sanpham.Masp\n "
                    + "INNER JOIN khuyenmai ON khuyenmai.Makm = chitietkhuyenmai.Makm");
            stm.setInt(1, Masp);
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt(1));
                    result.add(rs.getString(2));
                    result.add(rs.getDouble(3));
                    result.add(rs.getInt(4));
                    result.add(rs.getString(5));
                    result.add(rs.getString(6));
                    result.add(rs.getString(7));
                    result.add(rs.getDouble(8));
                    result.add(rs.getString(9));
                    result.add(rs.getString(10));
                    result.add(rs.getString(11));
                    result.add(rs.getInt(12));
                    result.add(rs.getInt(13));
                    result.add(rs.getString(14));
                    result.add(rs.getString(15));
                }
            }
            return result;

        } catch (Exception e) {
            return null;
        } finally {
            db.closeConnection();
        }

    }

    public ArrayList layMadh() {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT sanpham.Masp\n"
                    + "FROM sanpham\n"
                    + "ORDER BY sanpham.Masp ASC");
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt("Masp"));
                }
            }
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            db.closeConnection();
        }
    }

    public ArrayList layMadh2(String tenTrangThai) {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT sanpham.Masp\n"
                    + "FROM sanpham\n"
                    + "WHERE sanpham.TrangThai = ?"
                    + "ORDER BY sanpham.Masp ASC");
            stm.setString(1, tenTrangThai);
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt("Masp"));
                }
            }
            return result;
        } catch (Exception e) {
            return null;
        } finally {
            db.closeConnection();
        }
    }

    public int themSanPham(Model_SanPham model) throws SQLException {
        int id = 1;
        Boolean success;
        db.setupConnection();
        try {
//            String sql = "INSERT INTO	sanpham(Tensp,Loaisp,soluong,MauSac,Namsx,TrangThai,Icon,ThongSo)\n"
//                    + "VALUES (?,?,?,?,?,?,?,?)";
            String sql = "INSERT INTO sanpham(Tensp,Loaisp,soluong,MauSac,Namsx,TrangThai,Icon,ThongSo)\n"
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stm;
            stm = db.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1, model.getTenSp());
            stm.setString(2, model.getLoaiSp());
            stm.setInt(3, model.getSoLuong());
            stm.setString(4, model.getMauSac());
            stm.setString(5, model.getNamSX());
            stm.setString(6, model.getTrangThai());
            stm.setString(7, model.getIcon());
            stm.setString(8, model.getThongSo());
            success = db.sqlUpdate(stm);
            if (success == true) {
                rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return 0;
    }

    public void xoaSP(int maSp) {
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("UPDATE sanpham\n"
                    + "SET sanpham.TrangThai = \"F\" WHERE sanpham.Masp = ?;");
            stm.setInt(1, maSp);
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }

    public boolean suaSP(Model_SanPham model) {
        db.setupConnection();
        boolean success = true;
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("UPDATE sanpham\n"
                    + "SET sanpham.Tensp = ? , sanpham.Loaisp =? ,sanpham.MauSac=? , sanpham.Namsx=?, sanpham.TrangThai = ? ,sanpham.Icon = ? , sanpham.ThongSo = ? "
                    + "WHERE sanpham.Masp = ?");
            stm.setString(1, model.getTenSp());
            stm.setString(2, model.getLoaiSp());
            stm.setString(3, model.getMauSac());
            stm.setString(4, model.getNamSX());
            stm.setString(5, model.getTrangThai());
            stm.setString(6, model.getIcon());
            stm.setString(7, model.getThongSo());
            stm.setInt(8, model.getMasp());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Sua sp that bai");
            success = false;
        } finally {
            db.closeConnection();
        }
        return success;
    }

// Cau truy van Them gia san pham
    public void themGiaSP(int maSp, Model_SanPham model) {
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("INSERT INTO giasanpham(Masp,Giaban,Ngayupdate,TrangThai)\n"
                    + "VALUES (?,?,?,?)");
            stm.setInt(1, maSp);
            stm.setDouble(2, model.getGia());
            stm.setString(3, model.getNgayTao());
            stm.setString(4, model.getTrangThai());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }

// Sua gia san pham 
    public boolean suaGiasp(Model_SanPham model) {
        boolean success = true;
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("UPDATE giasanpham\n"
                    + "SET giasanpham.Giaban = ? WHERE giasanpham.Masp = ?");
            stm.setDouble(1, model.getGia());
            stm.setInt(2, model.getMasp());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Sua gia that bai");
            success = false;
        } finally {
            db.closeConnection();
        }
        return success;
    }

//    Sua chitietbaohanh
    public boolean suaBH(Model_SanPham model) {
        boolean success = true;
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("UPDATE chitietbaohanh\n"
                    + "SET chitietbaohanh.Mabaohanh = ? WHERE chitietbaohanh.Masp = ?");
            stm.setInt(1, model.getMabh());
            stm.setInt(2, model.getMasp());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Sua bao hanh that bai");
            success = false;
        } finally {
            db.closeConnection();
        }
        return success;
    }
//    Sua chitietkhuyenmai 

    public boolean suaKM(Model_SanPham model) {
        boolean success = true;
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("UPDATE chitietkhuyenmai\n"
                    + "SET chitietkhuyenmai.Makm = ? WHERE chitietkhuyenmai.Masp = ?");
            stm.setInt(1, model.getMakm());
            stm.setInt(2, model.getMasp());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Sua khuyen mai that bai");
            success = false;
        } finally {
            db.closeConnection();
        }
        return success;
    }
// Cau truy van Khuyen mai

    public ArrayList layDanhSachKM() {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT khuyenmai.Tenkm,khuyenmai.Ptkm,khuyenmai.Makm\n"
                    + "FROM khuyenmai");
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add(rs.getString("Tenkm"));
                    a.add(rs.getInt("Ptkm"));
                    a.add(rs.getInt("Makm"));
                    result.add(a);
                }
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return null;
    }

    public void themKM(int Masp, Model_SanPham model) {
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("INSERT INTO chitietkhuyenmai(Masp,Makm,TrangThai)\n"
                    + "VALUES (?,?,\"T\")");
            stm.setInt(1, Masp);
            stm.setInt(2, model.getMakm());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }
// Cau truy van Bao Hanh

    public ArrayList layDanhSachBH() {
        ArrayList result = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("SELECT baohanh.Thoigianbaohanh,baohanh.Mabaohanh\n"
                    + "FROM baohanh");
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add(rs.getString("Thoigianbaohanh"));
                    a.add(rs.getInt("Mabaohanh"));
                    result.add(a);
                }
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return null;
    }

    public void themBH(int Masp, Model_SanPham model) {
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("INSERT INTO chitietbaohanh(Mabaohanh,Masp,TrangThai)\n"
                    + "VALUES (?,?,\"T\")");
            // Dang lam gi v
            stm.setInt(1, model.getMabh());
            stm.setInt(2, Masp);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
    }

    public ArrayList getALLSanPham() {
        ArrayList result = new ArrayList<>();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select Masp from sanpham ");
            rs = db.sqlQry(stm);
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getString("Masp"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi" + ex);
        } finally {
            db.closeConnection();
        }
        return result;
    }
}
