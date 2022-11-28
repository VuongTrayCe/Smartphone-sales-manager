/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLiBaoHanh_DAO;
import Smartphone_sales_management.DTO.ModelBaoHanh;
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
public class QuanLiBaoHanh_BUS {

    QuanLiBaoHanh_DAO qlbh_DAO = new QuanLiBaoHanh_DAO();

    public ArrayList layDSBH_BUS() {
        ArrayList dsbh = new ArrayList();
        dsbh = qlbh_DAO.layDanhSachBaoHanh();
        return dsbh;
    }

    public ArrayList layDSCTBH_BUS() {
        ArrayList dsctbh = new ArrayList();
        dsctbh = qlbh_DAO.layDanhSachCTBH();
        return dsctbh;
    }

    public ArrayList layctbh(int Mabh) {
        ArrayList ctbh = new ArrayList();
        ctbh = qlbh_DAO.layctBH(Mabh);
        return ctbh;
    }

    public ArrayList layctOfctbh(int Mactbh) {
        ArrayList ctbh = new ArrayList();
        ctbh = qlbh_DAO.layctOfctBH(Mactbh);
        return ctbh;
    }

    public boolean themBH(ModelBaoHanh model) {
        if (qlbh_DAO.themBH(model)) {
            return true;
        }
        return false;
    }

    public boolean xoaBH(int Mabh) {
        if (qlbh_DAO.xoaBH(Mabh)) {
            return true;
        }
        return false;
    }

    public boolean suaBH(ModelBaoHanh model) {
        if (qlbh_DAO.suaBH(model)) {
            return true;
        }
        return false;
    }

    public ArrayList dsMasp() {
        ArrayList dssp = new ArrayList();
        dssp = qlbh_DAO.dsMasp();
        return dssp;
    }

    public boolean themCTBH(ModelBaoHanh model) {
        if (qlbh_DAO.themCTDH(model)) {
            return true;
        }
        return false;
    }

    public int layMactbh(ModelBaoHanh model) {
        int result = -1;
        result = qlbh_DAO.chitietbaohanh(model);
        return result;
    }

    public boolean xoaCTBH(int Mactbh) {
        if (qlbh_DAO.xoaCTBH(Mactbh)) {
            return true;
        }
        return false;
    }

    public double CheckNgayBaoHanh(Date ngayban, String[] tgbh, String ngayhientai) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date datestart22 = formatter.parse(ngayhientai);
        String[] arrNgayBan = ngayban.toString().split("-");
        int thoigianbaohanh = Integer.parseInt(tgbh[0]);
        int year = Integer.parseInt(arrNgayBan[0]);
        int Month = Integer.parseInt(arrNgayBan[1]);
        int day = Integer.parseInt(arrNgayBan[2]);
        int newyear = year;
        int newMonth = Month;
        if (Month + thoigianbaohanh > 12) {
            newyear = year + 1;
            newMonth = (Month + thoigianbaohanh) - 12;
            if (newMonth == 1 || newMonth == 3 || newMonth == 5 || newMonth == 7 || newMonth == 8 || newMonth == 10 || newMonth == 12) {
                if (day == 31) {
                    day = 31;
                }
            } else if (newMonth == 2) {
                if (day == 31 || day == 29 || day == 30) {
                    day = 28;
                }
            } else {
                if (day == 31) {
                    day = 30;
                }
            }
        } else {
            newMonth = Month + thoigianbaohanh;
        }
        String thoigianbaohanhcuoicung = "";
        String thoigianbaohanhcuoicung2 = thoigianbaohanhcuoicung.concat(newyear + "-" + newMonth + "-" + day);
        Date datehethan = formatter.parse(thoigianbaohanhcuoicung2);
        double ngayconlai = ((datehethan.getTime() - datestart22.getTime()) / 1000) / 86400;
        if (ngayconlai <= 0) {
            ngayconlai = 0;
        }
        return ngayconlai;
    }

    public ArrayList getDanhSachSanPhamBaoHanh(String keyWord, String trangthai, String ngayhientai) {

        ArrayList dsbh = new ArrayList();
        ArrayList dsspOfficial = new ArrayList<>();
        dsbh = qlbh_DAO.getDanhSachBaoHanh_DAO();
        ArrayList data = new ArrayList();

        if (keyWord == "" && trangthai.equals("ALL")) {
            for (Object object : dsbh) {
                Vector row = (Vector) object;
                try {
                    Date ngayban = (Date) row.get(5);
                    String[] tgbh = row.get(6).toString().split(" ");
                    double ngayconlai = CheckNgayBaoHanh(ngayban, tgbh, ngayhientai);
                    row.add((int) ngayconlai);

                } catch (ParseException ex) {
                    Logger.getLogger(QuanLiBaoHanh_BUS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return dsbh;
        }
        if (keyWord != "" && trangthai.equals("ALL")) {
            for (Object x : dsbh) {
                Vector y = (Vector) x;
                String masp = y.get(1).toString();
                String makh = y.get(2).toString();
                if (masp.contains(keyWord) || makh.contains(keyWord)) {
                    {
                        dsspOfficial.add(y);
                    }

                }
            }
            for (Object object : dsspOfficial) {
                Vector row = (Vector) object;
                try {
                    Date ngayban = (Date) row.get(5);
                    String[] tgbh = row.get(6).toString().split(" ");
                    double ngayconlai = CheckNgayBaoHanh(ngayban, tgbh, ngayhientai);
                    row.add((int) ngayconlai);

                } catch (ParseException ex) {
                    Logger.getLogger(QuanLiBaoHanh_BUS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return dsspOfficial;
        }
        if (trangthai.equals("ALL") != true) {
            dsbh = qlbh_DAO.getDanhSachBaoHanh_DAO();
            ArrayList dsbhOf = new ArrayList();

            for (Object object : dsbh) {
                Vector row = (Vector) object;
                try {
                    Date ngayban = (Date) row.get(5);
                    String[] tgbh = row.get(6).toString().split(" ");
                    double ngayconlai = CheckNgayBaoHanh(ngayban, tgbh, ngayhientai);
                    row.add((int) ngayconlai);
                } catch (ParseException ex) {
                    Logger.getLogger(QuanLiBaoHanh_BUS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (trangthai.equals("Đang Bảo Hành")) {
                for (Object object : dsbh) {
                    Vector row = (Vector) object;
                    int soNgayConLai = (int) row.get(7);
                    if (soNgayConLai > 0) {
                        dsbhOf.add(row);
                    }
                }
            }
            if (trangthai.equals("Đã Bảo Hành")) {
                for (Object object : dsbh) {
                    Vector row = (Vector) object;
                    int soNgayConLai = (int) row.get(7);
                    if (soNgayConLai == 0) {
                        dsbhOf.add(row);

                    }
                }
            }
            if (keyWord == "") {
                return dsbhOf;
            } else {
                for (Object x : dsbhOf) {
                    Vector y = (Vector) x;
                    String masp = y.get(1).toString();
                    String makh = y.get(2).toString();
                    if (masp.contains(keyWord) || makh.contains(keyWord)) {
                        {
                            data.add(y);

                        }

                    }
                }
                return data;
            }
        }
        return data;

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
}
