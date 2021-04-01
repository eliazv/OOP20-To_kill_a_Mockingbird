package map;

import javax.swing.ImageIcon;

public class Box {
	
	private ImageIcon image;
	private String filename;
	
	public Box() {
		image = null;
	}
	
	public Box(String filename) {
		setImage(filename);
	}

	//set the image variable.
	public  void setImage(String filename) {
		this.filename = filename;

		try {
			this.image = new ImageIcon(getClass().getResource(filename));
		} catch (Exception e) {
			image = null;
		}
	}

}
