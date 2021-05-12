package controllers;

import view.GameViewImpl;
import view.InGameMenuView;
import view.InGameMenuViewImpl;
import view.MainMenuView;

public class InGameMenuControllerImpl implements InGameMenuController {

	private final InGameMenuView view;
	GameViewImpl gameV;
	
	public InGameMenuControllerImpl() {
		this.view = new InGameMenuViewImpl(this);
	}
	
	@Override
	public void exit() {
		System.exit(0);
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		this.view.hide();
	}

	@Override
	public void setup() {
		// TODO Auto-generated method stub
		this.view.show();
	}

}
