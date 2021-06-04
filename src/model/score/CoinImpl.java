package model.score;

import model.map.BoxImpl;

public class CoinImpl extends BoxImpl implements Coin {

	private double YDIR = 1.0;
	
	public Coin initializeCoin(double XLoc, double YLoc) {
		this.setXLoc(XLoc);
		this.setYLoc(YLoc);
		this.setYDir(this.YDIR);
		this.setImage("coin.png");
		
		return this;
	}


}
