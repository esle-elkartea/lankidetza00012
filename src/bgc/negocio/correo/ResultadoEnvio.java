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

/**
 * Clase que almacena el resultado del envio
 * @author Campus-Telematika S.L.
 */
public class ResultadoEnvio {
    
    /** Creates a new instance of ResultadoEnvio */
    public ResultadoEnvio() {
    }
    
    /**
     * Crea un nuevo objeto de tipo ResultadoEnvio
     * @param c Cliente a enviar
     * @param r Texto con el reultado
     */
     public ResultadoEnvio(Cliente c, String r) {
	 setCliente(c);
	 resultado=r;
    }
  
    /**
     * Retorna el resultado
     * @return Resultado del envio
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Modifica el resultado
     * @param resultado Texto del resultado
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    /**
     * Retorna el Cliente a enviar
     * @return Cliente a enviar el email
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Modifica el Cliente a enviar
     * @param cliente Cliente a enviar
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    /**
     * Cliente a enviar el email
     */
     private Cliente cliente;
    /**
     * Texto con el resultado del envio
     */
    private String resultado;
}
