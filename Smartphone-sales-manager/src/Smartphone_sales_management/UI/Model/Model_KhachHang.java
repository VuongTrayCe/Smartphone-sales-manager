/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.UI.Model;

/**
 *
 * @author Hiep
 */
public class Model_KhachHang {
    private int Makh;
    private String Tenkh;
    private  String Cmnd;
    private String SDT;
    private String DiaChi;
    private String Email;
    private String Ngaytao;
    private int Diemso;
    private String TrangThai;
    
    public Model_KhachHang(){
        
}

    public Model_KhachHang(int Makh, String Tenkh, String Cmnd,String SDT, String DiaChi, String Email, String Ngaytao, int Diemso, String TrangThai) {
        this.Makh = Makh;
        this.Tenkh = Tenkh;
        this.Cmnd = Cmnd;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.Ngaytao = Ngaytao;
        this.Diemso = Diemso;
        this.TrangThai = TrangThai;
    }

    public int getMakh() {
        return Makh;
    }

    public void setMakh(int Makh) {
        this.Makh = Makh;
    }

    public String getTenkh() {
        return Tenkh;
    }

    public void setTenkh(String Tenkh) {
        this.Tenkh = Tenkh;
    }

    public String getCmnd() {
        return Cmnd;
    }

    public void setCmnd(String Cmnd) {
        this.Cmnd = Cmnd;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNgaytao() {
        return Ngaytao;
    }

    public void setNgaytao(String Ngaytao) {
        this.Ngaytao = Ngaytao;
    }

    public int getDiemso() {
        return Diemso;
    }

    public void setDiemso(int Diemso) {
        this.Diemso = Diemso;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    public String[] toArrayString() {
		return new String[] {Integer.toString(Makh),Tenkh,Cmnd,SDT,DiaChi,Email,Ngaytao,Integer.toString(Diemso),TrangThai};
    }

    public Object getS??T() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
