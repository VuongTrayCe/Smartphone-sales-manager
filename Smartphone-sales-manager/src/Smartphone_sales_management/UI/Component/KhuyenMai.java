/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component;

/**
 *
 * @author lehongthai
 */
public class KhuyenMai extends javax.swing.JPanel {

    /**
     * Creates new form KhuyenMai
     */
    
    public KhuyenMai() {
        initComponents();
        //2
    }
//
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        neweww = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabledanhsachkm = new javax.swing.JTable();
        jLabeldskhuyenmai = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabeltimkiem = new javax.swing.JLabel();
        jTexttimkiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanelkhuyenmai = new javax.swing.JPanel();
        jLabelmasanpham = new javax.swing.JLabel();
        jLabelmakhuyenmai = new javax.swing.JLabel();
        jLabelltenkhuyenmai = new javax.swing.JLabel();
        jLabelloaikhuyenmai = new javax.swing.JLabel();
        jTextmasanpham = new javax.swing.JTextField();
        jTextmakhuyenmai = new javax.swing.JTextField();
        jTextloaikhuyenmai = new javax.swing.JTextField();
        jButtonthem = new javax.swing.JButton();
        jButtonxoa = new javax.swing.JButton();
        jButtonlammoi = new javax.swing.JButton();
        jTexttenkhuyenmai = new javax.swing.JTextField();

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

        jTabledanhsachkm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã chi tiết khuyến mãi", "Mã sản phẩm", "Mã khuyến mãi", "Tên khuyến mãi", "Loại khuyến mãi", "Trạng thái"
            }
        ));
        jScrollPane2.setViewportView(jTabledanhsachkm);

        jLabeldskhuyenmai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabeldskhuyenmai.setText("Danh sách chi tiết khuyến mãi");

        jLabeltimkiem.setText("Tìm kiếm");

        jTexttimkiem.setFont(new java.awt.Font("Sitka Subheading", 0, 12)); // NOI18N
        jTexttimkiem.setText("Nhập mã khuyến mãi của sản phẩm....");

        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("KHUYẾN MÃI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                .addComponent(jLabeltimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jTexttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabeltimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTexttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelkhuyenmai.setBackground(new java.awt.Color(204, 204, 255));

        jLabelmasanpham.setText("Mã sản phẩm");

        jLabelmakhuyenmai.setText("Mã khuyến mãi");

        jLabelltenkhuyenmai.setText("Tên khuyến mãi");

        jLabelloaikhuyenmai.setText("Loại khuyến mãi");

        jTextloaikhuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextloaikhuyenmaiActionPerformed(evt);
            }
        });

        jButtonthem.setText("Thêm");

        jButtonxoa.setText("Xóa");
        jButtonxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonxoaActionPerformed(evt);
            }
        });

        jButtonlammoi.setText("Làm mới");

        javax.swing.GroupLayout jPanelkhuyenmaiLayout = new javax.swing.GroupLayout(jPanelkhuyenmai);
        jPanelkhuyenmai.setLayout(jPanelkhuyenmaiLayout);
        jPanelkhuyenmaiLayout.setHorizontalGroup(
            jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelkhuyenmaiLayout.createSequentialGroup()
                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelkhuyenmaiLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jButtonthem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jButtonxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonlammoi))
                    .addGroup(jPanelkhuyenmaiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelkhuyenmaiLayout.createSequentialGroup()
                                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelltenkhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelloaikhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextloaikhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                    .addComponent(jTexttenkhuyenmai)))
                            .addGroup(jPanelkhuyenmaiLayout.createSequentialGroup()
                                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelmakhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(jLabelmasanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextmakhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                                    .addComponent(jTextmasanpham))))))
                .addGap(10, 10, 10))
        );
        jPanelkhuyenmaiLayout.setVerticalGroup(
            jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelkhuyenmaiLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelmakhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextmakhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextmasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelmasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextloaikhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelloaikhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelltenkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTexttenkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonxoa)
                    .addComponent(jButtonthem)
                    .addComponent(jButtonlammoi))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout newewwLayout = new javax.swing.GroupLayout(neweww);
        neweww.setLayout(newewwLayout);
        newewwLayout.setHorizontalGroup(
            newewwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newewwLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newewwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeldskhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(newewwLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        newewwLayout.setVerticalGroup(
            newewwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newewwLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabeldskhuyenmai)
                .addGap(15, 15, 15)
                .addGroup(newewwLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelkhuyenmai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(neweww, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(neweww, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonxoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonxoaActionPerformed

    private void jTextloaikhuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextloaikhuyenmaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextloaikhuyenmaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonlammoi;
    private javax.swing.JButton jButtonthem;
    private javax.swing.JButton jButtonxoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabeldskhuyenmai;
    private javax.swing.JLabel jLabelloaikhuyenmai;
    private javax.swing.JLabel jLabelltenkhuyenmai;
    private javax.swing.JLabel jLabelmakhuyenmai;
    private javax.swing.JLabel jLabelmasanpham;
    private javax.swing.JLabel jLabeltimkiem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelkhuyenmai;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTabledanhsachkm;
    private javax.swing.JTextField jTextloaikhuyenmai;
    private javax.swing.JTextField jTextmakhuyenmai;
    private javax.swing.JTextField jTextmasanpham;
    private javax.swing.JTextField jTexttenkhuyenmai;
    private javax.swing.JTextField jTexttimkiem;
    private javax.swing.JPanel neweww;
    // End of variables declaration//GEN-END:variables
}
