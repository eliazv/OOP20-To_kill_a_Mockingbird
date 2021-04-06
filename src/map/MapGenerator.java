package map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MapGenerator  extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private int NSTRIP = 9; 		//numero di righe, 9 perche cosi carica quella nuova?
	private int BOXFORSTRIP = 8;	//numero di box per ogni strip, serve?
	private Strip striscia = new Strip();
	private Box[][] allStrips = new Box[NSTRIP][BOXFORSTRIP];
		
	public MapGenerator() {
		//Initializes game with land strips.
		for (int i = 0; i < NSTRIP; i++) {
			//allStrips[i] = striscia.getSpecificStrip("/Mockingbird/resources/Grass.png","/Mockingbird/resources/Tree_One.png");
			allStrips[i] = striscia.getStrip();
		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	
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
		
		repaint();
	}
	
}
	






