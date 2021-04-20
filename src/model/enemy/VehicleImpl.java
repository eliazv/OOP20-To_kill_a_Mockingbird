package model.enemy;

import java.util.Random;

import model.map.BoxImpl;

public class VehicleImpl implements Vehicle{

	
    private Random rand = new Random();

	public BoxImpl setCar(double stripYLoc) {

		//Nel view
		BoxImpl car = new BoxImpl();

        //Scrolls sprite.
        car.setYDir(1);

        //Set sprite to strip location.
        car.setYLoc(stripYLoc);
        

        if (rand.nextInt(2) == 1) {
            //Right to left.
            car.setXLoc(900);
            car.setXDir(-(rand.nextInt(10) + 2));
            car.setImage("Car_Left.png");

        } else {
            //Left to right.
            car.setXLoc(-200);
            car.setXDir((rand.nextInt(10) + 2));
            car.setImage("Car_Right.png");
        }

  
        return car;
	}
	
	
	//TODO il treno dovrebbe essere piu box cosecutivi
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

	//ancora da implemnt
	public void rndDir(BoxImpl vehicle, int pos, int speed) {

        if (rand.nextInt(2) == 1) {
            //Right to left.
        	vehicle.setXLoc( pos);
        	vehicle.setXDir(-(rand.nextInt(10) +  speed));
        	vehicle.setImage("Car_Left.png");//da cambiare

        } else {
            //Left to right.
        	vehicle.setXLoc( pos-1100);
        	vehicle.setXDir((rand.nextInt(10) +  speed));
        	vehicle.setImage("Car_Right.png");//da cambiare
        }

	}
	


}
