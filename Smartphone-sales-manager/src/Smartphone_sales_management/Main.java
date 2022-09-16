package Smartphone_sales_management;

import Smartphone_sales_management.DAO.QuanLyNhanVien_DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vuong
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Worlds");
        QuanLyNhanVien_DAO qlnv = new QuanLyNhanVien_DAO();
        qlnv.getMotNhanVien("001");
        
    }
}
