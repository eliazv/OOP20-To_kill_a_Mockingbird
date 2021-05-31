package model.map;

import java.awt.Graphics;

import javax.swing.JPanel;

import view.ImageLoader;

public interface Box {

	void setImage(String filename);
	
	public ImageLoader getImage();

	double getXLoc();
	
	void setXLoc(double xloc);
	
	double getYLoc();
	
	double getYDir();
	
	double getXDir();
	
	void setYLoc(double yloc);
	
	void setYDir(double ydir);
	
	void setXDir(double xdir);
	
	void move();

	void paint(Graphics g, JPanel panel);
}
