package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.map.Strip;
import model.map.StripImpl;

public class TestStrip {

	
	
	
	/**
     * This test verify the correct creation and working of the Strip.
     */
    @org.junit.Test
    public void testStrip() {
    	
    	Strip striscia = new StripImpl();
    	
    	striscia.getRndStrip(6);
    	assertEquals(8, striscia.getStrip().length);
    	
    	striscia.getSpecificStrip("Grass.png", "Tree.png", 2);
    	assertEquals(8, striscia.getStrip().length);
    	
    	striscia.getSpecificStrip("Rail.png", 5);
    	assertEquals(8, striscia.getStrip().length);
    	assertEquals("Rail.png", striscia.getBoxOfStrip(2).getImage().getFileName());
    	
    } 
      
}
