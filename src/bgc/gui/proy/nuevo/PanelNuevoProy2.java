package bgc.gui.proy.nuevo;
import bgc.gui.proy.nuevo.automatico.VNuevoProy3TipoEnv;
import bgc.gui.proy.nuevo.especial.VNuevoProy2Esp;
import bgc.negocio.proyecto.Proyecto;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
/**
 * La clase PanelNuevoProy2 ofrece la interfaz necesaria para determinar el 
 * formato del envio e introducir los datos necesarios para el formato elegido
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
public class PanelNuevoProy2 extends javax.swing.JPanel {
   /**Ventana contenedora de este panel*/
    VNuevoProy2 padre;
     /** Crea un nuevo panel PanelNuevoProy2*/
    public PanelNuevoProy2(Proyecto p,VNuevoProy2 padre) {
        proy = p;
        this.padre=padre;
        initComponents();
        this.setSize(475, 310);
        jPanel1.setSize(475, 310);
        jPanel2.setSize(160, 70);
        checkEmail.setVisible(false);
        checkSMS.setVisible(false);
        checkCarta.setVisible(false);
        textoAsunto.setVisible(false);
        textoSMS.setVisible(false);
        jScrollPane1.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jButton3.setEnabled(true);
        jButton1.setVisible(false);
        labelHTML.setVisible(false);
        jLabel3.setVisible(false);
        
        if(proy.getTipo().equals(Proyecto.MANUAL)) {
            checkEmail.setVisible(true);
            checkSMS.setVisible(true);
            checkCarta.setVisible(true);
        }else if ( proy.getTipo().equals(Proyecto.AUTOMATIZADO) ) {
            checkEmail.setVisible(true);
            checkSMS.setVisible(true);
        }else if ( proy.getTipo().equals(Proyecto.ESPECIAL) ) {
            checkEmail.setVisible(true);
            checkSMS.setVisible(true);
        }
        if (proy.getFormatoEnvio()!=-1) {
            switch (proy.getFormatoEnvio()) {
                case Proyecto.EMAIL:{ checkEmail.setSelected(true);
                textoAsunto.setVisible(true);
                jLabel1.setVisible(true);
                jButton1.setVisible(true);
                jButton3.setEnabled(true);
                labelHTML.setVisible(true);
                jLabel3.setVisible(true);
                textoAsunto.setText(proy.getAsunto());
                this.labelHTML.setText(proy.getHtml().substring(proy.getHtml().lastIndexOf("\\")+1));
                
                }break;
                case Proyecto.EMAIL_SMS:{ checkEmail.setSelected(true);  checkSMS.setSelected(true);
                textoAsunto.setVisible(true);
                jLabel1.setVisible(true);
                jButton1.setVisible(true);
                jButton3.setEnabled(true);
                labelHTML.setVisible(true);
                jLabel3.setVisible(true);
                textoSMS.setVisible(true);
                jScrollPane1.setVisible(true);
                jLabel1.setVisible(true);
                jLabel2.setVisible(true);
                textoAsunto.setText(proy.getAsunto());
                this.labelHTML.setText(proy.getHtml().substring(proy.getHtml().lastIndexOf("\\")+1));
                textoSMS.setText(proy.getTextoSMS());
                
                }break;
                case Proyecto.EMAIL_SMS_CARTA:{ checkEmail.setSelected(true); checkSMS.setSelected(true);
                checkCarta.setSelected(true);
                textoAsunto.setVisible(true);
                jLabel1.setVisible(true);
                jButton1.setVisible(true);
                jButton3.setEnabled(true);
                labelHTML.setVisible(true);
                jLabel3.setVisible(true);
                textoSMS.setVisible(true);
                jScrollPane1.setVisible(true);
                jLabel1.setVisible(true);
                jLabel2.setVisible(true);
                textoAsunto.setText(proy.getAsunto());
                this.labelHTML.setText(proy.getHtml().substring(proy.getHtml().lastIndexOf("\\")+1));
                textoSMS.setText(proy.getTextoSMS());
                
                }break;
                case Proyecto.SMS:{ checkSMS.setSelected(true);
                textoSMS.setVisible(true);
                jScrollPane1.setVisible(true);
               
                jLabel2.setVisible(true);
                jButton3.setEnabled(true);
                textoSMS.setText(proy.getTextoSMS());
                }break;
                case Proyecto.SMS_CARTA:{ checkSMS.setSelected(true); checkCarta.setSelected(true);
                textoSMS.setVisible(true);
                jScrollPane1.setVisible(true);
               
                jLabel2.setVisible(true);
                 jButton3.setEnabled(true);
                textoSMS.setText(proy.getTextoSMS());
                }break;
                case Proyecto.CARTA:{checkCarta.setSelected(true);
                 jButton3.setEnabled(true);
                }break;
                case Proyecto.EMAIL_CARTA:{checkEmail.setSelected(true); checkCarta.setSelected(true);
                
                textoAsunto.setVisible(true);
                
                jButton1.setVisible(true);
                jButton3.setEnabled(true);
                labelHTML.setVisible(true);
                jLabel3.setVisible(true);
                textoAsunto.setText(proy.getAsunto());
                this.labelHTML.setText(proy.getHtml().substring(proy.getHtml().lastIndexOf("\\")+1));
                
                }break;
                
                
            }
        }
        
        
        this.validate();
        this.repaint();
        
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        checkEmail = new javax.swing.JCheckBox();
        checkSMS = new javax.swing.JCheckBox();
        checkCarta = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textoAsunto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        labelHTML = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoSMS = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(253, 253, 252));
        setOpaque(false);
        jPanel1.setBackground(new java.awt.Color(253, 253, 252));
        jPanel1.setOpaque(false);
        jPanel2.setBackground(new java.awt.Color(253, 253, 252));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formato de env\u00edo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12)));
        jPanel2.setOpaque(false);
        checkEmail.setBackground(new java.awt.Color(253, 253, 252));
        checkEmail.setFont(new java.awt.Font("Arial", 0, 12));
        checkEmail.setText("Email");
        checkEmail.setToolTipText("");
        checkEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        checkEmail.setMargin(new java.awt.Insets(0, 0, 0, 0));
        checkEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEmailActionPerformed(evt);
            }
        });

        checkSMS.setBackground(new java.awt.Color(253, 253, 252));
        checkSMS.setFont(new java.awt.Font("Arial", 0, 12));
        checkSMS.setText("SMS a movil");
        checkSMS.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        checkSMS.setEnabled(false);
        checkSMS.setMargin(new java.awt.Insets(0, 0, 0, 0));
        checkSMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSMSActionPerformed(evt);
            }
        });

        checkCarta.setBackground(new java.awt.Color(253, 253, 252));
        checkCarta.setFont(new java.awt.Font("Arial", 0, 12));
        checkCarta.setText("Carta");
        checkCarta.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        checkCarta.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(checkEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(checkSMS, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(checkCarta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(checkEmail)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(checkSMS)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(checkCarta)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(216, 228, 198));
        jPanel4.setOpaque(false);
        jLabel1.setBackground(new java.awt.Color(216, 228, 198));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Asunto mailing");

        textoAsunto.setBackground(new java.awt.Color(216, 228, 198));
        textoAsunto.setFont(new java.awt.Font("Arial", 0, 12));

        jLabel3.setBackground(new java.awt.Color(216, 228, 198));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Elegir dise\u00f1o");

        jButton1.setBackground(new java.awt.Color(240, 240, 240));
        jButton1.setFont(new java.awt.Font("Arial", 0, 12));
        jButton1.setText("Elegir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelHTML.setBackground(new java.awt.Color(216, 228, 198));
        labelHTML.setFont(new java.awt.Font("Arial", 1, 12));
        labelHTML.setForeground(new java.awt.Color(0, 0, 204));
        labelHTML.setText("Elija un dise\u00f1o");
        labelHTML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelHTMLMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelHTMLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelHTMLMouseExited(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(216, 228, 198));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Texto SMS");

        jScrollPane1.setAutoscrolls(true);
        textoSMS.setBackground(new java.awt.Color(216, 228, 198));
        textoSMS.setColumns(20);
        textoSMS.setFont(new java.awt.Font("Arial", 0, 12));
        textoSMS.setLineWrap(true);
        textoSMS.setRows(5);
        textoSMS.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textoSMS);

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(jLabel1))
                .add(8, 8, 8)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, textoAsunto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 207, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, labelHTML, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(new java.awt.Component[] {jScrollPane1, labelHTML, textoAsunto}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textoAsunto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(labelHTML, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(240, 240, 240));
        jButton3.setFont(new java.awt.Font("Arial", 0, 12));
        jButton3.setText("Siguiente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(240, 240, 240));
        jButton2.setFont(new java.awt.Font("Arial", 0, 12));
        jButton2.setText("Anterior");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(363, Short.MAX_VALUE)
                .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton3)
                    .add(jButton2))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    /**Lanza el explorador web con el documento html elegido*/
    private void labelHTMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHTMLMouseClicked
// TODO add your handling code here:
        if (!labelHTML.getText().equals("Elija un diseño"))
        {
        Runtime rtt=Runtime.getRuntime();
        try {
            rtt.exec("cmd /c start iexplore \""+proy.getHtml()+"\"");;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        }
    }//GEN-LAST:event_labelHTMLMouseClicked
    /**Cambia el cursor a modo mano*/
    private void labelHTMLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHTMLMouseEntered
// TODO add your handling code here:
        labelHTML.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_labelHTMLMouseEntered
    /**Cambia el cursor a modo normal*/
    private void labelHTMLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHTMLMouseExited
// TODO add your handling code here:
        labelHTML.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_labelHTMLMouseExited
    /**Permite determinar el documento html que se quiere enviar*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Seleccionar fichero html");
            FileFilter filtroObj = new FileFilter() {
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".html") || f.isDirectory()||f.getName().toLowerCase().endsWith(".htm");
                }
                public String getDescription() {
                    return "Ficheros html";
                }
            };
            chooser.setFileFilter(filtroObj);
            
            chooser.setCurrentDirectory(new java.io.File("C:\\Archivos de programa\\Campus-Telematika\\Hermes"));
            int resultado = chooser.showOpenDialog(this.getParent());
            if (resultado == JFileChooser.APPROVE_OPTION){
                File ficheroSeleccionado = chooser.getSelectedFile();
                proy.setHtml(ficheroSeleccionado.getAbsolutePath());
                this.labelHTML.setText(ficheroSeleccionado.getName().substring(ficheroSeleccionado.getName().lastIndexOf("\\")+1));
                
            }
        } catch (HeadlessException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
        /**Determina los datos que hay que insertar para el envio por SMS*/
    private void checkSMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSMSActionPerformed
// TODO add your handling code here:
        textoSMS.setVisible(!textoSMS.isVisible());
        jScrollPane1.setVisible(!jScrollPane1.isVisible());
        jLabel2.setVisible(!jLabel2.isVisible());
       
        
    }//GEN-LAST:event_checkSMSActionPerformed
     /**Determina los datos que hay que insertar para el envio por mail*/
    private void checkEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEmailActionPerformed
// TODO add your handling code here:
        textoAsunto.setVisible(!textoAsunto.isVisible());
        jLabel1.setVisible(!jLabel1.isVisible());
        jButton1.setVisible(!jButton1.isVisible());
        labelHTML.setVisible(!labelHTML.isVisible());
        jLabel3.setVisible(!jLabel3.isVisible());

    }//GEN-LAST:event_checkEmailActionPerformed
    
    /**Lleva al siguiente paso dependiendo del formato de envío elegido y guarda los valores
 del proyecto actuales*/
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        if (checkEmail.isSelected() )
            proy.setFormatoEnvio(Proyecto.EMAIL);
        if (checkSMS.isSelected() )
            proy.setFormatoEnvio(Proyecto.SMS);
        if (checkCarta.isSelected() )
            proy.setFormatoEnvio(Proyecto.CARTA);
        if (checkEmail.isSelected()&&checkSMS.isSelected() )
            proy.setFormatoEnvio(Proyecto.EMAIL_SMS);
        if (checkSMS.isSelected()&&checkCarta.isSelected())
            proy.setFormatoEnvio(Proyecto.SMS_CARTA);
        if (checkEmail.isSelected()&&checkCarta.isSelected() )
            proy.setFormatoEnvio(Proyecto.EMAIL_CARTA);
        if (checkEmail.isSelected()&&checkSMS.isSelected()&&checkCarta.isSelected() )
            proy.setFormatoEnvio(Proyecto.EMAIL_SMS_CARTA);
        
        if ( !checkCarta.isSelected() && !checkEmail.isSelected() && !checkSMS.isSelected()) {
            
                JOptionPane.showMessageDialog(this,"¡Debe elegir un formato de envío!","Aviso",JOptionPane.INFORMATION_MESSAGE);
                return;
            
         }
        
        if ( textoAsunto.isVisible() ) {
            proy.setAsunto(textoAsunto.getText());
            if ( textoAsunto.getText().equals("") ) {
                JOptionPane.showMessageDialog(this,"¡Debe rellenar el asunto del e-mail!","Aviso",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if ( labelHTML.getText().equals("Elija un diseño") ) {
                JOptionPane.showMessageDialog(this,"¡Debe seleccionar el documento HTML!","Aviso",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
         }
        if (textoSMS.isVisible()) {
            proy.setTextoSMS(textoSMS.getText());
            if ( textoSMS.getText().equals("") ) {
                JOptionPane.showMessageDialog(this,"¡Debe rellenar el texto del SMS!","Aviso",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        
        if (proy.getTipo().equals(Proyecto.MANUAL)){
            VNuevoProy3 v = new VNuevoProy3(proy);
            this.padre.getParent().add(v);
            this.padre.dispose();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
            v.show();
        }
        if (proy.getTipo().equals(Proyecto.AUTOMATIZADO)){
            VNuevoProy3 vnp=new VNuevoProy3(this.proy);
            this.padre.getParent().add(vnp);
            this.padre.dispose();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            vnp.setLocation(screenSize.width/2-vnp.getSize().width/2, screenSize.height/2-vnp.getSize().height/2);
            vnp.show();
        }
        if (proy.getTipo().equals(Proyecto.ESPECIAL)) {
            VNuevoProy2Esp v = new VNuevoProy2Esp(proy);
            this.padre.getParent().add(v);
            this.padre.dispose();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
            v.show();
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    /**Lleva al paso anterior*/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VNuevoProy1 v = new VNuevoProy1(proy);
        this.padre.getParent().add(v);
        this.padre.dispose();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        v.setLocation(screenSize.width/2-v.getSize().width/2, screenSize.height/2-v.getSize().height/2);
        v.show();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.ButtonGroup buttonGroup2;
    public javax.swing.ButtonGroup buttonGroup3;
    public javax.swing.JCheckBox checkCarta;
    public javax.swing.JCheckBox checkEmail;
    public javax.swing.JCheckBox checkSMS;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel labelHTML;
    public javax.swing.JTextField textoAsunto;
    public javax.swing.JTextArea textoSMS;
    // End of variables declaration//GEN-END:variables
    /**Variable para la información del proyecto en curso*/
    Proyecto proy;
}



