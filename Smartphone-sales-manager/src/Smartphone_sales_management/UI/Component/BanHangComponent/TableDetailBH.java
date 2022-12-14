/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.BanHangComponent;

import Smartphone_sales_management.UI.Event.BanHang.EventBanHang;
import Smartphone_sales_management.DTO.Model_BanHang_ChiTietSanPham;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.border.Border;
import Smartphone_sales_management.BUS.QuanLyBanHang_BUS;
import Smartphone_sales_management.UI.Event.BanHang.AddGioHang;
import Smartphone_sales_management.UI.Main.MainFrame;
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
import Smartphone_sales_management.DTO.Model_BanHang_ChiTietHoaDon;
import javax.swing.JOptionPane;

/**
 *
 * @author Vuong
 */
public class TableDetailBH extends javax.swing.JPanel {

    /**
     * Creates new form TableDetailBH
     */
    AddGioHang event;
    public int indexSelected;
    public static int selectedIndex = -1;
    public String urlImage;
    public Model_GioHang modelGiohang;
    QuanLyBanHang_BUS qlbh_BUS = new QuanLyBanHang_BUS();
    ArrayList<Model_BanHang_ChiTietSanPham> datachitiet;
    Model_BanHang_ChiTietSanPham model;
    MainConTentBanHang panelbanhang;
    public int soluongcon = 0;
    ArrayList<Model_BanHang_ChiTietHoaDon> arrchitiethoadon;

    public TableDetailBH(ArrayList<Model_BanHang_ChiTietHoaDon> arrchitiethoadon, int index, MainFrame mainFrame, MainConTentBanHang panelbanhang) {
        initComponents();
//        jButton1.setBackground(Color.WHITE);
        selectedIndex = index;
        this.arrchitiethoadon = arrchitiethoadon;
        this.panelbanhang = panelbanhang;
        if (selectedIndex != -1) {
            DisplayInfor();
        }
    }

    // Th??m s??? ki???n th??m v??o gi??? h??ng
    public void addSanPhamVaoGio(AddGioHang event) {
        this.event = event;

        btnThem.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Boolean flag = true;
                if (model.getSl() == 0) {
                    JOptionPane.showMessageDialog(null, " S???n Ph???m ???? h???t");
                    flag = false;

                }
                for (Model_BanHang_ChiTietHoaDon object : arrchitiethoadon) {
                    if (object.getMasp() == model.getMasp()) {
                        if (object.getSoluong() >= model.getSl()) {
                            JOptionPane.showMessageDialog(null, "S??? L?????ng s???n ph???m ???? ?????t gi???i h???n");
                            flag = false;
                        }
                    }
                }
                if (flag == true) {
                    Model_BanHang_ChiTietHoaDon data = new Model_BanHang_ChiTietHoaDon(model.getMasp(), selectedIndex, model.getMachitietkhuyenmai(), model.getIcon(), model.getMachitietbaohanh(), model.getMagiasanpham(), 1, model.getGiaban(), model.getTensp(), model.getPtkm(), model.getBaohanh());
                    event.addGiohang(data);
                }

//                else if()
//                String str = lbcGia.getText().split(" ")[0];
//                Double x = Double.parseDouble(str);
//                System.out.println(x);
//                
            }
        ;
    }

    );
        
    }
    public void DisplayInfor() {
        datachitiet = new ArrayList();
        datachitiet = qlbh_BUS.getDanhSachChiTiet1SanPham(this.selectedIndex);
        model = datachitiet.get(0);
        lbcName.setText(model.getTensp());
        lbcLoai.setText(model.getLoaisp());
        String km = String.valueOf(model.getPtkm()) + " %";
        lbnKhuyenMai.setText(km);
        lbnBaoHanh.setText(model.getBaohanh());
        String SL = String.valueOf(model.getSl());
        lbcSL.setText(SL);
        lbcNamSx.setText(model.getNamsx());
        lbcNCC.setText(model.getTenncc());
        String gia = String.valueOf(model.getGiaban());
        lbcGia.setText(gia + " VND");
        this.urlImage = model.getIcon();
        String str = model.getChitiet();
        String[] tachChuoi = str.split("//");
        String chuoiChinh = "";
        for (String string : tachChuoi) {
            chuoiChinh += (string + "\n");
        }
        taThongSo.setText(chuoiChinh);
//        System.out.println(chuoiChinh);

        if (model.getIcon() != null) {
            this.urlImage = model.getIcon();
            System.out.println(this.urlImage);
            lbImage.setIcon(new ImageIcon(getClass().getResource(this.urlImage)));
        } else {
            this.urlImage = "";
        }

//        modelGiohang = new Model_GioHang();
//        // Kh???i t???o gi?? tr??? cho model gi??? h??ng 
//        modelGiohang.setName(model.getTensp());
//        modelGiohang.setLoai(model.getLoaisp());
//        modelGiohang.setGiatien(model.getGiaban().toString());
//        modelGiohang.setKhuyenmai(model.getPtkm());
//        modelGiohang.setBaohanh(model.getBaohanh());
//        modelGiohang.setIcon(urlImage);
//        modelGiohang.setType(GioHangType.MENU);
//        modelGiohang.setMasp(model.getMasp());
//        modelGiohang.setMakhuyenmai(model.getMakm());
//        modelGiohang.setMabaohanh(model.getMabh());
//        System.out.println(modelGiohang.getSoluong()); 
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        lbLoai = new javax.swing.JLabel();
        lbSL = new javax.swing.JLabel();
        lbNamSx = new javax.swing.JLabel();
        lbNCC = new javax.swing.JLabel();
        lbGia = new javax.swing.JLabel();
        lbcName = new javax.swing.JLabel();
        lbcLoai = new javax.swing.JLabel();
        lbcSL = new javax.swing.JLabel();
        lbcNamSx = new javax.swing.JLabel();
        lbcNCC = new javax.swing.JLabel();
        lbcGia = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taThongSo = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbnKhuyenMai = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbnBaoHanh = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setBackground(new java.awt.Color(204, 204, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setPreferredSize(new java.awt.Dimension(354, 414));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Xem chi ti???t s???n ph???m");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lbName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbName.setText("T??n s???n ph???m:");

        lbLoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLoai.setText("Lo???i s???n ph???m:");

        lbSL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSL.setText("S??? l?????ng c??n:");

        lbNamSx.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNamSx.setText("N??m s???n xu???t:");

        lbNCC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbNCC.setText("Nh?? cung c???p:");

        lbGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbGia.setText("Gi?? B??n:         ");

        lbcName.setText("jLabel10");

        lbcLoai.setText("jLabel11");

        lbcSL.setText("jLabel12");

        lbcNamSx.setText("jLabel13");

        lbcNCC.setText("jLabel14");

        lbcGia.setText("jLabel15");

        taThongSo.setEditable(false);
        taThongSo.setColumns(20);
        taThongSo.setLineWrap(true);
        taThongSo.setRows(10);
        taThongSo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Th??ng tin chi ti???t", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jScrollPane2.setViewportView(taThongSo);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbLoai)
                                .addGap(10, 10, 10)
                                .addComponent(lbcLoai))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbSL)
                                .addGap(10, 10, 10)
                                .addComponent(lbcSL))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbNamSx)
                                .addGap(10, 10, 10)
                                .addComponent(lbcNamSx))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbName)
                                .addGap(10, 10, 10)
                                .addComponent(lbcName))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbGia)
                                .addGap(10, 10, 10)
                                .addComponent(lbcGia))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbNCC)
                                .addGap(10, 10, 10)
                                .addComponent(lbcNCC)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(lbcName))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLoai)
                    .addComponent(lbcLoai))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSL)
                    .addComponent(lbcSL))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNamSx)
                    .addComponent(lbcNamSx))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNCC)
                    .addComponent(lbcNCC))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGia)
                    .addComponent(lbcGia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        lbImage.setBackground(new java.awt.Color(204, 204, 255));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/Add.png"))); // NOI18N
        btnThem.setText("Th??m ");
        btnThem.setBorder(null);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Khuy???n m??i: ");

        lbnKhuyenMai.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("B???o h??nh:");

        lbnBaoHanh.setText("jLabel5");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnBaoHanh)
                            .addComponent(lbnKhuyenMai))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addGap(94, 94, 94)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbnKhuyenMai))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbnBaoHanh))
                .addGap(47, 47, 47)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
//     
//            FileDialog fd = new FileDialog(new JFrame(), "Xu???t excel", FileDialog.LOAD);
//        fd.setVisible(true);
//                String url = fd.getDirectory() + fd.getFile();
////                lbImage.setIcon(new ImageIcon(new URL(url)));
//              String[] url2= url.split("src");
//              String a = url2[1].replace("\\","/");
//              System.out.println(a);

// TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbGia;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbLoai;
    private javax.swing.JLabel lbNCC;
    private javax.swing.JLabel lbNamSx;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbSL;
    private javax.swing.JLabel lbcGia;
    private javax.swing.JLabel lbcLoai;
    private javax.swing.JLabel lbcNCC;
    private javax.swing.JLabel lbcNamSx;
    private javax.swing.JLabel lbcName;
    private javax.swing.JLabel lbcSL;
    private javax.swing.JLabel lbnBaoHanh;
    private javax.swing.JLabel lbnKhuyenMai;
    private javax.swing.JTextArea taThongSo;
    // End of variables declaration//GEN-END:variables
}
