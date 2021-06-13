package input.player;

import java.awt.event.KeyEvent;

import controllers.GameController;
import controllers.GameControllerImpl;
import controllers.InGameMenuController;
import controllers.InGameMenuControllerImpl;
import model.player.Player;
import model.player.PlayerMovement;
import model.player.PlayerMovementImpl;

public class InputImpl implements Input{

	private PlayerMovement moves;
	private InGameMenuController controllerMenu = new InGameMenuControllerImpl();
	private GameController gameController = new GameControllerImpl();
	public InputImpl(Player player) {
		this.moves = new PlayerMovementImpl(player.getImage(), player.getXPos(), player.getYPos());
	}
	@Override
	public void keyInput(KeyEvent e) {
		System.out.println("sono quiiiiiiiiii");
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: 
			this.moves.goUp();
			gameController.setScore(gameController.getScore()+1);
			System.out.println("score: " + gameController.getScore());

			break;
		case KeyEvent.VK_DOWN:
			this.moves.goDown();
			gameController.setScore(gameController.getScore()-1);
			break;
		case KeyEvent.VK_LEFT:
			this.moves.goleft();
			break;
		case KeyEvent.VK_RIGHT:
			this.moves.goRight();
			break;
		default:
			break;
		}
		
		if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
			controllerMenu.setup();
		}
		
		
	}

}
