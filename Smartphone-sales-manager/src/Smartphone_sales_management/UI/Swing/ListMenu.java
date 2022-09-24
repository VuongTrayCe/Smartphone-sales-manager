/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.UI.Swing;

import Smartphone_sales_management.UI.Model.Model_Menu;
import Smartphone_sales_management.UI.Swing.MenuItem;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
//import static Smartphone_sales_management.UI.form.Menu.selectedIndex;

/**
 *
 * @author Vuong
 */
public class ListMenu<E extends Object >extends JList<E> {
     private final DefaultListModel model;
    public ListMenu()
            {
                model = new DefaultListModel();
                setOpaque(false);
                setModel(model);
            }
    
    public void addItem(Model_Menu data)
    {
        model.addElement(data);
    }
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer()
        {
            @Override
           public Component getListCellRendererComponent(JList<?> list, Object o,int index ,boolean isSelected,boolean cellHasFocus)
           {
               Model_Menu data ;
               if (o instanceof Model_Menu)
               {
                   data= (Model_Menu) o;
               }
               else
               {
                   data = new Model_Menu("",o+"",Model_Menu.MenuType.EMPTY);
               }
               MenuItem item;
//                 int i = selectedIndex==index?1:0;
                 item  = new MenuItem(data);
                

                return item;
               
           };
        };

    }
    
}
