package input.player;

import java.awt.event.KeyEvent;

import controllers.CollisionController;
import controllers.GameController;
import controllers.GameControllerImpl;
import controllers.InGameMenuController;
import controllers.InGameMenuControllerImpl;
import model.player.PlayerMovement;

import controllers.CollisionController.Directions;

public class InputImpl implements Input{
	
	private PlayerMovement player;
	private InGameMenuController controllerMenu = new InGameMenuControllerImpl();
	private GameController gameController;
	private CollisionController collisionController;
	
	public InputImpl(GameControllerImpl gameController) {
		this.player = gameController.getPlayer();
		this.gameController = gameController;
		this.collisionController = gameController.getCollisionController();
	}
	@Override
	public void keyInput(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: 
			if (collisionController.checkDir(Directions.UP)) {
				this.player.goUp();
				gameController.setScore(gameController.getRealScore()+1);
			}
			break;
			
		case KeyEvent.VK_DOWN:
			if (collisionController.checkDir(Directions.DOWN)) {
				this.player.goDown();
				gameController.setScore(gameController.getRealScore()-1);
			}
			break;
			
		case KeyEvent.VK_LEFT:
			if (collisionController.checkDir(Directions.LEFT)) {
				this.player.goLeft();
			}
			break;
			
		case KeyEvent.VK_RIGHT:
			if (collisionController.checkDir(Directions.RIGHT)) {
				this.player.goRight();
			}
			break;
			
		default:
			break;
		}
		
		if (KeyEvent.VK_ESCAPE == e.getKeyCode()) {

			gameController.setPause();
			if (gameController.getPause()) {
				controllerMenu.setup();
			}
		}
	}
}

