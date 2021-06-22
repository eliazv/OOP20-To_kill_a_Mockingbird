package model.map;

import java.util.ArrayList;
import java.util.Random;


public class StripImpl implements Strip{

	private static final int STRIP_LENGTH = 8;
	
	ArrayList<Box> boxesStrip;
	Random gen = new Random();
	StripEnvironment env;
	
    /**
     * {@inheritDoc}
     */
	@Override
	public ArrayList<Box> getRndStrip(int y) {

		this.boxesStrip = new ArrayList<>();
		int rnd_env = gen.nextInt(3); 

		switch (rnd_env) {
			
		/**
		 * fills the array with street environment
		 */
		case 0:
			env=StripEnvironment.ROAD;
			for (int i = 0; i < STRIP_LENGTH; i++) {
				this.boxesStrip.add(new BoxImpl("Road.png", i, y));
				
			}
			break;

		/**
		 * fills the array with rail environment
		 */
		case 1:
			env=StripEnvironment.RAIL;
			for (int i = 0; i < STRIP_LENGTH; i++) {
				this.boxesStrip.add(new BoxImpl("Rail.png", i, y));
			}
			break;

		/**
		 * fills the array with nature environment
		 */
		case 2:
			env=StripEnvironment.GRASS;
			for (int i = 0; i < STRIP_LENGTH; i++) {				
				this.boxesStrip.add(getBoxObstacles("Grass.png", "Tree.png", i, y));    
			}
			break;
		}

		return this.boxesStrip;
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
	public void setStripEnvironment(String background) {
		switch (background) {
			case "Road.png":
				env=StripEnvironment.ROAD;
				break;
			case "Rail.png":
				env=StripEnvironment.RAIL;
				break;
			case "Grass.png":
				env=StripEnvironment.GRASS;
				break;
		}
	}
	
	
    /**
     * {@inheritDoc}
     */
	@Override
	public StripEnvironment getStripEnvironment() {
		return env;
	}
	
	
    /**
     * {@inheritDoc}
     */
	@Override
	public ArrayList<Box> getSpecificStrip(String background, int y) {

		this.boxesStrip = new ArrayList<>();
	    this.setStripEnvironment(background);
		for (int i = 0; i < STRIP_LENGTH; i++) {
			this.boxesStrip.add(new BoxImpl(background, i, y));
		}
		
		return this.boxesStrip;
	}
	
	
    /**
     * {@inheritDoc}
     */
	@Override
	public ArrayList<Box> getSpecificStrip(String background, String specialBlock, int y) {

		this.boxesStrip = new ArrayList<>();
		this.setStripEnvironment(background);
		for (int i = 0; i < STRIP_LENGTH; i++) {
			this.boxesStrip.add( getBoxObstacles( background, specialBlock, i , y));
		}
		return this.boxesStrip;
	}
	
	
    /**
     * {@inheritDoc}
     */
	@Override
	public ArrayList<Box> getStrip() {
		return this.boxesStrip;
	}
	
	
    /**
     * {@inheritDoc}
     */
	@Override
	public Box getBoxOfStrip(int x) {
		return this.boxesStrip.get(x);
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public int getTreeNumber() {
		return (int) this.boxesStrip.stream().filter(o -> o.getImage().getFileName() == "Tree.png").count();
	}

	@Override
	public void move() {
	}

}
