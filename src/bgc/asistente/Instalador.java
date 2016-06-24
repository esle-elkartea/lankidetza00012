/*
 * Instalador.java
 *
 * Created on 30 de diciembre de 2005, 12:05
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

package bgc.asistente;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Clase que realiza la creacion de la BD
 * @author Campus-Telematika S.L.
 */

public class Instalador {
    
    
    /**
     * Informacion Sobre la instalación
     */
    InformacionInstalacion inf;
 
    
    /**
     * Creates a new instance of Instalador
     * @param inf Informacion de la instalacion
     */
    public Instalador(InformacionInstalacion inf) {
        
       this.inf=inf;
     
    }
    
    
    /**
     * Carga el paso de la instalacion pasado por parametro
     * @param paso Paso a cargar
     * @return Estado del paso
     *        0- Fallo
     *        1- Correcto
     */
    public int cargarPaso(int paso)
    {
        int res=0;
        switch(paso)
        {
            case 0:{ res=crearBD(); }break;
            case 1:{ res=crearTablas(); }break;
           
        }
    return res;
    }
    
    /** Todos los metodos de esta clase retornan un entero significando:
     *  
     *  1- No han ocurrido errores
     *  0- ERROR 
     */
  
    

    
    /**
     * Crea la Base de datos
     * @return Estado de la creacion
     *        0- Fallo
     *        1- Correcto
     */
    public int crearBD()
    {
        File actual=new File("C:\\Archivos de programa\\Campus-Telematika\\Hermes\\BD");//"C:\\Archivos de Programa\\Hermes\\"+"BD");
        actual.mkdir();
       File f=new File("C:\\Archivos de programa\\Campus-Telematika\\Hermes\\BD\\Hermes.odb");//"C:\\Archivos de Programa\\Hermes\\"+"BD"+System.getProperty("file.separator")+"Hermes.odb");
        try {
            if(f.createNewFile())
            {}
                return 1;
          
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
       return 0;
    }
    
    /**
     * Crea la tablas
     * @return Estado de la creacion
     *        0- Fallo
     *        1- Correcto
     */
    public int crearTablas()
    {
        GestorBD gbd =new GestorBD("C:\\Archivos de programa\\Campus-Telematika\\Hermes\\"+System.getProperty("file.separator")+"BD"+System.getProperty("file.separator")+"Hermes.odb");
        gbd.abrirBD();
        gbd.crearTablas(inf.getCampos());
        gbd.cerrarBD();
        return 1;
    }



    
}
