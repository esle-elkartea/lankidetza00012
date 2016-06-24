/*
 * InformacionInstalacion.java
 *
 * Created on 29 de diciembre de 2005, 9:08
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

import bgc.negocio.DatosNegocio;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Vector;

/**
 * Clase con la información necesaria para realizar la creacion de la BD
 * @author Campus-Telematika S.L
 */
public class InformacionInstalacion {
    
    
    private int numeroCampos;
    private Vector campos;
    private String directorio;
    private String nombreNegocio;
    private String email;
    private int numcamposOp;
    private String cif;
    
    
    
    
    /** Creates a new instance of InformacionInstalacion */
    
    
    public InformacionInstalacion() {
        
        campos=new Vector(15);
        numeroCampos=0;
        directorio=obtenerDirectorioSistema();
        DatosNegocio datos=new DatosNegocio();
        try {
            datos.leerDatos();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        nombreNegocio=datos.getNombreComercio();
        email=datos.getEmail();
        numcamposOp=0;
        cif=datos.getCif();
        iniciarCampos();
    }
    
    /**
     * Inicializa los campos del Vector
     */
    public void iniciarCampos() {
        
        campos.add(new DatoCampo("Nombre","Texto",0));
        numeroCampos++;
        campos.add(new DatoCampo("Apellidos","Texto",1));
        numeroCampos++;
        campos.add(new DatoCampo("Sexo","Texto",2));
        numeroCampos++;
        campos.add(new DatoCampo("Direccion","Texto",3));
        numeroCampos++;
        campos.add(new DatoCampo("CP","Numero",4));
        numeroCampos++;
        campos.add(new DatoCampo("Poblacion","Texto",5));
        numeroCampos++;
        campos.add(new DatoCampo("Provincia","Texto",6));
        numeroCampos++;
        campos.add(new DatoCampo("Email","Texto",7));
        numeroCampos++;
        campos.add(new DatoCampo("Telefono_Fijo","Texto",8));
        numeroCampos++;
        campos.add(new DatoCampo("Telefono_Movil","Texto",9));
        numeroCampos++;
        campos.add(new DatoCampo("Fecha_Nacimiento","Fecha",10));
        numeroCampos++;
    }
    
    /**
     * Transforma el nombre del campo para que se pueda guardar en la BD
     * @param nombre Nombre del campo
     * @return El nombre validado
     */
    public String nombreCampoABD(String nombre)
    {
        
        return nombre.replace(" ","_");
        
    }
    
    
    /**
     * Transforma el nombre del campo para que se vea mas depurado en pantalla
     * @param nombre Nombre del campo
     * @return El nombre validado
     */
    public String nombreCampoAPantalla(String nombre)
    {
        return nombre.replace("_"," ");
    }
    
    /**
     * Retorna el directorio de la aplicaión
     * @return ruta al directorio de la aplicación
     */
    public String obtenerDirectorioSistema() {
       
            return new File(".").getAbsolutePath();
       
        
    }
    /**
     * Añade un campo mas
     * @param nom Nombre del campo
     * @param tipo tipo de dato
     * @param pos Posición que tendra el campo en la tabla
     */
    public void addCampo(String nom,String tipo,int pos) {
        campos.add(new DatoCampo(nom,tipo,pos));
        numeroCampos++;
        numcamposOp++;
    }
    
    /**
     * Retorna el campo de la posicón pasad por parametro
     * @param p Posición a retornar
     * @return El DatoCampo de dicha posición
     */
    public DatoCampo getCampo(int p) {
        
        for(int i=0;i<campos.size();i++)
            if ( ((DatoCampo)campos.get(i)).getPos()==p )
                return ((DatoCampo)campos.get(i));
        return null;
    }
    /**
     * Eliminar el campo de la posición pasada por parametro
     * @param p Posicion a eliminar
     */
      public void borrarCampo(int p) {
        
        for(int i=0;i<campos.size();i++)
            if ( ((DatoCampo)campos.get(i)).getPos()==p )
                    campos.remove(i);
        numeroCampos--;
        numcamposOp--;
    }
    
    /**
     * Ordena
     */
    public void ordenar() {
        for (int i=0;i<campos.size();i++) {
            for(int k=i+1;k<campos.size();k++) {
                if (((DatoCampo)campos.get(i)).getPos()>((DatoCampo)campos.get(k)).getPos()) {
                    DatoCampo auxI=((DatoCampo)campos.get(i));
                    DatoCampo auxK=((DatoCampo)campos.get(k));
                    campos.remove(i);
                    campos.remove(k);
                    campos.insertElementAt(auxK,i);
                    campos.insertElementAt(auxI,k);
               }
            }
        }
        
    }
    
    /**
     * Retorna el numero de campos que tendra la tabla
     * @return Numero de campos
     */
    public int getNumeroCampos() {
        return numeroCampos;
    }
    
    /**
     * Modifica el numero de campos
     * @param numeroCampos numero de campos que tendra la tabla
     */
    public void setNumeroCampos(int numeroCampos) {
        this.numeroCampos = numeroCampos;
    }
    
    /**
     * Retorna el Vector con los DatoCampo
     * @return Vector de DatoCampo
     */
    public Vector getCampos() {
        return campos;
    }
    
    /**
     * Modifica el Vector de DatoCampo
     * @param campos Vector de DatoCampo
     */
    public void setCampos(Vector campos) {
        this.campos = campos;
    }
    
    /**
     * Retorna el directorio
     * @return Directorio
     */
    public String getDirectorio() {
        return directorio;
    }
    
    /**
     * Modifica el directorio
     * @param directorio Directorio
     */
    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }
    
    /**
     * Reorna el nombre del negocio
     * @return Nombre del negocio
     */
    public String getNombreNegocio() {
        return nombreNegocio;
    }
    
    /**
     * Modifica el nombre del negocio
     * @param nombreNegocio Nombre del negocio
     */
    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }
    
    /**
     * Retorna el email del negocio
     * @return email del negocio
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Modifica el email del negocio
     * @param email Email del negocio
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Retorna el numero de campos opcionales que tendra la tabla clientes
     * @return numero de campos opcionales que tendra la tabla clientes
     */
    public int getNumcamposOp() {
        return numcamposOp;
    }
    
    /**
     * Modifica el numero de campos opcionales que tendra la tabla clientes
     * @param numcamposOp numero de campos opcionales que tendra la tabla clientes
     */
    public void setNumcamposOp(int numcamposOp) {
        this.numcamposOp = numcamposOp;
    }

    /**
     * Retorna el CIF
     * @return CIF del negocio
     */
    public String getCif() {
        return cif;
    }

    /**
     * Modifica el CIF
     * @param cif CIF del negocio
     */
    public void setCif(String cif) {
        this.cif = cif;
    }
    
    
    
}
