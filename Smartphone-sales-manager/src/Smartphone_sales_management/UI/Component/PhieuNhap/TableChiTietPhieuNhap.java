/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.PhieuNhap;

import Smartphone_sales_management.BUS.QuanLyPhieuNhap_BUS;
import Smartphone_sales_management.UI.Main.MainFrame;
import Smartphone_sales_management.UI.Swing.PrintPanel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vuong
 */
public class TableChiTietPhieuNhap extends javax.swing.JPanel {

    /**
     * Creates new form TableChiTietPhieuNhap
     */
    QuanLyPhieuNhap_BUS qlpn = new QuanLyPhieuNhap_BUS();
    MainFrame frame;
    private int Mapn;
    private String ngaynhap;
    private String tenncc;
    DefaultTableModel model = new DefaultTableModel();
    String trangthai;
    JDialog dialog;
    TablePhieuNhap a;
    public TableChiTietPhieuNhap(TablePhieuNhap a,JDialog dialog,int Maph, String Ngaynhap, String tenncc, MainFrame frame, String trangthai) {
        initComponents();
        this.frame = frame;
        this.ngaynhap = Ngaynhap;
        this.tenncc = tenncc;
        this.trangthai = trangthai;
        Mapn = Maph;
        this.a= a;
        this.dialog=dialog;
        this.tenncc = tenncc;

        model.addColumn("STT");
        model.addColumn("Mã Sản Phẩm");
        model.addColumn("Tên Sản Phẩm");
        model.addColumn("Giá Nhập");
        model.addColumn("Số Lượng");
        model.addColumn("Tổng Tiền");
        jTable1.setOpaque(false);
        jTable1.getTableHeader().getColumnModel().setColumnMargin(1);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 17) {
        });
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setBackground(new Color(14, 14, 14));
        jTable1.setModel(model);

        jButton1.setBorder(new RoundedBorderer(new Color(0, 51, 51), 2, 20));

        DisplayDetailPhieuNhap();
    }

    public void setBtbHoanThanhHuyDon(String trangthai) {
        if (this.trangthai.equals("Đang Xử Lý")) {
            btnHoanThanh.setVisible(true);
            btnHuy.setVisible(true);
        } else {
            btnHoanThanh.setVisible(false);
            btnHuy.setVisible(false);
        }
    }

    private void DisplayDetailPhieuNhap() {
//        

        ArrayList data = new ArrayList();
        data = qlpn.getChiTietPhieuNhap(Mapn);
        jTable1.removeAll();
        model.setRowCount(0);
        for (int i = 0; i < data.size(); i++) {
            model.addRow((Vector<?>) data.get(i));
        }
        jScrollPane1.repaint();
        lbMaPhieuNhap.setText(Integer.toString(Mapn));
        lbNgayNhap.setText(ngaynhap);
        lbNhaCungCap.setText(tenncc);
        setBtbHoanThanhHuyDon(trangthai);
        

//        Model_BanHang_ChiTietSanPham model = data.get(0);
//        lbcName.setText(model.getTensp());
//        lbcLoai.setText(model.getLoaisp());
//        String km = String.valueOf(model.getPtkm()) + " %";
//        lbnKhuyenMai.setText(km);
//        lbnBaoHanh.setText(model.getBaohanh());
//        String SL = String.valueOf(model.getSl());
//        lbcSL.setText(SL);
//        lbcNamSx.setText(model.getNamsx());
//        lbcNCC.setText(model.getTenncc());
//        String gia = String.valueOf(model.getGiaban());
//        lbcGia.setText(gia + " VND");
//        this.urlImage = model.getIcon();
//        String str = model.getChitiet();
//        String[] tachChuoi = str.split("//");
//        String chuoiChinh = "";
//        for (String string : tachChuoi) {
//            chuoiChinh += (string + "\n");
//        }
//       
//        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbMaPhieuNhap = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbNhaCungCap = new javax.swing.JLabel();
        lbNgayNhap = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnHoanThanh = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(30);
        jTable1.setRowMargin(10);
        jTable1.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Thông Tin Phiếu Nhập");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Mã Phiếu Nhập: ");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Tên Nhà Cung Cấp:");

        lbMaPhieuNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbMaPhieuNhap.setForeground(new java.awt.Color(204, 0, 0));
        lbMaPhieuNhap.setText("lbMaPhieuNhap");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Ngày Nhập: ");

        lbNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNhaCungCap.setForeground(new java.awt.Color(204, 0, 0));
        lbNhaCungCap.setText("lbTenNhaCungCap");

        lbNgayNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNgayNhap.setForeground(new java.awt.Color(204, 0, 0));
        lbNgayNhap.setText("jLabel4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(lbNgayNhap))
                    .addComponent(lbMaPhieuNhap)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbNhaCungCap)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel3)))
                .addContainerGap(267, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaPhieuNhap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbNhaCungCap)
                    .addComponent(jLabel3)
                    .addComponent(lbNgayNhap))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/icon_print2.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnHoanThanh.setBackground(new java.awt.Color(0, 204, 0));
        btnHoanThanh.setText("Hoàn Thành");
        btnHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(204, 0, 0));
        btnHuy.setText("Hủy Phiếu");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHoanThanh)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(163, 163, 163)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHuy)
                    .addComponent(btnHoanThanh))
                .addGap(19, 19, 19))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrintPanel print = new PrintPanel();
        print.printRecord(jPanel1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhActionPerformed
     
       Boolean flag = qlpn.UpdateTrangThai(Mapn,"Hoàn Thành");  
       if(flag==true)
       {
           JOptionPane.showMessageDialog(null,"Đã Chỉnh Sủa thành công");
          dialog.dispose();
          a.SetDefautlTable("",trangthai);
       }
// TODO add your handling code here:
    }//GEN-LAST:event_btnHoanThanhActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
   
               Boolean flag = qlpn.UpdateTrangThai(Mapn,"Đã Hủy");  
       if(flag==true)
       {
           JOptionPane.showMessageDialog(null,"Đã Chỉnh Sủa thành công");
          dialog.dispose();
                    a.SetDefautlTable("",trangthai);

       }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoanThanh;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbMaPhieuNhap;
    private javax.swing.JLabel lbNgayNhap;
    private javax.swing.JLabel lbNhaCungCap;
    // End of variables declaration//GEN-END:variables
}
