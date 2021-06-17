package model.player;

public interface PlayerMovement {
	/**
	 * move one box up
	 */
	void goUp();
	
	/**
	 * move one box down
	 */
	void goDown();
	
	/**
	 * move one box left
	 */
	void goLeft();
	
	/**
	 * move one box right
	 */
	void goRight();
}
