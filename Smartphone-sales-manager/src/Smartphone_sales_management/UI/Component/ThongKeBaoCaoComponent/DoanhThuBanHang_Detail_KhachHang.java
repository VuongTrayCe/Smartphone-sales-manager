/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.ThongKeBaoCaoComponent;

import Smartphone_sales_management.BUS.ThongKeBaoCaoBanHang_BUS;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vuong
 */
public class DoanhThuBanHang_Detail_KhachHang extends javax.swing.JPanel {

    /**
     * Creates new form DoanhThuBanHang_Detail_KhachHang
     */
     ThongKeBaoCaoBanHang_BUS tkbc = new ThongKeBaoCaoBanHang_BUS();

    DefaultTableModel model;
    private String makh;
     JDialog inforDonHang;
    public DoanhThuBanHang_Detail_KhachHang(String makh) {
        initComponents();
        this.makh=makh;
        System.out.println(makh);
        SetDefautlTable();
    }
    public void SetDefautlTable() {
//        JTable.removeAll();
        model  = new DefaultTableModel();
        model.setRowCount(0);
        this.model.addColumn("STT");
        model.addColumn("Mã Đơn");
        model.addColumn("Ngày bán");

        model.addColumn("Số Lượng");
        model.addColumn("Số điểm");
        model.addColumn("Tổng Tiền");
        jTable1.setOpaque(false);
        jTable1.getTableHeader().getColumnModel().setColumnMargin(1);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 17) {
        });
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setBackground(new Color(14, 14, 14));
        ArrayList dataList = new ArrayList<>();
        dataList = tkbc.getThongKeBaoCaoBanHang_Detail_KhachHang(Integer.parseInt(makh));

//            Logger.getLogger(TableBanHang_TheoHangHoa.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println(hinhthuc);
        for (int i = 0; i < dataList.size(); i++) {
            model.addRow((Vector<?>) dataList.get(i));
        }
        jScrollPane1.repaint();
        jTable1.setModel(model);
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
