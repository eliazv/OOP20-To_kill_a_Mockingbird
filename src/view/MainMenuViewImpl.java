package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import controllers.MainMenuController;

public class MainMenuViewImpl implements MainMenuView {

	private static final int MENU_WIDTH = 613;
	private static final int MENU_HEIGHT = 727;
	private static final Color BACKGROUND_COLOR = new Color(11, 19, 30);
	
	private final MainMenuController controller;

	final JFrame frame = new JFrame();

	JButton startButton, controlsButton;
	private ImageIcon imgStart;
	
	public MainMenuViewImpl(final MainMenuController controller) {
		this.controller = controller;
		this.frame.setTitle("To Kill a Mockingbird");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.getContentPane().setBackground(BACKGROUND_COLOR);

		final JPanel mainPanel = new JPanel();
		frame.add(mainPanel);
		//Set layout to absolute for buttons.
		//setLayout(null);

		imgStart = new ImageIcon("D");
		//Create button component, set image, remove borders.
		//startButton = new JButton(new ImageIcon(getClass().getResource("startButton.png")));
		startButton = new JButton();
		startButton.setBorder(BorderFactory.createEmptyBorder());
		controlsButton = new JButton(new ImageIcon(getClass().getResource("controlsButton.png")));
		controlsButton.setBorder(BorderFactory.createEmptyBorder());
		
		startButton.setBounds(250, 175, 300, 200);
		controlsButton.setBounds(300, 390, 200, 100);

		startButton.addActionListener(e -> {
            controller.newGame();
        });
		
	}


	public void hide() {
		this.frame.dispose();
	}

	public void show() {
		this.frame.pack();
		this.frame.setVisible(true);
	}
}
