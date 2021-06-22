package controllers;

import view.InGameMenuView;
import view.InGameMenuViewImpl;

public class InGameMenuControllerImpl implements InGameMenuController {

	private InGameMenuView view;

	
	public InGameMenuControllerImpl() {
		
	}
	
	@Override
	public void exit() {
		System.exit(0);
	}

	@Override
	public void resume() {
		this.view.exit();
	}

	@Override
	public void setup() {
		this.view = new InGameMenuViewImpl(this);
		this.view.setup();
	}

}
