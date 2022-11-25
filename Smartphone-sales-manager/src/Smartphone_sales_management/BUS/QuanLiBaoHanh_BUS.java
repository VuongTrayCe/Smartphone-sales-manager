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

    public ArrayList getDanhSachSanPhamBaoHanh(String keyWord, String trangthai, String ngayhientai) {

        ArrayList dsbh = new ArrayList();
        ArrayList dsspOfficial = new ArrayList<>();
        dsbh = qlbh_DAO.getDanhSachBaoHanh_DAO();

        if (keyWord == "" && trangthai.equals("ALL")) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (Object object : dsbh) {
                Vector row = (Vector) object;
                try {
                    Date datestart22 = formatter.parse(ngayhientai);
                    Date ngayban = (Date) row.get(5);
                    double ngayconlai = ((datestart22.getTime() - ngayban.getTime()) / 1000)/86400;
                    String[] tgbh = row.get(6).toString().split("");
                 
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
            return dsspOfficial;
        }
        if (trangthai.equals("ALL") != true) {
            dsbh = qlbh_DAO.getALLBaoHanhTheoTrangThai(trangthai);
            if (keyWord == "") {
                return dsbh;
            } else {
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
            }
        }
        return dsspOfficial;

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
