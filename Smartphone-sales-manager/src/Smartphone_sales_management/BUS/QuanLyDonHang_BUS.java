/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLiDonHang_DAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class QuanLyDonHang_BUS {

    QuanLiDonHang_DAO qldh = new QuanLiDonHang_DAO();

    public QuanLyDonHang_BUS() {

    }

    public ArrayList layDanhSachDonHang(String keyWord, String tenTrangThai, Date start, Date end) throws ParseException {
        ArrayList dsdh = new ArrayList();
        ArrayList dsdhOfficial = new ArrayList();
        ArrayList dsdsOffical2 = new ArrayList();
        ArrayList dsdhtt = new ArrayList();
        dsdh = qldh.layDanhSachDonHang_DAO();
        dsdhtt = qldh.layDanhSachDonHangTheoTrangThai_DAO(tenTrangThai);

        if (tenTrangThai == "ALL") {
            if (start == null && end == null) {
                if (keyWord == "") {
                    return dsdh;
                } else {
                    for (Object x : dsdh) {
                        Vector y = (Vector) x;
                        String madh = Integer.toString((int) y.get(0));
                        if (madh.contains(keyWord)) {
                            dsdhOfficial.add(y);
                        }
                    }
                    return dsdhOfficial;
                }
            } else {
                if (keyWord == "") {
                    for (Object x : dsdh) {
                        Vector y = (Vector) x;
                        if (compareDate((Date) y.get(3), start, end)) {
                            dsdhOfficial.add(y);
                        }
                    }
                    return dsdhOfficial;
                } else {
                    for (Object x : dsdh) {
                        Vector y = (Vector) x;
                        System.out.println(y.get(3).toString());
                        var  datee= y.get(3);
                        if (compareDate((Date) datee, start, end)) {
                            dsdsOffical2.add(y);
                        }
                    }
                    for (Object x : dsdsOffical2) {
                        Vector y = (Vector) x;
                        String madh = Integer.toString((int) y.get(0));
                        if (madh.contains(keyWord)) {
                            dsdhOfficial.add(y);
                        }
                    }
                    return dsdhOfficial;
                }
            }
        } else {
            if (start == null && end == null) {
                if (keyWord == "") {
                    return dsdhtt;
                } else {
                    for (Object x : dsdhtt) {
                        Vector y = (Vector) x;
                        String madh = Integer.toString((int) y.get(0));
                        if (madh.contains(keyWord)) {
                            dsdhOfficial.add(y);
                        }
                    }
                    return dsdhOfficial;
                }
            } else {
                for (Object x : dsdhtt) {
                    Vector y = (Vector) x;
                    if (compareDate((Date) y.get(3), start, end)) {
                        dsdsOffical2.add(y);
                    }
                }
                for (Object x : dsdsOffical2) {
                    Vector y = (Vector) x;
                    String madh = Integer.toString((int) y.get(0));
                    if (madh.contains(keyWord)) {
                        dsdhOfficial.add(y);
                    }
                }
                return dsdhOfficial;
            }
        }
    }

    public void tinhDiemChoKhachHang(int Madh) {
        int Makh = qldh.layMakhTheoMadh(Madh);
        int Diemso = qldh.layDiemTheoMakh(Makh);
        ArrayList diem = qldh.layDADvaDT(Madh);
        int diemAD = (int) diem.get(0);
        int diemThuong = (int) diem.get(1);
        int diemKH = Diemso + diemThuong - diemAD;
        qldh.updateDiemKH(Makh, diemKH);
    }

    public int laySoLuongctdh(int Madh) {
        return qldh.laySoLuongctdh(Madh);
    }

    public ArrayList layctdh(int Madh) {
        ArrayList ctdh = new ArrayList();
        try {
            ctdh = qldh.layDanhSachChiTietDonHang(Madh);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return ctdh;
    }

    public Boolean compareDate(Date dateNgayBan, Date dateStart, Date dateEnd) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat  sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String datestart2 = sdf.format(dateStart);
        String dateEnd2 = sdf.format(dateEnd);
        Date datestart22 = formatter.parse(datestart2);
        Date dateEnd22 = formatter.parse(dateEnd2);
        Boolean flag = false;

        if (dateNgayBan.after(datestart22) == true && dateEnd22.after(dateNgayBan) == true) {
            flag = true;
        }
        return flag;
    }

    public void updateHuyDonHang(int Madh) {
        qldh.updateHuyDonHang(Madh);
    }

    public void updateXacNhanDonHang(int Madh) {
        qldh.updateXacNhanDonHang(Madh);
    }
}
