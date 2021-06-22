package controllers;

import view.GameView;
import view.MainMenuView;
import view.MainMenuViewImpl;

public class MainMenuControllerImpl implements MainMenuController {


	private final MainMenuView view;
	
	GameView gameV;

    public MainMenuControllerImpl() {
        this.view = new MainMenuViewImpl(this);
    }
   
    @Override
    public void setup() {
        this.view.setup();
    }

    @Override
    public void newGame() {
        this.view.exit();
        gameV = new GameView();
        gameV.setup();
    }
    


}
