package bgc.negocio.proyecto;

import bgc.negocio.*;
import java.io.*;
/**
 * La clase LeerProy proporcina métodos para abrir, leer y cerrar un fichero
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
public class LeerProy {
     /**Filtro de entrada para fichero*/
    private FileInputStream Escribir;
     /**Filtro de entrada para objeto*/
    private ObjectInputStream Salida;
     /**Abre el fichero que se pasa en el valor a la función para lectura*/
    public void abrir(File f)
        throws IOException
    {
       try{
           
            Escribir = new FileInputStream(f.getAbsoluteFile());
           
            Salida = new ObjectInputStream(Escribir);
            }
        catch(SecurityException s){
            System.err.println("No tiene permiso para leer el fichero");
            throw s;
        }
        catch(FileNotFoundException fi){
            System.err.println(fi.getMessage());
            System.err.println("Error al acceder al fichero");
            throw fi;
        }
    }
     /**Cierra el fichero*/
    public void cerrar()
    {
        try {
            if (Salida != null) Salida.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     /**Lee del fichero indicado en el valor que se le pasa a la función*/
    public Proyecto leer(File f)
    {
        Proyecto p=null;
        
            try {
           
                p=(Proyecto)Salida.readObject();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            
        return p;
    }
    
}
