
package Engine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

/**
 * This is an interface Drawable which can be implemented by any object that has an image 
 * and needs to be drawn.
 * @author thapaliya
 */
public interface Drawable
{
    /**
     * Sets the image to be drawn
     * @param img to be drawn  
     */
    public abstract void setImage(Image img);
    
    /**
     * Draws image at the given point of axis.
     * @param g
     * @param imgObs
     * @param x is the horizontal point of axis for the image to be drawn
     * @param y is the vertical point of axis for the image to be drawn.
     */
    public abstract void drawImage(Graphics g, ImageObserver imgObs, int x, int y);
}
