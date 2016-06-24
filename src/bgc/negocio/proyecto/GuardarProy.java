package bgc.negocio.proyecto;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import bgc.negocio.proyecto.Proyecto;
/**
 * La clase GuardarProy proporcina métodos para abrir, escribir y cerrar un fichero
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
public class GuardarProy {
    /**Filtro de salida para fichero*/
    private FileOutputStream Escribir;
     /**Filtro de salida para objeto*/
    private ObjectOutputStream Salida;
     /**Abre el fichero que se pasa en el valor a la función para escritura*/
    public void abrir(String nombreProy)
        throws IOException
    {
       try{
            Escribir = new FileOutputStream(nombreProy);
           
            Salida = new ObjectOutputStream(Escribir);
            }
        catch(SecurityException s){
            System.err.println("No tiene permiso para escribir en el fichero");
            throw s;
        }
        catch(FileNotFoundException f){
            System.err.println("Error al crear el fichero");
            throw f;
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
      /**Escribe en el fichero el valor que se le pasa a la función*/
    public void escribir(Proyecto p)
    {
        if (p!=null)
        {
            try {
                Salida.writeObject(p);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
