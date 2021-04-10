package map;

import java.io.IOException;

import javax.swing.*;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//Variable for final JFrame size.
	private final int SIZE = 800;

	GUI(boolean pause) throws IOException {

		//Set the title.
		setTitle("Mockingbird");

		//Set the size of the JFrame.
		setSize(SIZE, SIZE);

		//Set window to screen center.
		setLocationRelativeTo(null);

		//Specify the close button action.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//set resize.
		setResizable(false);

		//Add panel to frame.
		add(new MapGenerator());

		//Display the window.
		setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		
		//Pause game if first run.
		final boolean pause = true;

		//Create window for game.
		new GUI(pause);
	}
}