/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.NhanVienComponent;
import Smartphone_sales_management.BUS.QuanLyNhanVien_BUS;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import Smartphone_sales_management.KHONGCHONHAPCHU;
import Smartphone_sales_management.UI.Model.Model_NhanVien;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
/**
 *
 * @author lehongthai
 */
public class TableThemNV extends javax.swing.JPanel {
    TableNhanVien tbnhanvien;
    /**
     * Creates new form TableThemNV
     */
    public TableThemNV(TableNhanVien tbnhanvien) {
        this.tbnhanvien = tbnhanvien;
        initComponents();
        setDocument();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jtTen = new javax.swing.JTextField();
        jlTenNhanVien = new javax.swing.JLabel();
        jbTuoi = new javax.swing.JLabel();
        jtTuoi = new javax.swing.JTextField();
        jbSocccd = new javax.swing.JLabel();
        jtcccd = new javax.swing.JTextField();
        jbChucDanh = new javax.swing.JLabel();
        jtChucdanh = new javax.swing.JTextField();
        jbthemnv = new javax.swing.JButton();
        jLabelDiaChi = new javax.swing.JLabel();
        jTextDiaChi = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM NHÂN VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jlTenNhanVien.setText("Tên nhân viên");

        jbTuoi.setText("Tuổi");

        jtTuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTuoiActionPerformed(evt);
            }
        });

        jbSocccd.setText("Số CCCD");

        jbChucDanh.setText("Chức danh");

        jtChucdanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtChucdanhActionPerformed(evt);
            }
        });

        jbthemnv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/NhanVien.png"))); // NOI18N
        jbthemnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbthemnvActionPerformed(evt);
            }
        });

        jLabelDiaChi.setText("Điạ Chỉ");

        jTextDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDiaChiActionPerformed(evt);
            }
        });

        jButtonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Refresh.png"))); // NOI18N

        jButtonXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Delete.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSocccd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbTuoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlTenNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(jbChucDanh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jtTen))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(42, 42, 42)
                                .addComponent(jbthemnv)
                                .addGap(43, 43, 43)
                                .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88))
                            .addComponent(jtChucdanh, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtcccd)
                            .addComponent(jtTuoi)
                            .addComponent(jTextDiaChi))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jlTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSocccd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtcccd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbChucDanh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtChucdanh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbthemnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbthemnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbthemnvActionPerformed
        String ten = jtTen.getText();
        String tuoi = jtTuoi.getText();
        String Socccd = jtcccd.getText();
        String diachi = jTextDiaChi.getText();
        String chucdanh = jtChucdanh.getText();
        
        if(ten.length() == 0){
            JOptionPane.showMessageDialog(jtTen,"Bạn chưa nhập tên nhân viên");
            return;
        }
        if(ten.length()> 50){
            JOptionPane.showMessageDialog(jtTen,"Bạn nhập sai thông tin nhân viên");
            return;
        }
        
        if(tuoi.length() == 0){
            JOptionPane.showMessageDialog(jtTuoi,"Bạn chưa nhập tuổi nhân viên");
            return;
        }
        if( Integer.parseInt(tuoi) < 0){
            JOptionPane.showMessageDialog(jtTuoi,"Bạn cần nhập lại tuổi");
        }
         if( Integer.parseInt(tuoi) > 110){
            JOptionPane.showMessageDialog(jtTuoi,"Bạn cần nhập lại tuổi");
        }
        if(Socccd.length() == 0){
            JOptionPane.showMessageDialog(jtcccd,"Bạn chưa nhập số CCCD");
            return;
        }
        if(Socccd.length()>13){
            JOptionPane.showMessageDialog(jtcccd,"bạn cần nhập lại cccd ");
            return;
        }
        if(diachi.length() == 0){
            JOptionPane.showMessageDialog(jTextDiaChi,"Bạn chưa nhập địa chỉ");
            return;
        }
         if(diachi.length()>= 50){
            JOptionPane.showMessageDialog(jTextDiaChi,"Bạn nhập sai thông tin diachi");

        }
        if(chucdanh.length() == 0){
            JOptionPane.showMessageDialog(jtChucdanh,"Bạn chưa nhập chức danh");
        }
         if(chucdanh.length()>= 50){
            JOptionPane.showMessageDialog(jtChucdanh,"Bạn nhập sai thông tin chuc danh");

        }
           QuanLyNhanVien_BUS qlnv = new QuanLyNhanVien_BUS();
           
         Model_NhanVien NhanVien = new Model_NhanVien();
         NhanVien.setTenNV(ten);
         NhanVien.setTuoi(Integer.parseInt(tuoi));
         NhanVien.setSoCCCD(Integer.parseInt(Socccd));
         NhanVien.setDiaChi(diachi);
         NhanVien.setChucDanh(chucdanh);
         NhanVien.setTrangThai("T");
         NhanVien.setMaNV(qlnv.getSoTTMANV());
       
         qlnv.AddNhanVien(NhanVien);
         tbnhanvien.SetDefaultTable("");
        
     
        
    }//GEN-LAST:event_jbthemnvActionPerformed
    
    private void jtTuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTuoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTuoiActionPerformed

    private void jTextDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDiaChiActionPerformed

    private void jtChucdanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtChucdanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtChucdanhActionPerformed
    private void setDocument(){
        AbstractDocument jtcd = (AbstractDocument)jtcccd.getDocument();
        jtcd.setDocumentFilter(new KHONGCHONHAPCHU());
         AbstractDocument jtTuoinv = (AbstractDocument)jtTuoi.getDocument();
        jtTuoinv.setDocumentFilter(new KHONGCHONHAPCHU());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDiaChi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextDiaChi;
    private javax.swing.JLabel jbChucDanh;
    private javax.swing.JLabel jbSocccd;
    private javax.swing.JLabel jbTuoi;
    private javax.swing.JButton jbthemnv;
    private javax.swing.JLabel jlTenNhanVien;
    private javax.swing.JTextField jtChucdanh;
    private javax.swing.JTextField jtTen;
    private javax.swing.JTextField jtTuoi;
    private javax.swing.JTextField jtcccd;
    // End of variables declaration//GEN-END:variables
}
