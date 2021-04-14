package model.enemy;

import java.util.Random;

import model.map.BoxImpl;

public class VehicleImpl implements Vehicle{

	
    private Random rand = new Random();

	public BoxImpl setCar(int stripYLoc) {

        //Makes sprite.
        BoxImpl car = new BoxImpl("Car.png");

        //Scrolls sprite.
        car.setYDir(2);

        //Set sprite to strip location.
        car.setYLoc(stripYLoc);
        
        //random per settare se arrivano da sestra o sinistra
        car.setXLoc(700);
        car.setXDir(-(rand.nextInt(10) + 10)); //velocità casuale
        
        return car;
	}
	
	public BoxImpl setTrain(int stripYLoc) {

        //Makes sprite.
        BoxImpl train = new BoxImpl("Train.png");

        //Scrolls sprite.
        train.setYDir(2);

        //Set sprite to strip location.
        train.setYLoc(stripYLoc);
        
        
        train.setXLoc(500);
        train.setXDir(-(rand.nextInt(10) + 30));
        
        return train;
	}
	

}
