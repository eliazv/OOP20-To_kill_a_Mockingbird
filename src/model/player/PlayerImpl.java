package model.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.map.BoxImpl;

public class PlayerImpl implements Player{
	
	//Player location
	private double xPos,yPos;
	
	//Player direction
	private double xDir,yDir;
	
	//Player Icon
	
	private BufferedImage image;
	
	//Player image filename
	private String filename;
	
	//Player visibility
	private boolean show;
	
	//Location Methods
	/**
	 * 
	 * @param filename
	 * @param xPos initial position x
	 * @param yPos initial position y
	 */
	public PlayerImpl(String filename, double xPos, double yPos) {
		setImage(filename);
		this.xPos = xPos;
		this.yPos = yPos;
	}

	@Override
	public double getXPos() {
		// TODO Auto-generated method stub
		return this.xPos;
	}

	@Override
	public double getYPos() {
		// TODO Auto-generated method stub
		return this.yPos;
	}

	@Override
	public void setXPos(double newX) {
		this.xPos=newX;
		
	}

	@Override
	public void setYPos(double newY) {
		this.yPos=newY;
		
	}
	
	//Direction Methods

	@Override
	public double getXDir() {
		// TODO Auto-generated method stub
		return this.xDir;
	}

	@Override
	public double getYDir() {
		// TODO Auto-generated method stub
		return this.yDir;
	}

	@Override
	public void setXDir(double newXDir) {
		this.xDir=newXDir;
		
	}

	@Override
	public void setYDir(double newYDir) {
		this.yDir=newYDir;
		
	}

	@Override
	public void setImage(String filename) {
		this.filename = filename;

		try {
			 image = ImageIO.read(BoxImpl.class.getClassLoader().getResourceAsStream(filename));
			
		} catch (Exception e) {
			image = null;
		}
		
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void paint(Graphics g, JPanel p) {
		if (image == null) {
			g.drawRect((int)this.xPos, (int)this.yPos, 100, 100);			
		}
		
		else {
			g.drawImage(image, (int)this.xPos, (int)this.yPos, 100,100, null);
		}
		
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return this.filename;
	}
	
	
	

	
	
	

}
