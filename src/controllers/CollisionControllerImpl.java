package controllers;

import java.awt.Rectangle;
import model.player.Directions;

import java.util.HashMap;
import java.util.Map;

import model.enemy.Vehicle;
import model.map.Box;
import model.player.PlayerMovement;
import model.score.Coin;
import view.GameView;

public class CollisionControllerImpl implements CollisionController {

    private final GameController gameController;
    private final PlayerMovement player;
    private final Map<Directions, Boolean> enabledDir = new HashMap<>();
    private final GameView gameView;

    private int ERROR = 20;

    public CollisionControllerImpl(final GameController gc, final GameView gv) {
        this.gameController = gc;
        this.gameView = gv;
        this.player = gameController.getPlayer();
        //this.unBlockAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void collideWithVehicles(final Vehicle v) {
        final Rectangle borderVehicle = new Rectangle((int) v.getXLoc() - ERROR, (int) v.getYLoc() - ERROR, v.getWidth() - ERROR, 1);
        final Rectangle borderPlayer = new Rectangle((int) player.getXLoc() - ERROR, (int) player.getYLoc() - ERROR, 100 - ERROR, 100 - ERROR);
        if (borderPlayer.intersects(borderVehicle)) {
            //System.out.println("Sei stato colpito da " + v.getName());
            this.gameOver();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean collideWithCoins(final Coin c) {
        final Rectangle borderCoin = new Rectangle((int) c.getXLoc(), (int) c.getYLoc(), c.getWidth(), 50);
        final Rectangle borderPlayer = new Rectangle((int) player.getXLoc(), (int) player.getYLoc(), 100, 100);
        return borderPlayer.intersects(borderCoin);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkTrees(final Box tree) {
        final Rectangle borderTree = new Rectangle((int) tree.getXLoc(), (int) tree.getYLoc(), 60, 60);
        if (borderTree.intersects(new Rectangle((int) player.getXLoc() + 100 - ERROR, (int) player.getYLoc() - ERROR,
            100 - ERROR, 100 - ERROR))) {
            enabledDir.put(Directions.RIGHT, false);
        }
        if (borderTree.intersects(new Rectangle((int) player.getXLoc() - 100 - ERROR, (int) player.getYLoc() - ERROR,
                100 - ERROR, 100 - ERROR))) {
            enabledDir.put(Directions.LEFT, false);
        }
        if (borderTree.intersects(new Rectangle((int) player.getXLoc() - ERROR, (int) player.getYLoc() + 100 - ERROR,
            100 - ERROR, 100 - ERROR))) {
            enabledDir.put(Directions.DOWN, false);
        }
        if (borderTree.intersects(new Rectangle((int) player.getXLoc() - ERROR, (int) player.getYLoc() - 100 - ERROR, 
            100 - ERROR, 100 - ERROR))) {
            enabledDir.put(Directions.UP, false);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkBorders() {
        if (player.getXLoc() == 700.0) {
            enabledDir.put(Directions.RIGHT, false);
        }
        if (player.getXLoc() == 0.0) {
            enabledDir.put(Directions.LEFT, false);
        }
        if (player.getYLoc() <= 40.0) {
            enabledDir.put(Directions.UP, false);
        }
        if (player.getYLoc() >= 750.0) {
            this.gameOver();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void block(final Directions dir) {
        enabledDir.put(dir, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unBlockAll() {
        enabledDir.put(Directions.LEFT, true);
        enabledDir.put(Directions.RIGHT, true);
        enabledDir.put(Directions.UP, true);
        enabledDir.put(Directions.DOWN, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkDir(final Directions dir) {
        return enabledDir.get(dir);
    }

    /**
     * Throws Game Over screen.
     */
    public void gameOver() {
        final EndGameController endGame = new EndGameControllerImpl();
        this.gameController.setPause();
        endGame.setup();
        this.gameView.exit();
    }

}
