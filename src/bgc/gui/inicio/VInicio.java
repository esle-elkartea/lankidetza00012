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

package bgc.gui.inicio;
import bgc.ayuda.VAyuda;

import bgc.gui.VContenedor;
import bgc.gui.config.VOpciones;
import bgc.gui.gbd.VVisorGestor;
import bgc.gui.proy.abrir.VAbrir;
import bgc.gui.proy.automat.VAutomat;
import bgc.gui.proy.nuevo.VNuevoProy1;
import bgc.gui.wysiwyg.draganddrop.VHTMLDND;
import java.awt.Cursor;
import java.awt.Dimension;
import java.beans.PropertyVetoException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.metal.MetalInternalFrameUI;
/**
 * Ventana con el menu principal
 * @author Campus-Telematika S.L.
 */public class VInicio extends javax.swing.JInternalFrame  {
     Image imagen;
     /** Creates new form VInicio */
    
     public VInicio() {
         initComponents();
         inicializar();
         ((MetalInternalFrameUI)this.getUI()).setNorthPane(null);
     }
     
    /**
     * Inicializa los componentes visuales
     */
     public void inicializar() {
         botonCerrar=new JLabel(new ImageIcon(getClass().getResource("/hermes/imagenes/iconos_barra/icono_cerrar.png")));
         botonCerrar.setSize(20,20);
         botonCerrar.setLocation(480,22);
         botonCerrar.setToolTipText("Cerrar Hermes");
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
         botonAyuda.setLocation(450,22);
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
         
         botonNuevo=new JLabel(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botNuevoProyecto.png")));
         botonNuevo.setSize(228,77);
         botonNuevo.setLocation(30,130);
         botonNuevo.setToolTipText("Crear un nuevo mailing");
         botonNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 botonNuevoMouseEntered(evt);
             }
         });
         botonNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseExited(java.awt.event.MouseEvent evt) {
                 botonNuevoMouseExited(evt);
             }
         });
         botonNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 botonNuevoMouseClicked(evt);
             }
         });
         
         jLabel1.add(botonNuevo);
         
         botonAbrir=new JLabel(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botAbrirProyecto.png")));;
         botonAbrir.setSize(228,77);
         botonAbrir.setLocation(265,130);
         botonAbrir.setToolTipText("Abrir un mailing existente");
         botonAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 botonAbrirMouseEntered(evt);
             }
         });
         botonAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseExited(java.awt.event.MouseEvent evt) {
                 botonAbrirMouseExited(evt);
             }
         });
         botonAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 botonAbrirMouseClicked(evt);
             }
         });
         jLabel1.add(botonAbrir);
         
         botonGBD=new JLabel(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botGestionarBBDD.png")));;
         botonGBD.setSize(228,77);
         botonGBD.setLocation(30,210);
         botonGBD.setToolTipText("Gestionar la Base de Datos");
         botonGBD.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 botonGBDMouseEntered(evt);
             }
         });
         botonGBD.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseExited(java.awt.event.MouseEvent evt) {
                 botonGBDMouseExited(evt);
             }
         });
         botonGBD.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 botonGBDMouseClicked(evt);
             }
         });
         
         jLabel1.add(botonGBD);
         
         botonHTML=new JLabel(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botCrearHTML.png")));;
         botonHTML.setSize(228,77);
         botonHTML.setLocation(265,210);
         botonHTML.setToolTipText("Abrir el diseñador de HTML");
         botonHTML.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 botonHTMLMouseEntered(evt);
             }
         });
         botonHTML.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseExited(java.awt.event.MouseEvent evt) {
                 botonHTMLMouseExited(evt);
             }
         });
          botonHTML.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 botonHTMLMouseClicked(evt);
             }
         });
         
         jLabel1.add(botonHTML);
         
         botonAuto=new JLabel(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botProyectosAuto.png")));;
         botonAuto.setSize(228,77);
         botonAuto.setLocation(30,290);
         botonAuto.setToolTipText("Ver mailings programados");
         botonAuto.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 botonAutoMouseEntered(evt);
             }
         });
         botonAuto.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseExited(java.awt.event.MouseEvent evt) {
                 botonAutoMouseExited(evt);
             }
         });
         
         botonAuto.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 botonAutoMouseClicked(evt);
             }
         });
         jLabel1.add(botonAuto);

         botonConfig=new JLabel(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botConfiguracion.png")));;
         botonConfig.setSize(228,77);
         botonConfig.setLocation(265,290);
         botonConfig.setToolTipText("Opciones de Configuración");
          botonConfig.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseEntered(java.awt.event.MouseEvent evt) {
                 botonConfigMouseEntered(evt);
             }
         });
          botonConfig.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseExited(java.awt.event.MouseEvent evt) {
                 botonConfigMouseExited(evt);
             }
         });
         botonConfig.addMouseListener(new java.awt.event.MouseAdapter() {
             public void mouseClicked(java.awt.event.MouseEvent evt) {
                 botonConfigMouseClicked(evt);
             }
         });
         
         jLabel1.add(botonConfig);
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
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/inicio/PantallaInicial_fondo.png")));
        getContentPane().add(jLabel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Actualiza las imagenes de la botonera
     * @param evt 
     */
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
// TODO add your handling code here:
        ((VContenedor)this.getParent().getParent().getParent().getParent().getParent()).actualizarBotonera(0);
    }//GEN-LAST:event_formInternalFrameActivated
    
    /**
     * cambia el icono a mano
     * @param evt 
     */
    private void botonCerrarMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonCerrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    /**
     * cierra la aplicación
     * @param evt 
     */
     private void botonCerrarMouseClicked(java.awt.event.MouseEvent evt){
        Object []botones={"Salir","Minimizar"};
        if(JOptionPane.showOptionDialog(null,"¿Desea salir o minimizar la aplicación?","Confirmación de salida",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,botones,botones[0])==JOptionPane.OK_OPTION) {
            this.dispose();
            System.exit(0);
        }else {
            ((VContenedor)this.getParent().getParent().getParent().getParent().getParent()).hide();
        }
    }
     
    /**
     * cambia el icono a mano
     * @param evt 
     */
     private void botonAyudaMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonAyuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    /**
     * muestra la ayuda
     * @param evt 
     */
     private void botonAyudaMouseClicked(java.awt.event.MouseEvent evt){

         VAyuda ayuda=new VAyuda(null,true,"c:\\Archivos de Programa\\Campus-Telematika\\Hermes\\ayuda\\AInicio.rtf");
         ayuda.setVisible(true);
    }
     
    /**
     * cambia el icono a mano
     * @param evt 
     */
    private void botonAbrirMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonAbrir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonAbrir.setIcon(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botAbrirProyecto_over.png")));
    }
    /**
     * cambia el icono a normal
     * @param evt 
     */
     private void botonAbrirMouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonAbrir.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        botonAbrir.setIcon(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botAbrirProyecto.png")));
    }
    
    /**
     * muestra la ventana de Abrir
     * @param evt 
     */
    private void botonAbrirMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        VContenedor.VentanaActual=VContenedor.AbrirProyecto;
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Abrir proyecto");
        FileFilter filtroObj = new FileFilter() {
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".bgc") || f.isDirectory();
            }
            public String getDescription() {
                return "Proyectos Hermes";
            }
        };
        chooser.setFileFilter(filtroObj);
        
        chooser.setCurrentDirectory(new java.io.File("C:\\Archivos de programa\\Campus-Telematika\\Hermes"));
        int resultado = chooser.showOpenDialog(this.getParent());
        if (resultado == JFileChooser.APPROVE_OPTION){
            File ficheroSeleccionado = chooser.getSelectedFile();
            VAbrir v = new VAbrir(ficheroSeleccionado);
            this.getParent().add(v);
            ((VContenedor)this.getParent().getParent().getParent().getParent().getParent()).actualizarBotonera(2);
            this.dispose();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
            v.show();
        }
    }
    
    /**
     * cambia el icono a mano
     * @param evt 
     */
    private void botonNuevoMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonNuevo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonNuevo.setIcon(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botNuevoProyecto_over.png")));
    }
    
    /**
     * cambia el icono a normal
     * @param evt 
     */
     private void botonNuevoMouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonNuevo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        botonNuevo.setIcon(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botNuevoProyecto.png")));
    }
    
    /**
     * muestra la ventana de Nuevo mailing
     * @param evt 
     */
    private void botonNuevoMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        VContenedor.VentanaActual=VContenedor.NuevoProyecto;
        VNuevoProy1 v=new VNuevoProy1(null);
        this.getParent().add(v);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
        ((VContenedor)this.getParent().getParent().getParent().getParent().getParent()).actualizarBotonera(1);
        this.dispose();
        v.show();
    }
    
    /**
     * cambia el icono a mano
     * @param evt 
     */
    private void botonGBDMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonGBD.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonGBD.setIcon(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botGestionarBBDD_over.png")));
    }
    /**
     * cambia el icono a normal
     * @param evt 
     */
    private void botonGBDMouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonGBD.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        botonGBD.setIcon(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botGestionarBBDD.png")));
    }
    
    /**
     * muestra la ventana de Gestor de clientes
     * @param evt 
     */
    private void botonGBDMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
       VContenedor.VentanaActual=VContenedor.GBBDD;
       VVisorGestor v = new VVisorGestor((JDesktopPane)this.getParent());
       ((JDesktopPane)this.getParent()).add(v);
       ((VContenedor)this.getParent().getParent().getParent().getParent().getParent()).actualizarBotonera(3);
       this.dispose();
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
       v.show();
    }
    
    /**
     * cambia el icono a mano
     * @param evt 
     */
    private void botonHTMLMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonHTML.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonHTML.setIcon(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botCrearHTM_over.png")));
    }
    
    /**
     * cambia el icono a normal
     * @param evt 
     */
    private void botonHTMLMouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonHTML.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        botonHTML.setIcon(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botCrearHTML.png")));
    }
    /**
     * muestra la ventana de Diseñador
     * @param evt 
     */
     private void botonHTMLMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        VContenedor.VentanaActual=VContenedor.CrearHTML;
        VHTMLDND v = new VHTMLDND();
        this.getParent().add(v);
        ((JDesktopPane)this.getParent()).setSelectedFrame(v);
        ((VContenedor)this.getParent().getParent().getParent().getParent().getParent()).actualizarBotonera(4);
        this.dispose();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        v.setSize(screenSize.width-80,screenSize.height-120);
        v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
        v.show();
    }
    
    /**
     * cambia el icono a mano
     * @param evt 
     */
    private void botonAutoMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonAuto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonAuto.setIcon(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botProyectosAuto_over.png")));
    }
    /**
     * cambia el icono a normal
     * @param evt 
     */
    private void botonAutoMouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonAuto.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        botonAuto.setIcon(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botProyectosAuto.png")));
    }
    
    /**
     * muestra la ventana de mailings programados
     * @param evt 
     */
    private void botonAutoMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        VContenedor.VentanaActual=VContenedor.ProyectAuto;
        VAutomat v=new VAutomat();
        this.getParent().add(v);
        ((VContenedor)this.getParent().getParent().getParent().getParent().getParent()).actualizarBotonera(5);
        this.dispose();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
        v.show();
    }
    
    /**
     * cambia el icono a mano
     * @param evt 
     */
     private void botonConfigMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonConfig.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonConfig.setIcon(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botConfiguracion_over.png")));
    }
    /**
     * cambia el icono a normal
     * @param evt 
     */
    private void botonConfigMouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        botonConfig.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        botonConfig.setIcon(new ImageIcon(getClass().getResource("/hermes/imagenes/inicio/botConfiguracion.png")));
    }
    
    /**
     * muestra la ventana de configuración
     * @param evt 
     */
    private void botonConfigMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        VContenedor.VentanaActual=VContenedor.Configuracion;
        VOpciones v=new VOpciones();
        
        this.getParent().add(v);
        ((VContenedor)this.getParent().getParent().getParent().getParent().getParent()).actualizarBotonera(6);
        this.dispose();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
        v.show();
    }
    
    
   /* public void paint( Graphics g ) {
    // Se traslada el origen para evitar el efecto del borde
    g.translate( this.getInsets().left,this.getInsets().top );
    // Ahora se pinta la imagen a la mitad de su tamao?=o
    g.drawImage( imagen,0,0,imagen.getWidth(this),imagen.getHeight(this),this );
    
    }*/
    /**
     * 
     * @param evt 
     */
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        try {
            // TODO add your handling code here:
            this.setSelected(true);
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formMouseEntered
    
    javax.swing.JLabel botonCerrar;
    javax.swing.JLabel botonAyuda;
    JLabel botonNuevo;
    JLabel botonAbrir;
    JLabel botonGBD;
    JLabel botonHTML;
    JLabel botonAuto;
    JLabel botonConfig;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
 }
