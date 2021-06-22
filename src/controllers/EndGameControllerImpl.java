package controllers;

import view.EndGameView;
import view.EndGameViewImpl;
import view.GameView;

public class EndGameControllerImpl implements EndGameController {

	private EndGameView view;
	GameView gameV;
	
	public EndGameControllerImpl() {
		this.view = new EndGameViewImpl(this);
		this.view.exit();
	}
	
	@Override
	public void exit() {
		System.exit(0);
	}

	@Override
	public void restart() {
		this.view.exit();
        gameV = new GameView();
        gameV.setup();
	}
	
	@Override
	public void setup() {
		this.view.setup();
	}

}
