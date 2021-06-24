package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import controllers.MainMenuController;

public class MainMenuViewImpl implements View {

	private static final int MENU_WIDTH = 600;
	private static final int MENU_HEIGHT = 700;
	private static final int HALF_MENU_WIDTH = MENU_WIDTH / 2 - 80;
	private static final int IMAGE_WIDTH = 150;
	private static final int IMAGE_HEIGHT = 70;
	private static final int FIRST_IMAGE_Y= 450;
	private static final Color BACKGROUND_COLOR = new Color(60, 179, 113);

	private final MainMenuController controller;

	final JFrame frame = new JFrame();
	JLabel lblBackground;
	JButton startButton, controlsButton;
	Rectangle rStartButton, rControlsButton, rLblBackground;
	
	public MainMenuViewImpl(final MainMenuController controller) {
		final panelMenu menuPanel = new panelMenu();
		this.controller = controller;
		this.frame.setTitle("To Kill a Mockingbird");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setLocation(350, 10);
		this.frame.setSize(MENU_WIDTH, MENU_HEIGHT);
		this.frame.getContentPane().add(menuPanel);
		this.frame.setBackground(BACKGROUND_COLOR);
		this.frame.setVisible(true);
		//Set layout to absolute for buttons.
		this.frame.setLayout(null);
	}
	class panelMenu extends JLayeredPane {

		private static final long serialVersionUID = 1L;

		public panelMenu() {

			rLblBackground = new Rectangle(0, 0, MENU_WIDTH, MENU_HEIGHT);
			ImageIcon background = new ImageIcon(new ImageIcon(this.getClass().getResource("/MainMenu.png")).getImage().getScaledInstance(MENU_WIDTH, MENU_HEIGHT, Image.SCALE_SMOOTH));

			lblBackground = new JLabel(background);
			lblBackground.setBounds(rLblBackground);
			add(lblBackground, DEFAULT_LAYER);
			

			ImageIcon startImage = new ImageIcon(new ImageIcon(this.getClass().getResource("/startButton.png")).getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));
			ImageIcon controlsImage = new ImageIcon(new ImageIcon(this.getClass().getResource("/controlsButton.png")).getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));
			rStartButton = new Rectangle(HALF_MENU_WIDTH, FIRST_IMAGE_Y, IMAGE_WIDTH, IMAGE_HEIGHT);
			rControlsButton = new Rectangle(HALF_MENU_WIDTH, FIRST_IMAGE_Y + 100, IMAGE_WIDTH, IMAGE_HEIGHT);
			//Create button component, set image, remove borders.
			startButton = new JButton("", startImage);
			startButton.setBounds(rStartButton);
			startButton.setBorder(BorderFactory.createEmptyBorder());
			lblBackground.add(startButton);
			
			controlsButton = new JButton("", controlsImage);
			controlsButton.setBorder(BorderFactory.createEmptyBorder());
			controlsButton.setBounds(rControlsButton);
			lblBackground.add(controlsButton);

			startButton.addActionListener(e -> {
				controller.newGame();
			});

			controlsButton.addActionListener(e -> {
				JOptionPane.showMessageDialog(null, "Arrow Keys:  Move the character."
			+ "\nEsc:  Pause / Resume the game.");
			});
		}
	}

	@Override
	public void exit() {
		this.frame.dispose();
	}

	@Override
	public void setup() {

		this.frame.setVisible(true);
	}
}
