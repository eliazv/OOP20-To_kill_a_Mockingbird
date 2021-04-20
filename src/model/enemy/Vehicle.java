package model.enemy;

import model.map.BoxImpl;

public interface Vehicle {
	
	BoxImpl setCar(double stripYLoc);
	
	BoxImpl setTrain(double stripYLoc);

	void rndDir(BoxImpl vehicle, int pos, int speed);
}
