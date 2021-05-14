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
     * Call the methods sets the position and direction of the car.
     * @param stripYLoc contains the line where the car will be printed
     * @return get the car
     */
	BoxImpl setCar(double stripYLoc);
	
    /**
     * Call the methods for sets the position and direction of the train.
     * @param stripYLoc contains the line where the train will be printed
     * @return get the train
     */
	BoxImpl setTrain(double stripYLoc);
	
    /**
     * Sets the position and direction of the vehicles.
     * @param vehicle vehicle whose direction we want to set randomly.
     * @param speed of the vehicle.
     * @param imgR right sprite of the vehicle.
     * @param imgL left sprite of the vehicle.
     */
	void setRndDir(BoxImpl vehicle, int speed, String imgR, String imgL);

	/**
	 * Call the methods that set vehicles on the map.
	 * @param allStrips contains all the strips that make up the map.
	 * @param cars contains all cars on the map.
	 * @param trains contains all trains on the map.
	 * @param i is the line you want to check on.
	 */
	void checkOnRoad(BoxImpl[][] allStrips, ArrayList<BoxImpl> cars, ArrayList<BoxImpl> trains, int i);

	/**
	 * Set cars on the road.
	 * @param allStrips contains all the strips that make up the map.
	 * @param cars contains all cars on the map.
	 * @param i is the line you want to check on.
	 */
	void carOnRoad(BoxImpl[][] allStrips, ArrayList<BoxImpl> cars, int i);

	/**
	 * Set train on the rail
	 * @param allStrips contains all the strips that make up the map.
	 * @param trains contains all trains on the map.
	 * @param i is the line you want to check on.
	 */
	void trainOnRoad(BoxImpl[][] allStrips, ArrayList<BoxImpl> trains, int i);

}
