package controllers;

import java.util.ArrayList;


import model.enemy.Vehicle;
import model.enemy.VehicleImpl;
import model.map.BoxImpl;


public class GameControllerImpl implements GameController {
	protected int NSTRIP = 11;
	protected int BOXFORSTRIP = 8;
	protected int iriga = 11;
	
	public void startVehicle(VehicleImpl vehicleManager, ArrayList<BoxImpl> vehicles, int delay) {
		vehicleManager.moveVehicle(vehicles);		
		vehicleManager.restartVehicle(vehicles, delay);
	}
	
	
	public void scroolScren(BoxImpl[][] allStrips) {
		for (int y = 0; y < this.NSTRIP; y++) {
			
			for (int x = 0; x < this.BOXFORSTRIP; x++) {
				allStrips[y][x].setYDir(1);
			}
		}
	}
	

}
