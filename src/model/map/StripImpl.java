package model.map;

import java.util.ArrayList;
import java.util.Random;

/**
 * The implementation of Strip
 * 
 * It contains random and non-random methods for generating different types of
 * strip.
 */
public class StripImpl implements Strip {

    /**
     * constants for generating the strip.
     */
    private static final int STRIP_LENGTH = 8;
    private static final int PROBABILITY_OF_STRIPENV = 3;
    private static final int PROBABILITY_OF_SPAWN_OBSTACLE = 4;

    /**
     * local variables.
     */
    private ArrayList<Box> boxesStrip;
    private final Random gen = new Random();
    private static final String IMAGETREE = "Tree.png";
    private StripEnvironment env;

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Box> initializeRndStrip(final int y) {

        this.boxesStrip = new ArrayList<>();
        final int rndEnv = gen.nextInt(PROBABILITY_OF_STRIPENV);

        switch (rndEnv) {

        /**
         * fills the array with street environment
         */
            case 0:
                env = StripEnvironment.ROAD;
                for (int i = 0; i < STRIP_LENGTH; i++) {
                    this.boxesStrip.add(new BoxImpl("Road.png", i, y));

                }
                break;

        /**
         * fills the array with rail environment
         */
            case 1:
                env = StripEnvironment.RAIL;
                for (int i = 0; i < STRIP_LENGTH; i++) {
                    this.boxesStrip.add(new BoxImpl("Rail.png", i, y));
                }
                break;

        /**
         * fills the array with nature environment
         */
            case 2:
                env = StripEnvironment.GRASS;
                for (int i = 0; i < STRIP_LENGTH; i++) {
                    this.boxesStrip.add(insertBoxObstacles("Grass.png", "Tree.png", i, y));
                }
                break;
            default:
                break;
        }
        return this.boxesStrip;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Box insertBoxObstacles(final String background, final String specialBlock, final int x, final int y) {

        Box oneBlock;
        final int rand = gen.nextInt(PROBABILITY_OF_SPAWN_OBSTACLE);

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
    public void setStripEnvironment(final String background) {
        switch (background) {
            case "Road.png":
                env = StripEnvironment.ROAD;
                break;
            case "Rail.png":
                env = StripEnvironment.RAIL;
                break;
            case "Grass.png":
                env = StripEnvironment.GRASS;
                break;
            default:
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
    public ArrayList<Box> initializeSpecificStrip(final String background, final int y) {

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
    public ArrayList<Box> initializeSpecificStrip(final String background, final String specialBlock, final int y) {

        this.boxesStrip = new ArrayList<>();
        this.setStripEnvironment(background);
        for (int i = 0; i < STRIP_LENGTH; i++) {
            this.boxesStrip.add(insertBoxObstacles(background, specialBlock, i, y));
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
    public Box getBoxOfStrip(final int x) {
        return this.boxesStrip.get(x);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTreeNumber() {
        return (int) this.boxesStrip.stream().filter(o -> o.getImage().getFileName().equals(IMAGETREE)).count();
    }

    @Override
    public void move() {

    }

}
