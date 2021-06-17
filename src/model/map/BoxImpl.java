package model.map;

import java.awt.Graphics;
import javax.swing.JPanel;

import view.ImageLoader;

public class BoxImpl implements Box{

	//local variables
	private ImageLoader imgLoader ;
	private double xloc, yloc;
	private double xdir, ydir;
	private String name;
	
	public BoxImpl() {
		this.xloc = 0;
		this.yloc = 0;
		this.xdir = 0;
		this.ydir = 0;
	}
	
	public BoxImpl(String filename) {
		this.setImage(filename);
		this.name = filename;
	}
	
	
	public BoxImpl(String filename, double xloc, double yloc) {
		this.setImage(filename);
		this.xloc= xloc*100; 
		this.yloc = 800 - yloc*100;   //print the lines from the bottom to the top 
		this.name = filename;
	}

	public void setImage(String filename) {
		imgLoader= new ImageLoader(filename);
		this.name = filename;
	}
	
	public ImageLoader getImage() {
		return imgLoader;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getXLoc() {
		return this.xloc;
	}
	
	public void setXLoc(double xloc) {
		this.xloc = xloc;
	}

	
	public double getYLoc() {
		return  this.yloc;
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

	public double getXDir() {
		return  this.xdir;
	}
	
	public double getYDir() {
		return  this.ydir;
	}
	
	public void move() {
		this.xloc += this.xdir;
		this.yloc += this.ydir;
	}
	

	public void paint(Graphics g, JPanel panel) {
		//if no image has been uploaded, will be drawn an empy square
		if (imgLoader == null) {
			g.drawRect( (int)xloc, (int)yloc, 100, 100);			
		}
		//if imgLoader in not null, will be drawn a square filled with the image 
		else {
			g.drawImage(imgLoader.getImage(), (int)xloc, (int)yloc, imgLoader.getImgWidth(), imgLoader.getImgHeight(), null);
		}
			
	}
}
