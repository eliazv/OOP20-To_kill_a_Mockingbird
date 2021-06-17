package model.player;

import model.map.BoxImpl;

public class PlayerImpl extends BoxImpl implements Player{
	
	private int coins;
	
	public PlayerImpl(String filename, double xPos, double yPos) {
		setImage(filename);
		this.setXLoc(xPos);
		this.setYLoc(yPos);
		this.setYDir(1);
		this.coins=0;
	}

	@Override
	public int getCoins() {
		
		return this.coins;
	}

	@Override
	public void setCoins(int newCoins) {
		
		this.coins=newCoins;

		
	}

}
