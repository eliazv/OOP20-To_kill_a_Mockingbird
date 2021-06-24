package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import model.player.*;


public class TestPlayer {
	
	private static final double INITIAL_XLOC = 10;
	private static final double INITIAL_YLOC = 10;
	private static final double SCROLL_DIR = 1;
	private static final int INITIAL_COINS = 0;
	private Player player;
	
	@org.junit.Before
	public void setupMainPlayer() {
		this.player = new PlayerImpl("bird.png",INITIAL_XLOC,INITIAL_YLOC);
	}
	
	
	@org.junit.Test
	public void testMainPlayer() {

		this.player.move();
		assertEquals(SCROLL_DIR, player.getYDir());
		assertEquals(INITIAL_YLOC+1, player.getYLoc());
		assertEquals("bird.png", player.getImage().getFileName());
		
		assertEquals(INITIAL_COINS,player.getCoins());
		this.player.increaseCoins();
		assertEquals(INITIAL_COINS+1,player.getCoins());
	}
}
