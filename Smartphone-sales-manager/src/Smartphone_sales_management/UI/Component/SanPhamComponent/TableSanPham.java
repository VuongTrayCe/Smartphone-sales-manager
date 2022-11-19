/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.SanPhamComponent;

import Smartphone_sales_management.BUS.QuanLiSanPham_BUS;
import Smartphone_sales_management.UI.Event.SanPham.EventSanPham;
import Smartphone_sales_management.UI.Event.SanPham.LayMasp;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JApplet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Admin
 */
public class TableSanPham extends javax.swing.JPanel {

    /**
     * Creates new form TableSanPham
     */
    QuanLiSanPham_BUS qlsp_BUS = new QuanLiSanPham_BUS();
    DefaultTableModel model = new DefaultTableModel();
    private String keyWord;
    private String tenTrangThai;

    public TableSanPham(String keyWord, String tenTrangThai) {
        initComponents();
        this.keyWord = keyWord;
        this.tenTrangThai = tenTrangThai;
        model.addColumn("MaSP");
        model.addColumn("TenSP");
        model.addColumn("LoaiSP");
        model.addColumn("GiaSP");
        model.addColumn("SoLuong");
        model.addColumn("TrangThai");
        jTable1.setOpaque(false);
        jTable1.getTableHeader().getColumnModel().setColumnMargin(1);
        jTable1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 17));
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setBackground(new Color(14, 14, 14));
        SetDefaultTable(keyWord, tenTrangThai);
        jTable1.setModel(model);
    }

    public void addEventSanPham(EventSanPham event) {
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                event.selectedIndex(jTable1.getSelectedRow());
                   event.selectedIndex((int) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
                   System.out.println((int) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            }
        ;
    }

    );
    }
    
    
//    public void layMasp(LayMasp event) {
//        jTable1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                int column = 0;
//                String valueCell = (String) jTable1.getValueAt(jTable1.getSelectedRow(), column);
//                System.out.println("Ma da den"+valueCell);
//                event.layMasp(Integer.parseInt(valueCell));
//            }
//        }
//        );
//    }

    public void SetDefaultTable(String keyWord, String tenTrangThai) {
        jTable1.removeAll();
        model.setRowCount(0);
        ArrayList dataList = new ArrayList();
        dataList = qlsp_BUS.layDanhSachSanPham(keyWord, tenTrangThai);
        for (int i = 0; i < dataList.size(); i++) {
            model.addRow((Vector<?>) dataList.get(i));
        }
        panelTable.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTable = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(35);
        jTable1.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setShowGrid(true);
        panelTable.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jTable1;
    private javax.swing.JScrollPane panelTable;
    // End of variables declaration//GEN-END:variables
}
