/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component.ThongKeBaoCaoComponent;

import Smartphone_sales_management.BUS.LoiNhuanBanHang_BUS;
import Smartphone_sales_management.DBConnect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.ResultSet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Vuong
 */
public class LoiNhuanBanHang_BieuDo_HangHoa extends javax.swing.JPanel {

    /**
     * Creates new form LoiNhuanBanHang_BieuDo_HangHoa
     */
    LoiNhuanBanHang_BUS tkbc = new LoiNhuanBanHang_BUS();
    public LoiNhuanBanHang_BieuDo_HangHoa() {
        initComponents();
        setChart();

    }

    void setChart() {
        JDBCCategoryDataset dataset;
        DBConnect db = new DBConnect();
        ResultSet rs = null;
        db.setupConnection();
        dataset = new JDBCCategoryDataset(db.getConnection());
//       dataset.executeQuery("select Tenkm,Ptkm from khuyenmai");
        dataset = tkbc.getDataHangHoa_BieuDo();
        JFreeChart chart = createChartSanPham(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setSize(new Dimension(510,270));
//        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(new Color(255, 255, 255));
        chartPanel.setPreferredSize(new Dimension(300, 300));
        chartPanel.setMouseWheelEnabled(true);
//        chartPanel.setBounds(0,0,500,270);
        jPanel1.setLayout(new GridLayout());
        jPanel1.add(chartPanel);
        chartPanel.validate();
    }

    private JFreeChart createChartSanPham(CategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createLineChart3D("Top 10 sản phẩm thu lợi nhất","Lợi Nhuận","Tiền Lãi/Lỗ",dataset,PlotOrientation.VERTICAL,false, true, false);
        return barChart;
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
