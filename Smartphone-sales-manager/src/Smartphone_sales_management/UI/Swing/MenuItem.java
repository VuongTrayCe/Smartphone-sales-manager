/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Smartphone_sales_management.UI.Swing;

import Smartphone_sales_management.UI.Model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author Vuong
 */
public class MenuItem extends javax.swing.JPanel {
    
        private final Model_Menu data;
    public MenuItem(Model_Menu data) {
                initComponents();
        this.data=data;
        this.setBackground(Color.GRAY);
        if(data.getType() == Model_Menu.MenuType.MENU)
            {
//                System.out.println(index);
                lbIcon.setIcon(data.toIcon());
                lbName.setText(data.getName());
//                if(index == 1)
//                {
//                    
//                this.setBackground(Color.GREEN);
//                    System.out.println("Da vao ròi");
//                }
//                else
//                {
//                 this.setBackground(Color.GRAY);
//
//                }
//                

                
            }else{

                    lbName.setText("");
                    }

    }
    public void setSelected(boolean selected)
    {
        if(data.getType() == Model_Menu.MenuType.MENU)
            {
                if(selected)
                {
                    lbIcon.setIcon(data.toIconSelected());
                    lbIcon.setForeground(new Color(60,60,60));
                }
                else
                {
                    lbIcon.setIcon(data.toIcon());
                    lbName.setForeground(new Color(0,0,0));
                }
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 51, 0));
        setOpaque(false);

        lbName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lbIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbName)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(lbIcon))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

//@Override
//    protected void paintChildren(Graphics g) {
//          Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.fillRoundRect(0,0,getWidth(),getHeight(),5,5);
//        super.paintComponent(g);
//  
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
