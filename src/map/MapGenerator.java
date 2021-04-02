package map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MapGenerator  extends JPanel implements ActionListener {
	
	private int NSTRIP = 9; 	//numero di righe, 9 perche cosi carica quella nuova?
	private int BOXFORSTRIP = 8;	//numero di box per ogni strip, serve?
	private Strip striscia = new Strip();
	private Box[][] allStrips = new Box[NSTRIP][BOXFORSTRIP];
	
	//private JButton startButton = new JButton(new ImageIcon(getClass().getResource("/Mockingbird/resources/Tracks.png")));
	
	public MapGenerator() {
		//Initializes game with land strips.
		for (int i = 0; i < NSTRIP; i++) {

			//Creates a new land sprite strip.
			Box[] strip = striscia.getSpecificStrip("/Mockingbird/resources/Grass.png","/Mockingbird/resources/Tree_One.png");

			//Adds sprite strip to strips array.
			allStrips[i] = strip;
		}

	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}


