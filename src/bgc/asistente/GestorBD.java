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


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * Clase que gestiona la creación de la base de datos.
 * @author Campus-Telematika
 */
public class GestorBD {
    
   
    
    /**
     * Creates a new instance of GestorBD
     * @param ruta Ruta de la Base de Datos
     */
    public GestorBD(String ruta) {
        try{
            Class.forName("org.hsqldb.jdbcDriver");//"org.hsqldb.jdbcDriver");
            this.ruta=ruta;
        }catch(ClassNotFoundException n) {
            System.out.println("ERROR CARGAR DRIVER");
        }
    }
    
    
    /**
     * Abre la conexión a la base de datos
     */
    public void abrirBD() {
        try{
            con =DriverManager.getConnection("jdbc:hsqldb:"+ruta);
            smt=con.createStatement();
            
            
        }catch(SQLException e) {
            System.out.println("ERROR SQL: "+ e.getMessage());
        }
        
    }
    
    /**
     * Cierra la conexión a la base de datos
     */
    public void cerrarBD() {
        try{
            
            smt.close();
            con.close();
        }catch(SQLException e) {
            System.out.println("ERROR SQL: "+ e.getMessage());
        }
    }
    
    /**
     * Retorna el tipo de dato de la columna pasada  por parametro
     * @param t Columna
     * @return Tipo de dato de la columna
     */
    public String obtenerTipo(String t)
    {
        if (t.equals("Texto"))
            return "varchar_ignorecase(255)";
        if (t.equals("Numero"))
            return "integer";
        if (t.equals("Si/No"))
            return "boolean";
        if (t.equals("Fecha"))
            return "date";
        return "varchar_ignorecase(255)";
    
    }
    
    /**
     * Crea las tablas necesarias:
     *        Clientes   --  Tabla de clientes
     *        Campos     --  Tabla con los tipos de datos
     *        ProyectosA --  Tabla con los proyectos programados
     * @param campos Vector con un DatoCampo por cada cloumna de la tabla Clientes
     */
    public void crearTablas(Vector campos) {
        try {
            try{
           smt.executeUpdate("create table ProyectosA (nombre varchar(255))");
            }catch (SQLException se)
            {
                smt.executeUpdate("drop table ProyectosA");
                smt.executeUpdate("create table ProyectosA (nombre varchar(255))");
            }
            
            try{
            smt.executeUpdate("create table Campos(columna varchar (255),tipo varchar(255))");
            }catch (SQLException se)
            {
                smt.executeUpdate("drop table Campos");
                smt.executeUpdate("create table Campos(columna varchar (255),tipo varchar(255))");
            }
            String s="create table Clientes (";
            for(int i=0;i<campos.size();i++) {
                
                DatoCampo c=(DatoCampo)campos.get(i);
                smt.executeUpdate("insert into Campos values ('"+c.getNombre()+"','"+c.getTipo()+"')");
                if (i==0)
                {
                    s+=c.getNombre()+" "+obtenerTipo(c.getTipo());
                }else 
                {
                    s+=","+c.getNombre()+" "+obtenerTipo(c.getTipo());
                }
            }
            s+=")";
            try{
             smt.executeUpdate(s);
            }catch (SQLException se)
            {
                smt.executeUpdate("create table ClientesTmp (nombre VARCHAR_IGNORECASE(255),apellidos VARCHAR_IGNORECASE(255),sexo VARCHAR_IGNORECASE(255),direccion VARCHAR_IGNORECASE(255),cp VARCHAR_IGNORECASE(255),poblacion VARCHAR_IGNORECASE(255),provincia VARCHAR_IGNORECASE(255),telefono_fijo VARCHAR_IGNORECASE(255),telefono_movil VARCHAR_IGNORECASE(255),email VARCHAR_IGNORECASE(255),Fecha_Nacimiento date)");
                ResultSet rs=smt.executeQuery("Select * from Clientes");
                
                while(rs.next())
                {
                    String sql="insert into ClientesTmp (nombre,apellidos,sexo,direccion,cp,poblacion,provincia,telefono_fijo,telefono_movil,email,Fecha_Nacimiento) values ";
                
                    sql+="('"+rs.getString("nombre")+"','"+rs.getString("apellidos")+"','"+rs.getString("sexo")+"','"+rs.getString("direccion")+"',"+rs.getString("cp")+",'"+rs.getString("poblacion")+"','"+rs.getString("provincia")+"','"+rs.getString("telefono_fijo")+"','"+rs.getString("telefono_movil")+"','"+rs.getString("email")+"','"+rs.getString("Fecha_Nacimiento")+"')";
                    smt.executeUpdate(sql);
                }
                smt.executeUpdate("drop table Clientes");
                smt.executeUpdate(s);
                rs=smt.executeQuery("Select * from ClientesTmp");
                
                while(rs.next())
                {
                    String sql="insert into Clientes (nombre,apellidos,sexo,direccion,cp,poblacion,provincia,telefono_fijo,telefono_movil,email,Fecha_Nacimiento) values ";
                
                    sql+="('"+rs.getString("nombre")+"','"+rs.getString("apellidos")+"','"+rs.getString("sexo")+"','"+rs.getString("direccion")+"',"+rs.getString("cp")+",'"+rs.getString("poblacion")+"','"+rs.getString("provincia")+"','"+rs.getString("telefono_fijo")+"','"+rs.getString("telefono_movil")+"','"+rs.getString("email")+"','"+rs.getString("Fecha_Nacimiento")+"')";
                    smt.executeUpdate(sql);
                }
                smt.executeUpdate("drop table ClientesTmp");
            }
           
           
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    private  String ruta;
    private Connection con=null;
    private Statement smt=null;
 }