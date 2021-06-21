package application;

import java.io.IOException;

import javax.swing.*;

import controllers.MainMenuController;
import controllers.MainMenuControllerImpl;


public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	

	GUI() {

	}

	public static void main(String[] args) throws IOException {

		new GUI();
		
		MainMenuController controller = new MainMenuControllerImpl();
		controller.setup();

	}
}