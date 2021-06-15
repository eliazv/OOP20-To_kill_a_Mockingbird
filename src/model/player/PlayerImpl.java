package model.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.map.BoxImpl;

public class PlayerImpl implements Player{
	
	BoxImpl playerBox;
		
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
	
	private Graphics g;
	
	private JPanel p;
	
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
		this.yDir=1;
	}

	//Location Methods
	
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

	public void move() {
		this.xPos += this.xDir;
		this.yPos += this.yDir;
	}
	
	public void movePlayer(PlayerImpl player) {
		player.move();
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
	
	Graphics getGr() {
		return this.g;
	}
	
	JPanel getJp() {
		return this.p;
	}

	@Override
	public void paint(Graphics g, JPanel p) {
		this.g=g;
		this.p=p;
		if (image == null) {
			
			this.g.drawRect((int)this.xPos, (int)this.yPos, 100, 100);			
		}
		
		else {
			this.g.drawImage(image, (int)this.xPos, (int)this.yPos, 100,100, null);
		}
		
	}

	@Override
	public String getImage() {
		// TODO Auto-generated method stub
		return this.filename;
	}
	
	public BoxImpl setPlayer(double stripXLoc,double stripYLoc) {

		playerBox = new BoxImpl();
		playerBox.setXLoc(stripXLoc);
		playerBox.setYLoc(stripYLoc);
		
		//playerBox.setImage(filename);
		playerBox.setYDir(1);
		
		return playerBox;
	}
	
	
	@Override
	public void goUp() {
		this.setYPos(this.getYPos()-101);
		System.out.println(this.getYPos());
		
	
		
	}

	@Override
	public void goDown() {
		this.setYPos(this.getYPos()+99);
		
		
	}

	@Override
	public void goleft() {
		this.setXPos(this.getXPos()-100);
		
		
	}

	@Override
	public void goRight() {
		this.setXPos(this.getXPos()+100);
		
		
	}

	
	
	

	
	
	

}
