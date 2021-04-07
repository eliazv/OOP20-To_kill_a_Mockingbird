package map;

import java.util.Random;

public class Strip {
	
	//restituisce una striscia casuale
	public Box[] getStrip() {

		Box[] boxStrip = new Box[8];
		Random gen = new Random();
		int env = gen.nextInt(3); 

		// select landscape.
		switch (env) {
		// riempie la striscia con box di strada
		case 0:
			for (int i = 0; i < boxStrip.length; i++) {
				Box strip = new Box("Road.png");
				boxStrip[i] = strip;
			}
			break;

		//riempie la striscia con box di ferrovia
		case 1:
			for (int i = 0; i < boxStrip.length; i++) {
				Box strip = new Box("Tracks.png");
				boxStrip[i] = strip;
			}
			break;

		// riempie la striscia con box di erba e alberi
		case 2:
			for (int i = 0; i < boxStrip.length; i++) {
				boxStrip[i] = setObstacles("Grass.png", "Tree_One.png");
			}
			break;
		}

		return boxStrip;
	}
	
	//retituisce un box che può essere un ostacolo una volta su quattro
	private Box setObstacles(String background, String specialBlock) {

		Box oneBlock = new Box();
		Random gen = new Random();
		int rand = gen.nextInt(4);
		
		// una possibilità su 4 di mettere un ostacolo  (es albero)
		if (rand == 3) { 	
			oneBlock.setImage(specialBlock);
		} else {
			oneBlock.setImage(background);
		}
		
		return oneBlock;
	}
	
	
	//restituisce una striscia specifica
	public Box[] getSpecificStrip(String background) {

		Box[] boxStrip = new Box[8];
		
		for (int i = 0; i < boxStrip.length; i++) {
			Box strip = new Box(background);
			boxStrip[i] = strip;
		}
		
		return boxStrip;
	}
	
	
	//restituisce una striscia specifica con ostacoli
	public Box[] getSpecificStrip(String background, String specialBlock) {

		Box[] boxStrip = new Box[8];

		for (int i = 0; i < boxStrip.length; i++) {
			boxStrip[i] = setObstacles( background, specialBlock);
		}
		return boxStrip;
	}
	
}
