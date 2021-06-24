package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.map.Box;
import model.map.BoxImpl;

public class TestBox {

    private static final int XLOC = 5;
    private static final int YLOC = 10;
    private static final double DIR = 1;
    private static final double XLOCAFTERMOVE = 501;
    private static final double YLOCAFTERMOVE = -199;

    /**
     * Test that verify the correct creation and working of a box.
     */
    @org.junit.Test
    public void testBox() {
        final Box box = new BoxImpl();
        final Box box2 = new BoxImpl("grass.png", XLOC, YLOC);

        box2.setXDir(DIR);
        box2.setYDir(DIR);
        box2.move();

        assertEquals(null, box.getImage());
        assertEquals(0, box.getXLoc());
        assertEquals(0, box.getYLoc());

        assertEquals(XLOCAFTERMOVE, box2.getXLoc());
        assertEquals(YLOCAFTERMOVE, box2.getYLoc());
    }

}
