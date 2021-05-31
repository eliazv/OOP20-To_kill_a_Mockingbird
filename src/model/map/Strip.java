package model.map;

public interface Strip {
	
	/**
     * Generate an array of 8 box with a random environment among the three total.
     * @param y contains the line where the array will be printed
     * @return get an array of 8 box
     */
	Box[] getRndStrip(int riga);
	 
	/**
     * returns a box that can be an obstacle once in four
     * @param background contains the environment 
     * @param specialBlock contains the obstacle which could be printed
     * @param x is the position within the vector of the strip
     * @param y contains the line where the array will be printed
     * @return get a box
     */
	Box getBoxObstacles(String background, String specialBlock, int x, int y);
	
	
	/**
     * returns a specific environment strip 
     * @param background contains the environment of the desired strip
     * @param y contains the line where the array will be printed
     * @return get an array of 8 box
     */
	Box[] getSpecificStrip(String background, int y);
	
	
	/**
     * returns a specific environment strip with specific obstacles
     * @param background contains the environment of the desired strip
     * @param specialBlock contains the obstacle of the desired strip
     * @param y contains the line where the array will be printed
     * @return get an array of 8 box
     */
	Box[] getSpecificStrip(String background, String specialBlock, int y);
}
