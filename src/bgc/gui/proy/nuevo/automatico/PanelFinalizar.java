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

package bgc.gui.proy.nuevo.automatico;
import bgc.bd.GestorBD;
import bgc.gui.VContenedor;
import bgc.gui.inicio.VInicio;
import bgc.gui.proy.nuevo.*;
import bgc.gui.proy.nuevo.especial.VNuevoProy2Esp;
import bgc.gui.wysiwyg.draganddrop.VHTMLDND;
import bgc.negocio.Cliente;
import bgc.negocio.proyecto.GuardarProy;
import bgc.negocio.proyecto.Proyecto;
import bgc.negocio.proyecto.ProyectoAuto;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;/**
 * Se muestra el resumen del mailing progrado
 * @author Campus-Telematika S.L.
 */public class PanelFinalizar extends javax.swing.JPanel {
     
     /**
      * Creates new form VFinalizar
      */
     VFinalizar padre;
    /**
     * Crea un nuevo PanelFinalizar
     * @param p Proyecto con los datos del mailing
     * @param padre Ventana padre
     */
     public PanelFinalizar(Proyecto p,VFinalizar padre) {
         proy=p;
         initComponents();
         this.padre=padre;
         textoNombre.setEnabled(false);
         textoDescripcion.setEnabled(false);
         
         //this.jButton2.setText("Modificar");
         jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Destinatarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
         
         this.tablaDestinatarios.setEnabled(false);
         //this.jButton5.setVisible(false);
         this.textoSMS.setVisible(false);
         this.jLabel9.setVisible(false);
         this.jScrollPane4.setVisible(false);
         
         this.textoNombre.setText(proy.getNombre());
         this.textoDescripcion.setText(proy.getDescripcion());
         
         
         try{
             textoDesc.setText(((ProyectoAuto)proy).getDetalles());
         }catch(java.lang.ClassCastException ce) {
             textoDesc.setText((proy).getDetalles());
         }
         GestorBD gbd=new GestorBD();
         gbd.abrirBD();
         Vector v = gbd.obtenerListadoAbrir(proy.getSql());
         gbd.cerrarBD();
         Object[][]ao=new Object[v.size()][10];
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
         }
         tablaDestinatarios.getTableHeader().setFont(new Font("Arial",Font.BOLD,12));
         tablaDestinatarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         tablaDestinatarios.setCellEditor(null);
         tablaDestinatarios.enableInputMethods(false);
         jScrollPane2.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
         tablaDestinatarios.setAutoscrolls(true);
         jScrollPane2.setVerticalScrollBar(jScrollPane2.createVerticalScrollBar());
         tablaDestinatarios.setModel(new javax.swing.table.DefaultTableModel(
                 ao,
                 new String [] {
             "Nombre", "Apellidos", "Sexo", "Dirección", "CP", "Ciudad", "Provincia", "Teléfono", "Móvil", "Email"
         }
         ));
         
         tablaDestinatarios.getColumnModel().getColumn(0).setPreferredWidth(150);
         tablaDestinatarios.getColumnModel().getColumn(1).setPreferredWidth(200);
         tablaDestinatarios.getColumnModel().getColumn(2).setPreferredWidth(75);
         tablaDestinatarios.getColumnModel().getColumn(3).setPreferredWidth(250);
         tablaDestinatarios.getColumnModel().getColumn(4).setPreferredWidth(75);
         tablaDestinatarios.getColumnModel().getColumn(5).setPreferredWidth(150);
         tablaDestinatarios.getColumnModel().getColumn(6).setPreferredWidth(150);
         tablaDestinatarios.getColumnModel().getColumn(7).setPreferredWidth(100);
         tablaDestinatarios.getColumnModel().getColumn(8).setPreferredWidth(100);
         tablaDestinatarios.getColumnModel().getColumn(9).setPreferredWidth(200);
         
         textoSMS.setText(proy.getTextoSMS());
         labelFormato.setText("Formato del envio: "+proy.getNombreFormatoEnvio());
         textoAsunto.setText(proy.getAsunto());
         this.jLabel8.setText(proy.getHtml().substring(proy.getHtml().lastIndexOf("\\")+1));
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoDesc = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        labelFormato = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textoAsunto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDestinatarios = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        textoSMS = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(216, 228, 198));
        setEnabled(false);
        setOpaque(false);
        jLabel2.setBackground(new java.awt.Color(216, 228, 198));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel2.setText("Descripci\u00f3n del tipo de envio:");

        textoDesc.setBackground(new java.awt.Color(216, 228, 198));
        textoDesc.setColumns(20);
        textoDesc.setEditable(false);
        textoDesc.setFont(new java.awt.Font("Arial", 0, 12));
        textoDesc.setLineWrap(true);
        textoDesc.setRows(5);
        textoDesc.setWrapStyleWord(true);
        textoDesc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textoDesc.setEnabled(false);
        jScrollPane3.setViewportView(textoDesc);

        jLabel6.setBackground(new java.awt.Color(216, 228, 198));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setText("Descripci\u00f3n:");

        jLabel5.setBackground(new java.awt.Color(216, 228, 198));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setText("Nombre:");

        jLabel7.setBackground(new java.awt.Color(216, 228, 198));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel7.setText("Tipo de envio :   Automatizado");

        textoNombre.setBackground(new java.awt.Color(216, 228, 198));
        textoNombre.setEditable(false);
        textoNombre.setFont(new java.awt.Font("Arial", 0, 10));
        textoNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textoNombre.setEnabled(false);

        labelFormato.setBackground(new java.awt.Color(216, 228, 198));
        labelFormato.setFont(new java.awt.Font("Arial", 1, 12));
        labelFormato.setText("Formato del envio: ");

        jLabel1.setBackground(new java.awt.Color(216, 228, 198));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel1.setText("Asunto:");

        textoAsunto.setBackground(new java.awt.Color(216, 228, 198));
        textoAsunto.setEditable(false);
        textoAsunto.setFont(new java.awt.Font("Arial", 0, 12));
        textoAsunto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textoAsunto.setEnabled(false);

        jLabel4.setBackground(new java.awt.Color(216, 228, 198));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel4.setText("Documento que quieres enviar:");

        jLabel8.setBackground(new java.awt.Color(216, 228, 198));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("jLabel8");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(216, 228, 198));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel9.setText("Texto SMS:");

        jButton1.setBackground(new java.awt.Color(240, 240, 240));
        jButton1.setFont(new java.awt.Font("Arial", 0, 12));
        jButton1.setText("Anterior");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bGuardar.setBackground(new java.awt.Color(240, 240, 240));
        bGuardar.setFont(new java.awt.Font("Arial", 0, 12));
        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(240, 240, 240));
        jButton2.setFont(new java.awt.Font("Arial", 0, 12));
        jButton2.setText("Finalizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(216, 228, 198));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Destinatarios"), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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
        tablaDestinatarios.setOpaque(false);
        jScrollPane2.setViewportView(tablaDestinatarios);

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

        textoSMS.setBackground(new java.awt.Color(216, 228, 198));
        textoSMS.setColumns(20);
        textoSMS.setEditable(false);
        textoSMS.setFont(new java.awt.Font("Arial", 0, 12));
        textoSMS.setLineWrap(true);
        textoSMS.setRows(5);
        textoSMS.setWrapStyleWord(true);
        textoSMS.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textoSMS.setEnabled(false);
        jScrollPane4.setViewportView(textoSMS);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jLabel7)
                        .add(labelFormato)
                        .add(layout.createSequentialGroup()
                            .add(jLabel1)
                            .add(36, 36, 36)
                            .add(textoAsunto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 181, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(layout.createSequentialGroup()
                            .add(jLabel4)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jLabel8))
                        .add(jLabel2)
                        .add(layout.createSequentialGroup()
                            .add(jLabel9)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 15, Short.MAX_VALUE)
                            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jLabel6)
                                .add(jLabel5))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(textoNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .add(19, 19, 19)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jButton1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(bGuardar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton2))
        );

        layout.linkSize(new java.awt.Component[] {jScrollPane1, jScrollPane3, jScrollPane4, textoAsunto, textoNombre}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(textoNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(9, 9, 9)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel6))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(labelFormato)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(textoAsunto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel4)
                            .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel9))
                        .add(41, 41, 41))
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane2, 0, 0, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton2)
                    .add(bGuardar)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Cambia el cursor a normal
     * @param evt Evento
     */
    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
// TODO add your handling code here:
        jLabel8.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));        
    }//GEN-LAST:event_jLabel8MouseExited
    
    /**
     * Cambia el cursor a Mano
     * @param evt Evento
     */
    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
// TODO add your handling code here:
        jLabel8.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel8MouseEntered
    
    /**
     * Abre el HTML seleccionado
     * @param evt Evento
     */
    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
// TODO add your handling code here:
        Runtime rtt=Runtime.getRuntime();
        try {
            rtt.exec("cmd /c start iexplore \""+proy.getHtml()+"\"");;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jLabel8MouseClicked
    
    /**
     * Guarda el mailing
     * @param evt Evento
     */
    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
// TODO add your handling code here:
        // TODO add your handling code here:
        Date d = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(d);
        int dia = c.get(Calendar.DATE);
        int mes = c.get(Calendar.MONTH);
        int anyo = c.get(Calendar.YEAR);
        String tipo="";
//	Proyecto p=null;
//
//	    tipo = "Automatizado";
//	    proy = new ProyectoAuto(this.textoNombre.getText(),this.textoDescripcion.getText(),new Fecha(dia,mes,anyo),tipo,"","");
//	    ((ProyectoAuto)p).setFechaComienzo();
//            ((ProyectoAuto)p).setFechaFin();
        
        GuardarProy salida = new GuardarProy();
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Selecciona el directorio donde se guardara el mailing");
        FileFilter filtroObj = new FileFilter() {
            public boolean accept(File f) {
                
                return  f.isDirectory();
            }
            public String getDescription() {
                return "Mailing Hermes";
            }
        };
        chooser.setSelectedFile(new File(proy.getNombre()));
        chooser.setFileFilter(filtroObj);
        chooser.setCurrentDirectory(new java.io.File("C:\\Archivos de programa\\Campus-Telematika\\Hermes\\programados"));
        int resultado = chooser.showSaveDialog(this.getParent());
        if (resultado == JFileChooser.APPROVE_OPTION){
            File ficheroSeleccionado = chooser.getSelectedFile();
            try {
                 chooser.getSelectedFile().mkdir();
                    
                if (chooser.getSelectedFile().isDirectory()) {
                   // chooser.getSelectedFile().mkdir();
                    
                    proy.setRuta(chooser.getSelectedFile().getAbsolutePath());
                    
                    salida.abrir(chooser.getSelectedFile().getAbsolutePath()+System.getProperty("file.separator")+proy.getNombre()+".bgc");
                    VHTMLDND.copiarHTML(VHTMLDND.leerHTML(proy.getHtml()),new File(proy.getRuta()).getAbsolutePath()+"\\"+proy.getHtml().substring(proy.getHtml().lastIndexOf("\\")+1));
                    proy.setHtml(new File(proy.getRuta()).getAbsolutePath()+"\\"+proy.getHtml().substring(proy.getHtml().lastIndexOf("\\")+1));
                }
                
                
                GestorBD gbd=new GestorBD();
                gbd.abrirBD();
                gbd.insertarProyectoAuto(chooser.getSelectedFile()+System.getProperty("file.separator")+proy.getNombre()+".bgc");
                gbd.cerrarBD();
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            salida.escribir(proy);
            salida.cerrar();
            
            ((VContenedor)(this.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent())).gestorAuto.iniciarProyectosAuto();
            
            VInicio v = new VInicio();
            this.padre.getParent().add(v);
            this.padre.dispose();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
            v.show();
            
        }
    }//GEN-LAST:event_bGuardarActionPerformed
    
    /**
     * Finaliza poniendo en ejecucion el mailing programado. Ademas lo gurada en el
     * disco
     * @param evt Evento
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        GuardarProy salida = new GuardarProy();
       
        File fich = new File("programados"+System.getProperty("file.separator")+proy.getNombre());
        try {
            proy.setRuta("programados"+System.getProperty("file.separator")+proy.getNombre());
            fich.mkdirs();
            salida.abrir("programados"+System.getProperty("file.separator")+System.getProperty("file.separator")+proy.getNombre()+System.getProperty("file.separator")+proy.getNombre()+".bgc");
            VHTMLDND.copiarHTML(VHTMLDND.leerHTML(proy.getHtml()),new File(proy.getRuta()).getAbsolutePath()+"\\"+proy.getHtml().substring(proy.getHtml().lastIndexOf("\\")+1));
            proy.setHtml(new File(proy.getRuta()).getAbsolutePath()+"\\"+proy.getHtml().substring(proy.getHtml().lastIndexOf("\\")+1));
            GestorBD gbd=new GestorBD();
            gbd.abrirBD();
            gbd.insertarProyectoAuto(proy.getRuta()+System.getProperty("file.separator")+proy.getNombre()+".bgc");
            gbd.cerrarBD();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        salida.escribir(proy);
        salida.cerrar();
        
        ((VContenedor)(this.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent())).gestorAuto.iniciarProyectosAuto();
        
        VInicio v = new VInicio();
        this.padre.getParent().add(v);
        this.padre.dispose();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
        v.show();
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
     * Vuelve a la ventana anterior
     * @param evt Evento
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        if (proy.getTipo().equals("Manual")){
            
            VNuevoProy2 v = new VNuevoProy2(proy);
            this.padre.getParent().add(v);
            this.padre.dispose();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
            v.show();
        }
        if (proy.getTipo().equals("Automatizado")){
            
            VNuevoProy3TipoEnv v = new VNuevoProy3TipoEnv(proy);
            this.padre.getParent().add(v);
            this.padre.dispose();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
            v.show();
        }
        if (proy.getTipo().equals("Especial")){
            VNuevoProy2Esp v = new VNuevoProy2Esp(proy);
            this.padre.getParent().add(v);
            this.padre.dispose();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
            v.show();
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * Cierra la ventana
     * @param evt Evento
     */
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
    /**
     * Boton
     */
    public javax.swing.JButton bGuardar;
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JLabel labelFormato;
    public javax.swing.JTable tablaDestinatarios;
    public javax.swing.JTextField textoAsunto;
    public javax.swing.JTextArea textoDesc;
    public javax.swing.JTextArea textoDescripcion;
    public javax.swing.JTextField textoNombre;
    public javax.swing.JTextArea textoSMS;
    // End of variables declaration//GEN-END:variables
    
    Proyecto proy;
    
    
 }
