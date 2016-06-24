package bgc.gui.proy.automat;
import bgc.bd.GestorBD;
import bgc.gui.inicio.VInicio;
import bgc.negocio.Cliente;
import bgc.negocio.Fecha;
import bgc.negocio.proyecto.LeerProy;
import bgc.negocio.proyecto.Proyecto;
import bgc.negocio.proyecto.ProyectoAuto;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
/**
 * La clase PanelAbrir ofrece la interfaz necesaria para abrir los proyectos automatizados
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
    VDialogoAuto padre;
     /** Crea un nuevo panel PanelAbrir*/
    public PanelAbrir(File f,VDialogoAuto padre) {
	ficherito = f;
        this.padre=padre;
	initComponents();
	inicializar();
        ((TitledBorder)this.jScrollPane2.getBorder()).setTitleColor(new Color(0,70,213));
        ((TitledBorder)this.jScrollPane2.getBorder()).setTitleFont(new Font("Arial",Font.BOLD,12));
    }
    
    /**Inicializa el panel abrir con el proyecto automatizado*/
    public void inicializar()
    {
	
	textoNombre.setEnabled(false);
	textoDescripcion.setEnabled(false);

	this.tablaDestinatarios.setEnabled(false);
	
	
	LeerProy lectura = new LeerProy();
	try {
	    lectura.abrir(ficherito);
	} catch (IOException ex) {
	    ex.printStackTrace();
	}
	p = new Proyecto();
	p = lectura.leer(ficherito);
	this.textoNombre.setText(p.getNombre());
	this.textoDescripcion.setText(p.getDescripcion());
	this.textoDesc.setText(p.getDetalles());
        this.jLabel4.setText(p.getHtml().substring(p.getHtml().lastIndexOf("\\")+1));
	if (p.getTipo().equals("Automatizado")){
	   labelTipo.setText("Automatizado");
        }else if(p.getTipo().equals("Especial")){
            labelTipo.setText("Especial");
        }
	textoDesc.setText(((ProyectoAuto)p).getDetalles());
        this.textoAsunto.setText(p.getAsunto());
        labelFormato.setText("Formato del envío: "+p.getNombreFormatoEnvio());
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
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoDescripcion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoDesc = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        labelFormato = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textoAsunto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDestinatarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(216, 228, 198));
        setOpaque(false);
        jPanel1.setBackground(new java.awt.Color(216, 228, 198));
        jPanel1.setOpaque(false);
        jLabel5.setBackground(new java.awt.Color(216, 228, 198));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setText("Nombre");

        textoNombre.setBackground(new java.awt.Color(216, 228, 198));
        textoNombre.setEditable(false);
        textoNombre.setFont(new java.awt.Font("Arial", 0, 12));
        textoNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel6.setBackground(new java.awt.Color(216, 228, 198));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setText("Descripci\u00f3n");

        textoDescripcion.setBackground(new java.awt.Color(216, 228, 198));
        textoDescripcion.setColumns(20);
        textoDescripcion.setEditable(false);
        textoDescripcion.setFont(new java.awt.Font("Arial", 0, 12));
        textoDescripcion.setLineWrap(true);
        textoDescripcion.setRows(5);
        textoDescripcion.setWrapStyleWord(true);
        textoDescripcion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(textoDescripcion);

        jLabel7.setBackground(new java.awt.Color(216, 228, 198));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel7.setText("Tipo de env\u00edo:");

        textoDesc.setBackground(new java.awt.Color(216, 228, 198));
        textoDesc.setColumns(20);
        textoDesc.setEditable(false);
        textoDesc.setFont(new java.awt.Font("Arial", 0, 12));
        textoDesc.setLineWrap(true);
        textoDesc.setRows(5);
        textoDesc.setWrapStyleWord(true);
        textoDesc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(textoDesc);

        jLabel2.setBackground(new java.awt.Color(216, 228, 198));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel2.setText("Descripci\u00f3n del tipo de envio");

        labelFormato.setBackground(new java.awt.Color(216, 228, 198));
        labelFormato.setFont(new java.awt.Font("Arial", 1, 12));
        labelFormato.setText("Formato del envio: ");

        jLabel3.setBackground(new java.awt.Color(216, 228, 198));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel3.setText("Asunto:");

        textoAsunto.setBackground(new java.awt.Color(216, 228, 198));
        textoAsunto.setEditable(false);
        textoAsunto.setFont(new java.awt.Font("Arial", 0, 12));
        textoAsunto.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel15.setBackground(new java.awt.Color(216, 228, 198));
        jLabel15.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel15.setText("Documento que quieres enviar:");

        jLabel4.setBackground(new java.awt.Color(216, 228, 198));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("jLabel4");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(216, 228, 198));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Destinatarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
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
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jButton1))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel6)
                                    .add(jLabel5))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(textoAsunto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(textoNombre, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                    .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 151, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jLabel7)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(labelTipo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(69, 69, 69))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(labelFormato)
                                .add(194, 194, 194))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel15)
                                    .add(jLabel2)
                                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel4)
                                .add(77, 77, 77)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 566, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(37, 37, 37))
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {jScrollPane1, jScrollPane3, textoAsunto, textoNombre}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(textoNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(17, 17, 17)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(labelTipo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(labelFormato)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(textoAsunto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(11, 11, 11)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel15))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .add(17, 17, 17)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(169, 169, 169))
            .add(jPanel1Layout.createSequentialGroup()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
 /** Establece el cursor en modo normal*/
    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
// TODO add your handling code here:
        jLabel4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel4MouseExited
 /**Esteblece el cursor en modo mano*/
    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
// TODO add your handling code here:
        jLabel4.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel4MouseEntered
  /**Lanza el explorador con el documento html indicado*/
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
// TODO add your handling code here:
        Runtime rtt=Runtime.getRuntime();
        try {
            rtt.exec("cmd /c start iexplore \""+p.getHtml()+"\"");;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jLabel4MouseClicked
/**Cierra la ventana*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.padre.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed
/**Inicializa el contenido del panel PanelAbrir*/    
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
// TODO add your handling code here:
	
	inicializar();
    }//GEN-LAST:event_formInternalFrameActivated
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
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JLabel labelFormato;
    public javax.swing.JLabel labelTipo;
    public javax.swing.JTable tablaDestinatarios;
    public javax.swing.JTextField textoAsunto;
    public javax.swing.JTextArea textoDesc;
    public javax.swing.JTextArea textoDescripcion;
    public javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables
    /**Fichero del que lee el proyecto*/
    File ficherito;
    /**Para trabajar con el proyecto en modo local*/
    Proyecto p;
    /**Ejecuta y devuelve el resultado de una consulta sql*/
    private Statement smt=null;
    
}
