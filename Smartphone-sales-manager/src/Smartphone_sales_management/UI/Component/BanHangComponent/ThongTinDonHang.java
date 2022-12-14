/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.BanHangComponent;

import Smartphone_sales_management.BUS.QuanLyBanHang_BUS;
import Smartphone_sales_management.DAO.QuanLyBanHang_DAO;
import Smartphone_sales_management.DTO.Model_BanHang_ChiTietHoaDon;
import Smartphone_sales_management.DTO.Model_BanHang_HoaDon;
import Smartphone_sales_management.UI.Component.PhieuNhap.RoundedBorderer;
import Smartphone_sales_management.UI.Main.MainFrame;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import static Smartphone_sales_management.UI.Main.MainFrame.manv;
import javax.swing.JOptionPane;

/**
 *
 * @author Vuong
 */
public class ThongTinDonHang extends javax.swing.JPanel {

    /**
     * Creates new form ThongTinDonHang
     */
    DefaultTableModel model = new DefaultTableModel();

    private ArrayList<Model_BanHang_ChiTietHoaDon> data;
    private ArrayList<Object> danhsachkhachhang;
    private ArrayList<Object> danhsachsanpham;
    private int diemdadung;
    private int diemthuong;
    JDialog inforDonHangDialog;
    QuanLyBanHang_BUS qlbh_bus = new QuanLyBanHang_BUS();
    MainFrame a;
    LocalDateTime now;
    int SL = 0;
    int TT = 0;
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    int giasaukm = 0;
    int diem;
    MainConTentBanHang panelbanhang;

    public ThongTinDonHang(ArrayList<Model_BanHang_ChiTietHoaDon> data,MainFrame a, JDialog inforDonHang,MainConTentBanHang panelbanhang) {
        initComponents();
        this.data = data;
        this.a = a;
        this.inforDonHangDialog = inforDonHang;
        this.panelbanhang=panelbanhang;

        Model_BanHang_ChiTietHoaDon tets = data.get(0);
//        btnComplete.setBackground(new Color(255, 255, 255));
        btnComplete.setBorder(null);
        btnBack.setBorder(null);
//        btnBack.setBackground(new Color(255, 255, 255));

        // L???y danh s??ch kh??ch h??ng
//    final DefaultComboBoxModel model = new DefaultComboBoxModel(danhsachsanpham); 
//    cbbKhachHang.setModel(model);
        // set data Table
        LoadInforData();
        model.addColumn("STT");
        model.addColumn("T??n s???n ph???m");
        model.addColumn("Gi?? ti???n");
        model.addColumn("S??? l?????ng");
        model.addColumn("Khuy???n m??i");
        model.addColumn("B???o h??nh");
        jTable1.setOpaque(false);
        jTable1.getTableHeader().getColumnModel().setColumnMargin(1);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14) {
        });
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setBackground(new Color(14, 14, 14));

        SetDefautlTable();
        jTable1.setModel(model);
        jScrollPane1.setMaximumSize(new Dimension(1000, 50));
//                jTable1.setSize(jTable1.getWidth(),jTable1.getRowHeight()*model.getRowCount());
        btnBack.setBorder(new RoundedBorderer(new Color(255,255,255), 2, 30));
        btnComplete.setBorder(new RoundedBorderer(new Color(255,255,255), 2, 30));


    }
    // load d??? li???u li??n quan l??n form
    public void LoadInforData() {
        danhsachkhachhang = qlbh_bus.getALLKhachHang();
        cbbKhachHang.removeAllItems();
        for (Object khachhang : danhsachkhachhang) {
            Vector a = (Vector) khachhang;
            cbbKhachHang.addItem((a.get(1)).toString());
            System.out.println("Da vao");
        }
                cbbKhachHang.setSelectedIndex(0);
        Vector b = (Vector) danhsachkhachhang.get(cbbKhachHang.getSelectedIndex());
        cbDiem.setText(b.get(2).toString());
        diem = (int) b.get(2);
        // Load th??ng tin d??? li???u
        // set gi?? sau khi ??p d???ng khuy???n m??i
        giasaukm = 0;
        int tongtien =0;
        for (Model_BanHang_ChiTietHoaDon model_ChiTietHoaDon : data) {
            giasaukm += model_ChiTietHoaDon.getGiasaukm()*model_ChiTietHoaDon.getSoluong();
            SL += model_ChiTietHoaDon.getSoluong();
            tongtien+=model_ChiTietHoaDon.getGiaban()*model_ChiTietHoaDon.getSoluong();
            TT += model_ChiTietHoaDon.getTongTien();
//           cbbSanPham.addItem(model_GioHang.getName());
        }
        this.now = LocalDateTime.now();
        String formatDateTime = now.format(format);
        lbNgayBan.setText(formatDateTime);
        lbSoLuong.setText(String.valueOf(SL));
        lbnTongTien.setText(String.valueOf(tongtien) + " VND");
        lbnGiaSauKhuyenMai.setText(String.valueOf(giasaukm) + " VND");
        lbThanhToan.setText("Thanh to??n tr???c ti???p");
//        if(cbDiem.isSelected())
//        {
//                    giasaukm +=Integer.parseInt(cbDiem.getText());
        lbTongTienThanhToan.setText(String.valueOf(TT)+" VND");
    }

    public void SetDefautlTable() {

        jTable1.removeAll();
        model.setRowCount(0);
        int i = 1;
        for (Model_BanHang_ChiTietHoaDon model_BanHang_ChiTietHoaDons : data) {
            Vector a = new Vector();
            a.add(i);
            a.add(model_BanHang_ChiTietHoaDons.getTensp());
            a.add(model_BanHang_ChiTietHoaDons.getGiaban());
            a.add(model_BanHang_ChiTietHoaDons.getSoluong());
            a.add(model_BanHang_ChiTietHoaDons.getPhantramkhuyenmai() + " %");
            a.add(model_BanHang_ChiTietHoaDons.getThoigianbaohanh());
            model.addRow(a);
            i += 1;

        }
        jScrollPane1.setLayout(new ScrollPaneLayout());

        jScrollPane1.repaint();
    }

    ThongTinDonHang() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        lbTongTienThanhToan = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnComplete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbNgayBan = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbThanhToan = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbDiem = new javax.swing.JCheckBox();
        lbnGiaSauKhuyenMai = new javax.swing.JLabel();
        lbnTongTien = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("S??? L?????ng: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Thanh To??n");

        lbSoLuong.setForeground(new java.awt.Color(0, 0, 153));
        lbSoLuong.setText("jLabel8");

        lbTongTienThanhToan.setForeground(new java.awt.Color(0, 0, 153));
        lbTongTienThanhToan.setText("jLabel11");

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/go-back-2-894878.png"))); // NOI18N
        btnBack.setText("Quay L???i");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Danh S??ch S???n ph???m: ");

        btnComplete.setBackground(new java.awt.Color(0, 0, 0));
        btnComplete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnComplete.setForeground(new java.awt.Color(255, 255, 255));
        btnComplete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/GoBack4.png"))); // NOI18N
        btnComplete.setText("Ho??n Th??nh");
        btnComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setForeground(new java.awt.Color(0, 0, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        cbbKhachHang.setOpaque(true);
        cbbKhachHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKhachHangItemStateChanged(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Add - Copy.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("T??n Kh??ch H??ng: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Ng??y B??n: ");

        lbNgayBan.setForeground(new java.awt.Color(0, 0, 153));
        lbNgayBan.setText("jLabel9");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("H??nh th???c Thanh To??n: ");

        lbThanhToan.setForeground(new java.awt.Color(0, 0, 153));
        lbThanhToan.setText("jLabel10");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lbNgayBan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(58, 58, 58))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbThanhToan)
                    .addComponent(lbNgayBan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Gi?? Sau Khuy???n M??i: ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("??p D???ng ??i???m: ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("T???ng Ti???n: ");

        cbDiem.setText("0");
        cbDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDiemActionPerformed(evt);
            }
        });

        lbnGiaSauKhuyenMai.setText("jLabel11");

        lbnTongTien.setText("jLabel12");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTongTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbnGiaSauKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                        .addComponent(lbnTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(btnComplete)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSoLuong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbnTongTien))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbnGiaSauKhuyenMai))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbDiem))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTongTienThanhToan))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComplete, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("????n H??ng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(281, 281, 281))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        this.inforDonHangDialog.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteActionPerformed
        Model_BanHang_HoaDon hoadon = new Model_BanHang_HoaDon();
        int indexmakh = cbbKhachHang.getSelectedIndex();
        Vector vectorKhachHang = (Vector) danhsachkhachhang.get(indexmakh);
        int Makh =Integer.parseInt(vectorKhachHang.get(0).toString());
        for (Model_BanHang_ChiTietHoaDon model_BanHang_ChiTietHoaDon : data) {
            diemthuong+=model_BanHang_ChiTietHoaDon.getSoluong()*100000;         
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDateTime = now.format(format);
        hoadon.setMakh(Makh);
        TT=TT-diemdadung;
        hoadon.setDiemapdung(diemdadung);
        hoadon.setManv(manv);
        hoadon.setNgayban(formatDateTime);
        hoadon.setSoluong(Integer.parseInt(lbSoLuong.getText()));
        hoadon.setTongtien(TT);
        hoadon.setDiemthuong(diemthuong);
        int madh = qlbh_bus.InsertDonHang(hoadon,diem);
        for (Model_BanHang_ChiTietHoaDon object :data) {
            object.setMadh(madh);
            qlbh_bus.AddChiTietDonHang(object);      
        }
        JOptionPane.showMessageDialog(null,"???? t???o ????n h??ng th??nh c??ng");
        inforDonHangDialog.dispose();
        panelbanhang.SetDefaultInit();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCompleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // H??m th??m kh??ch h??ng
        Window win = SwingUtilities.getWindowAncestor(this);
        JDialog inforDonHang = new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
//        changePwdDialog.setUndecorated(true);
//          ThongTinDonHang donhang = new ThongTinDonHang(data,this,inforDonHang);
        AddKhachHang themkhachhang = new AddKhachHang(inforDonHang,ThongTinDonHang.this);
        inforDonHang.setSize(626, 488);
        inforDonHang.setLayout(new GridLayout());
        inforDonHang.setTitle("Th??m kh??ch h??ng");
        inforDonHang.add(themkhachhang);
        themkhachhang.validate();
        inforDonHang.setLocationRelativeTo(null);
        inforDonHang.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        inforDonHang.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDiemActionPerformed

        int gia = giasaukm;
        gia -= diem;

        if (cbDiem.isSelected()) {
            if (gia > 0) {
//                gia -= Integer.parseInt(cbDiem.getText());
                lbTongTienThanhToan.setText(String.valueOf(gia)+" VND");
                cbDiem.setText(cbDiem.getText() + "/" + cbDiem.getText());
                diemdadung=diem;
            } else {
                int x = Math.abs(gia);
                cbDiem.setText(String.valueOf(diem - x) + "/" + String.valueOf(diem));
                lbTongTienThanhToan.setText("0 VND");
                this.diemdadung=diem-x;
            }
        } else {

            lbTongTienThanhToan.setText(String.valueOf(giasaukm) + " VND");
            cbDiem.setText(String.valueOf(diem));
            this.diemdadung=0;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_cbDiemActionPerformed

    private void cbbKhachHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKhachHangItemStateChanged

        if(cbbKhachHang.getSelectedIndex()!=-1)
        {
            
        Vector b = (Vector) danhsachkhachhang.get(cbbKhachHang.getSelectedIndex());
        cbDiem.setText(b.get(2).toString());
        diem = (int) b.get(2);
        cbDiem.setSelected(false);
        }

    }//GEN-LAST:event_cbbKhachHangItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnComplete;
    private javax.swing.JCheckBox cbDiem;
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbNgayBan;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbThanhToan;
    private javax.swing.JLabel lbTongTienThanhToan;
    private javax.swing.JLabel lbnGiaSauKhuyenMai;
    private javax.swing.JLabel lbnTongTien;
    // End of variables declaration//GEN-END:variables
}
