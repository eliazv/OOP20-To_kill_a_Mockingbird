package model.map;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.Model;
import view.ImageLoader;

public interface Box extends Model {

    /**
     * set an image (via filename) for the specified box.
     * @param filename : the filename of the image
     */
    void setImage(String filename);

    /**
     * returns the image of the specified box.
     * @return an imageLoader
     */
    ImageLoader getImage();

    /**
     * returns the name of the specified box.
     * @return a string
     */
    String getName();

    /**
     * returns the X location of the specified box.
     * @return the X location
     */
    double getXLoc();

    /**
     * Set the X location for the specified box.
     * @param xloc contains the X location
     */
    void setXLoc(double xloc);

    /**
     * returns the Y location of the specified box.
     * @return the Y location
     */
    double getYLoc();

    /**
     * returns the Y direction (Y speed) of the specified box.
     * @return the Y direction
     */
    double getYDir();

    /**
     * returns the X direction (X speed) of the specified box.
     * @return the X direction
     */
    double getXDir();

    /**
     * Set the Y location for the specified box.
     * @param yloc contains the Y location
     */
    void setYLoc(double yloc);

    /**
     * set the Y direction (Y speed) of the specified box.
     * @param ydir contains the vertical scrolling speed
     */
    void setYDir(double ydir);

    /**
     * set the X direction (X speed) of the specified box.
     * @param xdir contains the horizontal scrolling speed
     */
    void setXDir(double xdir);

    /**
     * method that return the width of the image.
     * @return the width of the image.
     */
    int getWidth();

    /**
     * method that return the height of the image.
     * @return the height of the image.
     */
    int getHeight();

    /**
     * method that paints the boxes in the jpanel.
     * @param g allow an application to draw onto components
     * @param panel is the jpanel where the boxes will be painted
     */
    void paint(Graphics g, JPanel panel);
}
