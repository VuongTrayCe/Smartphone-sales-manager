/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.PhieuNhap;

import Smartphone_sales_management.BUS.QuanLyPhieuNhap_BUS;
import Smartphone_sales_management.UI.Component.NhaCungCap.AddNhaCungCap;
import Smartphone_sales_management.UI.Main.MainFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable.PrintMode;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Smartphone_sales_management.UI.Swing.GraphicsPanel;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;
import Smartphone_sales_management.DTO.Model_PhieuNhap;
import Smartphone_sales_management.DTO.Model_PhieuNhap_ChiTiet;

import static Smartphone_sales_management.UI.Main.MainFrame.manv;
import Smartphone_sales_management.UI.Swing.PrintPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Vuong
 */
public class PanelThemPhieuNhapHang extends javax.swing.JPanel {

    /**
     * Creates new form PanelThemPhieuNhapHang
     */
    JPanel panel;
    MainFrame frame;

    QuanLyPhieuNhap_BUS qlpn = new QuanLyPhieuNhap_BUS();
    private int Mapn;
    private int masp;
    private String ngaynhap;
    private String tenncc;
    DefaultTableModel model = new DefaultTableModel();
    private ArrayList<Object> danhsachNhaCungCap;
    LocalDateTime now;
    ArrayList<Model_PhieuNhap_ChiTiet> dataChiTietPhieuNhap = new ArrayList();
    Model_PhieuNhap modelPhieuNhap;
    Model_PhieuNhap_ChiTiet modelChiTietPhieuNhap;

    public PanelThemPhieuNhapHang(MainFrame frame, JPanel panel) {
        initComponents();
        this.panel = panel;
        this.frame = frame;
        this.now = LocalDateTime.now();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatDateTime = now.format(format);

        btnNgayNhap.setText(formatDateTime);

        model.addColumn("STT");
        model.addColumn("Mã Sản Phẩm");
        model.addColumn("Tên Sản Phẩm");
        model.addColumn("Giá Nhập");
        model.addColumn("Số Lượng");
        model.addColumn("Tổng Tiền");
        jTable1.setOpaque(false);
        jTable1.getTableHeader().getColumnModel().setColumnMargin(1);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 17) {
        });
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setBackground(new Color(14, 14, 14));
        jTable1.setModel(model);
        btnThem.setBorder(new RoundedBorderer(new Color(255, 255, 255), 2, 30));
        btnXoa.setBorder(new RoundedBorderer(new Color(255, 255, 255), 2, 30));
        btnHoanThanh.setBorder(new RoundedBorderer(new Color(255, 255, 255), 2, 30));
        btnGoBack.setBorder(new RoundedBorderer(new Color(255, 255, 255), 2, 30));

        setComboboxNhaCungCap();
        DisplayDetailPhieuNhap();

        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = jTable1.getSelectedRow();
                masp = (int) jTable1.getValueAt(index, 1);

            }
        ;
    }

    );
        
        
    }

    // Hiển thị thông tin ra bảng chi tiết
    public void DisplayDetailPhieuNhap() {
//        
        jTable1.removeAll();
        model.setRowCount(0);
        int soluong = 0;
        int tongtien = 0;
        if (dataChiTietPhieuNhap.size() != 0) {
            for (int i = 0; i < dataChiTietPhieuNhap.size(); i++) {
                Model_PhieuNhap_ChiTiet modelrow = dataChiTietPhieuNhap.get(i);
                Vector a = new Vector();
                a.add(i + 1);
                a.add(modelrow.getMasp());
                a.add(modelrow.getTensp());
                a.add(modelrow.getGianhap());
                a.add(modelrow.getSoluong());
                a.add(modelrow.getSoluong() * modelrow.getGianhap());
                soluong += modelrow.getSoluong();
                tongtien += modelrow.getGianhap() * modelrow.getSoluong();
                model.addRow(a);
            }
        }
        btnTongSoLuong.setText(String.valueOf(soluong));
        btnTongTien.setText(String.valueOf(tongtien));
        jScrollPane1.repaint();

//        lbMaPhieuNhap.setText(Integer.toString(Mapn));
//        lbNgayNhap.setText(ngaynhap);
//        lbNhaCungCap.setText(tenncc);
    }

    public void setComboboxNhaCungCap() {
        danhsachNhaCungCap = qlpn.getALLNhaCungCap();
        cbbNhaCungCap.removeAllItems();
        for (Object nhacungcap : danhsachNhaCungCap) {
            Vector a = (Vector) nhacungcap;
            cbbNhaCungCap.addItem((a.get(1)).toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new GraphicsPanel(50,new Color(255, 255, 255));
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnTongSoLuong = new javax.swing.JLabel();
        btnTongTien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNgayNhap = new javax.swing.JLabel();
        jPanel2 = new GraphicsPanel(50,new Color(255, 255, 255));
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnHoanThanh = new javax.swing.JButton();
        jPanel4 = new JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbbNhaCungCap = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnGoBack = new javax.swing.JButton();
        jPanel5 = new GraphicsPanel(20,new Color(255, 255, 255));
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        jScrollPane1.setBorder(null);

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
        jTable1.setRowHeight(35);
        jTable1.setSelectionBackground(new java.awt.Color(204, 0, 0));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Tổng Số Lượng: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Tổng TIền: ");

        btnTongSoLuong.setText("10");

        btnTongTien.setText("10000");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Danh Sách Sản Phẩm Nhập");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Ngày Nhập: ");

        btnNgayNhap.setText("jLabel8");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setBackground(new java.awt.Color(51, 153, 0));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(204, 0, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnHoanThanh.setBackground(new java.awt.Color(0, 153, 0));
        btnHoanThanh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHoanThanh.setText("Hoàn Thành");
        btnHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tên Nhà Cung Cấp:");

        cbbNhaCungCap.setBackground(new java.awt.Color(0, 0, 0));
        cbbNhaCungCap.setForeground(new java.awt.Color(255, 255, 255));
        cbbNhaCungCap.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNhaCungCapItemStateChanged(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Add.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(cbbNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnGoBack.setBackground(new java.awt.Color(204, 0, 0));
        btnGoBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGoBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/go-back-2-894878.png"))); // NOI18N
        btnGoBack.setText("Quay Lại");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(19, 19, 19))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNgayNhap))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnTongTien)
                                            .addComponent(btnTongSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(352, 352, 352)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnNgayNhap))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnTongSoLuong))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnTongTien))
                .addGap(18, 18, 18)
                .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Phiếu Nhập Hàng");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed

        MainConTentPhieuNhap a = new MainConTentPhieuNhap(frame, panel);
        panel.removeAll();
        a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        panel.setLayout(new GridLayout());
        panel.add(a);
        a.validate();
// TODO add your handling code here:
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        Vector b = (Vector) danhsachNhaCungCap.get(cbbNhaCungCap.getSelectedIndex());
        int mancc = (int) b.get(0);
        JDialog inforDonHang = new JDialog();
        PanelAddSanPhamPhieuNhap c = new PanelAddSanPhamPhieuNhap(mancc, dataChiTietPhieuNhap, Mapn, inforDonHang, PanelThemPhieuNhapHang.this);

//        changePwdDialog.setUndecorated(true);
//          ThongTinDonHang donhang = new ThongTinDonHang(data,this,inforDonHang);
        inforDonHang.setSize(400, 350);
        inforDonHang.setLayout(new GridLayout());
        inforDonHang.setTitle("Chi Tiết Phiếu Nhập");
        inforDonHang.add(c);
        c.validate();
        inforDonHang.setLocationRelativeTo(null);
        inforDonHang.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

        AddNhaCungCap_PhieuNhap nhacungcap = new AddNhaCungCap_PhieuNhap(PanelThemPhieuNhapHang.this);
        JDialog inforDonHang = new JDialog();
//        changePwdDialog.setUndecorated(true);
//          ThongTinDonHang donhang = new ThongTinDonHang(data,this,inforDonHang);
        inforDonHang.setSize(380, 300);
        inforDonHang.setLayout(new GridLayout());
        inforDonHang.setTitle("Thêm khách hàng");
        inforDonHang.add(nhacungcap);
        nhacungcap.validate();
        inforDonHang.setLocationRelativeTo(null);
        inforDonHang.setVisible(true);

    }//GEN-LAST:event_jLabel6MouseClicked

    private void btnHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhActionPerformed

        if (dataChiTietPhieuNhap.size() != 0) {
            int indexmncc = cbbNhaCungCap.getSelectedIndex();
            Vector ncc = (Vector) danhsachNhaCungCap.get(indexmncc);
            int mancc = (int) ncc.get(0);
            int soluong = Integer.parseInt(btnTongSoLuong.getText());
            double tongtien = Double.valueOf(btnTongTien.getText());
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formatDateTime = now.format(format);
            modelPhieuNhap = new Model_PhieuNhap(manv, mancc, soluong, formatDateTime, tongtien);
            Mapn = qlpn.AddPhieuNhapHang(modelPhieuNhap);
            System.out.println(Mapn);
            for (Model_PhieuNhap_ChiTiet model_PhieuNhap_ChiTiet : dataChiTietPhieuNhap) {
                model_PhieuNhap_ChiTiet.setMapn(Mapn);
                qlpn.AddChiTietPhieuNhap(model_PhieuNhap_ChiTiet);
            }
            dataChiTietPhieuNhap.clear();
            DisplayDetailPhieuNhap();

        } else {
            JOptionPane.showMessageDialog(null, "Vui Lòng Thêm Sản Phẩm Cần Nhập");
        }

    }//GEN-LAST:event_btnHoanThanhActionPerformed

    private void cbbNhaCungCapItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNhaCungCapItemStateChanged
        dataChiTietPhieuNhap.clear();
        DisplayDetailPhieuNhap();

// TODO add your handling code here:
    }//GEN-LAST:event_cbbNhaCungCapItemStateChanged

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        ArrayList<Model_PhieuNhap_ChiTiet> arr = new ArrayList<>();
        for (Model_PhieuNhap_ChiTiet model_PhieuNhap_ChiTiet : dataChiTietPhieuNhap) {
            if (model_PhieuNhap_ChiTiet.getMasp() != masp) {
                arr.add(model_PhieuNhap_ChiTiet);
            }
        }
        dataChiTietPhieuNhap = arr;
        DisplayDetailPhieuNhap();
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnHoanThanh;
    private javax.swing.JLabel btnNgayNhap;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel btnTongSoLuong;
    private javax.swing.JLabel btnTongTien;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbNhaCungCap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
