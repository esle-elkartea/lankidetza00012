package bgc.gui.gbd;

import bgc.negocio.Fecha;
import java.util.GregorianCalendar;
import javax.swing.JTextField;
/**
 * La clase VCalendario proporciona la interfaz necesaria para albergar el panel
 * calendario que permite visualizar y seleccionar fechas.
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
public class VCalendario extends javax.swing.JDialog {
    
   /**Panel con calendario grafico*/ 
   PanelCalendario panel;
   /**Fecha a modificar*/
   private JTextField texto;
   /** Crea un nuevo jDialog VCalendario */
    public VCalendario(java.awt.Frame parent, boolean modal,JTextField texto) {
	super(parent, modal);
	initComponents();
	this.texto=texto;
        panel=new PanelCalendario(this);
        this.add(panel);
        panel.setLocation(5,70);
        panel.setSize(296, 296);
        this.setSize(300, 300);
	GregorianCalendar c = new GregorianCalendar();
	this.panel.jCalendar1.setCalendar(c);
   }
/**Devuelve el JTextField Texto*/
    public JTextField getTexto() {
        return texto;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(100, 150, 225));
        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
