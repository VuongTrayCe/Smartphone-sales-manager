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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class TableDetailDH extends javax.swing.JPanel {

//    public int indexSelected
    QuanLyDonHang_BUS qldh_BUS = new QuanLyDonHang_BUS();
    TableDonHang donhang;
    ArrayList data = new ArrayList();
    public int Madh = -1;
    String tenTrangThai;
    int slctdh = -1;
    Date start;
    Date end;

    public TableDetailDH(int Madh, TableDonHang donhang, String tenTrangThai, Date start, Date end) {
        initComponents();
        this.donhang = donhang;
        this.Madh = Madh;
        this.start = start;
        this.end = end;
        this.tenTrangThai = tenTrangThai;
        if (this.Madh != -1) {

            data = qldh_BUS.layctdh(Madh);
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
        data = qldh_BUS.layctdh(this.Madh);
        slctdh = qldh_BUS.laySoLuongctdh(Madh);
        Vector dataDetail = new Vector();
        dataDetail = (Vector) data.get(jComboBox1.getSelectedIndex());
        madhlb.setText(dataDetail.get(0).toString());
        trangthailb1.setForeground(Color.red);
        madhlb.setText(dataDetail.get(0).toString());
        lbcLoai.setText(dataDetail.get(2).toString());
        lbcSL1.setText(dataDetail.get(3).toString());
        lbcKhuyenMai.setText(dataDetail.get(4).toString() + "%");
        lbcBHKT.setText(dataDetail.get(5).toString());
        lbcGia1.setText(dataDetail.get(10).toString());
        lbtongchitietgia.setText(dataDetail.get(6).toString());
        lbcgiasaukm.setText(dataDetail.get(7).toString());
        trangthailb1.setText(dataDetail.get(8).toString());
        txtslct.setText(String.valueOf(slctdh));
        if (dataDetail.get(9).toString() != null) {
            char temp = '\\';
            String newIcon = dataDetail.get(9).toString().replace(temp, '/');
            imglb.setIcon(new ImageIcon(getClass().getResource(newIcon)));
        }
        if (dataDetail.get(8).toString().equals("Hoàn Thành") || dataDetail.get(8).toString().equals("Đã Hủy")) {
            confirmBtn.setVisible(false);
            deleteBtn.setVisible(false);
        } else if (dataDetail.get(8).toString().equals("Đặt Hàng")) {
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
        jPanel2 = new javax.swing.JPanel();
        lbTrangThai = new javax.swing.JLabel();
        lbTenSanPham1 = new javax.swing.JLabel();
        madhlb = new javax.swing.JLabel();
        txtslct = new javax.swing.JLabel();
        lbTenSanPham = new javax.swing.JLabel();
        lbLoaiSP = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lbcLoai = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        lbcSL1 = new javax.swing.JLabel();
        lbGia = new javax.swing.JLabel();
        lbcGia1 = new javax.swing.JLabel();
        lbGia1 = new javax.swing.JLabel();
        lbcgiasaukm = new javax.swing.JLabel();
        lbGia2 = new javax.swing.JLabel();
        lbtongchitietgia = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        imglb = new javax.swing.JLabel();
        lbKhuyenMai = new javax.swing.JLabel();
        lbcKhuyenMai = new javax.swing.JLabel();
        lbBHKT = new javax.swing.JLabel();
        lbcBHKT = new javax.swing.JLabel();
        lbTrangThai1 = new javax.swing.JLabel();
        trangthailb1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        confirmBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(354, 450));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Xem chi tiết đơn hàng");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(300, 387));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lbTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTrangThai.setText("Mã DH");

        lbTenSanPham1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenSanPham1.setText("Số lượng chi tiết");

        madhlb.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        madhlb.setForeground(new java.awt.Color(255, 0, 51));
        madhlb.setText("jLabel10");

        txtslct.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtslct.setText("jLabel12");

        lbTenSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenSanPham.setText("Tên sản phẩm:");

        lbLoaiSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLoaiSP.setText("Loại sản phẩm:");

        jComboBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        lbcLoai.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbcLoai.setText("jLabel12");

        lbSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSoLuong.setText("Số lượng :");

        lbcSL1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbcSL1.setText("jLabel12");

        lbGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGia.setText("Giá :         ");

        lbcGia1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbcGia1.setText("jLabel15");

        lbGia1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGia1.setText("Giá sau khuyến mãi :");

        lbcgiasaukm.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbcgiasaukm.setText("jLabel15");

        lbGia2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGia2.setText("Tổng chi tiết giá :");

        lbtongchitietgia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbtongchitietgia.setText("jLabel15");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbTenSanPham)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbTenSanPham1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtslct))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbTrangThai)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(madhlb)))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbGia2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbtongchitietgia))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbGia1)
                                    .addComponent(lbGia)
                                    .addComponent(lbSoLuong)
                                    .addComponent(lbLoaiSP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbcSL1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbcLoai, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbcGia1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbcgiasaukm, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(28, 28, 28))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(madhlb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenSanPham1)
                    .addComponent(txtslct))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenSanPham)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLoaiSP)
                    .addComponent(lbcLoai))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSoLuong)
                    .addComponent(lbcSL1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGia)
                    .addComponent(lbcGia1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGia1)
                    .addComponent(lbcgiasaukm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGia2)
                    .addComponent(lbtongchitietgia))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        imglb.setBackground(new java.awt.Color(255, 255, 255));
        imglb.setOpaque(true);

        lbKhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbKhuyenMai.setText("Khuyến Mãi");

        lbcKhuyenMai.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbcKhuyenMai.setText("jLabel13");

        lbBHKT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbBHKT.setText("Thời gian BH");

        lbcBHKT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbcBHKT.setText("jLabel14");

        lbTrangThai1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTrangThai1.setText("Trạng Thái:");

        trangthailb1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        trangthailb1.setForeground(new java.awt.Color(255, 0, 51));
        trangthailb1.setText("jLabel10");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbKhuyenMai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbcKhuyenMai))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbBHKT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbcBHKT))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbTrangThai1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(trangthailb1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(imglb, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imglb, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbKhuyenMai)
                    .addComponent(lbcKhuyenMai))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBHKT)
                    .addComponent(lbcBHKT, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTrangThai1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trangthailb1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(confirmBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addGap(62, 62, 62)
                .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        DisplayInfor();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn hủy ?", "Hủy đơn hàng", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            qldh_BUS.updateHuyDonHang(Integer.parseInt(madhlb.getText()));
            qldh_BUS.tinhDiemChoKhachHangKhiHuy(Madh);
            System.out.println(data + "123");
            qldh_BUS.UpdateSLSP(data);
            DisplayInfor();
            try {
                donhang.SetDefaultTable("", tenTrangThai, start, end);
            } catch (ParseException ex) {
                Logger.getLogger(TableDetailDH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void confirmBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmBtnMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xác nhận ?", "Xác nhận đơn hàng", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            qldh_BUS.updateXacNhanDonHang(Integer.parseInt(madhlb.getText()));
            qldh_BUS.tinhDiemChoKhachHangKhiHoanThanh(Madh);

            DisplayInfor();
            try {
                donhang.SetDefaultTable("", tenTrangThai, start, end);
            } catch (ParseException ex) {
                Logger.getLogger(TableDetailDH.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_confirmBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel imglb;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbBHKT;
    private javax.swing.JLabel lbGia;
    private javax.swing.JLabel lbGia1;
    private javax.swing.JLabel lbGia2;
    private javax.swing.JLabel lbKhuyenMai;
    private javax.swing.JLabel lbLoaiSP;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTenSanPham;
    private javax.swing.JLabel lbTenSanPham1;
    private javax.swing.JLabel lbTrangThai;
    private javax.swing.JLabel lbTrangThai1;
    private javax.swing.JLabel lbcBHKT;
    private javax.swing.JLabel lbcGia1;
    private javax.swing.JLabel lbcKhuyenMai;
    private javax.swing.JLabel lbcLoai;
    private javax.swing.JLabel lbcSL1;
    private javax.swing.JLabel lbcgiasaukm;
    private javax.swing.JLabel lbtongchitietgia;
    private javax.swing.JLabel madhlb;
    private javax.swing.JLabel trangthailb1;
    private javax.swing.JLabel txtslct;
    // End of variables declaration//GEN-END:variables
}
