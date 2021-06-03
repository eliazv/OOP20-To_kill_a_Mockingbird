package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.map.Box;
import model.map.BoxImpl;


public class TestBoxes {

	private String imagePath = new String("grass.png");
	private int xloc = 5;
	private int yloc = 10;
	private double dir = 1;
	

	/**
	 * Test that verify the correct creation and working of a box.
	 */
	@org.junit.Test
	public void testBox() {
		Box box = new BoxImpl();
		Box box2 = new BoxImpl(this.imagePath, this.xloc, this.yloc);

		box2.setXDir(this.dir);
		box2.setYDir(this.dir);
		box2.move();

		assertEquals(null, box.getImage());
		assertEquals(0, box.getXLoc());
		assertEquals(0, box.getYLoc());

		assertEquals(501, box2.getXLoc());
		assertEquals(-199, box2.getYLoc());
	}
	
}
