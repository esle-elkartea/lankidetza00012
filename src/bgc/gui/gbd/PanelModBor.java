package bgc.gui.gbd;
import bgc.bd.GestorBD;
import bgc.negocio.Cliente;
import bgc.negocio.Fecha;
import bgc.negocio.Utilidades;
import java.util.Vector;
import javax.swing.JDesktopPane;
/**
 * La clase PanelModBor proporciona la interfaz necesaria para dar de baja un
 * cliente o modificarlo en la base de datos
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
public class PanelModBor extends javax.swing.JPanel {
    
    /**Nombre en curso del cliente seleccionado*/
    String nombreViejo;
    /**Ventana que llama al panel*/
    VModBor padre;
    /**Cliente seleccionado*/
    Cliente c;
    /** Crea un nuevo jPanel PanelModBor */
    public PanelModBor(VModBor padre, Cliente c) {
        initComponents();
        botoncal1.setVisible(false);
        botoncal2.setVisible(false);
        botoncal3.setVisible(false);
        botoncal4.setVisible(false);
        jLabel9.setVisible(false);
        textOpcion1.setVisible(false);
        jLabel10.setVisible(false);
        textOpcion2.setVisible(false);
        jLabel13.setVisible(false);
        textOpcion3.setVisible(false);
        jLabel14.setVisible(false);
        textOpcion4.setVisible(false);
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector v1=gbd.obtenerCampos();
        gbd.cerrarBD();
        this.c=c;
        if (v1.size()>11) {
            jLabel9.setText(Utilidades.nombreCampoAPantalla((String)v1.get(11)));
            jLabel9.setVisible(true);
            textOpcion1.setVisible(true);
            if (gbd.obtenerTipo((String)v1.get(11)).equals("Si/No")){
                textOpcion1.setText(c.getExtra1());
            }else
                textOpcion1.setText(c.getExtra1());
            gbd.abrirBD();
            if(gbd.obtenerTipo((String)v1.get(11)).equals("Fecha")) {
                botoncal1.setVisible(true);
                textOpcion1.setEditable(false);
            }
            
            
            if (v1.size()>12) {
                jLabel10.setText(Utilidades.nombreCampoAPantalla((String)v1.get(12)));
                jLabel10.setVisible(true);
                textOpcion2.setVisible(true);
                if (gbd.obtenerTipo((String)v1.get(12)).equals("Si/No")){
                    
                    textOpcion2.setText(c.getExtra2());
                }else
                    textOpcion2.setText(c.getExtra2());
                gbd.abrirBD();
                if(gbd.obtenerTipo((String)v1.get(12)).equals("Fecha")) {
                    botoncal2.setVisible(true);
                    textOpcion2.setEditable(false);
                }
                if (v1.size()>13) {
                    jLabel13.setText(Utilidades.nombreCampoAPantalla((String)v1.get(13)));
                    jLabel13.setVisible(true);
                    textOpcion3.setVisible(true);
                    if (gbd.obtenerTipo((String)v1.get(13)).equals("Si/No")){

                        textOpcion3.setText(c.getExtra3());
                    }else
                        textOpcion3.setText(c.getExtra3());
                    gbd.abrirBD();
                    if(gbd.obtenerTipo((String)v1.get(13)).equals("Fecha")) {
                        botoncal3.setVisible(true);
                        textOpcion3.setEditable(false);
                    }
                    if (v1.size()>14) {
                        jLabel14.setText(Utilidades.nombreCampoAPantalla((String)v1.get(14)));
                        jLabel14.setVisible(true);
                        textOpcion4.setVisible(true);
                        if (gbd.obtenerTipo((String)v1.get(14)).equals("Si/No")){

                            textOpcion4.setText(c.getExtra4());
                        }else
                            textOpcion4.setText(c.getExtra4());
                        gbd.abrirBD();
                        if(gbd.obtenerTipo((String)v1.get(14)).equals("Fecha")) {
                            botoncal4.setVisible(true);
                            textOpcion4.setEditable(false);
                        }
                    }else {jLabel14.setVisible(false);textOpcion4.setVisible(false);}
                }else {jLabel13.setVisible(false);textOpcion3.setVisible(false);}
            }else {jLabel10.setVisible(false);textOpcion2.setVisible(false);}
        }else {jLabel9.setVisible(false);textOpcion1.setVisible(false);}
        
        this.padre=padre;
        this.textNombre.setText(c.getNombre());
        nombreViejo=c.getNombre();
        this.textApellido.setText(c.getApellido());
        this.textSexo.setSelectedItem(c.getSexo());
        this.textDireccion.setText(c.getDireccion());
        this.textCP.setText(c.getCP());
        this.textTelefono.setText(c.getTelefono());
        this.txtMovil.setText(c.getMovil());
        this.textEmail.setText(c.getEmail());
        this.textProvincia.addItem("A CORUNA");
        this.textProvincia.addItem("ALBACETE");
        this.textProvincia.addItem("ALICANTE");
        this.textProvincia.addItem("ALMERIA");
        this.textProvincia.addItem("ARABA");
        this.textProvincia.addItem("ASTURIAS");
        this.textProvincia.addItem("AVILA");
        this.textProvincia.addItem("BADAJOZ");
        this.textProvincia.addItem("BARCELONA");
        this.textProvincia.addItem("BIZKAIA");
        this.textProvincia.addItem("BURGOS");
        this.textProvincia.addItem("CACERES");
        this.textProvincia.addItem("CADIZ");
        this.textProvincia.addItem("CANTABRIA");
        this.textProvincia.addItem("CASTELLON");
        this.textProvincia.addItem("CEUTA");
        this.textProvincia.addItem("CIUDAD REAL");
        this.textProvincia.addItem("CORDOBA");
        this.textProvincia.addItem("CUENCA");
        this.textProvincia.addItem("GIPUZKOA");
        this.textProvincia.addItem("GIRONA");
        this.textProvincia.addItem("GRANADA");
        this.textProvincia.addItem("GUADALAJARA");
        this.textProvincia.addItem("HUELVA");
        this.textProvincia.addItem("HUESCA");
        this.textProvincia.addItem("BALEARES");
        this.textProvincia.addItem("JAEN");
        this.textProvincia.addItem("LA RIOJA");
        this.textProvincia.addItem("LAS PALMAS DE GRAN CANARIA");
        this.textProvincia.addItem("LEON");
        this.textProvincia.addItem("LUGO");
        this.textProvincia.addItem("LLEIDA");
        this.textProvincia.addItem("MADRID");
        this.textProvincia.addItem("MALAGA");
        this.textProvincia.addItem("MELILLA");
        this.textProvincia.addItem("MURCIA");
        this.textProvincia.addItem("NAVARRA");
        this.textProvincia.addItem("OURENSE");
        this.textProvincia.addItem("PALENCIA");
        this.textProvincia.addItem("PONTEVEDRA");
        this.textProvincia.addItem("SALAMANCA");
        this.textProvincia.addItem("SANTA CRUZ DE TENERIFE");
        this.textProvincia.addItem("SEGOVIA");
        this.textProvincia.addItem("SEVILLA");
        this.textProvincia.addItem("SORIA");
        this.textProvincia.addItem("TARRAGONA");
        this.textProvincia.addItem("TERUEL");
        this.textProvincia.addItem("TOLEDO");
        this.textProvincia.addItem("VALENCIA");
        this.textProvincia.addItem("VALLADOLID");
        this.textProvincia.addItem("ZAMORA");
        this.textProvincia.addItem("ZARAGOZA");
        this.textProvincia.setSelectedItem(c.getProvincia());
        this.textCiudad.setText(c.getCiudad());
        this.textFecha.setText(c.getFechaNac().toString());
        this.textFecha.setEditable(false);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        textApellido = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        textDireccion = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textCP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMovil = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textCiudad = new javax.swing.JTextField();
        textOpcion1 = new javax.swing.JTextField();
        textOpcion2 = new javax.swing.JTextField();
        textOpcion3 = new javax.swing.JTextField();
        textOpcion4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        textSexo = new javax.swing.JComboBox();
        textProvincia = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        botonCerrar = new javax.swing.JButton();
        botoncal1 = new javax.swing.JButton();
        botoncal2 = new javax.swing.JButton();
        botoncal3 = new javax.swing.JButton();
        botoncal4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        textFecha = new javax.swing.JTextField();
        botoncal5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 240));
        setOpaque(false);
        jLabel1.setBackground(new java.awt.Color(240, 240, 240));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel1.setText("Nombre");

        jLabel2.setBackground(new java.awt.Color(240, 240, 240));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel2.setText("Apellidos");

        textNombre.setBackground(new java.awt.Color(240, 240, 240));
        textNombre.setFont(new java.awt.Font("Arial", 0, 12));

        textApellido.setBackground(new java.awt.Color(240, 240, 240));
        textApellido.setFont(new java.awt.Font("Arial", 0, 12));

        jLabel12.setBackground(new java.awt.Color(240, 240, 240));
        jLabel12.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel12.setText("Telefono");

        jLabel11.setBackground(new java.awt.Color(240, 240, 240));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel11.setText("Direccion");

        jLabel3.setBackground(new java.awt.Color(240, 240, 240));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel3.setText("Email");

        textEmail.setBackground(new java.awt.Color(240, 240, 240));
        textEmail.setFont(new java.awt.Font("Arial", 0, 12));

        textDireccion.setBackground(new java.awt.Color(240, 240, 240));
        textDireccion.setFont(new java.awt.Font("Arial", 0, 12));

        textTelefono.setBackground(new java.awt.Color(240, 240, 240));
        textTelefono.setFont(new java.awt.Font("Arial", 0, 12));

        jLabel4.setBackground(new java.awt.Color(240, 240, 240));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel4.setText("Sexo");

        textCP.setBackground(new java.awt.Color(240, 240, 240));
        textCP.setFont(new java.awt.Font("Arial", 0, 12));

        jLabel5.setBackground(new java.awt.Color(240, 240, 240));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setText("C\u00f3digo Postal");

        jLabel6.setBackground(new java.awt.Color(240, 240, 240));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setText("M\u00f3vil");

        txtMovil.setBackground(new java.awt.Color(240, 240, 240));
        txtMovil.setFont(new java.awt.Font("Arial", 0, 12));

        jLabel7.setBackground(new java.awt.Color(240, 240, 240));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel7.setText("Ciudad");

        jLabel8.setBackground(new java.awt.Color(240, 240, 240));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel8.setText("Provincia");

        textCiudad.setBackground(new java.awt.Color(240, 240, 240));
        textCiudad.setFont(new java.awt.Font("Arial", 0, 12));

        textOpcion1.setBackground(new java.awt.Color(240, 240, 240));
        textOpcion1.setFont(new java.awt.Font("Arial", 0, 12));

        textOpcion2.setBackground(new java.awt.Color(240, 240, 240));
        textOpcion2.setFont(new java.awt.Font("Arial", 0, 12));

        textOpcion3.setBackground(new java.awt.Color(240, 240, 240));
        textOpcion3.setFont(new java.awt.Font("Arial", 0, 12));

        textOpcion4.setBackground(new java.awt.Color(240, 240, 240));
        textOpcion4.setFont(new java.awt.Font("Arial", 0, 12));

        jLabel9.setBackground(new java.awt.Color(240, 240, 240));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel9.setText("opcion1");

        jLabel10.setBackground(new java.awt.Color(240, 240, 240));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel10.setText("opcion2");

        jLabel13.setBackground(new java.awt.Color(240, 240, 240));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel13.setText("opcion3");

        jLabel14.setBackground(new java.awt.Color(240, 240, 240));
        jLabel14.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel14.setText("opcion4");

        textSexo.setBackground(new java.awt.Color(240, 240, 240));
        textSexo.setFont(new java.awt.Font("Arial", 0, 12));
        textSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Femenino" }));

        textProvincia.setBackground(new java.awt.Color(240, 240, 240));
        textProvincia.setFont(new java.awt.Font("Arial", 0, 12));

        jButton1.setBackground(new java.awt.Color(240, 240, 240));
        jButton1.setFont(new java.awt.Font("Arial", 0, 12));
        jButton1.setText("Borrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botonAceptar.setBackground(new java.awt.Color(240, 240, 240));
        botonAceptar.setFont(new java.awt.Font("Arial", 0, 12));
        botonAceptar.setText("Modificar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCerrar.setBackground(new java.awt.Color(240, 240, 240));
        botonCerrar.setFont(new java.awt.Font("Arial", 0, 12));
        botonCerrar.setText("Cancelar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        botoncal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/automat/icono_calendario.gif")));
        botoncal1.setBorder(null);
        botoncal1.setBorderPainted(false);
        botoncal1.setContentAreaFilled(false);
        botoncal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncal1ActionPerformed(evt);
            }
        });

        botoncal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/automat/icono_calendario.gif")));
        botoncal2.setBorder(null);
        botoncal2.setBorderPainted(false);
        botoncal2.setContentAreaFilled(false);
        botoncal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncal2ActionPerformed(evt);
            }
        });

        botoncal3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/automat/icono_calendario.gif")));
        botoncal3.setBorder(null);
        botoncal3.setBorderPainted(false);
        botoncal3.setContentAreaFilled(false);
        botoncal3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncal3ActionPerformed(evt);
            }
        });

        botoncal4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/automat/icono_calendario.gif")));
        botoncal4.setBorder(null);
        botoncal4.setBorderPainted(false);
        botoncal4.setContentAreaFilled(false);
        botoncal4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncal4ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel15.setText("Fecha Nacimiento");

        textFecha.setBackground(new java.awt.Color(240, 240, 240));
        textFecha.setFont(new java.awt.Font("Arial", 0, 12));

        botoncal5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/imagenes/automat/icono_calendario.gif")));
        botoncal5.setBorder(null);
        botoncal5.setBorderPainted(false);
        botoncal5.setContentAreaFilled(false);
        botoncal5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoncal5ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(559, Short.MAX_VALUE)
                .add(botonCerrar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(botonAceptar))
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel14)
                    .add(jLabel13)
                    .add(jLabel10)
                    .add(jLabel9)
                    .add(jLabel3)
                    .add(jLabel15)
                    .add(jLabel4)
                    .add(jLabel1)
                    .add(jLabel11)
                    .add(jLabel7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(textOpcion4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(botoncal4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(textOpcion3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .add(textOpcion2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .add(textOpcion1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(textDireccion, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .add(textNombre, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                                .add(textCiudad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 259, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(textSexo, 0, 259, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, textEmail, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .add(textFecha, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, botoncal5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, botoncal1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, botoncal2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, botoncal3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel8)
                            .add(jLabel2)
                            .add(jLabel5))
                        .add(14, 14, 14)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, textProvincia, 0, 259, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, textTelefono, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtMovil, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, textCP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, textApellido, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)))
                    .add(jLabel12)
                    .add(jLabel6))
                .add(38, 38, 38))
        );

        layout.linkSize(new java.awt.Component[] {textCP, textDireccion, textProvincia, textTelefono, txtMovil}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.linkSize(new java.awt.Component[] {textOpcion1, textOpcion2, textOpcion3, textOpcion4}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.linkSize(new java.awt.Component[] {textApellido, textNombre}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.linkSize(new java.awt.Component[] {textCiudad, textEmail, textSexo}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel3)
                        .add(28, 28, 28))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel2)
                                    .add(textApellido, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel5)
                                    .add(textCP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(29, 29, 29)
                                        .add(textTelefono, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(txtMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(26, 26, 26)
                                        .add(jLabel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jLabel6))
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel8)
                                        .add(textProvincia, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel1)
                                    .add(textNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(textDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(textCiudad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jLabel7))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabel4)
                                    .add(textSexo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(textEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(botoncal5)
                            .add(jLabel15)
                            .add(textFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(botoncal1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9)
                    .add(textOpcion1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(botoncal2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel10)
                    .add(textOpcion2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(botoncal3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel13)
                    .add(textOpcion3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(textOpcion4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(botoncal4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel14))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 15, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(botonAceptar)
                    .add(jButton1)
                    .add(botonCerrar)))
        );
    }// </editor-fold>//GEN-END:initComponents
     /**Muestra un calendario para elegir la fecha de nacimiento*/
    private void botoncal5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncal5ActionPerformed
// TODO add your handling code here:
        new VCalendario(null,true,textFecha).setVisible(true);
    }//GEN-LAST:event_botoncal5ActionPerformed
     /**Muestra un calendario para elegir la fecha del campo extra 4*/
    private void botoncal4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncal4ActionPerformed
// TODO add your handling code here:
        new VCalendario(null,true,textOpcion1).setVisible(true);
    }//GEN-LAST:event_botoncal4ActionPerformed
     /**Muestra un calendario para elegir la fecha del campo extra 3*/
    private void botoncal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncal3ActionPerformed
// TODO add your handling code here:
        new VCalendario(null,true,textOpcion1).setVisible(true);
    }//GEN-LAST:event_botoncal3ActionPerformed
     /**Muestra un calendario para elegir la fecha del campo extra 2*/
    private void botoncal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncal2ActionPerformed
// TODO add your handling code here:
        new VCalendario(null,true,textOpcion1).setVisible(true);
    }//GEN-LAST:event_botoncal2ActionPerformed
     /**Muestra un calendario para elegir la fecha del campo extra 1*/
    private void botoncal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoncal1ActionPerformed
// TODO add your handling code here:
        new VCalendario(null,true,textOpcion1).setVisible(true);
    }//GEN-LAST:event_botoncal1ActionPerformed
    /**Cierra la ventana que llamo al panel*/
    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
// TODO add your handling code here:
        
        this.padre.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed
    /**Modifica el cliente en la base de datos*/
    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
// TODO add your handling code here:
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Cliente cli=new Cliente(textNombre.getText(),textApellido.getText(),textSexo.getSelectedItem().toString(),textDireccion.getText(),textCP.getText(),textCiudad.getText(),textProvincia.getSelectedItem().toString(),textEmail.getText(),textTelefono.getText(),txtMovil.getText(),textOpcion1.getText(),textOpcion2.getText(),textOpcion3.getText(),textOpcion4.getText());
        try {
            cli.setFechaNac(Fecha.parse(textFecha.getText()));
        } catch (Exception e){
            cli.setFechaNac(Fecha.parseBD(textFecha.getText()));
        }
        
        gbd.modificar(cli,c);
        
        gbd.cerrarBD();
        this.padre.getPadre().cargarListado();
        this.padre.dispose();
        
    }//GEN-LAST:event_botonAceptarActionPerformed
    /**Borra el cliente de la base de datos*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        gbd.darDeBaja(this.textNombre.getText());
        gbd.cerrarBD();
        this.padre.getPadre().cargarListado();
        this.padre.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botoncal1;
    private javax.swing.JButton botoncal2;
    private javax.swing.JButton botoncal3;
    private javax.swing.JButton botoncal4;
    private javax.swing.JButton botoncal5;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textCP;
    private javax.swing.JTextField textCiudad;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textFecha;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textOpcion1;
    private javax.swing.JTextField textOpcion2;
    private javax.swing.JTextField textOpcion3;
    private javax.swing.JTextField textOpcion4;
    private javax.swing.JComboBox textProvincia;
    private javax.swing.JComboBox textSexo;
    private javax.swing.JTextField textTelefono;
    private javax.swing.JTextField txtMovil;
    // End of variables declaration//GEN-END:variables
    /**Panel que contiene al panel actual*/
    JDesktopPane panelPadre;
}