package input.player;

import java.awt.event.KeyEvent;

import controllers.CollisionController;
import controllers.GameController;
import controllers.GameControllerImpl;
import controllers.InGameMenuController;
import controllers.InGameMenuControllerImpl;
import model.player.*;

import controllers.CollisionController.Directions;

public class InputImpl implements Input{
	
	private PlayerMovement player;
	private InGameMenuController controllerMenu = new InGameMenuControllerImpl();
	private GameController gameController;
	private CollisionController collisionController;
	
	public InputImpl(GameControllerImpl gameController, CollisionController cc) {
		this.player = gameController.getPlayer();
		this.gameController = gameController;
		this.collisionController = cc;
	}
	
	@Override
	public void keyInput(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: 
			if (collisionController.checkDir(Directions.UP) && !gameController.getPause()) {
				this.player.moveDirection(Directions.UP);
				gameController.setScore(gameController.getRealScore()+1);
			}
			break;
			
		case KeyEvent.VK_DOWN:
			if (collisionController.checkDir(Directions.DOWN) && !gameController.getPause()) {
				this.player.moveDirection(Directions.DOWN);;
				gameController.setScore(gameController.getRealScore()-1);
			}
			break;
			
		case KeyEvent.VK_LEFT:
			if (collisionController.checkDir(Directions.LEFT) && !gameController.getPause()) {
				this.player.moveDirection(Directions.LEFT);;
			}
			break;
			
		case KeyEvent.VK_RIGHT:
			if (collisionController.checkDir(Directions.RIGHT) && !gameController.getPause()) {
				this.player.moveDirection(Directions.RIGHT);;
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

