package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import controllers.CollisionController;
import controllers.CollisionControllerImpl;
import model.enemy.Vehicle;
import model.enemy.VehicleImpl;
import model.player.PlayerMovement;
import model.player.PlayerMovementImpl;
import model.score.Coin;
import model.score.CoinImpl;


public class TestCollision {

    private static final double XPOS = 400.0;
    private static final double YPOS = 600.0;
    private final PlayerMovement player = new PlayerMovementImpl("bird.png", XPOS, YPOS);
    private final CollisionController cm = new CollisionControllerImpl(player);
    /**
     * Test that verify the correct manageent of collisions with vehicles.
     */
    @org.junit.Test
    public void testVehicles() {
        final Vehicle car1 = new VehicleImpl();
        car1.initializeCar(2.0);
        car1.setXLoc(XPOS);
        car1.setYLoc(YPOS);
        final Vehicle train1 = new VehicleImpl();
        train1.initializeTrain(10.0);
        train1.setXLoc(0.0);
        train1.setYLoc(YPOS);

        assertTrue(cm.collideWithVehicles(car1));
        assertTrue(cm.collideWithVehicles(train1));

        final Vehicle car2 = new VehicleImpl();
        car2.initializeCar(2.0);
        car2.setXLoc(XPOS + 100.0);
        car2.setYLoc(YPOS);
        final Vehicle train2 = new VehicleImpl();
        train2.initializeTrain(10.0);
        train2.setXLoc(XPOS);
        train2.setYLoc(YPOS + 100);

        assertFalse(cm.collideWithVehicles(car2));
        assertFalse(cm.collideWithVehicles(train2));
    }

    /**
     * Test that verify the correct management of collisions with coins.
     */
    @org.junit.Test
    public void testCoins() {
        final Coin coin1 = new CoinImpl();
        coin1.initializeCoin(XPOS, YPOS);
        final Coin coin2 = new CoinImpl();
        coin2.initializeCoin(0.0, YPOS);

        assertTrue(cm.collideWithCoins(coin1));
        assertFalse(cm.collideWithCoins(coin2));
    }
}
