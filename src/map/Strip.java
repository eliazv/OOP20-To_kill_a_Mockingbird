package map;

import java.util.Random;

public class Strip {
	
	//restituisce una striscia casuale
	public Box[] getStrip(int riga) {

		Box[] boxStrip = new Box[8];
		Random gen = new Random();
		int env = gen.nextInt(3); 

		// select landscape.
		switch (env) {
		// riempie la striscia con box di strada
		case 0:
			for (int i = 0; i < boxStrip.length; i++) {
				Box strip = new Box("Road.png", i, riga);
				boxStrip[i] = strip;
			}
			break;

		//riempie la striscia con box di ferrovia
		case 1:
			for (int i = 0; i < boxStrip.length; i++) {
				Box strip = new Box("Tracks.png", i, riga);
				boxStrip[i] = strip;
			}
			break;

		// riempie la striscia con box di erba e alberi
		case 2:
			for (int i = 0; i < boxStrip.length; i++) {				
				boxStrip[i] = setObstacles("Grass.png", "Tree_One.png", i, riga);    
			}
			break;
		}

		return boxStrip;
	}
	
	//retituisce un box che può essere un ostacolo una volta su quattro
	private Box setObstacles(String background, String specialBlock, int x, int y) {

		Box oneBlock;
		Random gen = new Random();
		int rand = gen.nextInt(4);
		
		// una possibilità su 4 di mettere un ostacolo  (es albero)
		if (rand == 3) { 	
			 oneBlock = new Box(specialBlock, x, y);
		} else {
			oneBlock = new Box(background, x, y);
		}
		
		return oneBlock;
	}
	
	
	//restituisce una striscia specifica
	public Box[] getSpecificStrip(String background, int riga) {

		Box[] boxStrip = new Box[8];
		
		for (int i = 0; i < boxStrip.length; i++) {
			Box strip = new Box(background, i, riga);
			boxStrip[i] = strip;
		}
		
		return boxStrip;
	}
	
	
	//restituisce una striscia specifica con ostacoli
	public Box[] getSpecificStrip(String background, String specialBlock, int riga) {

		Box[] boxStrip = new Box[8];

		for (int i = 0; i < boxStrip.length; i++) {
			boxStrip[i] = setObstacles( background, specialBlock, i , riga);
		}
		return boxStrip;
	}
	
}
