package model.map;

import java.awt.Graphics;

import javax.swing.JPanel;

public interface Box {

	void setImage(String filename);
	
	String getFileName();

	public int getXLoc();
	
	public void setXLoc(int xloc);
	
	public int getYLoc();
	
	public void setYLoc(int yloc);
	
	public void setYDir(int ydir);
	
	public void setXDir(int xdir);
	
	public void move();

	public void paint(Graphics g, JPanel panel);
}
