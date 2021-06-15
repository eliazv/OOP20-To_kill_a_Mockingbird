package input.player;

import java.awt.event.KeyEvent;

import controllers.GameController;
import controllers.GameControllerImpl;
import controllers.InGameMenuController;
import controllers.InGameMenuControllerImpl;
import model.player.Player;

public class InputImpl implements Input{

	private Player player;
	private InGameMenuController controllerMenu = new InGameMenuControllerImpl();
	private GameController gameController;
	public InputImpl(Player player, GameControllerImpl gameController) {
		this.player = player;
		this.gameController=gameController;
	}
	@Override
	public void keyInput(KeyEvent e) {
	//#System.out.println("sono quiiiiiiiiii");
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: 
			this.player.goUp();
			gameController.setScore(gameController.getScore()+1);
			System.out.println("score: " + gameController.getScore());

			break;
		case KeyEvent.VK_DOWN:
			this.player.goDown();
			gameController.setScore(gameController.getScore()-1);
			break;
		case KeyEvent.VK_LEFT:
			this.player.goleft();
			break;
		case KeyEvent.VK_RIGHT:
			this.player.goRight();
			break;
		default:
			break;
		}
		
		if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {
			controllerMenu.setup();
		}
		
		
	}

}
