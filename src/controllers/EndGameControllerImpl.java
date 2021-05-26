package controllers;

import view.EndGameView;
import view.EndGameViewImpl;

public class EndGameControllerImpl implements EndGameController {

	private EndGameView view;

	public EndGameControllerImpl() {
		this.view = new EndGameViewImpl(this);
	}
	
	@Override
	public void exit() {
		System.exit(0);
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setup() {
		this.view.show();
	}

}
