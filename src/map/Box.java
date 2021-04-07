package map;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Box {

	private ImageIcon image;
	private String filename="";
	private int xloc=0, yloc=0; //locazione delle immagini all'interno della gui


	public Box() {
		image = null;
		xloc = 0;
		yloc = 0;
	}
	
	public Box(String filename) {
		setImage(filename);
	}

	public Box(int xloc, int yloc) {
		this.xloc = xloc;
		this.yloc = yloc;
	}

	public Box(String filename, int xloc, int yloc) {
		setImage(filename);
		this.xloc = xloc;
		this.yloc = yloc;
	}


	
	// set the image variable.
	public void setImage(String filename) {
		this.filename = filename;

		try {
			this.image = new ImageIcon(getClass().getResource(filename));
			
		} catch (Exception e) {
			image = null;
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
	
	

	void paint(Graphics g, JPanel panel) {
		if (image == null) {
			g.drawRect( xloc, yloc, 100, 100);			
		}
			
		else {
			image.paintIcon(panel, g,  xloc,  yloc);
		}
			
	}
}
