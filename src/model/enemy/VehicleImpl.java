package model.enemy;

import java.util.ArrayList;
import java.util.Random;

import model.map.BoxImpl;

public class VehicleImpl implements Vehicle {

	private static final double VEHICLE_SCROLL = 1;
	private static final int HIGHER_LIMIT = 900;
	private static final int INFERIOR_LIMIT = -100;
	private static final int SPEED_MOLTIPLICATOR = 30;
	private static final int ADJUST_ON_ROAD = 10;
	private static final int CAR_SPEED = 2;
	private static final int CAMION_SPEED = 1;
	private static final int TRAIN_SPEED = 10;
	private Random rand = new Random();
	
	// private static final double SCREEN_WIDTH =
	// Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	// private static final double SCREEN_HEIGHT =
	// Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	private int vehicleSpeed = 0;
	private int vehicleXLocSpawn;
	BoxImpl vehicle;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void moveVehicle(ArrayList<BoxImpl> vehicles) {
		vehicles.forEach(v -> v.move());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void restartVehicle(ArrayList<BoxImpl> vehicles, int delay) {
		for (BoxImpl s : vehicles) {
			
			if (s.getXLoc() > (HIGHER_LIMIT + s.getImage().getImgWidth()) && s.getXDir() > 0) {
				s.setXLoc(-(s.getXDir()) * SPEED_MOLTIPLICATOR - delay / 2);//togli il /2
			}

			else if (s.getXLoc() < (INFERIOR_LIMIT - s.getImage().getImgWidth()) && s.getXDir() < 0) {
				s.setXLoc((s.getXDir()) * SPEED_MOLTIPLICATOR + delay);
			}

			// TODO rimuovi se y >800 rimuovere veicoli fuori dalla mappa in
			// basso
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BoxImpl setCar(double stripYLoc) {

		vehicle = new BoxImpl();
		vehicle.setYDir(VEHICLE_SCROLL);
		vehicle.setYLoc(stripYLoc);
		
		if (rand.nextInt(2) == 1) {
			this.setRndDir(vehicle, CAR_SPEED, "Car_Left.png", "Car_Right.png");
		}
		
		else {
			this.setRndDir(vehicle, CAMION_SPEED, "Camion_L.png", "Camion_R.png");
		}
		return vehicle;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	// TODO il treno dovrebbe essere piu box cosecutivi
	public BoxImpl setTrain(double stripYLoc) {

		vehicle = new BoxImpl();
		vehicle.setYDir(VEHICLE_SCROLL);
		vehicle.setYLoc(stripYLoc);
		this.setRndDir(vehicle, TRAIN_SPEED, "Train.png", "Train.png"); // TODO togliere le
																// immagini
		return vehicle;
	}

	/**
     * {@inheritDoc}
     */
    @Override
	//TODO settare le immagini da un'altra parte, non qui
	public void setRndDir(BoxImpl vehicle, int speed, String imgR,
			String imgL) {

    	vehicleSpeed = rand.nextInt(10) + speed;
    	vehicleXLocSpawn = rand.nextInt(1500) * speed;
    	
    	/**
         * Sets the direction from right to left.
         */
		if (rand.nextInt(2) == 1) {
			vehicle.setXLoc(vehicleXLocSpawn + HIGHER_LIMIT);
			vehicle.setXDir(-(vehicleSpeed));
			vehicle.setImage(imgR);
			
		/**
         * Sets the direction from left to right.
         */
		} else {
			vehicle.setXLoc((-vehicleXLocSpawn - INFERIOR_LIMIT));
			vehicle.setXDir((vehicleSpeed));
			vehicle.setImage(imgL);
		}
	}

    
    //da fare test
    public int getSpeed() {
    	return vehicleSpeed;
    }
    
    
    //dovrebbe essere pair
    public BoxImpl getVehicle() {
    	return vehicle;
    }
    
    
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void checkOnRoad(BoxImpl[][] allStrips, ArrayList<BoxImpl> cars, ArrayList<BoxImpl> trains, int i) {
		this.carOnRoad(allStrips, cars, i);
		this.trainOnRoad(allStrips, trains, i);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void carOnRoad(BoxImpl[][] allStrips, ArrayList<BoxImpl> cars, int i) {
		if (allStrips[i][0].getImage().getFileName().equals("Road.png")) {
			cars.add(this.setCar(allStrips[i][0].getYLoc() + ADJUST_ON_ROAD));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void trainOnRoad(BoxImpl[][] allStrips, ArrayList<BoxImpl> trains, int i) {
		if (allStrips[i][0].getImage().getFileName().equals("Rail.png")) {
			trains.add(this.setTrain(allStrips[i][0].getYLoc() + ADJUST_ON_ROAD));

		}
	}

}
