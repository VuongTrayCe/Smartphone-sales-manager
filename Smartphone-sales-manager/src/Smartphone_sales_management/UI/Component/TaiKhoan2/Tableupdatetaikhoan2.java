/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.TaiKhoan2;

import Smartphone_sales_management.UI.Component.TaiKhoanComponent.*;
import Smartphone_sales_management.BUS.QuanLyTaiKhoan_BUS;
import static Smartphone_sales_management.UI.Component.TaiKhoanComponent.LoginFrom.main;
import Smartphone_sales_management.UI.Model.Model_TaiKhoan;
import Smartphone_sales_management.UI.Component.TaiKhoanComponent.MainConTentTaiKhoan;
import Smartphone_sales_management.UI.Main.MainFrame;
import java.io.File;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Windows10
 */
public class TableUpdateTaiKhoan2 extends javax.swing.JPanel {

    JFrame frame, framecontent;
    QuanLyTaiKhoan_BUS qltk_BUS = new QuanLyTaiKhoan_BUS();
    ArrayList dataCTTK;

    ArrayList data;
    MainConTentTaiKhoan2 frametaikhoan;

    public TableUpdateTaiKhoan2(ArrayList data, JFrame frame, MainConTentTaiKhoan2 frametaikhoan, JTable tableTK, JFrame framecontent) {
        initComponents();
        this.frame = frame;
        this.framecontent = framecontent;
        this.data = data;
        this.frametaikhoan = frametaikhoan;
        ArrayList dsnv = new ArrayList();
        dsnv = qltk_BUS.layDanhSachNV();
        Vector dsnv0 = (Vector) dsnv.get(0);
        DisplayInfor(this.data);
//        DefaultComboBoxModel modelcbbnv = new DefaultComboBoxModel();
//        for (Object x1 : dsnv) {
//            Vector y1 = (Vector)x1 ;
//            modelcbbnv.addElement(y1.get(0));
//        }
//        cbbnv.setModel(modelcbbnv);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        txtTendangnhap = new javax.swing.JTextField();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        javax.swing.JButton btnSua = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        txtNhanVien = new javax.swing.JTextField();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Mật Khẩu");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Mã tài khoản");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Tên Nhân Viên");

        btnSua.setBackground(new java.awt.Color(0, 0, 0));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa tài khoản");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tên đăng Nhập");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Sửa Tài Khoản");

        txtTaiKhoan.setEditable(false);

        txtNhanVien.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSua)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSua)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private boolean checkData() {
        boolean flag = true;
        String Tendangnhap = txtTendangnhap.getText();
        String Matkhau = txtMatKhau.getText();
        if (Tendangnhap.equals("")) {
            flag = false;
            JOptionPane.showMessageDialog(null, "Mời nhập Tên Đăng nhập ! ");
        } else if (Matkhau.equals("")) {
            flag = false;
            JOptionPane.showMessageDialog(null, "Mời nhập Mật Khẩu ! ");
        }
        if (flag == false) {
            return false;
        }
        return true;
    }

    public void DisplayInfor(ArrayList data) {
        ArrayList cttk = new ArrayList();
        cttk = data;
        txtTaiKhoan.setText(cttk.get(0).toString());
        txtNhanVien.setText(cttk.get(1).toString());
        txtTendangnhap.setText(cttk.get(2).toString());
        txtMatKhau.setText(cttk.get(3).toString());
    }
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (checkData()) {
            boolean check = true;
            Model_TaiKhoan model = new Model_TaiKhoan();
            model.setTaiKhoan(txtTendangnhap.getText());
            model.setMatKhau(txtMatKhau.getText());
            model.setMaTaiKhoan(Integer.parseInt(txtTaiKhoan.getText()));
            QuanLyTaiKhoan_BUS qltk_BUS = new QuanLyTaiKhoan_BUS();
            if (qltk_BUS.SuaTaiKhoan(model)) {
                check = true;
            } else {
                check = false;
            }
            if (check == true) {
                JOptionPane.showMessageDialog(null, "Sửa sản phẩm thành công !");
                frametaikhoan.setDefautlTaiKhoan();
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Sửa sản phẩm thất bại !");
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtTendangnhap;
    // End of variables declaration//GEN-END:variables
}
