package model.player;

import controllers.CollisionController.Directions;

public interface PlayerMovement extends Player {
	
	/**
	 * move character in any direction
	 * @param direction
	 */
	void moveDirection(Directions direction);
}
