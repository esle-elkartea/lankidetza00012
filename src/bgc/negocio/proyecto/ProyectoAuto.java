package bgc.negocio.proyecto;

import bgc.negocio.*;
import java.util.ArrayList;
/**
 * La clase ProyectoAuto gestiona los datos de los proyectos automaticos
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
public class ProyectoAuto extends Proyecto{
    
    /** Crea uan nueva instancia de ProyectoAuto */
    public ProyectoAuto() {
        dias=new ArrayList();
    }
     /**
     * Crea una nueva instancia de ProyectoAuto con los atributos
     *nombre proyecto
     *descripcion proyecto
     *fecha proyecto
     *tipo envío
     *consulta sql
     *ruta html
     */
    public ProyectoAuto(String n,String d,Fecha f, String t, String s, String h)
    {
        nombre=n;
        descripcion=d;
        fecha = f;
        
        tipo = t;
        sql = s;
        html = h;
	dias=new ArrayList();
    }
     /**
     * Crea una nueva instancia de ProyectoAuto con el atributo
     *tipo envío
     */
    public ProyectoAuto(int tipoEnv) {
        
        this.tipoEnv=tipoEnv;
        dias=new ArrayList();
    }
    /** Retorna el tipo de envio que realizara el proyecto automatico */
    public int getTipoEnv() {
        return tipoEnv;
    }
/**
     * Asigna el tipo de envio del proyecto automatico con el valor que se le pasa a la función
     */
    public void setTipoEnv(int tipo) {
        this.tipoEnv = tipo;
    }
  /**
     * Devuelve la fecha de comienzo del proyecto automatico
     */
    public Fecha getFechaComienzo() {
        return fechaComienzo;
    }
/**
     * Asigna la fecha de comienzo del proyecto automatico con el valor que se le pasa a la función
     */
    public void setFechaComienzo(Fecha fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    /**
     * Devuelve el día del ArrayList días de la posición especificada por el valor que se le pasa a la función
     */
    public Dia getDia(int p)
    {
        return (Dia)dias.get(p);
    }
/**Convierte a texto la fecha de comienzo del proyecto automatico*/
    public String toString()
    {
        
        return "Datos de proyecto automatizado: "+fechaComienzo.toString();
    }
    /**Añade un dia que se pasa a la función en el arrayList dias*/
    public void anyadirDia(Dia d)
    {
        dias.add(d);
    }
    /**Elimina todos los días del arrayList dias*/
    public void eliminarDias()
    {
	dias.clear();
    }
    /**Devuelve el número de días del arrayList */
    public int getDias()
    {return dias.size();}
    /***Devuelve la fecha de fin del proyecto automatico*/
    public Fecha getFechaFin() {
        return fechaFin;
    }
/**
     * Asigna la fecha de fin del proyecto automatico con el valor que se le pasa a la función
     */
    public void setFechaFin(Fecha fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    /**Devuelve los detalles del proyecto automatico*/
      public String getDetalles()
	{
	    String s="";
	   
	    
	    switch(tipoEnv)
	    {
		case ProyectoAuto.MENSUAL:{
		    s="El proyecto se enviará de forma automática todos los meses los: \n";
		    
			for(int i=0;i<dias.size();i++)
			    {
			    
			    s+= Dia.nombreDias[((Dia)dias.get(i)).getDia()];   
			    s+=", "+ ((Dia)dias.get(i)).getFecha().toString();
			    s+=", a las "+ ((Dia)dias.get(i)).getHoraTexto()+"\n";

			    }
		    
		} break;
		
		
		case ProyectoAuto.DIARIO:{
		    
			s="El proyecto se enviará de forma automática todos los días laborables a las: \n";
			for(int i=0;i<dias.size();i++)
			    {
			       s+= ((Dia)dias.get(i)).getHoraTexto();

			    }
			   s+="\n Fecha Inicio: "+fechaComienzo.toString();
                           s+="\n Fecha Fin: "+fechaFin.toString();
		    }break;
		    
		    
		case ProyectoAuto.SEMANAL:{
			s="El proyecto se enviará de forma automática los: \n";
			for(int i=0;i<dias.size();i++)
			    {
			    s+= Dia.nombreDias[((Dia)dias.get(i)).getDia()]+"  a las ";   
			    s+= ((Dia)dias.get(i)).getHoraTexto()+"\n";

			    }
			     s+="\n Fecha Inicio: "+fechaComienzo.toString();
                           s+="\n Fecha Fin: "+fechaFin.toString();
		    
		}break;
		case ProyectoAuto.UNA_VEZ:{
			s="El proyecto se enviará de forma automática el día: \n";
			for(int i=0;i<dias.size();i++)
			    {
			    s+= Dia.nombreDias[((Dia)dias.get(i)).getDia()];   
			    s+=", "+ ((Dia)dias.get(i)).getFecha().toString();
			    s+=", a las "+ ((Dia)dias.get(i)).getHoraTexto()+"\n";

			    }
		    
		}break;
	    case ProyectoAuto.ESPECIAL:{
			s="El proyecto se enviará de forma automática los días \n que algún cliente cumpla años";
			
		    
		}break;
	    }
	  /*  s="El proyecto se enviara de forma automatica ";
	    for(int i=0;i<dias.size();i++)
		{
		   s+= Dia.nombreDias[((Dia)dias.get(i)).getDia()];
		
		}
	    */
	    return s;
	}
    /**Indica el tipo de envio del proyecto automatico*/
    private int tipoEnv; 
    /**Indica la fecha de comienzo del proyecot automatico*/
    private Fecha fechaComienzo;
    /**Indica la fecha de fin del proyecto automatico*/
    private Fecha fechaFin;
    /**Contiene los días en los que hay que realizar el envío del proyecto automatico*/
    private ArrayList dias=null;
    /**Todos los meses, número 0 */
    public static final int MENSUAL=0;
    /**Todos los dias, número 1*/
    public static final int DIARIO=1;
    /**Todas las semanas, numero 2*/
    public static final int SEMANAL=2;
    /**Una sola vez, numero 3*/
    public static final int UNA_VEZ=3;
    /**Proyecto especial, numero 4*/
    public static final int ESPECIAL=4;

}
