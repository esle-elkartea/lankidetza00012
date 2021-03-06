package bgc.gui.proy.nuevo;
import bgc.bd.GestorBD;
import bgc.gui.VContenedor;
import bgc.gui.inicio.VInicio;
import bgc.negocio.Cliente;
import bgc.negocio.Fecha;
import bgc.negocio.proyecto.Proyecto;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.metal.MetalInternalFrameUI;
/**
 * La clase VNuevoProy3 proporciona la interfaz necesaria para albergar el 
 * PanelNuevoProy3
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
public class VNuevoProy3 extends javax.swing.JInternalFrame {
     /**Panel que va ser el contenido de esta ventana*/
    PanelNuevoProy3 panel;
     /** Crea un nuevo Internal Frame VNuevoProy3*/
    public VNuevoProy3(Proyecto p) {
        proy = p;
        initComponents();
        panel=new PanelNuevoProy3(proy,this);
        jLabel1.add(panel);
        panel.setLocation(60,120);
        panel.setSize(920, 525);
        this.setSize(1024,670);
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
        panel.jTableListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        panel.jTableListado.setCellEditor(null);
        panel.jTableListado.enableInputMethods(false);
        panel.jScrollPane1.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel.jTableListado.setAutoscrolls(true);
        panel.jScrollPane1.setVerticalScrollBar(panel.jScrollPane1.createVerticalScrollBar());
        
       String ArrayCampos[] = new String[v1.size()];
         for (int i=0; i<v1.size();i++)
         {
             ArrayCampos[i] = v1.elementAt(i).toString();
         }
        
      
       
        panel.jTableListado.setModel(new javax.swing.table.DefaultTableModel(ao,ArrayCampos));
        panel.jScrollPane1.setViewportView(panel.jTableListado);
        ( (MetalInternalFrameUI)this.getUI() ).setNorthPane(null);
        sqlGuardar="";

    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(216, 228, 198));
        setBorder(null);
        setClosable(true);
        setTitle("Nuevo Proyecto (Paso 2 - Manual y automatizado)");
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/proyecto/NuevoProyecto03_fondo.png")));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
            
    /**Devuelve un booleano indicando si hay seleccionados clientes o no en la jTable*/
    public boolean haySeleccionados() {
        for(int i=0;i<panel.jTableListado.getRowCount();i++) {
            if (this.panel.jTableListado.isRowSelected(i)) {
                return true;
            }
        }
        return false;
    }
    /**Devuelve los clientes seleccionados en un Vector*/
    public Vector getSeleccionados() {
        Vector A=new Vector(panel.jTableListado.getRowCount());
        for(int i=0;i<panel.jTableListado.getRowCount();i++) {
            if (this.panel.jTableListado.isRowSelected(i)) {
                A.add(new Integer(i));
            }
        }
        return A;
    }
     /**Devuelve un string con la select necesaria para obtener los clientes
     determinados por los criterios de b�squeda */
    public String obtenerSelect(Vector v) {
        String s="Select * from Clientes where ";
        for (int i=0;i<v.size();i++) {
            int pos=((Integer)v.elementAt(i)).intValue();
            if (i==0) {
                s+="(nombre='"+(String)panel.jTableListado.getValueAt(pos,0)+"' and apellido ='"+(String)panel.jTableListado.getValueAt(pos,1) +"' and email='"+(String)panel.jTableListado.getValueAt(pos,2) +"')";
            } else {
                
                s+=" or (nombre='"+(String)panel.jTableListado.getValueAt(pos,0)+"' and apellido ='"+(String)panel.jTableListado.getValueAt(pos,1) +"' and email='"+(String)panel.jTableListado.getValueAt(pos,2) +"')";
            }
        }
        return s;
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
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    /**Variable para la informaci�n del proyecto en curso*/
    Proyecto proy;
     /**Variable para la sql resultado de los criterios de b�squeda*/
    String sqlGuardar;
    /**Icono para el boton cerrar*/
    javax.swing.JLabel botonCerrar;
    /**Carga los datos de los clientes resultados de una b�squeda que se pasan
     en el vector que se le pasa a la funci�n*/
    public void cargarListadoBusqueda(Vector v) {
      v.remove(v.size()-1);
       GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        
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
            ao[i][10]=c.getFechaNac().toString();
            if (v1.size()>Cliente.numCamposFijos) {
                ao[i][Cliente.numCamposFijos]=c.getExtra1();
                if (v1.size()>Cliente.numCamposFijos+1) {
                    ao[i][Cliente.numCamposFijos+1]=c.getExtra2();
                    if (v1.size()>Cliente.numCamposFijos+2) {
                        ao[i][Cliente.numCamposFijos+2]=c.getExtra3();
                        if (v1.size()>Cliente.numCamposFijos+3) {
                            ao[i][Cliente.numCamposFijos+3]=c.getExtra4();
                            
                        }
                    }
                }
            }
        }
        panel.jTableListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        panel.jTableListado.setCellEditor(null);
        panel.jTableListado.enableInputMethods(false);
        panel.jScrollPane1.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel.jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel.jTableListado.setAutoscrolls(true);
        panel.jScrollPane1.setVerticalScrollBar(panel.jScrollPane1.createVerticalScrollBar());
        String ArrayCampos[] = new String[v1.size()];
         for (int i=0; i<v1.size();i++)
         {
             ArrayCampos[i] = v1.elementAt(i).toString();
         }
        
        panel.jTableListado.setModel(new javax.swing.table.DefaultTableModel(ao,ArrayCampos));
       
       
        panel.jScrollPane1.setViewportView(panel.jTableListado);
    }

}
