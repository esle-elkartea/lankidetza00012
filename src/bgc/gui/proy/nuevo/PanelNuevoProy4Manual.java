package bgc.gui.proy.nuevo;

import bgc.bd.GestorBD;
import bgc.gui.inicio.VInicio;
import bgc.gui.wysiwyg.draganddrop.VHTMLDND;
import bgc.negocio.Cliente;
import bgc.negocio.Fecha;
import bgc.negocio.proyecto.GuardarProy;
import bgc.negocio.proyecto.Proyecto;
import bgc.negocio.correo.ResultadoEnvio;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.JOptionPane;
import java.awt.print.*;
import javax.swing.JDesktopPane;

/**
 * La clase PanelNuevoProy4Manual ofrece la interfaz necesaria para ver los
 * detalles del proyecto actual
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
public class PanelNuevoProy4Manual extends javax.swing.JPanel {
    
    /**Ventana contenedora de este panel*/
    VNuevoProy4Manual padre;
    /** Crea un nuevo panel PanelNuevoProy4Manual*/
    public PanelNuevoProy4Manual(Proyecto p, VNuevoProy4Manual padre) {
        proy= p;
        this.padre=padre;
        initComponents();
        inicializar();
        if (proy.getFormatoEnvio()==Proyecto.CARTA) {
            jButton2.setText("Imprimir");
        }
    }
    
    /** Inicializa el contenido del panel PanelNuevoProy4Manual*/
    public void inicializar() {
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Destinatarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        textoNombre.setEnabled(false);
        textoDescripcion.setEnabled(false);
        this.tablaDestinatarios.setEnabled(false);
        this.textoNombre.setText(proy.getNombre());
        this.textoDescripcion.setText(proy.getDescripcion());
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector v = gbd.obtenerListadoAbrir(proy.getSql());
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
        tablaDestinatarios.setAutoscrolls(true);
        jScrollPane1.setVerticalScrollBar(jScrollPane1.createVerticalScrollBar());
        String ArrayCampos[] = new String[v1.size()];
        for (int i=0; i<v1.size();i++) {
            ArrayCampos[i] = v1.elementAt(i).toString();
        }
        
        
        
        tablaDestinatarios.setModel(new javax.swing.table.DefaultTableModel(ao,ArrayCampos));
        
        textoSMS.setText(proy.getTextoSMS());
        labelFormato.setText("Formato del envio: "+proy.getNombreFormatoEnvio());
        textoAsunto.setText(proy.getAsunto());
        this.jLabel3.setText(proy.getHtml().substring(proy.getHtml().lastIndexOf("\\")+1));
        this.jLabel9.setVisible(false);
        this.textoSMS.setVisible(false);
        this.jScrollPane3.setVisible(false);
        
        if (proy.getNombreFormatoEnvio().equals("carta")) {
            this.textoAsunto.setVisible(false);
            this.jLabel1.setVisible(false);
            this.jLabel2.setVisible(false);
            this.jLabel3.setVisible(false);
        }
        
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
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDestinatarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textoAsunto = new javax.swing.JTextField();
        labelFormato = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoSMS = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 240));
        setOpaque(false);
        jPanel1.setBackground(new java.awt.Color(216, 228, 198));
        jPanel1.setOpaque(false);
        jLabel5.setBackground(new java.awt.Color(216, 228, 198));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setText("Nombre");
        jLabel5.setToolTipText("Nombre del mailing");

        textoNombre.setBackground(new java.awt.Color(216, 228, 198));
        textoNombre.setEditable(false);
        textoNombre.setFont(new java.awt.Font("Arial", 0, 12));
        textoNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textoNombre.setEnabled(false);

        jLabel6.setBackground(new java.awt.Color(216, 228, 198));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setText("Descripci\u00f3n");
        jLabel6.setToolTipText("Descripci\u00f3n del mailing");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        textoDescripcion.setBackground(new java.awt.Color(216, 228, 198));
        textoDescripcion.setColumns(20);
        textoDescripcion.setEditable(false);
        textoDescripcion.setFont(new java.awt.Font("Arial", 0, 12));
        textoDescripcion.setLineWrap(true);
        textoDescripcion.setRows(5);
        textoDescripcion.setWrapStyleWord(true);
        textoDescripcion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textoDescripcion.setEnabled(false);
        jScrollPane1.setViewportView(textoDescripcion);

        jLabel7.setBackground(new java.awt.Color(216, 228, 198));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel7.setText("Tipo de env\u00edo :   Manual");
        jLabel7.setToolTipText("Tipo de env\u00edo del mailing");

        jScrollPane2.setBackground(new java.awt.Color(216, 228, 198));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Destinatarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        jScrollPane2.setEnabled(false);
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

        jLabel2.setBackground(new java.awt.Color(216, 228, 198));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel2.setText("Documento que quieres enviar:");
        jLabel2.setToolTipText("Documento que quieres enviar");

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

        jLabel1.setBackground(new java.awt.Color(216, 228, 198));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel1.setText("Asunto");
        jLabel1.setToolTipText("Asunto del mailing");

        textoAsunto.setBackground(new java.awt.Color(216, 228, 198));
        textoAsunto.setEditable(false);
        textoAsunto.setFont(new java.awt.Font("Arial", 0, 12));
        textoAsunto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textoAsunto.setEnabled(false);

        labelFormato.setBackground(new java.awt.Color(216, 228, 198));
        labelFormato.setFont(new java.awt.Font("Arial", 1, 12));
        labelFormato.setText("Formato del env\u00edo: ");
        labelFormato.setToolTipText("Formato de env\u00edo");

        jLabel8.setText("TextoSMS");

        textoSMS.setBackground(new java.awt.Color(216, 228, 198));
        textoSMS.setColumns(20);
        textoSMS.setEditable(false);
        textoSMS.setFont(new java.awt.Font("Arial", 0, 12));
        textoSMS.setLineWrap(true);
        textoSMS.setRows(5);
        textoSMS.setWrapStyleWord(true);
        textoSMS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textoSMS.setEnabled(false);
        jScrollPane3.setViewportView(textoSMS);

        jLabel9.setBackground(new java.awt.Color(216, 228, 198));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel9.setText("Texto SMS");
        jLabel9.setToolTipText("Texto SMS");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel6)
                            .add(jLabel5)
                            .add(jLabel9)
                            .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(textoNombre, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, textoAsunto, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel7)
                        .add(107, 107, 107))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(labelFormato, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(16, 16, 16))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel2)
                        .add(11, 11, 11)
                        .add(jLabel3)
                        .add(9, 9, 9)))
                .add(10, 10, 10)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {jScrollPane1, textoAsunto, textoNombre}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(textoNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel6)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(labelFormato)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(textoAsunto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel9)))
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(240, 240, 240));
        jButton3.setFont(new java.awt.Font("Arial", 0, 12));
        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(240, 240, 240));
        jButton2.setFont(new java.awt.Font("Arial", 0, 12));
        jButton2.setText("Enviar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(240, 240, 240));
        jButton7.setFont(new java.awt.Font("Arial", 0, 12));
        jButton7.setText("Finalizar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(240, 240, 240));
        jButton1.setFont(new java.awt.Font("Arial", 0, 12));
        jButton1.setText("Anterior");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(620, Short.MAX_VALUE)
                .add(jButton1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton7))
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton7)
                    .add(jButton1)
                    .add(jButton2)
                    .add(jButton3))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
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
    /** Establece el cursor en modo normal*/
    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
// TODO add your handling code here:
        jLabel3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel3MouseExited
    /**Esteblece el cursor en modo mano*/
    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
// TODO add your handling code here:
        jLabel3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
    }//GEN-LAST:event_jLabel3MouseEntered
    /**Vuelve a la pantalla de inicio*/
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
// TODO add your handling code here:
        VInicio v = new VInicio();
        this.padre.getParent().add(v);
        this.padre.dispose();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
        v.show();
    }//GEN-LAST:event_jButton7ActionPerformed
    /** Inicializa el contenido del panel PanelNuevoProy4Manual*/
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
// TODO add your handling code here:
        
        inicializar();
    }//GEN-LAST:event_formInternalFrameActivated
    /**Guarda el proyecto en el lugar indicado en el disco duro*/
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Date d = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(d);
        int dia = c.get(Calendar.DATE);
        int mes = c.get(Calendar.MONTH);
        int anyo = c.get(Calendar.YEAR);
        
        
        GuardarProy salida = new GuardarProy();
        JFileChooser chooser = new JFileChooser();
        
        chooser.setDialogTitle("Selecciona el directorio donde se guardara el mailing");
        
        FileFilter filtroObj = new FileFilter() {
            public boolean accept(File f) {
                
                return /*f.getName().toLowerCase().endsWith(".bgc") ||*/ f.isDirectory();
            }
            public String getDescription() {
                return "Mailing Hermes";
            }
        };
        chooser.setSelectedFile(new File(proy.getNombre()));
        chooser.setFileFilter(filtroObj);
        chooser.setCurrentDirectory(new java.io.File("C:\\Archivos de programa\\Campus-Telematika\\Hermes"));
        int resultado = chooser.showSaveDialog(this.getParent());
        if (resultado == JFileChooser.APPROVE_OPTION){
            
            try {
                
                chooser.getSelectedFile().mkdir();
                
                proy.setRuta(chooser.getSelectedFile().getAbsolutePath());
                
                salida.abrir(chooser.getSelectedFile().getAbsolutePath()+System.getProperty("file.separator")+proy.getNombre()+".bgc");
                VHTMLDND.copiarHTML(VHTMLDND.leerHTML(proy.getHtml()),new File(proy.getRuta()).getAbsolutePath()+"\\"+proy.getHtml().substring(proy.getHtml().lastIndexOf("\\")+1));
                proy.setHtml(new File(proy.getRuta()).getAbsolutePath()+System.getProperty("file.separator")+proy.getHtml().substring(proy.getHtml().lastIndexOf("\\")+1));
                
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            salida.escribir(proy);
            salida.cerrar();
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    /**Procede a la realización del envío*/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector vcli=gbd.obtenerListadoAbrir(proy.getSql());
        gbd.cerrarBD();
        
        ResultadoEnvio []as=new ResultadoEnvio[vcli.size()];
        
        for(int i=0;i<vcli.size();i++)
            as[i]=new ResultadoEnvio(((Cliente)vcli.elementAt(i)),"");
        
        if (proy.getFormatoEnvio()==Proyecto.CARTA) {
            PrinterJob printJob = PrinterJob.getPrinterJob();
            
            PageFormat pag=new PageFormat();
            pag.setOrientation(PageFormat.PORTRAIT);
        
            printJob.setPageable(new PrintLabel(as));
//            printJob.setPrintable(new Imprimir(as));
            if(printJob.printDialog()) {
                try {
                    printJob.print();
                } catch (Exception pe) {
                    System.out.println(pe);
                }
            }
            JOptionPane.showMessageDialog(null,"Se imprimiran las etiquetas de todos los clientes seleccionados en el mailing.\n\n \t  Si desea imprimir un documento HTML previsualizelo con el explorador." );
            
        }else {
            
            VNuevoProyEnvio v = new VNuevoProyEnvio(this.proy,as);
            this.padre.getParent().add(v);
            
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            
            v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
            
            v.setListado(as);
            
            ((JDesktopPane)this.padre.getParent()).setSelectedFrame(v);
            this.padre.dispose();
            v.show();
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
    /**Vuelve al paso anterior*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        VNuevoProy3 v = new VNuevoProy3(proy);
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
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton7;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JLabel labelFormato;
    public javax.swing.JTable tablaDestinatarios;
    public javax.swing.JTextField textoAsunto;
    public javax.swing.JTextArea textoDescripcion;
    public javax.swing.JTextField textoNombre;
    public javax.swing.JTextArea textoSMS;
    // End of variables declaration//GEN-END:variables
    /**Variable para la información del proyecto en curso*/
    Proyecto proy;
    
    
}
