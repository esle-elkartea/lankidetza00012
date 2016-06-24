package bgc.negocio;
/**
 * La clase Utilidades proporciona una serie de métodos para manejar
 * la conversión de los tipos de datos de la base de datos a pantalla
 *y viceversa.
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
 */public class Utilidades {
    
    /** Crea una nueva instancia de Utilidades */
    public Utilidades() {
    }
    /**Transforma un nombre de un campo de la base datos a pantalla (Sustituye guión bajo x blanco)*/
     public static String nombreCampoAPantalla(String nombre)
    {
        return nombre.replace("_"," ");
    }
     /**Transforma un nombre de un campo de la pantalla a la base de datos (Sustituye blanco x guión bajo)*/
    public static String nombreCampoABD(String nombre)
    {
        
        return nombre.replace(" ","_");
        
    }
     /**Transforma Si en true o No en false  */
    public static String siNoABD(String b)
    {
        if (b.equals("Si")) return "true";
       return "false";
    }
    /**Transforma true en Si o false en No  */
    public static String siNoAPantallado(String textito)
    {
        if ((textito).toLowerCase().equals("true")) return "Si";
        return "No";
    }
}
