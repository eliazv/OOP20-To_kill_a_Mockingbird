package map;

import javax.swing.*;

//import Display.KeyPressing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Display extends JPanel implements ActionListener {

	//Variable for the game logo 'Froggy Road'.
	private Box logo = new Box("Misc/Logo.png");
	private boolean showLogo = false;
	//New game variables.
	private boolean newGame = false;

	/*
	 * Variables.
	 */
	//Creates a strip generator object.
	//private MapGenerator mapGen = new MapGenerator();
	//Holds Number of strips on screen.
	private int numOfStrips = 9;
	//2D array for holding sprite strips.
	private Box[][] allStrips = new Box[numOfStrips][8];
	//Holds the index values of special strip images.
	private ArrayList<Integer> special = new ArrayList<>();
	//Holds number of special images in special strip.
	private int land = 1, water = 0;
	//Array that holds the cars.
	private ArrayList<Box> cars = new ArrayList<>();
	//Array that holds the trains.
	private ArrayList<Box> trains = new ArrayList<>();
	private JButton startButton, controlsButton;

	//private ManageVehicles vManager = new ManageVehicles();

	//Create hero sprite.
	private Box hero = new Box("Frog/Frog_up.png");

	//Variable to hold score and travel.
	private int score = 0, movement = 0;
	private Score scoreManager = new Score();

	//Variables for directional control.
	private int up = 0, down = 0, left = 0, right = 0;
	private boolean press = false;

	//Variables for hero invincibility power.
	private boolean invincibility = false;
	private int invDuration = 0, invTimeLeft = 0;

	//Create timer.
	private Timer gameLoop;

	//Create random generator.
	private Random rand = new Random();

	/**
	 * Default constructor.
	 */
	Display(boolean pause) {

		//Set layout to absolute for buttons.
		setLayout(null);

		//Create button component, set image, remove borders.
		startButton = new JButton(new ImageIcon(getClass().getResource("Misc/Start.png")));
		startButton.setBorder(BorderFactory.createEmptyBorder());
		controlsButton = new JButton(new ImageIcon(getClass().getResource("Misc/Controls.png")));
		controlsButton.setBorder(BorderFactory.createEmptyBorder());

		startButton.addActionListener(this);
		controlsButton.addActionListener(this);

		add(startButton);
		add(controlsButton);

		startButton.setBounds(250, 175, 300, 200);
		controlsButton.setBounds(300, 390, 200, 100);


		//Create key listener for character.
		addKeyListener(new KeyPressing());

		//Set the focus to JPanel.
		setFocusable(true);

		//Make the movement smooth.
		setDoubleBuffered(true);

		//Method to set the sprite locations.
		//setInitialLocations();

		//Create the game timer and start it.
		gameLoop = new Timer(25, this);

		///Pauses the game on first run.
		if (!pause) {
			startButton.setVisible(false);
			controlsButton.setVisible(false);
			gameLoop.start();
		} else
			showLogo = true;

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//Makes a new game if start button is clicked.
		if (e.getSource() == startButton) {

			newGame = true;
			newGame();

		}
		//Show message dialog with controls.
		else if (e.getSource() == controlsButton) {

			JOptionPane.showMessageDialog(null, "Arrow Keys:  Move the frog." +
					"\nCtrl:  Activates 3 seconds of invincibility once per game." +
					"\n         (Makes frog pass through any object)" +
					"\nShift:  Pause / Resume the game." +
					"\nEnter:  Start game / Restart game while paused.");

		}

	}

	/**
	 * Method that starts a new game.
	 * @throws IOException 
	 */
	private void newGame() throws IOException {

		if (newGame) {

			//Get this JFrame and destroy it.
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
			frame.dispose();

			//Create new main menu JFrame.
			new GUI(false);
		}
	}

	/**
	 * Method to end game.
	 * Stops loop, saves scores, displays message.
	 */
	private void killMsg(String killer) {

		repaint();
		gameLoop.stop();
		//scoreManager.updateScores(score);

		//Displays correct message based on death.
		switch (killer) {
		case "water":
			JOptionPane.showMessageDialog(null, "You drowned!" + "\nScore: " + score);
			break;
		case "tooFarDown":
			JOptionPane.showMessageDialog(null, "You were trapped!" + "\nScore: " + score);
			break;
		case "tooFarUp":
			JOptionPane.showMessageDialog(null, "You left the game!" + "\nScore: " + score);
			break;
		case "car":
			JOptionPane.showMessageDialog(null, "You got hit by a car!" + "\nScore: " + score);
			break;
		case "train":
			JOptionPane.showMessageDialog(null, "You got hit by a train!" + "\nScore: " + score);
			break;
		}

		//Show start button.
		//Start button makes new window.
		startButton.setVisible(true);
		controlsButton.setVisible(true);

		showLogo = true;
	}

	/**
	 * Reads keyboard input for moving
	 * when key is pressed down.
	 */
	private class KeyPressing extends KeyAdapter {

		public void keyPressed(KeyEvent e) {

			switch (e.getKeyCode()) {

			//Moves hero within left and right bounds.
			case KeyEvent.VK_RIGHT:
				if (!press && hero.getXLoc() < 695) {
					right = 8;
					press = true;
				}
				break;
			case KeyEvent.VK_LEFT:
				if (!press && hero.getXLoc() > 0) {
					left = 8;
					press = true;
				}
				break;
			case KeyEvent.VK_UP:
				if (!press) {
					up = 10;
					press = true;
				}
				break;
			case KeyEvent.VK_DOWN:
				if (!press) {
					down = 10;
					press = true;
				}
				break;
			case KeyEvent.VK_CONTROL:
				if (!invincibility && invDuration < 150)
					invincibility = true;
				break;
			case KeyEvent.VK_SHIFT:
				if (gameLoop.isRunning())
					gameLoop.stop();
				else
					gameLoop.start();
				break;
			case KeyEvent.VK_ENTER:
				if (!gameLoop.isRunning()) {
					newGame = true;
					newGame();
				}
				break;
			}
		}



	}
}
