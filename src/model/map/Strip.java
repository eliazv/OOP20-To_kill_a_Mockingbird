package model.map;

public interface Strip {
	
	
	BoxImpl[] setRndStrip(int riga);
	 
	 
	BoxImpl setObstacles(String background, String specialBlock, int x, int y);
	
	
	BoxImpl[] getSpecificStrip(String background, int riga);
	
	
	BoxImpl[] getSpecificStrip(String background, String specialBlock, int riga);
}
