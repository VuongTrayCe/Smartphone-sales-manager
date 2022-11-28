/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.PhieuNhap;

import Smartphone_sales_management.DTO.Model_DonHang;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.data.time.Day;

/**
 *
 * @author Admin
 */
public class PanelInHoaDon extends javax.swing.JPanel {

    /**
     * Creates new form PanelInHoaDon
     */
    ArrayList<Vector> dsct;
    ArrayList dataIn;
    String mapn;
    String tennhacungcap;
    String ngaynhap;
    String dulieudonhang = "";
    int i = 1;
    int tongtien = 0;
    JDialog inDialog;
    //y.get(1).toString() teen san pham
    //y.get(3).toString() so luong
    // y.get(10).toString() gia
    //y.get(7).toString() gia sau km
    // y.get(6).toString() tong gia

    public PanelInHoaDon(ArrayList dataIn, ArrayList dataChiTiet, JDialog inforDonHang) {
        initComponents();
        this.dsct = dataChiTiet;
        this.dataIn = dataIn;
        this.inDialog = inforDonHang;
        Vector y = (Vector) this.dataIn.get(0);
        String mapn = y.get(0).toString();
        String tenncc = y.get(1).toString();
        String ngaynhap = y.get(2).toString();
        this.mapn = mapn;
        this.tennhacungcap = tenncc;
        this.ngaynhap = ngaynhap;
        textReceipt.append("\t\t Phiếu Nhập Hàng \t"
                + "\n\n Tên Nhà Cung Cấp: \t" + tennhacungcap
                + "\n\n Ngày Bán: \t\t" + this.ngaynhap
                +"\n\n Danh Sách Sản Phẩm Nhập:"
                + "\n=============================================================================================\n");
        for (int i = 0; i < dsct.size(); i++) {
            Vector y1 = (Vector<?>) dsct.get(i);

            String stt = "STT: " + String.valueOf(i) + "\n";
            String tenSp = "Tên sản phẩm: \t\t" + y1.get(2).toString() + "\n";
            String gia = "Giá nhập:  \t\t\t" + y1.get(3).toString() + "\n";
            String soluong = "Số Lượng:  \t\t\t" + y1.get(4).toString() + "\n";
            String tongGia = "Sub Total :\t\t\t" + y1.get(5).toString() + "\n";
            String underline = "\t=====================================\n";
            int tongtien1 = Integer.parseInt(y1.get(5).toString());

            String data = stt + tenSp + soluong + gia + tongGia + underline;
            dulieudonhang += data;
//            total += subtotal;
//            String tong = String.valueOf(total);
//            String tenKH = y.get(11).toString();
//            Date ngayBan = (Date) y.get(12);
//            ngaybandonhang = ngayBan.toString();
            this.tongtien += tongtien1;

        }
        textReceipt.append(
                dulieudonhang + "\n"
                + "Tổng tiền\t\t\t" + tongtien+" VND"
                + "\n\n================================= Cảm ơn quý khách! ===========================================\n");
//        +"\n\n\n\t\t==============  Cảm ơn quý khách! =============="
    var description= "Testing bold for part of a string";

    }

//    public PanelInHoaDon(ArrayList dsct,JFrame frame) {
//        initComponents();
//        this.frame = frame;
//        this.dsct = dsct;
//        for (Object x : dsct) {
//            Vector y = (Vector) x;
//            String Madh = y.get(0).toString();
//            Madonhang = Madh;
//            String stt = "STT\t" + String.valueOf(i) + "\n";
//            i++;
//            String tenSp = "Tên sản phẩm \t\t\t" + y.get(1).toString() + "\n";
//            String soluong = "Số lượng: \t\t\t" + y.get(3).toString() + "\n";
//            String gia = "Giá: \t\t\t" + y.get(10).toString() + "\n";
//            String giaSauKM = "Giá sau khuyến mãi: \t\t" + y.get(7).toString() + "\n";
//            String tongGia = "Sub Total :\t\t\t" + y.get(6).toString() + "\n";
//            Double subtotal = Double.parseDouble(y.get(6).toString());
//            String underline = "\t\t=====================================\n";
//            String data = stt + tenSp + soluong + gia + giaSauKM + tongGia + underline;
//            dulieudonhang += data;
//            total += subtotal;
//            String tong = String.valueOf(total);
//            String tenKH = y.get(11).toString();
//            Date ngayBan = (Date) y.get(12);
//            ngaybandonhang=ngayBan.toString();
//            tongtien = tong;
//            tenkhachhang=tenKH;
//        };
//        textReceipt.append("\t\t\t Hóa đơn \t" + Madonhang+
//                "\n Tên Khách Hàng: \t"+tenkhachhang+
//                "\n Ngày bán: \t\t"+ngaybandonhang
//                + "\n\n=============================================================================================\n"
//                + dulieudonhang + "\n"
//                + "Tổng tiền\t\t\t" + tongtien
//                + "\n\n\n\t\t==============  Cảm ơn quý khách! =============="
//        );
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textReceipt = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("In Phiếu Nhập");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(239, 239, 239))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 8));

        textReceipt.setColumns(20);
        textReceipt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textReceipt.setRows(5);
        jScrollPane2.setViewportView(textReceipt);

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/print.png"))); // NOI18N
        jButton1.setText("In Hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/back-icon.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Bạn muốn in phiếu nhập ?", "In phiếu nhập ", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == a) {
            try {
                textReceipt.print();
            } catch (PrinterException ex) {
                Logger.getLogger(PanelInHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát ?", "Thoát ", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            inDialog.dispose();
        }
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textReceipt;
    // End of variables declaration//GEN-END:variables
}
