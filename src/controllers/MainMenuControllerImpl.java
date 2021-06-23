package controllers;

import view.GameView;
import view.MainMenuView;
import view.MainMenuViewImpl;

public class MainMenuControllerImpl implements MainMenuController {


    private final MainMenuView view;

    private GameView gameV;

    public MainMenuControllerImpl() {
        this.view = new MainMenuViewImpl(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setup() {
        this.view.setup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void newGame() {
        this.view.exit();
        gameV = new GameView();
        gameV.setup();
    }



}
