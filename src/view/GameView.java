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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controllers.GameControllerImpl;
import model.enemy.Vehicle;
import model.enemy.VehicleImpl;
import model.map.Box;
import model.score.Coin;

/**
 * 
 *
 */
public class GameView  implements  KeyListener, View {

	/**
	 * constants.
	 */
	private static final int SIZE = 800;
	
	/**
	 * 	local variables.
	 */
	private JFrame frame;
	private panelGame panelGame;
	private GameView gv = this;
	
	@Override
	public void setup() {

		this.panelGame = new panelGame();
		this.frame = new JFrame();
		this.frame.addKeyListener(this);
		this.frame.getContentPane().add(panelGame);
		this.frame.setTitle("Mockingbird");
		this.frame.setSize(SIZE, SIZE);
		this.frame.setLocationRelativeTo(null);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setVisible(true);
		
	}

	public class panelGame extends JPanel implements ActionListener {

		private static final long serialVersionUID = 1L;
		private static final int NSTRIP = 11;
		private static final int BOXFORSTRIP = 8;
		private final int TIMER_DELAY = 10;


	    private final Rectangle rlblCoinCounter;
	    private final JLabel lblCoinCounter = new JLabel();
		private ArrayList<ArrayList<Box>> allStrip = new ArrayList<ArrayList<Box>>();
		

		private ArrayList<Vehicle> VehiclesOnRoad = new ArrayList<>();
		private ArrayList<Vehicle> Trains = new ArrayList<>();
		private Vehicle vehicleManager = new VehicleImpl();
		private ArrayList<Coin> coins = new ArrayList<>();

		private Timer timer;

		private GameControllerImpl gameController;
		
		
		public panelGame() {
			
			gameController = new GameControllerImpl(gv);
			
			gameController.setup();

			this.timer = new Timer(this.TIMER_DELAY, this);

			gameController.SetInitialPosition(allStrip, VehiclesOnRoad, Trains);

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
			this.VehiclesOnRoad.forEach(v -> v.paint(g, this));
			this.Trains.forEach(v -> v.paint(g, this));
			

			gameController.getPlayer().paint(g, this);
			lblCoinCounter.setText("Score: " + gameController.getScore());
		}

		
		@Override
		public void actionPerformed(ActionEvent e) {

			this.repaint();
			gameController.generateMap(allStrip, VehiclesOnRoad,Trains,coins);
			gameController.actionPerformed(this.allStrip, this.vehicleManager, this.VehiclesOnRoad, this.coins,
					this.Trains);
		}
		
		public GameControllerImpl getGameController() {
			return gameController;
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
	
	/**
	 * 
	 */
	@Override
	public void exit() {
		this.frame.dispose();
	}


}
