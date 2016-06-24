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

package bgc.negocio.correo;
import bgc.negocio.*;
import com.ericdaugherty.mail.server.errors.InvalidAddressException;
import com.ericdaugherty.mail.server.errors.NotFoundException;
import com.ericdaugherty.mail.server.info.EmailAddress;
import com.ericdaugherty.mail.server.services.smtp.SMTPMessage;
import com.ericdaugherty.mail.server.services.smtp.SMTPRemoteSender;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Clase que se encarga de enviar el email
 * @author Campus-Telematika S.L.
 */
public class ClienteCorreo {
    
    
    /**
     * Numero de envio que es esta realizando
     */
    public static int numenvio=0;
    /**
     * Nombre del proyecto al que corresponde el email
     */
    private String nombreProyecto;
    /**
     * Datos del comercio
     */
    private DatosNegocio datos;
    /**
     * Creates a new instance of ClienteCorreo
     * @param nombre Nombre del proyecto
     */
    public ClienteCorreo(String nombre) {
        nombreProyecto=nombre;
        datos=new DatosNegocio();
        try {
            datos.leerDatos();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    
    /**
     * Traduce el error para mostrar en pantalla
     * @param error Mensaje del error a traducir
     * @return Un mensaje con el error que ha ocurrido
     */
    public String traducirError(String error ) {
        String s="Error envio: ";
        
        if ( error.indexOf("554")>=0) {
            int pos1=error.indexOf("<")+1;
            int pos2=error.indexOf(">");
            s=s+"Direccion Invalida "+error.substring(pos1,pos2);
        }
        else if (error.indexOf("Error talking to remote Server")>=0)
        {
            s+="Error al conectarse con un servidor de correo remoto";
        }
        return s;
    }
    
    
    
    /**
     * Lee el html que queremos mandar
     * @param s Ruta del fichero HTML
     * @return Un string con el html
     */
    String leerHTML(String s) {
        File fichero = new File(s);
        String str, str1="";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            while ((str = br.readLine()) != null) {
                str1+=str;
                
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        return str1;
    }
    
    
    /**
     * Inserta el nombre y el apellido del cliente en el HTML
     * @param html Donde queremos modificar
     * @param cli Cliente que vamso ha insertar
     * @return El HTML modificado
     */
    public String insertarVariable(String html,Cliente cli) {
        html=html.replaceAll("<var nombre>",cli.getNombre());
        html=html.replaceAll("<var apellido>",cli.getApellido());
        html=html.replaceAll("&lt;var nombre&gt;",cli.getNombre());
        html=html.replaceAll("&lt;var apellido&gt;",cli.getApellido());
        
        return html;
    }
    
    
    /**
     * Codifica el HTML para traducir las imagenes a formato de un email multipart, 
     * cambiando la ruta de las imagenes por la ruta al Multipart (cid:imagenX)
     * @param html Html a modificar
     * @param cli Cliente a insertar
     * @return el HTML modificado
     */
    public  Multipart codificarAMime(String html,Cliente cli) {
        
        
        
        Multipart mp=new MimeMultipart();
        String htmlMime="";
        int cont=0;
        System.out.println("HTML ORIGINAL: "+html);
        
        for(int i=0;i<html.length();i++) {
            if(html.substring(i).startsWith("<img")) {
                cont++;
            }
        }
        
        int vp=0;
        int posicionCopia=0;
        while(vp<=cont) {
            int posImg=html.indexOf("<img");
            int posFinImg=html.indexOf(">",posImg+1);
            if (posImg<0) {
                posImg=html.length();
                
                htmlMime+=(html.substring(posicionCopia,posImg));
                vp++;
            } else{
                htmlMime+=(html.substring(posicionCopia,posImg));
                
                String imagen=html.substring(posImg,posFinImg);
                int pi,pf;
                pi=imagen.indexOf('"');
                pf=imagen.indexOf('"',pi+1);
                imagen=imagen.substring(pi+1,pf);
                
                //Prueba
//        imagen="/home/aitor/Desktop/Proyecto Hermes/Hermes/ImagenesIÃ±aki/html/"+imagen;
                //Prueba
                vp++;
                MimeBodyPart mpi=new MimeBodyPart();
                html=html.substring(posFinImg+1);
                try {
                    
                    System.out.println("image"+vp+"  "+imagen);
                    mpi = new MimeBodyPart();
                    DataSource fds = new FileDataSource
                            (imagen);
                    mpi.setDataHandler(new DataHandler(fds));
                    mpi.setHeader("Content-ID","<image"+vp+">");
                    htmlMime+=("<img src=\"cid:image"+vp+"\">");
                    posicionCopia=0;
                    mp.addBodyPart(mpi);
                    
                } catch (MessagingException ex) {
                    ex.printStackTrace();
                }
            }
        }
        htmlMime=insertarVariable(htmlMime,cli);
        
        MimeBodyPart mpi=new MimeBodyPart();
        try {
            mpi.setContent(htmlMime,"text/html");
            mp.addBodyPart(mpi,0);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        System.out.println("HTML: "+htmlMime);
        return mp;
    }
    
    
    
    
    /**
     * Manda el email al cliente
     * @param cli Cliente a mandar el email
     * @param html Html a mandar
     * @param titulo Asunto del mensaje
     * @param num Numero de envio de este mailing
     * @return Resultado del envio
     */
    public ResultadoEnvio mandarJavaMail(Cliente cli, String html,String titulo,int num) {
        System.out.println("Sending mail...");
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "correo.campus-telematika.com");
        props.setProperty("mail.user", "iparrado");
        props.setProperty("mail.password", "IparradO");
        props.setProperty("mail.smtp.auth", "true");
        //Authenticator aut =new HermesAuthenticator();
        Session mailSession = Session.getDefaultInstance(props, null);
        mailSession.setDebug(true);
        String resultado="Ok";
        Transport transport=null;
        try {
            transport = mailSession.getTransport();
        } catch (NoSuchProviderException ex) {
            ex.printStackTrace();
            
            resultado=traducirError(ex.getMessage());
        }
        
        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setSubject(titulo);
            message.setFrom(new InternetAddress(datos.getEmail()));
            message.setContentID(message.getContentID());
            
            
            message.setContent(codificarAMime(leerHTML(html),cli));
            
            InternetAddress direccion=new InternetAddress(cli.getEmail());
            
            direccion.validate();
            
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(cli.getEmail()));
            
            //  transport.connect();
            message.saveChanges(); // implicit with send()
//            transport = mailSession.getTransport("smtp");
//            //transport.connect("correo.campus-telematika.com", "aarino", "");
//            transport.connect("correo.campus-telematika.com", "iparrado", "IparradO");
//
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
            
            DataInputStream salida=new DataInputStream(message.getInputStream());
            StringBuffer sb=new StringBuffer();
            String linea="";
            while((linea=salida.readLine())!=null)
                sb.append(linea+"\n");
            String txt=sb.toString();
            
            String ct=message.getContentType();
            String subject=message.getSubject();
            String from=datos.getEmail();
            String to=cli.getEmail();
            
            txt="From: "+from+"\nTo: "+to+"\nSubject: "+subject+"\nContent-Type: "+ct+"\n"+txt;
            SMTPMessage msg=new SMTPMessage();
            msg.setFromAddress(new EmailAddress(from));
            msg.addToAddress(new EmailAddress(to));
            msg.addDataLine(txt);
            System.out.println("TEXTO HTML: \n"+txt+"\n FIN HTML");
            
            SMTPRemoteSender sender=new SMTPRemoteSender();
            sender.sendMessage( ((EmailAddress) msg.getToAddresses().get(0)),msg );
            anyadirLog(cli,"Correcto",num);
            
        } catch(IOException ex ) {
            ex.printStackTrace();
        } catch (InvalidAddressException ex) {
            ex.printStackTrace();
            resultado="Error envio: Direccion Invalida "+cli.getEmail();
            anyadirLog(cli,"Fallido",num);
            
        } catch (AddressException ex) {
            ex.printStackTrace();
            resultado="Error envio: Direccion Invalida "+cli.getEmail();
            anyadirLog(cli,"Fallido",num);
            
        } catch (MessagingException ex) {
            ex.printStackTrace();
            resultado=traducirError(ex.getMessage());
            anyadirLog(cli,"Fallido",num);
        } catch (NotFoundException ex) {
            ex.printStackTrace();
            resultado="Error envio: Direccion Invalida "+cli.getEmail();
            anyadirLog(cli,"Fallido",num);
            
        }
        catch (Exception ex)
        {
             ex.printStackTrace();
            resultado=traducirError(ex.getMessage());
            anyadirLog(cli,"Fallido",num);
        }
        finally {
            return (new ResultadoEnvio(cli,resultado));
        }
    }
    
    /**
     * Crea y añade resultados del envio al fichero de log
     * @param c Cliente de este envio
     * @param resultado Resultado del envio
     * @param num Numero de envio
     */
    public void anyadirLog(Cliente c,String resultado,int num) {
        Runtime rtt=Runtime.getRuntime();
        try {
            String fich="";
            
            if (nombreProyecto!=null)
                fich="\"C:\\Archivos de programa\\Campus-Telematika\\Hermes\\"+nombreProyecto+System.getProperty("file.separator")+"envio"+Fecha.aFormatoBD(Fecha.fechaHoy().toString()).toString()+".log\"";
            else fich="\"envio"+Fecha.aFormatoBD(Fecha.fechaHoy().toString()).toString()+".log\"";
            if (num==0) {
                rtt.exec("cmd /c echo RESULTADO ENVIO DEL PROYECTO > "+fich);
                rtt.exec("cmd /c echo ----------------------------- >>  "+fich);
                rtt.exec("cmd /c echo Nombre              Email                     Resultado >> "+fich);
                rtt.exec("cmd /c echo ------------------------------------------------------- >> "+fich);
                rtt.exec("cmd /c echo "+c.getNombre()+" "+c.getApellido()+", "+c.getEmail()+"    .....         "+resultado+" >>"+fich);
            } else {
                rtt.exec("cmd /c echo "+c.getNombre()+" "+c.getApellido()+", "+c.getEmail()+"    .....         "+resultado+" >>"+fich);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
