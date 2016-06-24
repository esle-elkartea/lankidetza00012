package bgc.negocio;

import bgc.bd.GestorBD;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.datatransfer.*;
import java.util.*;
/**
 * La clase ExcelAdapter habilita la funcionalidad Copiar-Pegar en JTables.
 *
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

public class ExcelAdapter implements ActionListener {
    private String rowstring,value;
    private Clipboard system;
    private StringSelection stsel;
    private JTable jTable1 ;
    /**
     * El Excel Adapter es construido con una 
     * JTable en la que se habilitan las funciones
     * Copiar-Pegar y actua como un portapapeles esperando los eventos.
     */
    
    public ExcelAdapter(JTable myJTable) {
        jTable1 = myJTable;
        KeyStroke copy = KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK,false);
        KeyStroke paste = KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK,false);
        jTable1.registerKeyboardAction(this,"Copy",copy,JComponent.WHEN_FOCUSED);
        jTable1.registerKeyboardAction(this,"Paste",paste,JComponent.WHEN_FOCUSED);
        system = Toolkit.getDefaultToolkit().getSystemClipboard();
    }
    /**
     * Devuelve la jTable
     */
    public JTable getJTable() {return jTable1;}
   /**
    *Modifica la jTable con el valor que se le pasa a la función
    */
    public void setJTable(JTable jTable1) {this.jTable1=jTable1;}
    /**
     cuenta las columnas vacías que se copian al portapapeles
     */
    public int contadorsaltos(String todos) {
        
        StringTokenizer st1=new StringTokenizer(todos,"\n");
        return st1.countTokens();
        
    }
    /**
     * Esta función diferencia la acción que se lleva a cabo, si se quiere copiar o pegar.
     * El pegado se hace alineando los datos que se copiaron a la primera celda de la 
     * esquina superior izquierda de la selección de la jTable.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().compareTo("Copy")==0) {
            StringBuffer sbf=new StringBuffer();
            int numcols=jTable1.getSelectedColumnCount();
            int numrows=jTable1.getSelectedRowCount();
            int[] rowsselected=jTable1.getSelectedRows();
            int[] colsselected=jTable1.getSelectedColumns();
            if (!((numrows-1==rowsselected[rowsselected.length-1]-rowsselected[0] &&
                    numrows==rowsselected.length) &&
                    (numcols-1==colsselected[colsselected.length-1]-colsselected[0] &&
                    numcols==colsselected.length))) {
                JOptionPane.showMessageDialog(null, "Invalid Copy Selection",
                        "Invalid Copy Selection",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int i=0;i<numrows;i++) {
                for (int j=0;j<numcols;j++) {
                    sbf.append(jTable1.getValueAt(rowsselected[i],colsselected[j]));
                    if (j<numcols-1) sbf.append("\t");
                }
                sbf.append("\n");
            }
            stsel  = new StringSelection(sbf.toString());
            system = Toolkit.getDefaultToolkit().getSystemClipboard();
            system.setContents(stsel,stsel);
        }
        if (e.getActionCommand().compareTo("Paste")==0) {
            System.out.println("Trying to Paste");
            int startRow=(jTable1.getSelectedRows())[0];
            int startCol=(jTable1.getSelectedColumns())[0];
            try {
                String trstring= (String)(system.getContents(this).getTransferData(DataFlavor.stringFlavor));
                System.out.println("String is:"+trstring);
                
                StringTokenizer st1=new StringTokenizer(trstring,"\n");
                
                GestorBD gbd=new GestorBD();
                gbd.abrirBD();
                Vector v1=gbd.obtenerCampos();
                gbd.cerrarBD();
                Object[][]ao=new Object[contadorsaltos(trstring)][v1.size()];
                String ArrayCampos[] = new String[v1.size()];
                for (int i=0; i<v1.size();i++) {
                    ArrayCampos[i] = v1.elementAt(i).toString();
                }
                
                jTable1.setModel(new javax.swing.table.DefaultTableModel(ao,ArrayCampos));
                
                for(int i=0;st1.hasMoreTokens();i++) {
                    
                    rowstring=st1.nextToken();
                    rowstring = rowstring.replaceAll("\t\t\t\t\t\t\t\t\t\t","\t \t \t \t \t \t \t \t \t \t \t");
                    rowstring = rowstring.replaceAll("\t\t\t\t\t\t\t\t\t\t","\t \t \t \t \t \t \t \t \t \t");
                    rowstring = rowstring.replaceAll("\t\t\t\t\t\t\t\t\t","\t \t \t \t \t \t \t \t \t");
                    rowstring = rowstring.replaceAll("\t\t\t\t\t\t\t\t","\t \t \t \t \t \t \t \t");
                    rowstring = rowstring.replaceAll("\t\t\t\t\t\t\t","\t \t \t \t \t \t \t");
                    rowstring = rowstring.replaceAll("\t\t\t\t\t\t","\t \t \t \t \t \t");
                    rowstring = rowstring.replaceAll("\t\t\t\t\t\t","\t \t \t \t \t \t");
                    rowstring = rowstring.replaceAll("\t\t\t\t\t","\t \t \t \t \t");
                    rowstring = rowstring.replaceAll("\t\t\t\t","\t \t \t \t");
                    rowstring = rowstring.replaceAll("\t\t\t","\t \t \t");
                    rowstring = rowstring.replaceAll("\t\t","\t \t");
                    if (rowstring.endsWith("\t"))
                        rowstring+=" ";
                    
                    StringTokenizer st2=new StringTokenizer(rowstring,"\t");
                    for(int j=0;st2.hasMoreTokens();j++) {
                        value=(String)st2.nextToken();
                        if (startRow+i< jTable1.getRowCount()  &&
                                startCol+j< jTable1.getColumnCount())
                            jTable1.setValueAt(value,startRow+i,startCol+j);
                        System.out.println("Putting "+ value+"at row="+startRow+i+"column="+startCol+j);
                    }
                }
            } catch(Exception ex){ex.printStackTrace();}
        }
    }
}
