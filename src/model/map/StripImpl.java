package model.map;

import java.util.Random;

public class StripImpl implements Strip{

	Box[] boxStrip;
	Random gen = new Random();
	
    /**
     * {@inheritDoc}
     */
	@Override
	public Box[] getRndStrip(int y) {

		boxStrip = new BoxImpl[8];
		int env = gen.nextInt(3); 

		switch (env) {
		/**
		 * fills the array with street environment
		 */
		case 0:
			for (int i = 0; i < boxStrip.length; i++) {
				Box strip = new BoxImpl("Road.png", i, y);
				boxStrip[i] = strip;
			}
			break;

		/**
		 * fills the array with rail environment
		 */
		case 1:
			for (int i = 0; i < boxStrip.length; i++) {
				Box strip = new BoxImpl("Rail.png", i, y);
				boxStrip[i] = strip;
			}
			break;

		/**
		 * fills the array with nature environment
		 */
		case 2:
			for (int i = 0; i < boxStrip.length; i++) {				
				boxStrip[i] = getBoxObstacles("Grass.png", "Tree.png", i, y);    
			}
			break;
		}

		return boxStrip;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public Box getBoxObstacles(String background, String specialBlock, int x, int y) {

		Box oneBlock;
		int rand = gen.nextInt(4);
		
		if (rand == 3) { 	
			 oneBlock = new BoxImpl(specialBlock, x, y);
		} else {
			oneBlock = new BoxImpl(background, x, y);
		}
		
		return oneBlock;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public Box[] getSpecificStrip(String background, int y) {

	    boxStrip = new BoxImpl[8];
		
		for (int i = 0; i < boxStrip.length; i++) {
			Box strip = new BoxImpl(background, i, y);
			boxStrip[i] = strip;
		}
		
		return boxStrip;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public Box[] getSpecificStrip(String background, String specialBlock, int y) {

		boxStrip = new BoxImpl[8];

		for (int i = 0; i < boxStrip.length; i++) {
			boxStrip[i] = getBoxObstacles( background, specialBlock, i , y);
		}
		return boxStrip;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public Box[] getStrip() {
		return boxStrip;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public Box getBoxOfStrip(int x) {
		return boxStrip[x];
	}
	
}
