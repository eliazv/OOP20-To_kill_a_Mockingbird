package view;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/**
 * class to load images through strings containing their file path.
 */
public class ImageLoader {

    /**
     * local variables.
     */
    private BufferedImage img;
    private String filename = null;

    /**
     * loads the argument passed as an image
     * 
     * @param filename contains the image
     */
    public ImageLoader(final String filename) {
        this.filename = filename;

        try {
            img = ImageIO.read(ImageLoader.class.getClassLoader().getResourceAsStream(filename));

        } catch (Exception e) {
            img = null;
        }
    }

    /**
     * 
     * @return the width of image
     */
    public int getImgWidth() {
        return img.getWidth();
    }

    /**
     * 
     * @return the height of image
     */
    public int getImgHeight() {
        return img.getHeight();
    }

    /**
     * 
     * @return the string of the file containing the image
     */
    public String getFileName() {
        return filename;
    }

    /**
     * 
     * @return the image
     */
    public BufferedImage getImage() {
        return img;
    }
}
