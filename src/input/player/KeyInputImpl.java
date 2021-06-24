package input.player;

import java.awt.event.KeyEvent;

import controllers.CollisionController;
import controllers.GameController;
import controllers.GameControllerImpl;
import controllers.InGameMenuController;
import controllers.InGameMenuControllerImpl;
import model.player.*;

public class KeyInputImpl implements KeyInput{
	
	private PlayerMovement player;
	private InGameMenuController controllerMenu = new InGameMenuControllerImpl();
	private GameController gameController;
	private CollisionController collisionController;
	
	public KeyInputImpl(GameControllerImpl gameController, CollisionController cc) {
		this.player = gameController.getPlayer();
		this.gameController = gameController;
		this.collisionController = cc;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public void command(KeyEvent event) {
		switch (event.getKeyCode()) {
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
		
		if (KeyEvent.VK_ESCAPE == event.getKeyCode()) {

			gameController.setPause();
			if (gameController.getPause()) {
				controllerMenu.setup();
			}
		}
	}
}

