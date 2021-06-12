package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.score.Coin;
import model.score.CoinImpl;

public class TestCoin {

	/**
	 * Test that verify the correct creation and working of a coin.
	 */
	@org.junit.Test
	public void testSingleCoin() {
		double xloc = 5;
		double yloc = 10;
		Coin coin = new CoinImpl();
		coin.initializeCoin(xloc, yloc);
		coin.move();

		assertEquals(1, coin.getYDir());
		assertEquals(11, coin.getYLoc());
		assertEquals("coin.png", coin.getImage().getFileName());
	}
	
}
