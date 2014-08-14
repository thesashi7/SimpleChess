
package Engine;

import GUI.*;
import Unit.UnitImage;
import Movement.PawnMovement;
import javax.swing.JApplet;

/**
 * This is a ChessRestartListener class that implements RestartListener.
 * And is specially built to restart a chess game.
 * @author thapaliya
 */
public class ChessRestartListener implements RestartListener {

    Controller game;
    JApplet gameAplet;
    
    /**
     * 
     * @param g is the Controller object
     * @param ap is the applet object 
     */
    public ChessRestartListener(Controller g, JApplet ap)
    {
        this.game=g;
        this.gameAplet=ap;
    }
    
    /**
     *  Restarts the current chess game.
     */
    public void restart()
    {
        this.game.p1King.alive=true;
        this.game.p2King.alive=true;
        this.game.p1King.position.row= 0;
        this.game.p1King.position.colum = 3;
        this.game.p2King.position.row= 7;
        this.game.p2King.position.colum = 3;
        this.game.board.chessSquare[0][3].unit= this.game.p1King;
        this.game.board.chessSquare[7][3].unit= this.game.p2King;
        
        resetPawn();
        resetBishop();
        resetKnight();
        resetQueen();
        resetRook();
        resetBoard();
        
        this.game.selector.selectedUnit=null;
        this.game.mover.recentlyMovedUnit=null;
        this.game.mover.recentlySelectedUnit=null;
        
        ((Game)(this.gameAplet)).sidebar.update();
        this.gameAplet.repaint();
        System.out.println("restart");
    }
    
    private void resetPawn()
    {
        for(int i=0; i<8; i++)
        {
            this.game.playerOne[i].alive=true;
            this.game.playerOne[i].position.row=1;
            this.game.playerOne[i].position.colum=i;
            this.game.playerOne[i].move.addMovement(new PawnMovement(1));
            ((PawnMovement)this.game.playerOne[i].move.move).firstMove=0;
            this.game.playerOne[i].setImage(UnitImage.pawn1);
            this.game.board.chessSquare[1][i].unit = this.game.playerOne[i];
            
            this.game.playerTwo[i].alive=true;
            this.game.playerTwo[i].position.row=6;
            this.game.playerTwo[i].position.colum=i;
            this.game.playerTwo[i].move.addMovement(new PawnMovement(0));
            ((PawnMovement)this.game.playerTwo[i].move.move).firstMove=0;
            this.game.playerTwo[i].setImage(UnitImage.pawn2);
            this.game.board.chessSquare[6][i].unit = this.game.playerTwo[i];
        }
    }
    
    private void resetBishop()
    {
        int j=0;
        
        for(int i=8; i<10; i++)
        {
            this.game.playerOne[i].alive=true;
            this.game.playerOne[i].position.row=0;
            this.game.playerOne[i].position.colum=2+j;
            this.game.board.chessSquare[0][2+j].unit=this.game.playerOne[i];
            
            this.game.playerTwo[i].alive=true;
            this.game.playerTwo[i].position.row=7;
            this.game.playerTwo[i].position.colum=2+j;
            this.game.board.chessSquare[7][2+j].unit=this.game.playerTwo[i];
            j=3;
        }
    
    }
    
    private void resetKnight()
    {
       int j=0;
        
        for(int i=10; i<12; i++)
        {
            this.game.playerOne[i].alive=true;
            this.game.playerOne[i].position.row=0;
            this.game.playerOne[i].position.colum=1+j;
            this.game.board.chessSquare[0][1+j].unit= this.game.playerOne[i];
            
            this.game.playerTwo[i].alive=true;
            this.game.playerTwo[i].position.row=7;
            this.game.playerTwo[i].position.colum=1+j;
            this.game.board.chessSquare[7][1+j].unit= this.game.playerTwo[i];
            j=5;
        }
    }
    
    private void resetRook()
    {
       int j=0;
        
        for(int i=12; i<14; i++)
        {
            this.game.playerOne[i].alive=true;
            this.game.playerOne[i].position.row=0;
            this.game.playerOne[i].position.colum=0+j;
            this.game.board.chessSquare[0][0+j].unit= this.game.playerOne[i];
            
            this.game.playerTwo[i].alive=true;
            this.game.playerTwo[i].position.row=7;
            this.game.playerTwo[i].position.colum=0+j;
            this.game.board.chessSquare[7][0+j].unit= this.game.playerTwo[i];

            j=7;
        }
    }
    
    private void resetQueen()
    {
        this.game.playerOne[15].alive=true;
        this.game.playerOne[15].position.row=0;
        this.game.playerOne[15].position.colum=4;
        this.game.board.chessSquare[0][4].unit = this.game.playerOne[15];
               
        this.game.playerTwo[15].alive=true;
        this.game.playerTwo[15].position.row=7;
        this.game.playerTwo[15].position.colum=4;
        this.game.board.chessSquare[7][4].unit = this.game.playerTwo[15];
       
     }

    private void resetBoard()
    {
        for(int i=2; i<6; i++ )
        {
            for(int j=0; j<8; j++)
                this.game.board.chessSquare[i][j].unit=null;
        }
    }
}

