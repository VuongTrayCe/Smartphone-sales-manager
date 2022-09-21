/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.UI.Model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Vuong
 */
public class Model_Menu1 {
    String icon;
    String name;

    public Model_Menu1(String icon, String name) {
        this.icon = icon;
        this.name = name;
    }

//    public Icon getIcon() {
//        return new ImageIcon(getClass().getResource("/icon/boy"));
//    }

    public String getName() {
        return name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
 
}
