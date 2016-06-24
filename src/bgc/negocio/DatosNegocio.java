package bgc.negocio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * La clase DatosNegocio gestiona los datos de los comercios donde se configura la aplicación
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
public class DatosNegocio implements Serializable{
    
    /** Crea una nueva instancia de DatosNegocio */
    public DatosNegocio() {
        primeraVez=true;
        this.nombreComercio="";
        this.cif="";
        this.email="";
    }
    
    /** Crea una nueva instancia de DatosNegocio con los atributos
     *nombre
     *cif
     *email
     *vez
     */
     public DatosNegocio(String nombre,String cif,String email,boolean vez) {
        
         this.nombreComercio=nombre;
         this.cif=cif;
         this.email=email;
         this.primeraVez=vez;
    }
  
    
    /** retorna el nombre del comercio */
    public String getNombreComercio() {
        return nombreComercio;
    }

    /** modifica el nombre del comercio */
    public void setNombreComercio(String nombreComercio) {
        this.nombreComercio = nombreComercio;
    }

    /** retorna el cif del comercio */
    public String getCif() {
        return cif;
    }

    /** modifica el cif del comercio */
    public void setCif(String cif) {
        this.cif = cif;
    }

    /** retorna el email del comercio */
    public String getEmail() {
        return email;
    }

    /** modifica el email del comercio */
    public void setEmail(String email) {
        this.email = email;
    }

    /** retorna si es la primera vez que se ejecuta la aplicación */
    public boolean isPrimeraVez() {
        return primeraVez;
    }

    /** modifica si es la primera vez que se ejecuta la aplicación */
    public void setPrimeraVez(boolean primeraVez) {
        this.primeraVez = primeraVez;
    }
    
    /** Guarda los datos del comercio en el archivo pvqse.dat,
     devuelve true si todo funciona con normalidad
     devuelve false en caso contrario*/
    public boolean guardarDatos()
    {
        try {
            FileOutputStream f=new FileOutputStream("C:\\Archivos de programa\\Campus-Telematika\\Hermes\\pvqse.dat");
            ObjectOutputStream o=new ObjectOutputStream(f);
            o.writeObject(this);
            
            o.close();
            f.close();
             return true;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
            return false;
    }
    
     /** Lee los datos del comercio del archivo pvqse.dat,
     devuelve true si todo funciona con normalidad
     devuelve false en caso contrario*/
    public boolean leerDatos() throws FileNotFoundException 
    {
        try {
            FileInputStream f=new FileInputStream("C:\\Archivos de programa\\Campus-Telematika\\Hermes\\pvqse.dat");//"C:\\Archivos de Programa\\Hermes\\pvqse.dat");
            ObjectInputStream o=new ObjectInputStream(f);
            
            DatosNegocio tmp=(DatosNegocio)o.readObject();
            
            this.nombreComercio=tmp.getNombreComercio();
            this.cif=tmp.getCif();
            this.email=tmp.getEmail();
            this.primeraVez=tmp.isPrimeraVez();
        
            o.close();
            f.close();
            return true;
        } catch (FileNotFoundException ex) {
            throw ex;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
         return false;
    }
    /**Indica el nombre del comercio*/
    private String nombreComercio;
    /**Indica el cif del comercio*/
    private String cif;
    /**Indica la dirección de correo electronico del comercio*/
    private String email;
    /**Indica si es la primera vez que se ejecuta la aplicación*/
    private boolean primeraVez;
}
