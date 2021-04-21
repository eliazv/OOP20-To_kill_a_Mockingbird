package application;

import java.io.IOException;

import javax.swing.*;

import view.MapViewImpl;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private final int SIZE = 800;

	GUI(boolean pause) throws IOException {

		setTitle("Mockingbird");

		setSize(SIZE, SIZE);

		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(false);

		add(new MapViewImpl());

		setVisible(true);
	}

	public static void main(String[] args) throws IOException {

		final boolean pause = true;//serve?

		new GUI(pause);
	}
}