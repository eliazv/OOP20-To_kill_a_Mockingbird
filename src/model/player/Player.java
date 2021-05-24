package model.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import model.map.BoxImpl;

public interface Player {
	double getXPos();
	double getYPos();
	double getXDir();
	double getYDir();
	
	void setXPos(double newX);
	void setYPos(double newY);
	void setXDir(double newXDir);
	void setYDir(double newYDir);
	
	void setImage(String filename);
	String getImage();
	int getWidth();
	int getHeight();
	void paint(Graphics g,JPanel p); //da aggiungere la dimensione della finestra come parametro 
									// per decidere la posizione dello spawn
	BoxImpl setPlayer(double stripXLoc,double stripYLoc);
}
