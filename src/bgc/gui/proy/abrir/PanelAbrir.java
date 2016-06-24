package bgc.gui.proy.abrir;
import bgc.bd.GestorBD;
import bgc.gui.inicio.VInicio;
import bgc.gui.proy.nuevo.VNuevoProyEnvio;
import bgc.negocio.Cliente;
import bgc.negocio.Fecha;
import bgc.negocio.correo.ResultadoEnvio;
import bgc.negocio.proyecto.LeerProy;
import bgc.negocio.proyecto.Proyecto;
import bgc.negocio.proyecto.ProyectoAuto;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JTable;

/**
 * La clase PanelAbrir ofrece la interfaz necesaria para abrir los proyectos
 * guardados con anterioridad
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
public class PanelAbrir extends javax.swing.JPanel {
    
    /** Ventana padre que contiene al panel PanelAbrir*/
    VAbrir padre;
    /** Crea un nuevo panel PanelAbrir*/
    public PanelAbrir(File f,VAbrir padre) {
        ficherito = f;
        this.padre=padre;
        initComponents();
        inicializar();
        
    }
    /** Inicializa el contenido del panel PanelAbrir*/
    public void inicializar() {
        textoNombre.setEnabled(false);
        textoDescripcion.setEnabled(false);
        textoAsunto.setEnabled(false);
        textoSMS.setEnabled(false);
        textoSMS.setVisible(false);
        jScrollPane3.setVisible(false);
        jLabel14.setVisible(false);
        jLabel4.setVisible(false);
        textoDesc.setVisible(false);
        this.tablaDestinatarios.setEnabled(false);
        LeerProy lectura = new LeerProy();
        try {
            lectura.abrir(ficherito);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        proy = new Proyecto();
        proy = lectura.leer(ficherito);
        this.textoNombre.setText(proy.getNombre());
        this.textoDescripcion.setText(proy.getDescripcion());
        this.textoAsunto.setText(proy.getAsunto());
        this.textoSMS.setText(proy.getTextoSMS());
        labelFormato.setText("Formato del envio: "+proy.getNombreFormatoEnvio());
        this.jLabel1.setText(proy.getTipo());
        if (proy.getTipo().equals(Proyecto.AUTOMATIZADO)) {
            
            jButton3.setVisible(false);
            jLabel4.setVisible(true);
            textoDesc.setVisible(true);
            textoDesc.setText(((ProyectoAuto)proy).getDetalles());
            
        }
        this.jLabel3.setText(proy.getHtml().substring(proy.getHtml().lastIndexOf("\\")+1));
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector v=gbd.obtenerListadoAbrir(proy.getSql());
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
        tablaDestinatarios.getTableHeader().setFont(new Font("Arial",Font.BOLD,12));
        tablaDestinatarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablaDestinatarios.setCellEditor(null);
        tablaDestinatarios.enableInputMethods(false);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablaDestinatarios.setAutoscrolls(true);
        jScrollPane2.setVerticalScrollBar(jScrollPane2.createVerticalScrollBar());
        String ArrayCampos[] = new String[v1.size()];
        for (int i=0; i<v1.size();i++) {
            ArrayCampos[i] = v1.elementAt(i).toString();
        }
        tablaDestinatarios.setModel(new javax.swing.table.DefaultTableModel(ao,ArrayCampos));
        tablaDestinatarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
            }
        });
        jScrollPane2.setViewportView(tablaDestinatarios);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDestinatarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        labelFormato = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textoAsunto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoSMS = new javax.swing.JTextArea();
        textoDesc = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(216, 228, 198));
        setOpaque(false);
        jScrollPane2.setBackground(new java.awt.Color(216, 228, 198));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Destinatarios"));
        jScrollPane2.setOpaque(false);
        tablaDestinatarios.setBackground(new java.awt.Color(216, 228, 198));
        tablaDestinatarios.setFont(new java.awt.Font("Arial", 0, 10));
        tablaDestinatarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaDestinatarios);

        jButton1.setBackground(new java.awt.Color(240, 240, 240));
        jButton1.setFont(new java.awt.Font("Arial", 0, 12));
        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(240, 240, 240));
        jButton3.setFont(new java.awt.Font("Arial", 0, 12));
        jButton3.setText("Enviar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        labelFormato.setBackground(new java.awt.Color(216, 228, 198));
        labelFormato.setFont(new java.awt.Font("Arial", 1, 12));
        labelFormato.setText("Formato del envio: ");

        jLabel2.setBackground(new java.awt.Color(216, 228, 198));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel2.setText("Asunto:");

        jLabel14.setBackground(new java.awt.Color(216, 228, 198));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel14.setText("Texto SMS:");

        jLabel15.setBackground(new java.awt.Color(216, 228, 198));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel15.setText("Documento que quieres enviar:");

        jLabel3.setBackground(new java.awt.Color(216, 228, 198));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("jLabel3");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        textoAsunto.setBackground(new java.awt.Color(216, 228, 198));
        textoAsunto.setFont(new java.awt.Font("Arial", 0, 12));
        textoAsunto.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel5.setBackground(new java.awt.Color(216, 228, 198));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setText("Nombre:");

        textoNombre.setBackground(new java.awt.Color(216, 228, 198));
        textoNombre.setFont(new java.awt.Font("Arial", 0, 12));
        textoNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel6.setBackground(new java.awt.Color(216, 228, 198));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setText("Descripci\u00f3n:");

        jScrollPane1.setBackground(new java.awt.Color(216, 228, 198));
        textoDescripcion.setBackground(new java.awt.Color(216, 228, 198));
        textoDescripcion.setColumns(20);
        textoDescripcion.setFont(new java.awt.Font("Arial", 0, 12));
        textoDescripcion.setLineWrap(true);
        textoDescripcion.setRows(5);
        textoDescripcion.setWrapStyleWord(true);
        textoDescripcion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(textoDescripcion);

        jLabel7.setBackground(new java.awt.Color(216, 228, 198));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel7.setText("Tipo de env\u00edo:");

        jLabel1.setBackground(new java.awt.Color(216, 228, 198));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel1.setText("Manual");
        jLabel1.setToolTipText("detalles del envio");

        jScrollPane3.setBackground(new java.awt.Color(216, 228, 198));
        textoSMS.setBackground(new java.awt.Color(216, 228, 198));
        textoSMS.setColumns(20);
        textoSMS.setEditable(false);
        textoSMS.setFont(new java.awt.Font("Arial", 0, 12));
        textoSMS.setLineWrap(true);
        textoSMS.setRows(5);
        textoSMS.setWrapStyleWord(true);
        textoSMS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(textoSMS);

        textoDesc.setBackground(new java.awt.Color(216, 228, 198));
        textoDesc.setColumns(20);
        textoDesc.setEditable(false);
        textoDesc.setFont(new java.awt.Font("Arial", 0, 12));
        textoDesc.setLineWrap(true);
        textoDesc.setRows(5);
        textoDesc.setWrapStyleWord(true);
        textoDesc.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel4.setBackground(new java.awt.Color(216, 228, 198));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel4.setText("Descripci\u00f3n del tipo de envio");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(labelFormato, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .add(197, 197, 197))
                    .add(layout.createSequentialGroup()
                        .add(jLabel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .add(179, 179, 179))
                    .add(layout.createSequentialGroup()
                        .add(jLabel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                        .add(90, 90, 90))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                        .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                        .add(14, 14, 14)
                                        .add(textoNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 220, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(15, 15, 15))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(textoAsunto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 224, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel14, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(textoDesc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .add(17, 17, 17)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jButton3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(textoNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(16, 16, 16)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(labelFormato)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(textoAsunto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(21, 21, 21)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel15)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(21, 21, 21)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel14)
                            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(11, 11, 11)
                        .add(jLabel4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(textoDesc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton3)))
        );
    }// </editor-fold>//GEN-END:initComponents
    /**Establece el cursor en modo normal*/
    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
// TODO add your handling code here:
        jLabel3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel3MouseExited
    /**Esteblece el cursor en modo mano*/
    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
// TODO add your handling code here:
        jLabel3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel3MouseEntered
    /**Lanza el explorador con el documento html indicado*/
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
// TODO add your handling code here:
        Runtime rtt=Runtime.getRuntime();
        try {
            rtt.exec("cmd /c start iexplore \""+proy.getHtml()+"\"");;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jLabel3MouseClicked
  /**Inicializa el contenido del panel PanelAbrir*/    
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
// TODO add your handling code here:
        
        inicializar();
    }//GEN-LAST:event_formInternalFrameActivated
    /**Realiza el envío del mailing*/
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector vcli=gbd.obtenerListadoAbrir(proy.getSql());
        gbd.cerrarBD();
        
        ResultadoEnvio []as=new ResultadoEnvio[vcli.size()];
        
        for(int i=0;i<vcli.size();i++) as[i]=new ResultadoEnvio(((Cliente)vcli.elementAt(i)),"");
        
        VNuevoProyEnvio v = new VNuevoProyEnvio(this.proy,as);
        this.padre.getParent().add(v);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //v.setSize(screenSize.width,screenSize.height-55);
        v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
        v.setListado(as);
        this.padre.dispose();
        v.show();
        
        
    }//GEN-LAST:event_jButton3ActionPerformed
    /**Vuelve a la pantalla de inicio*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        VInicio v = new VInicio();
        this.padre.getParent().add(v);
        this.padre.dispose();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
        v.show();
    }//GEN-LAST:event_jButton1ActionPerformed
     /**Vuelve a la pantalla de inicio*/
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
// TODO add your handling code here:
        VInicio v = new VInicio();
        this.padre.getParent().add(v);
        this.padre.dispose();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
        v.show();
    }//GEN-LAST:event_formInternalFrameClosing
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton3;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JLabel labelFormato;
    public javax.swing.JTable tablaDestinatarios;
    public javax.swing.JTextField textoAsunto;
    public javax.swing.JTextArea textoDesc;
    public javax.swing.JTextArea textoDescripcion;
    public javax.swing.JTextField textoNombre;
    public javax.swing.JTextArea textoSMS;
    // End of variables declaration//GEN-END:variables
    /**Fichero del que lee el proyecto*/
    File ficherito;
    /**Para trabajar con el proyecto en modo local*/
    Proyecto proy;
    /**Ejecuta y devuelve el resultado de una consulta sql*/
    private Statement smt=null;
    
}
