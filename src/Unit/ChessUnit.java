/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit;

import Board.ChessSquare;
import Engine.Drawable;
import Engine.Position;
import Move.ChessUnitMove;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;



/**
 * This is a ChesssUnit class which can represent any unit in a chess.
 * Has data fields for the position, player side, movement, and life of this unit.
 * And, especially the type of ChessUnitMove or movement will define the type of chess unit
 * And, this class also implements Drawable interface
 * @author thapaliya
 */
public class ChessUnit implements Drawable
{
    public Position position;
    public ChessUnitMove move;
    public boolean alive;
    public int teamNumber;
    Image image;
   
    
    /**
     * CONSTRUCTOR
     * @param n represents the player or team number
     */
    public ChessUnit(int n)
    {
        this.position = new Position();
        this.teamNumber=n;
        this.alive=true;
    }

   /**
     * 
     * @return true if alive or else false 
    **/
    public  boolean isAlive()
    {
        return this.alive;
    }
    
    /**
     * Draws the image of this unit at its current position 
     * @param g
     * @param imgObs 
     */
    public void drawImage(Graphics g, ImageObserver imgObs) 
    {
        
        if(this.alive) this.drawImage(g, imgObs,  this.position.colum*ChessSquare.width,this.position.row*ChessSquare.height); // row maps y and colum maps to x
    }
    
    /**
     * @param chosenRow
     * @param chosenColum
     * @return true if  the move of this unit form its current position to the given position is valid in terms of this units
     * movement rules.
     * But, this does not check other movement validity in a board for this unit. Like jumping across units, or occupying 
     * non empty positions etc.
     */
    public boolean moveTo(int chosenRow, int chosenColum)
    {
        boolean moves=false;
        
        moves= this.move.move(this.position.row, this.position.colum, chosenRow, chosenColum);
        
        return moves;
    }
    
    @Override
    public void setImage(Image img) 
    {
        this.image=img;
    }

    @Override
    public void drawImage(Graphics g, ImageObserver imgObs, int x, int y) 
    {
        g.drawImage(image, x, y, imgObs);
      
    }

}
