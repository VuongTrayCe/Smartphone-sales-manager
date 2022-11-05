/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.KhuyenMaiComponent;

import Smartphone_sales_management.BUS.QuanLyKhuyenMai_BUS;
import Smartphone_sales_management.BUS.QuanLiSanPham_BUS;
import Smartphone_sales_management.UI.Main.MainFrame;
import Smartphone_sales_management.DTO.Model_ChiTietKM;
import Smartphone_sales_management.DTO.Model_KhuyenMai;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author lehongthai
 */
public class KhuyenMaiGUI extends javax.swing.JPanel {

    QuanLyKhuyenMai_BUS qlkm = new QuanLyKhuyenMai_BUS();
    QuanLiSanPham_BUS qlsp = new QuanLiSanPham_BUS();
    private DefaultTableModel modelKM;
    private DefaultTableModel modelCTKM;
    private ArrayList<String> danhsachkm;
    private ArrayList<String> danhsachsp;
    // = 1 la trang thai them km, 2 la thang trai chinh sua thong tin
    private int stateForm;

    /**
     * Creates new form KhuyenMaiGUI
     */
    public KhuyenMaiGUI(MainFrame mainFrame) {
        initComponents();

        showCTKM();
        showKM();
        danhsachkm = qlkm.getAllKM();
        danhsachsp = qlsp.getAllSP();
        loadDataDSKM();
        loadDataDSSP();
        jLabelXoaKM.setEnabled(false);
        jLabelChinhSuaKM.setEnabled(false);
        jLabelMaKM.setVisible(false);
        jTextMakm.setVisible(false);

    }

    private void showCTKM() {

        modelCTKM = (DefaultTableModel) jTable1.getModel();
        modelCTKM.addColumn("MaChiTietKM");
        modelCTKM.addColumn("MaSP");
        modelCTKM.addColumn("TenSP");
        modelCTKM.addColumn("MaKM");
        modelCTKM.addColumn("TrangThai");
        jTable1.getTableHeader().getColumnModel().setColumnMargin(1);
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15) {
        });
        jTable1.setRowHeight(25);
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setBackground(new Color(14, 14, 14));

        jTable1.setModel(modelCTKM);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTable1.getModel());
        jTable1.setRowSorter(sorter);
        setDefaultTableModelCTKM();

    }

    private void showKM() {
        modelKM = (DefaultTableModel) jTable2.getModel();
        modelKM.addColumn("MaKM");
        modelKM.addColumn("TenKM");
        modelKM.addColumn("PhanTramKM");
        modelKM.addColumn("TrangThai");
        jTable2.getTableHeader().getColumnModel().setColumnMargin(1);
        jTable2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15) {
        });
        jTable2.setRowHeight(25);
        jTable2.getTableHeader().setForeground(Color.WHITE);
        jTable2.getTableHeader().setBackground(new Color(14, 14, 14));

        jTable2.setModel(modelKM);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTable2.getModel());
        jTable2.setRowSorter(sorter);
        setDefaultTableModelKM();
    }

    public void setDefaultTableModelCTKM() {
        jTable1.removeAll();
        modelCTKM.setRowCount(0);
        ArrayList<Model_ChiTietKM> dataList = new ArrayList<Model_ChiTietKM>();
        dataList = qlkm.getDanhSachKMChiTiet();
        for (int i = 0; i < dataList.size(); i++) {
            modelCTKM.addRow(dataList.get(i).toArrayString());
        }
        jScrollChiTietKM.repaint();
    }

    public void setDefaultTableModelKM() {
        jTable2.removeAll();
        modelKM.setRowCount(0);
        ArrayList<Model_KhuyenMai> dataList = new ArrayList<Model_KhuyenMai>();
        dataList = qlkm.getDanhSachKhuyenMai();
        for (int i = 0; i < dataList.size(); i++) {
            modelKM.addRow(dataList.get(i).toArrayString());
        }
        jScrollKM.repaint();
    }

    public void truyendulieuKM(Model_KhuyenMai KhuyenMai) {
        stateForm = 2;
        jTextMakm.setText(Integer.toString(KhuyenMai.getMakm()));
        jTextTenKm.setText(KhuyenMai.getTenkm());
        jTextPtkm.setText(Float.toString(KhuyenMai.getPhantramkm()));

    }

    public void loadDataDSKM() {
        for (String khuyenmai : danhsachkm) {
            jComboBoxMaKM.addItem(khuyenmai);
        }
    }

    public void loadDataDSSP() {
        for (String sanpham : danhsachsp) {
            jComboBoxMaSP.addItem(sanpham);
        }
    }

    public void showdataKM(ArrayList<Model_KhuyenMai> KM) {
        modelKM.setRowCount(0);
        for (int i = 0; i < KM.size(); i++) {
            modelKM.addRow(new String[]{
                Integer.toString(KM.get(i).getMakm()),
                KM.get(i).getTenkm(),
                Float.toString(KM.get(i).getPhantramkm()),
                KM.get(i).getTrangthai(),});
        }
    }

    public void showdataCTKM(ArrayList<Model_ChiTietKM> CTKM) {
        modelCTKM.setRowCount(0);
        for (int i = 0; i < CTKM.size(); i++) {
            modelCTKM.addRow(new String[]{
                Integer.toString(CTKM.get(i).getMachitietkhuyenmai()),
                Integer.toString(CTKM.get(i).getMaSP()),
                CTKM.get(i).getTenSP(),
                Integer.toString(CTKM.get(i).getMaKM()),
                CTKM.get(i).getTrangThai(),});
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanelChiTietKM = new javax.swing.JPanel();
        jScrollChiTietKM = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabelMaCTKM = new javax.swing.JLabel();
        jLabelCTMaSP = new javax.swing.JLabel();
        jLableCTMaKM = new javax.swing.JLabel();
        jTextMaCTKM = new javax.swing.JTextField();
        jComboBoxMaSP = new javax.swing.JComboBox<>();
        jComboBoxMaKM = new javax.swing.JComboBox<>();
        jLabelLamMoiCTKM = new javax.swing.JLabel();
        jLabelUpdateCTKM = new javax.swing.JLabel();
        jLabelThemCTKM = new javax.swing.JLabel();
        jLabelXoaCTKM = new javax.swing.JLabel();
        jPanelKM = new javax.swing.JPanel();
        jScrollKM = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabelMaKM = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextPtkm = new javax.swing.JTextField();
        jTextMakm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextTenKm = new javax.swing.JTextField();
        jLabelLamMoiKM = new javax.swing.JLabel();
        jLabelXoaKM = new javax.swing.JLabel();
        jLabelChinhSuaKM = new javax.swing.JLabel();
        jLabelThemKM = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        rdbTimKiemCTKM = new javax.swing.JRadioButton();
        rdbMakm = new javax.swing.JRadioButton();
        rdbMaCTKM = new javax.swing.JRadioButton();
        rdbTenSP = new javax.swing.JRadioButton();
        jTextTimKiem = new javax.swing.JTextField();
        rdbMaCTKMNC = new javax.swing.JRadioButton();
        rdbMaSPNC = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaCTKMBD = new javax.swing.JTextField();
        txtMaSPBD = new javax.swing.JTextField();
        txtMaSPKT = new javax.swing.JTextField();
        txtMaCTKMKT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLRefesh = new javax.swing.JLabel();
        jLTimKiemCTKM = new javax.swing.JLabel();
        rdbTenKM = new javax.swing.JRadioButton();
        rdbPhanTramkm = new javax.swing.JRadioButton();
        rdbMaKMNC = new javax.swing.JRadioButton();
        txtMaKMDB = new javax.swing.JTextField();
        txtMaKMKT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1030, 509));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(1045, 530));

        jPanelChiTietKM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jScrollChiTietKM.setPreferredSize(new java.awt.Dimension(402, 402));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollChiTietKM.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelMaCTKM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelMaCTKM.setText("Mã CTKM");

        jLabelCTMaSP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelCTMaSP.setText("MaSP");

        jLableCTMaKM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLableCTMaKM.setText("MaKM");

        jTextMaCTKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMaCTKMActionPerformed(evt);
            }
        });

        jLabelLamMoiCTKM.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelLamMoiCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/reset.png"))); // NOI18N
        jLabelLamMoiCTKM.setText("Làm mới");

        jLabelUpdateCTKM.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelUpdateCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/gear.png"))); // NOI18N
        jLabelUpdateCTKM.setText("Chỉnh Sửa");

        jLabelThemCTKM.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelThemCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/plus.png"))); // NOI18N
        jLabelThemCTKM.setText("Thêm");

        jLabelXoaCTKM.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelXoaCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/remove.png"))); // NOI18N
        jLabelXoaCTKM.setText("Xóa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabelLamMoiCTKM)
                        .addGap(43, 43, 43)
                        .addComponent(jLabelUpdateCTKM))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelMaCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextMaCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabelCTMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxMaSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelThemCTKM)
                        .addGap(35, 35, 35)
                        .addComponent(jLabelXoaCTKM))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLableCTMaKM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxMaKM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMaCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMaCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCTMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLableCTMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLamMoiCTKM)
                    .addComponent(jLabelUpdateCTKM)
                    .addComponent(jLabelThemCTKM)
                    .addComponent(jLabelXoaCTKM))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanelChiTietKMLayout = new javax.swing.GroupLayout(jPanelChiTietKM);
        jPanelChiTietKM.setLayout(jPanelChiTietKMLayout);
        jPanelChiTietKMLayout.setHorizontalGroup(
            jPanelChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollChiTietKM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelChiTietKMLayout.setVerticalGroup(
            jPanelChiTietKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChiTietKMLayout.createSequentialGroup()
                .addComponent(jScrollChiTietKM, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelKM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jScrollKM.setPreferredSize(new java.awt.Dimension(402, 402));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollKM.setViewportView(jTable2);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(530, 154));

        jLabelMaKM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelMaKM.setText("MaKM");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("PhanTramKM");

        jTextPtkm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPtkmActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("TenKM");

        jTextTenKm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTenKmActionPerformed(evt);
            }
        });

        jLabelLamMoiKM.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelLamMoiKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/reset.png"))); // NOI18N
        jLabelLamMoiKM.setText("Làm mới");
        jLabelLamMoiKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLamMoiKMMouseClicked(evt);
            }
        });

        jLabelXoaKM.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelXoaKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/remove.png"))); // NOI18N
        jLabelXoaKM.setText("Xóa");
        jLabelXoaKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelXoaKMMouseClicked(evt);
            }
        });

        jLabelChinhSuaKM.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelChinhSuaKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/gear.png"))); // NOI18N
        jLabelChinhSuaKM.setText("Chỉnh sửa");
        jLabelChinhSuaKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelChinhSuaKMMouseClicked(evt);
            }
        });

        jLabelThemKM.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelThemKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/plus.png"))); // NOI18N
        jLabelThemKM.setText("Thêm");
        jLabelThemKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelThemKMMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextMakm, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextTenKm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabelLamMoiKM)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelChinhSuaKM)
                        .addGap(27, 27, 27)
                        .addComponent(jLabelThemKM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelXoaKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextPtkm))
                .addGap(7, 7, 7))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMakm, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTenKm, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextPtkm, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChinhSuaKM)
                    .addComponent(jLabelLamMoiKM)
                    .addComponent(jLabelThemKM)
                    .addComponent(jLabelXoaKM))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanelKMLayout = new javax.swing.GroupLayout(jPanelKM);
        jPanelKM.setLayout(jPanelKMLayout);
        jPanelKMLayout.setHorizontalGroup(
            jPanelKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
            .addComponent(jScrollKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelKMLayout.setVerticalGroup(
            jPanelKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKMLayout.createSequentialGroup()
                .addComponent(jScrollKM, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "ÁP DỤNG KHUYẾN MÃI", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18))); // NOI18N

        buttonGroup1.add(rdbTimKiemCTKM);
        rdbTimKiemCTKM.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        rdbTimKiemCTKM.setText("Nhập từ khóa tìm kiếm ");

        buttonGroup2.add(rdbMakm);
        rdbMakm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdbMakm.setText("Mã KM");

        buttonGroup2.add(rdbMaCTKM);
        rdbMaCTKM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdbMaCTKM.setText("Mã chi tiết KM");

        buttonGroup2.add(rdbTenSP);
        rdbTenSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdbTenSP.setText("Tên SP");

        buttonGroup1.add(rdbMaCTKMNC);

        buttonGroup1.add(rdbMaSPNC);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mã chi tiết KM từ :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Mã sản phẩm từ :");

        txtMaCTKMBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaCTKMBDActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("đến");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("đến");

        jLRefesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Goback.png"))); // NOI18N
        jLRefesh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLRefeshMouseClicked(evt);
            }
        });

        jLTimKiemCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/search.png"))); // NOI18N
        jLTimKiemCTKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLTimKiemCTKMMouseClicked(evt);
            }
        });

        buttonGroup2.add(rdbTenKM);
        rdbTenKM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdbTenKM.setText("Tên KM");

        buttonGroup2.add(rdbPhanTramkm);
        rdbPhanTramkm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rdbPhanTramkm.setText("Phần trăm KM");

        buttonGroup1.add(rdbMaKMNC);
        rdbMaKMNC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("đến");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Mã KM từ :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(rdbMaCTKMNC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(19, 19, 19)
                        .addComponent(txtMaCTKMBD)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(25, 25, 25)
                        .addComponent(txtMaCTKMKT)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(rdbTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(rdbMakm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51)
                        .addComponent(rdbPhanTramkm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(215, 215, 215))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(rdbMaKMNC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaKMDB)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLTimKiemCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLRefesh)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtMaKMKT)
                                .addGap(114, 114, 114))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(rdbTimKiemCTKM)
                .addGap(55, 55, 55)
                .addComponent(jTextTimKiem)
                .addGap(332, 332, 332))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(rdbMaSPNC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaSPBD)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel7)
                        .addGap(32, 32, 32)
                        .addComponent(txtMaSPKT)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(rdbMaCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(54, 54, 54)
                        .addComponent(rdbTenKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(348, 348, 348)))
                .addGap(268, 268, 268))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdbTimKiemCTKM))
                        .addGap(5, 5, 5))
                    .addComponent(jLRefesh)
                    .addComponent(jLTimKiemCTKM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbTenKM, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbPhanTramkm)
                        .addComponent(rdbMakm)
                        .addComponent(rdbTenSP)
                        .addComponent(rdbMaCTKM)))
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbMaKMNC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbMaCTKMNC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaCTKMKT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaCTKMBD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtMaKMKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaKMDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSPBD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbMaSPNC)
                            .addComponent(txtMaSPKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanelChiTietKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelChiTietKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        jPanel4.getAccessibleContext().setAccessibleName("Tìm Kiếm Chi Tiết KM\n");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextMaCTKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMaCTKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMaCTKMActionPerformed

    private void jTextTenKmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTenKmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTenKmActionPerformed

    private void jTextPtkmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPtkmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPtkmActionPerformed

    private void jLabelLamMoiKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLamMoiKMMouseClicked
        jLabelXoaKM.setEnabled(false);
        jLabelChinhSuaKM.setEnabled(false);
        jLabelThemKM.setEnabled(true);
        jTextMakm.setText("");
        jTextPtkm.setText("");
        jTextTenKm.setText("");
    }//GEN-LAST:event_jLabelLamMoiKMMouseClicked

    private void jLabelChinhSuaKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelChinhSuaKMMouseClicked
        if (stateForm != 2) {
            JOptionPane.showMessageDialog(jLabelChinhSuaKM, "Vui lòng chọn 1 dòng dữ liệu trên bảng khuyến mãi để có thể tiến hành chỉnh sửa thông tin dữ liêu");
            return;
        }
        String makm = jTextMakm.getText();
        String tenkm = jTextTenKm.getText();
        String ptkm = jTextPtkm.getText();
        if (tenkm.length() <= 0) {
            JOptionPane.showMessageDialog(jTextMakm, "Bạn vui lòng nhập dữ liệu tên khuyến mãi");
            return;
        }
        QuanLyKhuyenMai_BUS qlkm = new QuanLyKhuyenMai_BUS();
        Model_KhuyenMai KhuyenMai = new Model_KhuyenMai();
        KhuyenMai.setMakm(Integer.parseInt(makm));
        KhuyenMai.setTenkm(tenkm);
        KhuyenMai.setPhantramkm(Float.parseFloat(ptkm));
        KhuyenMai.setTrangthai("T");

        qlkm.updateKhuyenMai(KhuyenMai);
        setDefaultTableModelKM();
        jTextMakm.setText("");
        jTextTenKm.setText("");
        jTextPtkm.setText("");
    }//GEN-LAST:event_jLabelChinhSuaKMMouseClicked

    private void jLabelThemKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelThemKMMouseClicked

        String tenkm = jTextTenKm.getText();
        String phantramkm = jTextPtkm.getText();

        QuanLyKhuyenMai_BUS qlkm = new QuanLyKhuyenMai_BUS();
        Model_KhuyenMai KhuyenMai = new Model_KhuyenMai();

        if (tenkm.length() <= 0) {
            JOptionPane.showMessageDialog(jTextMakm, "Bạn vui lòng nhập dữ liệu tên khuyến mãi");
            return;
        }

        KhuyenMai.setTenkm(tenkm);
        KhuyenMai.setPhantramkm(Float.parseFloat(phantramkm));
        KhuyenMai.setTrangthai("T");

        qlkm.Addkhuyenmai(KhuyenMai);
        setDefaultTableModelKM();
        jTextMakm.setText("");
        jTextTenKm.setText("");
        jTextPtkm.setText("");
    }//GEN-LAST:event_jLabelThemKMMouseClicked

    private void jLabelXoaKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelXoaKMMouseClicked
        if (stateForm != 2) {
            JOptionPane.showMessageDialog(jLabelXoaKM, "Vui lòng chọn 1 dòng dữ liệu trên bảng khuyến mãi để có thể tiến hành chỉnh sửa thông tin dữ liêu");
            return;
        }
        String makm = jTextMakm.getText();
        if (makm.length() > 0) {
            qlkm.deleteKhuyenMai(Integer.parseInt(jTextMakm.getText()));
            setDefaultTableModelKM();
        }
        jTextMakm.setText("");
        jTextTenKm.setText("");
        jTextPtkm.setText("");
    }//GEN-LAST:event_jLabelXoaKMMouseClicked

    private void txtMaCTKMBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaCTKMBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaCTKMBDActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        jLabelXoaKM.setEnabled(true);
        jLabelChinhSuaKM.setEnabled(true);
        jLabelThemKM.setEnabled(false);
        int index = jTable2.getSelectedRow();
        Model_KhuyenMai KhuyenMai = new Model_KhuyenMai();
        TableModel modelKM = jTable2.getModel();
        String makm = modelKM.getValueAt(index, 0).toString();
        String tenkm = modelKM.getValueAt(index, 1).toString();
        String ptkm = modelKM.getValueAt(index, 2).toString();
        KhuyenMai.setMakm(Integer.parseInt(makm));
        KhuyenMai.setTenkm(tenkm);
        KhuyenMai.setPhantramkm(Float.parseFloat(ptkm));
        truyendulieuKM(KhuyenMai);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jLTimKiemCTKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLTimKiemCTKMMouseClicked
        if (rdbTimKiemCTKM.isSelected() == false && rdbMaCTKMNC.isSelected() == false && rdbMaSPNC.isSelected() == false && rdbMaKMNC.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn trường hợp cần tìm", "THÔNG BÁO", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (rdbTimKiemCTKM.isSelected()) {
            if (jTextTimKiem.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin cần tìm kiếm", "THÔNG BÁO", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                if (rdbMaCTKM.isSelected() == false && rdbTenKM.isSelected() == false && rdbTenSP.isSelected() == false && rdbMakm.isSelected() == false && rdbPhanTramkm.isSelected() == false) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn trường hợp cần tìm", "THÔNG BÁO", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (rdbMaCTKM.isSelected()) {
                    ArrayList<Model_ChiTietKM> dsctkm = qlkm.timKiemTheoMaCTKM(jTextTimKiem.getText());
                    showdataCTKM(dsctkm);
                }
                if (rdbTenKM.isSelected()) {
                    ArrayList<Model_KhuyenMai> dskm = qlkm.timKiemTheoTenKM(jTextTimKiem.getText());
                    showdataKM(dskm);
                }
                if (rdbTenSP.isSelected()) {
                    ArrayList<Model_ChiTietKM> dsctkm = qlkm.timKiemTheoTenSP(jTextTimKiem.getText());
                    showdataCTKM(dsctkm);
                }
                if (rdbMakm.isSelected()) {
                    ArrayList<Model_KhuyenMai> dskm = qlkm.timKiemTheoMaKM(jTextTimKiem.getText());
                    showdataKM(dskm);
                }
                if (rdbPhanTramkm.isSelected()) {
                    ArrayList<Model_KhuyenMai> dskm = qlkm.timKiemTheoPhanTramKM(jTextTimKiem.getText());
                    showdataKM(dskm);
                }
            }
        }

        if (rdbMaCTKMNC.isSelected()) {
            if (txtMaCTKMBD.getText().equals("") && txtMaCTKMKT.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Không được bỏ trống thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                Pattern p = Pattern.compile("^[0-9]+$");
                if (p.matcher(txtMaCTKMBD.getText()).find() && p.matcher(txtMaCTKMKT.getText()).find()) {
                    ArrayList<Model_ChiTietKM> dsctkm = qlkm.timKiemMaCTKMNangCao(txtMaCTKMBD.getText(), txtMaCTKMKT.getText());
                    showdataCTKM(dsctkm);
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn phải nhập vào kiểu Int cho MaCTKM", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }

        if (rdbMaKMNC.isSelected()) {
            if (txtMaKMDB.getText().equals("") && txtMaKMKT.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Không được  bỏ trống thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;

            } else {
                Pattern p = Pattern.compile("^[0-9]+$");
                if (p.matcher(txtMaKMDB.getText()).find() && p.matcher(txtMaKMKT.getText()).find()) {
                    ArrayList<Model_KhuyenMai> dskm = qlkm.timKiemMaKmNangCao(txtMaKMDB.getText(), txtMaKMKT.getText());
                    showdataKM(dskm);
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn phải nhập vào kiểu Int cho MaKM", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
        if (rdbMaSPNC.isSelected()) {
            if (txtMaSPBD.getText().equals("") && txtMaSPKT.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Không được  bỏ trống thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                Pattern p = Pattern.compile("^[0-9]+$");
                if (p.matcher(txtMaSPBD.getText()).find() && p.matcher(txtMaSPKT.getText()).find()) {
                    ArrayList<Model_ChiTietKM> dsctkm = qlkm.timKiemMaspNangCao(txtMaSPBD.getText(), txtMaSPKT.getText());
                    showdataCTKM(dsctkm);
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn phải nhập vào kiểu Int cho MaSP", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
        }


    }//GEN-LAST:event_jLTimKiemCTKMMouseClicked

    private void jLRefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLRefeshMouseClicked
        txtMaCTKMBD.setText("");
        txtMaCTKMKT.setText("");
        txtMaKMDB.setText("");
        txtMaKMKT.setText("");
        txtMaSPBD.setText("");
        txtMaSPKT.setText("");
        setDefaultTableModelKM();
        setDefaultTableModelCTKM();
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
    }//GEN-LAST:event_jLRefeshMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> jComboBoxMaKM;
    private javax.swing.JComboBox<String> jComboBoxMaSP;
    private javax.swing.JLabel jLRefesh;
    private javax.swing.JLabel jLTimKiemCTKM;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCTMaSP;
    private javax.swing.JLabel jLabelChinhSuaKM;
    private javax.swing.JLabel jLabelLamMoiCTKM;
    private javax.swing.JLabel jLabelLamMoiKM;
    private javax.swing.JLabel jLabelMaCTKM;
    private javax.swing.JLabel jLabelMaKM;
    private javax.swing.JLabel jLabelThemCTKM;
    private javax.swing.JLabel jLabelThemKM;
    private javax.swing.JLabel jLabelUpdateCTKM;
    private javax.swing.JLabel jLabelXoaCTKM;
    private javax.swing.JLabel jLabelXoaKM;
    private javax.swing.JLabel jLableCTMaKM;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelChiTietKM;
    private javax.swing.JPanel jPanelKM;
    private javax.swing.JScrollPane jScrollChiTietKM;
    private javax.swing.JScrollPane jScrollKM;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextMaCTKM;
    private javax.swing.JTextField jTextMakm;
    private javax.swing.JTextField jTextPtkm;
    private javax.swing.JTextField jTextTenKm;
    private javax.swing.JTextField jTextTimKiem;
    private javax.swing.JRadioButton rdbMaCTKM;
    private javax.swing.JRadioButton rdbMaCTKMNC;
    private javax.swing.JRadioButton rdbMaKMNC;
    private javax.swing.JRadioButton rdbMaSPNC;
    private javax.swing.JRadioButton rdbMakm;
    private javax.swing.JRadioButton rdbPhanTramkm;
    private javax.swing.JRadioButton rdbTenKM;
    private javax.swing.JRadioButton rdbTenSP;
    private javax.swing.JRadioButton rdbTimKiemCTKM;
    private javax.swing.JTextField txtMaCTKMBD;
    private javax.swing.JTextField txtMaCTKMKT;
    private javax.swing.JTextField txtMaKMDB;
    private javax.swing.JTextField txtMaKMKT;
    private javax.swing.JTextField txtMaSPBD;
    private javax.swing.JTextField txtMaSPKT;
    // End of variables declaration//GEN-END:variables
}
