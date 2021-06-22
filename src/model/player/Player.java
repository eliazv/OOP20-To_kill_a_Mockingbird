package model.player;

import model.map.Box;

public interface Player extends Box{
	
	/**
	 * 
	 * @return the number of coins
	 */
	int getCoins();
	
	/**
	 * set the new number of coins
	 * @param newCoins
	 */
	void setCoins(int numberOfCoins);
	
	/**
	 * increase the number of coins
	 */
	void increaseCoins();
	
}
