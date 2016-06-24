/*
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

/**
 * Clase  que almacena la información sobre un campo de la tabla
 * @author Campus-Telematika
 */

public class DatoCampo {
    
    /** Creates a new instance of DatoCampo */
    public DatoCampo() {
        setNombre("");
        setTipo("");
        setPos(0);
    }
    
    /**
     * Creates a new instance of DatoCampo
     * @param nombre Nombre del campo
     * @param tipo Tipo de dato del campo
     * @param posicion Posicion del campo en la tabla
     */
    public DatoCampo(String nombre,String tipo,int posicion)
    {
        this.setNombre(nombre);
        this.setTipo(tipo);
        this.setPos(posicion);
    }
   
    /**
     * Retorna el nombre del campo
     * @return El nombre del campo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del campo
     * @param nombre Modifica el nombre del campo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el tipo de dato del campo
     * @return Retorna el tipo de dato del campo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Modifica el tipo de dato del campo
     * @param tipo Modifica el tipo de dato del campo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna la posicion del campo en la tabla
     * @return Retorna la posicion del campo en la tabla
     */
    public int getPos() {
        return pos;
    }

    /**
     * Modifica la posicion del campo en la tabla
     * @param pos Modifica la posicion del campo en la tabla
     */
    public void setPos(int pos) {
        this.pos = pos;
    }
    
    /**
     * Tipo de dato NUMERICO
     */
    public static final String Numero="Numero";
    /**
     * Tipo de dato FECHA
     */
    public static final String Fecha="Fecha";
    /**
     * Tipo de dato TEXTO
     */
    public static final String Texto="Texto";
    /**
     * Tipo de dtao BOOLEANO
     */
    public static final String SiNo="Si/No";
    
    
    private String nombre;
    private String tipo;
    private int pos;
}
