/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.TaiKhoanComponent;

import Smartphone_sales_management.BUS.QuanLyTaiKhoan_BUS;
import Smartphone_sales_management.DAO.QuanLyTaiKhoan_DAO;
import Smartphone_sales_management.UI.Component.TaiKhoanComponent.TableDetailTK;
import Smartphone_sales_management.UI.Component.BanHangComponent.TableGioHang;
import Smartphone_sales_management.UI.Event.TaiKhoan.EventTaiKhoan;
import Smartphone_sales_management.UI.Main.MainFrame;
import java.awt.GridLayout;
import Smartphone_sales_management.UI.Event.TaiKhoan.AddDetailTK;
import Smartphone_sales_management.UI.Event.TaiKhoan.LayMatk;
import Smartphone_sales_management.UI.Model.Model_TaiKhoan;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows10
 */
public class MainConTentTaiKhoan extends javax.swing.JPanel {

    EventTaiKhoan event;
    MainFrame frame;
    QuanLyTaiKhoan_BUS qltk = new QuanLyTaiKhoan_BUS();
    QuanLyTaiKhoan_DAO a = new QuanLyTaiKhoan_DAO();
    ArrayList data = new ArrayList();
    DefaultTableModel model = new DefaultTableModel();
    int Matk = -1;

    public MainConTentTaiKhoan(MainFrame frame) {
        initComponents();
        this.frame = frame;
        model.addColumn("MaTk");
        model.addColumn("Manv");
        model.addColumn("tenDangNhap");
        model.addColumn("MatKhau");
        TableTaiKhoan.setOpaque(false);
        TableTaiKhoan.getTableHeader().getColumnModel().setColumnMargin(1);
        TableTaiKhoan.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 17) {
        });
        TableTaiKhoan.getTableHeader().setForeground(Color.WHITE);
        TableTaiKhoan.getTableHeader().setBackground(new Color(14, 14, 14));
        TableTaiKhoan.setModel(model);
        addEventTaiKhoan(new EventTaiKhoan(){
            @Override
             public int SelectedInxex(int index){
                 
                 Matk= index;
                 return -1;
             };
        });
        setDefautlTaiKhoan();

//        DetailTaiKhoanPanel.add(tbdtTK);
        timkiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {

                setDefautlTaiKhoan();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setDefautlTaiKhoan();

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                setDefautlTaiKhoan();

            }
        });

    }

    public void addEventTaiKhoan(EventTaiKhoan event) {
        TableTaiKhoan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                event.selectedIndex(jTable1.getSelectedRow());
                event.SelectedInxex((int) TableTaiKhoan.getValueAt(TableTaiKhoan.getSelectedRow(), 0));
                
            }

            
        }
        );

    }

    public void setDefautlTaiKhoan() {

        TableTaiKhoan.removeAll();
        model.setRowCount(0);
        ArrayList dataList = new ArrayList<>();
        dataList = qltk.layDanhSachTaiKhoan(timkiem.getText());
        for (int i = 0; i < dataList.size(); i++) {
            model.addRow((Vector<?>) dataList.get(i));
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

        jLabel5 = new javax.swing.JLabel();
        javax.swing.JPanel Nền = new javax.swing.JPanel();
        timkiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableTaiKhoan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnDelete = new javax.swing.JLabel();

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/search.png"))); // NOI18N

        Nền.setBackground(new java.awt.Color(0, 153, 153));

        timkiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemActionPerformed(evt);
            }
        });

        TableTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableTaiKhoan);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 51, Short.MAX_VALUE)
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/search.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tài Khoản");

        btnThem.setBackground(new java.awt.Color(0, 153, 153));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Add.png"))); // NOI18N
        btnThem.setText("Thêm tài khoản mới");
        btnThem.setBorder(null);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jButton1.setText("Quản Lý Quyền TK");

        btnDelete.setBackground(java.awt.Color.cyan);
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Close-icon.png"))); // NOI18N
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout NềnLayout = new javax.swing.GroupLayout(Nền);
        Nền.setLayout(NềnLayout);
        NềnLayout.setHorizontalGroup(
            NềnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NềnLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(NềnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(NềnLayout.createSequentialGroup()
                        .addGroup(NềnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(NềnLayout.createSequentialGroup()
                                .addComponent(timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addGroup(NềnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NềnLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NềnLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26))
        );
        NềnLayout.setVerticalGroup(
            NềnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NềnLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(NềnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(NềnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NềnLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4))
                    .addGroup(NềnLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(NềnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(NềnLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(NềnLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Nền, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Nền, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
      public void DisPlayComponent(Component taikhoan) {

    }
    private void timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timkiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        JFrame frame = new JFrame("Them tai khoan");
        Tableaddtaikhoan themTaiKhoan = new Tableaddtaikhoan();
        frame.setSize(567, 383);
        frame.setLocationRelativeTo(null);
        frame.add(themTaiKhoan);
        frame.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed
    public boolean checkMatk(int Matk) {
        if (Matk != -1) {
            return true;
        }
        return false;
    }
    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
//        ResetMau();
//        if (btnDelete.getBackground() != Color.CYAN) {
//            btnDelete.setBackground(Color.CYAN);
//        } else {
//            btnDelete.setBackground(Color.red);
//        }
        int a = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa ?", "Xóa tài khoản ", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {

            if (checkMatk(Matk)) {
                QuanLyTaiKhoan_BUS qltk_BUS = new QuanLyTaiKhoan_BUS();
                if (qltk_BUS.xoaTK(Matk)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                    Matk = -1;
//                    System.out.println(txtTimKiem.getText());
//                    sanPham.SetDefaultTable(txtTimKiem.getText(), jComboBox2.getSelectedItem().toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Xóa thất bại!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Chưa chọn tài khoản muốn xóa");
            }
        }

    }//GEN-LAST:event_btnDeleteMouseClicked

    private void TableTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableTaiKhoanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TableTaiKhoanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableTaiKhoan;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField timkiem;
    // End of variables declaration//GEN-END:variables
}
