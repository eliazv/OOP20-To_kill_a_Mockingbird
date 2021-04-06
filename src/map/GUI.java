package map;
import java.awt.Image;
import java.util.List;

import javax.swing.*;


/*/
 * Window that holds the Display JPanel.
 */
public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Variable for final JFrame size.
	private final int SIZE = 800;

	/**
	 * Default constructor.
	 */
	GUI(boolean pause) {

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


	/**
	 * Main constructor to start program.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Pause game if first run.
		final boolean pause = true;

		//Create window for game.
		new GUI(pause);
	}
}