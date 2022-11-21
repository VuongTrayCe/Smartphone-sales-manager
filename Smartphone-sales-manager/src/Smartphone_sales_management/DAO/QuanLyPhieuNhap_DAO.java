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
public class QuanLyPhieuNhap_DAO {

    DBConnect db = new DBConnect();
    ResultSet rs = null;

    public ArrayList getDanhSachPhieuNhap_DAO() {

        ArrayList dsnp = new ArrayList();
        db.setupConnection();
        try {
            PreparedStatement stm = db.getConnection().prepareStatement("select phieunhap.Maphieunhap,phieunhap.NgayNhap,nhacungcap.Tenncc as Nhacungcap,phieunhap.SoLuong,phieunhap.TongTien from phieunhap,nhacungcap where phieunhap.Mancc=nhacungcap.Mancc");
            rs = stm.executeQuery();
            int i = 1;
            while (rs.next()) {
                Vector a = new Vector();
                a.add((i));
                a.add(rs.getInt("Maphieunhap"));
                a.add(rs.getString("NgayNhap"));
                a.add(rs.getString("Nhacungcap"));
                a.add(rs.getInt("SoLuong"));
                a.add(rs.getString("TongTien"));

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
   
    
    

}
