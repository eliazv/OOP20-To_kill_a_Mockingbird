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
	private PlayerMovement pl;
	private Map<Directions, Boolean> boh = new HashMap<>();
	private int ERROR = 20;
	
	public CollisionControllerImpl(GameController gc) {
		this.gameController = gc;
		this.pl = gameController.getPlayer();
		this.unBlockAll();
	}
	
	public void collideWithVehicles(Vehicle v) {
		Rectangle borderVehicle = new Rectangle((int) v.getXLoc()-ERROR, (int)v.getYLoc()-ERROR, v.getWidth()-ERROR, 1);
		Rectangle borderPlayer = new Rectangle((int) pl.getX()-ERROR, (int) pl.getY()-ERROR, 100-ERROR, 100-ERROR);
		if (borderPlayer.intersects(borderVehicle)) {
			System.out.println("Sei stato colpito da " + v.getName());
			this.gameOver();
		}
	}
	
	public boolean collideWithCoins(Coin c) {
		Rectangle borderCoin = new Rectangle((int) c.getXLoc(), (int)c.getYLoc(), c.getWidth(), 50);
		Rectangle borderPlayer = new Rectangle((int) pl.getX(), (int) pl.getY(), 100, 100);
		if (borderPlayer.intersects(borderCoin)) return true;
		return false;
	}
	
	public void checkTrees(Box tree) {
		Rectangle borderTree = new Rectangle((int) tree.getXLoc(), (int) tree.getYLoc(), 60, 60);
		if (borderTree.intersects(new Rectangle((int) pl.getX()+100-ERROR, (int) pl.getY()-ERROR, 100-ERROR, 100-ERROR))) {
			boh.put(Directions.RIGHT,false);
		}
		if (borderTree.intersects(new Rectangle((int) pl.getX()-100-ERROR, (int) pl.getY()-ERROR, 100-ERROR, 100-ERROR))) {
			boh.put(Directions.LEFT,false);
		}
		if (borderTree.intersects(new Rectangle((int) pl.getX()-ERROR, (int) pl.getY()+100-ERROR, 100-ERROR, 100-ERROR))) {
			boh.put(Directions.DOWN,false);
		}
		if (borderTree.intersects(new Rectangle((int) pl.getX()-ERROR, (int) pl.getY()-100-ERROR, 100-ERROR, 100-ERROR))) {
			boh.put(Directions.UP,false);
		}
	}
	
	public void checkBorders() {
		if (pl.getX() == 700.0) boh.put(Directions.RIGHT, false);
		if (pl.getX() == 0.0) boh.put(Directions.LEFT, false);
		if (pl.getY() <= 40.0) boh.put(Directions.UP, false);
		if (pl.getY() >= 750.0) this.gameOver();
	}

	public void block(Directions dir) {
		boh.put(dir, false);
	}
	
	public void unBlock(Directions dir) {
		boh.put(dir, true);
	}
	
	public void unBlockAll() {
		boh.put(Directions.LEFT, true);
		boh.put(Directions.RIGHT, true);
		boh.put(Directions.UP, true);
		boh.put(Directions.DOWN, true);
	}
	
	public boolean checkDir(Directions dir) {
		return boh.get(dir);
	}
	
	public void gameOver() {
		System.exit(1);
	}

}
