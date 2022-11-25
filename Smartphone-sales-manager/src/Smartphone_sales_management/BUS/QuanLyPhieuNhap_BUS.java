/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.BUS;

import Smartphone_sales_management.DAO.QuanLyPhieuNhap_DAO;
import Smartphone_sales_management.DTO.Model_PhieuNhap;
import Smartphone_sales_management.DTO.Model_PhieuNhap_ChiTiet;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Vuong
 */
public class QuanLyPhieuNhap_BUS {

    QuanLyPhieuNhap_DAO qlpn = new QuanLyPhieuNhap_DAO();

    public ArrayList getDanhSachPhieuNhap(String keyWord, String tranngthai) {
        ArrayList dssp = new ArrayList();
        ArrayList dsspOfficial = new ArrayList<>();
        dssp = qlpn.getDanhSachPhieuNhap_DAO();
        if (keyWord == "" && tranngthai.equals("ALL")) {
            return dssp;
        }
        if (keyWord != "" && tranngthai.equals("ALL")) {
            for (Object x : dssp) {
                Vector y = (Vector) x;
                String mapn = Integer.toString((int) y.get(1));
                String tenncc = y.get(3).toString();
//                String name = (String) y.get(1);
                if (mapn.contains(keyWord) || tenncc.contains(keyWord)) {
                    {
                        dsspOfficial.add(y);
                    }

                }
            }
            return dsspOfficial;
        }
        if (tranngthai.equals("ALL") != true) {
            dssp = qlpn.getALLPhieuNhapTheoTrangThai(tranngthai);

            if (keyWord == "") {
                return dssp;
            } else {
                for (Object x : dssp) {
                    Vector y = (Vector) x;
                    String mapn = Integer.toString((int) y.get(1));
                    String tenncc = y.get(3).toString();
//                String name = (String) y.get(1);
                    if (mapn.contains(keyWord) || tenncc.contains(keyWord)) {
                        {
                            dsspOfficial.add(y);
                        }

                    }
                }
            }
        }
        return dsspOfficial;

    }

    public ArrayList getChiTietPhieuNhap(int Mapn) {
        ArrayList data = qlpn.getChiTietPhieuNhap_DAO(Mapn);

        return data;
    }

    public ArrayList<Object> getALLNhaCungCap() {

        ArrayList dsnhacc = new ArrayList();

        dsnhacc = qlpn.getALLNhaCungCap();
        return dsnhacc;
    }

    public ArrayList getALLSanPham(int mancc) {
        ArrayList dssp = new ArrayList();
//        System.out.println("ALo");
        dssp = qlpn.getALLSanPham(mancc);
        return dssp;

    }

    public int AddPhieuNhapHang(Model_PhieuNhap modelPhieuNhap) {
        return qlpn.AddPhieuNhapHang(modelPhieuNhap);
    }

    public void AddChiTietPhieuNhap(Model_PhieuNhap_ChiTiet model_PhieuNhap_ChiTiet) {

        qlpn.AddChiTietPhieuNhap(model_PhieuNhap_ChiTiet);
    }

    public Boolean UpdateTrangThai(int Mapn, String trangthai) {
        return qlpn.UpdatePhieuNhap(Mapn,trangthai);
    }

    public void updateSLSanPham(int mapn,ArrayList dataChiTiet) {
        int mancc = qlpn.getMaNCC(mapn);
        for (Object object : dataChiTiet) {
            Vector dataChiTietPhieuNhap = (Vector) object;
            int masp= (int) dataChiTietPhieuNhap.get(1);
            int sl =(int) dataChiTietPhieuNhap.get(4);
                    qlpn.UpdateSLSanPham(masp,sl,mancc);
        }
    }

}
