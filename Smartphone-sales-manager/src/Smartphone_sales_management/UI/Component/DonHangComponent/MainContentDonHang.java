/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.DonHangComponent;

import Smartphone_sales_management.BUS.QuanLyBanHang_BUS;
import Smartphone_sales_management.BUS.QuanLyDonHang_BUS;
import Smartphone_sales_management.DTO.Model_DonHang;
import Smartphone_sales_management.UI.Component.PhieuNhap.RoundedBorderer;
import Smartphone_sales_management.UI.Event.DonHang.EventDonHang;
import Smartphone_sales_management.UI.Event.DonHang.EventDonHang2;
import Smartphone_sales_management.UI.Main.MainFrame;
import Smartphone_sales_management.UI.Swing.GraphicsTextFied;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Window;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class MainContentDonHang extends javax.swing.JPanel {

    MainFrame mainFrame;
    TableDetailDH detailDH;
    TableDonHang donHang;
    int Madonhang = -1;

    public MainContentDonHang(MainFrame mainFrame) throws ParseException {
        initComponents();
        this.mainFrame = mainFrame;
        donHang = new TableDonHang("", jComboBox2.getSelectedItem().toString(), DateStart.getDate(), DateEnd.getDate());
        jScrollPane1.setViewportView(donHang);
        //        detailDonHangPanel.setLayout(new GridLayout());
        donHang.addEventDonHang(new EventDonHang() {
            @Override
            public int SelectedInxex(int Madh) {
                JFrame frame = new JFrame("Chi Tiet Don Hang");
                detailDH = new TableDetailDH(Madh, donHang, jComboBox2.getSelectedItem().toString(), DateStart.getDate(), DateEnd.getDate());
                QuanLyDonHang_BUS qldh_BUS = new QuanLyDonHang_BUS();
                qldh_BUS.laySoLuongctdh(Madh);
                frame.setSize(600, 500);
                frame.add(detailDH);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
//                detailDonHangPanel.removeAll();

//                detailDH.setBounds(0, 0, detailDonHangPanel.getWidth(), detailDonHangPanel.getHeight());
//                detailDonHangPanel.add(detailDH);
                repaint();
//                detailDH.validate();
                return Madh;
            }
        }, new EventDonHang2() {
            @Override
            public int maDH(int Madh) {
                Madonhang = Madh;
                return Madh;
            }

        });

        btnInHoaDon.setBorder(new RoundedBorderer(new Color(0, 51, 51), 2, 30));
        btnExcel.setBorder(new RoundedBorderer(new Color(0, 51, 51), 2, 30));

        txtTimkiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                try {
                    donHang.SetDefaultTable(txtTimkiem.getText(), jComboBox2.getSelectedItem().toString(), DateStart.getDate(), DateEnd.getDate());
                } catch (ParseException ex) {
                    Logger.getLogger(MainContentDonHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    donHang.SetDefaultTable(txtTimkiem.getText(), jComboBox2.getSelectedItem().toString(), DateStart.getDate(), DateEnd.getDate());
                } catch (ParseException ex) {
                    Logger.getLogger(MainContentDonHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {

                try {
                    donHang.SetDefaultTable(txtTimkiem.getText(), jComboBox2.getSelectedItem().toString(), DateStart.getDate(), DateEnd.getDate());
                } catch (ParseException ex) {
                    Logger.getLogger(MainContentDonHang.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTimkiem = new GraphicsTextFied(30);
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        btnExcel = new javax.swing.JButton();
        btnInHoaDon = new javax.swing.JButton();
        DateStart = new com.toedter.calendar.JDateChooser();
        DateEnd = new com.toedter.calendar.JDateChooser();
        BtnLocTheoNgay = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 255, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtTimkiem.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        txtTimkiem.setForeground(new java.awt.Color(153, 153, 153));
        txtTimkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimkiemMouseClicked(evt);
            }
        });
        txtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimkiemActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "Hoàn Thành", "Đặt Hàng", "Đã Hủy" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        btnExcel.setBackground(new java.awt.Color(255, 0, 51));
        btnExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Logos-Excel-icon.png"))); // NOI18N
        btnExcel.setText("Xuất Excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        btnInHoaDon.setBackground(new java.awt.Color(255, 0, 51));
        btnInHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Very-Basic-Print-icon.png"))); // NOI18N
        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        DateStart.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Từ ngày"));

        DateEnd.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Đến ngày"));

        BtnLocTheoNgay.setBackground(new java.awt.Color(0, 0, 0));
        BtnLocTheoNgay.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        BtnLocTheoNgay.setForeground(new java.awt.Color(255, 255, 255));
        BtnLocTheoNgay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BtnLocTheoNgay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/search-icon (1).png"))); // NOI18N
        BtnLocTheoNgay.setText("Xem");
        BtnLocTheoNgay.setOpaque(true);
        BtnLocTheoNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnLocTheoNgayMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("|| Thông Tin Đơn Đặt Hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInHoaDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcel))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(DateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnLocTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138)))
                        .addGap(0, 448, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcel)
                    .addComponent(btnInHoaDon)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnLocTheoNgay, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1031, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimkiemActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void txtTimkiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimkiemMouseClicked
        txtTimkiem.setText("");

// TODO add your handling code here:
    }//GEN-LAST:event_txtTimkiemMouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        txtTimkiem.setText("");
        try {
            donHang.SetDefaultTable(txtTimkiem.getText(), jComboBox2.getSelectedItem().toString(), DateStart.getDate(), DateEnd.getDate());

// TODO add your handling code here:
        } catch (ParseException ex) {
            Logger.getLogger(MainContentDonHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        XuatExcel123 ex = new XuatExcel123(txtTimkiem.getText(), jComboBox2.getSelectedItem().toString(), DateStart.getDate(), DateEnd.getDate());
        try {
            ex.xuatFileExcelDanhSachtHoaDon();
        } catch (ParseException ex1) {
            Logger.getLogger(MainContentDonHang.class.getName()).log(Level.SEVERE, null, ex1);
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        JFrame frame = new JFrame();
        ArrayList dsctdh = new ArrayList();
        QuanLyDonHang_BUS qldh_BUS = new QuanLyDonHang_BUS();
        dsctdh = qldh_BUS.layctdh(Madonhang);
        PanelInHoaDon pn = new PanelInHoaDon(dsctdh, frame);
        frame.setSize(1000, 750);
        frame.setLocationRelativeTo(null);
        frame.add(pn);
        frame.setVisible(true);
    }//GEN-LAST:event_btnInHoaDonActionPerformed
    private boolean checkDate() {
        if (DateStart.getDate() != null && DateEnd.getDate() != null) {
            return true;
        }
        return false;
    }
    private void BtnLocTheoNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnLocTheoNgayMouseClicked
        if (checkDate()) {
            try {
                donHang.SetDefaultTable(txtTimkiem.getText(), jComboBox2.getSelectedItem().toString(), DateStart.getDate(), DateEnd.getDate());
            } catch (ParseException ex) {
                Logger.getLogger(MainContentDonHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chua chon ngay nhap");
        }

    }//GEN-LAST:event_BtnLocTheoNgayMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnLocTheoNgay;
    private com.toedter.calendar.JDateChooser DateEnd;
    private com.toedter.calendar.JDateChooser DateStart;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
