package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.enemy.VehicleImpl;
import model.enemy.VehicleType;


public class TestEnemy {
	
	private static final int VEHICLE_SCROLL = 1;
	private static final int CAR_SPEED = 2;
	private static final int CAMION_SPEED = 1;
	private static final int TRAIN_SPEED = 10;
	private static final int RANDOM_SPEED_ADDITION = 10;
	private static final int RANDOM_XLOCSPAWN_ADDITION = 1500;

	
	/**
     * This test verify the correct creation and working of the car.
     */
    @org.junit.Test
    public void testCar() {
    	VehicleImpl vehicle = new VehicleImpl();
    	vehicle.setCar(4);
    	assertEquals(4, vehicle.getVehicle().getYLoc());
    	assertEquals(VEHICLE_SCROLL, vehicle.getVehicle().getYDir());
    	assertTrue(vehicle.getVehicleType()==VehicleType.TRUCK || vehicle.getVehicleType()==VehicleType.CAR);
    	assertTrue(vehicle.getVehicleSpeed()>= CAMION_SPEED &&  vehicle.getVehicleSpeed() <= CAR_SPEED + RANDOM_SPEED_ADDITION );
    	assertTrue(vehicle.getVehicleXLocSpawn() >= CAMION_SPEED && vehicle.getVehicleXLocSpawn() <= CAR_SPEED * RANDOM_XLOCSPAWN_ADDITION );
    }

    

	/**
     * This test verify the correct creation and working of the train.
     */
    @org.junit.Test
    public void testTrain() {
    	VehicleImpl vehicle = new VehicleImpl();
    	vehicle.setTrain(4);
    	assertEquals(4, vehicle.getVehicle().getYLoc());
    	assertEquals(VEHICLE_SCROLL, vehicle.getVehicle().getYDir());
    	assertEquals(VehicleType.TRAIN, vehicle.getVehicleType());
    	assertTrue(vehicle.getVehicleSpeed()>= TRAIN_SPEED &&  vehicle.getVehicleSpeed() <= TRAIN_SPEED + RANDOM_SPEED_ADDITION );
    	assertTrue(vehicle.getVehicleXLocSpawn() >= TRAIN_SPEED && vehicle.getVehicleXLocSpawn() <= TRAIN_SPEED * RANDOM_XLOCSPAWN_ADDITION );
    }
    


}
