package model.map;

public interface Strip {
	
	
	Box[] setRndStrip(int riga);
	 
	 
	Box setObstacles(String background, String specialBlock, int x, int y);
	
	
	Box[] getSpecificStrip(String background, int riga);
	
	
	Box[] getSpecificStrip(String background, String specialBlock, int riga);
}
