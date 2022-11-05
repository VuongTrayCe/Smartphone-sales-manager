/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.ThongKeBaoCao_DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Vuong
 */
public class ThongKeBaoCao_BUS {

    ThongKeBaoCao_DAO tkbc = new ThongKeBaoCao_DAO();
    ArrayList listdata = new ArrayList();

    public ArrayList getThongKeBaoCaoBanHang(String type, String hinhthuc, Date dateStart, Date dateEnd) throws ParseException {

        if (hinhthuc.equals("Hàng Hóa")) {
            listdata = tkbc.getDoanhThuBanHang_HangHoa();
        } else if (hinhthuc.equals("Ngày Bán")) {
            listdata = tkbc.getDoanhThuBanHang_NgayBan();
            var listdata2 = new ArrayList<>();

            for (Object object : listdata) {
                Vector dataRow = (Vector) object;
                var dateBanHang = dataRow.get(1);
                if (compareDate((Date) dateBanHang, dateStart, dateEnd)) {
                    listdata2.add((object));

                }
            }
            return listdata2;

        } else {
            listdata = tkbc.getDoanhThuBanHang_KhachHang();

        }
        return listdata;
    }
   // hàm so sánh ngày (kiểu date)
    public Boolean compareDate(Date dateBanHang, Date dateStart, Date dateEnd) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat  sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String datestart2 = sdf.format(dateStart);
        String dateEnd2 = sdf.format(dateEnd);
        Date datestart22 = formatter.parse(datestart2);
        Date dateEnd22 = formatter.parse(dateEnd2);
        Boolean flag = false;
//                System.out.println(dateBanHang.toString());

        if (dateBanHang.after(datestart22) == true && dateEnd22.after(dateBanHang) == true) {
            flag = true;
        }
        System.out.println(flag);
        return flag;
    }
     // Lấy số đơn hàng của 1 khách hàng
    public ArrayList getThongKeBaoCaoBanHang_Detail_NgayBan(String NgayBan) {
        ArrayList listdata2 = new ArrayList();
        listdata2 = tkbc.getDoanhThuBanHang_NgayBan_Detail(NgayBan);

        return listdata2;
    }
    public ArrayList getThongKeBaoCaoBanHang_Detail_KhachHang(int makh) {
        ArrayList listdata2 = new ArrayList();
        listdata2 = tkbc.getDoanhThuBanHang_KhachHang_Detail(makh);
        return listdata2;
    }

    public JDBCCategoryDataset getDataHangHoa_BieuDo() {
        
        return tkbc.getHangHoa_BieuDo();
    }

    public JDBCCategoryDataset getDataHangHoa_BieuDo_KhachHang() {
         return tkbc.getKhachHang_BieuDo_KhachHang();
    }

    public ArrayList getThongKeBaoCaoNhapHang(String type, String hinhthuc) {
        ArrayList data=new ArrayList();
        if(hinhthuc.equals("Hàng Hóa"))
        {
            System.out.println("Da Vao");
            data = tkbc.getChiPhiPhieuNhap_HangHoa2();
         }
        else
        {
            data= tkbc.getChiPhiPhieuNhap_NhaCungCap();
        }
        return data;
    }
}
