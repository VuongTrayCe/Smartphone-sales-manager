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
	private int Quyen;
      
    
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
	public int getQuyen() {
		return Quyen;
	}
	public void setQuyen(int quyen) {
		Quyen = quyen;
	}
	
    
}
