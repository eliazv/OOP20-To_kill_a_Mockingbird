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
import view.GameView;

public class GameControllerImpl implements GameController {

	
	//local variables
	public static final int NSTRIP = 11;
	public static final int BOXFORSTRIP = 8;
	public static final int MAP_SCROLL = 1;
	private static final int HIGHER_LIMIT = 900;
	private static final int INFERIOR_LIMIT = -100;
	private static final int SPEED_MOLTIPLICATOR = 30;
	private static final int ADJUST_ON_ROAD = 10;
	
	private int score = 0;
	private int realScore = 0;
	private Boolean pause = false;
	
	private PlayerMovement player;
	private CollisionController collisionController;
	private Input input;
	private GameView gameView; 
	
	public GameControllerImpl(GameView gv) {
		this.gameView = gv;
	}
	
	@Override
	public void setup() {
		player = new PlayerMovementImpl("bird.png",400,600);
		this.collisionController = new CollisionControllerImpl(this, gameView);
		this.input = new InputImpl(this, collisionController); 
		
	}
	
	public Boolean getPause() {
		return pause;
	}

	public void setPause() {
		this.pause = !this.pause;
	}

	@Override
	public void moveVehicle(ArrayList<Vehicle> vehicles) {
		vehicles.forEach(v -> v.move());
	}

	@Override
	public void moveMoney(ArrayList<Coin> coins) {
		coins.forEach(v -> v.move());
	}
	
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

	@Override
	public void startVehicle(Vehicle vehicleManager, ArrayList<Vehicle> vehicles, int delay) {
		this.moveVehicle(vehicles);
		this.restartVehicle(vehicles, delay);
	}

	@Override
	public void scrollScreen(ArrayList<ArrayList<Box>> allStrips) {
		allStrips.forEach(strip -> strip.forEach(box ->{
			box.setYDir(MAP_SCROLL);
			if (!box.getName().equals("coin.png")) box.move();
		}));
	}

	/** main method for the map movement
	 * @param allStrips contains all the strips that make up the map.
	 * @param vehicleManager
	 * @param cars contains all cars
	 * @param coins contains all coins
	 * @param trains contains all trains
	 */
	public void actionPerformed(ArrayList<ArrayList<Box>> allStrips, Vehicle vehicleManager, ArrayList<Vehicle> cars, 
			ArrayList<Coin> coins,ArrayList<Vehicle> trains) {
		if(!pause) {
			
			this.scrollScreen(allStrips);
			this.startVehicle(vehicleManager, cars, 1500);
			this.startVehicle(vehicleManager, trains, 5000);
			this.moveMoney(coins);
			this.player.move();
			
			collisionController.unBlockAll();
			
			cars.forEach(x -> collisionController.collideWithVehicles(x));
			trains.forEach(x -> collisionController.collideWithVehicles(x));
			
			for (int i = 0; i < coins.size(); i++) {
				Coin x = coins.get(i);
				if (collisionController.collideWithCoins(x)) { 
					coins.remove(x); 
					System.out.println("moneta raccolta");
					//TODO implement coin counter/score
				}
			}
			
			allStrips.forEach(strip -> strip.forEach(box ->{
				if (box.getName().equals("Tree.png")) collisionController.checkTrees(box);
			}));
			
			collisionController.checkBorders();
		}
	}

	@Override
	public void checkOnRoad(ArrayList<ArrayList<Box>> allStrips, ArrayList<Vehicle> cars, ArrayList<Vehicle> trains, int i) {
		this.carOnRoad(allStrips, cars, i);
		this.trainOnRail(allStrips, trains, i);
	}

	@Override
	public void carOnRoad(ArrayList<ArrayList<Box>> allStrips, ArrayList<Vehicle> cars, int i) {
		Box tile = allStrips.get(i).get(0);
		if (tile.getName().equals("Road.png")) {
			cars.add(new VehicleImpl().setCar(tile.getYLoc() + ADJUST_ON_ROAD));
		}
	}

	@Override
	public void trainOnRail(ArrayList<ArrayList<Box>> allStrips, ArrayList<Vehicle> trains, int i) {
		Box tile = allStrips.get(i).get(0);
		if (tile.getName().equals("Rail.png")) {
			trains.add(new VehicleImpl().setTrain(tile.getYLoc() + ADJUST_ON_ROAD));
		}
	}

	@Override
	public void spawnCoin(ArrayList<ArrayList<Box>> allStrips, ArrayList<Coin> coins, int i, int j) {
		Box tile = allStrips.get(i).get(j);
		if (!tile.getName().equals("Tree.png")) {
			coins.add(new CoinImpl().initializeCoin(tile.getXLoc(), tile.getYLoc()));
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
		if (score >= this.score) this.score = score;
		this.realScore = score;
	}
	
	public int getRealScore() {
		return this.realScore;
	}


}
