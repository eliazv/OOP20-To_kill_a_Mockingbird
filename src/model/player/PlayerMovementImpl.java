package model.player;


public class PlayerMovementImpl extends PlayerImpl implements PlayerMovement {

	public PlayerMovementImpl(String filename, double xPos, double yPos) {
		
		super(filename, xPos, yPos);
	}

	/**
	 * move character one box up
	 */
	private void goUp() {
		
		this.setYLoc(this.getYLoc()-100.2);
	}

	/**
	 * move character one box down
	 */
	private void goDown() {
		
		this.setYLoc(this.getYLoc()+100.2);
	}
	
	/**
	 * move character one Box left
	 */
	private void goLeft() {
		
		this.setXLoc(this.getXLoc()-100);
	}
	

	/**
	 * move character one Box right
	 */
	private void goRight() {
		
		this.setXLoc(this.getXLoc()+100);
	}


    /**
     * {@inheritDoc}
     */
	@Override
	public void moveDirection(Directions direction) {
		
		switch (direction) {
		case UP:
			this.goUp();
			break;
			
		case DOWN:
			this.goDown();
			break;
			
		case RIGHT:
			this.goRight();
			break;
			
		case LEFT:
			this.goLeft();
			break;
		
		default:
			break;
		}
	}
}
