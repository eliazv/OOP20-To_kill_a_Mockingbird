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

import controllers.EndGameController;

public class EndGameViewImpl implements EndGameView {
	private static final int MENU_WIDTH = 400;
	private static final int MENU_HEIGHT = 500;
	private static final Color BACKGROUND_COLOR = new Color(60, 179, 113);

	private final EndGameController controller;
	
	final JFrame frame = new JFrame();
	JLabel lblBackground;
	JButton restartButton, exitButton;
	Rectangle rRestartButton, rLblBackground, rExitButton;
	
	public EndGameViewImpl(final EndGameController controller) {
		
		final EndGamePanel menu = new EndGamePanel();
		this.controller = controller;
		this.frame.setTitle("To Kill a Mockingbird");
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setResizable(false);
		this.frame.setLocation(450,100);
		this.frame.setSize(MENU_WIDTH, MENU_HEIGHT);
		this.frame.getContentPane().add(menu);
		this.frame.setBackground(BACKGROUND_COLOR);
		this.frame.setVisible(true);

		//Set layout to absolute for buttons.
		this.frame.setLayout(null);
	}

	class EndGamePanel extends JLayeredPane {
		
		private static final long serialVersionUID = 1L;

		public EndGamePanel() {
			
			rLblBackground = new Rectangle(0,0,400,500);
			ImageIcon background = new ImageIcon(new ImageIcon("resources/GameOver.png").getImage().getScaledInstance(400, 500, Image.SCALE_SMOOTH));

			lblBackground = new JLabel(background);
			lblBackground.setBounds(rLblBackground);
			add(lblBackground, DEFAULT_LAYER);
			ImageIcon restartImage = new ImageIcon (new ImageIcon("resources/RestartButton.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH));
			ImageIcon exitImage = new ImageIcon (new ImageIcon("resources/ExitButton2.png").getImage().getScaledInstance(150, 30, Image.SCALE_SMOOTH));

			rRestartButton = new Rectangle(MENU_WIDTH/2-80, 150, 150, 30);
			rExitButton = new Rectangle(MENU_WIDTH/2-80, 200, 150, 30);

			//Create button component, set image, remove borders.
			restartButton = new JButton ("", restartImage);
			restartButton.setBounds(rRestartButton);
			restartButton.setBorder(BorderFactory.createEmptyBorder());
			
			lblBackground.add(restartButton);
			
			exitButton = new JButton("", exitImage);
			exitButton.setBorder(BorderFactory.createEmptyBorder());
			exitButton.setBounds(rExitButton);
			lblBackground.add(exitButton);
			
			restartButton.addActionListener(e -> {
				controller.restart();
			});

			exitButton.addActionListener(e -> {
				controller.exit();
			});
		}
	}
	
	@Override
	public void show() {
		this.frame.setVisible(true);
	}

	@Override
	public void hide() {
		this.frame.dispose();
	}
}
