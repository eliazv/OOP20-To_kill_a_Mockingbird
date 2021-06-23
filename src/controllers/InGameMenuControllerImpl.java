package controllers;

import view.View;
import view.InGameMenuViewImpl;

public class InGameMenuControllerImpl implements InGameMenuController {

    private View view;

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
    public void resume() {
        this.view.exit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setup() {
        this.view = new InGameMenuViewImpl(this);
        this.view.setup();
    }

}
