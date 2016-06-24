package bgc.gui.gbd;
import bgc.bd.GestorBD;
import bgc.gui.inicio.VInicio;
import bgc.negocio.Cliente;
import bgc.negocio.Fecha;
import bgc.negocio.Utilidades;
import bgc.negocio.proyecto.Proyecto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 * La clase PanelVisorGestor proporciona la interfaz necesaria para realizar
 * una completa gestión de clientes en la base de datos
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
public class PanelVisorGestor extends javax.swing.JPanel  {
    
    /** Ventana que llama a PanelVisorGestor */
    VVisorGestor padre;
    /**Crea un nuevo panel PanelVisorGestor*/
    public PanelVisorGestor(JDesktopPane d,VVisorGestor padre) {
        initComponents();
        this.setLocation(0,0);
        panelPadre=d;
        this.padre=padre;
        PanelBuscar1 panelBuscar1 = new PanelBuscar1();
        panelBuscar1.setLocation(0,5);
        panelBuscar1.setSize(200, 320);
        this.jPanel2.add(panelBuscar1);
        this.validate();
        this.repaint();
        prepararTabla();
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector v=gbd.obtenerCampos();
        gbd.cerrarBD();
        for (int i=0;i<v.size();i++) {
            comboBoxCampo.addItem(v.elementAt(i));
        }
    }
    /**Inicializa la jTable del panelVisorGestor con los datos de todos los clientes de la
     base de datos*/
    private void prepararTabla() {
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector v=gbd.obtenerListado();
        Vector v1=gbd.obtenerCampos();
        gbd.cerrarBD();
        Object[][]ao=new Object[v.size()][v1.size()];
        for (int i=0;i<v.size();i++) {
            Cliente c=(Cliente)v.elementAt(i);
            ao[i][0]=c.getNombre();
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
        jTableListado.getTableHeader().setFont(new Font("Arial",Font.BOLD,12));
        jTableListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableListado.enableInputMethods(false);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jTableListado.setAutoscrolls(true);
        jScrollPane1.setVerticalScrollBar(jScrollPane1.createVerticalScrollBar());
        String ArrayCampos[] = new String[v1.size()];
        for (int i=0; i<v1.size();i++) {
            ArrayCampos[i] = Utilidades.nombreCampoAPantalla(v1.elementAt(i).toString());
        }
        
        jTableListado.setModel(new javax.swing.table.DefaultTableModel(ao,ArrayCampos));
        jTableListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListadoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableListadoMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListado);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel6 = new javax.swing.JPanel();
        comboBoxCampo = new javax.swing.JComboBox();
        textBuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        botonAnyadir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListado = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 240));
        setOpaque(false);
        jPanel6.setBackground(new java.awt.Color(240, 240, 240));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("B\u00fasqueda"));
        jPanel6.setOpaque(false);
        comboBoxCampo.setBackground(new java.awt.Color(240, 240, 240));
        comboBoxCampo.setFont(new java.awt.Font("Arial", 1, 12));

        textBuscar.setBackground(new java.awt.Color(216, 228, 198));
        textBuscar.setFont(new java.awt.Font("Arial", 0, 12));
        textBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBuscarKeyReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(comboBoxCampo, 0, 171, Short.MAX_VALUE)
                    .add(textBuscar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(comboBoxCampo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(textBuscar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Cliente"));
        jPanel1.setOpaque(false);
        botonAnyadir.setBackground(new java.awt.Color(240, 240, 240));
        botonAnyadir.setText("A\u00f1adir");
        botonAnyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnyadirActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(botonAnyadir, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(botonAnyadir)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(240, 240, 240));
        jButton1.setFont(new java.awt.Font("Arial", 0, 12));
        jButton1.setText("Volver");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(240, 240, 240));
        jButton2.setFont(new java.awt.Font("Arial", 0, 12));
        jButton2.setText("Importar datos");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setOpaque(false);
        jTableListado.setBackground(new java.awt.Color(240, 240, 240));
        jTableListado.setFont(new java.awt.Font("Arial", 0, 10));
        jTableListado.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableListado.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableListado.setGridColor(new java.awt.Color(102, 102, 102));
        jTableListado.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTableListado);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Avanzada"));
        jPanel2.setOpaque(false);
        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 191, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 251, Short.MAX_VALUE)
        );

        jButton5.setBackground(new java.awt.Color(240, 240, 240));
        jButton5.setFont(new java.awt.Font("Arial", 0, 12));
        jButton5.setText("Limpiar");
        jButton5.setOpaque(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(240, 240, 240));
        jButton4.setFont(new java.awt.Font("Arial", 0, 12));
        jButton4.setText("Buscar");
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jButton5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton4))
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jButton2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton1))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jButton2)
                    .add(jButton5)
                    .add(jButton4))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
/**Realiza la búsqueda de clientes en la base de datos según los criterios que haya marcado 
 el usuario en los paneles de búsqueda avanzada*/
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        String []ArraySql= new String [7];
        String sql="";
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
      
        if (jPanel2.getComponentCount()==1) {
            PanelBuscar1 panel = new PanelBuscar1();
            panel = (PanelBuscar1)this.jPanel2.getComponent(0);
         
            JTextField primero = new JTextField();
            primero = (JTextField)panel.getComponent(4);
            JTextField segundo = new JTextField();
            segundo = (JTextField)panel.getComponent(5);
            JComboBox combo = new JComboBox();
            combo = (JComboBox)panel.getComponent(0);
 
            ArraySql[0]=Utilidades.nombreCampoABD((String)combo.getSelectedItem());//break;
           
            ArraySql[1]=primero.getText();
            
            sql=((PanelBuscar1)this.jPanel2.getComponent(0)).obtenerSentencia();
            if (((JRadioButton)panel.getComponent(9)).isSelected() ) {
                sql=sql+" AND";
                sql=sql+((PanelBuscar2)((PanelBuscar1)this.jPanel2.getComponent(0)).getComponent(11)).obtenerSentencia();
            }else  if (((JRadioButton)panel.getComponent(10)).isSelected() ) {
                sql=sql+" OR";
                sql=sql+((PanelBuscar2)((PanelBuscar1)this.jPanel2.getComponent(0)).getComponent(11)).obtenerSentencia();
            }
            sql=sql+" order by "+ArraySql[0];
         
            
        }
        
        Vector aux=gbd.obtenerListado();
      
        
        Vector v=gbd.buscar(sql);
        sqlGuardar = (String)v.get(v.size()-1);
        cargarListadoBusquedaAvanzada(v);
        gbd.cerrarBD();
    }//GEN-LAST:event_jButton4ActionPerformed
/**Devuelve el panelVisorGestor a su estado inicial*/
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
        this.jPanel2.remove(0);
        PanelBuscar1 panelBuscar1 = new PanelBuscar1();
        panelBuscar1.setLocation(0,5);
        panelBuscar1.setSize(200, 320);
        this.jPanel2.add(panelBuscar1);
        this.validate();
        this.repaint();
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
        jTableListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableListado.setCellEditor(null);
        jTableListado.enableInputMethods(false);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jTableListado.setAutoscrolls(true);
        jScrollPane1.setVerticalScrollBar(jScrollPane1.createVerticalScrollBar());
        String ArrayCampos[] = new String[v1.size()];
        for (int i=0; i<v1.size();i++) {
            ArrayCampos[i] = v1.elementAt(i).toString();
        }
        
        
        
        jTableListado.setModel(new javax.swing.table.DefaultTableModel(ao,ArrayCampos));
        
        jScrollPane1.setViewportView(jTableListado);
    }//GEN-LAST:event_jButton5ActionPerformed

    //**Resalta el color de la fila seleccionada en la tabla*/
    private void jTableListadoMouseClicked(java.awt.event.MouseEvent evt) {
      getTabla().setSelectionForeground(Color.blue);
    }
    /**Llama a la ventana VModBor con los datos del cliente seleccionado*/
    private void jTableListadoMouseReleased(java.awt.event.MouseEvent evt) {
// TODO add your handling code here:
     
        if (evt.getClickCount()>=2) {
            jTableListado.getCellEditor().stopCellEditing();
            
            String n=(String)getTabla().getValueAt(getTabla().getSelectedRow(),0);
            String a=(String)getTabla().getValueAt(getTabla().getSelectedRow(),1);
            String s=(String)getTabla().getValueAt(getTabla().getSelectedRow(),2 );
            String d=(String)getTabla().getValueAt(getTabla().getSelectedRow(),3);
            String cp=(String)getTabla().getValueAt(getTabla().getSelectedRow(),4);
            String ci=(String)getTabla().getValueAt(getTabla().getSelectedRow(),5);
            String p=(String)getTabla().getValueAt(getTabla().getSelectedRow(),6);
            String t=(String)getTabla().getValueAt(getTabla().getSelectedRow(),7 );
            String m=(String)getTabla().getValueAt(getTabla().getSelectedRow(),8);
            String e=(String)getTabla().getValueAt(getTabla().getSelectedRow(),9);
            String f=(String)getTabla().getValueAt(getTabla().getSelectedRow(),10);
            Cliente c=new Cliente(n,a,s,d,cp,ci,p,t,m,e);
            c.setFechaNac(Fecha.parse(f));
            if (getTabla().getColumnCount()>Cliente.numCamposFijos+1) {
                c.setExtra1((String)getTabla().getValueAt(getTabla().getSelectedRow(),Cliente.numCamposFijos+1));
                if (getTabla().getColumnCount()>Cliente.numCamposFijos+2) {
                    c.setExtra2((String)getTabla().getValueAt(getTabla().getSelectedRow(),Cliente.numCamposFijos+2));
                    
                    if (getTabla().getColumnCount()>Cliente.numCamposFijos+3) {
                        
                        c.setExtra3((String)getTabla().getValueAt(getTabla().getSelectedRow(),Cliente.numCamposFijos+3));
                        if (getTabla().getColumnCount()>Cliente.numCamposFijos+4) {
                            
                            c.setExtra4((String)getTabla().getValueAt(getTabla().getSelectedRow(),Cliente.numCamposFijos+4));
                        }
                    }
                }
            }
            VModBor dm = new VModBor(this.padre,c);
            
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            dm.setLocation(screenSize.width/2-dm.getSize().width/2, screenSize.height/2-dm.getSize().height/2);
            this.padre.getPanelPadre().add(dm);
            this.padre.getPanelPadre().setSelectedFrame(dm);
            dm.setVisible(true);
        }
    }
    /**Llama al jDialog ImportarDatos*/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        ImportarDatos v = new ImportarDatos(null,true,padre);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
        v.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    /**Cierra el VisorGestor y vuelve a la ventana de inicio*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        VInicio v = new VInicio();
        this.padre.getParent().add(v);
        this.padre.dispose();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
        v.show();
    }//GEN-LAST:event_jButton1ActionPerformed
    /**Realiza una búsqueda sensitiva*/
    private void textBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarKeyReleased
// TODO add your handling code here:
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector v=null;
        v =gbd.buscar(textBuscar.getText(),Utilidades.nombreCampoABD((String)comboBoxCampo.getSelectedItem())); //break;
        cargarListadoBusqueda(v);
        gbd.cerrarBD();
    }//GEN-LAST:event_textBuscarKeyReleased
    /**Llama a la ventana VAnyadir*/
    private void botonAnyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnyadirActionPerformed
// TODO add your handling code here:
        VAnyadir va=new VAnyadir(this.padre);
        this.padre.getParent().add(va);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        va.setLocation(screenSize.width/2-va.getSize().width/2, screenSize.height/2-va.getSize().height/2);
        va.show();
    }//GEN-LAST:event_botonAnyadirActionPerformed
    /**Devuelbe la tabla donde se encuentra la información de todos los clientes*/
    public JTable getTabla(){return jTableListado;}
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
            ao[i][0]=c.getNombre();
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
        for (int i=0; i<v1.size();i++) {
            ArrayCampos[i] = Utilidades.nombreCampoAPantalla(v1.elementAt(i).toString());
        }
        
        jTableListado.setModel(new javax.swing.table.DefaultTableModel(ao,ArrayCampos));
 
    }
    /**Carga los datos de los clientes resultados de una búsqueda avanzada que se pasan
     en el vector que se le pasa a la función*/
    public void cargarListadoBusquedaAvanzada(Vector v){
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
        jTableListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableListado.setCellEditor(null);
        jTableListado.enableInputMethods(false);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jTableListado.setAutoscrolls(true);
        jScrollPane1.setVerticalScrollBar(jScrollPane1.createVerticalScrollBar());
        String ArrayCampos[] = new String[v1.size()];
        for (int i=0; i<v1.size();i++) {
            ArrayCampos[i] = v1.elementAt(i).toString();
        }
        
        jTableListado.setModel(new javax.swing.table.DefaultTableModel(ao,ArrayCampos));

        jScrollPane1.setViewportView(jTableListado);
    }
    /**Carga los datos de los clientes resultados de una búsqueda sensitiva que se pasan
     en el vector que se le pasa a la función*/
    public void cargarListadoBusqueda(Vector v) {
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector v1=gbd.obtenerCampos();
        gbd.cerrarBD();
        Object[][]ao=new Object[v.size()][v1.size()];
        for (int i=0;i<v.size();i++) {
            Cliente c=(Cliente)v.elementAt(i);
            ao[i][0]=c.getNombre();
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
        for (int i=0; i<v1.size();i++) {
            ArrayCampos[i] = Utilidades.nombreCampoAPantalla(v1.elementAt(i).toString());
        }
        
        jTableListado.setModel(new javax.swing.table.DefaultTableModel(ao,ArrayCampos));
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton botonAnyadir;
    public javax.swing.JComboBox comboBoxCampo;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableListado;
    public javax.swing.JTextField textBuscar;
    // End of variables declaration//GEN-END:variables
    /**Panel que contiene al panelVisorGestor*/
    JDesktopPane panelPadre;
    /**Consulta sql resultado de las búsquedas*/
    String sqlGuardar;
}
