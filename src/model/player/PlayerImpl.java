package model.player;

import model.map.BoxImpl;

public class PlayerImpl extends BoxImpl implements Player{
	
	private int collectedCoins;
	
	public PlayerImpl(String filename, double xPos, double yPos) {
		setImage(filename);
		this.setXLoc(xPos);
		this.setYLoc(yPos);
		this.setYDir(1);
		this.collectedCoins=0;
	}

	@Override
	public int getCoins() {
		
		return this.collectedCoins;
	}

	@Override
	public void setCoins(int numberOfCoins) {
		
		this.collectedCoins=numberOfCoins;

	}

	@Override
	public void increaseCoins() {
		this.collectedCoins++;
		
	}

}
