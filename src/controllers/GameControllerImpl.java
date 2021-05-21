package controllers;

import java.util.ArrayList;


import model.enemy.VehicleImpl;
import model.map.BoxImpl;
import model.player.Player;
import model.player.PlayerImpl;

public class GameControllerImpl implements GameController {

	public static final int NSTRIP = 11;
	public static final int BOXFORSTRIP = 8;
	public static final int MAP_SCROLL = 1;
	private Player player = new PlayerImpl("bird.png",400,600);
	



	private void startVehicle(VehicleImpl vehicleManager,
			ArrayList<BoxImpl> vehicles, int delay) {
		vehicleManager.moveVehicle(vehicles);
		vehicleManager.restartVehicle(vehicles, delay);
	}

	private void scroolScren(BoxImpl[][] allStrips) {
		for (int y = 0; y < NSTRIP; y++) {

			for (int x = 0; x < BOXFORSTRIP; x++) {
				allStrips[y][x].setYDir(MAP_SCROLL);
			}
		}
	}

	public void actionPerformed(BoxImpl[][] allStrips,
			VehicleImpl vehicleManager, ArrayList<BoxImpl> cars,
			ArrayList<BoxImpl> trains) {

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
