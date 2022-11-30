/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.TaiKhoan2;

import Smartphone_sales_management.BUS.QuanLyQuyen_BUS;
import Smartphone_sales_management.BUS.QuanLyTaiKhoan_BUS;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JDialog;

/**
 *
 * @author Vuong
 */
public class FormQuanLyQuyenTK_AddQuyen_Add extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
//    QuanLyTaiKhoan_BUS qltk = new QuanLyTaiKhoan_BUS();
    QuanLyQuyen_BUS qltk = new QuanLyQuyen_BUS();
    ArrayList arrQuyen;

    public FormQuanLyQuyenTK_AddQuyen_Add() {
        initComponents();
    }
    int matk;
    JDialog dialog;
    JComboBox cbbquyenht;
    ArrayList arrquyenmoi;
    FormQuanLyQuyenTK_ThemQuyen frame;

    public FormQuanLyQuyenTK_AddQuyen_Add(int matk, JDialog inforDonHang, JComboBox cbbquyenht) {
        initComponents();
        this.matk = matk;
        this.cbbquyenht = cbbquyenht;
        this.dialog = inforDonHang;
        arrQuyen = qltk.layDanhSachQuyenChuaCo(matk);
        for (Object object : arrQuyen) {
            Vector a = (Vector) object;
            cbbQuyen.addItem(a.get(1).toString());
        }

    }

    FormQuanLyQuyenTK_AddQuyen_Add(int matk, JDialog inforDonHang, ArrayList arrquyenmoi, FormQuanLyQuyenTK_ThemQuyen aThis) {

        initComponents();
        this.matk = matk;
        this.frame = aThis;
        this.arrquyenmoi = arrquyenmoi;
        this.dialog = inforDonHang;
        loadData();

    }

    public void loadData() {
        arrQuyen = qltk.layDanhSachQuyenChuaCo(matk);
        for (Object object : arrQuyen) {
            Vector a = (Vector) object;
            Boolean flag = true;
            for (Object object1 : arrquyenmoi) {
                Vector b = (Vector) object1;
                if (a.get(1).toString().equals(b.get(1).toString())) {
                    flag = false;
                }

            }
            if (flag == true) {
                cbbQuyen.addItem(a.get(1).toString());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbbQuyen = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên Quyền");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Quay Lại");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        dialog.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        if(cbbQuyen.getSelectedItem()!=null )
        {
        String tenquyen = cbbQuyen.getSelectedItem().toString();
        for (Object object : arrQuyen) {
            Vector a = (Vector) object;
            if(a.get(1).toString().equals(tenquyen))
            {
                        arrquyenmoi.add(a);
            }

        }
        frame.loadALLLQuyenmoi(arrquyenmoi);
        dialog.dispose();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbQuyen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
