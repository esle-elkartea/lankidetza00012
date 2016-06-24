package bgc.negocio;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * La clase Fecha gestiona y proporciona una serie de métodos para manejar
 * los datos del tipo Fecha
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
public class Fecha implements Serializable {
    
    /** Crea una nueva instancia de Fecha */
    public Fecha() {
        
    }
    /** Crea una nueva instancia de Fecha con los atributos
     Dia
     Mes
     Anyo
     */
    public Fecha(int d, int m, int a){
        setDia(d);
        setMes(m);
        setAnyo(a);
    }
    /**Devuelve el dia*/
    public int getDia() {
        return dia;
    }
    /**Modifica el dia con el valor que se le pasa a la función*/
    public void setDia(int d) {
        this.dia = d;
    }
    /**
     *Devuelve el mes
     */
    public int getMes() {
        return mes;
    }
    /**Modifica el mes con el valor que se le pasa a la función*/
    public void setMes(int m) {
        this.mes = m;
    }
    /**Devuelve el año*/
    public int getAnyo() {
        return anyo;
    }
    /**Modifica el año con el valor que se le pasa a la función*/
    public void setAnyo(int a) {
        this.anyo = a;
    }
    /**Devuelve el número de dias del año*/
    public long diasDelAnyo(int aa) {
        return (esBisiesto(aa) ? 366 : 365);
    }
    /**Determina si un año es bisiesto o no*/
    public boolean esBisiesto(int aa) {
        if ((( anyo % 4 == 0 ) && ( anyo % 100 != 0 )) || ( anyo % 400 == 0 ))
            return true;
        return false;
    }
    /**Devuelve el número de día del mes*/    
    public long diasDelMes(int mm, int aa) {
        if (mm==4 || mm==6 || mm==9 || mm== 11)
            return 30;
        if (mm==2)
            if (esBisiesto(aa))
                return 29;
            else return 28;
        else return 31;
    }
    /* Retorna el número de dias transcurridos entre el 1-1-1900 y la fecha del objeto.*/
    public long getNumeroDias() {
        long d=0;
        for (int aa=1900; aa <= anyo -1; aa++)
            d+= diasDelAnyo(aa);
        for (int mm=1; mm <= mes-1; mm++)
            d+=diasDelMes(mm, anyo);
        return d += dia-1;
    }
       
    /* Compara dos fechas retornado un numero entero
     
     *      posibles valores que retorna:
     *              -1   si la fecha del objeto en curso es menor que la Fecha fecha
     *              0    si las Fechas son iguales
     *              1    si la Fecha fecha es mayor que la del objeto en curso
     */
    public int comparar(Fecha fecha) {
        
        long ft=this.getNumeroDias()-fecha.getNumeroDias();
        
        if (ft<0)
            return -1;
        else if(ft>0)
            return 1;
        return 0;
    }
    
    /**Devuelve la fecha actual*/
    public static Fecha fechaHoy() {
        Date d = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(d);
        System.out.println(c.get(Calendar.DATE)+" dia semana: "+c.get(Calendar.YEAR));
        return new Fecha(c.get(Calendar.DATE),c.get(Calendar.MONTH)+1,c.get(Calendar.YEAR));
        
        
        
    }
    /**Devuelve el número de dia de la semana*/
    public  int obtenerDiaSemana() {
        long l=this.getNumeroDias()-2;
        long d=l%7;
        
        return (int)d;
    }
    /**Devuelve la fecha restandole al año el valor que se le pasa a la función*/
    public Fecha restarAnyos(int a) {
        return new Fecha(dia,mes,anyo-a);
        
    }
    /**Devuelve la fecha en formato texto*/
    public String toString() {
        String s="";
        if (dia<10)
            s+="0"+dia+"/";
        else s+=dia+"/";
        if (mes<10)
            s+="0"+mes+"/";
        else s+=mes+"/";
        if (anyo<10)
            s+="0"+anyo;
        else s+=anyo;
        return s;
    }
    
    /**Devuelve una fecha a partir de un string con el caracter de separación /*/
    public static Fecha parse(String f) {
        int d=Integer.parseInt(f.substring(0,f.indexOf("/")));
        int m=Integer.parseInt(f.substring(f.indexOf("/")+1,f.lastIndexOf("/")));
        int a=Integer.parseInt(f.substring(f.lastIndexOf("/")+1,f.length()));
        return new Fecha(d,m,a);
    }
    /**Devuelve una fecha a partir de un string con el caracter de separación -*/
    public static Fecha parseBD(String f) {
        int d=Integer.parseInt(f.substring(0,f.indexOf("-")));
        int m=Integer.parseInt(f.substring(f.indexOf("-")+1,f.lastIndexOf("-")));
        int a=Integer.parseInt(f.substring(f.lastIndexOf("-")+1,f.length()));
        return new Fecha(d,m,a);
    }
   /**  Convierte un string fecha a un string comprendible por la base de datos*/
    public static String aFormatoBD(String f) {
        try{
            if (f.indexOf("/")>=0) {
                int d=Integer.parseInt(f.substring(0,f.indexOf("/")));
                int m=Integer.parseInt(f.substring(f.indexOf("/")+1,f.lastIndexOf("/")));
                int a=Integer.parseInt(f.substring(f.lastIndexOf("/")+1,f.length()));
                return ""+a+"-"+m+"-"+d;
            }else if (f.indexOf("-")>=0) {
                int d=Integer.parseInt(f.substring(0,f.indexOf("-")));
                int m=Integer.parseInt(f.substring(f.indexOf("-")+1,f.lastIndexOf("-")));
                int a=Integer.parseInt(f.substring(f.lastIndexOf("-")+1,f.length()));
                return ""+a+"-"+m+"-"+d;
            }
        }catch(Exception  e ) {
        }
        return "0-0-0";
    }
    /**  Convierte un string fecha de la base de datos a un string fecha para presenta en pantalla*/
    public static String aFormatoLocal(String f) {
        
        if (f.indexOf("-")>=0) {
            int a=Integer.parseInt(f.substring(0,f.indexOf("-")));
            int m=Integer.parseInt(f.substring(f.indexOf("-")+1,f.lastIndexOf("-")));
            int d=Integer.parseInt(f.substring(f.lastIndexOf("-")+1,f.length()));
            return ""+d+"-"+m+"-"+a;
        } else  if (f.indexOf("/")>=0){ int a=Integer.parseInt(f.substring(0,f.indexOf("/")));
        int m=Integer.parseInt(f.substring(f.indexOf("/")+1,f.lastIndexOf("/")));
        int d=Integer.parseInt(f.substring(f.lastIndexOf("/")+1,f.length()));
        return ""+d+"-"+m+"-"+a;
        }
        return "0-0-0";
    }
    /**Ordena la fecha en dia/mes/año*/
    public static String ordenarFecha(String f)
    {try{
        String fechita=f;
        String dia;
        String mes;
        String anio;
        anio = fechita.substring(0,4);
        mes = fechita.substring(5,7);
        dia = fechita.substring(8,10);
        fechita = dia+"/"+mes+"/"+anio;
    return fechita;
     }catch(StringIndexOutOfBoundsException ex)
    {
        return "01/01/01";
    }
    }
    /**Indica el dia*/
    private int dia;
    /**Indica el año*/
    private int mes;
    /**Indica el año*/
    private int anyo;
    
}
