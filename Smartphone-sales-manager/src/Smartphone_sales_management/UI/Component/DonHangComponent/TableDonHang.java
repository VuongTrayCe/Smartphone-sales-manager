/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.DonHangComponent;

import Smartphone_sales_management.BUS.QuanLyDonHang_BUS;
import Smartphone_sales_management.UI.Event.DonHang.EventDonHang;
import Smartphone_sales_management.UI.Event.DonHang.EventDonHang2;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Admin
 */
public class TableDonHang extends javax.swing.JPanel {

    QuanLyDonHang_BUS qldh_BUS = new QuanLyDonHang_BUS();
    DefaultTableModel model = new DefaultTableModel();
    private String keyWord;
    String tenTrangThai;
    Date dateStart;
    Date dateEnd;

    public TableDonHang(String keyWord, String tenTrangThai, Date start, Date end) throws ParseException {
        initComponents();
        this.keyWord = keyWord;
        this.tenTrangThai = tenTrangThai;
        this.dateStart = start;
        this.dateEnd = end;
        model.addColumn("Mã Đơn Hàng");
        model.addColumn("Tên khách hàng");
        model.addColumn("Tên nhân viên");
        model.addColumn("Ngày bán");
        model.addColumn("Tổng số lượng");
        model.addColumn("Tổng tiền");
        model.addColumn("Điểm áp dụng");
        model.addColumn("Điểm thưởng");
        model.addColumn("Trạng thái");
        jTableDH.setOpaque(false);
        jTableDH.getTableHeader().getColumnModel().setColumnMargin(1);
        jTableDH.getTableHeader().setFont(new Font("Arial", Font.BOLD, 17));
        jTableDH.getTableHeader().setForeground(Color.WHITE);
        jTableDH.getTableHeader().setBackground(new Color(14, 14, 14));
        SetDefaultTable(keyWord, tenTrangThai, start, end);
        jTableDH.setModel(model);
        jTableDH.getColumnModel().getColumn(0).setMinWidth(120);
        jTableDH.getColumnModel().getColumn(1).setMinWidth(150);
        jTableDH.getColumnModel().getColumn(2).setMinWidth(150);
        jTableDH.getColumnModel().getColumn(3).setMinWidth(120);
        jTableDH.getColumnModel().getColumn(4).setMinWidth(150);
        jTableDH.getColumnModel().getColumn(5).setMinWidth(120);
        jTableDH.getColumnModel().getColumn(6).setMinWidth(120);
        jTableDH.getColumnModel().getColumn(7).setMinWidth(120);
        jTableDH.getColumnModel().getColumn(8).setMinWidth(120);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTableDH.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        jTableDH.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        jTableDH.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        jTableDH.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        jTableDH.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        jTableDH.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);
        jTableDH.getColumnModel().getColumn(6).setCellRenderer(cellRenderer);
        jTableDH.getColumnModel().getColumn(7).setCellRenderer(cellRenderer);
        jTableDH.getColumnModel().getColumn(8).setCellRenderer(cellRenderer);
    }

    public void addEventDonHang(EventDonHang event, EventDonHang2 event2) {
//        event.SelectedInxex(0,);
        jTableDH.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    event.SelectedInxex((int) jTableDH.getValueAt(jTableDH.getSelectedRow(), 0));
                } else {
                    event2.maDH((int) jTableDH.getValueAt(jTableDH.getSelectedRow(), 0));
                }
            }
        ;
    }

    );
    }
    
   
    public void SetDefaultTable(String keyWord, String tenTrangThai, Date start, Date end) throws ParseException {
        jTableDH.removeAll();
        model.setRowCount(0);
        ArrayList dataList = new ArrayList();
        dataList = qldh_BUS.layDanhSachDonHang(keyWord, tenTrangThai, start, end);
        for (int i = 0; i < dataList.size(); i++) {
            model.addRow((Vector<?>) dataList.get(i));
        }
        JscrollDH.repaint();

    }

//    public void SetDefaultTableTheoNgay(String keyWord, String tenTrangThai,Date dateStart, Date dateEnd){
//        jTable1.removeAll();
//        model.setRowCount(0);
//        ArrayList dataList = new ArrayList();
//        dataList = qldh_BUS.layDanhSachDonHangTheoNgay(keyWord,tenTrangThai,dateStart,dateEnd);
//        for (int i = 0; i < dataList.size(); i++) {
//            model.addRow((Vector<?>) dataList.get(i));
//        }
//        jScrollPane1.repaint();
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JscrollDH = new javax.swing.JScrollPane();
        jTableDH = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(431, 308));

        JscrollDH.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jTableDH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableDH.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTableDH.setAutoResizeMode(0);
        jTableDH.setFocusable(false);
        jTableDH.setGridColor(new java.awt.Color(255, 255, 255));
        jTableDH.setRowHeight(35);
        jTableDH.setSelectionBackground(new java.awt.Color(255, 0, 51));
        jTableDH.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableDH.setShowGrid(true);
        JscrollDH.setViewportView(jTableDH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JscrollDH)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JscrollDH)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JscrollDH;
    private javax.swing.JTable jTableDH;
    // End of variables declaration//GEN-END:variables

}
