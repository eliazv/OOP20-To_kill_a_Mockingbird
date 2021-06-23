package controllers;

import model.enemy.Vehicle;
import model.map.Box;
import model.score.Coin;
import model.player.Directions;

public interface CollisionController {

    /**
     * method that checks the collision with the vehicle v.
     */
    void collideWithVehicles(Vehicle v) ;
	
	/**
	 * method that checks the collision with coins.
	 * @return true if colliding, false if not.
	 */
    boolean collideWithCoins(Coin c);

    /**
	 * check if the player is too close to trees and blocks input to prevent overlapping.
	 */
    void checkTrees(Box tree);
	
	/**
	 * check if the player is too close to borders.
	 */
    void checkBorders();

	/**
	 * blocks a certain direction.
	 */
    void block(Directions dir);
	
	/**
	 * blocks all directions.
	 */
    void unBlockAll();
	
	/**
	 * check if the player can move in a certain direction.
	 * @return TODO
	 */
    boolean checkDir(Directions dir);

}
