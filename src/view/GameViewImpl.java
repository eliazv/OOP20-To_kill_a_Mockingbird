package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.GameController;
import controllers.GameControllerImpl;

public class GameViewImpl implements GameView {

	private final int SIZE = 800;
	private GameControllerImpl gameC;
	private final JFrame frame;
	private panelGame panelGame = new panelGame();
	// this.frame.getContentPane().add(panelGame);

	public GameViewImpl() {

		this.frame = new JFrame();

		this.frame.setTitle("Mockingbird");

		this.frame.setSize(this.SIZE, this.SIZE);

		this.frame.setLocationRelativeTo(null);

		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frame.setResizable(false);

		this.frame.setVisible(true);

		this.frame.getContentPane().add(new GameControllerImpl());

		
	}

	
	
	class panelGame extends JPanel {

		private static final long serialVersionUID = 1L;

		public panelGame()  {



		}
	}
}
