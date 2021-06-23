package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import controllers.CollisionController;
import controllers.CollisionControllerImpl;
import model.enemy.Vehicle;
import model.enemy.VehicleImpl;
import model.player.PlayerMovement;
import model.player.PlayerMovementImpl;


public class TestCollision {

    /**
     * Test that verify the correct manageent of collisions.
     */
    @org.junit.Test
    public void testVehicles() {
        final PlayerMovement player = new PlayerMovementImpl("bird.png", 400, 600);
        final CollisionController cm = new CollisionControllerImpl(player);
        final Vehicle car1 = new VehicleImpl();
        car1.setCar(2.0);
        car1.setXLoc(400.0);
        car1.setYLoc(600.0);
        final Vehicle train1 = new VehicleImpl();
        train1.setTrain(10.0);
        train1.setXLoc(0.0);
        train1.setYLoc(600.0);

        assertTrue(cm.collideWithVehicles(car1));
        assertTrue(cm.collideWithVehicles(train1));

        final Vehicle car2 = new VehicleImpl();
        car2.setCar(2.0);
        car2.setXLoc(500.0);
        car2.setYLoc(600.0);
        final Vehicle train2 = new VehicleImpl();
        train2.setTrain(10.0);
        train2.setXLoc(400.0);
        train2.setYLoc(700.0);

        assertFalse(cm.collideWithVehicles(car2));
        assertFalse(cm.collideWithVehicles(train2));
    }

    public void testCoins() {
        
    }
}
