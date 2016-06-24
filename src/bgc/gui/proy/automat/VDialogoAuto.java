package bgc.gui.proy.automat;
import bgc.ayuda.VAyuda;
import bgc.bd.GestorBD;
import bgc.gui.inicio.VInicio;
import bgc.negocio.Cliente;
import bgc.negocio.Fecha;
import bgc.negocio.proyecto.LeerProy;
import bgc.negocio.proyecto.Proyecto;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.plaf.metal.MetalInternalFrameUI;
/**
 * La clase VDialogoAuto ofrece la interfaz necesaria para 
 * contener el panel abrir que visualizara los detalles de los proyectos
 * automatizados en curso.
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
public class VDialogoAuto extends javax.swing.JInternalFrame {
    /**Panel que será el contenido de VDialogoAuto*/
    PanelAbrir panel;
    /**Fichero con los datos del proyecto*/
    File ficherito;
    /**Proyecto a abrir*/
    Proyecto p;
    /**
     * Crea una nueva instancia de VDialogoAuto
     */
    public VDialogoAuto(File f) {
        ficherito = f;
        initComponents();
        panel=new PanelAbrir(f,this);
        jLabel1.add(panel);
        this.setSize(1024, 670);
        panel.setLocation(60,120);
        panel.setSize(920, 525);
        inicializar();
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
         botonAyuda.setToolTipText("Visualizar la ayuda");
         botonAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 botonAyudaMouseEntered(evt);
             }
             public void mouseClicked(java.awt.event.MouseEvent evt){
                botonAyudaMouseClicked(evt);
             }
         });
         jLabel1.add(botonAyuda);
        
        ((MetalInternalFrameUI)this.getUI() ).setNorthPane(null);
    }
     /**Cambia el cursor a mano*/
      private void botonAyudaMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonAyuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
      /**Muestra la ayuda*/
     private void botonAyudaMouseClicked(java.awt.event.MouseEvent evt){
        VAyuda ayuda=new VAyuda(null,true,getClass().getResource("/bgc/ayuda/proyecto/auto/AGBD.rtf").getPath().replaceAll("%20"," "));
         ayuda.setVisible(true);
    }
     /**Inicializa los datos que se quieren cargar en el PanelAbrir*/
    public void inicializar() {
        
        panel.textoNombre.setEnabled(false);
        panel.textoDescripcion.setEnabled(false);
        
        
        
        this.panel.tablaDestinatarios.setEnabled(false);
        
        
        LeerProy lectura = new LeerProy();
        try {
            lectura.abrir(ficherito);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        p = new Proyecto();
        p = lectura.leer(ficherito);
        this.panel.textoNombre.setText(p.getNombre());
        this.panel.textoDescripcion.setText(p.getDescripcion());
        
        if (p.getTipo().equals("Automatizado")){
            panel.labelTipo.setText("Automatizado");
        }else if(p.getTipo().equals("Especial")){
            panel.labelTipo.setText("Especial");
        }

        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector v = gbd.obtenerListadoAbrir(p.getSql());
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
            ao[i][7]=c.getTelefono();
            ao[i][8]=c.getMovil();
            ao[i][9]=c.getEmail();
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
        panel.tablaDestinatarios.getTableHeader().setFont(new Font("Arial",Font.BOLD,12));
        panel.tablaDestinatarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        panel.tablaDestinatarios.setCellEditor(null);
        panel.tablaDestinatarios.enableInputMethods(false);
        panel.tablaDestinatarios.setAutoscrolls(true);
        
        String ArrayCampos[] = new String[v1.size()];
        for (int i=0; i<v1.size();i++) {
            ArrayCampos[i] = v1.elementAt(i).toString();
        }
        panel.tablaDestinatarios.setModel(new javax.swing.table.DefaultTableModel(ao,ArrayCampos));
     
        
        lectura.cerrar();
        
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modfy this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(216, 228, 198));
        setBorder(null);
        setClosable(true);
        setTitle("Abrir proyecto");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/abrir_mailing/abrir_mailing.png")));
        getContentPane().add(jLabel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   /**Cambia el cursor a mano*/
    private void botonCerrarMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    /**Cierra la ventana actual*/
    private void botonCerrarMouseClicked(java.awt.event.MouseEvent evt){
          this.dispose();
    }
    /**Incializa los datos del PanelAbrir*/
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
// TODO add your handling code here:
        
        inicializar();
    }//GEN-LAST:event_formInternalFrameActivated
    /**Vuelve a la pantalla de inicio*/
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
// TODO add your handling code here:
        VInicio v = new VInicio();
        this.getParent().add(v);
        this.dispose();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2-50);
        v.show();
    }//GEN-LAST:event_formInternalFrameClosing
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    /**Icono para cerrar la ventana*/
   javax.swing.JLabel botonCerrar;
   /**Icono para mostrar la ayuda*/
    javax.swing.JLabel botonAyuda;
}
