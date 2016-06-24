package bgc.negocio.proyecto;
import bgc.negocio.Fecha;
import java.io.Serializable;
/**
 * La clase Proyecto gestiona los datos de los proyectos
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
public class Proyecto implements Serializable {
    /** Crea una nueva instancia de Proyecto */
    public Proyecto() {
        nombre="";
        descripcion="";
        fecha = Fecha.fechaHoy();
        tipo = "";
        sql = "";
        html = "";
        setAsunto("");
        formatoEnvio=-1;
    }
    /**
     * Crea una nueva instancia de Proyecto con los atributos
     *nombre proyecto
     *descripcion proyecto
     *fecha proyecto
     *tipo envío
     *consulta sql
     *ruta html
     *asunto del mail
     *formato del envío
     */
   public Proyecto(String n,String d,Fecha f, String t, String s, String h,String a)
    {
        nombre=n;
        descripcion=d;
        fecha = f;
        tipo = t;
        sql = s;
        html = h;
        setAsunto(a);
        formatoEnvio=-1;
        
    }
     /**
     * Asigna el nombre del proyecto con el valor que se le pasa a la función
     */
    public void setNombre(String n){nombre=n;}
    /**
     * Asigna la descripcion del proyecto con el valor que se le pasa a la función
     */
    public void setDescripcion(String d){descripcion=d;}
    /**
     * Asigna la fecha del proyecto con el valor que se le pasa a la función
     */
    public void setFecha(Fecha f){fecha=f;}
    /**
     * Asigna el tipo de envio del proyecto con el valor que se le pasa a la función
     */
    public void setTipo(String t){tipo=t;}
    /**
     * Asigna la consulta sql del proyecto con el valor que se le pasa a la función
     */
    public void setSql(String s){sql=s;}/**
     * Asigna el documento html del proyecto con el valor que se le pasa a la función
     */
    public void setHtml(String h){html=h;}
     /**
     * Devuelve el nombre del proyecto
     */
    public String getNombre(){return nombre;} 
    /**
     * Devuelve la descripcion del proyecto
     */
    public String getDescripcion(){return descripcion;}
     /**
     * Devuelve la fecha del proyecto
     */
    public Fecha getFecha(){return fecha;}
    /**
     * Devuelve el tipo de envio del proyecto
     */
    public String getTipo(){return tipo;}
    /**
     * Devuelve la consulta sql del proyecto
     */
    public String getSql(){return sql;}
    /**
     * Devuelve el documento hatml del proyecto
     */    
    public String getHtml(){return html;}
    /**
     * Devuelve los detalles del proyecto
     */
    public String getDetalles()
    {
	String s="";
	
	s="El proyecto sera enviado de forma manual cuando el usuario lo desee";
	
	return s;
    }
    /**
     * Devuelve el nombe del formato de envio del proyecto
     */
    public String getNombreFormatoEnvio()
    {
        String s="";
        switch (this.getFormatoEnvio() )
        {
            case Proyecto.EMAIL:{ s="email"; }break;
            case Proyecto.EMAIL_SMS:{ s="email y sms";   }break;
            case Proyecto.EMAIL_SMS_CARTA:{  s="email, sms y carta"; }break;
            case Proyecto.SMS:{ s="sms";  }break;
            case Proyecto.SMS_CARTA:{ s="sms y carta"; }break;
            case Proyecto.CARTA:{s="carta"; }break;
            case Proyecto.EMAIL_CARTA:{s="email y carta";}break;
            
        }
        return s;
        
    }
    
    /**Indica el nombre del proyecto*/
    protected String nombre;
    /**Indica la descripción del proyecto*/
    protected String descripcion;
    /**Indica la fecha del proyecto*/
    protected Fecha fecha;
    /**Indica el tipo de envio del proyecto*/
    protected String tipo;
    /**Indica la consulta sql para los destinatarios del proyecto*/
    protected String sql;
    /**Indica la ruta del documento html a enviar*/
    protected String html;
    /**Indica el asunto del mail*/
    private String asunto;
    /**Indica el texto del SMS que se envía a los teléfonos móviles*/
    private String textoSMS;
    /**Indica el formato en el que se va a enviar el proyecto*/
    private int formatoEnvio;
    /**Indica la ruta donde se guardará el proyecto en el disco duro*/
    private String ruta;
    /**Tipo de envio manual*/
    public static final String MANUAL="Manual";
    /**Tipo de envio especial*/
    public static final String ESPECIAL="Especial";
    /**Tipo de envio automatizado*/
    public static final String AUTOMATIZADO="Automatizado";
    /**Formato de envio por email*/
    public static final int EMAIL=0;
     /**Formato de envio por sms*/
    public static final int SMS=1;
     /**Formato de envio por carta*/
    public static final int CARTA=2;
     /**Formato de envio por email, sms y carta*/
    public static final int EMAIL_SMS_CARTA=3;
     /**Formato de envio por email y sms*/
    public static final int EMAIL_SMS=4;
     /**Formato de envio por sms y carta*/
    public static final int SMS_CARTA=5;
     /**Formato de envio por email y carta*/
    public static final int EMAIL_CARTA=6;
  
    /**
     * Devuelve el asunto del proyecto
     */
    public String getAsunto() {
        return asunto;
    }
/**
     * Asigna el asunto del proyecto con el valor que se le pasa a la función
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
/**
     * Devuelve el texto del sms del proyecto
     */
    public String getTextoSMS() {
        return textoSMS;
    }
/**
     * Asigna el texto del sms del proyecto con el valor que se le pasa a la función
     */
    public void setTextoSMS(String textoSMS) {
        this.textoSMS = textoSMS;
    }
/**
     * Devuelve el formato de envio del proyecto
     */
    public int getFormatoEnvio() {
        return formatoEnvio;
    }
/**
     * Asigna el formato de envio del proyecto con el valor que se le pasa a la función
     */
    public void setFormatoEnvio(int formatoEnvio) {
        this.formatoEnvio = formatoEnvio;
    }
/**
     * Devuelve la ruta donde se guardara del proyecto
     */
    public String getRuta() {
        return ruta;
    }
/**
     * Asigna la ruta donde se guardara el proyecto con el valor que se le pasa a la función
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
