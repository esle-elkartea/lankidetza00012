package bgc.gui.proy.automat;

import bgc.bd.GestorBD;
import bgc.negocio.Cliente;
import bgc.negocio.correo.ClienteCorreo;
import bgc.negocio.Fecha;
import bgc.negocio.proyecto.LeerProy;
import bgc.negocio.proyecto.ProyectoAuto;
import bgc.negocio.correo.ResultadoEnvio;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
/**
 * La clase GestorAuto proporciona los métodos necesarios para gestionar
 * los proyectos automatizados
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
public class GestorAuto {
    
    /**Crea una nueva instancia de GestorAuto*/
    public GestorAuto() {
        
    }
    /**Carga de la base de datos los proyectos automatizados pendientes*/
    public static void iniciarProyectosAuto() {
        GestorBD gbd=new GestorBD();
        gbd.abrirBD();
        Vector vpa=gbd.obtenerProyectosAutomatizados();
        gbd.cerrarBD();
       
            proyectosAuto=new Vector(vpa.size());
            cargarProyectos(vpa);
     
            if (vpa.size()!=0) {
                inicializarProyectosHoy();
                inicializarProyectosSemanal();
                inicializarProyectosUnaVez();
                inicializarProyectosEspeciales();
            }
       
    }
    /** Aqui cargo todos los proyectos del vector de string a proy */
    private static void cargarProyectos(Vector vpa) {
        for(int i=0;i<proyectosAuto.size();i++) {
            ((Hilo)proyectosAuto.elementAt(i)).destroy();
            proyectosAuto.clear();
        }
 
        LeerProy lp=new LeerProy();
        for (int i=0;i<vpa.size();i++) {
            try {
                ProyectoAuto pa=null;
                File f=new File( (String)vpa.elementAt(i));
                try{
                lp.abrir(f);
                }catch (FileNotFoundException fe)
                {
                    GestorBD gbd=new GestorBD();
                    gbd.abrirBD();
                    gbd.eliminarProyAuto((String)vpa.elementAt(i));
                    gbd.cerrarBD();
                            
                }
                LeerProy lf=new LeerProy();
                try {
                    lf.abrir(f);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                pa=(ProyectoAuto)lf.leer(f);
                lf.cerrar();
                
                Hilo h=new Hilo();
                
                h.setProyecto(pa);
                proyectosAuto.add(h);
                lp.cerrar();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    /**Inicializa los proyectos diarios*/
    private static void inicializarProyectosHoy() {
        
        for (int i=0;i<proyectosAuto.size();i++) {
            if ( ((Hilo)proyectosAuto.get(i)).getProyecto().getTipoEnv()==ProyectoAuto.DIARIO ) {
                if( (((Hilo)proyectosAuto.get(i)).getProyecto().getFechaComienzo().comparar(Fecha.fechaHoy())<=0) &&(((Hilo)proyectosAuto.get(i)).getProyecto().getFechaFin().comparar(Fecha.fechaHoy())>=0 )) {
                
                    ((Hilo)proyectosAuto.elementAt(i)).start();
                }else {
                    
                }
            }
        }
        
    }
    /**Inicializa los proyectos espceciales*/
    private static void inicializarProyectosEspeciales() {
        
        for (int i=0;i<proyectosAuto.size();i++) {
            if ( ((Hilo)proyectosAuto.get(i)).getProyecto().getTipoEnv()==ProyectoAuto.ESPECIAL) {
                
                GestorBD gbd=new GestorBD();
                gbd.abrirBD();
                Vector v=gbd.obtenerListado();
                gbd.cerrarBD();
                
                for(int k=0;k<v.size();k++) {
                    String email=((Cliente)v.elementAt(k)).getEmail();
                    
                    Fecha fecha=((Cliente)v.elementAt(k)).getFechaNac()
                    ;
                    
                    Fecha hoy=Fecha.fechaHoy();
                    
                    if( (fecha.getDia()==hoy.getDia())&& (fecha.getMes()==hoy.getMes()) ) {
                     
                        ResultadoEnvio []as=new ResultadoEnvio[1];
                        ClienteCorreo cc=new ClienteCorreo(((Hilo)proyectosAuto.get(i)).getProyecto().getNombre());
                        as[0]=new ResultadoEnvio(((Cliente)v.elementAt(k)),"");
                        cc.mandarJavaMail(as[0].getCliente(),((Hilo)proyectosAuto.get(i)).getProyecto().getHtml(),((Hilo)proyectosAuto.get(i)).getProyecto().getAsunto(),k);
                    }else {
                        
                    }
                }
            }
        }
    }
    
    /**Inicializa los proyectos semanales*/
    private static void inicializarProyectosSemanal() {
         for (int i=0;i<proyectosAuto.size();i++) {
            if(((Hilo)proyectosAuto.get(i)).getProyecto().getTipoEnv()==ProyectoAuto.SEMANAL) {
                if( (((Hilo)proyectosAuto.get(i)).getProyecto().getFechaComienzo().comparar(Fecha.fechaHoy())<=0) &&(((Hilo)proyectosAuto.get(i)).getProyecto().getFechaFin().comparar(Fecha.fechaHoy())>=0 )) {
                    boolean esta=false;
                    for(int k=0;k<((Hilo)proyectosAuto.get(i)).getProyecto().getDias();k++ ) {
                        
                        if (((Hilo)proyectosAuto.get(i)).getProyecto().getDia(k).getDia()==Fecha.fechaHoy().obtenerDiaSemana()) {
                      
                            ((Hilo)proyectosAuto.elementAt(i)).start();
                        }
                    }
                }else {
                    
                }
            }
        }
        
    }
    /**Inicializa los proyectos de una sola vez*/
    private static void inicializarProyectosUnaVez() {
        
        for (int i=0;i<proyectosAuto.size();i++) {
            if(((Hilo)proyectosAuto.get(i)).getProyecto().getTipoEnv()==ProyectoAuto.UNA_VEZ) {
                if( (((Hilo)proyectosAuto.get(i)).getProyecto().getFechaComienzo().comparar(Fecha.fechaHoy())<=0) &&(((Hilo)proyectosAuto.get(i)).getProyecto().getFechaFin().comparar(Fecha.fechaHoy())>=0 )) {
                
                    ((Hilo)proyectosAuto.elementAt(i)).start();
                }else {
                    
                }
            }
        }
        
    }
    /**Vector de proyectos automatizados*/  
    private static Vector proyectosAuto=null;
}
