/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyNhanVien_DAO;
import Smartphone_sales_management.UI.Model.Model_NhanVien;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lehongthai
 */
public class QuanLyNhanVien_BUS {
    QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
    public QuanLyNhanVien_BUS(){
    
    }
    public ArrayList<Model_NhanVien> getDanhSachNhanVien(String keyWord){
        ArrayList<Model_NhanVien> dsnv = new ArrayList<Model_NhanVien>();
   
        dsnv = qlnv.getDanhSachNhanVien_DAO();
       
        return dsnv;

    }
}
