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
public class Model_Menu {
    String icon;
    String name;
    MenuType type;
    public static enum MenuType
    {
        MENU, EMPTY
    
    
    }

     public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }
    public Icon toIcon()
    {
     return  new ImageIcon(getClass().getResource("/Smartphone_sales_management/UI/Icon/"+icon+".png"));
    }
    public Icon toIconSelected()
    {
        return new ImageIcon(getClass().getResource("/com/raven/icon/"+icon+"_selected.png"));
    }


    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public MenuType getType() {
        return type;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(MenuType type) {
        this.type = type;
    }
}
