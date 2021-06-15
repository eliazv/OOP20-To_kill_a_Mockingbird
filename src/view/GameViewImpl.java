package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controllers.GameControllerImpl;
import model.enemy.Vehicle;
import model.enemy.VehicleImpl;
import model.map.Box;
import model.map.Strip;
import model.map.StripImpl;
import model.score.Coin;

public class GameViewImpl implements GameView, KeyListener {

	private final int SIZE = 800;
	private final JFrame frame;
	private panelGame panelGame;
	

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

	public class panelGame extends JPanel implements ActionListener {

		private static final long serialVersionUID = 1L;
		protected int NSTRIP = 11;
		protected int iriga = 11;
		protected int BOXFORSTRIP = 8;
		protected int TIMER_DELAY = 10;
		protected int SPAWN_CHARACTER_LINE = 4;
		protected int COIN_SPAWN_PROB = 2;

	    private final Rectangle rlblCoinCounter;
	    private final JLabel lblCoinCounter = new JLabel();
		private Strip striscia = new StripImpl();
		private ArrayList<ArrayList<Box>> allStrip = new ArrayList<ArrayList<Box>>();
		

		private ArrayList<Vehicle> VehiclesOnRaod = new ArrayList<>();
		private ArrayList<Vehicle> trains = new ArrayList<>();
		private Vehicle vehicleManager = new VehicleImpl();

		private ArrayList<Coin> coins = new ArrayList<>();

		private Timer timer;

		private GameControllerImpl gameController;

		public panelGame() {

			this.gameController = new GameControllerImpl();

			this.timer = new Timer(this.TIMER_DELAY, this);

			this.SetInitialPosition();

			this.repaint();

			this.add(lblCoinCounter);
			lblCoinCounter.setText("Score: 0");
		    lblCoinCounter.setForeground(Color.white);
		    lblCoinCounter.setFont(new Font("Helvetica", Font.ITALIC, 40));
		    rlblCoinCounter = new Rectangle(10,10,30,30);
		    lblCoinCounter.setBounds(rlblCoinCounter);
		    
			this.timer.start();
		}

		/**
		 * 
		 */
		public void paintComponent(Graphics g) {

			/**
			 * Erases the previous screen.
			 */
			super.paintComponent(g);

			/**
			 * Draws strips.
			 */
			for (int i = 0; i < NSTRIP; i++) {
				for (int x = 0; x < BOXFORSTRIP; x++) {
					this.allStrip.get(i).get(x).paint(g, this);
				}
			}

			/**
			 * Draws vehicles.
			 */
			this.coins.forEach(v -> v.paint(g, this));
			this.VehiclesOnRaod.forEach(v -> v.paint(g, this));
			this.trains.forEach(v -> v.paint(g, this));
			

			this.gameController.getPlayer().paint(g, this);
		
			System.out.println(gameController.getScore());
			lblCoinCounter.setText("Score: " + gameController.getScore());

		}

		/**
		 * Set the initial landscape without vehicles
		 */
		public void SetInitialPosition() {
			for (int i = 0; i < NSTRIP; i++) {
				/**
				 * Set the line where the character will be spawn and the next one without any
				 * obstacles
				 */
				if (i == SPAWN_CHARACTER_LINE || i == SPAWN_CHARACTER_LINE + 1) {
					this.allStrip.add(this.striscia.getSpecificStrip("Grass.png", i));
				}

				else {
					this.allStrip.add(this.striscia.getSpecificStrip("Grass.png", "Tree.png", i));
					this.gameController.checkOnRoad(this.allStrip, this.VehiclesOnRaod, this.trains, i);
				}
			}
		}

		/**
		 * 
		 */
		public void generateMap() {
			Random rndYLoc = new Random();
			int coinSpawn;
			for (int i = 0; i < NSTRIP; i++) {
				if (allStrip.get(i).get(0).getYLoc() > 800) {
					coinSpawn = rndYLoc.nextInt(this.COIN_SPAWN_PROB + 1);
					
					this.allStrip.set(i, this.striscia.getRndStrip(this.iriga));
					this.gameController.checkOnRoad(this.allStrip, this.VehiclesOnRaod, this.trains, i);
					
					if (coinSpawn == this.COIN_SPAWN_PROB) {
						this.gameController.spawnCoin(this.allStrip, this.coins, i, rndYLoc.nextInt(this.BOXFORSTRIP));
					}
					
				}
			}
			
			

		}
		
		@Override
		public void actionPerformed(ActionEvent e) {

			this.repaint();
			this.generateMap();
			this.gameController.actionPerformed(this.allStrip, this.vehicleManager, this.VehiclesOnRaod, this.coins,
					this.trains);
			

		}
		
		public GameControllerImpl getGameController() {
			return this.gameController;
		} 
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		panelGame.getGameController().keyCatch(e);
		

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
