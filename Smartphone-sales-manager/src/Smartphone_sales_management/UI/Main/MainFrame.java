/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Smartphone_sales_management.UI.Main;

import Smartphone_sales_management.DAO.ThongKeBaoCaoBanHang_DAO;
import Smartphone_sales_management.UI.Component.BanHangComponent.MainConTentBanHang;
import Smartphone_sales_management.UI.Component.ThongKeBaoCaoComponent.ThongKeMainPanel;

import Smartphone_sales_management.UI.Component.BanHangComponent.TableBanHang;
import Smartphone_sales_management.UI.Component.BaoHanhComponent.PanelThongTinBaoHanh;
import Smartphone_sales_management.UI.Component.DonHangComponent.MainContentDonHang;
import Smartphone_sales_management.UI.Component.SanPhamComponent.MainContentSanPham;
import Smartphone_sales_management.UI.Component.KhuyenMaiComponent.KhuyenMaiGUI;
import Smartphone_sales_management.UI.Component.PhieuNhap.MainConTentPhieuNhap;
import Smartphone_sales_management.UI.Event.EventMenu;
import Smartphone_sales_management.UI.Swing.Menu.ConNguoi;
import Smartphone_sales_management.UI.Component.BaoHanhComponent.MainContentBaoHanh;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Vuong
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form TestFrame
     */
    public static int selectedIndex = -1;
    public static int manv =1;
    public static String tennv = "Vuong";

    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        setVisible(true);
        jPanel1.setMinimumSize(new Dimension(100, 100));
//        PanelThemPhieuNhapHang a = new PanelThemPhieuNhapHang(this, jPanel1);
          MainContentBaoHanh a = new MainContentBaoHanh(MainFrame.this, jPanel1);
//        MainConTentPhieuNhap a = new  MainConTentPhieuNhap(this,jPanel1);
//        ThongKeMainPanel a = new ThongKeMainPanel();
//        MainConTentBanHang a = new MainConTentBanHang(MainFrame.this);
//        MainContentDonHang a = new MainContentDonHang(MainFrame.this);
//        MainContentSanPham a = new MainContentSanPham(MainFrame.this);
//        MainConTentBanHang a = new MainConTentBanHang(MainFrame.this);

//   TestPanel2  a = new TestPanel2();
        a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        jPanel1.setLayout(new GridLayout());
        jPanel1.add(a);
        a.validate();
        menu2.addEventMenu(new EventMenu() {
            @Override
            public void selected(int index) {
                if (index == 0) {
//                       NhanVienGUI a = new NhanVienGUI(MainFrame.this);
//KhuyenMaiGUI a = new KhuyenMaiGUI(MainFrame.this);
                    MainConTentBanHang a = new MainConTentBanHang(MainFrame.this);
//                    MainContentDonHang a = new MainContentDonHang(MainFrame.this);
//                    MainContentSanPham a = new MainContentSanPham(MainFrame.this);
//                    MainConTentBanHang a = new MainConTentBanHang(MainFrame.this);

                    jPanel1.removeAll();
                    a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
                    jPanel1.setLayout(new GridLayout());
                    jPanel1.add(a);
                    a.validate();
//                    pack();

                }
                if (index == 1) {

                    MainContentSanPham a = new MainContentSanPham(MainFrame.this);
                    jPanel1.removeAll();
                    a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
                    jPanel1.setLayout(new GridLayout());
                    jPanel1.add(a);
                    a.validate();
//                    pack();

//                    
//                    jPanel1.removeAll();
//                    pack();
//                    jPanel1.repaint();
                }

                if (index == 2) {

                    MainContentDonHang a = null;
                    try {
                        a = new MainContentDonHang(MainFrame.this);
                    } catch (ParseException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    jPanel1.removeAll();
                    a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
                    jPanel1.setLayout(new GridLayout());
                    jPanel1.add(a);
                    a.validate();
//                    pack();
//                    jPanel1.removeAll();
//                    jPanel1.repaint();

                }
                if (index == 3) {

                    MainConTentPhieuNhap a = new MainConTentPhieuNhap(MainFrame.this, jPanel1);

                    jPanel1.removeAll();
                    a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
                    jPanel1.setLayout(new GridLayout());
                    jPanel1.add(a);
                    a.validate();
//                    pack();
//                    jPanel1.removeAll();
//                    jPanel1.repaint();

                }
                if (index == 4) {
                    ConNguoi a = new ConNguoi(MainFrame.this, jPanel1);
                    jPanel1.removeAll();
                    a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
                    jPanel1.setLayout(new GridLayout());
                    jPanel1.add(a);
                    a.validate();
//                    NewJFrame framechoise = new  NewJFrame();
//                    framechoise.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//                    framechoise.setVisible(true);
//                    this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));

//                     MainContentDonHang a = new MainContentDonHang(MainFrame.this);
//
//                    jPanel1.removeAll();
//                    a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
//                    jPanel1.setLayout(new GridLayout());
//                    jPanel1.add(a);
//                    a.validate();
                }
                if (index == 5) {
                    ThongKeMainPanel a = new ThongKeMainPanel();
                    jPanel1.removeAll();
                    a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
                    jPanel1.setLayout(new GridLayout());
                    jPanel1.add(a);
                    a.validate();
                }
                if (index == 7) {
                    KhuyenMaiGUI a = new KhuyenMaiGUI(MainFrame.this);
//                    ThongKeMainPanel a = new ThongKeMainPanel();
                    jPanel1.removeAll();
                    a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
                    jPanel1.setLayout(new GridLayout());
                    jPanel1.add(a);
                    a.validate();
                }

            }
        });

//        setBackground(new Color(0,0,0,0));
//      menuPanel1.initMoving(TestFrame.this);
//       TestPanel a = new TestPanel();
//         a.setBounds(0,0,jPanel1.getWidth(),jPanel1.getHeight());
//
//   jPanel1.add(a);
//       System.out.println("Vuong da vao");
//   pack();
    }

    @Override
    public void paintComponents(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(152, 141, 172));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 100, 10, getWidth(), getHeight());

        super.paintComponents(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new Smartphone_sales_management.UI.Swing.PanelBorder();
        menu2 = new Smartphone_sales_management.UI.form.Menu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(33, 29, 79));

        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("jLabel1");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/NhanVien.png"))); // NOI18N
        jLabel2.setText("Name");

        jComboBox1.setBackground(new java.awt.Color(0, 51, 204));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online", "Đăng Xuất" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 624, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TestFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Smartphone_sales_management.UI.form.Menu menu2;
    private Smartphone_sales_management.UI.Swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
