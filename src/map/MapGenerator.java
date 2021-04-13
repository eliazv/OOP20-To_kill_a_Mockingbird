package map;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import enemy.Vehicle;

public class MapGenerator extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	

	protected int NSTRIP = 19; // numero di righe da stampare 
	protected int BOXFORSTRIP = 8; // numero di box per ogni strip (n colonne)
	protected int TIMER_DELAY = 10;

	private Strip striscia = new Strip();
	private Box[][] allStrips = new Box[NSTRIP][BOXFORSTRIP];
	private Timer timer;
	//private Box bird;
	
	//veicoli ma non stampa
	private ArrayList<Box> cars = new ArrayList<>();
	private ArrayList<Box> trains = new ArrayList<>();
	private Vehicle veicoli = new Vehicle();
	
	

	public MapGenerator() throws IOException {

		this.timer = new Timer(this.TIMER_DELAY, this);

		this.SetInitialPosition();

		this.setDoubleBuffered(true);

		this.timer.start();

		this.repaint();
	}

	public void paintComponent(Graphics g) {
		// Erases the previous screen.
		super.paintComponent(g);

		// Draws strips.
		for (int i = 0; i < NSTRIP; i++) {
			for (int x = 0; x < BOXFORSTRIP; x++) {
				allStrips[i][x].paint(g, this);
			}
		}
		
		//draw vehicles NON FUNZIONA
		for (Box s : cars)
			s.paint(g, this);

		for (Box s : trains)
			s.paint(g, this);
		
		//this.bird.paint(g, this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < this.NSTRIP; i++) {
			for (int x = 0; x < this.BOXFORSTRIP; x++) {
				allStrips[i][x].move();
			}
		}

		this.scroolScren();
		
		this.repaint();

	}
	
	public void SetInitialPosition() {
		
		//this.bird.setXLoc(258);
		//this.bird.setYLoc(300);
		
		for (int i = 0; i < NSTRIP; i++) {

			allStrips[i] = striscia.getStrip(i);
			
			
			//Set vehicles NON FUNZIONA
			if (allStrips[i][0].getFileName().equals("Misc/Road.png")){
			    cars.add(veicoli.setCar(allStrips[i][0].getYLoc() + 10));
			}
			
	        if (allStrips[i][0].getFileName().equals("Misc/Tracks.png")) {
	            trains.add(veicoli.setTrain(allStrips[i][0].getYLoc() + 10));
	        }
	        
		}
		
	}
	
	
	private void scroolScren() {
		for (int v = 0; v < this.NSTRIP; v++) {
			for (int x = 0; x < this.BOXFORSTRIP; x++) {
				allStrips[v][x].setYDir(1);
			}
		}
	}

}
