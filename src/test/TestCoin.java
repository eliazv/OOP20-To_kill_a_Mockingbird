package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.score.Coin;
import model.score.CoinImpl;

public class TestCoin {

    /**
     * constant for test.
     */
    private static final double XLOC = 5;
    private static final double YLOC = 5;
    private static final double RIGHTXLOC = 1;
    private static final double RIGHTYLOC = 11;

    /**
     * Test that verify the correct creation and working of a coin.
     */
    @org.junit.Test
    public void testSingleCoin() {
        final Coin coin = new CoinImpl();
        coin.initializeCoin(XLOC, YLOC);
        coin.move();

        assertEquals(RIGHTXLOC, coin.getYDir());
        assertEquals(RIGHTYLOC, coin.getYLoc());
    }

}
