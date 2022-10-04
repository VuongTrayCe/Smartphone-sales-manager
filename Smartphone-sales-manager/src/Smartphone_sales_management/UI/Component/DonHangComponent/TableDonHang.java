/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.DonHangComponent;

import Smartphone_sales_management.BUS.QuanLyDonHang_BUS;
import Smartphone_sales_management.UI.Event.DonHang.EventDonHang;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class TableDonHang extends javax.swing.JPanel {

    QuanLyDonHang_BUS qldh_BUS = new QuanLyDonHang_BUS();
    DefaultTableModel model = new DefaultTableModel();
    EventDonHang event;

    public TableDonHang() {
        initComponents();
        model.addColumn("MaDH");
        model.addColumn("MaKH");
        model.addColumn("MaNV");
        model.addColumn("NgayBan");
        model.addColumn("TongSoLuong");
        model.addColumn("TongTien");
        model.addColumn("TrangThai");
        jTable1.setOpaque(false);
        jTable1.getTableHeader().getColumnModel().setColumnMargin(1);
        jTable1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 17));
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setBackground(new Color(14, 14, 14));

        SetDefaultTable("");
        jTable1.setModel(model);

    }

    public void addEventDonHang(EventDonHang event) {
        this.event = event;
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                event.SelectedInxex(jTable1.getSelectedRow());
            }
        ;
    }

    );
    }
    public void SetDefaultTable(String keyWord) {
        jTable1.removeAll();
        model.setRowCount(0);
        ArrayList dataList = new ArrayList();
        dataList = qldh_BUS.layDanhSachDonHang(keyWord);
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

        setPreferredSize(new java.awt.Dimension(431, 308));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(255, 0, 51));
        jTable1.setShowGrid(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
