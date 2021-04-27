package model.enemy;

import java.util.ArrayList;

import model.map.BoxImpl;

public interface Vehicle {
	
    /**
     * Call move method for the vehicles.
     * @param vehicles containing all vehicles
     */
	void moveVehicle(ArrayList<BoxImpl> vehicles);
	
    /**
     * Restart the vehicles out of the map
     * @param vehicles containing all vehicles
     * @param delay vehicles delay
     */
	void restartVehicle(ArrayList<BoxImpl> vehicles, int delay);
	
    /**
     * Call the methos sets the position and direction of the car.
     * @param stripYLoc contains the line where the car will be printed
     * @return get the car
     */
	BoxImpl setCar(double stripYLoc);
	
    /**
     * Call the methos for sets the position and direction of the train.
     * @param stripYLoc contains the line where the train will be printed
     * @return get the train
     */
	BoxImpl setTrain(double stripYLoc);
	
    /**
     * Sets the position and direction of the vehicles.
     * @param vehicle //TODO
     * @param speed of the vehile
     * @param imgR right sprite of the vehicle 
     * @param imgL left sprite of the vehicle
     */
	void setRndDir(BoxImpl vehicle, int speed, String imgR, String imgL);
	//servono i get?

	//img non qui
}
