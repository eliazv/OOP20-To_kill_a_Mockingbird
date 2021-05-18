package view;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class ImageLoader {
	
	private BufferedImage img ;
	private String filename = null;
	
	public ImageLoader() {
	
	}
	
	public ImageLoader(String filename) {
		this.filename = filename;
		
		try {
			 img = ImageIO.read(ImageLoader.class.getClassLoader().getResourceAsStream(filename));
			
		} catch (Exception e) {
			img = null;
		}
	}

	public int getImgWidth() {
		return img.getWidth();
	}
	
	public int getImgHeight() {
		return img.getHeight();
	}

	
	public String getFileName() {
		return filename;
	}

	public BufferedImage getImage(){
		return img;
	}
}
