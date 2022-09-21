/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Component;

import Smartphone_sales_management.UI.Model.Model_Menu1;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 *
 * @author Vuong
 */
public class MenuPanel2 extends javax.swing.JPanel {

    public MenuPanel2() {
        initComponents();
        setOpaque(false);  
        this.add(new Listitem(new Model_Menu1("boy","VUong")));
        repaint();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 442, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

@Override
    protected void paintChildren(Graphics g) {
          Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint  h = new GradientPaint(0,0, Color.decode("#003399"), 0, getHeight(), Color.decode("#ffffff"));
        g2.setPaint(h);
        g2.fillRoundRect(0,0,getWidth(),getHeight(),15,15);
        g2.fillRect(getWidth()-20, 0,getWidth(), getHeight());
        super.paintComponent(g);
        
        super.paintChildren(g);
    }
    private int x;
    private int y;
    public void initMoving(JFrame fr)           
    {
       this.addMouseListener(new MouseAdapter() {
             
          @Override
          public void mousePressed(MouseEvent me)
          { 
              x = me.getX();
              y = me.getY();
          }
  
       });
       this.addMouseMotionListener(new MouseMotionListener() {
           @Override
           public void mouseDragged(MouseEvent e) {
               
               fr.setLocation(e.getXOnScreen()-x, e.getYOnScreen()-y);
           }

           @Override
           public void mouseMoved(MouseEvent e) {
           }
       });
       
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
