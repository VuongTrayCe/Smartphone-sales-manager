/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.TaiKhoan2;

import Smartphone_sales_management.UI.Component.TaiKhoanComponent.*;
import Smartphone_sales_management.BUS.QuanLyQuyen_BUS;
import Smartphone_sales_management.DTO.Model_Quyen;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Window;
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
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author Dell
 */
public class FormQuanLyQuyenTK_ThemQuyen extends javax.swing.JPanel {

    QuanLyQuyen_BUS qlq_BUS = new QuanLyQuyen_BUS();
    FormQuanLyQuyenTK frame;
    JDialog dialog;
    ArrayList dstk;
    ArrayList dsq;
    ArrayList arrquyenmoi = new ArrayList();
    int matk;

    public FormQuanLyQuyenTK_ThemQuyen(FormQuanLyQuyenTK frame, JDialog dialog) {
        initComponents();
        this.frame = frame;
        this.dialog = dialog;
        dstk = new ArrayList();
        dsq = new ArrayList();
        dstk = qlq_BUS.layDanhSachMatk2();
        Vector dstk0 = (Vector) dstk.get(0);
        loadALLQuyenTheoTK(Integer.parseInt(dstk0.get(0).toString()));

//        Vector dsq0 = (Vector) dsq.get(0);
        DefaultComboBoxModel modelcbbtk = new DefaultComboBoxModel();
        DefaultComboBoxModel modelcbbq = new DefaultComboBoxModel();
        for (Object x : dstk) {
            Vector y = (Vector) x;
            modelcbbtk.addElement(y.get(0));
        }
//        for (Object x1 : dsq) {
//            Vector y1 = (Vector)x1 ;
//            modelcbbq.addElement(y1.get(0));
//        }
        cbbMatk.setModel(modelcbbtk);
        cbbMatk.setSelectedIndex(0);
        txtTenNhanVien.setText(dstk0.get(1).toString());
        matk = (int) dstk0.get(0);

//        cbbMaQ.setModel(modelcbbq);
        // dang do du lieu vo cbb
    }

    public void loadALLQuyenTheoTK(int matk) {
        cbbMaQ.removeAllItems();
        dsq = qlq_BUS.layDanhSachQuyenTheoTaiKhoan(matk);
        for (Object object : dsq) {
            Vector a = (Vector) object;
            cbbMaQ.addItem(a.get(1).toString());

        }

    }

    public void loadALLLQuyenmoi(ArrayList arr) {
        cbbquyenmoi.removeAllItems();
        for (Object object : arr) {
            Vector a = (Vector) object;
            cbbquyenmoi.addItem(a.get(1).toString());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbbMatk = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbbMaQ = new javax.swing.JComboBox<>();
        btnHoanThanh = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbbquyenmoi = new javax.swing.JComboBox<>();

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Thêm Quyền");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Mã Tài Khoản");

        cbbMatk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMatkItemStateChanged(evt);
            }
        });
        cbbMatk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMatkActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Quyền Hiện Tại");

        cbbMaQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMaQActionPerformed(evt);
            }
        });

        btnHoanThanh.setBackground(new java.awt.Color(0, 0, 0));
        btnHoanThanh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHoanThanh.setForeground(new java.awt.Color(255, 255, 255));
        btnHoanThanh.setText("Hoàn Thành");
        btnHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Add - Copy.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nhân Viên");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Quay Lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Quyền Mới");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(64, 64, 64))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(cbbMatk, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cbbquyenmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHoanThanh)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbMaQ, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(44, 44, 44)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMatk)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbMaQ)
                        .addComponent(cbbquyenmoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHoanThanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbMaQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMaQActionPerformed
//         ArrayList dsq = new ArrayList();
//        dsq = qlq_BUS.layDanhSachMaQuyen();
//        Vector data = (Vector) dsq.get(cbbMaQ.getSelectedIndex());
//        txtTenQuyen.setText(data.get(1).toString());
    }//GEN-LAST:event_cbbMaQActionPerformed

    private void cbbMatkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMatkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMatkActionPerformed

    private void btnHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhActionPerformed

        if (arrquyenmoi.size() == 0) {
            JOptionPane.showMessageDialog(null, "Vui Lòng Thêm Quyền Mới");
        } else {
            qlq_BUS.AddQuyenTaiKhoan(arrquyenmoi, matk);
            JOptionPane.showMessageDialog(null, "Thêm Thành Công");
            frame.setDefautlQuyen();
            dialog.dispose();
        }


    }//GEN-LAST:event_btnHoanThanhActionPerformed

    private void cbbMatkItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMatkItemStateChanged

        int index = cbbMatk.getSelectedIndex();
        Vector tennv = (Vector) (dstk.get(index));
        matk = (int) tennv.get(0);
        txtTenNhanVien.setText(tennv.get(1).toString());
        loadALLQuyenTheoTK(matk);
        cbbquyenmoi.removeAllItems();

// TODO add your handling code here:
    }//GEN-LAST:event_cbbMatkItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dialog.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Window win = SwingUtilities.getWindowAncestor(this);
        JDialog inforDonHang = new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
        FormQuanLyQuyenTK_AddQuyen_Add a = new FormQuanLyQuyenTK_AddQuyen_Add(matk, inforDonHang, arrquyenmoi, FormQuanLyQuyenTK_ThemQuyen.this);
//        changePwdDialog.setUndecorated(true);
//          ThongTinDonHang donhang = new ThongTinDonHang(data,this,inforDonHang);
//        AddKhachHang themkhachhang = new AddKhachHang(inforDonHang, this);
        inforDonHang.setSize(300, 200);
        inforDonHang.setLayout(new GridLayout());
        inforDonHang.setTitle("Thêm Quyền Tài Khoản");
        inforDonHang.add(a);
        a.validate();
        inforDonHang.setLocationRelativeTo(null);
        inforDonHang.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        inforDonHang.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoanThanh;
    private javax.swing.JComboBox<String> cbbMaQ;
    private javax.swing.JComboBox<String> cbbMatk;
    private javax.swing.JComboBox<String> cbbquyenmoi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtTenNhanVien;
    // End of variables declaration//GEN-END:variables
}
