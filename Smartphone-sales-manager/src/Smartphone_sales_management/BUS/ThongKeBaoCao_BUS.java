/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.ThongKeBaoCao_DAO;
import java.util.ArrayList;

/**
 *
 * @author Vuong
 */
public class ThongKeBaoCao_BUS {
       ThongKeBaoCao_DAO tkbc = new  ThongKeBaoCao_DAO();
       ArrayList listdata = new ArrayList();
    public ArrayList getThongKeBaoCaoBanHang(String type, String hinhthuc) {
        
        if(hinhthuc.equals("Hàng Hóa"))
        {
                  listdata=  tkbc.getDoanhThuBanHang_HangHoa();
        }
        else
        {
                              listdata=  tkbc.getDoanhThuBanHang_KhachHang();

        }
        return listdata;
    }

}
