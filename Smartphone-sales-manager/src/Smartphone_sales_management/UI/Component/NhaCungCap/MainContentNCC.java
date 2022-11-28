/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.NhaCungCap;

import Smartphone_sales_management.BUS.QuanLyNhaCungCap_BUS;
import Smartphone_sales_management.DAO.QuanLyNhaCungCap_DAO;
import Smartphone_sales_management.DTO.Model_NhaCungCap;
import Smartphone_sales_management.UI.Component.NhaCungCap.AddNhaCungCap;
import Smartphone_sales_management.UI.Event.NhaCungCap.EventNhaCC;
import Smartphone_sales_management.UI.Main.MainFrame;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author lehongthai
 */
public class MainContentNCC extends javax.swing.JPanel {
 MainFrame frame;
 TableNhaCC nhacc;
 AddNhaCungCap addNcc;
 EventNhaCC event;
    /**
     * Creates new form MainContentNCC
     */
  

    public MainContentNCC(MainFrame frame) {
        initComponents();
        jtMa.setEditable(false);
        this.frame = frame;
        addNcc = new AddNhaCungCap(frame, nhacc); 
      nhacc = new TableNhaCC(event,this);
        
        nhacc.setBounds(0, 0, jScrollPane1.getWidth(), jScrollPane1.getHeight());

        jScrollPane1.setViewportView(nhacc);
        
               jTextTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {

                nhacc.SetDefaultTable(jTextTimKiem.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                nhacc.SetDefaultTable(jTextTimKiem.getText());

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                nhacc.SetDefaultTable(jTextTimKiem.getText());

            }
        });
    }
  public void truyendulieu(Model_NhaCungCap NhaCC){
//        stateForm =2;
      jtMa.setText(Integer.toString(NhaCC.getMacc()));
      jtTen.setText(NhaCC.getTenncc());
      jtsdt.setText(Integer.toString(NhaCC.getSDT()));
      jTextDiaChi.setText(NhaCC.getDiaChi());
    
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
        jTextTimKiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelThem = new javax.swing.JLabel();
        jLabelXoa = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtTen = new javax.swing.JTextField();
        jb1 = new javax.swing.JLabel();
        jb3 = new javax.swing.JLabel();
        jtsdt = new javax.swing.JTextField();
        jb4 = new javax.swing.JLabel();
        jTextDiaChi = new javax.swing.JTextField();
        jtMa = new javax.swing.JTextField();
        jLMa = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/search.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("QUẢN LÝ NHÀ CUNG CẤP");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/gear.png"))); // NOI18N
        jLabel3.setText("Sửa");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabelThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/plus.png"))); // NOI18N
        jLabelThem.setText("Thêm");
        jLabelThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelThemMouseClicked(evt);
            }
        });

        jLabelXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/remove.png"))); // NOI18N
        jLabelXoa.setText("Xóa");
        jLabelXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelXoaMouseClicked(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jtTen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTenActionPerformed(evt);
            }
        });

        jb1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jb1.setText("Tên nhà cung cấp");

        jb3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jb3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jb3.setText("Số điện thoại");

        jtsdt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jb4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jb4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jb4.setText("Địa chỉ");

        jTextDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDiaChiActionPerformed(evt);
            }
        });

        jtMa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtMaActionPerformed(evt);
            }
        });

        jLMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLMa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLMa.setText("MaNV");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb1)
                    .addComponent(jLMa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb3)
                    .addComponent(jtMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(jtsdt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtTen, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextDiaChi, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLMa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(jb1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jb3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtsdt, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(jb4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(34, 301, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                        .addGap(97, 97, 97))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelThem)
                                .addGap(47, 47, 47)
                                .addComponent(jLabelXoa)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel3))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelXoaMouseClicked
 String mancc = jtMa.getText();
        QuanLyNhaCungCap_BUS qlncc = new QuanLyNhaCungCap_BUS();
        
        Model_NhaCungCap Nhacc = new Model_NhaCungCap();
        Nhacc.setMacc(Integer.parseInt(mancc));
        Nhacc.setTrangThai("F");
            int a = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa không ?","Xóa NhaCungCap", JOptionPane.YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION) {
           qlncc.deleteNhacc(Nhacc);
        nhacc.SetDefaultTable("");
        }
        jtMa.setText("");
        jtTen.setText("");
        jtsdt.setText("");
        jTextDiaChi.setText("");
    }//GEN-LAST:event_jLabelXoaMouseClicked

    private void jLabelThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelThemMouseClicked
        JFrame frame = new JFrame("Thêm nhà cung cấp ");
        AddNhaCungCap addNcc = new AddNhaCungCap(frame, nhacc);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.add(addNcc);
        frame.setVisible(true);

    }//GEN-LAST:event_jLabelThemMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
     String mancc = jtMa.getText();
          String ten = jtTen.getText();
        String sdt = jtsdt.getText();
        String diachi = jTextDiaChi.getText();
        String SDT_Pattern = "^[0]\\d{9}$";
        if(ten.equals(""))
        {
             JOptionPane.showMessageDialog(null, "Vui lòng nhập tên nhà cung cấp");
                        return;
        }
         if(sdt.equals(""))
        {
             JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại");
                        return;
        }
          if(Pattern.matches(SDT_Pattern, sdt)!=true)
        {
                        JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng");
                        return;
        }
        if(diachi.equals(""))
        {
             JOptionPane.showMessageDialog(null, "Vui lòng nhập địa chỉ");
                        return;
        }
       
            QuanLyNhaCungCap_BUS qlncc = new QuanLyNhaCungCap_BUS();
        
        Model_NhaCungCap Nhacc = new Model_NhaCungCap();
        Nhacc.setMacc(Integer.parseInt(mancc));
        Nhacc.setTenncc(ten);
        Nhacc.setSDT(Integer.parseInt(sdt));
        Nhacc.setDiaChi(diachi);
              int a = JOptionPane.showConfirmDialog(null, "Bạn muốn chỉnh sửa thông tin không ?","Chỉnh sửa thông tin Nhà cung cấp", JOptionPane.YES_NO_OPTION);
        if(a==JOptionPane.YES_OPTION) {
           qlncc.updateNhacc(Nhacc);

        nhacc.SetDefaultTable("");
        }
        jtMa.setText("");
        jtTen.setText("");
        jtsdt.setText("");
        jTextDiaChi.setText("");
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTenActionPerformed

    private void jTextDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDiaChiActionPerformed

    private void jtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtMaActionPerformed

    }//GEN-LAST:event_jtMaActionPerformed
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLMa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelThem;
    private javax.swing.JLabel jLabelXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextDiaChi;
    private javax.swing.JTextField jTextTimKiem;
    private javax.swing.JLabel jb1;
    private javax.swing.JLabel jb3;
    private javax.swing.JLabel jb4;
    private javax.swing.JTextField jtMa;
    private javax.swing.JTextField jtTen;
    private javax.swing.JTextField jtsdt;
    // End of variables declaration//GEN-END:variables
}
