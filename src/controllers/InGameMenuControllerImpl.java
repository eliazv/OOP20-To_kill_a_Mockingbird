package controllers;

import view.InGameMenuView;
import view.InGameMenuViewImpl;

public class InGameMenuControllerImpl implements InGameMenuController {

	InGameMenuView view = new InGameMenuViewImpl(this);
	
	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
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
