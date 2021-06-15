package controllers;

import java.util.ArrayList;

import model.enemy.Vehicle;
import model.map.Box;
import model.score.Coin;

public interface GameController {

	
    /**
     * Call move method for the vehicles.
     * @param vehicles containing all vehicles
     */
	void moveVehicle(ArrayList<Vehicle> vehicles);
	
	/**
	 * moves all coins downward
	 * @param coins contains all coins
	 */
	void moveMoney(ArrayList<Coin> coins);
	
	/**
	 * moves vehicles on the map and restart them when they are out of bounds
	 * @param vehicleManager 
	 * @param vehicles box of the vehicles
	 * @param delay delay in the departure of vehicles
	 */
	void startVehicle(Vehicle vehicleManager, ArrayList<Vehicle> vehicles, int delay);
	
    /**
     * Restart the vehicles out of the map
     * @param vehicles containing all vehicles
     * @param delay vehicles delay
     */
	void restartVehicle(ArrayList<Vehicle> vehicles, int delay);

	
	/**
	 * assigns each box of the map the speed and direction of scrolling of the map
	 * @param allStrips contains all the strips that make up the map.
	 */
	void scroolScren(ArrayList<ArrayList<Box>> allStrips);
	
	/**
	 * Call the methods that set vehicles on the map.
	 * @param allStrips contains all the strips that make up the map.
	 * @param cars contains all cars on the map.
	 * @param trains contains all trains on the map.
	 * @param i is the line you want to check on.
	 */
	void checkOnRoad(ArrayList<ArrayList<Box>> allStrips, ArrayList<Vehicle> cars, ArrayList<Vehicle> trains, int i);

	/**
	 * Set cars on the road.
	 * @param allStrips contains all the strips that make up the map.
	 * @param cars contains all cars on the map.
	 * @param i is the line you want to check on.
	 */
	void carOnRoad(ArrayList<ArrayList<Box>> allStrips, ArrayList<Vehicle> cars, int i);

	/**
	 * Set train on the rail
	 * @param allStrips contains all the strips that make up the map.
	 * @param trains contains all trains on the map.
	 * @param i is the line you want to check on.
	 */
	void trainOnRail(ArrayList<ArrayList<Box>> allStrips, ArrayList<Vehicle> trains, int i);
	

	/**
	 * Set coins in the map, except where there is a tree
	 * @param allStrips contains all the strips that make up the map.
	 * @param coins contains all coins.
	 * @param i is the line you want to check on.
	 * @param j is the column you want to check on.
	 */
	void spawnCoin(ArrayList<ArrayList<Box>> allStrips, ArrayList<Coin> coins, int i, int j);

	
	int getScore();
	
	void setScore(int score);
	
	Boolean getPause();

	void setPause();


}
