/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.BaoHanhComponent;

import Smartphone_sales_management.BUS.QuanLiBaoHanh_BUS;
import Smartphone_sales_management.BUS.QuanLiSanPham_BUS;
import Smartphone_sales_management.DTO.ModelBaoHanh;
import Smartphone_sales_management.UI.Component.PhieuNhap.RoundedBorderer;
import Smartphone_sales_management.UI.Event.BaoHanh.EventBaoHanh;
import Smartphone_sales_management.UI.Main.MainFrame;
import Smartphone_sales_management.UI.Swing.GraphicsPanel;
import Smartphone_sales_management.UI.Swing.GraphicsTextFied;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class MainContentBaoHanh extends javax.swing.JPanel {

    DefaultTableModel modelbh = new DefaultTableModel();
    DefaultTableModel modelctbh = new DefaultTableModel();
    DefaultComboBoxModel<String> modelcbbBH = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> modelcbbSP = new DefaultComboBoxModel<>();
    QuanLiBaoHanh_BUS qlbh_BUS = new QuanLiBaoHanh_BUS();
    QuanLiSanPham_BUS qlsp_BUS = new QuanLiSanPham_BUS();
    public int mabh = -1;
    public int mactbh = -1;
    MainFrame mainframe;
    JPanel panelcenter;

    public MainContentBaoHanh(MainFrame mainFrame, JPanel panel) {
        initComponents();
        this.mainframe = mainFrame;
        this.panelcenter = panel;
        setColumnModelBH();
        setColumnModelCTBH();
        setDefaultTableBaoHanh();
        setDefaultTableCTBH();
        tablebh.setModel(modelbh);
        tablectbh.setModel(modelctbh);
        cbbbh.setModel(modelcbbBH);
        cbbsp.setModel(modelcbbSP);
        btnThemCT.setBorder(new RoundedBorderer(new Color(255, 255, 255), 2, 30));
        btnDeleteCTSP.setBorder(new RoundedBorderer(new Color(255, 255, 255), 2, 30));
        jButton1.setBorder(new RoundedBorderer(new Color(255,255,255), 2, 30));

    }

    public void setColumnModelBH() {
        modelbh.addColumn("Mã bảo hành");
        modelbh.addColumn("Thời gian bảo hành");
        modelbh.addColumn("Trạng Thái");
        tablebh.setOpaque(false);
        tablebh.getTableHeader().getColumnModel().setColumnMargin(1);
        tablebh.getTableHeader().setFont(new Font("Arial", Font.BOLD, 17));
        tablebh.getTableHeader().setForeground(Color.WHITE);
        tablebh.getTableHeader().setBackground(new Color(14, 14, 14));
    }

    public void setColumnModelCTBH() {
        modelctbh.addColumn("Mã Chi tiết bảo hành");
        modelctbh.addColumn("Mã Bảo Hành");
        modelctbh.addColumn("Mã sản phẩm");
        tablectbh.setOpaque(false);
        tablectbh.getTableHeader().getColumnModel().setColumnMargin(1);
        tablectbh.getTableHeader().setFont(new Font("Arial", Font.BOLD, 17));
        tablectbh.getTableHeader().setForeground(Color.WHITE);
        tablectbh.getTableHeader().setBackground(new Color(14, 14, 14));
    }

    public void setDefaultTableBaoHanh() {
        tablebh.removeAll();
        modelbh.setRowCount(0);
        ArrayList dsbh = new ArrayList();
        dsbh = qlbh_BUS.layDSBH_BUS();
        for (int i = 0; i < dsbh.size(); i++) {
            modelbh.addRow((Vector<?>) dsbh.get(i));
        }
        for (Object x : dsbh) {
            Vector y = (Vector) x;
            String Mabh = y.get(0).toString();
            modelcbbBH.addElement(Mabh);
        }
        addEventTableBaoHanh();
        jscrollbh.repaint();
    }

    public void setDefaultTableCTBH() {
        tablectbh.removeAll();
        modelctbh.setRowCount(0);
        ArrayList dsctbh = new ArrayList();
        ArrayList dsMasp = new ArrayList();
        dsctbh = qlbh_BUS.layDSCTBH_BUS();
        dsMasp = qlbh_BUS.dsMasp();
        for (Object x : dsMasp) {
            modelcbbSP.addElement(x.toString());
        }
        for (int i = 0; i < dsctbh.size(); i++) {
            modelctbh.addRow((Vector<?>) dsctbh.get(i));
        }
        jscrollctbh.repaint();
    }

    public void addEventTableBaoHanh() {
        tablebh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ArrayList ctbh = new ArrayList();
                System.out.println(tablebh.getValueAt(tablebh.getSelectedRow(), 0));
                mabh = (int) tablebh.getValueAt(tablebh.getSelectedRow(), 0);
                ctbh = qlbh_BUS.layctbh(mabh);
                txttgbh.setText(ctbh.get(0).toString());
                txttrangthai.setText(ctbh.get(1).toString());
            }
        });
    }
//    public void addEventTableCTBaoHanh() {
//        tablectbh.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                ArrayList ctbh = new ArrayList();
//                System.out.println(tablectbh.getValueAt(tablectbh.getSelectedRow(), 0));
//                mactbh=(int)tablectbh.getValueAt(tablebh.getSelectedRow(), 0);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField4 = new GraphicsTextFied(15);
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jscrollctbh = new javax.swing.JScrollPane();
        tablectbh = new javax.swing.JTable();
        jPanel3 = new GraphicsPanel(50,new Color(0,0,0));
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnThemCT = new javax.swing.JButton();
        btnDeleteCTSP = new javax.swing.JButton();
        cbbbh = new javax.swing.JComboBox<>();
        cbbsp = new javax.swing.JComboBox<>();
        jscrollbh = new javax.swing.JScrollPane();
        tablebh = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txttgbh = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnThemBH = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        txttrangthai = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("||  Bảo Hành");

        jTextField4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jComboBox3.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", " " }));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thông Tin Bảo Hành");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tablectbh.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tablectbh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablectbh.setGridColor(new java.awt.Color(255, 255, 255));
        tablectbh.setRowHeight(35);
        tablectbh.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tablectbh.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablectbh.setShowGrid(true);
        jscrollctbh.setViewportView(tablectbh);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Chi tiết bảo hành");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã bảo hành");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mã sp");

        btnThemCT.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnThemCT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/sign-add-icon (1).png"))); // NOI18N
        btnThemCT.setText("Thêm");
        btnThemCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemCTMouseClicked(evt);
            }
        });
        btnThemCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTActionPerformed(evt);
            }
        });

        btnDeleteCTSP.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnDeleteCTSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/remove.png"))); // NOI18N
        btnDeleteCTSP.setText("Xóa");
        btnDeleteCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteCTSPMouseClicked(evt);
            }
        });

        cbbbh.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        cbbsp.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnThemCT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(cbbbh, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(cbbsp, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(115, 115, 115))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnDeleteCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbbh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(cbbsp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemCT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        tablebh.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tablebh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablebh.setGridColor(new java.awt.Color(255, 255, 255));
        tablebh.setRowHeight(35);
        tablebh.setSelectionBackground(new java.awt.Color(255, 0, 51));
        tablebh.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablebh.setShowGrid(true);
        jscrollbh.setViewportView(tablebh);

        jLabel9.setFont(new java.awt.Font("Arial", 3, 25)); // NOI18N
        jLabel9.setText("Danh sách chi tiết bảo hành");

        jLabel10.setFont(new java.awt.Font("Arial", 3, 25)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Danh sách bảo hành");

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Bảo hành");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Thời gian bảo hành");

        txttgbh.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txttgbh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttgbhActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Trạng Thái");

        btnThemBH.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnThemBH.setForeground(new java.awt.Color(255, 255, 255));
        btnThemBH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/sign-add-icon (1).png"))); // NOI18N
        btnThemBH.setText("Thêm bảo hành");
        btnThemBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemBHMouseClicked(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/remove.png"))); // NOI18N
        btnDelete.setText("Xóa bảo hành");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/fix.png"))); // NOI18N
        btnUpdate.setText("Sửa bảo hành");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Clear-icon.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });

        txttrangthai.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txttrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttrangthaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttgbh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttrangthai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDelete)
                                    .addComponent(btnReset))
                                .addGap(14, 14, 14))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(btnThemBH)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel12)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttgbh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txttrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemBH)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jscrollctbh, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jscrollbh)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jscrollbh, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jscrollctbh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void txttgbhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttgbhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttgbhActionPerformed

    private void txttrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttrangthaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttrangthaiActionPerformed

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        txttgbh.setText("");
        txttrangthai.setText("");
    }//GEN-LAST:event_btnResetMouseClicked
    private boolean checkData() {
        if (!txttgbh.getText().equals("") && !txttrangthai.getText().equals("")) {
            return true;
        }
        return false;
    }
    private void btnThemBHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemBHMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm bảo hành ?", "Thêm bảo hành", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.OK_OPTION) {
            if (checkData()) {
                ModelBaoHanh model = new ModelBaoHanh();
                model.setThoigianbh(txttgbh.getText());
                model.setTrangthai(txttrangthai.getText());
                if (qlbh_BUS.themBH(model)) {
                    JOptionPane.showMessageDialog(null, "Thêm thành công!");
                    setDefaultTableBaoHanh();
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm thất bại!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Mời điền đầy đủ thông tin");
            }
        }
    }//GEN-LAST:event_btnThemBHMouseClicked
    private boolean checkMabh() {
        if (mabh != -1) {
            return true;
        }
        return false;
    }
    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa bảo hành ?", "Xóa bảo hành", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.OK_OPTION) {
            if (checkMabh()) {
                if (qlbh_BUS.xoaBH(mabh)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                    setDefaultTableBaoHanh();
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chưa chọn Mã bảo hành");
            }
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa bảo hành ?", "sửa bảo hành", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.OK_OPTION) {
            if (checkMabh()) {
                if (checkData()) {
                    ModelBaoHanh model = new ModelBaoHanh();
                    model.setMabh(mabh);
                    model.setThoigianbh(txttgbh.getText());
                    model.setTrangthai(txttrangthai.getText());
                    if (qlbh_BUS.suaBH(model)) {
                        JOptionPane.showMessageDialog(null, "Sửa thành công!");
                        setDefaultTableBaoHanh();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sửa thất bại!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chưa chọn mã cần sửa");
            }
        }
    }//GEN-LAST:event_btnUpdateMouseClicked
    private boolean checkMasp() {
        ArrayList dssp = new ArrayList();
        dssp = qlbh_BUS.layDSCTBH_BUS();
        for (Object x : dssp) {
            Vector y = (Vector) x;
            String Masp = y.get(2).toString();
            if (Masp.equals(cbbsp.getSelectedItem().toString())) {
                return false;
            }
        }
        return true;
    }
    private void btnThemCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemCTMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm bảo hành ?", "Thêm bảo hành", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.OK_OPTION) {
            if (checkMasp()) {
                ModelBaoHanh model = new ModelBaoHanh();
                model.setMabh(Integer.parseInt(cbbbh.getSelectedItem().toString()));
                model.setMasp(Integer.parseInt(cbbsp.getSelectedItem().toString()));
                if (qlbh_BUS.themCTBH(model)) {
                    JOptionPane.showMessageDialog(null, "Thêm thành công!");
                    setDefaultTableCTBH();
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm không thành công!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Trùng sản phẩm!");
            }
        }
    }//GEN-LAST:event_btnThemCTMouseClicked
    private boolean checkCoMaChiTiet() {
        if (mactbh != -1) {
            return true;
        }
        return false;
    }
    private void btnDeleteCTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteCTSPMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa bảo hành ?", "Xóa bảo hành", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.OK_OPTION) {
            if (checkMasp()) {
                JOptionPane.showMessageDialog(null, "Mã sản phẩm chưa áp dụng");
            } else {
                ModelBaoHanh model = new ModelBaoHanh();
                model.setMabh(Integer.parseInt(cbbbh.getSelectedItem().toString()));
                model.setMasp(Integer.parseInt(cbbsp.getSelectedItem().toString()));
                mactbh = qlbh_BUS.layMactbh(model);
                if (checkCoMaChiTiet()) {
                    if (qlbh_BUS.xoaCTBH(mactbh)) {
                        JOptionPane.showMessageDialog(null, "Xóa thành công!");
                        mactbh = -1;
                        setDefaultTableCTBH();
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bảo hành không hợp lệ!");
                }
            }

        }
    }//GEN-LAST:event_btnDeleteCTSPMouseClicked

    private void btnThemCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemCTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PanelThongTinBaoHanh a = new PanelThongTinBaoHanh(mainframe, panelcenter);
        jPanel1.removeAll();
        a.setBounds(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        jPanel1.setLayout(new GridLayout());
        jPanel1.add(a);
        a.validate();

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDelete;
    private javax.swing.JButton btnDeleteCTSP;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnThemBH;
    private javax.swing.JButton btnThemCT;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JComboBox<String> cbbbh;
    private javax.swing.JComboBox<String> cbbsp;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JScrollPane jscrollbh;
    private javax.swing.JScrollPane jscrollctbh;
    private javax.swing.JTable tablebh;
    private javax.swing.JTable tablectbh;
    private javax.swing.JTextField txttgbh;
    private javax.swing.JTextField txttrangthai;
    // End of variables declaration//GEN-END:variables
}
