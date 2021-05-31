package controllers;

import java.util.ArrayList;

import model.enemy.Vehicle;
import model.map.Box;

public interface GameController {

	/**
	 * moves vehicles on the map and restart them when they are out of bounds
	 * @param vehicleManager 
	 * @param vehicles box of the vehicles
	 * @param delay delay in the departure of vehicles
	 */
	void startVehicle(Vehicle vehicleManager, ArrayList<Box> vehicles, int delay);

	/**
	 * assigns each box of the map the speed and direction of scrolling of the map
	 * @param allStrips contains all the strips that make up the map.
	 */
	void scroolScren(Box[][] allStrips);

}
