
package Engine;

import GUI.*;
import Board.ChessBoard;
import Board.ChessSquare;
import Unit.ChessUnit;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;


/**
 * This is a Selector class that selects the users chosen chess unit.
 * @author thapaliya
 */
public class Selector implements Drawer
{
    public static ChessUnit selectedUnit;
    public static int selectedRow, selectedColum;
    public ChessUnit previousSelectedUnit;
    public ChessBoard board;
    
    /**
     * 
     * @param b is the chess board.
     */
    public Selector( ChessBoard b)
    {
        this.board=b;
        this.previousSelectedUnit=null;
    }

    
    /**
     * 
     * @param r is the selected row by the player
     * @param c is the selected colum by the player
     * @param ctr is the controller object
     * @return true if this is the first click to the unit or else false.
     */
    public boolean firstClick(int r, int c, Controller ctr)
    {
        int i;
        boolean firstClick = false;
                
        if(selectedUnit==null)
        {   
            //if(playerUnitSelected(this.playerOne, r,c, ctr));
            //else if(playerUnitSelected(this.playerTwo, r,c, ctr));
            if(this.board.chessSquare[r][c].unit !=null && this.board.chessSquare[r][c].unit.alive!=false)
            {
                this.selectedUnit = this.board.chessSquare[r][c].unit;
                this.selectedRow = r;
                this.selectedColum=c;
                
                ctr.update(this);
                //firstClick=true;
            }
            //System.out.println("After call: "+ System.currentTimeMillis());
            
            
            firstClick=true;

        } 
        return firstClick;
    }
    
    /**
     *
     * @param player is the array of chess units
     * @param r is the selected row
     * @param c is the selected colum.
     * @param ctr is the controller object
     * @return true if a chess unit is found and selected at the given position or else false.
     */
    /*public boolean playerUnitSelected(ChessUnit[] player,int r, int c, Controller ctr)
    {
         
        for(int i=0; i< player.length; i++) 
        {
                if(player[i].position.row==r && player[i].position.colum==c && player[i].isAlive())
                {
                    this.selectedUnit=player[i];
                    this.selectedRow=this.selectedUnit.position.row;
                    this.selectedColum=this.selectedUnit.position.colum;
                    
                    ctr.update(this);
                    
                    return true;
                }
         }
        return false;
    
    }*/
        
    /**
     * Draws a visible square around the selected chess piece.
     * @param g is the graphics object
     * @param img is the imageObserver object
     */
    public void draw(Graphics g, ImageObserver img) 
    {
        int row,colum;
        row=this.selectedUnit.position.row;
        colum = this.selectedUnit.position.colum;
        
        //System.out.println("Inside call : "+ System.currentTimeMillis());
        if(this.previousSelectedUnit!=null)
        {
            this.board.chessSquare[this.previousSelectedUnit.position.row][this.previousSelectedUnit.position.colum].draw(g, img);
            this.previousSelectedUnit.drawImage(g, img);
            //System.out.printf("Erase rect at [%d,%d]\n", this.previousSelectedUnit.position.row, this.previousSelectedUnit.position.colum);
        }
        
        g.setColor(Color.BLUE);
        g.drawRect(this.board.chessSquare[row][colum].x+2, this.board.chessSquare[row][colum].y, ChessSquare.width-10, ChessSquare.height-10);
        g.drawRect(this.board.chessSquare[row][colum].x+3, this.board.chessSquare[row][colum].y, ChessSquare.width-10, ChessSquare.height-10);
        g.drawRect(this.board.chessSquare[row][colum].x+4, this.board.chessSquare[row][colum].y, ChessSquare.width-10, ChessSquare.height-10);

        this.previousSelectedUnit=this.selectedUnit;
    }

  
    
}
