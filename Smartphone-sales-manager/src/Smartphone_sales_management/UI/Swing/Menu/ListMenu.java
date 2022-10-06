/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.UI.Swing.Menu;

import Smartphone_sales_management.UI.Event.EventMenu;
import Smartphone_sales_management.UI.Model.Model_Menu;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import static Smartphone_sales_management.UI.Main.MainFrame.selectedIndex;

/**
 *
 * @author Vuong
 */
public class ListMenu<E extends Object >extends JList<E> {
     private final DefaultListModel model;
     
         private EventMenu event;

      public void addEventMenu(EventMenu event) {
          this.event=event;
    }
     
     
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
               if(selectedIndex==index)
               {
                 item  = new MenuItem(data,selectedIndex);

               }
               else
               {
                 item  = new MenuItem(data,-1);

               }
                

                return item;
               
           };
        };

    }

   
    
}
