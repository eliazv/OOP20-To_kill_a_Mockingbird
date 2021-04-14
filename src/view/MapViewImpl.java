package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.enemy.Vehicle;
import model.enemy.VehicleImpl;
import model.map.BoxImpl;
import model.map.Strip;

public class MapViewImpl extends JPanel implements ActionListener, MapView {

	private static final long serialVersionUID = 1L;

	protected int NSTRIP = 19; // numero di righe da stampare
	protected int BOXFORSTRIP = 8; // numero di box per ogni strip (n
									// colonne)
	protected int TIMER_DELAY = 10;

	private Strip striscia = new Strip();
	private BoxImpl[][] allStrips = new BoxImpl[NSTRIP][BOXFORSTRIP];
	private Timer timer;

	private ArrayList<BoxImpl> cars = new ArrayList<>();
	private ArrayList<BoxImpl> trains = new ArrayList<>();
	private Vehicle veicoli = new VehicleImpl();

	public MapViewImpl() throws IOException {

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

		for (BoxImpl s : cars)
			s.paint(g, this);

		for (BoxImpl s : trains)
			s.paint(g, this);

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

		for (int i = 0; i < NSTRIP; i++) {

			allStrips[i] = striscia.getStrip(i);

			if (allStrips[i][0].getFileName().equals("Road.png")) {
				cars.add(veicoli.setCar(allStrips[i][0].getYLoc() + 10));
			}

			if (allStrips[i][0].getFileName().equals("Tracks.png")) {
				trains.add(veicoli.setTrain(allStrips[i][0].getYLoc() + 10));
			}

		}

	}

	public void scroolScren() {
		for (int v = 0; v < this.NSTRIP; v++) {
			// TODO cicla cars e trains qui
			for (int x = 0; x < this.BOXFORSTRIP; x++) {
				allStrips[v][x].setYDir(1);
			}
		}
	}

}