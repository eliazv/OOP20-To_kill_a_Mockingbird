package map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Box {

	BufferedImage img ;
	private String filename = null;
	private int xloc = 0, yloc = 0; 	//locazione delle immagini all'interno della gui
	



	public Box() {
		img = null;
		xloc = 0;
		yloc = 0;
	}
	
	public Box(String filename) {
		setImage(filename);
	}
	
	
	public Box(String filename, int xloc, int yloc) {
		setImage(filename);
		this.xloc= xloc*100;
		this.yloc = yloc*100;
	}


	
	// set the image 
	public void setImage(String filename) {
		this.filename = filename;

		try {
			 img = ImageIO.read(prova.class.getClassLoader().getResourceAsStream(filename));
			
		} catch (Exception e) {
			img = null;
		}
	}

	
	int getXLoc() {
		return xloc;
	}
	void setXLoc(int xloc) {
		this.xloc = xloc;
	}

	
	int getYLoc() {
		return  yloc;
	}
	void setYLoc(int yloc) {
		this.yloc = yloc;
	}
	
	
	//stampa blocco
	void paint(Graphics g, JPanel panel) {
		//se non c'è l'immagine stampa un quadrato 
		if (img == null) {
			g.drawRect( xloc, yloc, 100, 100);			
		}
		
		else {
			g.drawImage(img, xloc, yloc, 100,100, null);
		}
			
	}
}
