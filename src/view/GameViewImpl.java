package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import controllers.GameControllerImpl;
import controllers.PlayerController;
import controllers.PlayerControllerImpl;
import model.enemy.Vehicle;
import model.enemy.VehicleImpl;
import model.map.Box;
import model.map.BoxImpl;
import model.map.Strip;
import model.map.StripImpl;
import model.player.Player;
import model.player.PlayerImpl;

public class GameViewImpl implements GameView,KeyListener {

	private final int SIZE = 800;
	private final JFrame frame;
	private panelGame panelGame;
	private PlayerController controller = new PlayerControllerImpl();

	public GameViewImpl() {
		
		this.panelGame = new panelGame();
		
		this.frame = new JFrame();
		
		this.frame.addKeyListener(this);
		
		this.frame.getContentPane().add(panelGame);
		
		this.frame.setTitle("Mockingbird");

		this.frame.setSize(this.SIZE, this.SIZE);

		this.frame.setLocationRelativeTo(null);

		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frame.setResizable(false);

		this.frame.setVisible(true);
		
	}

	
	
	public class panelGame extends JPanel implements ActionListener{

		private static final long serialVersionUID = 1L;
		protected int NSTRIP = 11;
		protected int iriga = 11;
		protected int BOXFORSTRIP = 8;
		protected int TIMER_DELAY = 10;
		protected int SPAWN_CHARACTER_LINE = 4;

		private Strip striscia = new StripImpl();
		private Box[][] allStrips = new BoxImpl[NSTRIP][BOXFORSTRIP];
		private Player player = new PlayerImpl("bird.png",400,600);

		private ArrayList<Box> cars = new ArrayList<>();
		private ArrayList<Box> trains = new ArrayList<>();
		private Vehicle vehicleManager = new VehicleImpl();
		private Timer timer;
		
		private GameControllerImpl gameController;
		
		public panelGame()  {
			
			this.gameController = new GameControllerImpl() ;
			
			this.timer = new Timer(this.TIMER_DELAY, this);
			
			this.SetInitialPosition();
			
			this.repaint();
			
			this.timer.start();
		}
		
		public void paintComponent(Graphics g) {

			super.paintComponent(g); // Erases the previous screen.

			// Draws strips.
			for (int i = 0; i < NSTRIP; i++) {
				for (int x = 0; x < BOXFORSTRIP; x++) {
					allStrips[i][x].paint(g, this);
				}
			}

			for (Box s : cars) // da fare un metodo ma problemi con paint
				s.paint(g, this);

			for (Box s : trains)
				s.paint(g, this);

			
			this.player.paint(g, this);
		}
		

	     /**
	 	 * Set the initial landscape without vehicles
	 	 */
	    public void SetInitialPosition() {

	    	
	        for (int i = 0; i < NSTRIP; i++) {

	        	
	        	
	            /**
	             * Set the line where the character will be spawn and the next one without any obstacles 
	             */
	            if(i==SPAWN_CHARACTER_LINE|| i == SPAWN_CHARACTER_LINE + 1) {
	                allStrips[i] = striscia.getSpecificStrip("Grass.png", i);
	            }

	            else {
	                allStrips[i] = striscia.getSpecificStrip("Grass.png", "Tree.png", i);
	                vehicleManager.checkOnRoad(allStrips, cars, trains, i);
	            }

	        }
	        
	    }
		
		public void generateMap() {

			for (int i = 0; i < NSTRIP; i++) {
				if (allStrips[i][0].getYLoc() > 800) {
					allStrips[i] = striscia.setRndStrip(iriga);
					vehicleManager.checkOnRoad(allStrips, cars, trains, i);
				}
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			this.repaint();
			this.generateMap();
			this.gameController.actionPerformed(this.allStrips, this.vehicleManager, this.cars, this.trains);
			
		}
	}



	@Override
	public void keyPressed(KeyEvent e) {
		this.controller.keyCatch(e);
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
