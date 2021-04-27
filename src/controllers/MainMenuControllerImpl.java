package controllers;

import view.MainMenuView;
import view.MainMenuViewImpl;

public class MainMenuControllerImpl implements MainMenuController {


	private final MainMenuView view;

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
        
    }

}
