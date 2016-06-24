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

import bgc.gui.proy.nuevo.PanelProgreso;
import bgc.gui.proy.nuevo.VNuevoProyEnvio;
import java.lang.reflect.Array;

/**
 * Clase Thread que se encarga de mandar los emails
 * @author Campus-Telematika S.L.
 */
public class HiloCorreo extends Thread{
   
    /**
     * Array de ResultadoEnvio
     */
     ResultadoEnvio []as;
    /**
     * Html a enviar
     */
     String documentohtml;
    /**
     * Ventana padre
     */
     VNuevoProyEnvio v;
    /**
     * Panel Padre
     */
     PanelProgreso padre;
    /**
     * Cliente correo
     */
     ClienteCorreo c;
    /**
     * Control de finalización del envio
     */
     boolean fin;
    /**
     * Asunto del email
     */
     String titulo;
    
    /**
     * Creates a new instance of HiloCorreo
     * @param as Array de Resultado de Envio
     * @param fin control de fin
     * @param v Ventana padre
     * @param padre Panel Padre 
     * @param html HTML a enviar
     * @param titulo Asunto de email
     */
    public HiloCorreo(ResultadoEnvio []as,boolean fin,VNuevoProyEnvio v,PanelProgreso padre, String html,String titulo) {
        this.as=as;
        this.documentohtml=html;
        this.v=v;
        c=new ClienteCorreo(v.getProyecto().getRuta());
        this.padre=padre;
        this.fin=fin;
        this.titulo=titulo;
    }

    /**
     * Heredado de Thread
     */
    public void run() {

        super.run();
        int total=Array.getLength(as);
        int cont=1;
        System.out.println("::::::::ENVIO::::::::");
        try {
            int rango=padre.progreso.getMaximum()/Array.getLength(as);
            
            for(int i=0;i<Array.getLength(as);i++)
            {
                padre.jLabel2.setText("Enviando mensaje "+cont+" de "+total);
                cont++;   
                as[i]=c.mandarJavaMail(as[i].getCliente(),documentohtml,titulo,i);
                padre.progreso.setValue(padre.progreso.getValue()+rango);
                v.validar();
            }
            
        } catch (java.lang.NullPointerException npe) {
            System.out.println("ERROR ENVIO"+ npe.getMessage());
        }
	
	System.out.println(":::::::::::POST  ENVIO::::::::");
        fin=true;
        //this.destroy();
        padre.cerrar();
    }
    
}
