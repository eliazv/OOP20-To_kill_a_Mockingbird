package controllers;

import java.util.ArrayList;

import model.enemy.Vehicle;
import model.map.Box;
import model.player.Player;
import model.player.PlayerImpl;

public class GameControllerImpl implements GameController {

	public static final int NSTRIP = 11;
	public static final int BOXFORSTRIP = 8;
	public static final int MAP_SCROLL = 1;
	private Player player = new PlayerImpl("bird.png",400,600);


	private void startVehicle(Vehicle vehicleManager,
			ArrayList<Box> vehicles, int delay) {
		vehicleManager.moveVehicle(vehicles);
		vehicleManager.restartVehicle(vehicles, delay);
	}

	private void scroolScren(Box[][] allStrips) {
		for (int y = 0; y < NSTRIP; y++) {

			for (int x = 0; x < BOXFORSTRIP; x++) {
				allStrips[y][x].setYDir(MAP_SCROLL);
			}
		}
	}

	public void actionPerformed(Box[][] allStrips, Vehicle vehicleManager, ArrayList<Box> cars, ArrayList<Box> trains) {

		for (int i = 0; i < NSTRIP; i++) {
			for (int x = 0; x < BOXFORSTRIP; x++) {
				allStrips[i][x].move();
			}
		}

		this.scroolScren(allStrips);

		this.startVehicle(vehicleManager, cars, 1500);
		this.startVehicle(vehicleManager, trains, 5000);

	}

	/**
	 * 
	 * @return player
	 */
	public Player getPlayer() {
		return this.player;
	}

}
