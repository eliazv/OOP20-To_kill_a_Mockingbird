package controllers;

import java.util.ArrayList;
import java.util.List;

import model.enemy.Vehicle;
import model.map.Box;
import model.player.PlayerMovement;
import model.score.Coin;

public interface GameController extends Controller {

    /**
     * Call move method for the vehicles.
     * 
     * @param vehicles containing all vehicles
     */
    void moveVehicle(List<Vehicle> vehicles);

    /**
     * moves all coins downward
     * 
     * @param coins contains all coins
     */
    void moveMoney(List<Coin> coins);

    /**
     * moves vehicles on the map and restart them when they are out of bounds
     * 
     * @param vehicleManager
     * @param vehicles       box of the vehicles
     * @param delay          delay in the departure of vehicles
     */
    void startVehicle(Vehicle vehicleManager, List<Vehicle> vehicles, int delay);

    /**
     * Restart the vehicles out of the map
     * 
     * @param vehicles containing all vehicles
     * @param delay    vehicles delay
     */
    void restartVehicle(List<Vehicle> vehicles, int delay);

    /**
     * assigns each box of the map the speed and direction of scrolling of the map
     * 
     * @param allStrips contains all the strips that make up the map.
     */
    void scrollScreen(List<ArrayList<Box>> allStrips);

    /**
     * Call the methods that set vehicles on the map.
     * 
     * @param allStrips contains all the strips that make up the map.
     * @param cars      contains all cars on the map.
     * @param trains    contains all trains on the map.
     * @param i         is the line you want to check on.
     */
    void spawnVehicle(List<ArrayList<Box>> allStrips, List<Vehicle> cars, List<Vehicle> trains, int i);

    /**
     * Set cars on the road.
     * 
     * @param allStrips contains all the strips that make up the map.
     * @param cars      contains all cars on the map.
     * @param i         is the line you want to check on.
     */
    void carOnRoad(List<ArrayList<Box>> allStrips, List<Vehicle> cars, int i);

    /**
     * Set train on the rail
     * 
     * @param allStrips contains all the strips that make up the map.
     * @param trains    contains all trains on the map.
     * @param i         is the line you want to check on.
     */
    void trainOnRail(List<ArrayList<Box>> allStrips, List<Vehicle> trains, int i);

    /**
     * Set coins in the map, except where there is a tree
     * 
     * @param allStrips contains all the strips that make up the map.
     * @param coins     contains all coins.
     * @param i         is the line you want to check on.
     * @param j         is the column you want to check on.
     */
    void spawnCoin(List<ArrayList<Box>> allStrips, List<Coin> coins, int i, int j);

    /**
     * 
     * @return return the score that should be displayed
     */
    int getScore();

    /**
     * 
     * @return return the score that should be used internally
     */
    int getRealScore();

    /**
     * 
     * @param score
     */
    void setScore(int score);

    /**
     * 
     * @return PlayerMovement
     */
    PlayerMovement getPlayer();

    /**
     * 
     * @return boolean
     */
    Boolean getPause();

    /**
     * 
     */
    void setPause();

    /**
     * Generates the initial area of the map with only Grass strips, the character's spawn zone is without obstacles.
     * @param allStrip strips that generate the map
     */
    void setInitialPosition(List<ArrayList<Box>> allStrip);

    /**
     * Generates the map and above it the vehicles and coins
     * @param allStrip strips that generate the map
     * @param VehiclesOnRoad car or truck in the map
     * @param Trains trains in the map
     * @param coins coins in the map
     */
    void generateMap(List<ArrayList<Box>> allStrip, List<Vehicle> VehiclesOnRoad, List<Vehicle> Trains,
            List<Coin> coins);

}
