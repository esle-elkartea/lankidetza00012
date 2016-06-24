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
import java.awt.Cursor;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que crea los bordes redimensionables
 * @author Campus-Telematika S.L.
 */
public class JLabelBorde extends JPanel implements MouseListener{
    
    
    /**
     * Cursor Redimensionable al Norte
     */
    public static final int N=0;//NORTE
    /**
     * Cursor Redimensionable al NorEste
     */
    public static final int NE=1;//NORESTE
    /**
     * Cursor Redimensionable al Este
     */
    public static final int E=2;//ESTE
    /**
     * Cursor Redimensionable al SurEste
     */
    public static final int SE=3;//SURETE
    /**
     * Cursor Redimensionable al Sur
     */
    public static final int S=4;//SUR
    /**
     * Cursor Redimensionable al SurOeste
     */
    public static final int SO=5;//SUROESTE
    /**
     * Cursor Redimensionable al Oeste
     */
    public static final int O=6;//OESTE
    /**
     * Cursor Redimensionable al NorOeste
     */
    public static final int NO=7;//NOROESTE
    
    
    /**
     * JLabel Padre
     */
    private JLabel padre;
    /**
     * Tipo de borde
     */
    private int tipo;
    /**
     * Creates a new instance of JLabelBorde
     * @param padre JLabel Padre
     * @param tipo tipo de borde
     * @param c Color del borde
     */
    public JLabelBorde(JLabel padre,int tipo,Color c) {
        
        this.padre=padre;
        this.tipo=tipo;
        this.setSize(6,6);
        this.setBackground(c);
        this.setOpaque(true);
        this.addMouseListener(this);
        posicionar();
        
    }
    
   
    
    /**
     * Posiciona el borde
     */
    public void posicionar() {
        

        switch(tipo) {
            case N:{
                    
                this.setLocation((int)(padre.getSize().getWidth()/2)-3,1);
            
                }break;
            
            case NE:{
                this.setLocation(1,1);
            }break;
            case E:{
                this.setLocation(1,(int)(padre.getSize().getHeight()/2)-3);
            }break;
            case SE:{
                this.setLocation(1,(int)(padre.getSize().getHeight())-6);
            }break;
            case S:{
                this.setLocation((int)(padre.getSize().getWidth()/2)-3,(int)(padre.getSize().getHeight())-6);
            }break;
            case SO:{
                this.setLocation((int)padre.getSize().getWidth()-6,(int)padre.getSize().getHeight()-6);
            }break;
            case O:{
                this.setLocation((int)(padre.getSize().getWidth())-6,(int)(padre.getSize().getHeight()/2)-6);
            }break;
            case NO:{
                this.setLocation((int)(padre.getSize().getWidth())-6,1);
            }break;
            
          
            
        }
        

          this.padre.repaint();
    }
    
    /**
     * Posiciona de nuevo el borde
     * @param e Evento
     */
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
         ((JLabelHermes)padre).redimensionar(e.getX(),e.getY());
         this.posicionar();
    }
    
    /**
     * 
     * @param e 
     */
    public void mousePressed(java.awt.event.MouseEvent e) {
       // padre.dibujarRect(e.getX(),e.getY());
    }
    
    /**
     * Cambia el cursor a normal
     * @param e Evento
     */
    public void mouseExited(java.awt.event.MouseEvent e) {
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    /**
     * Cambia el cursor al tipo redimensionable  correspondiente
     * @param e Evento
     */
    public void mouseEntered(java.awt.event.MouseEvent e) {
        switch(tipo) {
            case N:{
                    
                this.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
            
                }break;
            
            case NE:{
                 this.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
            }break;
            case E:{
                 this.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
            }break;
            case SE:{
                this.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
            }break;
            case S:{
                 this.setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
            }break;
            case SO:{
                 this.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
            }break;
            case O:{
                 this.setCursor(new Cursor(Cursor.W_RESIZE_CURSOR));
            }break;
            case NO:{
                 this.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
            }break;
            
            
        }
        
        
    }
    
    /**
     * 
     * @param e 
     */
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }
    
}
