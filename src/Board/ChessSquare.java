/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

import Unit.ChessUnit;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

/**
 * This is a ChessSquare class. 
 * @author thapaliya
 */
public class ChessSquare 
{
    private Image square;
    public int row, colum,x,y;
    public static int width, height;
    public ChessUnit unit; // Referenec to the unit currently at this square.
    
    /**
     * Constructor for ChessSquare
     * @param sqr is the Image of this chess square
     * @param r is the row of this square
     * @param c is the colum of this square
     * @param a is the x horizontal axis of this square
     * @param b is the y vertical axis of this square.
     */
    public ChessSquare(Image sqr, int r, int c, int a, int b)
    {
        this.square=sqr;
        this.row=r;
        this.colum=c;
        this.x=a;
        this.y=b;
        this.unit=null;
    }
    
    /**
     * Draws this square from the x and y point of axis of this square
     * @param g
     * @param imgObs 
     */
    public void draw(Graphics g, ImageObserver imgObs)
    {
        //g.drawImage(this.square, this.x , this.y, imgObs);
        g.drawImage(this.square, this.x, this.y, width, height, imgObs);
        
    }
    
    
   
    
}
