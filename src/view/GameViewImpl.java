package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.GameController;
import controllers.GameControllerImpl;
import controllers.PlayerController;
import controllers.PlayerControllerImpl;
import input.player.Input;
import input.player.InputImpl;

public class GameViewImpl implements GameView, KeyListener {

	private final int SIZE = 800;
	private GameControllerImpl gameC;
	private final JFrame frame;
	private panelGame panelGame = new panelGame();
	// this.frame.getContentPane().add(panelGame);
	private PlayerController inputPlayer= new PlayerControllerImpl();
    
	public GameViewImpl() {

		this.frame = new JFrame();

		this.frame.setTitle("Mockingbird");

		this.frame.setSize(this.SIZE, this.SIZE);

		this.frame.setLocationRelativeTo(null);
		
		this.frame.addKeyListener(this);
		
		this.frame.setLocationByPlatform(true);

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



	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("PERMUTO " + e.toString());
		this.inputPlayer.keyCatch(e);
		
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
