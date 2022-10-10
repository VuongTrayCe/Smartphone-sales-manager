/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.NhanVienComponent;

import Smartphone_sales_management.BUS.QuanLyNhanVien_BUS;
import Smartphone_sales_management.UI.Event.NhanVien.EventNhanVien;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener; 
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
/**
 *
 * @author lehongthai
 */
public class TableNhanVien extends javax.swing.JPanel {

    QuanLyNhanVien_BUS qlnv = new QuanLyNhanVien_BUS();
    DefaultTableModel model = new DefaultTableModel();
    EventNhanVien Event;
            
    public TableNhanVien(EventNhanVien Event) {
        
         initComponents();
         model.addColumn("MaNV");        
         model.addColumn("TenNV");
         model.addColumn("SoCCCD");
         model.addColumn("Tuoi");
         model.addColumn("DiaChi");        
         model.addColumn("ChucDanh");
         model.addColumn("TrangThai");
         jTable1.setOpaque(false);
        jTable1.getTableHeader().getColumnModel().setColumnMargin(1);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 17) {
        });
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setBackground(new Color(14, 14, 14));
        
        SetDefaultTable("");
        
        jTable1.setModel(model);
    }

//     public void addEventNhanVien(EventNhanVien event) {
//        this.event = event;
//        jTable1.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                event.SelectedInxex(jTable1.getSelectedRow());
//            }
//        ;
//    }
//
//    );
//    }
    public void SetDefaultTable(String keyWord) {
        jTable1.removeAll();
        model.setRowCount(0);
        ArrayList dataList = new ArrayList<>();
        dataList = qlnv.getDanhSachNhanVien(keyWord);
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

        setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBorder(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(255, 0, 51));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
