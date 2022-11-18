/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.PhieuNhap;

import Smartphone_sales_management.BUS.QuanLyBanHang_BUS;
import Smartphone_sales_management.BUS.QuanLyPhieuNhap_BUS;
import Smartphone_sales_management.UI.Event.BanHang.EventBanHang;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vuong
 */
public class TablePhieuNhap extends javax.swing.JPanel {

    /**
     * Creates new form TablePhieuNhap
     */
    QuanLyPhieuNhap_BUS qlpn = new QuanLyPhieuNhap_BUS();
    DefaultTableModel model = new DefaultTableModel();
    EventBanHang event;

    public TablePhieuNhap() {
        initComponents();
        model.addColumn("STT");
        model.addColumn("Maphieunhap");
        model.addColumn("NgayNhap");
        model.addColumn("Nhacungcap");
        model.addColumn("SoLuong");
        model.addColumn("TongTien");
        jTable1.setOpaque(false);
        jTable1.getTableHeader().getColumnModel().setColumnMargin(1);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 17) {
        });
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setBackground(new Color(14, 14, 14));
        SetDefautlTable("");
        jTable1.setModel(model);
    }

    public void SetDefautlTable(String keyWord) {

        jTable1.removeAll();
        model.setRowCount(0);
        ArrayList dataList = new ArrayList<>();
        dataList = qlpn.getDanhSachPhieuNhap(keyWord);
        for (int i = 0; i < dataList.size(); i++) {
            model.addRow((Vector<?>) dataList.get(i));
        }
        jScrollPane1.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
