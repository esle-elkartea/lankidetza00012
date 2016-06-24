package bgc.gui.proy.nuevo;
import bgc.negocio.correo.ResultadoEnvio;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.ArrayList;
/**
 * La clase PanelLabel proporciona los métodos necesarios para imprimir
 * las etiquetas con los datos postales del cliente
 *
 * @author Campus - Telematika, S.L.
 *
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

public class PrintLabel implements Printable,Pageable{
    /**Array con los resultado de los envíos*/
    ResultadoEnvio re[];
    ArrayList AL;
    static int vez=0;
    
    /**Crea una nueva instancia de PrintLabel*/
    public PrintLabel(ResultadoEnvio []as) {
        re = as;
        AL=new ArrayList();
        int l=as.length;
        int i=0;
        while(i<l) {
             ResultadoEnvio []bas=new ResultadoEnvio[21];
                    for (int k=0;k<21;k++) {
                        if (i<l) {
                            bas[k]=as[i];
                            i++;
                        }
                    }
                    AL.add(new Imprimir(bas));
        }
    }
        /**Imprime las etiquetas con los datos postales del cliente*/
        public int print(Graphics g,PageFormat f,int pageIndex) {
//            if(pageIndex < 0) {
//                return NO_SUCH_PAGE ;
//            }
//            
////        Paper p=f.getPaper();
////        p.setImageableArea(0,0,21.0,30.1);
////        f.setPaper(p);
//            
//            Graphics2D g2=(Graphics2D)g ;
////         g2.translate(0,0);
//            Font defaultFont=g2.getFont() ;
//            int x=30;
//            int y=50;//80
//            for (int i = 0;i<re.length;i++) {
//                int pos=i;
//                if ((re[pos]!=null)&&(pos<re.length)) {
//                    if (i<3) {
//                        y=50;
//                    }else{y=((i/3)*100)+60;}
//                    if ((i%3) == 0) {
//                        x= 30;
//                        
//                    } else {
//                        x = x+200;
//                        
//                    }
//                    Font normalFont=new Font("Arial",Font.BOLD,12) ;
//                    g2.setFont(normalFont) ;
//                    g2.drawString(re[pos].getCliente().getNombre() + " " + re[pos].getCliente().getApellido(), x,y);
//                    y=y+15;
//                    Font norFont=new Font("Arial",Font.PLAIN,12) ;
//                    g2.setFont(norFont) ;
//                    g2.drawString(re[pos].getCliente().getDireccion(), x,y) ;
//                    y=y+15;
//                    g2.drawString(re[pos].getCliente().getCP() + " " + re[pos].getCliente().getCiudad() ,x,y) ;
//                    y=y+15;
//                    g2.drawString(re[pos].getCliente().getProvincia(),x,y) ;
//                    y=y+50;
//                    
//                } else return NO_SUCH_PAGE;
//            }
            return PAGE_EXISTS ;
        }
        
        /**
         * Returns the <code>Printable</code> instance responsible for
         * rendering the page specified by <code>pageIndex</code>.
         *
         * @param pageIndex the zero based index of the page whose
         *            <code>Printable</code> is being requested
         * @return the <code>Printable</code> that renders the page.
         * @throws IndexOutOfBoundsException if
         *            the <code>Pageable</code> does not contain the requested
         * 		  page.
         */
        public Printable getPrintable(int pageIndex) throws IndexOutOfBoundsException {
            
            
            return ((Imprimir)AL.get(vez++));
//            return ((Imprimir)AL.get(pageIndex));
        }
        
        /**
         * Returns the <code>PageFormat</code> of the page specified by
         * <code>pageIndex</code>.
         *
         * @param pageIndex the zero based index of the page whose
         *            <code>PageFormat</code> is being requested
         * @return the <code>PageFormat</code> describing the size and
         * 		orientation.
         * @throws IndexOutOfBoundsException if
         *          the <code>Pageable</code> does not contain the requested
         * 		page.
         */
        public PageFormat getPageFormat(int pageIndex) throws IndexOutOfBoundsException {
            return ((Imprimir)AL.get(pageIndex)).getPage();
        }
        
        /**
         * Returns the number of pages in the set.
         * To enable advanced printing features,
         * it is recommended that <code>Pageable</code>
         * implementations return the true number of pages
         * rather than the
         * UNKNOWN_NUMBER_OF_PAGES constant.
         *
         * @return the number of pages in this <code>Pageable</code>.
         */
        public int getNumberOfPages() {
            return AL.size();
        }
        
    }