package model.map;

import java.util.ArrayList;

import model.Model;

/**
 * An interface for create the map.
 * 
 * Is an extension of Model
 */
public interface Strip extends Model {

    /**
     * Generate an array of 8 box with a random environment among the three total.
     * 
     * @param y contains the line where the array will be printed
     * @return get an array of 8 box
     */
    ArrayList<Box> initializeRndStrip(int y);

    /**
     * returns a box that can be an obstacle once in four.
     * 
     * @param background   contains the environment
     * @param specialBlock contains the obstacle which could be printed
     * @param x            is the position within the vector of the strip
     * @param y            contains the line where the array will be printed
     * @return get a box
     */
    Box insertBoxObstacles(String background, String specialBlock, int x, int y);

    /**
     * returns a specific environment strip.
     * 
     * @param background contains the environment of the desired strip
     * @param y          contains the line where the array will be printed
     * @return get an array of 8 box
     */
    ArrayList<Box> initializeSpecificStrip(String background, int y);

    /**
     * returns a specific environment strip with specific obstacles. useful for
     * creating the initial area
     * 
     * @param background   contains the environment of the desired strip
     * @param specialBlock contains the obstacle of the desired strip
     * @param y            contains the line where the array will be printed
     * @return get an array of 8 box
     */
    ArrayList<Box> initializeSpecificStrip(String background, String specialBlock, int y);

    /**
     * returns the generated strip.
     * 
     * @return get an array of 8 box
     */
    ArrayList<Box> getStrip();

    /**
     * returns the box of the strip specified by the index.
     * 
     * @param x strip vector index
     * @return get a box
     */
    Box getBoxOfStrip(int x);

    /**
     * returns the environment type of the Strip.
     * 
     * @return get the environment type of the Strip
     */
    StripEnvironment getStripEnvironment();

    /**
     * set the environment type of the Strip.
     * 
     * @param background strip background
     */
    void setStripEnvironment(String background);

    /**
     * returns the number of trees in a strip. Useful for test
     * 
     * @return get number of trees
     */
    int getTreeNumber();
}
