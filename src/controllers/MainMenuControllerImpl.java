package controllers;

import view.GameView;
import view.View;
import view.MainMenuViewImpl;

public class MainMenuControllerImpl implements MainMenuController {

    private final View view;
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
