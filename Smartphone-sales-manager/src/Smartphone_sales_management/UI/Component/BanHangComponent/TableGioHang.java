/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.BanHangComponent;

import Smartphone_sales_management.BUS.QuanLyBanHang_BUS;
import Smartphone_sales_management.UI.Main.MainFrame;
import Smartphone_sales_management.UI.Model.Model_GioHang;
import com.mysql.cj.protocol.Message;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Vuong
 */
public class TableGioHang extends javax.swing.JPanel {

    /**
     * Creates new form TableGioHang
     */
    public static int selectedIndexGioHang;
    QuanLyBanHang_BUS qlbh_bus = new QuanLyBanHang_BUS();
    ArrayList data = new ArrayList();
    JLabel sl;
    MainFrame frame;
    public TableGioHang(ArrayList data, JLabel SL,MainFrame mainFrame) {
        this.sl = SL;
        this.data = data;
        initComponents();
        Double sum = 0.0;
        this.frame = mainFrame;
        for (Object object : data) {
            listGioHang1.addItem((Model_GioHang) object);
            Model_GioHang x = (Model_GioHang) object;
            sum += x.getTongTien();
            lbTongTien.setText(Double.toString(sum) + " VND");
            jButton1.setBorder(null);
            jButton1.setBackground(new Color(242, 242, 242));
        }

        listGioHang1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedIndexGioHang = listGioHang1.getSelectedIndex();
                listGioHang1.repaint();
            }
        });
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
        listGioHang1 = new Smartphone_sales_management.UI.Swing.GioHang.ListGioHang<>();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 255, 153));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        setPreferredSize(new java.awt.Dimension(354, 414));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(258, 414));

        listGioHang1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(listGioHang1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Delete2.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setBorder(null);
        jButton2.setLabel("Tạo Hóa Đơn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tổng tiền: ");

        lbTongTien.setText("0.000");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "One", "ALL" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31))
                    .addComponent(lbTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jComboBox1, 0, 68, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTongTien))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // xử lý chọn nút để xóa một sản phẩm
        if (selectedIndexGioHang != -1) {
            int indexDelete = selectedIndexGioHang;
            if (jComboBox1.getSelectedIndex() == 0) {
                Model_GioHang x = (Model_GioHang) this.data.get(selectedIndexGioHang);
                x.setSoluong(x.getSoluong() - 1);
                if (x.getSoluong() == 0) {

                    ((DefaultListModel) listGioHang1.getModel()).remove(selectedIndexGioHang);
                    this.data.remove(indexDelete);
                    this.sl.setText(Integer.toString(data.size()));
                    lbTongTien.setText("0.00" + " VND");

                }

                listGioHang1.repaint();

                int sum = 0;
                for (Object object : data) {

                    Model_GioHang model = (Model_GioHang) object;
                    sum += model.getTongTien();
                    lbTongTien.setText(Double.toString(sum) + " VND");

                }

            } else {
                ((DefaultListModel) listGioHang1.getModel()).remove(selectedIndexGioHang);
                this.data.remove(indexDelete);
                this.sl.setText(Integer.toString(data.size()));

                listGioHang1.repaint();
                int sum = 0;
                if(this.data.size()==0)
                {
                   lbTongTien.setText("0.00 "+ "VND");

                }
                else
                {
                for (Object object : data) {

                    Model_GioHang model = (Model_GioHang) object;
                    sum += model.getTongTien();
                    lbTongTien.setText(Double.toString(sum) + " VND");

                }
                }
            }

        } else {
            if (data.size() == 0) {
                JOptionPane.showMessageDialog(null, "Không có sản phẩm nào để xóa");

            } else {

                JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần xóa ");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(this.data.size()==0)
      {
         JOptionPane.showMessageDialog(null, "Chưa có sản phẩm cần tạo");

      }
      else
      {
//        frame.setVisible(false);
        Window win = SwingUtilities.getWindowAncestor(this);
                JDialog inforDonHang= new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
//        changePwdDialog.setUndecorated(true);
          ThongTinDonHang donhang = new ThongTinDonHang(data,this,inforDonHang);
          inforDonHang.setSize(850,470);
            inforDonHang.setLayout(new GridLayout());
            inforDonHang.setTitle("Thông tin đơn hàng");
            inforDonHang.add(donhang);
            donhang.validate();
          inforDonHang.setLocationRelativeTo(null);
                    inforDonHang.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            inforDonHang.setVisible(true);

      }
             


// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTongTien;
    private Smartphone_sales_management.UI.Swing.GioHang.ListGioHang<String> listGioHang1;
    // End of variables declaration//GEN-END:variables
}
