package controllers;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import model.enemy.Vehicle;
import model.map.Box;
import model.player.PlayerMovement;
import model.score.Coin;

public class CollisionControllerImpl implements CollisionController {
	
	private GameController gameController;
	private PlayerMovement player;
	private Map<Directions, Boolean> enabledDir = new HashMap<>();
	
	private int ERROR = 20;
	
	public CollisionControllerImpl(GameController gc) {
		this.gameController = gc;
		this.player = gameController.getPlayer();
		this.unBlockAll();
	}
	
	public void collideWithVehicles(Vehicle v) {
		Rectangle borderVehicle = new Rectangle((int) v.getXLoc()-ERROR, (int)v.getYLoc()-ERROR, v.getWidth()-ERROR, 1);
		Rectangle borderPlayer = new Rectangle((int) player.getX()-ERROR, (int) player.getY()-ERROR, 100-ERROR, 100-ERROR);
		if (borderPlayer.intersects(borderVehicle)) {
			System.out.println("Sei stato colpito da " + v.getName());
			this.gameOver();
		}
	}
	
	public boolean collideWithCoins(Coin c) {
		Rectangle borderCoin = new Rectangle((int) c.getXLoc(), (int)c.getYLoc(), c.getWidth(), 50);
		Rectangle borderPlayer = new Rectangle((int) player.getX(), (int) player.getY(), 100, 100);
		if (borderPlayer.intersects(borderCoin)) return true;
		return false;
	}
	
	public void checkTrees(Box tree) {
		Rectangle borderTree = new Rectangle((int) tree.getXLoc(), (int) tree.getYLoc(), 60, 60);
		if (borderTree.intersects(new Rectangle((int) player.getX()+100-ERROR, (int) player.getY()-ERROR, 100-ERROR, 100-ERROR))) {
			enabledDir.put(Directions.RIGHT,false);
		}
		if (borderTree.intersects(new Rectangle((int) player.getX()-100-ERROR, (int) player.getY()-ERROR, 100-ERROR, 100-ERROR))) {
			enabledDir.put(Directions.LEFT,false);
		}
		if (borderTree.intersects(new Rectangle((int) player.getX()-ERROR, (int) player.getY()+100-ERROR, 100-ERROR, 100-ERROR))) {
			enabledDir.put(Directions.DOWN,false);
		}
		if (borderTree.intersects(new Rectangle((int) player.getX()-ERROR, (int) player.getY()-100-ERROR, 100-ERROR, 100-ERROR))) {
			enabledDir.put(Directions.UP,false);
		}
	}
	
	public void checkBorders() {
		if (player.getX() == 700.0) enabledDir.put(Directions.RIGHT, false);
		if (player.getX() == 0.0) enabledDir.put(Directions.LEFT, false);
		if (player.getY() <= 40.0) enabledDir.put(Directions.UP, false);
		if (player.getY() >= 750.0) this.gameOver();
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
		System.exit(1);
		//TODO add game over screen
	}

}
