package controllers;

import view.EndGameView;
import view.EndGameViewImpl;
import view.GameViewImpl;

public class EndGameControllerImpl implements EndGameController {

	private EndGameView view;
	GameViewImpl gameV ;
	
	public EndGameControllerImpl() {
		this.view = new EndGameViewImpl(this);
	}
	
	@Override
	public void exit() {
		System.exit(0);
	}

	@Override
	public void restart() {
		this.view.hide();
        gameV = new GameViewImpl();		
	}
	
	@Override
	public void setup() {
		this.view.show();
	}

}
