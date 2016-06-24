package bgc.negocio.ficheros;

import java.io.*;
/**
 * La clase GuardarFichero proporcina métodos para abrir, escribir y cerrar un fichero
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
public class GuardarFichero {
    /**Fichero en el que se va a escribir*/
    private FileWriter Escribir;
    /**Buffer donde se almacena lo que se va a escribir*/
    private BufferedWriter cauce;
    /**Buffer de escritura*/
    private PrintWriter Salida;
    /**Abre el fichero que se pasa en el valor a la función para escritura*/
    public void abrir(String nombreFich)
        throws IOException
    {
       try{
            Escribir = new FileWriter(nombreFich);
            cauce = new BufferedWriter(Escribir);
            Salida = new PrintWriter(Escribir);
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
        
            if (Salida != null) Salida.close();
       
    }
    /**Escribe en el fichero indicado en el valor que se le pasa a la función*/
    public void escribir(String fichero)
    {
        if (Salida!=null)
        {
           
                Salida.write(fichero);
           
        }
    } 
    
}