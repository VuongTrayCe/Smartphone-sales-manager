/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.UI.Model;

/**
 *
 * @author Windows10
 */
public class Model_TaiKhoan {
        private int MaTaiKhoan;
        private int MaNhanVien; 
	private String TaiKhoan;
	private String MatKhau;
	private String Trangthai;
      
    
        public int getMaTaiKhoan() {
		return MaTaiKhoan;
	}
	public void setMaTaiKhoan(int maTaiKhoan) {
		MaTaiKhoan = maTaiKhoan;
	}
	public int getMaNhanVien() {
		return MaNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		MaNhanVien = maNhanVien;
	}
	public String getTaiKhoan() {
		return TaiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.TaiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		this.MatKhau = matKhau;
	}
	public String getTrangthai() {
		return Trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.Trangthai = trangthai;
	}
	
    
}
