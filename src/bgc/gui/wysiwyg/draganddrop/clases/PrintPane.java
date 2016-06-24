package bgc.gui.wysiwyg.draganddrop.clases;

import java.awt.*;
import javax.swing.*;
import java.awt.print.*;
import java.io.*;

public class PrintPane extends JTextPane implements Printable,Serializable
{
	public PrintPane(){}
	public int print(Graphics g,PageFormat pf,int pi) throws PrinterException
	{

		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.black);

		Dimension d = this.getSize(); //get size of document
		double panelWidth = d.width; //width in pixels
		double panelHeight = d.height; //height in pixels

		double pageHeight = pf.getImageableHeight(); //height of printer page
		double pageWidth = pf.getImageableWidth(); //width of printer page

		double scale = pageWidth/panelWidth;
		int totalNumPages = (int)Math.ceil(scale * panelHeight / pageHeight);

		//make sure not print empty pages
		if(pi >= totalNumPages)
		{ return Printable.NO_SUCH_PAGE;
		}

		//shift Graphic to line up with beginning of print-imageable region
		g2.translate(pf.getImageableX(), pf.getImageableY());

		//shift Graphic to line up with beginning of next page to print
		g2.translate(0f, - pi * pageHeight);

		//scale the page so the width fits...
		g2.scale(scale, scale);

		this.paint(g2); //repaint the page for printing

		return Printable.PAGE_EXISTS;

		/*if (pi>=0)
		{
			return Printable.NO_SUCH_PAGE;
		}
		g.translate(100,100);
		paint(g);
		return Printable.PAGE_EXISTS;*/
	}
}