package model.score;

import model.map.BoxImpl;

public class CoinImpl extends BoxImpl implements Coin {
    /**
     * constant.
     */
    private static final double YDIR = 1.0; // y direction allows to coin to move downward when the move method is called

    /**
     * {@inheritDoc}
     */
    @Override
    public Coin initializeCoin(final double xLoc, final double yLoc) {
        this.setXLoc(xLoc);
        this.setYLoc(yLoc);
        this.setYDir(YDIR);
        this.setImage("coin.png");

        return this;
    }

}
