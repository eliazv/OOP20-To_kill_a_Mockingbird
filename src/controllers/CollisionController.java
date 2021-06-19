package controllers;

import java.util.Map;
import model.enemy.Vehicle;
import model.map.Box;
import model.score.Coin;

public interface CollisionController {
	
	enum Directions{
		LEFT,RIGHT,UP,DOWN
	}
	
	/*
	 * method that checks the collision with the vehicle v.
	 * @return true if colliding, false if not.
	 */
	public void collideWithVehicles(Vehicle v) ;
	
	/*
	 * method that checks the collision with coins.
	 * @return true if colliding, false if not.
	 */
	public boolean collideWithCoins(Coin c);

	/*
	 * check if the player is too close to trees and blocks input
	 * to prevent overlapping
	 */
	public void checkTrees(Box tree);
	
	/*
	 * check if the player is too close to borders.
	 */
	public void checkBorders();

	/*
	 * blocks a certain direction.
	 */
	public void block(Directions dir);
	
	/*
	 * unblocks a certain direction.
	 */
	public void unBlock(Directions dir);
	
	/*
	 * blocks all directions.
	 */
	public void unBlockAll();
	
	/*
	 * check if the player can move in a certain direction.
	 */
	public boolean checkDir(Directions dir);
}
