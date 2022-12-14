/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.form;

import Smartphone_sales_management.UI.Event.EventMenu;
import Smartphone_sales_management.UI.Main.MainFrame;
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
import static Smartphone_sales_management.UI.Main.MainFrame.manv;
import static Smartphone_sales_management.UI.Main.MainFrame.BanHang;
import static Smartphone_sales_management.UI.Main.MainFrame.SanPham;
import static Smartphone_sales_management.UI.Main.MainFrame.PhieuNhap;
import static Smartphone_sales_management.UI.Main.MainFrame.DonHang;
import static Smartphone_sales_management.UI.Main.MainFrame.ThongKe;
import static Smartphone_sales_management.UI.Main.MainFrame.ChinhSach;
import static Smartphone_sales_management.UI.Main.MainFrame.ConNguoi;

import Smartphone_sales_management.UI.Swing.Menu.NewJPanel;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Vuong
 */
public class Menu extends javax.swing.JPanel {

    /**
     * Creates new form Menu
     */
    private EventMenu event;

    int index;
    ArrayList tenquyen = new ArrayList();
    public void addEventMenu(EventMenu event) {
        this.event = event;
//        event.selected(0);
//        listMenu1.addEventMenu(event);

//     listMenu1.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                if(listMenu1.getSelectedIndex()==0)
//                {
//                   selectedIndex=0;
//                   listMenu1.repaint();
//                  event.selected(selectedIndex);4
        listMenu1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();

                if (evt.getClickCount() == 1) {

                    // Double-click detected
                    index = list.locationToIndex(evt.getPoint());
                }
//        } else if (evt.getClickCount() == 3) {
//            
//            // Triple-click detected
//           index = list.locationToIndex(evt.getPoint());         
//                }
                if (index == 0) {
                    selectedIndex = 0;
                    listMenu1.repaint();
                    event.selected(0, (String) tenquyen.get(index));
                }
                if (index == 1) {
                    selectedIndex = 1;
                    listMenu1.repaint();
                    event.selected(1, (String) tenquyen.get(index));
                }
                if (index == 2) {
                    selectedIndex = 2;
                    listMenu1.repaint();
                    event.selected(2,(String) tenquyen.get(index));
                }
                if (index == 3) {
                    selectedIndex = 3;
                    listMenu1.repaint();
                    event.selected(3,(String) tenquyen.get(index));
                }
                if (index == 4) {
                    selectedIndex = 4;
                    listMenu1.repaint();
                    event.selected(4,(String) tenquyen.get(index));
//                          listMenu1.add2(5,new NewJPanel());

                }
                if (index == 5) {
                    selectedIndex = 5;
                    listMenu1.repaint();
                    event.selected(5,(String) tenquyen.get(index));

                }
                if (index == 6) {
                    selectedIndex = 6;
                    listMenu1.repaint();
                    event.selected(6,(String) tenquyen.get(index));

                }
                if (index == 7) {
                    selectedIndex = 7;
                    listMenu1.repaint();
                    event.selected(7,(String) tenquyen.get(index));

                }

            }
        });

    }

    public Menu() {
        initComponents();

        init();
        setOpaque(false);
        listMenu1.setOpaque(false);
//        listMenu1.setBorder(new EmptyBorder(50,10, 10, 10));
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
    public void init() {
        if (BanHang == 1) {
            listMenu1.addItem(new Model_Menu("BanHang", "B??n H??ng", Model_Menu.MenuType.MENU));
            tenquyen.add("B??n H??ng");
          
        }
        if (SanPham == 1) {
            listMenu1.addItem(new Model_Menu("SanPham", "S???n Ph???m", Model_Menu.MenuType.MENU));
            tenquyen.add("S???n Ph???m");

        }
        if (DonHang == 1) {
            listMenu1.addItem(new Model_Menu("DonHang", "????n H??ng", Model_Menu.MenuType.MENU));
            tenquyen.add("????n H??ng");

        }
        if (PhieuNhap == 1) {
            listMenu1.addItem(new Model_Menu("PhieuNhap", "Phi???u Nh???p", Model_Menu.MenuType.MENU));
            tenquyen.add("Phi???u Nh???p");

        }
        if (ConNguoi == 1) {
            listMenu1.addItem(new Model_Menu("NhanVien", "Con Ng?????i", Model_Menu.MenuType.MENU));
            tenquyen.add("Con Ng?????i");
        }
        if (ThongKe == 1) {
            listMenu1.addItem(new Model_Menu("ThongKe", "Th???ng K??", Model_Menu.MenuType.MENU));
            tenquyen.add("Th???ng K??");
        }
        if (MainFrame.TaiKhoan == 1) {
            listMenu1.addItem(new Model_Menu("TaiKhoan", "T??i Kho???n", Model_Menu.MenuType.MENU));
            tenquyen.add("T??i Kho???n");
        }
        if (ChinhSach == 1) {
            listMenu1.addItem(new Model_Menu("TaiKhoan", "Ch??nh S??ch", Model_Menu.MenuType.MENU));
            tenquyen.add("Ch??nh S??ch");
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

        listMenu1.setBackground(new java.awt.Color(255, 51, 102));

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
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(0, 0, 0));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());

        super.paintComponent(g);
    }

//     @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
////            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
//            int width = getWidth();
//            int height = getHeight();
//            Graphics2D graphics = (Graphics2D) g;
//            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//            graphics.setColor(new Color(152, 141, 172));
//            //Draws the rounded panel with borders.
//        graphics.fillRoundRect(0,0,getWidth(),getHeight(),50,50);
//
////            graphics.fillRoundRect(0, 0, width-1, height-1,50,50); //paint background
////            graphics.setColor(getForeground());
////            graphics.drawRoundRect(0, 0, width-1, height-1,50,50); //paint border
//        }
//    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private Smartphone_sales_management.UI.Swing.Menu.ListMenu<String> listMenu1;
    // End of variables declaration//GEN-END:variables
}
