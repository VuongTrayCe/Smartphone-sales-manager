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
import javax.swing.JLabel;
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
    private DefaultTableCellRenderer cellRenderer;

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
        jTextMaCTKM.setVisible(false);
        jLabelMaCTKM.setVisible(false);
    }

    private void showCTKM() {

        modelCTKM = (DefaultTableModel) jTable1.getModel();
        modelCTKM.addColumn("Mã chi tiết khuyến mãi");
        modelCTKM.addColumn("Mã sản phẩm");
        modelCTKM.addColumn("Tên sản phẩm");
        modelCTKM.addColumn("Mã khuyến mãi");
//        modelCTKM.addColumn("TrangThai");
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
        
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(130);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(2).setMinWidth(140);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);

        cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        jTable1.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);

    }

    private void showKM() {
        modelKM = (DefaultTableModel) jTable2.getModel();
        modelKM.addColumn("Mã khuyến mãi");
        modelKM.addColumn("Tên khuyến mãi");
        modelKM.addColumn("Phần trăm khuyến mãi");
//        modelKM.addColumn("TrangThai");
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
          jTable2.getColumnModel().getColumn(0).setPreferredWidth(110);
        jTable2.getColumnModel().getColumn(1).setMinWidth(130);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(150);

        cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTable2.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
        jTable2.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        jTable2.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
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
    public void truyendualieuCTKM(Model_ChiTietKM ChiTietKM){
        stateForm = 2;
        jTextMaCTKM.setText(Integer.toString(ChiTietKM.getMachitietkhuyenmai()));
        jComboBoxMaSP.setSelectedItem(Integer.toString(ChiTietKM.getMaSP()));
        jComboBoxMaKM.setSelectedItem(Integer.toString(ChiTietKM.getMaKM()));
        
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
        jTextTimKiem = new javax.swing.JTextField();
        jLTimKiemCTKM = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1030, 509));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1045, 530));

        jPanelChiTietKM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jScrollChiTietKM.setPreferredSize(new java.awt.Dimension(402, 402));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
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

        jLabelThemCTKM.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelThemCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/plus.png"))); // NOI18N
        jLabelThemCTKM.setText("Thêm");
        jLabelThemCTKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelThemCTKMMouseClicked(evt);
            }
        });

        jLabelXoaCTKM.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabelXoaCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/remove.png"))); // NOI18N
        jLabelXoaCTKM.setText("Xóa");
        jLabelXoaCTKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelXoaCTKMMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelThemCTKM)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelXoaCTKM))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelMaCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextMaCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCTMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxMaSP, 0, 131, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addComponent(jLableCTMaKM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxMaKM, 0, 132, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMaCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMaCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCTMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLableCTMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelThemCTKM)
                    .addComponent(jLabelXoaCTKM))
                .addGap(15, 15, 15))
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
                .addComponent(jScrollKM, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "ÁP DỤNG KHUYẾN MÃI", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18))); // NOI18N

        jLTimKiemCTKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/search.png"))); // NOI18N
        jLTimKiemCTKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLTimKiemCTKMMouseClicked(evt);
            }
        });

        jComboBox.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KM", "CTKM" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTextTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLTimKiemCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTimKiemCTKM, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách khuyến mãi");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Danh sách chi tiết khuyến mãi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanelChiTietKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
                .addGap(3, 3, 3))
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
         Pattern p = Pattern.compile("[a-z]");
                if (p.matcher(jTextPtkm.getText()).find()){
            JOptionPane.showMessageDialog(jTextPtkm,"Bạn  nhập sai định dạng phần trăm KM ");
            return;
        }
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
         int a = JOptionPane.showConfirmDialog(null, "Bạn muốn chỉnh sửa không ?","Chỉnh sửa thông tin Khuyến Mãi", JOptionPane.YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION) {
        qlkm.updateKhuyenMai(KhuyenMai);
        setDefaultTableModelKM();
        jTextTenKm.setText("");
        jTextPtkm.setText("");
        }
    }//GEN-LAST:event_jLabelChinhSuaKMMouseClicked

    private void jLabelThemKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelThemKMMouseClicked

        String tenkm = jTextTenKm.getText();
        String phantramkm = jTextPtkm.getText();
        
        Pattern p = Pattern.compile("[a-z]");
                if (p.matcher(jTextPtkm.getText()).find()){
            JOptionPane.showMessageDialog(jTextPtkm,"Bạn  nhập sai định dạng phần trăm KM ");
            return;
        }
        if (tenkm.length() <= 0) {
            JOptionPane.showMessageDialog(jTextTenKm, "Bạn vui lòng nhập dữ liệu tên khuyến mãi");
            return;
        }
       
         if (phantramkm.length() <= 0) {
            JOptionPane.showMessageDialog(jTextPtkm, "Bạn vui lòng nhập dữ liệu phần trăm khuyến mãi");
            return;
        }

         QuanLyKhuyenMai_BUS qlkm = new QuanLyKhuyenMai_BUS();
        Model_KhuyenMai KhuyenMai = new Model_KhuyenMai();
        KhuyenMai.setTenkm(tenkm);
       
        KhuyenMai.setPhantramkm(Float.parseFloat(phantramkm));
        KhuyenMai.setTrangthai("T");
          int a = JOptionPane.showConfirmDialog(null, "Bạn muốn thêm không ?","Thêm Khuyến Mãi", JOptionPane.YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION) {
        qlkm.Addkhuyenmai(KhuyenMai);
        setDefaultTableModelKM();
        jTextTenKm.setText("");
        jTextPtkm.setText("");
        }
    }//GEN-LAST:event_jLabelThemKMMouseClicked

    private void jLabelXoaKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelXoaKMMouseClicked
        if (stateForm != 2) {
            JOptionPane.showMessageDialog(jLabelXoaKM, "Vui lòng chọn 1 dòng dữ liệu trên bảng khuyến mãi để có thể tiến hành chỉnh sửa thông tin dữ liêu");
            return;
        }
        String makm = jTextMakm.getText();
        QuanLyKhuyenMai_BUS qlkm = new QuanLyKhuyenMai_BUS();
        Model_KhuyenMai KhuyenMai = new Model_KhuyenMai();
        KhuyenMai.setMakm(Integer.parseInt(makm));
        KhuyenMai.setTrangthai("F");
        int a = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa không ?","DELETE Khuyến Mãi", JOptionPane.YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION) {
        qlkm.deleteKhuyenMai(KhuyenMai);
        setDefaultTableModelKM();
        jTextMakm.setText("");
        jTextTenKm.setText("");
        jTextPtkm.setText("");
        }
    }//GEN-LAST:event_jLabelXoaKMMouseClicked

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

            if(jComboBox.getSelectedItem().equals("KM")){

                    ArrayList<Model_KhuyenMai> dskm = qlkm.timKiemKM(jTextTimKiem.getText());
                    showdataKM(dskm);
                    jTextTimKiem.setText("");
                   
            }
            if(jComboBox.getSelectedItem().equals("CTKM")){
                    ArrayList<Model_ChiTietKM> dsctkm = qlkm.timKiemCTKM(jTextTimKiem.getText());
                    showdataCTKM(dsctkm);
                    jTextTimKiem.setText("");
                }
            if(jComboBox.getSelectedItem().equals("ALL")){
                    setDefaultTableModelKM();
                    setDefaultTableModelCTKM();
                    jTextTimKiem.setText("");
                }
            
    }//GEN-LAST:event_jLTimKiemCTKMMouseClicked

    private void jLabelThemCTKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelThemCTKMMouseClicked
         
        String masp = (String) jComboBoxMaSP.getSelectedItem();
        String makm = (String) jComboBoxMaKM.getSelectedItem();
         if(qlkm.ExistsCTKM(Integer.parseInt(masp),Integer.parseInt(makm))){
            JOptionPane.showMessageDialog(this, "Khuyến mãi đã tồn tại");
            return;
        }

      if(qlkm.exitmakm(Integer.parseInt(masp))){
         JOptionPane.showMessageDialog(this, "Cần chuyển mã trước về F");
         return;
      }
        QuanLyKhuyenMai_BUS qlkm = new QuanLyKhuyenMai_BUS();
        Model_ChiTietKM ctkm = new Model_ChiTietKM();
        ctkm.setMaSP(Integer.parseInt(masp));
        ctkm.setMaKM(Integer.parseInt(makm));
        ctkm.setTrangThai("T");
      
//        if(qlkm.exitmakm(Inte, ctkm)){
//        
//        }
         int a = JOptionPane.showConfirmDialog(null, "Bạn muốn thêm không ?","Thêm chi tiết  Khuyến Mãi", JOptionPane.YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION) {
        qlkm.insertChiTietKM(ctkm);
        setDefaultTableModelCTKM();
        System.out.println(jComboBoxMaSP.getSelectedItem());
        System.out.println(jComboBoxMaKM.getSelectedItem());
        }
    }//GEN-LAST:event_jLabelThemCTKMMouseClicked

    private void jLabelXoaCTKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelXoaCTKMMouseClicked
          if (stateForm != 2) {
            JOptionPane.showMessageDialog(jLabelXoaKM, "Vui lòng chọn 1 dòng dữ liệu trên bảng  để có thể tiến hành chỉnh sửa dữ liêu");
            return;
        }
        String machitietkm = jTextMaCTKM.getText();
        QuanLyKhuyenMai_BUS qlkm = new QuanLyKhuyenMai_BUS();
        Model_ChiTietKM ChiTietKM = new Model_ChiTietKM();
        ChiTietKM.setMachitietkhuyenmai(Integer.parseInt(machitietkm));
        ChiTietKM.setTrangThai("F");
        int a = JOptionPane.showConfirmDialog(null, "Bạn muốn Xóa không ?","Xóa chi tiết  Khuyến Mãi", JOptionPane.YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION) {
        qlkm.deleteChiTietKM(ChiTietKM);
            setDefaultTableModelCTKM();
            }
        
    }//GEN-LAST:event_jLabelXoaCTKMMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     
        int index = jTable1.getSelectedRow();
        Model_ChiTietKM ChiTietKM = new Model_ChiTietKM();
        TableModel modelCTKM = jTable1.getModel();
        String mactkm = modelCTKM.getValueAt(index, 0).toString();
        String masp = modelCTKM.getValueAt(index, 1).toString();
        String makm = modelCTKM.getValueAt(index, 3).toString();
        ChiTietKM.setMachitietkhuyenmai(Integer.parseInt(mactkm));
        ChiTietKM.setMaSP(Integer.parseInt(masp));
        ChiTietKM.setMaKM(Integer.parseInt(makm));
        truyendualieuCTKM(ChiTietKM);
        
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> jComboBox;
    private javax.swing.JComboBox<String> jComboBoxMaKM;
    private javax.swing.JComboBox<String> jComboBoxMaSP;
    private javax.swing.JLabel jLTimKiemCTKM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCTMaSP;
    private javax.swing.JLabel jLabelChinhSuaKM;
    private javax.swing.JLabel jLabelLamMoiKM;
    private javax.swing.JLabel jLabelMaCTKM;
    private javax.swing.JLabel jLabelMaKM;
    private javax.swing.JLabel jLabelThemCTKM;
    private javax.swing.JLabel jLabelThemKM;
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
    // End of variables declaration//GEN-END:variables
}
