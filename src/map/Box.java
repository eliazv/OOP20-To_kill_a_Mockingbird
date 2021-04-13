package map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Box {

	private BufferedImage img ;
	private String filename = null;
	private int xloc, yloc; // locazione delle immagini all'interno della gui
	private int xdir, ydir;
	

	public Box() {
		this.img = null;
		this.xloc = 0;
		this.yloc = 0;
		this.xdir = 0;
		this.ydir = 0;
	}
	
	public Box(String filename) {
		setImage(filename);
	}
	
	
	public Box(String filename, int xloc, int yloc) {
		setImage(filename);
		this.xloc= xloc*100;
		this.yloc = 800 - yloc*100;   //stampare le righe dal basso verso l'altro 
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

	
	String getFileName() {
		return filename;
	}

	
	public int getXLoc() {
		return xloc;
	}
	public void setXLoc(int xloc) {
		this.xloc = xloc;
	}

	
	public int getYLoc() {
		return  yloc;
	}
	public void setYLoc(int yloc) {
		this.yloc = yloc;
	}
	
	
	public void setYDir(int ydir) {
		this.ydir = ydir;
	}

	public void setXDir(int xdir) {
		this.xdir = xdir;
	}

	public void move() {
		this.xloc += this.xdir;
		this.yloc += this.ydir;
	}
	
	//stampa blocco
	public void paint(Graphics g, JPanel panel) {
		//se non c'è l'immagine stampa un quadrato 
		if (img == null) {
			g.drawRect( xloc, yloc, 100, 100);			
		}
		
		else {
			g.drawImage(img, xloc, yloc, 100,100, null);
		}
			
	}
}
