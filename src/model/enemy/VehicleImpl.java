package model.enemy;

import java.util.Random;

import model.map.BoxImpl;

public class VehicleImpl implements Vehicle{

	
    private Random rand = new Random();

	public BoxImpl setCar(double stripYLoc) {

		//Nel view
        BoxImpl car = new BoxImpl("Car.png");

        //Scrolls sprite.
        car.setYDir(1);

        //Set sprite to strip location.
        car.setYLoc(stripYLoc);
        
        //random per settare se arrivano da sestra o sinistra
        if (rand.nextInt(2) == 1) {
            //Right to left.
            car.setXLoc(900);
            car.setXDir(-(rand.nextInt(10) + 2));

        } else {
            //Left to right.
            car.setXLoc(-200);
            car.setXDir((rand.nextInt(10) + 2));
        }

        //car.setXLoc(700);
        //car.setXDir(-(rand.nextInt(10) + 2)); //velocità casuale
        
        return car;
	}
	
	public BoxImpl setTrain(double stripYLoc) {

        //Nel view
        BoxImpl train = new BoxImpl("Train.png");

        //Scrolls sprite.
        train.setYDir(1);

        //Set sprite to strip location.
        train.setYLoc(stripYLoc);
        
        
        if (rand.nextInt(2) == 1) {
            //Right to left.
            train.setXLoc(900);
            train.setXDir(-(rand.nextInt(10) + 10));
        } else {
            //Left to right.
            train.setXLoc(-1500);
            train.setXDir((rand.nextInt(10) + 10));
        }

        
        return train;
	}
	
	

}
