package model.enemy;

import java.util.ArrayList;
import java.util.Random;
import model.map.BoxImpl;

public class VehicleImpl implements Vehicle{
	
    private Random rand = new Random();
    public int HIGHER_LIMIT = 900;
	public int INFERIOR_LIMIT = -100;
	protected int SPEED_MOLTIPLICATOR=30;
	//private static final double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	
	public void moveVehicle(ArrayList<BoxImpl> vehicles) {
		for(BoxImpl s : vehicles) {
			s.move();
		}
	}
	
	
	public void restartVehicle(ArrayList<BoxImpl> vehicles, int delay)  { 
		for(BoxImpl s : vehicles) {
			if(s.getXLoc() > (HIGHER_LIMIT + s.getImgWidth())  && s.getXDir()>0) {
				s.setXLoc(-(s.getXDir() ) *SPEED_MOLTIPLICATOR - delay/2);//DA TOGLIERE IL /2
			}
			
			else if(s.getXLoc() < (INFERIOR_LIMIT - s.getImgWidth()) && s.getXDir()<0) {
				s.setXLoc((s.getXDir())*SPEED_MOLTIPLICATOR + delay  );
			}
			
			//TODO rimuovi se y >800 rimuovere veicoli fuori dalla mappa in basso
		}
	}

	
	public BoxImpl setCar(double stripYLoc) {

		BoxImpl car = new BoxImpl();
        car.setYDir(1);
        car.setYLoc(stripYLoc);
        this.setRndDir(car, 2, "Car_Left.png", "Car_Right.png");
        return car;
	}
	
	
	//TODO il treno dovrebbe essere piu box cosecutivi
	public BoxImpl setTrain(double stripYLoc) {

        BoxImpl train = new BoxImpl();
        train.setYDir(1);
        train.setYLoc(stripYLoc);
        this.setRndDir(train, 10, "Train.png", "Train.png"); //TODO togliere le immagini	
        return train;
	}
	

	//TODO settare le immagini da un'altra parte, non qui
	public void setRndDir(BoxImpl vehicle,int speed, String imgR, String imgL) {

        if (rand.nextInt(2) == 1) {           						//Right to left.
        	vehicle.setXLoc((rand.nextInt(1500)*speed) + HIGHER_LIMIT);
        	vehicle.setXDir(-(rand.nextInt(10) +  speed));
        	vehicle.setImage(imgR);

        } else {           											//Left to right.
        	vehicle.setXLoc((-(rand.nextInt(1500)*speed) - INFERIOR_LIMIT));
        	vehicle.setXDir((rand.nextInt(10) +  speed));
        	vehicle.setImage(imgL);
        }

	}	
	
	
	
	public void checkOnRoad(BoxImpl[][] allStrips, ArrayList<BoxImpl> cars, ArrayList<BoxImpl> trains,  int i) {
		this.carOnRoad(allStrips, cars, i);
		this.trainOnRoad(allStrips, trains, i);
	}
	
	public void carOnRoad(BoxImpl[][] allStrips, ArrayList<BoxImpl> cars, int i) {
		if (allStrips[i][0].getFileName().equals("Road.png")) {
			cars.add(this.setCar(allStrips[i][0].getYLoc()));//+10 tolto ma serviva?
		}
	}
	public void trainOnRoad(BoxImpl[][] allStrips, ArrayList<BoxImpl> trains, int i) {
		if (allStrips[i][0].getFileName().equals("Rail.png")) {
			trains.add(this.setTrain(allStrips[i][0].getYLoc() ));//+10 tolto ma serviva?
			
		}
	}


}
