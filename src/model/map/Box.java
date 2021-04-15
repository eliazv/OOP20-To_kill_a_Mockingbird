package model.map;

import java.awt.Graphics;

import javax.swing.JPanel;

public interface Box {

	void setImage(String filename);
	
	String getFileName();

	public double getXLoc();
	
	public void setXLoc(double xloc);
	
	public double getYLoc();
	
	public void setYLoc(double yloc);
	
	public void setYDir(double ydir);
	
	public void setXDir(double xdir);
	
	public void move();

	public void paint(Graphics g, JPanel panel);
}
