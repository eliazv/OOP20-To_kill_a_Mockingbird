package model.map;

import java.awt.Graphics;

import javax.swing.JPanel;

public interface Box {

	//void setImage(String filename);
	
	//String getFileName();

	double getXLoc();
	
	void setXLoc(double xloc);
	
	double getYLoc();
	
	void setYLoc(double yloc);
	
	void setYDir(double ydir);
	
	void setXDir(double xdir);
	
	void move();

	void paint(Graphics g, JPanel panel);
}
