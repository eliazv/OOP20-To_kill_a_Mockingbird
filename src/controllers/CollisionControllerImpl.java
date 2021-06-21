package controllers;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import model.enemy.Vehicle;
import model.map.Box;
import model.player.PlayerMovement;
import model.score.Coin;
import view.GameView;

public class CollisionControllerImpl implements CollisionController {
	
	private GameController gameController;
	private PlayerMovement player;
	private Map<Directions, Boolean> enabledDir = new HashMap<>();
	private EndGameController egs;
	private GameView gameView;
	
	private int ERROR = 20;
	
	public CollisionControllerImpl(GameController gc, GameView gv) {
		this.gameController = gc;
		this.gameView = gv;
		this.player = gameController.getPlayer();
		this.unBlockAll();
	}
	
	public void collideWithVehicles(Vehicle v) {
		Rectangle borderVehicle = new Rectangle((int) v.getXLoc()-ERROR, (int) v.getYLoc()-ERROR, v.getWidth()-ERROR, 1);
		Rectangle borderPlayer = new Rectangle((int) player.getXLoc()-ERROR, (int) player.getYLoc()-ERROR, 100-ERROR, 100-ERROR);
		if (borderPlayer.intersects(borderVehicle)) {
			System.out.println("Sei stato colpito da " + v.getName());
			this.gameOver();
		}
	}
	
	public boolean collideWithCoins(Coin c) {
		Rectangle borderCoin = new Rectangle((int) c.getXLoc(), (int)c.getYLoc(), c.getWidth(), 50);
		Rectangle borderPlayer = new Rectangle((int) player.getXLoc(), (int) player.getYLoc(), 100, 100);
		if (borderPlayer.intersects(borderCoin)) return true;
		return false;
	}
	
	public void checkTrees(Box tree) {
		Rectangle borderTree = new Rectangle((int) tree.getXLoc(), (int) tree.getYLoc(), 60, 60);
		if (borderTree.intersects(new Rectangle((int) player.getXLoc()+100-ERROR, (int) player.getYLoc()-ERROR, 100-ERROR, 100-ERROR))) {
			enabledDir.put(Directions.RIGHT,false);
		}
		if (borderTree.intersects(new Rectangle((int) player.getXLoc()-100-ERROR, (int) player.getYLoc()-ERROR, 100-ERROR, 100-ERROR))) {
			enabledDir.put(Directions.LEFT,false);
		}
		if (borderTree.intersects(new Rectangle((int) player.getXLoc()-ERROR, (int) player.getYLoc()+100-ERROR, 100-ERROR, 100-ERROR))) {
			enabledDir.put(Directions.DOWN,false);
		}
		if (borderTree.intersects(new Rectangle((int) player.getXLoc()-ERROR, (int) player.getYLoc()-100-ERROR, 100-ERROR, 100-ERROR))) {
			enabledDir.put(Directions.UP,false);
		}
	}
	
	public void checkBorders() {
		if (player.getXLoc() == 700.0) enabledDir.put(Directions.RIGHT, false);
		if (player.getXLoc() == 0.0) enabledDir.put(Directions.LEFT, false);
		if (player.getYLoc() <= 40.0) enabledDir.put(Directions.UP, false);
		if (player.getYLoc() >= 750.0) this.gameOver();
	}

	public void block(Directions dir) {
		enabledDir.put(dir, false);
	}
	
	public void unBlock(Directions dir) {
		enabledDir.put(dir, true);
	}
	
	public void unBlockAll() {
		enabledDir.put(Directions.LEFT, true);
		enabledDir.put(Directions.RIGHT, true);
		enabledDir.put(Directions.UP, true);
		enabledDir.put(Directions.DOWN, true);
	}
	
	public boolean checkDir(Directions dir) {
		return enabledDir.get(dir);
	}
	
	public void gameOver() {
		this.egs=new EndGameControllerImpl();
		this.gameController.setPause();
		this.egs.setup();
		this.gameView.hide();
	}

}
