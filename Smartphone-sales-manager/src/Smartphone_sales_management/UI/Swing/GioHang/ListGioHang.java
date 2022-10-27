/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.UI.Swing.GioHang;

import Smartphone_sales_management.UI.Model.Model_GioHang;
import Smartphone_sales_management.UI.Model.Model_Menu;
import Smartphone_sales_management.UI.Swing.Menu.MenuItem;
import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import static Smartphone_sales_management.UI.Component.BanHangComponent.TableGioHang.selectedIndexGioHang;

/**
 *
 * @author Vuong
 */
public class ListGioHang<E extends Object> extends JList<E> {

    private final DefaultListModel model;

    public ListGioHang() {

        model = new DefaultListModel();
        setOpaque(false);
        setModel(model);
    }

    public void addItem(Model_GioHang data) {
        model.addElement(data);
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object o, int index, boolean isSelected, boolean cellHasFocus) {
                try {

                    Model_GioHang data;
                    if (o instanceof Model_GioHang) {
                        data = (Model_GioHang) o;
                    } else {
                        data = new Model_GioHang("", "", "", o + "", Model_GioHang.GioHangType.EMPTY, "");
                    }
                    GioHangItem item;
                    item = new GioHangItem(data);

                    Model_GioHang data;
                    if (o instanceof Model_GioHang) {
                        data = (Model_GioHang) o;
                    } else {
                        data = new Model_GioHang("", "", 1, o + "", Model_GioHang.GioHangType.EMPTY, "");
                    }
                    GioHangItem item;
                    if (selectedIndexGioHang == index) {
                        item = new GioHangItem(data, selectedIndexGioHang);

                    } else {
                        item = new GioHangItem(data, -1);

                    }

                    return item;
                } catch (IOException ex) {
                    Logger.getLogger(ListGioHang.class.getName()).log(Level.SEVERE, null, ex);

                }
                return null;
            }
        };
    }
}
