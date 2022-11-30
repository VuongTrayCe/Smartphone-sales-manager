/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.TaiKhoan2;

import Smartphone_sales_management.UI.Component.TaiKhoanComponent.*;
import Smartphone_sales_management.BUS.QuanLyQuyen_BUS;
import Smartphone_sales_management.DAO.QuanLyQuyen_DAO;
import Smartphone_sales_management.UI.Component.BanHangComponent.AddKhachHang;
import Smartphone_sales_management.UI.Component.TaiKhoanComponent.MainConTentTaiKhoan;
import Smartphone_sales_management.UI.Event.Quyen.EvenQuyen;
import Smartphone_sales_management.UI.Main.MainFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.text.TabableView;

/**
 *
 * @author Dell
 */
public class FormQuanLyQuyenTK extends javax.swing.JPanel {

    QuanLyQuyen_BUS qlq = new QuanLyQuyen_BUS();
    QuanLyQuyen_DAO a = new QuanLyQuyen_DAO();
    JFrame frame;
    EvenQuyen event;
    DefaultTableModel model = new DefaultTableModel();
    ArrayList dataChitietTK = null;
    ArrayList data = new ArrayList();
    int Matk = -1;
    FormQuanLyQuyenTK_ThemQuyen fromaddquyen;

    /**
     * Creates new form FromQuyen
     */
    public FormQuanLyQuyenTK() {
        initComponents();
        this.frame = frame;
        model.addColumn("STT");
        model.addColumn("Mã Quyền Tài Khoản");
        model.addColumn("Mã Tài Khoản");
        model.addColumn("Mã Nhân Viên");
        model.addColumn("Tên Nhân Viên");
        model.addColumn("Tên Quyền");
        TabbleThongTin.setOpaque(false);
        TabbleThongTin.getTableHeader().getColumnModel().setColumnMargin(1);
        TabbleThongTin.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 17) {
        });
        TabbleThongTin.getTableHeader().setForeground(Color.WHITE);
        TabbleThongTin.getTableHeader().setBackground(new Color(14, 14, 14));
        TabbleThongTin.setModel(model);
        setDefautlQuyen();
        timkiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {

                setDefautlQuyen();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setDefautlQuyen();

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                setDefautlQuyen();

            }
        });
    }

//    public void addEventTaiKhoan(EvenQuyen event) {
//        TabbleThongTin.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
////                event.selectedIndex(jTable1.getSelectedRow());
//                event.SelectedInxex((int) TabbleThongTin.getValueAt(TabbleThongTin.getSelectedRow(), 0));
//                
//            }
//
//            
//        }
//        );
//
//    }
    public void setDefautlQuyen() {

        TabbleThongTin.removeAll();
        model.setRowCount(0);
        ArrayList dataList = new ArrayList<>();
        dataList = qlq.layDanhSachQuyen2(timkiem.getText());
        for (int i = 0; i < dataList.size(); i++) {
            model.addRow((Vector<?>) dataList.get(i));
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

        jPanel1 = new javax.swing.JPanel();
        timkiem = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabbleThongTin = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1093, 500));

        timkiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setText("DANH SÁCH PHÂN QUYỀN");

        TabbleThongTin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TabbleThongTin.setRowHeight(35);
        TabbleThongTin.setSelectionBackground(new java.awt.Color(204, 0, 0));
        TabbleThongTin.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(TabbleThongTin);

        btnThem.setBackground(new java.awt.Color(0, 0, 0));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm quyền");
        btnThem.setBorder(null);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/search.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Xóa Quyền");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Quản Lý Quyền");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(timkiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(61, 61, 61)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timkiem, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timkiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        Window win = SwingUtilities.getWindowAncestor(this);
        JDialog inforDonHang = new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
        FormQuanLyQuyenTK_ThemQuyen a = new FormQuanLyQuyenTK_ThemQuyen(FormQuanLyQuyenTK.this, inforDonHang);
//        changePwdDialog.setUndecorated(true);
//          ThongTinDonHang donhang = new ThongTinDonHang(data,this,inforDonHang);
//        AddKhachHang themkhachhang = new AddKhachHang(inforDonHang, this);
        inforDonHang.setSize(480, 340);
        inforDonHang.setLayout(new GridLayout());
        inforDonHang.setTitle("Thêm Quyền Tài Khoản");
        inforDonHang.add(a);
        a.validate();
        inforDonHang.setLocationRelativeTo(null);
        inforDonHang.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        inforDonHang.setVisible(true);

//        changePwdDialog.setUndecorated(true);
//          ThongTinDonHang donhang = new ThongTinDonHang(data,this,inforDonHang);

    }//GEN-LAST:event_btnThemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int indexRowSelected = TabbleThongTin.getSelectedRow();
        if (TabbleThongTin.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Quyền Cần Xóa");
        } else {
            int a = JOptionPane.showConfirmDialog(null, "Bạn muốn Xóa Không?", "Xóa Quyền ", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {

                int maquyentk = (int) TabbleThongTin.getValueAt(indexRowSelected, 1);
                qlq.DeleteQuyenTaiKhoan(maquyentk);
                setDefautlQuyen();
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     
        
        Window win = SwingUtilities.getWindowAncestor(this);
        JDialog inforDonHang = new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
        FormQuanLyQuyen a =new FormQuanLyQuyen();
        inforDonHang.setSize(680, 400);
        inforDonHang.setLayout(new GridLayout());
        inforDonHang.setTitle("Quản Lý Quyền");
        inforDonHang.add(a);
        a.validate();
        inforDonHang.setLocationRelativeTo(null);
//        inforDonHang.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        inforDonHang.setVisible(true);

        


// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabbleThongTin;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField timkiem;
    // End of variables declaration//GEN-END:variables
}