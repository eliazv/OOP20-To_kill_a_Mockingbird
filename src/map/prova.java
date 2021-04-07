package map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class prova {
	//prova di stampa di immagini
	
	
	public static void main(String[] args) throws Exception {
		JFrame w = new JFrame("prova");
		w.setLocation(300, 300);
		w.setSize(315,238);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//w.setResizable(false);
		
		
		BufferedImage img = ImageIO.read(prova.class.getClassLoader().getResourceAsStream("Tracks.png"));
		BufferedImage img2 = ImageIO.read(prova.class.getClassLoader().getResourceAsStream("Grass.png"));
		BufferedImage bird = ImageIO.read(prova.class.getClassLoader().getResourceAsStream("bird.png"));
		
		JPanel p =new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, 100,100, null);
				g.drawImage(img2, 100, 0, 100,100, null);
				g.drawImage(img2, 0, 100, 100,100, null);
				g.drawImage(bird, 0, 100, 100,100, null);
			}
		};
		w.add(p);
		w.setVisible(true);
	}
}
