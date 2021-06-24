package model.map;

import java.awt.Graphics;
import javax.swing.JPanel;

import view.ImageLoader;

public class BoxImpl implements Box {

    private static final int MAP_SIZE = 800;
    private static final int BOX_SIZE = 100;
    //local variables
    private ImageLoader imgLoader;
    private double xloc, yloc;
    private double xdir, ydir;
    private String name;

    public BoxImpl() {
        this.xloc = 0;
        this.yloc = 0;
        this.xdir = 0;
        this.ydir = 0;
    }

    public BoxImpl(final String filename) {
        this.setImage(filename);
        this.name = filename;
    }

    public BoxImpl(final String filename, final double xloc, final double yloc) {
        this.setImage(filename);
        this.xloc = xloc * BOX_SIZE; 
        this.yloc = MAP_SIZE - yloc * BOX_SIZE;
        this.name = filename;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setImage(final String filename) {
        imgLoader = new ImageLoader(filename);
        this.name = filename;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImageLoader getImage() {
        return imgLoader;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getXLoc() {
        return this.xloc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setXLoc(final double xloc) {
        this.xloc = xloc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getYLoc() {
        return  this.yloc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setYLoc(final double yloc) {
        this.yloc = yloc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setYDir(final double ydir) {
        this.ydir = ydir;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setXDir(final double xdir) {
        this.xdir = xdir;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getXDir() {
        return  this.xdir;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getYDir() {
        return  this.ydir;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void move() {
        this.xloc += this.xdir;
        this.yloc += this.ydir;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getWidth() {
        return imgLoader.getImgWidth();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paint(final Graphics g, final JPanel panel) {
        //if no image has been uploaded, will be drawn an empy square: otherwise will be drawn a square filled with the image 
        if (imgLoader == null) {
            g.drawRect((int) xloc, (int) yloc, BOX_SIZE, BOX_SIZE);
        } else {
            g.drawImage(imgLoader.getImage(), (int) xloc, (int) yloc, imgLoader.getImgWidth(), imgLoader.getImgHeight(), null);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHeight() {
        return imgLoader.getImgHeight();
    }
}
