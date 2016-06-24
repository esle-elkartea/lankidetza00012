/*
 * IconoSistema.java
 *
 * Created on 24 de octubre de 2005, 8:20
 *
 * creado por Bergalcas Soft
 */
package hermes;
/**
 *
 * @author Campus-Telematika S.L.
 *
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
import bgc.asistente.VPaso1;
import bgc.gui.VContenedor;
import bgc.gui.inicio.VPresentacion;
import bgc.gui.proy.automat.GestorAuto;
import bgc.negocio.DatosNegocio;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import org.jdesktop.jdic.tray.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
public class IconoSistema implements ActionListener, ItemListener,MouseListener {
    SystemTray tray = SystemTray.getDefaultSystemTray();
    static TrayIcon ti;
    JFrame frame;
    VContenedor vcont;
    
    
    public IconoSistema() {
        
        JPopupMenu menu;
        JMenu  submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;
        
        VPresentacion vp=new VPresentacion();
        vp.setVisible(true);
        vp.cargarProgreso();
        
        
        
        
        DatosNegocio datos=new DatosNegocio();
        try{
            datos.leerDatos();
            
            if (datos.isPrimeraVez()) {
                VPaso1  vpa=new VPaso1();
                vpa.setVisible(true);
                while(vpa.isVisible());
                vcont=new VContenedor();
                vcont.gestorAuto=new GestorAuto();
                vcont.setVisible(true);
                vcont.gestorAuto.iniciarProyectosAuto();
            }  else {
                vcont=new VContenedor();
                vcont.gestorAuto=new GestorAuto();
                vcont.setVisible(true);
                vcont.gestorAuto.iniciarProyectosAuto();
            }
        }catch(FileNotFoundException ex) {
            try {
                FileOutputStream f=new FileOutputStream("C:\\Archivos de programa\\Campus-Telematika\\Hermes\\pvqse.dat");
                ObjectOutputStream o=new ObjectOutputStream(f);
                datos.setPrimeraVez(false);
                o.writeObject(datos);
                o.close();
                f.close();
            } catch (FileNotFoundException ex1) {
                ex.printStackTrace();
            } catch (IOException ex2) {
                ex.printStackTrace();
            }
            
            
            VPaso1  vpa=new VPaso1();
            vpa.setVisible(true);
            
            while(vpa.isVisible());
            vcont=new VContenedor();
            vcont.gestorAuto=new GestorAuto();
            vcont.setVisible(true);
            vcont.gestorAuto.iniciarProyectosAuto();
            
        }
        
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        if( Integer.parseInt(System.getProperty("java.version").substring(2,3)) >=5 )
            System.setProperty("javax.swing.adjustPopupLocationToFit", "false");
        menu = new JPopupMenu("A Menu");
        
        // a group of JMenuItems
        
        
        // ImageIcon icon = new ImageIcon("middle.gif");
        ImageIcon icon = new ImageIcon(IconoSistema.class.getResource("/hermes/imagenes/iconos_barra/icono_barra.png"));
        
        menuItem = new JMenuItem("Hermes", icon);
        menuItem.getAccessibleContext().setAccessibleDescription("Restaurar Hermes");
        menuItem.setMnemonic(KeyEvent.VK_B);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        menu.addSeparator();
        menuItem = new JMenuItem("Hermes en internet... ", KeyEvent.VK_T);
        // menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
                ActionEvent.CTRL_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription("Ir a la pagina web de Hermes");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menu.addSeparator();
        
        menuItem = new JMenuItem("Salir");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        
        // ImageIcon i = new ImageIcon("duke.gif");
        ImageIcon i = new ImageIcon(IconoSistema.class.getResource("/hermes/imagenes/iconos_barra/icono_barra.png"));
        
        ti = new TrayIcon(i, "Hermes", menu);
        
        ti.setPopupMenu(menu);
        ti.setIconAutoSize(true);
        ti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//               System.out.println("ACTION PERFORMEADA");
                
                
                vcont.setVisible(true);
                vcont.setExtendedState(JFrame.MAXIMIZED_BOTH);
                
                
            }
        });
        ti.addBalloonActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Balloon Message been clicked - IconoSistema", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        tray.addTrayIcon(ti);
        
        
    }
    
    
    public static void mostrarMensaje(String titulo,String mensaje,int tipo) {
        ti.displayMessage(titulo, mensaje, tipo);
    }
    
    public static void cambiarIcono(String ruta) {
        ti.setIcon(new ImageIcon(IconoSistema.class.getResource(ruta)));
    }
    
    public void pulsadoMensaje(ActionEvent e) {
        
        
        JOptionPane.showMessageDialog(null,
                "Balloon Message been clicked - IconoSistema", "Message",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
// Returns just the class name -- no package info.
    protected String getClassName(Object o) {
        String classString = o.getClass().getName();
        int dotIndex = classString.lastIndexOf(".");
        
        return classString.substring(dotIndex + 1);
    }
    
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem) (e.getSource());
        String s = source.getText();
        if (s.equalsIgnoreCase("Salir")) {
            System.out.println("Gracias por utilizar Hermes");
            System.exit(0);
        } else
            if (s.equals("Hermes")) {
            vcont.setVisible(true);
            vcont.setExtendedState(JFrame.MAXIMIZED_BOTH);
            } else if (s.equals("Hermes en internet... ")) {
            
            Runtime rtt=Runtime.getRuntime();
            try {
                rtt.exec("cmd /c start iexplore \"http://www.campus-telematika.com/Hermes\"");;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            }
        
        {
            s = "Action event detected." + "\n" + "    Event source: "
                    + source + " (an instance of " + getClassName(source) + ")";
            
            System.out.println(s);
        }
    }
    
    public void itemStateChanged(ItemEvent e) {
        JMenuItem source = (JMenuItem) (e.getSource());
        String s = "Item event detected." + "\n" + "    Event source: "
                + source.getText() + " (an instance of " + getClassName(source)
                + ")" + "\n" + "    New state: "
                + ((e.getStateChange() == ItemEvent.SELECTED)
                ? "selected"
                : "unselected");
        
        System.out.println(s);
    }
    
    public void mouseClicked(MouseEvent e) {
        if ((e.getClickCount()==2) && (e.getButton()==MouseEvent.BUTTON1) ) {
            vcont.setVisible(true);
            vcont.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }
    
    public void mouseReleased(MouseEvent e) {
        
    }
    public void mouseEntered(MouseEvent e) {
        
    }
    
    
    public void mousePressed(java.awt.event.MouseEvent e) {
        
    }
    
    public void mouseExited(java.awt.event.MouseEvent e) {
        
    }
    
}