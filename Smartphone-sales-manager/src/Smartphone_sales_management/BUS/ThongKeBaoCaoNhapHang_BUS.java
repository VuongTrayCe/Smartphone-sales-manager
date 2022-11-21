/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.ThongKeBaoCaoBanHang_DAO;
import Smartphone_sales_management.DAO.ThongKeBaoCaoNhapHang_DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Vuong
 */
public class ThongKeBaoCaoNhapHang_BUS {
        ThongKeBaoCaoNhapHang_DAO tkbc = new ThongKeBaoCaoNhapHang_DAO();
    ArrayList listdata = new ArrayList();
    
    
    
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
    
    
    
    
}
