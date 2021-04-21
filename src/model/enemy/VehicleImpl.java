package model.enemy;

import java.util.Random;
import model.map.BoxImpl;

public class VehicleImpl implements Vehicle{
	
    private Random rand = new Random();

	public BoxImpl setCar(double stripYLoc) {

		BoxImpl car = new BoxImpl();
        car.setYDir(1);
        car.setYLoc(stripYLoc);
        this.rndDir(car, 900, 2, "Car_Left.png", "Car_Right.png");
        return car;
	}
	
	
	//TODO il treno dovrebbe essere piu box cosecutivi
	public BoxImpl setTrain(double stripYLoc) {

        BoxImpl train = new BoxImpl();
        train.setYDir(1);
        train.setYLoc(stripYLoc);
        this.rndDir(train, 900, 10, "Train.png", "Train.png"); //TODO togliere i numeri e le immagini	 HIGHER_LIMIT
        return train;
	}


	//settare le immagini da un'altra parte, non qui
	public void rndDir(BoxImpl vehicle, int pos, int speed, String imgDx, String imgSx) {

        if (rand.nextInt(2) == 1) {
            //Right to left.
        	vehicle.setXLoc(pos);
        	vehicle.setXDir(-(rand.nextInt(10) +  speed));
        	vehicle.setImage(imgDx);//da cambiare

        } else {
            //Left to right.
        	vehicle.setXLoc( pos-1100);
        	vehicle.setXDir((rand.nextInt(10) +  speed));
        	vehicle.setImage(imgSx);//da cambiare
        }

	}
	


}
