package controllers;

import view.EndGameView;
import view.EndGameViewImpl;
import view.GameView;

public class EndGameControllerImpl implements EndGameController {

	private EndGameView view;
	GameView gameV;
	
	public EndGameControllerImpl() {
		this.view = new EndGameViewImpl(this);
		this.view.hide();
	}
	
	@Override
	public void exit() {
		System.exit(0);
	}

	@Override
	public void restart() {
		this.view.hide();
        gameV = new GameView();
	}
	
	@Override
	public void setup() {
		this.view.show();
	}

}
