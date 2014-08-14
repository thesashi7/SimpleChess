
package Engine;


import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 * This is a general interface Drawer. 
 * This can be implemented by any class that needs the ability to draw.
 * @author thapaliya
 */
public interface Drawer
{
    /**
     * The implementing class is responsible for drawing whatever necessary into the ImageObserver using
     * the Graphics object.
     * @param g
     * @param img 
     */
     public void draw(Graphics g, ImageObserver img); 
}
