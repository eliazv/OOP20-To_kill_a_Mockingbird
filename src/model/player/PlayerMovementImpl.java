package model.player;

public class PlayerMovementImpl extends PlayerImpl implements PlayerMovement {

	public PlayerMovementImpl(String filename, double xPos, double yPos) {
		super(filename, xPos, yPos);
	}

	@Override
	public void goUp() {
		
		this.setYLoc(this.getYLoc()-100.2);
		
	}

	@Override
	public void goDown() {
		
		this.setYLoc(this.getYLoc()+100.2);
		
	}

	@Override
	public void goLeft() {
		
		this.setXLoc(this.getXLoc()-100);
		
	}

	@Override
	public void goRight() {
		
		this.setXLoc(this.getXLoc()+100);
		
	}	
}
