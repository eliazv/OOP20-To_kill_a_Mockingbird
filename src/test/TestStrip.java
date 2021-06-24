package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.map.Strip;
import model.map.StripEnvironment;
import model.map.StripImpl;

public class TestStrip {

    /**
     * This test verify the correct creation and working of the Strip.
     */
    @org.junit.Test
    public void testStrip() {

        Strip strip = new StripImpl();

        strip.initializeRndStrip(6);
        assertEquals(8, strip.getStrip().size());

        strip.initializeSpecificStrip("Grass.png", "Tree.png", 2);
        assertEquals(8, strip.getStrip().size());
        assertEquals(StripEnvironment.GRASS, strip.getStripEnvironment());
        assertTrue(strip.getTreeNumber() <= 8 && strip.getTreeNumber() >= 0);

        strip.initializeSpecificStrip("Rail.png", 5);
        assertEquals(8, strip.getStrip().size());
        assertEquals("Rail.png", strip.getBoxOfStrip(2).getImage().getFileName());
        assertEquals(StripEnvironment.RAIL, strip.getStripEnvironment());

    }

}
