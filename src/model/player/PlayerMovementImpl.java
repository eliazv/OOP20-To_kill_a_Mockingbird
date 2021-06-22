package model.player;


public class PlayerMovementImpl extends PlayerImpl implements PlayerMovement {

	public PlayerMovementImpl(String filename, double xPos, double yPos) {
		
		super(filename, xPos, yPos);
	}

	private void goUp() {
		
		this.setYLoc(this.getYLoc()-100.2);
	}

	private void goDown() {
		
		this.setYLoc(this.getYLoc()+100.2);
	}
	
	private void goLeft() {
		
		this.setXLoc(this.getXLoc()-100);
	}

	private void goRight() {
		
		this.setXLoc(this.getXLoc()+100);
	}


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
