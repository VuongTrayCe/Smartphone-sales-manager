/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.DAO;

import Smartphone_sales_management.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class QuanLiDonHang_DAO {

    DBConnect dbConnect = new DBConnect();
    ResultSet rs = null;

    public ArrayList layDanhSachDonHang_DAO() {
        ArrayList dsdh = new ArrayList();
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Madh , khachhang.Tenkh, nhanvien.Tennv,donhang.Ngayban,donhang.SoLuong,donhang.Tongtien,donhang.Diemapdung,donhang.Diemthuong,donhang.Trangthai\n"
                    + "FROM donhang\n"
                    + "INNER JOIN khachhang ON khachhang.Makh = donhang.Makh\n"
                    + "INNER JOIN nhanvien ON nhanvien.Manv = donhang.Manv");
            rs = stm.executeQuery();
            while (rs.next()) {
                Vector a = new Vector();
                a.add(rs.getInt("Madh"));
                a.add(rs.getString("Tenkh"));
                a.add(rs.getString("Tennv"));
                a.add(rs.getDate("NgayBan"));
                a.add(rs.getInt("SoLuong"));
                a.add((int)rs.getDouble("TongTien"));
                a.add(rs.getInt("Diemapdung"));
                a.add(rs.getInt("Diemthuong"));
                a.add(rs.getString("Trangthai"));
                dsdh.add(a);
            }
            return dsdh;
        } catch (SQLException e) {
            return null;
        } finally {
            dbConnect.closeConnection();
        }
    }

//    So sanh ngay ban co nam trong khoang Datestart -> DateEnd khong
    public ArrayList layDanhSachDonHangTheoTrangThai_DAO(String tenTrangThai) {
        ArrayList dsdhtct = new ArrayList();
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Madh , khachhang.Tenkh, nhanvien.Tennv,donhang.Ngayban,donhang.SoLuong,donhang.Tongtien,donhang.Diemapdung,donhang.Diemthuong,donhang.Trangthai\n"
                    + "FROM donhang\n"
                    + "INNER JOIN khachhang ON khachhang.Makh = donhang.Makh AND donhang.TrangThai = ?\n"
                    + "INNER JOIN nhanvien ON nhanvien.Manv = donhang.Manv");
            stm.setString(1, tenTrangThai);
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add(rs.getInt("Madh"));
                    a.add(rs.getString("Tenkh"));
                    a.add(rs.getString("Tennv"));
                    a.add(rs.getDate("NgayBan"));
                    a.add(rs.getInt("SoLuong"));
                    a.add((int)rs.getDouble("TongTien"));
                    a.add(rs.getInt("Diemapdung"));
                    a.add(rs.getInt("Diemthuong"));
                    a.add(rs.getString("Trangthai"));
                    dsdhtct.add(a);
                }
            }
            return dsdhtct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dbConnect.closeConnection();
        }
    }

    public ArrayList layDanhSachChiTietDonHang(int Madh) throws SQLException {
        ArrayList result = new ArrayList();
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Madh, sanpham.Tensp, sanpham.Loaisp,chitietdonhang.Soluong, khuyenmai.Ptkm,baohanh.Thoigianbaohanh, chitietdonhang.giaban, chitietdonhang.giasaukm,donhang.Trangthai,sanpham.Icon,giasanpham.Giaban,khachhang.Tenkh,donhang.Ngayban,chitietdonhang.mactdh,(chitietdonhang.giasaukm * chitietdonhang.Soluong)AS \"Tong chi tiet gia\"\n"
                    + "                                                                               FROM donhang\n"
                    + "                                                                               INNER JOIN chitietdonhang ON chitietdonhang.Madh = donhang.Madh AND donhang.Madh = ?\n"
                    + "                                                                              INNER JOIN sanpham ON sanpham.Masp = chitietdonhang.Masp\n"
                    + "                                                                                INNER JOIN chitietkhuyenmai ON chitietkhuyenmai.Masp = sanpham.Masp\n"
                    + "                                                                               INNER JOIN khuyenmai ON khuyenmai.Makm = chitietkhuyenmai.Makm  AND chitietkhuyenmai.TrangThai = \"T\"\n"
                    + "                                                                              INNER JOIN chitietbaohanh ON chitietbaohanh.Masp = sanpham.Masp\n"
                    + "                                                                             INNER JOIN baohanh ON baohanh.Mabaohanh = chitietbaohanh.Mabaohanh AND chitietbaohanh.TrangThai =\"T\"\n"
                    + "                                                                              INNER JOIN giasanpham ON giasanpham.Masp = sanpham.Masp AND giasanpham.TrangThai = \"T\"\n"
                    + "                                                                           INNER JOIN khachhang ON khachhang.Makh = donhang.Makh");
            stm.setInt(1, Madh);
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Vector a = new Vector();
                    a.add(rs.getInt(1));
                    a.add(rs.getString(2));
                    a.add(rs.getString(3));
                    a.add(rs.getInt(4));
                    a.add(rs.getInt(5));
                    a.add(rs.getString(6));
                    a.add((int)rs.getDouble(7));
                    a.add((int)rs.getDouble(8));
                    a.add(rs.getString(9));
                    a.add(rs.getString(10));
                    a.add((int)rs.getDouble(11));
                    a.add(rs.getString(12));
                    a.add(rs.getDate(13));
                    a.add(rs.getInt(14));
                    System.out.println(rs.getInt(15));
                    a.add(rs.getInt(15));
                    result.add(a);
                }
            }

            return result;
        } catch (SQLException e) {
            return null;
        } finally {
            dbConnect.closeConnection();
        }

    }

    public int laySoLuongctdh(int Madh) {
        int result = 0;
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT COUNT(donhang.Madh) AS \"So Chi tiet\"\n"
                    + "FROM chitietdonhang \n"
                    + "INNER JOIN donhang ON chitietdonhang.Madh = donhang.Madh AND donhang.Madh = ?");
            stm.setInt(1, Madh);
            rs = stm.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    result = rs.getInt("So Chi tiet");
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            dbConnect.closeConnection();
        }

    }

    public ArrayList layMadh() {
        ArrayList result = new ArrayList();
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Madh\n"
                    + "FROM donhang\n"
                    + "ORDER BY donhang.Madh ASC");
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt("Madh"));
                }
            }

        } catch (SQLException e) {
            return null;
        } finally {
            dbConnect.closeConnection();
        }
        return result;
    }

    public ArrayList getDanhSachDonHangTheoTrangThai(int indexTrangThai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList layMadh2(String tenTrangThai) {
        ArrayList result = new ArrayList();
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Madh\n"
                    + "FROM donhang\n where donhang.Trangthai = ?"
                    + "ORDER BY donhang.Madh ASC");
            stm.setString(1, tenTrangThai);
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt("Madh"));
                }
            }

        } catch (SQLException e) {
            return null;
        } finally {
            dbConnect.closeConnection();
        }
        return result;
    }
// Lay ma khach hang theo ma don hang

    public int layMakhTheoMadh(int Madh) {
        int result = -1;
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Makh\n"
                    + "FROM donhang\n"
                    + "WHERE donhang.Madh = ?");
            stm.setInt(1, Madh);
            rs = stm.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    result = rs.getInt("Makh");
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            dbConnect.closeConnection();
        }
    }

    public int layDiemTheoMakh(int Makh) {
        int result = -1;
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT khachhang.Diemso\n"
                    + "FROM khachhang\n"
                    + "WHERE khachhang.Makh = ?");
            stm.setInt(1, Makh);
            rs = stm.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    result = rs.getInt("Diemso");
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            dbConnect.closeConnection();
        }
    }

    public ArrayList layDADvaDT(int Madh) {
        ArrayList result = new ArrayList();
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT donhang.Diemapdung, donhang.Diemthuong\n"
                    + "FROM donhang\n"
                    + "WHERE donhang.Madh = ?");
            stm.setInt(1, Madh);
            rs = stm.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result.add(rs.getInt("Diemapdung"));
                    result.add(rs.getInt("Diemthuong"));
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            dbConnect.closeConnection();
        }
    }

    public void updateDiemKH(int Makh, int Diemso) {
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("UPDATE khachhang\n"
                    + "SET khachhang.Diemso = ? WHERE khachhang.Makh = ?");
            stm.setInt(1, Diemso);
            stm.setInt(2, Makh);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnect.closeConnection();
        }
    }

    public void updateHuyDonHang(int Madh) {
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("UPDATE donhang\n"
                    + "SET donhang.Trangthai = \"Đã Hủy\"\n"
                    + "WHERE donhang.Madh = ?");
            stm.setInt(1, Madh);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.closeConnection();
        }
    }

    public void updateXacNhanDonHang(int Madh) {
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("UPDATE donhang\n"
                    + "SET donhang.Trangthai = \"Hoàn Thành\"\n"
                    + "WHERE donhang.Madh = ?");
            stm.setInt(1, Madh);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.closeConnection();
        }
    }

    public ArrayList chitietSPvaSL(int Mactdh) {
        ArrayList data = new ArrayList();
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT chitietdonhang.Masp, chitietdonhang.Soluong\n"
                    + "FROM chitietdonhang\n"
                    + "WHERE chitietdonhang.mactdh = ? ");
            stm.setInt(1, Mactdh);
            rs = stm.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    data.add(rs.getInt("Masp"));
                    data.add(rs.getInt("Soluong"));
                }
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            dbConnect.closeConnection();
        }
    }

    public int SLofSP(int Masp) {
        int SL = 0;
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("SELECT sanpham.soluong \n"
                    + "FROM sanpham\n"
                    + "WHERE sanpham.Masp= ?");
            stm.setInt(1, Masp);
            rs = stm.executeQuery();
            if (rs != null) {
                if (rs.next()) {
                    SL = (int) rs.getInt("soluong");
                }
            }
            return SL;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            dbConnect.closeConnection();
        }
    }

    public boolean updateSLSP(int Masp, int SL) {
        boolean success = true;
        dbConnect.setupConnection();
        try {
            PreparedStatement stm = dbConnect.getConnection().prepareStatement("UPDATE sanpham\n"
                    + "SET sanpham.soluong = ? WHERE sanpham.Masp = ?");
            stm.setInt(1, SL);
            stm.setInt(2, Masp);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return success = false;
        } finally {
            dbConnect.closeConnection();
        }
        return success;
    }

}
