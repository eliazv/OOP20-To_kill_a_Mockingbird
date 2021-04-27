package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.MainMenuController;

public class MainMenuViewImpl implements MainMenuView {

	private static final int MENU_WIDTH = 613;
	private static final int MENU_HEIGHT = 727;
	private static final Color BACKGROUND_COLOR = new Color(60, 179, 113);
	
	JLabel imgLabel = new JLabel(new ImageIcon("startButton.png"));
	
	private final MainMenuController controller;

	final JFrame frame = new JFrame();

	JButton startButton, controlsButton;
	
	public MainMenuViewImpl(final MainMenuController controller) {
		final panelMenu menuPanel = new panelMenu();
		this.controller = controller;
		this.frame.setTitle("To Kill a Mockingbird");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setSize(MENU_WIDTH, MENU_HEIGHT);
		this.frame.getContentPane().add(menuPanel);

		this.frame.setBackground(BACKGROUND_COLOR);
		this.frame.setVisible(true);

		//Set layout to absolute for buttons.
		//setLayout(null);
	}
	class panelMenu extends JPanel {

		private static final long serialVersionUID = 1L;

			public panelMenu() {

				this.setBackground(BACKGROUND_COLOR);
				
				//Set layout to absolute for buttons.
				//setLayout(null);
				
				//Create button component, set image, remove borders.
				startButton = new JButton("start");
				//startButton.setBorder(BorderFactory.createEmptyBorder());
				controlsButton = new JButton("controls");
				//controlsButton.setBorder(BorderFactory.createEmptyBorder());
				this.add(imgLabel);
				this.add(startButton);
				this.add(controlsButton);

				//startButton.setBounds(250, 175, 300, 200);
				//controlsButton.setBounds(300, 390, 200, 100);
				
				startButton.addActionListener(e -> {
		            controller.newGame();
		        });
				
				controlsButton.addActionListener(e -> {
					JOptionPane.showMessageDialog(null, "Arrow Keys:  Move the frog." +
							"\nCtrl:  Activates 3 seconds of invincibility once per game." +
							"\n         (Makes frog pass through any object)" +
							"\nShift:  Pause / Resume the game." +
							"\nEnter:  Start game / Restart game while paused.");
				});
				
			}
			
	}
	

	public void hide() {
		this.frame.dispose();
	}

	public void show() {
		//this.frame.pack();
		this.frame.setVisible(true);
	}
}
