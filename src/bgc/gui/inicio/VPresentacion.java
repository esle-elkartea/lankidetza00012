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

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;

/**
 * Ventana con la imagen de presentación
 * @author Campus-Telematika S.L.
 */
public class VPresentacion extends javax.swing.JFrame {
    
    /** Creates new form VPresentacion */
    public VPresentacion() {
        initComponents();//getImage("./images/logoHermesG.jpg")
        this.setSize(502,273);
        barraProgreso = new javax.swing.JProgressBar();
        texto=new JLabel();
        barraProgreso.setMaximum(10);
        barraProgreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 0), new java.awt.Color(51, 102, 255), new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204)));
    
        jLabel1.add(barraProgreso);
        barraProgreso.setLocation(180,225);
        barraProgreso.setSize(175,10);
        texto.setSize(200,25);
        texto.setLocation(180,195);
        
        jLabel1.add(texto);
        
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2-50);
       // cargarProgreso();
        //this.texto.setBackground(Color.);
        
    }
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setUndecorated(true);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/inicio/logo_inicio_hermes_f.png")));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel1)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
  
    
    /**
     * carga el progreso
     */
    public void cargarProgreso()
    {
        String[]modulos={"gestor Base Datos","driver hsqldb","entorno grafico","componentes HTML","enlace ficheros","procesos background","menus inicio","automatizacion procesos","Cliente correo","procesos smtp"};
    for(int i=0;i<11;i++)
        {
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
            }
            this.barraProgreso.setValue(i);
            if (i<10)
                this.texto.setText("Cargando "+modulos[i]);
        }
        this.dispose();
    }
    
    private JLabel texto;
    private javax.swing.JProgressBar barraProgreso;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
