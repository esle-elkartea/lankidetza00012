package bgc.bd;

import bgc.negocio.Cliente;
import bgc.negocio.Fecha;
import bgc.negocio.Utilidades;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
/**
 * La clase GestorBD gestiona la base de datos
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
public class GestorBD {
    
    
    
    /** Crea una nueva instancia de GestorBD */
    public GestorBD() {
        try{
            Class.forName("org.hsqldb.jdbcDriver");//"org.hsqldb.jdbcDriver");
        }catch(ClassNotFoundException n) {
            System.out.println("ERROR CARGAR DRIVER");
        }
    }
    
    /**Abre la base de datos*/
    public void abrirBD() {
        try{
            con =DriverManager.getConnection("jdbc:hsqldb:C:\\Archivos de programa\\Campus-Telematika\\Hermes\\bd\\hermes.odb");
          //  con =DriverManager.getConnection("jdbc:hsqldb:"+"C:\\Archivos de Programa\\Hermes\\"+"BD");
            smt=con.createStatement();
            
            
        }catch(SQLException e) {
            System.out.println("ERROR SQL: "+ e.getMessage());
        }
        
    }
    /**Cierra la base de datos*/
    public void cerrarBD() {
        try{
            
            smt.close();
            con.close();
        }catch(SQLException e) {
            System.out.println("ERROR SQL: "+ e.getMessage());
        }
    }
    /**Añade un cliente a la base de datos*/
    public void anyadir(Cliente c) {
        try{
            String s="insert into Clientes values('"+c.getNombre()+"','"+c.getApellido()+"','"+c.getSexo()+"','"+c.getDireccion()+"',"+c.getCP()+",'"+c.getCiudad()+"','"+c.getProvincia()+"','"+c.getEmail()+"','"+c.getTelefono()+"','"+c.getMovil()+"', '"+Fecha.aFormatoBD(c.getFechaNac().toString())+"'";
            Vector v=obtenerCampos();
            if (v.size()>Cliente.numCamposFijos+1) {
                if ( obtenerTipo(((String)v.get(Cliente.numCamposFijos+1))).equals("Texto") )
                    s+=",'"+c.getExtra1()+"'";
                else if ( obtenerTipo(((String)v.get(Cliente.numCamposFijos+1))).equals("Fecha") )
                    s+=",'"+Fecha.aFormatoBD(c.getExtra1())+"'";
                else if ( obtenerTipo(((String)v.get(Cliente.numCamposFijos+1))).equals("Si/No") )
                    s+=","+Utilidades.siNoABD(c.getExtra1());
                else s+=",0"+c.getExtra1()+"";
                if (v.size()>(Cliente.numCamposFijos+2)) {
                    if ( obtenerTipo(((String)v.get(Cliente.numCamposFijos+2))).equals("Texto")  )
                        s+=",'"+c.getExtra2()+"'";
                    else if ( obtenerTipo(((String)v.get(Cliente.numCamposFijos+2))).equals("Fecha"))
                        s+=",'"+Fecha.aFormatoBD(c.getExtra2())+"'";
                    else if ( obtenerTipo(((String)v.get(Cliente.numCamposFijos+2))).equals("Si/No") )
                        s+=","+Utilidades.siNoABD(c.getExtra2());
                    else s+=",0"+c.getExtra2()+"";
                    if (v.size()>(Cliente.numCamposFijos+3)) {
                        if ( obtenerTipo(((String)v.get(Cliente.numCamposFijos+3))).equals("Texto") )
                            s+=",'"+c.getExtra3()+"'";
                        else if (obtenerTipo(((String)v.get(Cliente.numCamposFijos+3))).equals("Fecha")  )
                            s+=",'"+Fecha.aFormatoBD(c.getExtra3())+"'";
                        else if ( obtenerTipo(((String)v.get(Cliente.numCamposFijos+3))).equals("Si/No") )
                            s+=","+Utilidades.siNoABD(c.getExtra3());
                        else s+=",0"+c.getExtra3()+"";
                        if (v.size()>(Cliente.numCamposFijos+4)) {
                            if ( obtenerTipo(((String)v.get(Cliente.numCamposFijos+4))).equals("Texto")    )
                                s+=",'"+c.getExtra4()+"'";
                            else if(obtenerTipo(((String)v.get(Cliente.numCamposFijos+4))).equals("Fecha"))
                                s+=",'"+Fecha.aFormatoBD(c.getExtra4())+"'";
                            else if ( obtenerTipo(((String)v.get(Cliente.numCamposFijos+4))).equals("Si/No") )
                                s+=","+Utilidades.siNoABD(c.getExtra4());
                            else s+=",0"+c.getExtra4()+"";
                        }
                    }
                }
            }
            s+=")";
            smt.executeUpdate(s);
           
        }catch(SQLException e) {
            System.out.println("ERROR SQL: "+ e.getMessage());
        }
    }
    /**Indica si un poryecto automatico pasado a la función existe o no*/
    public boolean existeProyectoAuto(String str) {
        
        ResultSet rs=null;
        Vector v=null;
        try{
            rs=smt.executeQuery("Select * from ProyectosA where nombre='"+str+"'");
            if(rs.next())
                return true;
            return false;
        } catch (SQLException ex) {
            System.out.println("ERROR SQL: "+ ex.getMessage());
        }
        return false;
    }
    /**Añade un proyecto automatico a la base de datos*/    
    public void insertarProyectoAuto(String str) {
        try {
            
            if(!existeProyectoAuto(str)) {
                smt.executeUpdate("insert into ProyectosA values ('"+str+"')");
            }
            
        } catch (SQLException ex) {
            System.out.println("ERROR SQL: "+ ex.getMessage());
        }
    }
    /**Devuelve un Vector con todos los proyectos automatizaso existentes en la base de datos*/    
    public Vector obtenerProyectosAutomatizados() {
        ResultSet rs=null;
        Vector v=null;
        try{
            rs=smt.executeQuery("Select count (*) from ProyectosA");
            rs.next();
            int cont=rs.getInt(1);
            v=new Vector(cont);
            
            rs =smt.executeQuery("Select * from ProyectosA");
            while (rs.next()) {
                v.add(rs.getString("nombre"));
                
            }
            rs.close();
            return v;
        }catch(SQLException e) {
            System.out.println("ERROR SQL: "+ e.getMessage());
        }
        return v;
    }
    /**Elimina de la base de datos el proyecto automatizado pasado a la funcion*/
    public String eliminarProyAuto(String n) {
        try {
            
            ResultSet rs=smt.executeQuery("Select * from ProyectosA where nombre='"+n+"'");
            if(rs.next()) {
                String ruta=rs.getString("nombre");
                smt.executeUpdate("delete from ProyectosA where nombre='"+n+"'");
                System.out.println("Proyecto Eliminado");
                return ruta;
            }
        } catch (SQLException ex) {
            System.out.println("ERROR SQL: "+ ex.getMessage());
        }
        return "";
    }
    /**Obtiene un listado con los mails y fechas de nacimiento de todos los clientes existentes
     en la base de datos*/
    public Vector obtenerListadoEmailFecha() {
        ResultSet rs=null;
        Vector v=null;
        try{
            rs=smt.executeQuery("Select count (*) from Clientes");
            rs.next();
            int cont=rs.getInt(1);
            v=new Vector(cont);
            
            rs =smt.executeQuery("Select * from Clientes order by fechaNac");
            while (rs.next()) {
                v.add(rs.getString("email")+";"+rs.getString("fechaNac"));
                
            }
            rs.close();
            return v;
        }catch(SQLException e) {
            System.out.println("ERROR SQL: "+ e.getMessage());
        }
        return v;
    }
    /**Devuelve un Vector con todos los clientes existentes en la base de datos
     ordenados por apellidos*/
    
    public Vector obtenerListado() {
        ResultSet rs=null;
        Vector v=null;
        try{
            rs=smt.executeQuery("Select count (*) from Clientes");
            rs.next();
            int cont=rs.getInt(1);
            v=new Vector(cont);
            Vector vc=obtenerCampos();
            rs =smt.executeQuery("Select * from Clientes order by apellidos");
            while (rs.next()) {
                Cliente c=new Cliente(rs.getString("nombre"),rs.getString("apellidos"),rs.getString("sexo"),rs.getString("direccion"),rs.getString("cp"),rs.getString("poblacion"),rs.getString("provincia"),rs.getString("email"),rs.getString("telefono_fijo"),rs.getString("telefono_movil"));
                c.setFechaNac(Fecha.parseBD(rs.getString("Fecha_Nacimiento")));
                if (vc.size()>Cliente.numCamposFijos+1) {
                    if (obtenerTipo((String)vc.get( Cliente.numCamposFijos+1 )).equals("Texto")) {
                        c.setExtra1(rs.getString((String)vc.get(Cliente.numCamposFijos+1)) );
                    }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Numero")) {
                        c.setExtra1(""+rs.getInt((String)vc.get(Cliente.numCamposFijos+1)) );
                    }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Si/No")) {
                        c.setExtra1(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get(Cliente.numCamposFijos+1))));
                    }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Fecha")) {
                        c.setExtra1(Fecha.aFormatoLocal(rs.getString((String)vc.get(Cliente.numCamposFijos)) ));
                    }
                    if (vc.size()>(Cliente.numCamposFijos+2)) {
                        if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+2)).equals("Texto")) {
                            c.setExtra2(rs.getString((String)vc.get(Cliente.numCamposFijos+2)) );
                        }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+2)).equals("Numero")) {
                            c.setExtra2(""+rs.getInt((String)vc.get(Cliente.numCamposFijos+2)) );
                        }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+2)).equals("Si/No")) {
                            c.setExtra2(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get(Cliente.numCamposFijos+2)) ));
                        }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+2)).equals("Fecha")) {
                            c.setExtra2(Fecha.aFormatoLocal(rs.getString((String)vc.get(Cliente.numCamposFijos+2))) );
                        }
                        
                        if (vc.size()>(Cliente.numCamposFijos+3)) {
                            if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+3)).equals("Texto")) {
                                c.setExtra3(rs.getString((String)vc.get(Cliente.numCamposFijos+3)) );
                            }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+3)).equals("Numero")) {
                                c.setExtra3(""+rs.getInt((String)vc.get(Cliente.numCamposFijos+3)) );
                            }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+3)).equals("Si/No")) {
                                c.setExtra3(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get(Cliente.numCamposFijos+3))) );
                            }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+3)).equals("Fecha")) {
                                c.setExtra3(Fecha.aFormatoLocal(rs.getString((String)vc.get(Cliente.numCamposFijos+3))) );
                            }
                            
                            if (vc.size()>(Cliente.numCamposFijos+4)) {
                                if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+4)).equals("Texto")) {
                                    c.setExtra4(rs.getString((String)vc.get(Cliente.numCamposFijos+4)) );
                                }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+4)).equals("Numero")) {
                                    c.setExtra4(""+rs.getInt((String)vc.get(Cliente.numCamposFijos+4)) );
                                }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+4)).equals("Si/No")) {
                                    c.setExtra4(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get(Cliente.numCamposFijos+4))) );
                                }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+4)).equals("Fecha")) {
                                    c.setExtra4(Fecha.aFormatoLocal(rs.getString((String)vc.get(Cliente.numCamposFijos+4))) );
                                }
                            }
                        }
                    }
                }
            
                v.add(c);
            }
            rs.close();
            return v;
        }catch(SQLException e) {
            System.out.println("ERROR SQL: "+ e.getMessage());
        }
        return v;
    }
    /**Devuelve un Vector con el resultado de la consulta sql que se le pasa a la función*/
    public Vector obtenerListadoAbrir(String sqlAbrir) {
        ResultSet rs=null;
        Vector v=null;
        try{
            rs=smt.executeQuery("Select count (*) from Clientes");
            rs.next();
            int cont=rs.getInt(1);
            v=new Vector(cont);
            Vector vc=obtenerCampos();
            
            rs =smt.executeQuery(sqlAbrir);
            while (rs.next()) {
                Cliente c=new Cliente(rs.getString("nombre"),rs.getString("apellidos"),rs.getString("sexo"),rs.getString("direccion"),rs.getString("cp"),rs.getString("poblacion"),rs.getString("provincia"),rs.getString("email"),rs.getString("telefono_fijo"),rs.getString("telefono_movil"));
                c.setFechaNac(Fecha.parseBD(rs.getString("Fecha_Nacimiento")));
                if (vc.size()>Cliente.numCamposFijos+1) {
                    if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Texto")) {
                        c.setExtra1(rs.getString((String)vc.get(Cliente.numCamposFijos+1)) );
                    }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Numero")) {
                        c.setExtra1(""+rs.getInt((String)vc.get(Cliente.numCamposFijos+1)) );
                    }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Si/No")) {
                        c.setExtra1(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get(Cliente.numCamposFijos+1))) );
                    }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Fecha")) {
                        c.setExtra1(Fecha.aFormatoLocal(rs.getString((String)vc.get(Cliente.numCamposFijos+1)) ));
                    }
                    if (vc.size()>(Cliente.numCamposFijos+2)) {
                        if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+2)).equals("Texto")) {
                            c.setExtra2(rs.getString((String)vc.get(Cliente.numCamposFijos+2)) );
                        }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+2)).equals("Numero")) {
                            c.setExtra2(""+rs.getInt((String)vc.get(Cliente.numCamposFijos+2)) );
                        }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+2)).equals("Si/No")) {
                            c.setExtra2(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get(Cliente.numCamposFijos+2))) );
                        }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+2)).equals("Fecha")) {
                            c.setExtra2(Fecha.aFormatoLocal(rs.getString((String)vc.get(Cliente.numCamposFijos+2))) );
                        }
                        
                        if (vc.size()>(Cliente.numCamposFijos+3)) {
                            if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+3)).equals("Texto")) {
                                c.setExtra3(rs.getString((String)vc.get(Cliente.numCamposFijos+3)) );
                            }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+3)).equals("Numero")) {
                                c.setExtra3(""+rs.getInt((String)vc.get(Cliente.numCamposFijos+3)) );
                            }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+3)).equals("Si/No")) {
                                c.setExtra3(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get(Cliente.numCamposFijos+3))) );
                            }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+3)).equals("Fecha")) {
                                c.setExtra3(Fecha.aFormatoLocal(rs.getString((String)vc.get(Cliente.numCamposFijos+3))) );
                            }
                            
                            if (vc.size()>(Cliente.numCamposFijos+4)) {
                                if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+4)).equals("Texto")) {
                                    c.setExtra4(rs.getString((String)vc.get(Cliente.numCamposFijos+4)) );
                                }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+4)).equals("Numero")) {
                                    c.setExtra4(""+rs.getInt((String)vc.get(Cliente.numCamposFijos+4)) );
                                }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+4)).equals("Si/No")) {
                                    c.setExtra4(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get(Cliente.numCamposFijos+4))) );
                                }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+4)).equals("Fecha")) {
                                    c.setExtra4(Fecha.aFormatoLocal(rs.getString((String)vc.get(Cliente.numCamposFijos+4))) );
                                }
                            }
                        }
                    }
                }
                
                v.add(c);
            }
            rs.close();
            
            
        }catch(SQLException e) {
            System.out.println("ERROR SQL: "+ e.getMessage());
        }
        return v;
    }
 /**Elimina un cliente de la base de datos*/
    public void darDeBaja(String n) {
        try {
            smt.executeUpdate("delete from Clientes where nombre='"+n+"'");
        
        } catch (SQLException ex) {
            System.out.println("ERROR SQL: "+ ex.getMessage());
        }
        
    }
    /**Modifica los datos de un cliente de la base de datos*/
    public void modificar(Cliente c,Cliente cv) {
        try {
          
            
            String s1="update Clientes set nombre='"+c.getNombre()+"', apellidos='"+c.getApellido()+"', sexo='"+c.getSexo()+"',direccion='"+c.getDireccion()+"',cp='"+c.getCP()+"',telefono_fijo='"+c.getTelefono()+"',telefono_movil='"+c.getMovil()+"',email='"+c.getEmail()+"',fecha_nacimiento='"+Fecha.aFormatoBD(c.getFechaNac().toString())+"'";
            String s2="where nombre='"+cv.getNombre()+"' and apellidos='"+cv.getApellido()+"' and sexo='"+cv.getSexo()+"' and direccion='"+cv.getDireccion()+"' and cp='"+cv.getCP()+"' and telefono_fijo='"+cv.getTelefono()+"' and telefono_movil='"+cv.getMovil()+"' and email='"+cv.getEmail()+"',fecha_nacimiento='"+Fecha.aFormatoBD(c.getFechaNac().toString())+"'";
            Vector v1=obtenerCampos();
            
            if (v1.size()>Cliente.numCamposFijos+1) {
                if ( obtenerTipo(((String)v1.get(Cliente.numCamposFijos+1))).equals("Texto")) {
                    s1+=","+((String)v1.get(Cliente.numCamposFijos+1))+"='"+c.getExtra1()+"'";
                    s2+=" and "+((String)v1.get(Cliente.numCamposFijos+1))+"='"+cv.getExtra1()+"'";
                    
                }else
                    if ( obtenerTipo(((String)v1.get(Cliente.numCamposFijos+1))).equals("Fecha")) {
                    s1+=","+((String)v1.get(Cliente.numCamposFijos+1))+"='"+Fecha.aFormatoBD(c.getExtra1())+"'";
                    s2+=" and "+((String)v1.get(Cliente.numCamposFijos+1))+"='"+Fecha.aFormatoBD(cv.getExtra1())+"'";
                    } else
                        if  ( obtenerTipo(((String)v1.get(Cliente.numCamposFijos+1))).equals("Si/No")) {
                    s1+=","+((String)v1.get(Cliente.numCamposFijos+1))+"='"+Utilidades.siNoABD(c.getExtra1())+"'";
                    s2+=" and "+((String)v1.get(Cliente.numCamposFijos+1))+"='"+Utilidades.siNoABD(cv.getExtra1())+"'";
                        } else {
                    s1+=","+((String)v1.get(Cliente.numCamposFijos+1))+"=0"+c.getExtra1()+"";
                    s2+=" and "+((String)v1.get(Cliente.numCamposFijos+1))+"="+cv.getExtra1()+"";
                        }
                if (v1.size()>(Cliente.numCamposFijos+2)) {
                    if ( obtenerTipo(((String)v1.get(Cliente.numCamposFijos+2))).equals("Texto")|| obtenerTipo(((String)v1.get(Cliente.numCamposFijos+2))).equals("Fecha")) {
                        s1+=","+((String)v1.get(Cliente.numCamposFijos+2))+"='"+c.getExtra2()+"'";
                        s2+=" and "+((String)v1.get(Cliente.numCamposFijos+2))+"='"+cv.getExtra2()+"'";
                    }else
                        if  ( obtenerTipo(((String)v1.get(Cliente.numCamposFijos+2))).equals("Si/No")) {
                        s1+=","+((String)v1.get(Cliente.numCamposFijos+2))+"='"+Utilidades.siNoABD(c.getExtra2())+"'";
                        s2+=" and "+((String)v1.get(Cliente.numCamposFijos+2))+"='"+Utilidades.siNoABD(cv.getExtra2())+"'";
                        } else{
                        s1+=","+((String)v1.get(Cliente.numCamposFijos+2))+"=0"+c.getExtra2()+"";
                        s2+=" and "+((String)v1.get(Cliente.numCamposFijos+2))+"="+cv.getExtra2()+"";
                        }
                    if (v1.size()>(Cliente.numCamposFijos+3)) {
                        if ( obtenerTipo(((String)v1.get((Cliente.numCamposFijos+3)))).equals("Texto")|| obtenerTipo(((String)v1.get((Cliente.numCamposFijos+3)))).equals("Fecha")) {
                            s1+=","+((String)v1.get((Cliente.numCamposFijos+3)))+"='"+c.getExtra3()+"'";
                            s2+=" and "+((String)v1.get((Cliente.numCamposFijos+3)))+"='"+cv.getExtra3()+"'";
                        }else
                            if  ( obtenerTipo(((String)v1.get(Cliente.numCamposFijos+3))).equals("Si/No")) {
                            s1+=","+((String)v1.get(Cliente.numCamposFijos+3))+"='"+Utilidades.siNoABD(c.getExtra3())+"'";
                            s2+=" and "+((String)v1.get(Cliente.numCamposFijos+3))+"='"+Utilidades.siNoABD(cv.getExtra3())+"'";
                            } else{
                            s1+=","+((String)v1.get((Cliente.numCamposFijos+3)))+"=0"+c.getExtra3()+"";
                            s2+=" and "+((String)v1.get((Cliente.numCamposFijos+3)))+"="+cv.getExtra3()+"";
                            }
                        if (v1.size()>(Cliente.numCamposFijos+4)) {
                            if ( obtenerTipo(((String)v1.get((Cliente.numCamposFijos+4)))).equals("Texto")|| obtenerTipo(((String)v1.get((Cliente.numCamposFijos+4)))).equals("Fecha")) {
                                s1+=","+((String)v1.get((Cliente.numCamposFijos+4)))+"='"+c.getExtra4()+"'";
                                s2+=" and "+((String)v1.get((Cliente.numCamposFijos+4)))+"='"+cv.getExtra4()+"'";
                            }else
                                if  ( obtenerTipo(((String)v1.get(Cliente.numCamposFijos+1))).equals("Si/No")) {
                                s1+=","+((String)v1.get(Cliente.numCamposFijos+4))+"='"+Utilidades.siNoABD(c.getExtra4())+"'";
                                s2+=" and "+((String)v1.get(Cliente.numCamposFijos+4))+"='"+Utilidades.siNoABD(cv.getExtra4())+"'";
                                } else{
                                s1+=","+((String)v1.get((Cliente.numCamposFijos+4)))+"=0"+c.getExtra4()+"";
                                s2+=" and "+((String)v1.get((Cliente.numCamposFijos+4)))+"="+cv.getExtra4()+"";
                                }
                        }
                        
                    }
                }
            }
         
           smt.executeUpdate(s1+' '+s2);
            
        } catch (SQLException ex) {
            System.out.println("ERROR SQL: "+ ex.getMessage());
        }
        
    }
    /**Devuelve un vector con los clientes existentes en la base de datos que cumplan 
     el criterio indicado en el parametro que se le pasa a la función*/
    public Vector buscar(String n) {
        ResultSet rs=null;
        Vector v=null;
        String sql="";
        try{
       
            v=new Vector(16);
       
            sql="Select * from Clientes where "+n+"";
        
            rs =smt.executeQuery(sql);
            while (rs.next()) {
                Cliente c=new Cliente(rs.getString("nombre"),rs.getString("apellidos"),rs.getString("sexo"),rs.getString("direccion"),rs.getString("cp"),rs.getString("poblacion"),rs.getString("provincia"),rs.getString("email"),rs.getString("telefono_fijo"),rs.getString("telefono_movil"));
                c.setFechaNac(Fecha.parseBD(rs.getString("Fecha_Nacimiento")));
                Vector vc=obtenerCampos();
                
                if (vc.size()>Cliente.numCamposFijos+1) {
                    if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Texto")) {
                        c.setExtra1(rs.getString((String)vc.get(Cliente.numCamposFijos+1)) );
                    }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Numero")) {
                        c.setExtra1(""+rs.getInt((String)vc.get(Cliente.numCamposFijos+1)) );
                    }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Si/No")) {
                        c.setExtra1(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get(Cliente.numCamposFijos+1))) );
                    }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Fecha")) {
                        c.setExtra1(Fecha.aFormatoLocal(rs.getString((String)vc.get(Cliente.numCamposFijos+1)) ));
                    }
                    if (vc.size()>(Cliente.numCamposFijos+2)) {
                        if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+2))).equals("Texto")) {
                            c.setExtra2(rs.getString((String)vc.get((Cliente.numCamposFijos+2))) );
                        }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+2))).equals("Numero")) {
                            c.setExtra2(""+rs.getInt((String)vc.get((Cliente.numCamposFijos+2))) );
                        }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+2))).equals("Si/No")) {
                            c.setExtra2(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get((Cliente.numCamposFijos+2))) ));
                        }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+2))).equals("Fecha")) {
                            c.setExtra2(Fecha.aFormatoLocal(rs.getString((String)vc.get((Cliente.numCamposFijos+2)))) );
                        }
                        
                        if (vc.size()>(Cliente.numCamposFijos+3)) {
                            if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+3))).equals("Texto")) {
                                c.setExtra3(rs.getString((String)vc.get((Cliente.numCamposFijos+3))) );
                            }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+3))).equals("Numero")) {
                                c.setExtra3(""+rs.getInt((String)vc.get((Cliente.numCamposFijos+3))) );
                            }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+3))).equals("Si/No")) {
                                c.setExtra3(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get((Cliente.numCamposFijos+3)))) );
                            }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+3))).equals("Fecha")) {
                                c.setExtra3(Fecha.aFormatoLocal(rs.getString((String)vc.get((Cliente.numCamposFijos+3)))) );
                            }
                            
                            if (vc.size()>(Cliente.numCamposFijos+4)) {
                                if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+4))).equals("Texto")) {
                                    c.setExtra4(rs.getString((String)vc.get((Cliente.numCamposFijos+4))) );
                                }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+4))).equals("Numero")) {
                                    c.setExtra4(""+rs.getInt((String)vc.get((Cliente.numCamposFijos+4))) );
                                }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+4))).equals("Si/No")) {
                                    c.setExtra4(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get((Cliente.numCamposFijos+4)))) );
                                }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+4))).equals("Fecha")) {
                                    c.setExtra4(Fecha.aFormatoLocal(rs.getString((String)vc.get((Cliente.numCamposFijos+4)))) );
                                }
                            }
                        }
                    }
                }
                v.add(c);
            }
            rs.close();
            v.add(sql);
            return v;
        }catch(SQLException e) {
            System.out.println("ERROR SQL: "+ e.getMessage());
        }
        return v;
    }
    
     /**Devuelve un vector con los clientes existentes en la base de datos que cumplan 
     el criterio indicado en el parametro n que se le pasa a la función para la columna
      que se le pasa a la función*/
    public Vector buscar(String n,String columna) {
        ResultSet rs=null;
        Vector v=null;
        String sql="";
        try{
      
            v=new Vector(10);
       
            sql="Select * from Clientes where "+columna+" LIKE ('"+n+"%')";
            rs =smt.executeQuery(sql);
            while (rs.next()) {
                Cliente c=new Cliente(rs.getString("nombre"),rs.getString("apellidos"),rs.getString("sexo"),rs.getString("direccion"),rs.getString("cp"),rs.getString("poblacion"),rs.getString("provincia"),rs.getString("email"),rs.getString("telefono_fijo"),rs.getString("telefono_movil"));
                c.setFechaNac(Fecha.parseBD(rs.getString("Fecha_Nacimiento")));
                Vector vc=obtenerCampos();
                
                if (vc.size()>Cliente.numCamposFijos+1) {
                    if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Texto")) {
                        c.setExtra1(rs.getString((String)vc.get(Cliente.numCamposFijos+1)) );
                    }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Numero")) {
                        c.setExtra1(""+rs.getInt((String)vc.get(Cliente.numCamposFijos+1)) );
                    }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Si/No")) {
                        c.setExtra1(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get(Cliente.numCamposFijos+1))) );
                    }else  if (obtenerTipo((String)vc.get(Cliente.numCamposFijos+1)).equals("Fecha")) {
                        c.setExtra1(Fecha.aFormatoLocal(rs.getString((String)vc.get(Cliente.numCamposFijos+1)) ));
                    }
                    if (vc.size()>(Cliente.numCamposFijos+2)) {
                        if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+2))).equals("Texto")) {
                            c.setExtra2(rs.getString((String)vc.get((Cliente.numCamposFijos+2))) );
                        }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+2))).equals("Numero")) {
                            c.setExtra2(""+rs.getInt((String)vc.get((Cliente.numCamposFijos+2))) );
                        }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+2))).equals("Si/No")) {
                            c.setExtra2(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get((Cliente.numCamposFijos+2)))) );
                        }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+2))).equals("Fecha")) {
                            c.setExtra2(Fecha.aFormatoLocal(rs.getString((String)vc.get((Cliente.numCamposFijos+2)))) );
                        }
                        
                        if (vc.size()>(Cliente.numCamposFijos+3)) {
                            if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+3))).equals("Texto")) {
                                c.setExtra3(rs.getString((String)vc.get((Cliente.numCamposFijos+3))) );
                            }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+3))).equals("Numero")) {
                                c.setExtra3(""+rs.getInt((String)vc.get((Cliente.numCamposFijos+3))) );
                            }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+3))).equals("Si/No")) {
                                c.setExtra3(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get((Cliente.numCamposFijos+3)))) );
                            }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+3))).equals("Fecha")) {
                                c.setExtra3(Fecha.aFormatoLocal(rs.getString((String)vc.get((Cliente.numCamposFijos+3)))) );
                            }
                            
                            if (vc.size()>(Cliente.numCamposFijos+4)) {
                                if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+4))).equals("Texto")) {
                                    c.setExtra4(rs.getString((String)vc.get((Cliente.numCamposFijos+4))) );
                                }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+4))).equals("Numero")) {
                                    c.setExtra4(""+rs.getInt((String)vc.get((Cliente.numCamposFijos+4))) );
                                }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+4))).equals("Si/No")) {
                                    c.setExtra4(Utilidades.siNoAPantallado(""+rs.getBoolean((String)vc.get((Cliente.numCamposFijos+4)))) );
                                }else  if (obtenerTipo((String)vc.get((Cliente.numCamposFijos+4))).equals("Fecha")) {
                                    c.setExtra4(Fecha.aFormatoLocal(rs.getString((String)vc.get((Cliente.numCamposFijos+4)))) );
                                }
                            }
                        }
                    }
                }
                v.add(c);
            }
            rs.close();
            
            return v;
        }catch(SQLException e) {
            System.out.println("ERROR SQL: "+ e.getMessage());
        }
        return v;
    }
    /**Devuelve un vector con todos los campos de la base de datos*/
    public Vector obtenerCampos() {
        ResultSet rs=null;
        Vector v=null;
        try{
            v=new Vector(14);
            String sql = "Select * from Campos";
            rs =smt.executeQuery(sql);
            while (rs.next()) {
                v.add(rs.getString("columna"));
            }
            rs.close();
            return v;
        }catch(SQLException e) {
            System.out.println("ERROR SQL: "+ e.getMessage());
        }
        return v;
    }
    /**Devuelve el tipo de dato de la columna especificada de la base de datos*/
    public String obtenerTipo(String nomColumna) {
        ResultSet rs=null;
        String v="";
        try{
            
            String sql = "Select * from Campos where columna = '"+nomColumna+"'";
            rs =smt.executeQuery(sql);
            while (rs.next()) {
                v = rs.getString("tipo");
            }
            rs.close();
            return v;
        }catch(SQLException e) {
            System.out.println("ERROR SQL: "+ e.getMessage());
        }
        return v;
    }
    /**Conexión con la base de datos*/    
    private Connection con=null;
    /**Ejecuta la consulta sql y devuelve el resultado.*/
    private Statement smt=null;
}
