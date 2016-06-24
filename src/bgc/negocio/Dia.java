package bgc.negocio;

import java.io.Serializable;

/**
 * La clase Dia gestiona los datos de los clientes
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
public class Dia implements Serializable{
    
    
    
    
    /** Crea una nueva instacia de Dia */
    public Dia() {
	setFecha(null);
	dia=0;
	hora=0;
	min=0;
    }
    
    /** Devuelve el dia*/
    public int getDia() {
        return dia;
    }
    
    /**Modifica el dia con el valor que se le pasa a la función*/
    public void setDia(int dia) {
        this.dia = dia;
    }
    /**Devuelve la hora*/
    public int getHora() {
        return hora;
    }
    /**Modifica la hora con el valor que se le pasa a la función*/
    public void setHora(int hora) {
        this.hora = hora;
    }
    /**Devuelve el minuto*/
    public int getMin() {
        return min;
    }
    /**Modifica el minuto con el valor que se le pasa a la función*/
    public void setMin(int min) {
        this.min = min;
    }
    /**Devuelve la fecha*/
     public Fecha getFecha() {
        return fecha;
    }
    /**Modifica la fecha con el valor que se le pasa a la función*/
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    /**Devuelve la hora en formato texto*/
    public String getHoraTexto()
    {
	String s="";
	
	if (hora<10)
	    s+="0"+hora+":";
	else s+=hora+":";
	if (min<10)
	    s+="0"+min;
	else s+=min;
	
	return s;
	
    }
    
    
    /**Indica el día*/
    private int dia;
      /**Indica la hora*/
    private int hora;
      /**Indica el minuto*/
    private int min;
      /**Indica la fecha*/
    private Fecha fecha;
    /**Nombre dia LUNES, número día 1*/
    public static final int LUNES=1;
     /**Nombre dia MARTES, número día 2*/
    public static final int MARTES=2;
     /**Nombre dia MIERCOLES, número día 3*/
    public static final int MIERCOLES=3;
     /**Nombre dia JUEVES, número día 4*/
    public static final int JUEVES=4;
     /**Nombre dia VIERNES, número día 5*/
    public static final int VIERNES=5;
     /**Nombre dia SABADO, número día 6*/
    public static final int SABADO=6;
     /**Nombre dia DOMINGO, número día 0*/
    public static final int DOMINGO=0;
    /**Array con los nombrs de los días*/
    public static final String []nombreDias={"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"};

   
}
