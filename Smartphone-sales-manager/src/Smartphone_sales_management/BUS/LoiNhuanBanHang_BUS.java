/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.LoiNhuanBanHang_DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Vuong
 */
public class LoiNhuanBanHang_BUS {

    LoiNhuanBanHang_DAO lnbn = new LoiNhuanBanHang_DAO();
    ArrayList listdata = new ArrayList();

    public ArrayList getLoiNhuanBanHang_HangHoa() {
        listdata = lnbn.getLoiNhuanBanHang_HangHoa();
        int TongTien1 = 0;
        int TongVon1 = 0;
        int TongTienLai = 0;
        for (Object object : listdata) {
            Vector dataRow = (Vector) object;
            int Tongtien = (int) dataRow.get(5);
            int TienVon = (int) dataRow.get(6);
            TongTien1 += Tongtien;
            TongVon1 += TienVon;
            dataRow.add(Tongtien - TienVon);
            TongTienLai += (Tongtien - TienVon);

        }
        Vector a = new Vector();
        a.add("");
        a.add("");
        a.add("");
        a.add("");
        a.add("");
        a.add(TongTien1);
        a.add(TongVon1);
        a.add(TongTienLai);
        listdata.add(a);
        return listdata;
    }

    public ArrayList getLoiNhuanBanHang_NgayBan(Date dateStart, Date dateEnd) {

        listdata = lnbn.getLoiNhuanBanHang_NgayBan();
        var listdata2 = new ArrayList<>();
        for (Object object : listdata) {
            Vector dataRow = (Vector) object;
            var dateBanHang = dataRow.get(1);
            try {
                if (compareDate((Date) dateBanHang, dateStart, dateEnd)) {
                    listdata2.add((object));
                }
            } catch (ParseException ex) {
            }
        }
        int TongTien1 = 0;
        int TongVon1 = 0;
        int TongTienLai = 0;
        for (Object object : listdata2) {
            Vector dataRow = (Vector) object;
            int Tongtien = (int) dataRow.get(4);
            int TienVon = (int) dataRow.get(5);
            TongTien1 += Tongtien;
            TongVon1 += TienVon;
            dataRow.add(Tongtien - TienVon);
            TongTienLai += Tongtien - TienVon;

        }
        Vector a = new Vector();
        a.add("");
        a.add("");
        a.add("");
        a.add("");
        a.add(TongTien1);
        a.add(TongVon1);
        a.add(TongTienLai);
        listdata2.add(a);

        return listdata2;
    }

    public Boolean compareDate(Date dateBanHang, Date dateStart, Date dateEnd) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat  sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String datestart2 = sdf.format(dateStart);
        String dateEnd2 = sdf.format(dateEnd);
        Date datestart22 = formatter.parse(datestart2);
        Date dateEnd22 = formatter.parse(dateEnd2);
        Boolean flag = false;

        if (dateBanHang.after(datestart22) == true && dateEnd22.after(dateBanHang) == true) {
            flag = true;
        }
        return flag;
    }
    public JDBCCategoryDataset getDataHangHoa_BieuDo() {
        return lnbn.getDataHangHoa_BieuDo();
    }
    public JDBCCategoryDataset getDataNgayBan_BieuDo(Date datestart, Date dateEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datestart2 = sdf.format(datestart);
        String dateEnd2= sdf.format(dateEnd);
        return lnbn.getDataNgayBan_BieuDo(datestart2, dateEnd2);
    }
}
