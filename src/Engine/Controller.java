
package Engine;

import GUI.*;
import Board.ChessBoard;
import Unit.ChessUnit;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import javax.swing.JApplet;


/**
 * This is a final Controller class which acts like an engine connecting all the components of the game together.
 * Also, implements Drawer
 * @author thapaliya
 */
public final class Controller implements Drawer
{
    ChessBoard board;
    ChessUnit playerOne[],playerTwo[];
    public ChessUnit p1King, p2King;
    Game observer;
    Selector selector;
    Mover mover;
    PawnPromoter pawnPromoter;

    /**
     * Gets a Starter object as parameter
     * @param readyGame 
     */
    public Controller(Starter readyGame)
    {
      this.board= readyGame.board;
      this.playerOne = new ChessUnit[16];
      this.playerOne = new ChessUnit[16];
 
      
      this.playerOne = readyGame.getPlayerOne();
      this.playerTwo = readyGame.getPlayerTwo();
      this.p1King=readyGame.getFirstKing();
      this.p2King= readyGame.getSecondKing();
      
      this.selector = new Selector( this.board);
      this.mover = new Mover(this.board);
      this.pawnPromoter = new PawnPromoter(500,100, this);
    }
   
    /**
     * Gets a JApplet object as parameter
     * Observer is responsible for displaying the GUI. So, it should be notified whenever any changes are made in the game.
     * @param ap 
     */
    public void setObserver(JApplet ap)
    {
        this.observer=(Game) ap;
    }
    
    
    /**
     * Draws the Chess board along with all the units at it current positions in the current game.
     * Also, draws any marks of unit selection.
     * @param g is a Graphics object
     * @param img is the ImageObserver 
     */
    
    public void draw(Graphics g, ImageObserver img)
    {
        int i;
        
        this.board.draw(g, img);
        for(i=0; i< this.playerOne.length; i++) this.playerOne[i].drawImage(g, img);
        for(i=0; i< this.playerTwo.length; i++) this.playerTwo[i].drawImage(g, img);
        
        if(this.selector.selectedUnit!=null) this.selector.draw(g, img);
     }
    

    /**
     * This needs to be called whenever user clicks inside the frame during game play.
     * And, if appropriate this will use the selector to select a piece
     *  or will use the mover to move the piece.
     * @param r is the selected row by the player
     * @param c is the selected colum by the player
     */
    public void click(int r, int c)
    {
        System.out.println("click");
        if(r>=0 && r<=7 && c>=0 && c<=7)
        {
            if(!this.p1King.alive || !this.p2King.alive)observer.update(this);
            else if(this.selector.firstClick(r, c, this) == false) this.mover.move(r, c, this);
        }   
    }
    
  
    /**
     * Gets an object of an instant type Drawer.
     * This needs to be called when any changes happen in the game. Like a piece selection, move etc.
     * Then this will reflect the changes on the frame.
     * @param ob 
     */
    public  void update(Object ob)
    {
      //  System.out.println("CTR update");
        this.observer.update((Drawer) ob);
        if(!this.p1King.alive) System.out.println("Player 2 Won");
        else if(!this.p2King.alive) System.out.println("Player 1 Won");
    }

    /**
     * Checks if the pawn at given row is promotable
     * And, prompts the user for promotion of the pawn if promotable.
     * @param r is the row of the unit
     * @param pawn is a Pawn 
     */
    public void promoteIfPromotable(int r, ChessUnit pawn)
    {
        if(r==0 || r==7)
        {
            this.pawnPromoter.promote(pawn);
        }
    }
}
