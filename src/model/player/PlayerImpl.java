package model.player;

import model.map.BoxImpl;

public class PlayerImpl extends BoxImpl implements Player {

    private static final double MAP_SCROLL = 1;
    private int collectedCoins;

    public PlayerImpl(final String filename, final double xPos, final double yPos) {
        setImage(filename);
        this.setXLoc(xPos);
        this.setYLoc(yPos);
        this.setYDir(MAP_SCROLL);
        this.collectedCoins = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCoins() {

        return this.collectedCoins;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCoins(final int numberOfCoins) {

        this.collectedCoins = numberOfCoins;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void increaseCoins() {

        this.collectedCoins++;
    }

}
