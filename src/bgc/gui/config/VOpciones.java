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

package bgc.gui.config;

import bgc.ayuda.VAyuda;
import bgc.gui.inicio.VInicio;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.plaf.metal.MetalInternalFrameUI;

/**
 * Ventana de las opciones de configuración
 * @author Campus-Telematika S.L.
 */
public class VOpciones extends javax.swing.JInternalFrame {
    
    PanelOpciones panel;
    
    /** Creates new form VOpciones */
    public VOpciones() {
        initComponents();
         botonCerrar=new JLabel(new ImageIcon(getClass().getResource("/hermes/imagenes/iconos_barra/icono_cerrar.png")));
         botonCerrar.setSize(20,20);
         botonCerrar.setLocation(965,30);
         botonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 botonCerrarMouseEntered(evt);
             }
             public void mouseClicked(java.awt.event.MouseEvent evt){
                botonCerrarMouseClicked(evt);
             }
         });
         jLabel1.add(botonCerrar);
         
          botonAyuda=new JLabel(new ImageIcon(getClass().getResource("/hermes/imagenes/iconos_barra/icono_ayuda.png")));
         botonAyuda.setSize(20,20);
         botonAyuda.setLocation(945,30);
         botonAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 botonAyudaMouseEntered(evt);
             }
             public void mouseClicked(java.awt.event.MouseEvent evt){
                botonAyudaMouseClicked(evt);
             }
         });
         jLabel1.add(botonAyuda);
        ((MetalInternalFrameUI)this.getUI()).setNorthPane(null);
        panel=new PanelOpciones();
       
        
        this.jLabel1.add(panel);
        
        this.setSize(1024,670);
       panel.setLocation(60,120);
        panel.setSize(900,500);
        
        
        validate();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(216, 228, 198));
        setBorder(null);
        setFrameIcon(null);
        jLabel1.setBackground(new java.awt.Color(216, 228, 198));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/configuracion/pantalla_configuracion_fond.png")));
        getContentPane().add(jLabel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Camnbia el cursor a mano
     * @param evt 
     */
    private void botonCerrarMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    /**
     * cierra la ventana
     * @param evt 
     */
    private void botonCerrarMouseClicked(java.awt.event.MouseEvent evt){
       VInicio v = new VInicio();
       this.getParent().add(v);
       this.dispose();
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
       v.show();
    }
    /**
     * cambia el cursor a mano
     * @param evt 
     */
     private void botonAyudaMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonAyuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    /**
     * Muestra la ayuda
     * @param evt 
     */
     private void botonAyudaMouseClicked(java.awt.event.MouseEvent evt){
      VAyuda ayuda=new VAyuda(null,true,"c:\\Archivos de Programa\\Campus-Telematika\\Hermes\\ayuda\\AOpcion.rtf");
         ayuda.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    javax.swing.JLabel botonCerrar;
    javax.swing.JLabel botonAyuda;
}
