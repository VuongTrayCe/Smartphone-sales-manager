/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.UI.Swing.Menu;

import com.mysql.cj.protocol.Message;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Vuong
 */
public class ReactPanel extends JPanel implements MouseMotionListener {

    public ReactPanel() {
//        setPreferredSize(new Dimension(450, 450));

        addMouseMotionListener(this);
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
//        this.setBackground(Color.red);

    }
}
