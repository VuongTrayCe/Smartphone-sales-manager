/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Smartphone_sales_management.UI.Main;

import Smartphone_sales_management.BUS.QuanLyTaiKhoan_BUS;
import Smartphone_sales_management.DAO.ThongKeBaoCaoBanHang_DAO;
import Smartphone_sales_management.UI.Component.BanHangComponent.MainConTentBanHang;
import Smartphone_sales_management.UI.Component.ThongKeBaoCaoComponent.ThongKeMainPanel;

import Smartphone_sales_management.UI.Component.BanHangComponent.TableBanHang;
import Smartphone_sales_management.UI.Component.BaoHanhComponent.PanelThongTinBaoHanh;
import Smartphone_sales_management.UI.Component.DonHangComponent.MainContentDonHang;
import Smartphone_sales_management.UI.Component.SanPhamComponent.MainContentSanPham;
import Smartphone_sales_management.UI.Component.KhuyenMaiComponent.KhuyenMaiGUI;
import Smartphone_sales_management.UI.Component.PhieuNhap.MainConTentPhieuNhap;
import Smartphone_sales_management.UI.Component.TaiKhoanComponent.MainConTentTaiKhoan;
import Smartphone_sales_management.UI.Event.EventMenu;
import Smartphone_sales_management.UI.Swing.Menu.ConNguoi;
import Smartphone_sales_management.UI.Component.BaoHanhComponent.MainContentBaoHanh;
import Smartphone_sales_management.UI.Component.TaiKhoan2.MainConTentTaiKhoan2;
import Smartphone_sales_management.UI.Component.TaiKhoanComponent.LoginFrom;
import Smartphone_sales_management.UI.Swing.ChinhSach.ChinhSach;

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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vuong
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form TestFrame
     */
    public static int selectedIndex = 0;
    public static int manv = 0;
    public static String tennv = "Vuong";
    public static int BanHang = 0;
    public static int ThongKe = 0;
    public static int SanPham = 0;
    public static int PhieuNhap = 0;
    public static int ConNguoi = 0;
    public static int DonHang = 0;
    public static int ChinhSach = 0;
    public static int TaiKhoan = 0;
    QuanLyTaiKhoan_BUS qltk = new QuanLyTaiKhoan_BUS();
    LoginFrom form;

    public MainFrame(int manv, String tennv, LoginFrom form) {
        CheckQuyen(manv);
        this.form = form;
        form.setVisible(false);
        this.manv = manv;
        initComponents();
        lbTenDangNhap.setText(tennv);
        this.setLocationRelativeTo(null);
        setVisible(true);
        jPanel1.setMinimumSize(new Dimension(100, 100));
        if (BanHang == 1) {
            MainConTentBanHang a = new MainConTentBanHang(MainFrame.this);
            a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
            jPanel1.setLayout(new GridLayout());
            jPanel1.add(a);
            a.validate();
        } else if (SanPham == 1) {
            MainContentSanPham a = new MainContentSanPham(MainFrame.this);
            a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
            jPanel1.setLayout(new GridLayout());
            jPanel1.add(a);
            a.validate();

        } else if (DonHang == 1) {
            try {
                MainContentDonHang a = new MainContentDonHang(MainFrame.this);
                a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
                jPanel1.setLayout(new GridLayout());
                jPanel1.add(a);
                a.validate();
            } catch (ParseException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (PhieuNhap == 1) {
            MainConTentPhieuNhap a = new MainConTentPhieuNhap(this, jPanel1);
            a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
            jPanel1.setLayout(new GridLayout());
            jPanel1.add(a);
            a.validate();

        } else if (ConNguoi == 1) {
            ConNguoi a = new ConNguoi(this, jPanel1);
            a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
            jPanel1.setLayout(new GridLayout());
            jPanel1.add(a);
            a.validate();
        } else if (ThongKe == 1) {
            ThongKeMainPanel a = new ThongKeMainPanel();
            a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
            jPanel1.setLayout(new GridLayout());
            jPanel1.add(a);
            a.validate();
        } else if (TaiKhoan == 1) {
            MainConTentTaiKhoan a = new MainConTentTaiKhoan(this);
            a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
            jPanel1.setLayout(new GridLayout());
            jPanel1.add(a);
            a.validate();
        } else {
            ChinhSach a = new ChinhSach(this, jPanel1);
            a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
            jPanel1.setLayout(new GridLayout());
            jPanel1.add(a);
            a.validate();
        }

//        PanelThemPhieuNhapHang a = new PanelThemPhieuNhapHang(this, jPanel1);
//          MainContentBaoHanh a = new MainContentBaoHanh(MainFrame.this, jPanel1);
//        ThongKeMainPanel a = new ThongKeMainPanel()
//        MainConTentBanHang a = new MainConTentBanHang(MainFrame.this);
//   TestPanel2  a = new TestPanel2();
        menu2.addEventMenu(new EventMenu() {
            @Override
            public void selected(int index, String tenquyen) {
                if (tenquyen.equals("Bán Hàng")) {
//                       NhanVienGUI a = new NhanVienGUI(MainFrame.this);
//KhuyenMaiGUI a = new KhuyenMaiGUI(MainFrame.this);
//                    MainConTentTaiKhoan a = new MainConTentTaiKhoan(MainFrame.this);
//                    MainContentDonHang a = new MainContentDonHang(MainFrame.this);
//                    MainContentSanPham a = new MainContentSanPham(MainFrame.this);
                    MainConTentBanHang a = new MainConTentBanHang(MainFrame.this);
                    jPanel1.removeAll();
                    a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
                    jPanel1.setLayout(new GridLayout());
                    jPanel1.add(a);
                    a.validate();
//                    pack();
                }
                if (tenquyen.equals("Sản Phẩm")) {

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

                if (tenquyen.equals("Đơn Hàng")) {
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
                if (tenquyen.equals("Phiếu Nhập")) {

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
                if (tenquyen.equals("Con Người")) {
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
                if (tenquyen.equals("Thống Kê")) {
                    ThongKeMainPanel a = new ThongKeMainPanel();
                    jPanel1.removeAll();
                    a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
                    jPanel1.setLayout(new GridLayout());
                    jPanel1.add(a);
                    a.validate();
                }
                 if (tenquyen.equals("Tài Khoản")) {
//                    KhuyenMaiGUI a = new KhuyenMaiGUI(MainFrame.this);
                    MainConTentTaiKhoan2 a = new MainConTentTaiKhoan2(MainFrame.this);
//                    ThongKeMainPanel a = new ThongKeMainPanel();
                    jPanel1.removeAll();
                    a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
                    jPanel1.setLayout(new GridLayout());
                    jPanel1.add(a);
                    a.validate();
                }
                if (tenquyen.equals("Chính Sách")) {
//                    KhuyenMaiGUI a = new KhuyenMaiGUI(MainFrame.this);
                    ChinhSach a = new ChinhSach(MainFrame.this, jPanel1);
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

    public void CheckQuyen(int manv1) {
        ArrayList arrQuyen = new ArrayList();
        BanHang = 0;
        SanPham = 0;
        DonHang = 0;
        PhieuNhap = 0;
        ConNguoi = 0;
        ThongKe = 0;
        TaiKhoan =0;
        ChinhSach = 0;
        selectedIndex=0;
        arrQuyen = qltk.getALLQuyenTK(manv1);
        for (Object object : arrQuyen) {
            String tenquyen = (String) object;
            if (tenquyen.equals("Quản Lý")) {
                BanHang = 1;
                SanPham = 1;
                DonHang = 1;
                PhieuNhap = 1;
                ConNguoi = 1;
                ThongKe = 1;
                TaiKhoan = 1;
                ChinhSach = 1;
                System.out.println("quan ly");

            }
            if (tenquyen.equals("Bán Hàng")) {
                BanHang = 1;
                System.out.println("Ban hang");

            }
            if (tenquyen.equals("Đơn Hàng")) {
                DonHang = 1;
            }
            if (tenquyen.equals("Sản Phẩm")) {
                SanPham = 1;
            }
            if (tenquyen.equals("Phiếu Nhập")) {
                PhieuNhap = 1;
            }
            if (tenquyen.equals("Chính Sách")) {
                ChinhSach = 1;
            }
            if (tenquyen.equals("Con Người")) {
                ConNguoi = 1;
            }
            if (tenquyen.equals("Thống Kê")) {
                ThongKe = 1;
            }
            if (tenquyen.equals("Tài Khoản")) {
                TaiKhoan = 1;
            }
        }
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
        lbTenDangNhap = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();

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

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("PhoneNumber: 036143418471             ||      Address: 611/30 QL1A Bình Hưng Hòa Bình Tân HCM");

        lbTenDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        lbTenDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Icon_Admin_DangNhap.png"))); // NOI18N
        lbTenDangNhap.setText("Name");

        cbbTrangThai.setBackground(new java.awt.Color(0, 51, 204));
        cbbTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online", "Đăng Xuất" }));
        cbbTrangThai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTrangThaiItemStateChanged(evt);
            }
        });
        cbbTrangThai.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbbTrangThaiPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(lbTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void cbbTrangThaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTrangThaiItemStateChanged

        int indexSta = cbbTrangThai.getSelectedIndex();
        if (indexSta == 1) {
            this.dispose();
            this.form.setVisible(true);
        }
// TODO add your handling code here:
    }//GEN-LAST:event_cbbTrangThaiItemStateChanged

    private void cbbTrangThaiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbbTrangThaiPropertyChange

// TODO add your handling code here:
    }//GEN-LAST:event_cbbTrangThaiPropertyChange

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
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbTenDangNhap;
    private Smartphone_sales_management.UI.form.Menu menu2;
    private Smartphone_sales_management.UI.Swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
