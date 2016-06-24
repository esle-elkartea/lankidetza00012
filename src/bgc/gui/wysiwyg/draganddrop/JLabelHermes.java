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

import bgc.gui.wysiwyg.draganddrop.clases.ExtendedHTMLDocument;
import bgc.gui.wysiwyg.draganddrop.clases.ExtendedHTMLEditorKit;
import bgc.gui.wysiwyg.draganddrop.clases.PrintPane;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

/**
 * Clase de
 * @author Campus-Telematika S.L.
 */
class JLabelHermes extends JLabel implements FocusListener {
    /**
     * Tipo de componente
     */
    private int tipo;
    /**
     * Nombre de la imagen
     */
    private String nombreImagen;
    
    /**
     * Area de Texto
     */
    private JTextPane area;
    /**
     * capa de control de eventos
     */
    private JLabel capa;
    /**
     * Tipo de Fuente
     */
    private Font fuente;
    /**
     * Color de la fuente
     */
    private Color colorFuente;
    
    /**
     * Tipo de Componente TEXTO
     */
    public static final int TEXTO=0;
    /**
     * Tipo de Componente IMAGEN
     */
    public static final int IMAGEN=1;
    
    /**
     * Crea una nueva JLabelHermes
     * @param tipo Tipo de Componente
     */
    public JLabelHermes(int tipo) {
        super();
        setCapa(new JLabel());
        getCapa().setSize(this.getSize());
        
        // getCapa().setOpaque(false);
        //  getCapa().setOpaque(true);
        getCapa().setBackground(Color.green);
        this.setLayout(null);
        
        this.setBorder(new LineBorder(Color.GRAY,1));
        this.tipo=tipo;
        if(tipo==TEXTO) {
            area=new PrintPane();
            ExtendedHTMLEditorKit htmlKit = new ExtendedHTMLEditorKit();
            ExtendedHTMLDocument htmlDoc = (ExtendedHTMLDocument)(htmlKit.createDefaultDocument());
            htmlKit.setDefaultCursor(new Cursor(Cursor.TEXT_CURSOR));
            this.area.setCursor(new Cursor(Cursor.TEXT_CURSOR));
            this.area.setBorder(null);
            
            /* Set up the text pane */
            area.setEditorKit(htmlKit);
            area.setDocument(htmlDoc);
            area.setAutoscrolls(true);
            
            this.add(area);
            area.setEditable(false);
//            area.setEnabled(false);
            area.setLocation(5,5);
            area.addFocusListener(this);
            
        }
        //this.add(getCapa(),-1);
        
        getCapa().grabFocus();
        setFuente(new Font("Verdana", Font.PLAIN, 10));
        setColorFuente(new Color(0));
//        getCapa().setOpaque(true);
        this.add(getCapa(),-1);
       
        
    }
    
    /**
     * Retorna el tipo de Componente
     * @return Tipo de Componente
     */
    public int getTipo(){return tipo;}
    /**
     * Modifica el Tipo de Componente
     * @param tipo Tipo de Componente
     */
    public void setTipo(int tipo){this.tipo=tipo;}
    
    /**
     * Retorna el nombre de la Imagen
     * @return nombre de la Imagen
     */
    public String getNombreImagen(){return nombreImagen;}
    /**
     * Modifica el nombre de la imagen
     * @param n nombre de la Imagen
     */
    public void setNombreImagen(String n){nombreImagen=n;}
    
    /**
     * Rediemnsiona el componente
     * @param x nueva X
     * @param y nueva Y
     */
    public void redimensionar(int x,int y) {
        
        this.getCapa().setSize(this.getCapa().getWidth()+x,this.getCapa().getHeight()+y);
        this.setSize(this.getWidth()+x+5,this.getHeight()+ y+5);
        this.getParent().repaint();
        if(getTipo()==JLabelHermes.IMAGEN) {
            ImageIcon xxx=new ImageIcon(getNombreImagen());
            setIcon(new ImageIcon(xxx.getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_DEFAULT)));
            
        }else if (getTipo()==JLabelHermes.TEXTO){
            this.getArea().setSize(getWidth()-10,getHeight()-10);
            
        }
       
            this.cambiarBorde();
        
        this.repaint();
        this.getParent().repaint();
        
    }
    
    
    /**
     * Compara dos Componentes
     * @param j Componente 
     * @return Si es menor el objeto en curso retorna true
     */
    public boolean esMenor(JLabelHermes j) {
        if ((getLocation().getX()<j.getLocation().getX())&&(getLocation().getY()<j.getLocation().getY()))
            return true;
        return false;
    }
    
    /**
     * Retorna el Area
     * @return Area
     */
    public JTextPane getArea() {
        return area;
    }
    
    /**
     * Modifica el Area
     * @param area Area
     */
    public void setArea(JTextPane area) {
        this.area = area;
    }
  
    /**
     * Retorna la capa
     * @return capa
     */
    public JLabel getCapa() {
        return capa;
    }
    
    /**
     * Modifica la capa
     * @param capa capa
     */
    public void setCapa(JLabel capa) {
        this.capa = capa;
    }
    
    /**
     * Modifica el tamaño del Componente
     * @param w ancho
     * @param h alto
     */
    public void setSize(int w,int h) {
        super.setSize(w,h);
        getCapa().setSize(w,h);
    }
    
    /**
     * Pierde el foco
     * @param e Evento
     */
    public void focusLost(FocusEvent e) {
        area.setEditable(false);
        area.setEnabled(false);
    }
    
    /**
     * Gana el foco
     * @param e Evento
     */
    public void focusGained(FocusEvent e) {
    }
    
    /**
     * Retorna la fuente
     * @return Fuente
     */
    public Font getFuente() {
        return fuente;
    }
    
    /**
     * Modifica la fuente
     * @param fuente Fuente nueva
     */
    public void setFuente(Font fuente) {
        this.fuente = fuente;
    }
    
    /**
     * Retorna el color de la fuente
     * @return color de la fuente
     */
    public Color getColorFuente() {
        return colorFuente;
    }
    
    /**
     * Modifica el color de la fuente
     * @param colorFuente color de la fuente
     */
    public void setColorFuente(Color colorFuente) {
        this.colorFuente = colorFuente;
    }
    
    /**
     * Añade el borde
     * @param c Color del borde
     */
    public void anyadirBorde(Color c) {
        for(int i=0;i<8;i++) {
            this.getCapa().add(new JLabelBorde(this,i,c));
            
        }
    }
    /**
     * cambia de posicion el borde
     */
    public void cambiarBorde() {
        for(int i=0;i<8;i++) {
            ((JLabelBorde)this.getCapa().getComponent(i)).posicionar();
        }
        
    }
}