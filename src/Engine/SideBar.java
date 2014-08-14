
package Engine;

import GUI.*;
import Engine.Drawable;
import Unit.ChessUnit;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;



/**
 * This a SideBar class , implements Drawable interface, and is responsible for displaying the side bar of the chess game.
 * SideBar indicates the players and consists of the restart button.
 * @author thapaliya
 */
public class SideBar  implements Drawable
{
    ChessUnit playerOne,playerTwo; // indicates the king of both players
    Image bgImage;
    String labelOne, labelTwo;
    int width, height;
    

    public SideBar( ChessUnit firstKing,  ChessUnit secondKing) 
    {
        try 
        {
            this.playerOne=firstKing;
            this.playerTwo=secondKing;
            this.bgImage = ImageIO.read(this.getClass().getClassLoader().getResource("resources/sidebar.png"));
            initComp();
        } 
        catch (IOException ex) 
        {
            System.err.println(ex.toString());
        }
        
    }

    /**
     * Looks at the king pieces to indicate win or loss in the bar.
     * @param firstKing is the king piece of the first player
     * @param secondKing is the king piece of the second player
     * @param w is the width of this bar
     * @param h is the height of this bar
     */
    public SideBar(ChessUnit firstKing,  ChessUnit secondKing, int w, int h)
    {
        this.playerOne=firstKing;
        this.playerTwo=secondKing;
        this.width=w;
        this.height=h;
        initComp();
        
    }

    private void initComp()
    {
        this.labelOne="Player One";
        this.labelTwo="Player Two";
        
    }
    
    public void update()
    {
        if(!this.playerOne.alive) labelTwo="Player Two Won!";
        else if(!this.playerTwo.alive)labelOne="Player One Won!";
        else
        {
            labelTwo="Player Two";
            labelOne="Player One";
        }
    
    }

    @Override
    public void setImage(Image img)
    {
        this.bgImage=img;
    }

    /**
     * Draws this SideBar at the given position -- includes all three panels.
     * @param g is the graphics object
     * @param imgObs is the ImageObserver object.
     * @param x 
     * @param y 
     */
    public void drawImage(Graphics g, ImageObserver imgObs, int x, int y) 
    {
        g.setColor(Color.GREEN);
        g.drawRect(x, y,width , height/3);
        g.fillRect(x, y,width , height/3);
        //g.drawImage(bgImage, x, y,  imgObs);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 19));
        g.drawString(labelOne, x+50, y+90);
        g.setColor(Color.blue);
        g.drawRect(x, y+(height/3),width , height/3);
        g.fillRect(x, y+(height/3),width , height/3);
        g.setColor(Color.CYAN);
        g.drawRect(x, y+(2*(height/3)),width , height/3);
        g.fillRect(x, y+(2*(height/3)),width , height/3);
        g.setColor(Color.WHITE);
        g.drawString(labelTwo, x+50, 600-80);
    }
    
    /**
     * Draws the player one and twos panels only.
     * @param g
     * @param imgObs
     * @param x
     * @param y 
     */
    public void drawLabels(Graphics g, ImageObserver imgObs, int x, int y) 
    {
        g.setColor(Color.GREEN);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 19));
        g.drawRect(x, y,width , height/3);
        g.fillRect(x, y,width , height/3);
        //g.drawImage(bgImage, x, y,  imgObs);
        g.setColor(Color.WHITE);
        g.drawString(labelOne, x+50, y+90);
        
        g.setColor(Color.CYAN);
        g.drawRect(x, y+(2*(height/3)),width , height/3);
        g.fillRect(x, y+(2*(height/3)),width , height/3);
        g.setColor(Color.WHITE);
        g.drawString(labelTwo, x+50, 600-80);
        
    }

 
    

    
}
