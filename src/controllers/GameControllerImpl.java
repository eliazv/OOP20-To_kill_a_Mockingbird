package controllers;

import java.util.ArrayList;

import model.enemy.Vehicle;
import model.enemy.VehicleImpl;
import model.map.Box;
import model.player.Player;
import model.player.PlayerImpl;

public class GameControllerImpl implements GameController {

	public static final int NSTRIP = 11;
	public static final int BOXFORSTRIP = 8;
	public static final int MAP_SCROLL = 1;
	private static final int HIGHER_LIMIT = 900;
	private static final int INFERIOR_LIMIT = -100;
	private static final int SPEED_MOLTIPLICATOR = 30;
	private static final int ADJUST_ON_ROAD = 10;
	private Player player = new PlayerImpl("bird.png",400,600);


	 /**
     * {@inheritDoc}
     */
	@Override
	public void moveVehicle(ArrayList<Vehicle> vehicles) {
		vehicles.forEach(v -> v.move());
	}
	
	 /**
     * {@inheritDoc}
     */
	@Override
	public void restartVehicle(ArrayList<Vehicle> vehicles, int delay) {
		
		for (Vehicle s : vehicles) {
			if (s.getXLoc() > (HIGHER_LIMIT + s.getImage().getImgWidth()) && s.getXDir() > 0) {
				s.setXLoc(-(s.getXDir()) * SPEED_MOLTIPLICATOR - delay / 2);//togli il /2
			}

			else if (s.getXLoc() < (INFERIOR_LIMIT - s.getImage().getImgWidth()) && s.getXDir() < 0) {
				s.setXLoc((s.getXDir()) * SPEED_MOLTIPLICATOR + delay);
			}

			// TODO rimuovi se y >800 rimuovere veicoli fuori dalla mappa in basso
		}
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public void startVehicle(Vehicle vehicleManager, ArrayList<Vehicle> vehicles, int delay) {
		this.moveVehicle(vehicles);
		this.restartVehicle(vehicles, delay);
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public void scroolScren(ArrayList<ArrayList<Box>> allStrips) {
		for (int y = 0; y < NSTRIP; y++) {
			for (int x = 0; x < BOXFORSTRIP; x++) {
				allStrips.get(y).get(x).setYDir(MAP_SCROLL);
			}
		}
	}

	
	public void actionPerformed(ArrayList<ArrayList<Box>> allStrips, Vehicle vehicleManager, ArrayList<Vehicle> cars, ArrayList<Vehicle> trains) {

		for (int i = 0; i < NSTRIP; i++) {
			for (int x = 0; x < BOXFORSTRIP; x++) {
				allStrips.get(i).get(x).move();
			}
		}
		this.scroolScren(allStrips);
		this.startVehicle(vehicleManager, cars, 1500);
		this.startVehicle(vehicleManager, trains, 5000);
	}


	
	 /**
     * {@inheritDoc}
     */
	@Override
	public void checkOnRoad(ArrayList<ArrayList<Box>> allStrips, ArrayList<Vehicle> cars, ArrayList<Vehicle> trains, int i) {
		this.carOnRoad(allStrips, cars, i);
		this.trainOnRail(allStrips, trains, i);
	}

	
	 /**
     * {@inheritDoc}
     */
	@Override
	public void carOnRoad(ArrayList<ArrayList<Box>> allStrips, ArrayList<Vehicle> cars, int i) {
		if (allStrips.get(i).get(0).getImage().getFileName().equals("Road.png")) {
			cars.add(new VehicleImpl().setCar(allStrips.get(i).get(0).getYLoc() + ADJUST_ON_ROAD));
		}
	}
	
	 /**
     * {@inheritDoc}
     */
	@Override
	public void trainOnRail(ArrayList<ArrayList<Box>> allStrips, ArrayList<Vehicle> trains, int i) {
		if (allStrips.get(i).get(0).getImage().getFileName().equals("Rail.png")) {
			trains.add(new VehicleImpl().setTrain(allStrips.get(i).get(0).getYLoc() + ADJUST_ON_ROAD));

		}
	}


	/**
	 * 
	 * @return player
	 */
	public Player getPlayer() {
		return this.player;
	}

	
}
