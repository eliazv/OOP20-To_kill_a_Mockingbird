package controllers;

import view.GameViewImpl;
import view.MainMenuView;
import view.MainMenuViewImpl;

public class MainMenuControllerImpl implements MainMenuController {


	private final MainMenuView view;
	
	GameViewImpl gameV ;

    public MainMenuControllerImpl() {
        this.view = new MainMenuViewImpl(this);
    }
   
    @Override
    public void setup() {
        this.view.show();
    }

    @Override
    public void newGame() {
        this.view.hide();
        gameV = new GameViewImpl();
    }
    


}
