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
        ////
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
        jPanelkhuyenmai = new javax.swing.JPanel();
        jLabelmasanpham = new javax.swing.JLabel();
        jLabelmakhuyenmai = new javax.swing.JLabel();
        jLabelltenkhuyenmai = new javax.swing.JLabel();
        jLabelloaikhuyenmai = new javax.swing.JLabel();
        jTextmasanpham = new javax.swing.JTextField();
        jTexttenkhuyenmai = new javax.swing.JTextField();
        jTextmakhuyenmai = new javax.swing.JTextField();
        jTextloaikhuyenmai = new javax.swing.JTextField();
        jButtonthem = new javax.swing.JButton();
        jButtonxoa = new javax.swing.JButton();
        jButtonlammoi = new javax.swing.JButton();
        jPaneldschitietkm = new javax.swing.JPanel();
        jLabeldskhuyenmai = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabledanhsachkm = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabeltimkiem = new javax.swing.JLabel();
        jTexttimkiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

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
                .addContainerGap()
                .addComponent(jLabelmakhuyenmai)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelkhuyenmaiLayout.createSequentialGroup()
                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelkhuyenmaiLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelmasanpham)
                        .addGap(89, 89, 89))
                    .addGroup(jPanelkhuyenmaiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelloaikhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelkhuyenmaiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelltenkhuyenmai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextmasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextmakhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextloaikhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTexttenkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(612, 612, 612))
            .addGroup(jPanelkhuyenmaiLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jButtonthem, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButtonxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButtonlammoi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelkhuyenmaiLayout.setVerticalGroup(
            jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelkhuyenmaiLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelmakhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextmakhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelmasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextmasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelloaikhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextloaikhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelltenkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTexttenkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanelkhuyenmaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonthem)
                    .addComponent(jButtonxoa)
                    .addComponent(jButtonlammoi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPaneldschitietkm.setBackground(new java.awt.Color(204, 255, 204));

        jLabeldskhuyenmai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabeldskhuyenmai.setText("Danh sách chi tiết khuyến mãi");

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

        javax.swing.GroupLayout jPaneldschitietkmLayout = new javax.swing.GroupLayout(jPaneldschitietkm);
        jPaneldschitietkm.setLayout(jPaneldschitietkmLayout);
        jPaneldschitietkmLayout.setHorizontalGroup(
            jPaneldschitietkmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPaneldschitietkmLayout.createSequentialGroup()
                .addComponent(jLabeldskhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPaneldschitietkmLayout.setVerticalGroup(
            jPaneldschitietkmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneldschitietkmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabeldskhuyenmai)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(jLabeltimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jTexttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTexttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabeltimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaneldschitietkm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanelkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPaneldschitietkm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(134, 134, 134))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextloaikhuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextloaikhuyenmaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextloaikhuyenmaiActionPerformed

    private void jButtonxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonxoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonxoaActionPerformed


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
    private javax.swing.JPanel jPaneldschitietkm;
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
    // End of variables declaration//GEN-END:variables
}
