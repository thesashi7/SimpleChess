package Engine;

import GUI.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;

/**
 * This is RestartButton class that extends MouseAdapter. 
 * This is basically a button that is built for restarting processes like games.
 * @author thapaliya
 */
public class RestartButton extends MouseAdapter
{
    public Rectangle button;
    public RestartListener restart;
    
    /**
     * 
     * @param x is the horizontal position of this button
     * @param y is the vertical position of this button
     * @param w is the width of this button
     * @param h is the height of this button
     */
    public RestartButton(int x, int y, int w, int h)
    {
        button = new Rectangle(x,y,w,h);
    }
    
    /**
     * Draws this restart Button
     * @param g is the graphics object
     * @param img is the ImageObserver object
     */
    public void drawImage(Graphics g, ImageObserver img)
    {
        g.setColor(Color.BLUE);
        g.drawRect(button.x, button.y, button.width, button.height);
        g.setColor(Color.BLACK);
        g.fillRect(button.x+1, button.y+1, button.width-2, button.height-2);
        g.setColor(Color.RED);
        g.setFont(new Font("Serif", Font.BOLD, 16));
        g.drawString("Restart", button.x+10, button.y+20);
        
        
    }
    
    @Override
    public void mouseClicked(MouseEvent me)
    {
        if(me.getX()>= button.x && me.getX()<= (button.x+button.width))
        {
            if(me.getY()>= button.y && me.getY()<=(button.y+button.height))
            {
                //restart
                this.restart.restart();
            }
        
        }
    }
    
}
