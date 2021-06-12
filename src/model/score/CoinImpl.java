package model.score;

import model.map.BoxImpl;

public class CoinImpl extends BoxImpl implements Coin {
	
	//local variables
	private double YDIR = 1.0; // y direction allows to coin to move downward when the move method is called
	
	public Coin initializeCoin(double XLoc, double YLoc) {
		this.setXLoc(XLoc);
		this.setYLoc(YLoc);
		this.setYDir(this.YDIR);
		this.setImage("coin.png");
		
		return this;
	}


}
