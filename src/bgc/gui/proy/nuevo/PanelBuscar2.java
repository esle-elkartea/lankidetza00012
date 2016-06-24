package bgc.gui.proy.nuevo;

import bgc.bd.GestorBD;
import bgc.gui.gbd.VCalendario;
import bgc.negocio.Utilidades;
import java.util.Vector;
/**
 *La clase PanelBuscar2 proporciona la interfaz necesaria para la b�squeda
 *avanzada de clientes en la base de datos
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
public class PanelBuscar2 extends javax.swing.JPanel {
    
    /**
     * Crea un nuevo jPanel PanelBuscar1
     */
    public PanelBuscar2() {
        initComponents();
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector v1=gbd.obtenerCampos();
        for (int i=0;i<v1.size();i++) {
            this.jComboBox1.addItem(Utilidades.nombreCampoAPantalla((String)v1.elementAt(i)));
        }
        gbd.cerrarBD();
        this.jRadioButton3.setVisible(false);
        this.jRadioButton4.setVisible(false);
       
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        botoncal5 = new javax.swing.JButton();
        botoncal6 = new javax.swing.JButton();

        setOpaque(false);
        jComboBox1.setBackground(new java.awt.Color(216, 228, 198));
        jComboBox1.setFont(new java.awt.Font("Arial", 1, 12));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel1.setText("De");

        jTextField1.setBackground(new java.awt.Color(216, 228, 198));
        jTextField1.setFont(new java.awt.Font("Arial", 0, 12));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel2.setText("A");

        jTextField2.setBackground(new java.awt.Color(216, 228, 198));
        jTextField2.setFont(new java.awt.Font("Arial", 0, 12));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Arial", 1, 12));
        jRadioButton3.setText("Si");
        jRadioButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton3.setOpaque(false);

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Arial", 1, 12));
        jRadioButton4.setText("No");
        jRadioButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton4.setOpaque(false);
        jRadioButton4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton4StateChanged(evt);
            }
        });

        botoncal5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/automat/icono_calendario.gif")));
        botoncal5.setBorder(null);
        botoncal5.setBorderPainted(false);
        botoncal5.setContentAreaFilled(false);
        botoncal5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncal5ActionPerformed(evt);
            }
        });

        botoncal6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/automat/icono_calendario.gif")));
        botoncal6.setBorder(null);
        botoncal6.setBorderPainted(false);
        botoncal6.setContentAreaFilled(false);
        botoncal6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncal6ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 176, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTextField2)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(botoncal5)
                                    .add(botoncal6)))))
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jLabel2))
                    .add(layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jRadioButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(48, 48, 48)
                        .add(jRadioButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jRadioButton3)
                    .add(jRadioButton4))
                .add(7, 7, 7)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(botoncal5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(botoncal6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void jRadioButton4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton4StateChanged
// TODO add your handling code here:
        if (jRadioButton4.getText().equals("Fecha")&&(jRadioButton4.isSelected())) {
            this.botoncal5.setVisible(true);
            this.botoncal6.setVisible(true);
            this.jTextField1.setText("");
            this.jTextField2.setText("");
            this.jTextField1.setEditable(false);
            this.jTextField2.setEditable(false);
        }else {
            this.botoncal5.setVisible(false);
            this.botoncal6.setVisible(false);
            this.jTextField1.setText("");
            this.jTextField2.setText("");
            this.jTextField1.setEditable(true);
            this.jTextField2.setEditable(true);
        }
        
    }//GEN-LAST:event_jRadioButton4StateChanged
    
    private void botoncal6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncal6ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_botoncal6ActionPerformed
    
    private void botoncal5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncal5ActionPerformed
// TODO add your handling code here:
        new VCalendario(null,true,jTextField1).setVisible(true);
    }//GEN-LAST:event_botoncal5ActionPerformed
    /**Muestra u oculta los componentes del panel de b�squeda en funci�n del tipo
         de datos por el que se desea hacer la b�squeda*/
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
// TODO add your handling code here:
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        this.jTextField1.setText("");
        this.jTextField2.setText("");
        this.jRadioButton3.setSelected(false);
        this.jRadioButton4.setSelected(false);
        this.botoncal5.setVisible(false);
        this.botoncal6.setVisible(false);
        this.jTextField1.setEditable(true);
        this.jTextField2.setEditable(true);
        
        if (gbd.obtenerTipo(Utilidades.nombreCampoABD((String)jComboBox1.getSelectedItem())).equals("Texto")) {
            this.jTextField1.setVisible(true);
            this.jTextField2.setVisible(false);
            this.jLabel1.setVisible(false);
            this.jLabel2.setVisible(false);
            this.jRadioButton3.setVisible(false);
            this.jRadioButton4.setVisible(false);
            this.botoncal5.setVisible(false);
            this.botoncal6.setVisible(false);
            this.jTextField1.setEditable(true);
            this.jTextField2.setEditable(true);
        }
        if (gbd.obtenerTipo(Utilidades.nombreCampoABD((String)jComboBox1.getSelectedItem())).equals("Numero")) {
            this.jTextField1.setVisible(true);
            this.jTextField2.setVisible(true);
            this.jLabel1.setVisible(true);
            this.jLabel2.setVisible(true);
            this.jLabel1.setText("Entre:");
            this.jLabel2.setText("Y:");
            this.jRadioButton3.setVisible(false);
            this.jRadioButton4.setVisible(false);
            this.botoncal5.setVisible(false);
            this.botoncal6.setVisible(false);
            this.jTextField1.setEditable(true);
            this.jTextField2.setEditable(true);
        }
        if (gbd.obtenerTipo(Utilidades.nombreCampoABD((String)jComboBox1.getSelectedItem())).equals("Fecha")) {
            this.jTextField1.setVisible(true);
            this.jTextField2.setVisible(true);
            this.jLabel1.setVisible(true);
            this.jLabel2.setVisible(true);
            this.jLabel1.setText("De:");
            this.jLabel2.setText("A:");
            this.jRadioButton3.setVisible(false);
            this.jRadioButton4.setVisible(false);
        }
        if (gbd.obtenerTipo(Utilidades.nombreCampoABD((String)jComboBox1.getSelectedItem())).equals("Si/No")) {
            this.jTextField1.setVisible(false);
            this.jTextField2.setVisible(false);
            this.jLabel1.setVisible(false);
            this.jLabel2.setVisible(false);
            this.jRadioButton3.setVisible(true);
            this.jRadioButton4.setVisible(true);
            this.botoncal5.setVisible(false);
            this.botoncal6.setVisible(false);
            this.jTextField1.setEditable(true);
            this.jTextField2.setEditable(true);
        }
        gbd.cerrarBD();
    }//GEN-LAST:event_jComboBox1ItemStateChanged
    /**Calcula la sentencia sql que se tendr� que ejecutar en fucni�n a los criterios
     * establecidos por el usuario*/
    public String obtenerSentencia() {
        String sql="";
        String campo=Utilidades.nombreCampoABD(((String)jComboBox1.getSelectedItem()));//.toLowerCase();
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        if (gbd.obtenerTipo(campo).equals("Texto")) {
            sql=" ("+campo+" LIKE ('"+jTextField1.getText()+"%') )";
        }
        if (gbd.obtenerTipo(campo).equals("Numero")) {
            
            if (!jTextField1.getText().equals("")&&!jTextField2.getText().equals("")) {
                sql=" ("+campo+" BETWEEN "+jTextField1.getText()+" AND "+jTextField2.getText()+" )";
            } else {
                sql=" ("+campo+" = "+jTextField1.getText()+" )";
            }
        }
        if (gbd.obtenerTipo(campo).equals("Fecha")) {
            
            if (!jTextField1.getText().equals("")&&!jTextField2.getText().equals("")) {
                sql=" ("+campo+" BETWEEN "+jTextField1.getText()+" AND "+jTextField2.getText()+" )";
            } else {
                sql=" ("+campo+" = "+jTextField1.getText()+" )";
            }
        }
        if (gbd.obtenerTipo(campo).equals("Si/No")) {
            if (this.jRadioButton3.isSelected())
                sql=" ("+campo+" LIKE ('true') )";
            else if (this.jRadioButton4.isSelected())
                sql=" ("+campo+" LIKE ('false') )";
        }
        gbd.cerrarBD();
        return sql;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoncal5;
    private javax.swing.JButton botoncal6;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    
}
