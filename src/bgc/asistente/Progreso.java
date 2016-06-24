/*
 * Progreso.java
 *
 * Created on 6 de febrero de 2006, 9:43
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

import java.util.Random;
import javax.swing.JProgressBar;

/**
 * Clase que maneja el progreso de la creación
 * @author Campus-Telematika S.L.
 */
public class Progreso extends Thread{
    
    
    JProgressBar barra;
   
    
    Instalador instalador;
    
    /**
     * Creates a new instance of Progreso
     * @param barra JProgresBar que muestra el progreso
     * @param inst Informacion de la instalacion
     */
    public Progreso(JProgressBar barra,InformacionInstalacion inst) {
        this.barra=barra;
        instalador=new Instalador(inst);
    }
    
    
    public void run() {
        Random r=new Random();
        int paso=0;
        while(barra.getValue()<100) {
            try {
                sleep(400);
               if (paso<2)
               {
               if (instalador.cargarPaso(paso)==1)
               {
                    paso++;
               }
               }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
            int x=Math.abs(r.nextInt()%10);
            if ((barra.getValue()>90)&&(barra.getValue()+x>=100))
            {
                try {
                               
                    sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
             barra.setValue(barra.getValue()+x);
        }
        
    }
}
