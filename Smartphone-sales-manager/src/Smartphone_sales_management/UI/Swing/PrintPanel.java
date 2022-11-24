/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Smartphone_sales_management.UI.Swing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Vuong
 */
public class PrintPanel {

    public void printRecord(JPanel panel) {
        PrinterJob printerjob = PrinterJob.getPrinterJob();
        printerjob.setJobName("Print");
        printerjob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

                if (pageIndex>0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D graphics2D = (Graphics2D) graphics;
                
                Dimension size= panel.getSize();

		graphics2D.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
		if (pageFormat.getWidth() != size.getWidth() 
				|| pageFormat.getHeight() != size.getHeight())
		{
			graphics2D.scale(pageFormat.getWidth() / size.getWidth(), 
				pageFormat.getHeight() / size.getHeight());
		}
//		.paint(grx);
                
                
//                graphics2D.translate(pageFormat.getImageableX()*2,pageFormat.getImageableY()*2);
//                graphics2D.scale(0.6,0.7);
                panel.paint(graphics2D);
                return Printable.PAGE_EXISTS;
            }
        });
       boolean  returningResult = printerjob.printDialog();
       if(returningResult)
       {
           try {
               printerjob.print();
           } catch (Exception e) {
               JOptionPane.showMessageDialog(panel,"error"+e.getMessage());
           }
       }
       
    }

}
