
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

import controllers.InGameMenuController;

public class InGameMenuViewImpl implements View {

	private static final int MENU_WIDTH = 400;
	private static final int MENU_HEIGHT = 500;
	private static final int HALF_MENU_WIDTH = MENU_WIDTH / 2 - 80;
	private static final int IMAGE_WIDTH = 150;
	private static final int IMAGE_HEIGHT= 30;
	private static final int FIRST_IMAGE_Y= 250;
	private static final Color BACKGROUND_COLOR = new Color(60, 179, 113);

	private final InGameMenuController controller;
	
	final JFrame frame = new JFrame();
	JLabel lblBackground;
	JButton resumeButton, controlsButton, exitButton;
	Rectangle rResumeButton, rControlsButton, rLblBackground, rExitButton;
	
	public InGameMenuViewImpl(final InGameMenuController controller) {

		final InGameMenuPanel menu = new InGameMenuPanel();
		this.controller = controller;
		this.frame.setTitle("To Kill a Mockingbird");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setLocation(450, 100);
		this.frame.setSize(MENU_WIDTH, MENU_HEIGHT);
		this.frame.getContentPane().add(menu);
		this.frame.setBackground(BACKGROUND_COLOR);
		this.frame.setVisible(true);

		//Set layout to absolute for buttons.
		this.frame.setLayout(null);
	}

	class InGameMenuPanel extends JLayeredPane {

		private static final long serialVersionUID = 1L;
		
		public InGameMenuPanel() {

			rLblBackground = new Rectangle(0, 0, MENU_WIDTH, MENU_HEIGHT);
			ImageIcon background = new ImageIcon(new ImageIcon(this.getClass().getResource("/InGameMenu.png")).getImage().getScaledInstance(MENU_WIDTH, MENU_HEIGHT, Image.SCALE_SMOOTH));
			lblBackground = new JLabel(background);
			lblBackground.setBounds(rLblBackground);
			add(lblBackground, DEFAULT_LAYER);
			
			ImageIcon resumeImage = new ImageIcon(new ImageIcon(this.getClass().getResource("/resumeButton.png")).getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));
			ImageIcon controlsImage = new ImageIcon(new ImageIcon(this.getClass().getResource("/controlsButton2.png")).getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH));
			ImageIcon exitImage = new ImageIcon(new ImageIcon(this.getClass().getResource("/exitButton.png")).getImage().getScaledInstance(IMAGE_HEIGHT, IMAGE_HEIGHT, Image.SCALE_SMOOTH));
			rResumeButton = new Rectangle(HALF_MENU_WIDTH, FIRST_IMAGE_Y, IMAGE_WIDTH, IMAGE_HEIGHT);
			rControlsButton = new Rectangle(HALF_MENU_WIDTH, FIRST_IMAGE_Y + 50, IMAGE_WIDTH, IMAGE_HEIGHT);
			rExitButton = new Rectangle(MENU_WIDTH - 80, FIRST_IMAGE_Y + 150, IMAGE_HEIGHT, IMAGE_HEIGHT);

			//Create button component, set image, remove borders.
			resumeButton = new JButton("", resumeImage);
			resumeButton.setBounds(rResumeButton);
			resumeButton.setBorder(BorderFactory.createEmptyBorder());
			lblBackground.add(resumeButton);
			
			controlsButton = new JButton("", controlsImage);
			controlsButton.setBorder(BorderFactory.createEmptyBorder());
			controlsButton.setBounds(rControlsButton);
			lblBackground.add(controlsButton);
			
			exitButton = new JButton("", exitImage);
			exitButton.setBorder(BorderFactory.createEmptyBorder());
			exitButton.setBounds(rExitButton);
			lblBackground.add(exitButton);
			
			resumeButton.addActionListener(e -> {
				controller.resume();
			});

			exitButton.addActionListener(e -> {
				controller.exit();
			});
			controlsButton.addActionListener(e -> {
				JOptionPane.showMessageDialog(null, "Arrow Keys:  Move the character." 
			+ "\nEsc:  Pause / Resume the game.");
			});
		}
	}
	
	@Override
	public void setup() {
		this.frame.setVisible(true);
	}

	@Override
	public void exit() {
		this.frame.dispose();
		JOptionPane.showMessageDialog(null, "Press ESC to resume");
	}
}
