/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.ThongKeBaoCaoComponent;

import Smartphone_sales_management.BUS.ThongKeBaoCaoBanHang_BUS;
import Smartphone_sales_management.BUS.ThongKeBaoCaoNhapHang_BUS;
import Smartphone_sales_management.UI.Event.ThongKe.AddXemChiTiet;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Vuong
 */
public class TableChiPhiNhapHang extends javax.swing.JPanel {

    /**
     * Creates new form TableChiPhiNhapHang
     */
    AddXemChiTiet event;
    ThongKeBaoCaoNhapHang_BUS tkbc = new ThongKeBaoCaoNhapHang_BUS();
    DefaultTableModel model;
    private String type;
    private String hinhthuc;

    private Date datetart;
    private Date dateEnd;

    public TableChiPhiNhapHang(String type, String hinhthuc) {
        initComponents();
        this.type = type;
        this.hinhthuc = hinhthuc;
        SetDefautlTable();
        TableColumnModel columnModel = jTable1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(5);
        columnModel.getColumn(1).setPreferredWidth(5);

    }

    public TableChiPhiNhapHang(String type, String hinhthuc, Date dateStart, Date dateEnd) {
        initComponents();
        this.type = type;
        this.hinhthuc = hinhthuc;
        this.dateEnd = dateEnd;
        this.datetart = dateStart;
//        SetDefautlTable();
//        jTable1.setColumnSelectionAllowed(true);
    }

    public void init(String type, String hinhthuc, Date dateStart, Date dateEnd) {
        this.type = type;
        this.hinhthuc = hinhthuc;
        this.dateEnd = dateEnd;
        this.datetart = dateStart;
        SetDefautlTable();

    }

    public void init(String type, String hinhthuc) {
        this.type = type;
        this.hinhthuc = hinhthuc;
        SetDefautlTable();

    }

    public void addXemChiTiet(AddXemChiTiet event) {
        this.event = event;

        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = jTable1.getSelectedRow();
                event.Ngayban(String.valueOf(jTable1.getValueAt(i, 1)));
            }
        ;
    }

    );
    } 
       
      public void SetDefautlTable() {
        jTable1.removeAll();
        model = new DefaultTableModel();
        if (hinhthuc.equals("Hàng Hóa")) {
            this.model.addColumn("STT");
            model.addColumn("Mã Hàng");
            model.addColumn("Tên Hàng");
            model.addColumn("Số Lần Nhập");
            model.addColumn("Số Lượng");
            model.addColumn("Tổng Tiền");
            model.addColumn("Đơn Vị Tiền");
//            model.addColumn("Số Lượng còn");
        }
        if (hinhthuc.equals("Nhà Cung Cấp")) {
            this.model.addColumn("STT");
            model.addColumn("Mã Nhà Cung Cấp");
            model.addColumn("Tên Nhà Cung Cấp");
            model.addColumn("Số phiếu");
            model.addColumn("Số Lượng");
            model.addColumn("Tồng tiền");
            model.addColumn("Đơn Vị Tiền");

        }
        if (hinhthuc.equals("Ngày Nhập")) {
            model.addColumn("STT");
            model.addColumn("Ngày Nhập");
            model.addColumn("Số Phiếu Nhập");
            model.addColumn("Số Lượng");
            model.addColumn("Tổng Tiền");
            model.addColumn("Đơn Vị Tiền");

//            model.addColumn("Số Lượng còn");
        }
        jTable1.setOpaque(false);
        jTable1.getTableHeader().getColumnModel().setColumnMargin(1);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 17) {
        });
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setBackground(new Color(14, 14, 14));
//        jTable1.s  (jTable1.getWidth(), new double[]{0.5, 1, 1, 1, 2, 1, 2, 2, 2});

//  Lấy dữ liệu theo hình thức và type sau đó add dữ liệu vào bảng
        ArrayList dataList = new ArrayList<>();
        if (hinhthuc.equals("Hàng Hóa")) {
            dataList = tkbc.getThongKeBaoCaoNhapHang(type, hinhthuc);
        } else if (hinhthuc.equals("Nhà Cung Cấp")) {
            dataList = tkbc.getThongKeBaoCaoNhapHang(type, hinhthuc);
        } else {
            dataList = tkbc.getThongKeBaoCaoNhapHang_NgayBan(datetart, dateEnd);

        }
        System.out.println(dataList.size() + "sdfaf");
        for (int i = 0; i < dataList.size(); i++) {
            model.addRow((Vector<?>) dataList.get(i));
        }
        jTable1.setModel(model);
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
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    JTable getTable() {
        return jTable1;

    }
}
