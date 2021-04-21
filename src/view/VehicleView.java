package view;

import java.util.ArrayList;

import model.map.BoxImpl;

public interface VehicleView {


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
	void restartVehicle(ArrayList<BoxImpl> vehicles, int delay) ;
}
