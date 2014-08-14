
package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JApplet;

/**
 * This a Menu class that extends MouseAdapter and is specially built for Chess game.
 * @author thapaliya
 */
public class Menu extends MouseAdapter 
{
    Image bgImage, startButton,exitButton;
    Rectangle playGame, exit;
    JApplet frame;
    boolean insideStart, insideExit;
    
    public Menu(int w, int h, JApplet aplet)
    {
        try 
        {
            bgImage = ImageIO.read(this.getClass().getClassLoader().getResource("resources/chessg.jpg"));
            bgImage =  bgImage.getScaledInstance(w, h, 1);
            startButton = ImageIO.read(this.getClass().getClassLoader().getResource("resources/startgame.png"));
            exitButton =ImageIO.read(this.getClass().getClassLoader().getResource("resources/exitgame.png"));
            playGame=  new Rectangle(100,100,100,50);
            exit = new Rectangle(100,200,90,50);
            frame=aplet;
            
        } 
        catch (IOException ex)
        {
            System.err.println(ex.toString());
        }
    }
    
    public void draw(Graphics g, ImageObserver img)
    {
            
        if(this.insideStart)
        {
            g.drawImage(startButton,playGame.x,playGame.y,playGame.width+50, playGame.height+20, img);
        }
        else if(this.insideExit)
        {
            g.drawImage(exitButton,exit.x,exit.y,exit.width+50, exit.height+20,img);  
        }
        else
        {
            g.drawImage(bgImage, 0, 0, img);
            g.drawImage(startButton,playGame.x,playGame.y,playGame.width, playGame.height, img);
            g.drawImage(exitButton,exit.x,exit.y,exit.width, exit.height,img);
        }
            
    }
    
    
    @Override
    public void mouseMoved(MouseEvent me)
    {
         if(hooveredOverStart(me));
         else if(hooveredOverExit(me));
         else if(this.insideStart)
         {
             this.insideStart=false;
             frame.repaint();
         }
         else if (this.insideExit)
         {
             this.insideExit=false;
             frame.repaint();
         }
         else
         {
             this.insideStart=false;
             this.insideExit=false;
         }
    }
    
    @Override
    public void mouseClicked(MouseEvent me)
    {
        if(this.insideStart)
        {
            ((Game)this.frame).startGame();
        }
        else if (this.insideExit)
        {
            ((Game)this.frame).exitGame();
        }
    }
    
    private boolean hooveredOverStart(MouseEvent me)
    {
        if(me.getX()>=this.playGame.x && me.getX()<= (this.playGame.x+this.playGame.width))
        {
             if(me.getY()>= this.playGame.y && me.getY()<=(this.playGame.y+this.playGame.height))
             {
                 System.out.println("entered");
                 frame.repaint();
                 this.insideStart=true;
                 return true;
             }
             else if(this.insideStart) 
             {
                 this.insideStart=false;
                 frame.repaint();
                 return false;
             }
         }
        
        return false;
    }
    
    private boolean hooveredOverExit(MouseEvent me)
    {
         if(me.getX()>=this.exit.x && me.getX()<= (this.exit.x+this.exit.width))
        {
             if(me.getY()>= this.exit.y && me.getY()<=(this.exit.y+this.exit.height))
             {
                 System.out.println("entered");
                 frame.repaint();
                 this.insideExit=true;
                 return true;
             }
             else if(this.insideExit) 
             {
                 this.insideExit=false;
                 frame.repaint();
                 return false;
             }
         }
        
        return false;
    
    }
}
