/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.ThongKeBaoCaoComponent;

import Smartphone_sales_management.BUS.ThongKeBaoCao_BUS;
import Smartphone_sales_management.DBConnect;
import Smartphone_sales_management.UI.Component.BanHangComponent.AddKhachHang;
import Smartphone_sales_management.UI.Component.BanHangComponent.TableBanHang;
import Smartphone_sales_management.UI.Component.BanHangComponent.TableGioHang;
import Smartphone_sales_management.UI.Event.BanHang.AddGioHang;
import Smartphone_sales_management.UI.Event.ThongKe.AddXemChiTiet;
import Smartphone_sales_management.UI.Model.Model_GioHang;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Vuong
 */
public class ThongKeMainPanel extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeComponent
     */
    TableDoanhThuBanHang a;
    public String ngaybanSelect;
    public String MaHangHoa_NhaCungCap;
    private int flag;
    ThongKeBaoCao_BUS tkbc = new ThongKeBaoCao_BUS();

    public ThongKeMainPanel() {
        initComponents();
        cbbHinhThuc.addItem("Hàng Hóa");
        cbbHinhThuc.addItem("Khách Hàng");
        cbbHinhThuc.addItem("Ngày Bán");
        DateStart.setVisible(false);
        DateEnd.setVisible(false);
        flag = 0;
        lbTitle.setText(cbbType.getSelectedItem() + "-" + cbbHinhThuc.getSelectedItem());
        a = new TableDoanhThuBanHang((String) cbbType.getSelectedItem(), (String) cbbHinhThuc.getSelectedItem(), null, null);
        a.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
        jScrollPane1.setViewportView(a);
        a.addXemChiTiet(new AddXemChiTiet() {
            @Override
            public String Ngayban(String ngayban) {
                ngaybanSelect = ngayban;
                return ngayban;
            }
        });
        DoanhThuBanHang_BieuDo_HangHoa bieudohangHoa = new DoanhThuBanHang_BieuDo_HangHoa();
        // Tao biểu đồ
        setChart(bieudohangHoa, 0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btExcel = new javax.swing.JButton();
        cbbType = new javax.swing.JComboBox<>();
        cbbHinhThuc = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnXem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        DateStart = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        DateEnd = new com.toedter.calendar.JDateChooser();
        lbTitle = new javax.swing.JLabel();
        btnDetail = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1030, 530));

        jPanel5.setPreferredSize(new java.awt.Dimension(1030, 530));

        jPanel4.setBackground(new java.awt.Color(102, 204, 255));

        btExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Logos-Excel-icon.png"))); // NOI18N
        btExcel.setText("Xuất Excel");

        cbbType.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Doanh Thu Bán Hàng", "Lợi Nhuận Bán Hàng", "Chi Phí Nhập Hàng" }));
        cbbType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTypeItemStateChanged(evt);
            }
        });

        cbbHinhThuc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbHinhThuc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbHinhThucItemStateChanged(evt);
            }
        });
        cbbHinhThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbHinhThucActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Hình Thức");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Type");

        btnXem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXem.setText("Xem");
        btnXem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Từ Ngày:");

        DateStart.setDateFormatString("yyyy-MM-dd");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Đến Ngày: ");

        DateEnd.setDateFormatString("yyyy-MM-dd");

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 0, 0));
        lbTitle.setText("jLabel5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(lbTitle))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(DateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        btnDetail.setText("Xem Chi Tiet");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cbbType, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbbHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btExcel)
                .addGap(44, 44, 44)
                .addComponent(btnXem, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXem))
                    .addComponent(cbbHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 102, 153));

        jPanel1.setBackground(new java.awt.Color(204, 255, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGap(37, 37, 37))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbHinhThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbHinhThucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbHinhThucActionPerformed

    private void cbbTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTypeItemStateChanged
        if (cbbType.getSelectedIndex() == 2) {
            cbbHinhThuc.removeAllItems();
            cbbHinhThuc.addItem("Hàng Hóa");
            cbbHinhThuc.addItem("Nhà Cung Cấp");
//            cbbHinhThuc.addItem("Nhà Cung Cấp");

        }
        if (cbbType.getSelectedIndex() == 0) {
            cbbHinhThuc.removeAllItems();
            cbbHinhThuc.addItem("Hàng Hóa");
            cbbHinhThuc.addItem("Khách Hàng");
            cbbHinhThuc.addItem("Ngày Bán");

        }
//            TableBanHang_TheoHangHoa a = new TableBanHang_TheoHangHoa((String) cbbType.getSelectedItem(), (String) cbbHinhThuc.getSelectedItem(), null, null);
//  a.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
//        jScrollPane1.setViewportView(a);
//        }
    }//GEN-LAST:event_cbbTypeItemStateChanged

    private void cbbHinhThucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbHinhThucItemStateChanged
//        if (cbbType.getSelectedIndex() == 0 && cbbHinhThuc.) {
//                TableBanHang_TheoHangHoa a = new TableBanHang_TheoHangHoa((String) cbbType.getSelectedItem(), (String) cbbHinhThuc.getSelectedItem(), null, null);
//         a.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
//        jScrollPane1.setViewportView(a);
        if (cbbType.getSelectedIndex() == 0) {
            if (cbbHinhThuc.getSelectedIndex() == 2) {
//            jScrollPane1.removeAll();
                DateStart.setVisible(true);
                DateEnd.setVisible(true);

            } else if (cbbHinhThuc.getSelectedIndex() == 1) {
                DateStart.setVisible(false);
                DateEnd.setVisible(false);
            } else {
                DateStart.setVisible(false);
                DateEnd.setVisible(false);
            }
        }
        if (cbbType.getSelectedIndex() == 1) {
            if (cbbHinhThuc.getSelectedIndex() == 2) {
//            jScrollPane1.removeAll();
                DateStart.setVisible(true);
                DateEnd.setVisible(true);

            } else if (cbbHinhThuc.getSelectedIndex() == 1) {
                DateStart.setVisible(false);
                DateEnd.setVisible(false);
            } else {
                DateStart.setVisible(false);
                DateEnd.setVisible(false);
            }
        }

//            }
    }//GEN-LAST:event_cbbHinhThucItemStateChanged

    public void setChart(Object ob, int index) {
        jPanel3.removeAll();
        jPanel3.setLayout(new GridLayout());

        if (index == 0) {
            DoanhThuBanHang_BieuDo_HangHoa bieuDo_HangHoa = (DoanhThuBanHang_BieuDo_HangHoa) ob;
            jPanel3.add(bieuDo_HangHoa);
            a.validate();
        }
        if (index == 1) {
            DoanhThuBanHang_BieuDo_KhachHang bieuDo_KhachHang = (DoanhThuBanHang_BieuDo_KhachHang) ob;
            jPanel3.add(bieuDo_KhachHang);
            a.validate();
        }

        jPanel3.repaint();
    }
    private void btnXemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemActionPerformed

        if (cbbType.getSelectedIndex() == 0) {
            if (cbbHinhThuc.getSelectedIndex() == 0) {

                a.init((String) cbbType.getSelectedItem(), (String) cbbHinhThuc.getSelectedItem(), null, null);
                a.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
                jScrollPane1.setViewportView(a);
                flag = 2;
                DoanhThuBanHang_BieuDo_HangHoa bieudohangHoa = new DoanhThuBanHang_BieuDo_HangHoa();
                // Tao biểu đồ
                setChart(bieudohangHoa, 0);
                lbTitle.setText(cbbType.getSelectedItem() + "--" + cbbHinhThuc.getSelectedItem());

            }
            if (cbbHinhThuc.getSelectedIndex() == 1) {
                a.init((String) cbbType.getSelectedItem(), (String) cbbHinhThuc.getSelectedItem(), null, null);
                a.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
                jScrollPane1.setViewportView(a);
                flag = 1;
                lbTitle.setText(cbbType.getSelectedItem() + "--" + cbbHinhThuc.getSelectedItem());
                DoanhThuBanHang_BieuDo_KhachHang bieudo_khachHang = new DoanhThuBanHang_BieuDo_KhachHang();
                setChart(bieudo_khachHang, 1);

//                setChart_KhachHang();
            }
            if (cbbHinhThuc.getSelectedIndex() == 2) {
                if (CheckChooiseDate() == true) {
                    a.init((String) cbbType.getSelectedItem(), (String) cbbHinhThuc.getSelectedItem(), DateStart.getDate(), DateEnd.getDate());
                    a.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
                    jScrollPane1.setViewportView(a);
                    flag = 2;
                    lbTitle.setText(cbbType.getSelectedItem() + "--" + cbbHinhThuc.getSelectedItem());

                }
            }
        }
        if (cbbType.getSelectedIndex() == 1) {
            TableChiPhiNhapHang a = new TableChiPhiNhapHang((String) cbbType.getSelectedItem(), (String) cbbHinhThuc.getSelectedItem());
            a.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
            jScrollPane1.setViewportView(a);
                lbTitle.setText(cbbType.getSelectedItem() + "--" + cbbHinhThuc.getSelectedItem());

//            a.addXemChiTiet(new AddXemChiTiet() {
//                @Override
//                public String Ngayban(String ma) {
//                    MaHangHoa_NhaCungCap = ma;
//                    return MaHangHoa_NhaCungCap;
//                }
//            });
            if (cbbHinhThuc.getSelectedIndex() == 0) {

            }
//            a.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
//            jScrollPane1.setViewportView(a);
        }
//                if (cbbHinhThuc.getSelectedIndex() == 2) {
//                    CheckChooiseDate();
//                    TableBanHang_TheoHangHoa b = new TableBanHang_TheoHangHoa((String) cbbType.getSelectedItem(), (String) cbbHinhThuc.getSelectedItem(), DateStart.getDate(), DateEnd.getDate());
//                    b.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
//                    jScrollPane1.setViewportView(b);
//                }
//            }
//        if (cbbType.getSelectedIndex()==1) {
//                TableBanHang_TheoHangHoa a = new TableBanHang_TheoHangHoa((String) cbbType.getSelectedItem(), (String) cbbHinhThuc.getSelectedItem(), null, null);
//         a.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
//        jScrollPane1.setViewportView(a);
//         }

// TODO add your handling code here:
    }//GEN-LAST:event_btnXemActionPerformed


    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed

        if (cbbType.getSelectedIndex() == 0) {
            if (cbbHinhThuc.getSelectedIndex() == 2 && flag == 2) {
                if (CheckChooiseDate() == true) {
                    System.out.println(ngaybanSelect);
//                    Window win = SwingUtilities.getWindowAncestor(this);
//                    JDialog inforDonHang = new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
//        changePwdDialog.setUndecorated(true);
//          ThongTinDonHang donhang = new ThongTinDonHang(data,this,inforDonHang);
                    JDialog inforDonHang = new JDialog();
                    DoangThuBanHang_Detail_NgayBan detail_NgayBan = new DoangThuBanHang_Detail_NgayBan(ngaybanSelect, inforDonHang);
                    inforDonHang.setSize(626, 488);
                    inforDonHang.setLayout(new GridLayout());
                    inforDonHang.setTitle("Chi Tiet");
                    inforDonHang.add(detail_NgayBan);
                    detail_NgayBan.validate();
                    inforDonHang.setLocationRelativeTo(null);
//                    inforDonHang.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    inforDonHang.setVisible(true);

//                    TableDoanhThuBanHang b = new TableDoanhThuBanHang((String) cbbType.getSelectedItem(), (String) cbbHinhThuc.getSelectedItem(), DateStart.getDate(), DateEnd.getDate());
//                    b.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
//                    jScrollPane1.setViewportView(b);
                }
            }
            if (cbbType.getSelectedIndex() == 0) {
                if (cbbHinhThuc.getSelectedIndex() == 1 && flag == 1) {
//                    Window win = SwingUtilities.getWindowAncestor(this);
//                    JDialog inforDonHang = new JDialog(win, Dialog.ModalityType.APPLICATION_MODAL);
//        changePwdDialog.setUndecorated(true);
//          ThongTinDonHang donhang = new ThongTinDonHang(data,this,inforDonHang);
                    JDialog inforDonHang = new JDialog();
                    DoanhThuBanHang_Detail_KhachHang detail_KhachHang = new DoanhThuBanHang_Detail_KhachHang(ngaybanSelect);
                    inforDonHang.setSize(626, 488);
                    inforDonHang.setLayout(new GridLayout());
                    inforDonHang.setTitle("Chi Tiet");
                    inforDonHang.add(detail_KhachHang);
                    detail_KhachHang.validate();
                    inforDonHang.setLocationRelativeTo(null);
//                    inforDonHang.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    inforDonHang.setVisible(true);

//                    TableDoanhThuBanHang b = new TableDoanhThuBanHang((String) cbbType.getSelectedItem(), (String) cbbHinhThuc.getSelectedItem(), DateStart.getDate(), DateEnd.getDate());
//                    b.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());
//                    jScrollPane1.setViewportView(b);
                }
            }
        }
    }//GEN-LAST:event_btnDetailActionPerformed

    public boolean CheckChooiseDate() {
        Boolean flag = true;
        if (DateStart.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Vui chọn ngày bắt đầu!");
            flag = false;
        }
        if (DateEnd.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Vui chọn ngày kết thúc");
            flag = false;
        }
        return flag;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateEnd;
    private com.toedter.calendar.JDateChooser DateStart;
    private javax.swing.JButton btExcel;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnXem;
    private javax.swing.JComboBox<String> cbbHinhThuc;
    private javax.swing.JComboBox<String> cbbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitle;
    // End of variables declaration//GEN-END:variables
}
