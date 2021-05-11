package input.player;

import java.awt.event.KeyEvent;

import model.player.Player;
import model.player.PlayerMovement;
import model.player.PlayerMovementImpl;

public class InputImpl implements Input{

	private PlayerMovement moves ;
	
	public InputImpl(Player player) {
		this.moves = new PlayerMovementImpl(player.getImage(), player.getXPos(), player.getYPos());
	}
	@Override
	public void keyInput(KeyEvent e) {
		System.out.println("sono quiiiiiiiiii");
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: 
			this.moves.goUp();
			break;
		case KeyEvent.VK_DOWN:
			this.moves.goDown();
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
		
		
	}

}
