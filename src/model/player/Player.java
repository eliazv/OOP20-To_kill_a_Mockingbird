package model.player;

import model.map.Box;

public interface Player extends Box{
	
	/**
	 * 
	 * @return the number of coins
	 */
	public int getCoins();
	
	/**
	 * set the new number of coins
	 * @param newCoins
	 */
	public void setCoins(int newCoins);
	
}
