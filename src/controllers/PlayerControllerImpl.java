package controllers;

import java.awt.event.KeyEvent;

import input.player.Input;
import input.player.InputImpl;

public class PlayerControllerImpl extends GameControllerImpl implements PlayerController{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2866484581455331098L;
	private Input input = new InputImpl(this.getPlayer()); 

	@Override
	public void keyCatch(KeyEvent e) {
		System.out.println("sono qui");
		this.input.keyInput(e);	
	}
	
	

}
