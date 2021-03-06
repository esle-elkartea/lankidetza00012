package bgc.gui.gbd;
import bgc.ayuda.VAyuda;

import bgc.bd.GestorBD;
import bgc.gui.inicio.VInicio;
import bgc.negocio.Cliente;
import bgc.negocio.Fecha;
import bgc.negocio.Utilidades;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.plaf.metal.MetalInternalFrameUI;
/**
 * La clase VVisorGestor proporciona la interfaz necesaria para albergar el PanelVisorGestro
 * y realizar una completa gesti�n de clientes en la base de datos
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
public class VVisorGestor extends javax.swing.JInternalFrame  {
    
    /**Panel que va a contener el VVIsorGestor*/
    PanelVisorGestor panel;
    /** Crea un nuevo Internal Frame VVisorGestor */
    public VVisorGestor(JDesktopPane d) {
        initComponents();
        ((MetalInternalFrameUI)this.getUI()).setNorthPane(null);
        this.setSize(1024, 670);
        botonCerrar=new JLabel(new ImageIcon(getClass().getResource("/hermes/imagenes/iconos_barra/icono_cerrar.png")));
        botonCerrar.setSize(20,20);
        botonCerrar.setLocation(970,26);
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
         botonAyuda.setLocation(950,26);
         botonAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 botonAyudaMouseEntered(evt);
             }
             public void mouseClicked(java.awt.event.MouseEvent evt){
                botonAyudaMouseClicked(evt);
             }
         });
         jLabel1.add(botonAyuda);
        panelPadre=d; 
        panel = new PanelVisorGestor(getPanelPadre(), this);
        panel.setLocation(50,100);
        this.panel.setSize(950, 550);
        this.jLabel1.setSize(800,700);
        jLabel1.add(panel);
      
        
       
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
        setClosable(true);
        setTitle("Gesti\u00f3n base datos ");
        setFrameIcon(null);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/gbd/GestionarBBDD_fondo.png")));
        getContentPane().add(jLabel1, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
     /**Cambia el cursor a mano*/
     private void botonCerrarMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
      /**Cierra la ventana VVisorGestor*/
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
      VAyuda ayuda=new VAyuda(null,true,"c:\\Archivos de Programa\\Campus-Telematika\\Hermes\\ayuda\\AGBD.rtf");
         ayuda.setVisible(true);
    }
     /**Carga los datos de los clientes de la base de datos en la jTable*/ 
    public void cargarListado() {
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector v=gbd.obtenerListado();
        Vector v1=gbd.obtenerCampos();
        gbd.cerrarBD();
        Object[][]ao=new Object[v.size()][v1.size()];
         for (int i=0;i<v.size();i++) {
            Cliente c=(Cliente)v.elementAt(i);
            ao[i][0]=c.getNombre() ;
            ao[i][1]=c.getApellido();
            ao[i][2]=c.getSexo();
            ao[i][3]=c.getDireccion();
            ao[i][4]=c.getCP();
            ao[i][5]=c.getCiudad();
            ao[i][6]=c.getProvincia();
            ao[i][7]=c.getEmail();
            ao[i][8]=c.getTelefono();
            ao[i][9]=c.getMovil();
            ao[i][10]=Fecha.ordenarFecha(c.getFechaNac().toString());
            if (v1.size()>Cliente.numCamposFijos+1) {
                ao[i][Cliente.numCamposFijos+1]=c.getExtra1();
                if (v1.size()>Cliente.numCamposFijos+2) {
                    ao[i][Cliente.numCamposFijos+2]=c.getExtra2();
                    if (v1.size()>Cliente.numCamposFijos+3) {
                        ao[i][Cliente.numCamposFijos+3]=c.getExtra3();
                        if (v1.size()>Cliente.numCamposFijos+4) {
                            ao[i][Cliente.numCamposFijos+4]=c.getExtra4();
                            
                        }
                    }
                }
            }
        
            
            
        }
       
        String ArrayCampos[] = new String[v1.size()];
         for (int i=0; i<v1.size();i++)
         {
             ArrayCampos[i] = Utilidades.nombreCampoAPantalla(v1.elementAt(i).toString());
         }
        
        panel.jTableListado.setModel(new javax.swing.table.DefaultTableModel(ao,ArrayCampos));
        
       
    }
    /**Carga los datos de los clientes resultados de una b�squeda avanzada que se pasan
     en el vector que se le pasa a la funci�n*/
    public void cargarListadoBusqueda(Vector v) {
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector v1=gbd.obtenerCampos();
        gbd.cerrarBD();
        Object[][]ao=new Object[v.size()][v1.size()]; for (int i=0;i<v.size();i++) {
            Cliente c=(Cliente)v.elementAt(i);
            ao[i][0]=c.getNombre() ;
            ao[i][1]=c.getApellido();
            ao[i][2]=c.getSexo();
            ao[i][3]=c.getDireccion();
            ao[i][4]=c.getCP();
            ao[i][5]=c.getCiudad();
            ao[i][6]=c.getProvincia();
            ao[i][7]=c.getEmail();
            ao[i][8]=c.getTelefono();
            ao[i][9]=c.getMovil();
            ao[i][10]=Fecha.ordenarFecha(c.getFechaNac().toString());
            if (v1.size()>Cliente.numCamposFijos) {
                ao[i][Cliente.numCamposFijos+1]=c.getExtra1();
                if (v1.size()>Cliente.numCamposFijos+1) {
                    ao[i][Cliente.numCamposFijos+2]=c.getExtra2();
                    if (v1.size()>Cliente.numCamposFijos+2) {
                        ao[i][Cliente.numCamposFijos+3]=c.getExtra3();
                        if (v1.size()>Cliente.numCamposFijos+3) {
                            ao[i][Cliente.numCamposFijos+4]=c.getExtra4();
                            
                        }
                    }
                }
       
            }
            
            
        }
         String ArrayCampos[] = new String[v1.size()];
         for (int i=0; i<v1.size();i++)
         {
             ArrayCampos[i] = Utilidades.nombreCampoAPantalla(v1.elementAt(i).toString());
         }
        panel.jTableListado.setModel(new javax.swing.table.DefaultTableModel(ao,ArrayCampos));
       
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    /**Panel que contiene a VVisorGestor*/
    private JDesktopPane panelPadre;
      /**Icono para cerrar la ventana*/
    javax.swing.JLabel botonCerrar;
    /**NOs devuelve el panel padre*/
    public JDesktopPane getPanelPadre() {
        return panelPadre;
    }
    /**Icono boton ayuda*/ 
    javax.swing.JLabel botonAyuda;
}
