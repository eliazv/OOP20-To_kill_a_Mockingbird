package model.enemy;

import model.map.BoxImpl;

public interface Vehicle {
	
	BoxImpl setCar(double stripYLoc);
	
	BoxImpl setTrain(double stripYLoc);
	
	//servono i get?

	//img non qui
	void rndDir(BoxImpl vehicle, int pos, int speed, String imgDx, String imgSx);
}
