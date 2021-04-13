package enemy;

import java.util.Random;

import map.Box;

public class Vehicle {
	
    private Random rand = new Random();

	public Box setCar(int stripYLoc) {

        //Makes sprite.
        Box car = new Box("Car.png");

        //Scrolls sprite.
        car.setYDir(2);

        //Set sprite to strip location.
        car.setYLoc(stripYLoc);
        
        //random per settare se arrivano da sestra o sinistra
        car.setXLoc(700);
        //car.setXDir(-(rand.nextInt(10) + 10)); //velocità casuale
        
        return car;
	}
	
	public Box setTrain(int stripYLoc) {

        //Makes sprite.
        Box train = new Box("Train.png");

        //Scrolls sprite.
        train.setYDir(2);

        //Set sprite to strip location.
        train.setYLoc(stripYLoc);
        
        
        train.setXLoc(500);
        //train.setXDir(-(rand.nextInt(10) + 30));
        
        return train;
	}
	

}
