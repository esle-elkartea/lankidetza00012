/*
 * Imprimir.java
 *
 * Created on 2 de marzo de 2006, 14:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package bgc.gui.proy.nuevo;

import bgc.negocio.correo.ResultadoEnvio;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

/**
 *
 * @author Aitor
 */
public class Imprimir implements Printable{
    
    /** Creates a new instance of Imprimir */
    private PageFormat page;
    private ResultadoEnvio[]re;
    public Imprimir(ResultadoEnvio[]as) {
        setRs(as);
        setPage(new PageFormat());
        getPage().setOrientation(PageFormat.PORTRAIT);
        Paper p=new Paper();
        p.setImageableArea(0,0,551.19055118110236,870.8047244094488);
        getPage().setPaper(p);
    }
    
    /**
     * Prints the page at the specified index into the specified
     * {@link Graphics} context in the specified
     * format.  A <code>PrinterJob</code> calls the
     * <code>Printable</code> interface to request that a page be
     * rendered into the context specified by
     * <code>graphics</code>.  The format of the page to be drawn is
     * specified by <code>pageFormat</code>.  The zero based index
     * of the requested page is specified by <code>pageIndex</code>.
     * If the requested page does not exist then this method returns
     * NO_SUCH_PAGE; otherwise PAGE_EXISTS is returned.
     * The <code>Graphics</code> class or subclass implements the
     * {@link PrinterGraphics} interface to provide additional
     * information.  If the <code>Printable</code> object
     * aborts the print job then it throws a {@link PrinterException}.
     *
     * @param graphics the context into which the page is drawn
     * @param pageFormat the size and orientation of the page being drawn
     * @param pageIndex the zero based index of the page to be drawn
     * @return PAGE_EXISTS if the page is rendered successfully
     *         or NO_SUCH_PAGE if <code>pageIndex</code> specifies a
     * 	       non-existent page.
     * @exception java.awt.print.PrinterException
     *         thrown when the print job is terminated.
     */
    public int print(Graphics g,PageFormat f,int pageIndex) {
            
            if(pageIndex < 0) {
                return NO_SUCH_PAGE ;
            }
           
//        Paper p=f.getPaper();
//        p.setImageableArea(0,0,21.0,30.1);
//        f.setPaper(p);
            
            Graphics2D g2=(Graphics2D)g ;
//         g2.translate(0,0);
            Font defaultFont=g2.getFont() ;
            int x=30;
            int y=50;//80
            for (int i = 0;i<re.length;i++) {
                int pos=i;
                if ((re[pos]!=null)&&(pos<re.length)) {
                    if (i<3) {
                        y=50;
                    }else{
                        if (i>5){
                            if (i>8)
                            {
                                if (i>11){
                                    if (i>14){
                                            if (i>17)
                                            {
                                                y=((i/3)*100)+160;
                                            }else
                                        y=((i/3)*100)+140;
                                    }else
                                     y=((i/3)*100)+120;
                                }else y=((i/3)*100)+100;
                            }else     y=((i/3)*100)+80;
                        }else  y=((i/3)*100)+60;
                    }
                    if ((i%3) == 0) {
                        x= 30;
                        
                    } else {
                        x = x+200;
                        
                    }
                    Font normalFont=new Font("Arial",Font.BOLD,12) ;
                    g2.setFont(normalFont) ;
                    g2.drawString(re[pos].getCliente().getNombre() + " " + re[pos].getCliente().getApellido(), x,y);
                    y=y+15;
                    Font norFont=new Font("Arial",Font.PLAIN,12) ;
                    g2.setFont(norFont) ;
                    g2.drawString(re[pos].getCliente().getDireccion(), x,y) ;
                    y=y+15;
                    g2.drawString(re[pos].getCliente().getCP() + " " + re[pos].getCliente().getCiudad() ,x,y) ;
                    y=y+15;
                    g2.drawString(re[pos].getCliente().getProvincia(),x,y) ;
                    y=y+50;
                    
                } else {
                    
                    return PAGE_EXISTS;
                
                }
            }
           
            return PAGE_EXISTS ;
        }

    public PageFormat getPage() {
        return page;
    }

    public void setPage(PageFormat page) {
        this.page = page;
    }

    public ResultadoEnvio[] getRs() {
        return re;
    }

    public void setRs(ResultadoEnvio[] rs) {
        this.re = rs;
    }
    
}
