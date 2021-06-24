package model.score;

import model.map.Box;

public interface Coin extends Box {
    /**
     * initialize a coin with X and Y position and the coin image (coin.png).
     * 
     * @param xLoc is the X coordinate
     * @param yLoc is the Y coordinate
     * @return a coin with X and Y location and the coin image
     */
    Coin initializeCoin(double xLoc, double yLoc);

}
