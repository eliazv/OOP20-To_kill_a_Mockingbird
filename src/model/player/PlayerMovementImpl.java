package model.player;

public class PlayerMovementImpl extends PlayerImpl implements PlayerMovement {

	
	public PlayerMovementImpl(String filename, double x, double y) {
		super(filename, x, y);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void goUp() {
		this.setYPos(this.getYPos()+10);
		System.out.println(this.getYPos());
		
	
		
	}

	@Override
	public void goDown() {
		this.setYPos(this.getYPos()-10);
		
		
	}

	@Override
	public void goleft() {
		this.setXPos(this.getXPos()-10);
		
		
	}

	@Override
	public void goRight() {
		this.setXPos(this.getXPos()+10);
		
		
	}
}