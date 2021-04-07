package map;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class MapGenerator  extends JPanel  {

    private static final long serialVersionUID = 1L;
    protected int NSTRIP = 9; 				//numero di righe, 9 perche cosi carica quella nuova?
	protected int BOXFORSTRIP = 8;			//numero di box per ogni strip
	private Strip striscia = new Strip();
	private Box[][] allStrips = new Box[NSTRIP][BOXFORSTRIP];
		
	public MapGenerator() {
		//Initializes game with land strips.
		for (int i = 0; i < NSTRIP; i++) {
			allStrips[i] = striscia.getSpecificStrip("Grass.png");
			//allStrips[i] = striscia.getStrip();			
		}
		this.repaint();
	}

	
	public void paintComponent(Graphics g) {
		//Erases the previous screen.
		super.paintComponent(g);

		//Draws strips.
		for (int i = 0; i < NSTRIP; i++) {
			for (int x = 0; x < BOXFORSTRIP; x++) {
				allStrips[i][x].paint(g, this);
			}
		}

	}


}
	






