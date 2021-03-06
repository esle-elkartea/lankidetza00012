package bgc.gui.proy.nuevo;
import bgc.ayuda.VAyuda;

import bgc.gui.inicio.VInicio;
import bgc.negocio.proyecto.Proyecto;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.plaf.metal.MetalInternalFrameUI;
/**
 * La clase VNuevoProy1 proporciona la interfaz necesaria para albergar el 
 * PanelNuevoProy1
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
public class VNuevoProy1 extends javax.swing.JInternalFrame {
    /**Panel que va ser el contenido de esta ventana*/
    PanelNuevoProy1 panel;
    /** Crea un nuevo Internal Frame VNuevoProy1*/
    public VNuevoProy1(Proyecto p) {
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
         jLabel4.add(botonCerrar);
         
          botonAyuda=new JLabel(new ImageIcon(getClass().getResource("/hermes/imagenes/iconos_barra/icono_ayuda.png")));
         botonAyuda.setSize(20,20);
         botonAyuda.setLocation(945,30);
         botonAyuda.setToolTipText("Visualizar la ayuda");
         botonAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 botonAyudaMouseEntered(evt);
             }
             public void mouseClicked(java.awt.event.MouseEvent evt){
                botonAyudaMouseClicked(evt);
             }
         });
         jLabel4.add(botonAyuda);
         
        ((MetalInternalFrameUI)getUI()).setNorthPane(null);
        pro = p;
        panel=new PanelNuevoProy1(pro,this);
        if (p!=null){
        this.panel.jTextField1.setText(p.getNombre());
        this.panel.jTextArea1.setText(p.getDescripcion());
        if (p.getTipo().equals("Manual")){
            this.panel.jRadioButton1.setSelected(true);
            }
        if (p.getTipo().equals("Automatizado")){
            this.panel.jRadioButton2.setSelected(true);
            }
        if (p.getTipo().equals("Especial")){
            this.panel.jRadioButton3.setSelected(true);
            }
        }
        jLabel4.add(panel);
        this.setSize(1024,670);
       panel.setLocation(65,130);
        panel.setSize(336, 256);
    }
    /**Cambia el cursor a modo mano*/
    private void botonCerrarMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    /**Vuelve a la ventana de inicio*/
    private void botonCerrarMouseClicked(java.awt.event.MouseEvent evt){
       VInicio v = new VInicio();
       this.getParent().add(v);
       this.dispose();
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
       v.show();
    }
    /**Cambia el cursos a modo mano*/
     private void botonAyudaMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonAyuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
     /**Lanza la ventana de ayuda*/
     private void botonAyudaMouseClicked(java.awt.event.MouseEvent evt){
         VAyuda ayuda=new VAyuda(null,true,"c:\\Archivos de Programa\\Campus-Telematika\\Hermes\\ayuda\\ANuevo.rtf");
         ayuda.setVisible(true);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(216, 228, 198));
        setBorder(null);
        setClosable(true);
        setTitle("Nuevo Proyecto (Paso 1)");
        jLabel4.setBackground(new java.awt.Color(240, 240, 240));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/proyecto/NuevoProyecto01_fondo.png")));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1023, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 661, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
    /**Datos del proyecto*/
    Proyecto pro;
    /**Icono bot�n cerrar*/
    javax.swing.JLabel botonCerrar;
    /**Icono boton ayuda*/
    javax.swing.JLabel botonAyuda;
}
