/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.KhuyenMaiComponent;

import Smartphone_sales_management.UI.Component.BanHangComponent.*;
import Smartphone_sales_management.UI.Event.BanHang.EventBanHang;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.border.Border;
import Smartphone_sales_management.BUS.QuanLyBanHang_BUS;
import Smartphone_sales_management.UI.Event.BanHang.AddGioHang;
import Smartphone_sales_management.UI.Model.Model_GioHang;
import java.awt.FileDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import Smartphone_sales_management.UI.Model.Model_GioHang.GioHangType;


/**
 *
 * @author Vuong
 */
public class TableChiTietKM extends javax.swing.JPanel {

    /**
     * Creates new form TableDetailBH
     */
    AddGioHang event;
   public int indexSelected;
    public static int selectedIndex=-1;
    public String urlImage;
    QuanLyBanHang_BUS qlbh_BUS = new QuanLyBanHang_BUS();
    public TableChiTietKM(int index) {
        initComponents();
//        jButton1.setBackground(Color.WHITE);
     selectedIndex=index;
     if(selectedIndex!=-1)
     {
       DisplayInfor();
    }
    }
    // Thêm sự kiện thêm vào giỏ hàng
    public void addSanPhamVaoGio(AddGioHang event)
    {
        this.event=event;
        
        btnThem.addMouseListener(new  MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e) {
                Model_GioHang data= new Model_GioHang(lbcMaChiTietKM.getText(),lbcMaSp.getText(),lbcMaKM.getText(),urlImage,GioHangType.MENU,lbcTrangThai.getText());
                event.addGiohang(data);
                String str = lbcTrangThai.getText().split(" ")[0];
                Double x = Double.parseDouble(str);
                System.out.println(x);
                
            };
        });
        
    }
    public void DisplayInfor()
    {
       ArrayList data = new ArrayList();
       data = qlbh_BUS.getDanhSachChiTiet1SanPham(this.selectedIndex);
       lbcMaChiTietKM.setText((String) data.get(0));
       lbcMaSp.setText((String) data.get(1));
       lbcMaKM.setText(data.get(2).toString());
       lbcTenKM.setText((String) data.get(3));
       lbcLoaiKM.setText((String) data.get(4));
       lbcTrangThai.setText((String) data.get(5)+" VND");
       this.urlImage=(String) data.get(6);
       String  str= (String) data.get(7);
       String[] tachChuoi = str.split("//");
       String chuoiChinh="";
        for (String string : tachChuoi) {
            chuoiChinh+=(string+"\n");
        }
       taThongSo.setText(chuoiChinh);
        System.out.println(chuoiChinh);
       
       if(data.get(6)!=null)
       {
                  this.urlImage=(String) data.get(6);

        lbImage.setIcon(new ImageIcon(getClass().getResource((String) data.get(6))));
       }
       else
       {
           this.urlImage="";
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jbMaChiTietKM = new javax.swing.JLabel();
        jbMaSP = new javax.swing.JLabel();
        jbMaKM = new javax.swing.JLabel();
        jbTenKm = new javax.swing.JLabel();
        jbLoaiKM = new javax.swing.JLabel();
        jbTrangThai = new javax.swing.JLabel();
        jbcMaChiTietKM = new javax.swing.JLabel();
        jbcMaSP = new javax.swing.JLabel();
        jbcMaKM = new javax.swing.JLabel();
        jbcTenKM = new javax.swing.JLabel();
        jbcLoaiKM = new javax.swing.JLabel();
        jbcTrangThai = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(354, 450));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Xem chi tiết Khuyến Mãi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jbMaChiTietKM.setText("Mã chi tiết khuyến mãi");

        jbMaSP.setText("Mã sản phẩm");

        jbMaKM.setText("Mã khuyến mãi");

        jbTenKm.setText("Tên khuyến mãi");

        jbLoaiKM.setText("Loại khuyến mãi");

        jbTrangThai.setText("Trạng thái");

        jbcMaChiTietKM.setText("jLabel8");

        jbcMaSP.setText("jLabel9");

        jbcMaKM.setText("jLabel10");

        jbcTenKM.setText("jLabel11");

        jbcLoaiKM.setText("jLabel12");

        jbcTrangThai.setText("jLabel13");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbMaChiTietKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbMaKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbTenKm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbLoaiKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbcMaKM, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jbcTenKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbcLoaiKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbcTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbcMaChiTietKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbcMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)))
                .addGap(116, 116, 116))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMaChiTietKM)
                    .addComponent(jbcMaChiTietKM))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMaSP)
                    .addComponent(jbcMaSP))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMaKM)
                    .addComponent(jbcMaKM))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbTenKm)
                    .addComponent(jbcTenKM))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLoaiKM)
                    .addComponent(jbcLoaiKM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbTrangThai)
                    .addComponent(jbcTrangThai))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel jbLoaiKM;
    private javax.swing.JLabel jbMaChiTietKM;
    private javax.swing.JLabel jbMaKM;
    private javax.swing.JLabel jbMaSP;
    private javax.swing.JLabel jbTenKm;
    private javax.swing.JLabel jbTrangThai;
    private javax.swing.JLabel jbcLoaiKM;
    private javax.swing.JLabel jbcMaChiTietKM;
    private javax.swing.JLabel jbcMaKM;
    private javax.swing.JLabel jbcMaSP;
    private javax.swing.JLabel jbcTenKM;
    private javax.swing.JLabel jbcTrangThai;
    // End of variables declaration//GEN-END:variables
}
