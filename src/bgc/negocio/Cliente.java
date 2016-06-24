package bgc.negocio;
/**
 * La clase Cliente gestiona los datos de los clientes
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
public class Cliente {
    
    /** Crea una nueva instancia de Cliente
     */
    public Cliente() {
    }
    
    /**
     * Crea una nueva instancia de Cliente con los atributos
     *nombre
     *apellido
     *sexo
     *direccion
     *CP
     *telefono
     *movil
     *email
     *ciudad
     *provincia
     *fecha nacimiento
     */
    public Cliente(String n,String a, String s, String d,String c,String ci,String p,String e,String t,String m,Fecha f ) {
        setNombre(n);
        setApellido(a);
        setSexo(s);
        setDireccion(d);
        setCP(c);
        setTelefono(t);
        setMovil(m);
        setEmail(e);
        setCiudad(ci);
        setProvincia(p);
        setFechaNac(f);
    }
    /**
     * Crea una nueva instancia de Cliente con los atributos
     *nombre
     *apellido
     *sexo
     *direccion
     *CP
     *telefono
     *movil
     *email
     *ciudad
     *provincia
     *opcional1
     *opcional2
     *opcional3
     *opcional4
     */
    public Cliente(String n,String a, String s, String d,String c,String ci,String p,String e,String t,String m,String op1,String op2,String op3,String op4) {
        setNombre(n);
        setApellido(a);
        setSexo(s);
        setDireccion(d);
        setCP(c);
        setTelefono(t);
        setMovil(m);
        setEmail(e);
        setCiudad(ci);
        setProvincia(p);
        setExtra1(op1);
        setExtra2(op2);
        setExtra3(op3);
        setExtra4(op4);
        
    }
    /**
     * Crea una nueva instancia de Cliente con los atributos
     *nombre
     *apellido
     *sexo
     *direccion
     *CP
     *telefono
     *movil
     *email
     *ciudad
     *provincia
     */
    public Cliente(String n,String a, String s, String d,String c,String ci,String p,String e,String t,String m) {
        setNombre(n);
        setApellido(a);
        setSexo(s);
        setDireccion(d);
        setCP(c);
        setTelefono(t);
        setMovil(m);
        setEmail(e);
        setCiudad(ci);
        setProvincia(p);
        
        
    }
    
    /**
     * Devuelve el nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Asigna el nombre del cliente con el valor que se le pasa a la función
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Devuelve el apellido del cliente
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * Asigna el apellido del cliente con el valor que se le pasa a la función
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * Devuelve el sexo del cliente
     */
    public String getSexo() {
        return sexo;
    }
    /**
     * Asigna el sexo del cliente con el valor que se le pasa a la función
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    /**
     * Devuelve la direccion del cliente
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Asigna la direccion del cliente con el valor que se le pasa a la función
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Devuelve el codigo postal del cliente
     */
    public String getCP() {
        return CP;
    }
    /**
     * Asigna el codigo postal del cliente con el valor que se le pasa a la función
     */
    public void setCP(String CP) {
        this.CP = CP;
    }
    /**
     * Devuelve el telefono del cliente
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * Asigna el telefono del cliente con el valor que se le pasa a la función
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * Devuelve el telefono movil del cliente
     */
    public String getMovil() {
        return movil;
    }
    /**
     * Asigna el telefono movil del cliente con el valor que se le pasa a la función
     */
    public void setMovil(String movil) {
        this.movil = movil;
    }
    /**
     * Devuelve la direccion de correo de electronico del cliente
     */
    public String getEmail() {
        return email;
    }
    /**
     * Asigna la dirección de correo electronico del cliente con el valor que se le pasa a la función
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Devuelve la ciudad del cliente
     */
    public String getCiudad() {
        return ciudad;
    }
    /**
     * Asigna la ciudad del cliente con el valor que se le pasa a la función
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    /**
     * Devuelve la provincia del cliente
     */
    public String getProvincia() {
        return provincia;
    }
    /**
     * Asigna la provincia del cliente con el valor que se le pasa a la función
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    /**
     * Devuelve la fecha de nacimiento del cliente
     */
    public Fecha getFechaNac() {
        return fechaNac;
    }
    /**
     * Asigna la fecha de nacimiento del cliente con el valor que se le pasa a la función
     */
    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }
    /**
     * Devuelve nombre, apellido, sexo, dirección, codigo postal, telefono, telefono movil y dirección de correo electrónico del cliente en modo texto
     */
    public String toString() {
        return ""+nombre+", "+apellido+" sexo: "+sexo+" direccion: "+direccion+ " CP: "+CP+" telefono: "+telefono+" movil: "+movil+" email: "+email;
    }
    /**
     * Devuelve el primer campo opcional del cliente
     */
    public String getExtra1() {
        return extra1;
    }
    /**
     * Asigna el primer campo opcional del cliente con el valor que se le pasa a la función
     */
    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }
    /**
     * Devuelve el segundo campo opcional del cliente
     */
    public String getExtra2() {
        return extra2;
    }
    /**
     * Asigna el segundo campo opcional del cliente con el valor que se le pasa a la función
     */
    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }
    /**
     * Devuelve el tercer campo opcional del cliente
     */
    public String getExtra3() {
        return extra3;
    }
    /**
     * Asigna el tercer campo opcional del cliente con el valor que se le pasa a la función
     */
    public void setExtra3(String extra3) {
        this.extra3 = extra3;
    }
    /**
     * Devuelve el cuarto campo opcional del cliente
     */
    public String getExtra4() {
        return extra4;
    }
    /**
     * Asigna el cuarto campo opcional del cliente con el valor que se le pasa a la función
     */
    public void setExtra4(String extra4) {
        this.extra4 = extra4;
    }
    /**
     *Indica el nombre del cliente
     */
    private String nombre;
    /**
     *Indica el apellido del cliente
     */
    private String apellido;
    /**
     *Indica el sexo del cliente
     */
    private String sexo;
    /**
     *Indica la direccion del cliente
     */
    private String direccion;
    /**
     *Indica el codigo postal del cliente
     */
    private String CP;
    /**
     *Indica el telefono del cliente
     */
    private String telefono;
    /**
     *Indica el telefono movil del cliente
     */
    private String movil;
    /**
     *Indica la dirección de correo electronico del cliente
     */
    private String email;
    /**
     *Indica la ciudad del cliente
     */
    private String ciudad;
    /**
     *Indica la provincia del cliente
     */
    private String provincia;
    /**
     *Indica la fecha de nacimiento del cliente
     */
    private Fecha fechaNac;
    /**
     * Indica el primer campo opcional del cliente
     */
    private String extra1;
    /**
     * Indica el segundo campo opcional del cliente
     */
    private String extra2;
    /**
     * Indica el tercer campo opcional del cliente
     */
    private String extra3;
    /**
     * Indica el cuarto campo opcional del cliente
     */
    private String extra4;
    /**
     *Indica el número de campos fijos que existen en la tabla clientes
     */
    public static int numCamposFijos=10;
    
}
