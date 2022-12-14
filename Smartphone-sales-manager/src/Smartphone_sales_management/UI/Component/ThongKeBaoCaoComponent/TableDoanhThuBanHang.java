/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.ThongKeBaoCaoComponent;

import Smartphone_sales_management.BUS.QuanLyBanHang_BUS;
import Smartphone_sales_management.BUS.ThongKeBaoCaoBanHang_BUS;
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

/**
 *
 * @author Vuong
 */
public class TableDoanhThuBanHang extends javax.swing.JPanel {

    /**
     * Creates new form TableBanHang_TheoHangHoa
     */
    ThongKeBaoCaoBanHang_BUS tkbc = new ThongKeBaoCaoBanHang_BUS();

    DefaultTableModel model;
    private String type;
    private String hinhthuc;
    private Date datetart;
    private Date dateEnd;
    AddXemChiTiet event;

    public TableDoanhThuBanHang(String type, String hinhthuc) {
        initComponents();
        this.type = type;
        this.hinhthuc = hinhthuc;
        SetDefautlTable();
//        jTable1.setColumnSelectionAllowed(true);
    }

    public TableDoanhThuBanHang(String type, String hinhthuc, Date dateStart, Date dateEnd) {
        initComponents();
        this.type = type;
        this.hinhthuc = hinhthuc;
        this.dateEnd = dateEnd;
        this.datetart = dateStart;
        SetDefautlTable();
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
                if (hinhthuc.equals("Kh??ch H??ng")) {
                    event.Ngayban(String.valueOf(jTable1.getValueAt(i, 1)));

                } else {
                    event.Ngayban(String.valueOf(jTable1.getValueAt(i, 1)));

                }
            }
        ;
    }

    );
    }
    public void SetDefautlTable() {
        model = new DefaultTableModel();
        jTable1.removeAll();
        if (hinhthuc.equals("H??ng H??a")) {
            this.model.addColumn("STT");
            model.addColumn("M?? H??ng");
            model.addColumn("T??n H??ng");
            model.addColumn("S??? L?????ng");
            model.addColumn("T???ng Ti???n");
        }

        if (hinhthuc.equals("Kh??ch H??ng")) {
            this.model.addColumn("STT");
            model.addColumn("M?? Kh??ch H??ng");
            model.addColumn("T??n Kh??ch H??ng");
            model.addColumn("S??? ????n");
            model.addColumn("S??? L?????ng");
            model.addColumn("T???ng ti???n");

        }

        if (hinhthuc.equals("Ng??y B??n")) {
            this.model.addColumn("STT");
            model.addColumn("Ng??y B??n");
            model.addColumn("S??? ????n H??ng");
            model.addColumn("S??? L?????ng");
            model.addColumn("T???ng H??ng");
//             System.out.println(dateEnd.toString());
//             System.out.println(datetart.toString());
//             System.out.println(datetart.compareTo(dateEnd));

//            model.addColumn("S??? L?????ng c??n");
        }

        jTable1.setOpaque(false);
        jTable1.getTableHeader().getColumnModel().setColumnMargin(1);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 17) {
        });
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setBackground(new Color(14, 14, 14));
//        jTable1.s  (jTable1.getWidth(), new double[]{0.5, 1, 1, 1, 2, 1, 2, 2, 2});

//  L???y d??? li???u theo h??nh th???c v?? type sau ???? add d??? li???u v??o b???ng
        ArrayList dataList = new ArrayList<>();
        try {
            if (hinhthuc.equals("H??ng H??a") || hinhthuc.equals("Kh??ch H??ng")) {
                dataList = tkbc.getThongKeBaoCaoBanHang(type, hinhthuc);
            } else {
                dataList = tkbc.getThongKeBaoCaoBanHang(datetart, dateEnd);

            }
        } catch (ParseException ex) {
            Logger.getLogger(TableDoanhThuBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
//            System.out.println(hinhthuc);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
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

    private ArrayList getThongKeBaoCaoBanHang(String type, String hinhthuc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    JTable getTable() {
                return jTable1;

    }
}
