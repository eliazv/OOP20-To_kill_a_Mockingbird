package controllers;

import view.EndGameView;
import view.EndGameViewImpl;
import view.GameView;

public class EndGameControllerImpl implements EndGameController {

    private final EndGameView view;
    private GameView gameV;

    public EndGameControllerImpl() {
        this.view = new EndGameViewImpl(this);
        this.view.exit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void exit() {
        System.exit(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void restart() {
        this.view.exit();
        gameV = new GameView();
        gameV.setup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setup() {
        this.view.setup();
    }

}
