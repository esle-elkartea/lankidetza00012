/*
* This program is free software; you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA.
 */

package bgc.gui.wysiwyg.draganddrop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.JPanel;

/**
 * Clase Panel donde se diseñara el HTML
 * @author Campus-Telematika S.L.
 */

public class JPanelHermes extends JPanel implements Printable {
    
    
    /**
     * Crea un nuevo JPanelHermes
     */
    public JPanelHermes() {
        super();
    }
    
    /**
     * Retorna la posicion del componente mas alejado del borde superior
     * @return posicion del componente mas alejado del borde superior
     */
    public int getMaxPosicion() {
        int pos =0;
        
        for (int i=0;i<getComponentCount();i++)
            
            if (pos < (getComponent(i).getX()+getComponent(i).getWidth()))
                pos=getComponent(i).getX()+getComponent(i).getWidth();
        
        return pos;
    }
    
    
    /**
     * Imprime el contenido del Panel
     * @param g Graphics
     * @param pf Formato de l apagina
     * @param pi formato 
     * @throws java.awt.print.PrinterException 
     * @return 
     */
    public int print(Graphics g, PageFormat pf, int pi) throws PrinterException {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);
        
        Dimension d = this.getSize(); //get size of document
        double panelWidth = getMaxPosicion();//d.width; //width in pixels
        double panelHeight = d.height; //height in pixels
        
        double pageHeight = pf.getImageableHeight(); //height of printer page
        double pageWidth = pf.getImageableWidth(); //width of printer page
        
        double scale = pageWidth/panelWidth;
        int totalNumPages = (int)Math.ceil(scale * panelHeight / pageHeight);
        
        //make sure not print empty pages
        if(pi >= totalNumPages) {
            return Printable.NO_SUCH_PAGE;
        }
        
        //shift Graphic to line up with beginning of print-imageable region
        g2.translate(pf.getImageableX(), pf.getImageableY());
        
        //shift Graphic to line up with beginning of next page to print
        g2.translate(0f, - pi * pageHeight);
        
        //scale the page so the width fits...
        g2.scale(scale, scale);
        
        this.paint(g2); //repaint the page for printing
        
        return Printable.PAGE_EXISTS;
        
                /*if (pi>=0)
                {
                        return Printable.NO_SUCH_PAGE;
                }
                g.translate(100,100);
                paint(g);
                return Printable.PAGE_EXISTS;*/
    }
    
}