package map;

import java.util.Random;

public class StripGenerator {
	Box[] getStrip() {

		// Array to hold strip.
		Box[] boxStrip = new Box[7];

		// Number of grids wide.
		int y = boxStrip.length;

		// Selects random landscape.
		Random gen = new Random();
		int env = gen.nextInt(3);

		// Sets landscape.
		switch (env) {
		// Road.
		case 0:
			for (int i = 0; i < y; i++) {
				Box strip = new Box("Road.png");
				boxStrip[i] = strip;
			}
			break;

		// Tracks.
		case 1:
			for (int i = 0; i < y; i++) {
				Box strip = new Box("Tracks.png");
				boxStrip[i] = strip;
			}
			break;

		// Special Land.
		case 2:
			for (int i = 0; i < y; i++) {
				// Holds random number.
				// env = gen.nextInt(5);
				boxStrip[i] = stripWithObstacles(i, env, "Grass.png", "Tree_One.png");
			}
			break;

		}

		return boxStrip;
	}

	private Box stripWithObstacles(int i, int x, String background, String specialBlock) {

		Box oneBlock = new Box();
		Random gen = new Random();
		int rand = gen.nextInt(5);
		if (rand == 4) { // una possibilità su 5 di mettere ostacolo
			oneBlock.setImage(specialBlock);
		} else {
			oneBlock.setImage(background);
		}

		// Adds image to strip.
		return oneBlock;
	}
//PROVA 1
}
