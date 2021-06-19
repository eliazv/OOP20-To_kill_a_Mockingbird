package controllers;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import input.player.Input;
import input.player.InputImpl;
import model.enemy.Vehicle;
import model.enemy.VehicleImpl;
import model.map.Box;
import model.player.PlayerMovement;
import model.player.PlayerMovementImpl;
import model.score.Coin;
import model.score.CoinImpl;

public class GameControllerImpl implements GameController {

	
	//local variables
	public static final int NSTRIP = 11;
	public static final int BOXFORSTRIP = 8;
	public static final int MAP_SCROLL = 1;
	private static final int HIGHER_LIMIT = 900;
	private static final int INFERIOR_LIMIT = -100;
	private static final int SPEED_MOLTIPLICATOR = 30;
	private static final int ADJUST_ON_ROAD = 10;
	
	private PlayerMovement player = new PlayerMovementImpl("bird.png",400,600);
	private CollisionController collisionController = new CollisionControllerImpl(this);
	private Input input = new InputImpl(this, collisionController); 
	private int score = 0;
	private int realScore = 0;
	private Boolean pause = false;
	
	public Boolean getPause() {
		return pause;
	}

	public void setPause() {
		this.pause = !this.pause;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void moveVehicle(ArrayList<Vehicle> vehicles) {
		vehicles.forEach(v -> v.move());
	}

	@Override
	public void moveMoney(ArrayList<Coin> coins) {
		coins.forEach(v -> v.move());
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void restartVehicle(ArrayList<Vehicle> vehicles, int delay) {

		for (Vehicle s : vehicles) {
			if (s.getXLoc() > (HIGHER_LIMIT + s.getImage().getImgWidth()) && s.getXDir() > 0) {
				s.setXLoc(-(s.getXDir()) * SPEED_MOLTIPLICATOR - delay / 2);// togli il /2
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
	public void scrollScren(ArrayList<ArrayList<Box>> allStrips) {
		for (int y = 0; y < NSTRIP; y++) {
			for (int x = 0; x < BOXFORSTRIP; x++) {
				allStrips.get(y).get(x).setYDir(MAP_SCROLL);
			}
		}
	}

	
	/** main method for the map movement
	 * @param allStrips contains all the strips that make up the map.
	 * @param vehicleManager
	 * @param cars contains all cars
	 * @param coins contains all coins
	 * @param trains contains all trains
	 */
	public void actionPerformed(ArrayList<ArrayList<Box>> allStrips, Vehicle vehicleManager, ArrayList<Vehicle> cars, ArrayList<Coin> coins,ArrayList<Vehicle> trains) {
		if(!pause) {
			for (int i = 0; i < NSTRIP; i++) {
				for (int x = 0; x < BOXFORSTRIP; x++) {
					if (!allStrips.get(i).get(x).getImage().getFileName().equals("coin.png")) {
						allStrips.get(i).get(x).move();
					}
				}
			}
			this.scrollScren(allStrips);
			this.startVehicle(vehicleManager, cars, 1500);
			this.startVehicle(vehicleManager, trains, 5000);
			this.moveMoney(coins);
			((Box) this.player).move();
			
			collisionController.unBlockAll();
			
			cars.forEach( x -> collisionController.collideWithVehicles(x));
			trains.forEach( x -> collisionController.collideWithVehicles(x));
			
			for (int i=0; i<coins.size(); i++) {
				Coin x=coins.get(i);
				if (collisionController.collideWithCoins(x)) { 
					coins.remove(x); 
					System.out.println("moneta raccolta");
					//gameController.setScore(gameController.getRealScore()+2);
				}
			}
			
			allStrips.forEach(x ->{
				x.forEach(z ->{
					if (z.getName() == "Tree.png") {
						collisionController.checkTrees(z);
					}
				});
			});
			
			collisionController.checkBorders();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void checkOnRoad(ArrayList<ArrayList<Box>> allStrips, ArrayList<Vehicle> cars, ArrayList<Vehicle> trains,
			int i) {
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

	@Override
	public void spawnCoin(ArrayList<ArrayList<Box>> allStrips, ArrayList<Coin> coins, int i, int j) {
		if (!allStrips.get(i).get(j).getImage().getFileName().equals("Tree.png")) {
			coins.add(new CoinImpl().initializeCoin(allStrips.get(i).get(j).getXLoc(),
					allStrips.get(i).get(j).getYLoc() ));
		}
	}
	
	public void keyCatch(KeyEvent e) {
		this.input.keyInput(e);	
	}

	public PlayerMovement getPlayer() {
		return this.player;
	}
	
	public int getScore() {
		return Math.max(this.score, this.realScore);
	}
	
	public void setScore(int score) {
		if (score >= this.score) {
			this.score = score;
		}
		this.realScore = score;
	}
	
	public int getRealScore() {
		return this.realScore;
	}
}
