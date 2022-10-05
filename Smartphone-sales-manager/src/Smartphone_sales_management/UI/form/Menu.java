/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.form;

import Smartphone_sales_management.UI.Event.EventMenu;
import Smartphone_sales_management.UI.Model.Model_Menu;
import Smartphone_sales_management.UI.Swing.Menu.ListMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static Smartphone_sales_management.UI.Main.MainFrame.selectedIndex;

/**
 *
 * @author Vuong
 */
public class Menu extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    private EventMenu event;
    
    
     public void addEventMenu(EventMenu event) {
        this.event = event;
//        event.selected(0);
//        listMenu1.addEventMenu(event);


     listMenu1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(listMenu1.getSelectedIndex()==0)
                {
                   selectedIndex=0;
                   listMenu1.repaint();
                  event.selected(selectedIndex);
                  
                  
                  
                }
                if(listMenu1.getSelectedIndex()==1)
                {
                    selectedIndex=1;
                   listMenu1.repaint();
                  event.selected(1);
                  
                }
                if(listMenu1.getSelectedIndex()==2)
                {
                    selectedIndex=2;
                   listMenu1.repaint();
                  event.selected(2);
                  
                }
                if(listMenu1.getSelectedIndex()==3)
                {
                    selectedIndex=3;
                   listMenu1.repaint();
                  event.selected(3);
                  
                }



            }
        });


    }
    
    
    
    public Menu() {
        initComponents();
        
         init();
        setOpaque(false);
        listMenu1.setOpaque(false);
//        listMenu1.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                if(listMenu1.getSelectedIndex()==1)
//                {
//                   flag=1;
//                    System.out.println("Da vao");
//                    repaint();
//                  
//                }
//            }
//        });
//        listMenu1.add
//     listMenu1.addMouseMotionListener(new MouseAdapter() {
//      public void mouseMoved(MouseEvent me) {
//    Point p = new Point(me.getX(),me.getY());
//    int index=-1;
//     index = listMenu1.locationToIndex(p);
//          System.out.println(index);
//    if (index != selectedIndex) {
//      selectedIndex= index ;
//      listMenu1.repaint();
//    }
//    else if(index == -1)
//    {
//     selectedIndex=-1;
//     listMenu1.repaint();
//    }
//    
//      }
//});
      
    
     
    }
       
    
    public void init()
    {
        
        listMenu1.addItem(new Model_Menu("BanHang","Bán Hàng", Model_Menu.MenuType.MENU));
                   listMenu1.addItem(new Model_Menu("SanPham","Sản Phẩm", Model_Menu.MenuType.MENU));
                   listMenu1.addItem(new Model_Menu("DonHang","Đơn Hàng", Model_Menu.MenuType.MENU));
                   listMenu1.addItem(new Model_Menu("PhieuNhap","Phiếu Nhập", Model_Menu.MenuType.MENU));
                   listMenu1.addItem(new Model_Menu("NhanVien","Nhân Viên", Model_Menu.MenuType.MENU));
                   listMenu1.addItem(new Model_Menu("ThongKe","Thống Kê", Model_Menu.MenuType.MENU));


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
        jLabel1 = new javax.swing.JLabel();
        listMenu1 = new Smartphone_sales_management.UI.Swing.Menu.ListMenu<>();

        jPanel1.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/SmartPhone.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

@Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.gray);
        g2.fillRoundRect(0,0,getWidth(),getHeight(),15,15);
        g2.fillRect(getWidth()-20, 0,getWidth(), getHeight());

        super.paintComponent(g);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private Smartphone_sales_management.UI.Swing.Menu.ListMenu<String> listMenu1;
    // End of variables declaration//GEN-END:variables
}
