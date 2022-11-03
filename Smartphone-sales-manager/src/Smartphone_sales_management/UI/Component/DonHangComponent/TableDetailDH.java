/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.DonHangComponent;

import Smartphone_sales_management.BUS.QuanLyDonHang_BUS;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class TableDetailDH extends javax.swing.JPanel {

//    public int indexSelected
    public static int selectedIndex = -1;
    QuanLyDonHang_BUS qldh_BUS = new QuanLyDonHang_BUS();
    TableDonHang donhang;
    ArrayList data = new ArrayList();
    String tenTrangThai;

    public TableDetailDH(int index, String tenTrangThai,DefaultTableModel model,TableDonHang donhang) {
        initComponents();
        this.donhang= donhang;
        selectedIndex = index;
        this.tenTrangThai = tenTrangThai;
        if (selectedIndex != -1) {

            data = qldh_BUS.layDanhSachChiTietDonHang(this.selectedIndex, tenTrangThai);

            DefaultComboBoxModel modelTenSP = new DefaultComboBoxModel();
//            Tao bien arrSp de luu tenSP roi add vao modelTenSP
            for (Object object : data) {
                Vector arrSp = (Vector) object;
                modelTenSP.addElement(arrSp.get(1));
            }
            jComboBox1.setModel(modelTenSP);
            DisplayInfor();
        }

    }

    public void DisplayInfor() {
        ArrayList data = new ArrayList();
        data = qldh_BUS.layDanhSachChiTietDonHang(this.selectedIndex, tenTrangThai);
        Vector dataDetail = new Vector();
        dataDetail = (Vector) data.get(jComboBox1.getSelectedIndex());
        madhlb.setText(dataDetail.get(0).toString());
        trangthailb1.setForeground(Color.red);
        madhlb.setText(dataDetail.get(0).toString());
        lbcLoai.setText(dataDetail.get(2).toString());
        lbcSL1.setText(dataDetail.get(3).toString());
        lbcKhuyenMai.setText(dataDetail.get(4).toString() + "%");
        lbcBHKT.setText(dataDetail.get(5).toString());
        lbcGia1.setText(dataDetail.get(6).toString());
        lbcgiasaukm.setText(dataDetail.get(7).toString());
        trangthailb1.setText(dataDetail.get(8).toString());
        if (dataDetail.get(8).toString().equals("Đã xử lí") || dataDetail.get(8).toString().equals("Hủy đơn")) {
            confirmBtn.setVisible(false);
            deleteBtn.setVisible(false);
        } else if (dataDetail.get(8).toString().equals("Chưa xử lí")) {
            confirmBtn.setVisible(true);
            deleteBtn.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbTenSanPham = new javax.swing.JLabel();
        lbLoaiSP = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        lbKhuyenMai = new javax.swing.JLabel();
        lbGia = new javax.swing.JLabel();
        lbcSL1 = new javax.swing.JLabel();
        lbcKhuyenMai = new javax.swing.JLabel();
        lbcGia1 = new javax.swing.JLabel();
        lbTrangThai = new javax.swing.JLabel();
        madhlb = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lbBHKT = new javax.swing.JLabel();
        lbcBHKT = new javax.swing.JLabel();
        lbcLoai = new javax.swing.JLabel();
        lbGia1 = new javax.swing.JLabel();
        lbcgiasaukm = new javax.swing.JLabel();
        confirmBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        lbTrangThai1 = new javax.swing.JLabel();
        trangthailb1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(354, 450));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Xem chi tiết đơn hàng");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 387));

        lbTenSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenSanPham.setText("Tên sản phẩm:");

        lbLoaiSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLoaiSP.setText("Loại sản phẩm:");

        lbSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSoLuong.setText("Số lượng :");

        lbKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbKhuyenMai.setText("Khuyến Mãi");

        lbGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGia.setText("Giá :         ");

        lbcSL1.setText("jLabel12");

        lbcKhuyenMai.setText("jLabel13");

        lbcGia1.setText("jLabel15");

        lbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTrangThai.setText("Mã DH");

        madhlb.setText("jLabel10");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        lbBHKT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbBHKT.setText("Thời gian BH");

        lbcBHKT.setText("jLabel14");

        lbcLoai.setText("jLabel12");

        lbGia1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGia1.setText("Giá sau khuyến mãi :");

        lbcgiasaukm.setText("jLabel15");

        confirmBtn.setBackground(new java.awt.Color(255, 0, 51));
        confirmBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        confirmBtn.setForeground(new java.awt.Color(255, 255, 255));
        confirmBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/check1.png"))); // NOI18N
        confirmBtn.setText("Xác nhận đơn hàng");
        confirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmBtnMouseClicked(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 0, 51));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Close-icon.png"))); // NOI18N
        deleteBtn.setText("Hủy đơn hàng");
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });

        lbTrangThai1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTrangThai1.setText("Trạng Thái:");

        trangthailb1.setText("jLabel10");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbTenSanPham)
                                            .addComponent(lbTrangThai))
                                        .addGap(34, 34, 34))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbSoLuong)
                                            .addComponent(lbLoaiSP))
                                        .addGap(30, 30, 30))))
                            .addComponent(lbKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBHKT, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGia, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(madhlb, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbcGia1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbcBHKT, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbcKhuyenMai, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcSL1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbcLoai, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbGia1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbcgiasaukm))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(confirmBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbTrangThai1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trangthailb1)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(madhlb))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenSanPham)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLoaiSP)
                    .addComponent(lbcLoai))
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
                    .addComponent(lbBHKT)
                    .addComponent(lbcBHKT))
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGia)
                    .addComponent(lbcGia1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGia1)
                    .addComponent(lbcgiasaukm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTrangThai1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trangthailb1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(74, 74, 74))
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lbImage.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 444, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        DisplayInfor();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn hủy ?");
        if (a == JOptionPane.YES_OPTION) {
            qldh_BUS.updateHuyDonHang(Integer.parseInt(madhlb.getText()));
            DisplayInfor();
            donhang.SetDefaultTable("", 0);
        }
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void confirmBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xác nhận ?");
        if (a == JOptionPane.YES_OPTION) {
            qldh_BUS.updateXacNhanDonHang(Integer.parseInt(madhlb.getText()));
            DisplayInfor();
            donhang.SetDefaultTable("", 0);
        }
    }//GEN-LAST:event_confirmBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbBHKT;
    private javax.swing.JLabel lbGia;
    private javax.swing.JLabel lbGia1;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbKhuyenMai;
    private javax.swing.JLabel lbLoaiSP;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTenSanPham;
    private javax.swing.JLabel lbTrangThai;
    private javax.swing.JLabel lbTrangThai1;
    private javax.swing.JLabel lbcBHKT;
    private javax.swing.JLabel lbcGia1;
    private javax.swing.JLabel lbcKhuyenMai;
    private javax.swing.JLabel lbcLoai;
    private javax.swing.JLabel lbcSL1;
    private javax.swing.JLabel lbcgiasaukm;
    private javax.swing.JLabel madhlb;
    private javax.swing.JLabel trangthailb1;
    // End of variables declaration//GEN-END:variables
}
