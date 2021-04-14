package model.enemy;

import model.map.BoxImpl;

public interface Vehicle {
	
	BoxImpl setCar(int stripYLoc);
	
	BoxImpl setTrain(int stripYLoc);

}
