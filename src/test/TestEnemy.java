package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.enemy.VehicleImpl;


public class TestEnemy {
	
	private static final double VEHICLE_SCROLL = 1;
	
	
	
	
	/**
     * This test verify the correct creation and working of the car.
     */
    @org.junit.Test
    public void testCar() {
    	VehicleImpl vehicle = new VehicleImpl();
    	vehicle.setCar(4);
    	assertEquals(4, vehicle.getVehicle().getYLoc());
    	assertEquals(VEHICLE_SCROLL, vehicle.getVehicle().getYDir());
    	
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
    	
    }
    


}
