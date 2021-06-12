package model.score;

import model.map.Box;

public interface Coin extends Box {
	
	
	/** initialize a coin with X and Y position and the coin image (coin.png)
	 * @param XLoc is the X coordinate
	 * @param YLoc is the Y coordinate
	 * @return a coin with X and Y location and the coin image
	 */
	Coin initializeCoin(double XLoc, double YLoc);

}
