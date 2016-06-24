/*
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

package bgc.gui.wysiwyg.draganddrop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

/**
 * Clase con los documentos HTML abiertos recientemente
 * @author Campus-Telematika S.L.
 */
public class Reciente implements Serializable{
    
    /**
     * Nombre del documento
     */
    private String nombre;
    /**
     * Nombre absoluto (Ruta)
     */
    private String nombreAbsoluto;
    /**
     * ruta al documento
     */
    private String ruta;
    
    /**
     * Creates a new instance of Reciente
     * @param nombreAbsoluto ruta al documento
     */
    public Reciente(String nombreAbsoluto) {
        this.setNombreAbsoluto(nombreAbsoluto);
        if(nombreAbsoluto.indexOf("\\")>=0) {
            nombre=nombreAbsoluto.substring(nombreAbsoluto.lastIndexOf("\\"));
            ruta=nombreAbsoluto.substring(0,nombreAbsoluto.lastIndexOf("\\"));
        }else if(nombreAbsoluto.indexOf("/")>=0) {
            nombre=nombreAbsoluto.substring(nombreAbsoluto.lastIndexOf("/"));
            ruta=nombreAbsoluto.substring(0,nombreAbsoluto.lastIndexOf("/"));
        }
    }
    /**
     * Crea un nuevo objeto de tipo Reciente
     */
    public Reciente() {
        
    }
    
    /**
     * Retorna el nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Modifica el nombre
     * @param nombre nombre del documento
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Retorna el nombre absoluto
     * @return nombre absoluto
     */
    public String getNombreAbsoluto() {
        return nombreAbsoluto;
    }
    
    /**
     * Modifica el nombre absoluto
     * @param nombreAbsoluto nombre absoluto
     */
    public void setNombreAbsoluto(String nombreAbsoluto) {
        this.nombreAbsoluto = nombreAbsoluto;
    }
    
    /**
     * Retorna la ruta
     * @return ruta
     */
    public String getRuta() {
        return ruta;
    }
    
    /**
     * Modifica la ruta
     * @param ruta ruta
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    /**
     * Lee de fichero los documentos recientes y los retorna en un array
     * @return Array de Reciente
     */
    public static Reciente[] leerRecientes() {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        try {
            fis=new FileInputStream("rec.rec");
            ois = new ObjectInputStream(fis);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Vector v=null;
        
        try {
            v = (Vector) ois.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        Reciente []s=new Reciente[v.size()];
        for(int i=0;i<v.size();i++) {
            s[i]=(Reciente)v.elementAt(i);
        }
        try {
            ois.close();
            fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return s;
    }
    
    /**
     * Guarda los documentos recientes en fichero
     * @param r Array de Reciente
     * @return Array de Reciente
     */
    public static Reciente[] guardarReciente(Reciente r) {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
//        File f=new File("rec.rec");
//        try {
//            f.createNewFile();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        
        try {
            fis=new FileInputStream("C:\\Archivos de programa\\Campus-Telematika\\Hermes\\rec.rec");
            ois = new ObjectInputStream(fis);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Vector v=null;
        if(ois!=null) {
            try {
                v = (Vector) ois.readObject();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            
            
            try {
                
                ois.close();
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else        {
            v=new Vector();
        }
        v.add(r);
        
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try {
            fos=new FileOutputStream("rec.rec");
            oos = new ObjectOutputStream(fos);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            oos.writeObject(v);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Reciente []s=new Reciente[v.size()];
        for(int i=0;i<v.size();i++) {
            s[i]=(Reciente)v.elementAt(i);
        }
        return s;
    }
    
}
