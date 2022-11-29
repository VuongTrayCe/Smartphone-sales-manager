/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;
import Smartphone_sales_management.DAO.QuanLyNhaCungCap_DAO;
import java.util.ArrayList;
import Smartphone_sales_management.DTO.Model_NhaCungCap;
import java.util.Vector;
/**
 *
 * @author lehongthai
 */
public class QuanLyNhaCungCap_BUS {
     QuanLyNhaCungCap_DAO qlncc = new QuanLyNhaCungCap_DAO();
public ArrayList getDanhSachSanPham(String keyWord) {
        ArrayList<Model_NhaCungCap> dsncc = new ArrayList<Model_NhaCungCap>();
        ArrayList dsnccOfficial = new ArrayList<>();
        dsncc = qlncc.getDanhSachNhaCC_DAO();
        if (keyWord == "") {
            return dsncc;
        } else {

            for (Object x : dsncc) {
                Model_NhaCungCap y = (Model_NhaCungCap) x;
                String mancc = Integer.toString((int) y.getMacc());
                String name = (String) y.getTenncc();
                String sdt = y.getSDT();
                String diachi = (String) y.getDiaChi();
                if (mancc.contains(keyWord) || name.contains(keyWord)  || sdt.contains(keyWord)  || diachi.contains(keyWord)) {
                    {
                        dsnccOfficial.add(y);
                    }

                }
            }
            return dsnccOfficial;
        }
    }
    public  boolean AddNhaCC(Model_NhaCungCap NhaCC){
        boolean isSuccess = false;
        if(NhaCC != null){
        qlncc.insertNhaCC(NhaCC);
        }
        
        return isSuccess;
    }
    
	public boolean deleteNhacc(Model_NhaCungCap NhaCC) {
		boolean isSuccess = false;
            qlncc.deleteNhacc(NhaCC);
                return isSuccess;
       }
        public boolean updateNhacc(Model_NhaCungCap NhaCC){
            boolean isSuccess = false;
            qlncc.updateNhaCC(NhaCC);
//      
        return isSuccess;
     }

}
