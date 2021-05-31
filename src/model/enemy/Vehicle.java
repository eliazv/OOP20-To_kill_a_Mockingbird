package model.enemy;

import java.util.ArrayList;

import model.map.Box;


public interface Vehicle { //extends Box
	
    /**
     * Call move method for the vehicles.
     * @param vehicles containing all vehicles
     */
	void moveVehicle(ArrayList<Box> vehicles);
	
    /**
     * Restart the vehicles out of the map
     * @param vehicles containing all vehicles
     * @param delay vehicles delay
     */
	void restartVehicle(ArrayList<Box> vehicles, int delay);
	
    /**
     * Call the methods sets the position and direction of the car.
     * @param stripYLoc contains the line where the car will be printed
     * @return get the car
     */
	Box setCar(double stripYLoc);
	
    /**
     * Call the methods for sets the position and direction of the train.
     * @param stripYLoc contains the line where the train will be printed
     * @return get the train
     */
	Box setTrain(double stripYLoc);
	
    /**
     * Sets the position and direction of the vehicles.
     * @param vehicle vehicle whose direction we want to set randomly.
     * @param speed of the vehicle.
     * @param imgR right sprite of the vehicle.
     * @param imgL left sprite of the vehicle.
     */
	void setRndDir(Box vehicle, int speed, String imgR, String imgL);

	/**
	 * Call the methods that set vehicles on the map.
	 * @param allStrips contains all the strips that make up the map.
	 * @param cars contains all cars on the map.
	 * @param trains contains all trains on the map.
	 * @param i is the line you want to check on.
	 */
	void checkOnRoad(Box[][] allStrips, ArrayList<Box> cars, ArrayList<Box> trains, int i);

	/**
	 * Set cars on the road.
	 * @param allStrips contains all the strips that make up the map.
	 * @param cars contains all cars on the map.
	 * @param i is the line you want to check on.
	 */
	void carOnRoad(Box[][] allStrips, ArrayList<Box> cars, int i);

	/**
	 * Set train on the rail
	 * @param allStrips contains all the strips that make up the map.
	 * @param trains contains all trains on the map.
	 * @param i is the line you want to check on.
	 */
	void trainOnRail(Box[][] allStrips, ArrayList<Box> trains, int i);

}
