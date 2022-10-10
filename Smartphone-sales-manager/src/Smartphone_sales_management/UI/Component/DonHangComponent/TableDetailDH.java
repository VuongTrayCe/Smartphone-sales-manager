/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.DonHangComponent;

import Smartphone_sales_management.BUS.QuanLyDonHang_BUS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Admin
 */
public class TableDetailDH extends javax.swing.JPanel {

//    public int indexSelected
    public static int selectedIndex = -1;
    QuanLyDonHang_BUS qldh_BUS = new QuanLyDonHang_BUS();

    public TableDetailDH(int index) {
        initComponents();
        selectedIndex = index;
        if (selectedIndex != -1) {
            DisplayInfor();
        }
    }

    public void DisplayInfor() {
        ArrayList data = new ArrayList();
        data = qldh_BUS.layDanhSachChiTietDonHang(this.selectedIndex);
        DefaultComboBoxModel modelTenSP = new DefaultComboBoxModel();
        DefaultComboBoxModel modelLoai = new DefaultComboBoxModel();
        int SoChiTietDonHang = data.size() / 8;
        int currentIndexTT = 0;
        int currentIndexTSP = 1;
        int currentIndexLoai = 2;
        int currentIndexSL = 3;
        int currentIndexKM = 4;
        int currentIndexBHBD = 5;
        int currentIndexBHKT = 6;
        int currentIndexGia = 7;

        ArrayList<String> ctdh = new ArrayList();
        ArrayList tctdh = new ArrayList();
        while (SoChiTietDonHang != 0) {
            modelTenSP.addElement(data.get(currentIndexTSP).toString());
            ctdh.add(data.get(currentIndexLoai).toString());
            ctdh.add(data.get(currentIndexSL).toString());
            ctdh.add(data.get(currentIndexKM).toString());
            ctdh.add(data.get(currentIndexBHBD).toString());
            ctdh.add(data.get(currentIndexBHKT).toString());
            ctdh.add(data.get(currentIndexGia).toString());
            currentIndexLoai += 8;
            currentIndexSL += 8;
            currentIndexKM += 8;
            currentIndexBHBD += 8;
            currentIndexBHKT += 8;
            currentIndexGia += 8;
            currentIndexTSP += 8;
            tctdh.add(ctdh);
            System.out.println(tctdh);
            ctdh.removeAll(ctdh);
            SoChiTietDonHang--;
        }
//        System.out.println(tctdh);
        lbcName2.setText((String) data.get(0));
        jComboBox1.setModel(modelTenSP);
        jComboBox2.setModel(modelLoai);
        lbcSL1.setText(data.get(3).toString());
        lbcKhuyenMai.setText(data.get(4).toString());
        lbcBHBD.setText(data.get(5).toString());
        lbcBHKT.setText(data.get(6).toString());
        lbcGia1.setText(data.get(7).toString());

        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(ctdh.get(jComboBox1.getSelectedIndex()));

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbTenSanPham = new javax.swing.JLabel();
        lbLoaiSP = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        lbKhuyenMai = new javax.swing.JLabel();
        lbBHBD = new javax.swing.JLabel();
        lbGia = new javax.swing.JLabel();
        lbcSL1 = new javax.swing.JLabel();
        lbcKhuyenMai = new javax.swing.JLabel();
        lbcBHBD = new javax.swing.JLabel();
        lbcGia1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        lbTrangThai = new javax.swing.JLabel();
        lbcName2 = new javax.swing.JLabel();
        btnThem1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        lbBHKT = new javax.swing.JLabel();
        lbcBHKT = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(354, 450));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Xem chi tiết đơn hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        lbTenSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenSanPham.setText("Tên sản phẩm:");

        lbLoaiSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLoaiSP.setText("Loại sản phẩm:");

        lbSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSoLuong.setText("Số lượng :");

        lbKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbKhuyenMai.setText("Khuyến Mãi");

        lbBHBD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbBHBD.setText("Bảo Hành Ngày BĐ:");

        lbGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGia.setText("Giá :         ");

        lbcSL1.setText("jLabel12");

        lbcKhuyenMai.setText("jLabel13");

        lbcBHBD.setText("jLabel14");

        lbcGia1.setText("jLabel15");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/print.png"))); // NOI18N
        btnThem.setBorder(null);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        lbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTrangThai.setText("Trạng Thái:");

        lbcName2.setText("jLabel10");

        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/confirm.png"))); // NOI18N
        btnThem1.setBorder(null);
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbBHKT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbBHKT.setText("Bảo Hành Ngày KT:");

        lbcBHKT.setText("jLabel14");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbTenSanPham)
                                        .addComponent(lbTrangThai))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbcName2)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbLoaiSP)
                                        .addComponent(lbSoLuong))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbcSL1, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(btnThem1)
                                    .addGap(29, 29, 29))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lbKhuyenMai)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbcKhuyenMai))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lbGia)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbcGia1))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lbBHKT)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbcBHKT)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(lbBHBD)
                            .addGap(18, 18, 18)
                            .addComponent(lbcBHBD))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcName2))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenSanPham)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLoaiSP)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoLuong)
                    .addComponent(lbcSL1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbKhuyenMai)
                    .addComponent(lbcKhuyenMai))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBHBD)
                    .addComponent(lbcBHBD))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBHKT)
                    .addComponent(lbcBHKT))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGia)
                    .addComponent(lbcGia1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(11, 11, 11)))
                .addGap(10, 10, 10))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lbImage.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(241, 241, 241))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 417, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 28, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        //
        //            FileDialog fd = new FileDialog(new JFrame(), "Xuất excel", FileDialog.LOAD);
        //        fd.setVisible(true);
        //                String url = fd.getDirectory() + fd.getFile();
        ////                lbImage.setIcon(new ImageIcon(new URL(url)));
        //              String[] url2= url.split("src");
        //              String a = url2[1].replace("\\","/");
        //              System.out.println(a);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbBHBD;
    private javax.swing.JLabel lbBHKT;
    private javax.swing.JLabel lbGia;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbKhuyenMai;
    private javax.swing.JLabel lbLoaiSP;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTenSanPham;
    private javax.swing.JLabel lbTrangThai;
    private javax.swing.JLabel lbcBHBD;
    private javax.swing.JLabel lbcBHKT;
    private javax.swing.JLabel lbcGia1;
    private javax.swing.JLabel lbcKhuyenMai;
    private javax.swing.JLabel lbcName2;
    private javax.swing.JLabel lbcSL1;
    // End of variables declaration//GEN-END:variables
}
