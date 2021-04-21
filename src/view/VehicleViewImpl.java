package view;

import java.util.ArrayList;

import model.map.BoxImpl;

public class VehicleViewImpl {
	public int HIGHER_LIMIT = 900;
	public int INFERIOR_LIMIT = -100;
	protected int SPEED_MOLTIPLICATOR=30;
	
	public void moveVehicle(ArrayList<BoxImpl> vehicles) {
		for(BoxImpl s : vehicles) {
			s.move();
		}
	}
	
	
	public void restartVehicle(ArrayList<BoxImpl> vehicles, int delay)  { 
		for(BoxImpl s : vehicles) {
			if(s.getXLoc() > HIGHER_LIMIT && s.getXDir()>0) {
				s.setXLoc(-(s.getXDir() ) *SPEED_MOLTIPLICATOR - delay/2);//DA TOGLIERE IL /2
			}
			
			else if(s.getXLoc() < INFERIOR_LIMIT && s.getXDir()<0) {
				s.setXLoc((s.getXDir())*SPEED_MOLTIPLICATOR + delay  );
			}
			
			//TODO rimuovi se y >800 rimuovere veicoli fuori dalla mappa in basso
		}
	}
}
