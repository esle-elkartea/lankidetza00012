package bgc.gui.proy.automat;
import bgc.bd.GestorBD;
import bgc.negocio.Cliente;
import bgc.negocio.correo.ClienteCorreo;
import bgc.negocio.Fecha;
import bgc.negocio.proyecto.ProyectoAuto;
import bgc.negocio.correo.ResultadoEnvio;
import bgc.negocio.proyecto.Proyecto;
import hermes.IconoSistema;
import java.util.Date;
import java.util.Vector;
import org.jdesktop.jdic.tray.TrayIcon;
import java.util.GregorianCalendar;
import java.util.Calendar;
/**
 * La clase Hilo gestiona los diferentes hilos para cada proyecto automatizado
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
public class Hilo extends Thread{
    
    /** Crea una nueva instancia de Hilo */
    public Hilo() {
        fin=false;
    }
    /** Ejecución del hilo*/
    public void run() {
        
        switch(proyecto.getTipoEnv()) {
            case ProyectoAuto.DIARIO:{runDiario(); }   break;
            case ProyectoAuto.SEMANAL:{ runSemanal(); } break;
            case ProyectoAuto.UNA_VEZ:{ runUnaVez(); } break;
            case ProyectoAuto.ESPECIAL:{runCumple();}break;
        }
    }
    /**Devuelbe un proyecto automatizado*/
    public ProyectoAuto getProyecto() {
        return proyecto;
    }
    /**Asigana al proyecto automatizado el valor pasado en la función*/
    public void setProyecto(Proyecto proyecto) {
        this.proyecto = (ProyectoAuto)proyecto;
    }
    
    /** Ejecución del hilo diario*/
    public void runDiario() {
        fin=false;
        
        
        while(!fin ) {
            try {
                
                Thread.sleep(30000);
                Date d=new Date();
                GregorianCalendar c = new GregorianCalendar();
                c.setTime(d);
               
                Fecha fec=new Fecha(c.get(Calendar.DATE),c.get(Calendar.MONTH),c.get(Calendar.YEAR));
                
                String msj="Proyecto "+proyecto.getNombre()+ "\n -- Hora: "+proyecto.getDia(0).getHora()+":"+proyecto.getDia(0).getMin()+" --- ";
              
                if ( proyecto.getDia(0).getHora()==c.get(Calendar.HOUR_OF_DAY) )
                    if (proyecto.getDia(0).getMin()==c.get(Calendar.MINUTE)) {
                    
                    // String msj="Proyecto "+proyecto.getNombre()+ "\n -- Hora: "+proyecto.getDia(0).getHora()+":"+proyecto.getDia(0).getMin()+" ---";
                   
                    IconoSistema.mostrarMensaje("Proyectos automaticos Diario Hermes", msj,TrayIcon.INFO_MESSAGE_TYPE);
                    IconoSistema.cambiarIcono("/hermes/imagenes/iconos_barra/icono_barra_enviando.gif");
                    GestorBD gbd=new GestorBD();
                    gbd.abrirBD();
                    Vector vcli=gbd.obtenerListadoAbrir(proyecto.getSql());
                    gbd.cerrarBD();
                    
                    ResultadoEnvio []as=new ResultadoEnvio[vcli.size()];
                    ClienteCorreo cc=new ClienteCorreo(proyecto.getRuta());
                    for(int i=0;i<vcli.size();i++) {
                        as[i]=new ResultadoEnvio(((Cliente)vcli.elementAt(i)),"");
                        cc.mandarJavaMail(as[i].getCliente(),proyecto.getHtml(),proyecto.getAsunto(),i);
                    }
                    
                     IconoSistema.cambiarIcono("/hermes/imagenes/iconos_barra/icono_barra.png");
                    
                  Thread.sleep(60000);
                    }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
    /** Ejecución del hilo especial*/
     public void runCumple() {
        fin=false;
        
        
        while(!fin ) {
            try {
                
                Thread.sleep(30000);
                Date d=new Date();
                GregorianCalendar c = new GregorianCalendar();
                c.setTime(d);
             
                Fecha fec=new Fecha(c.get(Calendar.DATE),c.get(Calendar.MONTH),c.get(Calendar.YEAR));
                
                String msj="Proyecto "+proyecto.getNombre()+ "\n -- Hora: "+proyecto.getDia(0).getHora()+":"+proyecto.getDia(0).getMin()+" --- ";
               
                if ( proyecto.getDia(0).getHora()==c.get(Calendar.HOUR_OF_DAY) )
                    if (proyecto.getDia(0).getMin()==c.get(Calendar.MINUTE)) {
                    
                                      
                    IconoSistema.mostrarMensaje("Proyectos automaticos Diario Hermes", msj,TrayIcon.INFO_MESSAGE_TYPE);
                    IconoSistema.cambiarIcono("/hermes/imagenes/iconos_barra/icono_barra_enviando.gif");
                    GestorBD gbd=new GestorBD();
                    gbd.abrirBD();
                    Vector vcli=gbd.obtenerListadoAbrir(proyecto.getSql());
                    gbd.cerrarBD();
                    
                    ResultadoEnvio []as=new ResultadoEnvio[vcli.size()];
                    ClienteCorreo cc=new ClienteCorreo(proyecto.getRuta());
                    for(int i=0;i<vcli.size();i++) {
                        as[i]=new ResultadoEnvio(((Cliente)vcli.elementAt(i)),"");
                        cc.mandarJavaMail(as[i].getCliente(),proyecto.getHtml(),proyecto.getAsunto(),i);
                    }
                    IconoSistema.cambiarIcono("/hermes/imagenes/iconos_barra/icono_barra.png");
                    
                    
                  Thread.sleep(60000);
                    }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    

    /** Ejecución del hilo semanal*/
    public void runSemanal() {
        fin=false;
        
        
        while(!fin ) {
            try {
                
                Thread.sleep(30000);
                Date d=new Date();
                GregorianCalendar c = new GregorianCalendar();
                c.setTime(d);
                Fecha fec=new Fecha(c.get(Calendar.DATE),c.get(Calendar.MONTH),c.get(Calendar.YEAR));
               
                
                for(int i=0;i<(proyecto.getDias());i++) {
                    
                 
                    if(proyecto.getDia(i).getDia()==Fecha.fechaHoy().obtenerDiaSemana()) {
                       
                        if ( proyecto.getDia(i).getHora()==c.get(Calendar.HOUR_OF_DAY) )
                            if (proyecto.getDia(i).getMin()==c.get(Calendar.MINUTE)) {
                            
                            String msj="Proyecto "+proyecto.getNombre()+ "\n -- Hora: "+proyecto.getDia(0).getHora()+":"+proyecto.getDia(0).getMin()+" ---";
                            IconoSistema.mostrarMensaje("Proyectos automaticos semanal Hermes", msj,TrayIcon.INFO_MESSAGE_TYPE);
                            IconoSistema.cambiarIcono("/hermes/imagenes/iconos_barra/icono_barra_enviando.gif");
                            GestorBD gbd=new GestorBD();
                            gbd.abrirBD();
                            Vector vcli=gbd.obtenerListadoAbrir(proyecto.getSql());
                            gbd.cerrarBD();
                            
                            ResultadoEnvio []as=new ResultadoEnvio[vcli.size()];
                            ClienteCorreo cc=new ClienteCorreo(proyecto.getRuta());
                            for(int k=0;k<vcli.size();k++) {
                                as[k]=new ResultadoEnvio(((Cliente)vcli.elementAt(k)),"");
                                cc.mandarJavaMail(as[k].getCliente(),proyecto.getHtml(),proyecto.getAsunto(),i);
                            }
                            IconoSistema.cambiarIcono("/hermes/imagenes/iconos_barra/icono_barra.png");
                            Thread.sleep(60000);
                            }
                    }
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    /** Ejecución del hilo una unica vez*/
    public void runUnaVez() {
        fin=false;
        
        
        while(!fin ) {
            try {
                
                Thread.sleep(30000);
                 Date d=new Date();
                 GregorianCalendar c = new GregorianCalendar();
                 c.setTime(d);
               
                Fecha fec=new Fecha(c.get(Calendar.DATE),c.get(Calendar.MONTH),c.get(Calendar.YEAR));
                
                if ( proyecto.getDia(0).getHora()==c.get(Calendar.HOUR_OF_DAY) )
                    if (proyecto.getDia(0).getMin()==c.get(Calendar.MINUTE)) {
                    
                    String msj="Proyecto "+proyecto.getNombre()+ "\n -- Hora: "+proyecto.getDia(0).getHora()+":"+proyecto.getDia(0).getMin()+" ---";
                    IconoSistema.mostrarMensaje("Proyectos automaticos Una vez Hermes", msj,TrayIcon.INFO_MESSAGE_TYPE);
                    fin=true;
                    IconoSistema.cambiarIcono("/hermes/imagenes/iconos_barra/icono_barra_enviando.gif");
                    GestorBD gbd=new GestorBD();
                            gbd.abrirBD();
                            Vector vcli=gbd.obtenerListadoAbrir(proyecto.getSql());
                            gbd.cerrarBD();
                            
                            ResultadoEnvio []as=new ResultadoEnvio[vcli.size()];
                            ClienteCorreo cc=new ClienteCorreo(proyecto.getRuta());
                            for(int k=0;k<vcli.size();k++) {
                                as[k]=new ResultadoEnvio(((Cliente)vcli.elementAt(k)),"");
                                cc.mandarJavaMail(as[k].getCliente(),proyecto.getHtml(),proyecto.getAsunto(),k);
                            }
                            IconoSistema.cambiarIcono("/hermes/imagenes/iconos_barra/icono_barra.png");
                            Thread.sleep(60000);
                    }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
        }
        
    }
    /**Indica si el hilo a finalizado*/
    private boolean fin;
    /**Indica el proyecto automatizado*/
    private ProyectoAuto proyecto;
}
