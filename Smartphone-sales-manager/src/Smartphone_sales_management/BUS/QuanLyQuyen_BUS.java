/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;
import Smartphone_sales_management.DAO.QuanLyQuyen_DAO;
import Smartphone_sales_management.DTO.Model_Quyen;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class QuanLyQuyen_BUS {
    QuanLyQuyen_DAO qlq = new QuanLyQuyen_DAO();

    public QuanLyQuyen_BUS() {
    }

    public ArrayList layDanhSachQuyen(String keyWord) {
        ArrayList dsq = new ArrayList();
        ArrayList dstkOfficial = new ArrayList();
        dsq = qlq.getDanhsachQuyen();
//        System.out.println(dstk);
        if (keyWord == "") {
            return dsq;
        } else {
            for (Object x : dsq) {
                Vector y = (Vector) x;
                String Maquyentk = Integer.toString((int) y.get(0));
                if (Maquyentk.contains(keyWord)) {
                    dstkOfficial.add(y);
                }
            }
            return dstkOfficial;
        }
    }
      public ArrayList layDanhSachQuyen2(String keyWord) {
        ArrayList dsq = new ArrayList();
        ArrayList dstkOfficial = new ArrayList();
        dsq = qlq.getDanhsachQuyen2();
        if (keyWord == "") {
            return dsq;
        } else {
            for (Object x : dsq) {
                Vector y = (Vector) x;
                String Matk = Integer.toString((int) y.get(0));
                if (Matk.contains(keyWord)) {
                    dstkOfficial.add(y);
                }
            }
            return dstkOfficial;
        }
    }
    public boolean themQ(Model_Quyen Quyen) throws SQLException {
        if (qlq.themQuyen(Quyen)) {
            return true;
        } else {
            return false;
        }
    }
    public ArrayList layDanhSachMatk() {
        ArrayList dstk = new ArrayList();
        dstk = qlq.layDanhSachMaTk();
        return dstk;
    }
     public ArrayList layDanhSachMatk2() {
        ArrayList dstk = new ArrayList();
        dstk = qlq.layDanhSachMaTk2();
        return dstk;
    }
    public ArrayList layDanhSachMaQuyen() {
        ArrayList dsq = new ArrayList();
        dsq = qlq.layDanhSachMaQuyen();
        return dsq;
    }

    public ArrayList layDanhSachQuyenTheoTaiKhoan(int matk) {
     
          ArrayList dsq = new ArrayList();
        dsq = qlq.layDanhSachQuyenTheoTaiKhoan(matk);
        return dsq;
    }

    public ArrayList layDanhSachQuyenChuaCo(int matk) {
              
          ArrayList dsq = new ArrayList();
        dsq = qlq.layDanhSachQuyenChuaCo(matk);
        return dsq;
    }

    public void AddQuyenTaiKhoan(ArrayList arrquyenmoi, int matk) {
        for (Object object : arrquyenmoi) {
            Vector dataRow = (Vector) object;
            qlq.AdddQuyenTaiKhoan(Integer.parseInt(dataRow.get(0).toString()),matk);
        }
    }

    public void DeleteQuyenTaiKhoan(int maquyentk) {
        qlq.DeleteQuyenTaiKhoan(maquyentk);
    }
}
