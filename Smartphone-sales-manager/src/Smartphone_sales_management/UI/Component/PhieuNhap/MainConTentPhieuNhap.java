/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.PhieuNhap;

import Smartphone_sales_management.UI.Component.BanHangComponent.*;
import Smartphone_sales_management.UI.Component.BanHangComponent.TableBanHang;
import Smartphone_sales_management.UI.Component.BanHangComponent.TableDetailBH;
import Smartphone_sales_management.UI.Event.BanHang.EventBanHang;
import Smartphone_sales_management.UI.Main.MainFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.event.DocumentEvent;
import java.awt.LayoutManager;
import static Smartphone_sales_management.UI.Component.BanHangComponent.TableDetailBH.selectedIndex;
import Smartphone_sales_management.UI.Event.BanHang.AddGioHang;
import Smartphone_sales_management.UI.Model.Model_GioHang;
import java.util.ArrayList;
import javax.swing.event.DocumentListener;
import static Smartphone_sales_management.UI.Component.BanHangComponent.TableGioHang.selectedIndexGioHang;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Vuong
 */
public class MainConTentPhieuNhap extends javax.swing.JPanel {

    /**
     * Creates new form TestPanel
     */
    EventBanHang event;
    MainFrame frame;
    AddGioHang eventGioHang;
    ArrayList<Object> arrListSanpham = new ArrayList<>();

    TableDetailBH c;
    TableGioHang b ;
    public MainConTentPhieuNhap(MainFrame frame) {
        initComponents();
        this.frame = frame;
 
//        TableDetailBH c = new TableDetailBH(index);
//
//        TableBanHang a = new TableBanHang(event);
//         b = new TableGioHang(arrListSanpham,IconGioHang,frame);
//        a.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
//        b.setBounds(0, 0, jPanel2.getWidth(), jPanel2.getHeight());
//
//        jScrollPane1.setViewportView(a);
////        jPanel2.setLayout(new GridLayout());
//        IconGioHang.setText(Integer.toString(arrListSanpham.size()));
//
////        jPanel2.add(b);
////        b.validate();
//        // Hiển thị bảng chi tiết khi click sản phẩm từ bảng
//        a.addEventBanHang(new EventBanHang() {
//            @Override
//            public int SelectedInxex(int index) {
//                c = new TableDetailBH(index,frame);
//                c.setBounds(0, 0, jPanel2.getWidth(), jPanel2.getHeight());
//                jPanel2.removeAll();
////                TableDetailBH b = new TableDetailBH(event);
////                b.setMinimumSize(new Dimension(100,100));
////                b.setMaximumSize(new Dimension(jPanel2.getWidth(),jPanel2.getHeight()));
//
//                jPanel2.setLayout(new GridLayout());
//                jPanel2.add(c);
//                c.validate();
//                
//                 IconGioHang.setBackground(new Color(153, 153, 153));
//                 IconDetail.setBackground(Color.red);
//                // Bắt sự kiện nút thêm vào giỏ
//                c.addSanPhamVaoGio(new AddGioHang() {
//                    @Override
//                    public void addGiohang(Model_GioHang data) {
//                        ArrayList a = new ArrayList<>();
//                        ArrayList arr = new ArrayList<>();
//                        a = arrListSanpham;
//                        boolean flag = false;
//                        for (Object object : a) {
//                            Model_GioHang x = (Model_GioHang) object;
//                            if (x.getName().equals(data.getName())) {
//                                flag = true;
//                                x.setSoluong(x.getSoluong() + data.getSoluong());
//                            }
//                            
//                            arr.add(x);
//
//                        }
//                        if (flag == true) {
//                            arrListSanpham = arr;
//                        } else {
//                            arrListSanpham.add(data);
//                        }
////                       
//                        IconGioHang.setText(Integer.toString(arrListSanpham.size()));
//                    }
//
//                });
//
//                return index;
//            }
//        });
//
//        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//
//                a.SetDefautlTable(txtTimKiem.getText());
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                a.SetDefautlTable(txtTimKiem.getText());
//
//            }
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                a.SetDefautlTable(txtTimKiem.getText());
//
//            }
//        });

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
        txtTimKiem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setPreferredSize(new java.awt.Dimension(1030, 530));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(1030, 530));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        txtTimKiem.setText("Nhập từ khóa tìm kiếm");
        txtTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseClicked(evt);
            }
        });
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(147, 147, 147)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addGap(9, 9, 9))
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

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    public void DisPlayComponent(Component a) {
//        a.setBounds(0, 0, jPanel2.getWidth(), jPanel2.getHeight());
//        jPanel2.removeAll();
//        jPanel2.setLayout(new GridLayout());
//        jPanel2.add(a);
//        a.validate();
//        jPanel2.repaint();
    }
    private void txtTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
