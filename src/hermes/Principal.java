/*
 * Principal.java
 *
 * Created on 14 de octubre de 2005, 9:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package hermes;

import com.ericdaugherty.mail.server.configuration.ConfigurationManager;
import javax.swing.JOptionPane;


/**
 *
 * @author Aitor
 */
public class Principal {
    
    /** Creates a new instance of Principal */
    public Principal() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        GestorBD gbd=new GestorBD();
//        gbd.abrirBD();
//        gbd.crearBaseDatos();
//        gbd.cerrarBD();
        try{
        ConfigurationManager cfg= ConfigurationManager.initialize("");
        new IconoSistema();
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"ERROR: \n"+ex.getMessage());
        }
       /* VContenedor v=new VContenedor();
      
        v.setVisible(true);*/
    }
    
}
