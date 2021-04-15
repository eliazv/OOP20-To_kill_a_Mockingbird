package model.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoxImpl implements Box{

	private BufferedImage img ;
	private String filename = null;
	private double xloc, yloc; // locazione delle immagini all'doubleerno della gui
	private double xdir, ydir;
	

	public BoxImpl() {
		this.img = null;
		this.xloc = 0;
		this.yloc = 0;
		this.xdir = 0;
		this.ydir = 0;
	}
	
	public BoxImpl(String filename) {
		setImage(filename);
	}
	
	
	public BoxImpl(String filename, double xloc, double yloc) {
		setImage(filename);
		this.xloc= xloc*100;
		this.yloc = 800 - yloc*100;   //stampare le righe dal basso verso l'altro 
	}


	
	// set the image 
	public void setImage(String filename) {
		this.filename = filename;

		try {
			 img = ImageIO.read(BoxImpl.class.getClassLoader().getResourceAsStream(filename));
			
		} catch (Exception e) {
			img = null;
		}
	}

	
	public String getFileName() {
		return filename;
	}

	
	public double getXLoc() {
		return xloc;
	}
	public void setXLoc(double xloc) {
		this.xloc = xloc;
	}

	
	public double getYLoc() {
		return  yloc;
	}
	public void setYLoc(double yloc) {
		this.yloc = yloc;
	}
	
	
	public void setYDir(double ydir) {
		this.ydir = ydir;
	}

	public void setXDir(double xdir) {
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
			g.drawRect( (int)xloc, (int)yloc, 100, 100);			
		}
		
		else {
			g.drawImage(img, (int)xloc, (int)yloc, 100,100, null);
		}
			
	}
}
