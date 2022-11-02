/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

/**
 *
 * @author Hiep
 */
public class QuanLyKhachHang_BUS {
    private ArryList<Model_KhachHang> dskn = null;
    private QuanLyKhachHang_BUS qlkh = new QuanLyKhachHang_BUS();
 // public QuanLyKhachHang_BUS(){
    // this.dskh = qlkh.getDanhSachKhachHang_DAO();
    //}
public ArrayList<Model_KhachHang> getDanhSachKhachHang(){
this.dskh = qlkh.getDanhSachKhachHang_DAO();
return dskh;
    
}
public boolean AddKhachHang(Model_KhachHang KhachHang){
    boolean isSuccess = false;
    if(KhachHang !=null){
        qlkh.iserKhachHang(KhachHang);
    }
    return isSuccess;
    }
public int getSoTTMaKh(){
    return this.getDanhSachKhachHang().size()+1;
}
public boolean deleteKhachHang(int Makh){
    boolean isSuccess = false;
    
    for(Model_KhachHang kh:dskh){
        if(kh.getMaKh() == MaKh){
            dskh.remove(kh);
            qlkh.deleteKhachHang(Makh);
            isSuccess = true;
            break;
            
        }
    }
    return isSuccess;
}
public boolean updateKhachHang(Model_KhachHang KhachHang){
    boolean isSuccess = false;
    qlkh.updateKhachHang(KhachHang);
    
 return isSuccess;
}
public boolean ExistsKhachHang(String cccd){
    boolean isExists = false;
     
    for(Model_KhachHang : dskh){
        if (KhachHang.getCCCD().equals(cccd)){
            isExists = true;
            break;
            
        }
    }
    return isExists;
}

public ArrayList<Model_KhachHang> timKiemTheoMaNV(String tuKhoa)){
    tuKhoa = tuKhoa.toLowerCase();
    ArrayList<Model_KhachHang> khds = new ArrayList();
    for (Model_KhachHang kh: dskh){
        StringMaKh = Integer.toString(kh.getMaKh());
        if (MaKh.contains(tuKhoa)){
            khds.add(kh);
        }
    }
    return khds;
}
public ArrayList<Model_KhachHang> timKiemTheoTen(String tuKhoa){
    tuKhoa = tuKhoa.toLowerCase();
    ArrayList<Model_KhachHang> khds = new ArrayList<>();
    for (Model_KhachHang kh : dskh){
        String TenKh = kh.getTenKh().
    }
}
}
