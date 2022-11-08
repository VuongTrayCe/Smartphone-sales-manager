/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.SanPhamComponent;

import Smartphone_sales_management.BUS.QuanLiSanPham_BUS;
import Smartphone_sales_management.UI.Event.SanPham.EventSanPham;
import Smartphone_sales_management.UI.Event.SanPham.LayMasp;
import Smartphone_sales_management.UI.Main.MainFrame;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Admin
 */
public class MainContentSanPham extends javax.swing.JPanel {

    /**
     * Creates new form SanPham
     */
    MainFrame mainFrame;
    TableDetailSP tableDetail;
    TableSanPham sanPham;
    EventSanPham event;
    int maSp = -1;
    String keyWord = "";

    public MainContentSanPham(MainFrame mainFrame) {
        initComponents();

        this.mainFrame = mainFrame;
        sanPham = new TableSanPham(keyWord, jComboBox2.getSelectedIndex());
        jScrollPane1.setViewportView(sanPham);
        btnDelete.setOpaque(true);
        btnFormThemSP.setOpaque(true);
        btnFormUpdate.setOpaque(true);
//        detailSPPanel.setLayout(new GridLayout());
        sanPham.addEventSanPham(new EventSanPham() {
            @Override
            public int selectedIndex(int index) {
                ArrayList data = new ArrayList();
                detailSPPanel.removeAll();
                tableDetail = new TableDetailSP(index, jComboBox2.getSelectedItem().toString(), sanPham);
                tableDetail.setBounds(0, 0, detailSPPanel.getWidth(), detailSPPanel.getHeight());
                QuanLiSanPham_BUS qlsp_BUS = new QuanLiSanPham_BUS();
                data = qlsp_BUS.layChitietSanPham(index, (String) jComboBox2.getSelectedItem());
//                System.out.println(data.get(0));
                maSp = (int) data.get(0);
                detailSPPanel.add(tableDetail);
                repaint();
                tableDetail.validate();
                return index;
            }
        });

        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {

                sanPham.SetDefaultTable(txtTimKiem.getText(), jComboBox2.getSelectedIndex());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sanPham.SetDefaultTable(txtTimKiem.getText(), jComboBox2.getSelectedIndex());

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                sanPham.SetDefaultTable(txtTimKiem.getText(), jComboBox2.getSelectedIndex());
            }
        });

    }

//    public void btnDelete(int index, String tenTrangThai) {
//        btnDelete.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                System.out.println("123");
//                System.out.println(index);
//                System.out.println(tenTrangThai);
//            }
//        });
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailSPPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnFormThemSP = new javax.swing.JLabel();
        btnFormUpdate = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1030, 530));

        mainPanel.setBackground(new java.awt.Color(153, 153, 153));
        mainPanel.setPreferredSize(new java.awt.Dimension(1030, 530));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/search-icon (1).png"))); // NOI18N
        jLabel8.setText("Tìm kiếm");

        txtTimKiem.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtTimKiem.setForeground(new java.awt.Color(153, 153, 153));
        txtTimKiem.setText("Nhập thông tin tìm kiếm");
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(204, 204, 255));
        jComboBox2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 51, 51));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "T", "F", " " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout detailSPPanelLayout = new javax.swing.GroupLayout(detailSPPanel);
        detailSPPanel.setLayout(detailSPPanelLayout);
        detailSPPanelLayout.setHorizontalGroup(
            detailSPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
        detailSPPanelLayout.setVerticalGroup(
            detailSPPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(java.awt.Color.cyan);

        btnFormThemSP.setBackground(java.awt.Color.cyan);
        btnFormThemSP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFormThemSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Add.png"))); // NOI18N
        btnFormThemSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormThemSPMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnFormThemSPMousePressed(evt);
            }
        });

        btnFormUpdate.setBackground(java.awt.Color.cyan);
        btnFormUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFormUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/fix.png"))); // NOI18N
        btnFormUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFormUpdateMouseClicked(evt);
            }
        });

        btnDelete.setBackground(java.awt.Color.cyan);
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Close-icon.png"))); // NOI18N
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnFormThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnFormUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFormThemSP, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnFormUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(detailSPPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addComponent(detailSPPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        txtTimKiem.setText("");
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        txtTimKiem.setText("");
        sanPham.SetDefaultTable(txtTimKiem.getText(), jComboBox2.getSelectedIndex());
    }//GEN-LAST:event_jComboBox2ActionPerformed
    public void Doimau() {
        btnFormThemSP.setBackground(Color.CYAN);
        btnDelete.setBackground(Color.CYAN);
        btnFormUpdate.setBackground(Color.CYAN);
    }
    private void btnFormThemSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormThemSPMouseClicked
        Doimau();
        if (btnFormThemSP.getBackground() != Color.CYAN) {
            btnFormThemSP.setBackground(Color.CYAN);
        } else {
            btnFormThemSP.setBackground(Color.red);
        }
        System.out.println(btnFormThemSP.getBackground());
        JFrame frame = new JFrame("Them thong tin");
        FormThemSanPham themSanPham = new FormThemSanPham(frame, sanPham);
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.add(themSanPham);
        frame.setVisible(true);

    }//GEN-LAST:event_btnFormThemSPMouseClicked
    public boolean checkMasp(int Masp) {
        if (maSp != -1) {
            return true;
        }
        return false;
    }
    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        Doimau();
        if (btnDelete.getBackground() != Color.CYAN) {
            btnDelete.setBackground(Color.CYAN);
        } else {
            btnDelete.setBackground(Color.red);
        }
        int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa ?");
        if (a == JOptionPane.YES_OPTION) {
            if (checkMasp(maSp)) {
                QuanLiSanPham_BUS qlsp_BUS = new QuanLiSanPham_BUS();
                if (qlsp_BUS.kiemTraTrangThaiSP(maSp) && qlsp_BUS.xoaSP(maSp)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                    maSp = -1;
                    System.out.println(txtTimKiem.getText());
                    sanPham.SetDefaultTable(txtTimKiem.getText(), jComboBox2.getSelectedIndex());
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chưa chọn sản phẩm muốn xóa");
            }
        }


    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnFormUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormUpdateMouseClicked
        Doimau();
        if (btnFormUpdate.getBackground() != Color.CYAN) {
            btnFormUpdate.setBackground(Color.CYAN);
        } else {
            btnFormUpdate.setBackground(Color.red);
        }
    }//GEN-LAST:event_btnFormUpdateMouseClicked

    private void btnFormThemSPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFormThemSPMousePressed

    }//GEN-LAST:event_btnFormThemSPMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnFormThemSP;
    private javax.swing.JLabel btnFormUpdate;
    private javax.swing.JPanel detailSPPanel;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
