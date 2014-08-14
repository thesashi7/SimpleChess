
package Engine;

import Unit.UnitImage;
import Board.ChessBoard;
import Board.ChessSquare;
import Move.ChessUnitMove;
import Movement.BishopMovement;
import Movement.KingMovement;
import Movement.KnightMovement;
import Movement.PawnMovement;
import Movement.QueenMovement;
import Movement.RookMovement;
import Unit.ChessUnit;
import java.awt.image.BufferedImage;


/**
 * This is a Starter class which is built for the chess game.
 * This initializes all the chess components.
 * Needed to start the game from beginning.
 * @author thapaliya
 */
public class Starter 
{
    public ChessBoard board;
    private ChessUnit p1Pawn[],p2Pawn[], p1Knight[], p2Knight[], p1Bishop[], p2Bishop[], p1Rook[],p2Rook[];
    private ChessUnit p1King, p1Queen, p2King, p2Queen;
    public UnitImage units;
    
    /**
     * 
     * @param boardWidth
     * @param boardHeight 
     */
    public Starter(int boardWidth, int boardHeight)
    {
        board = new ChessBoard(boardWidth,boardHeight);
        units = new UnitImage();
        initUnits();
       
    }
   
    /**
     * Initializes all the units to the start of the game of a chess.
     */
    private void initUnits()
    {
        int  squareWidth, squareHeight;
        BufferedImage bImg;
        
        squareWidth = ChessSquare.width;
        squareHeight = ChessSquare.height;
        
        this.p1Pawn = new ChessUnit[8];
        this.p2Pawn = new ChessUnit[8];
        this.p1Knight = new ChessUnit[2];
        this.p2Knight = new ChessUnit[2];
        this.p1Bishop = new ChessUnit[2];
        this.p2Bishop = new ChessUnit[2];
        this.p1Rook = new ChessUnit[2];
        this.p2Rook = new ChessUnit[2];
        
        this.p1King = new ChessUnit(1);
        this.p2King = new ChessUnit(2);
        this.p1Queen = new ChessUnit(1);
        this.p2Queen = new ChessUnit(2);
        
        
        for(int i=0; i<8; i++)
        {
            this.p1Pawn[i] = new ChessUnit(1);
            this.p2Pawn[i] = new ChessUnit(2);
            this.p1Pawn[i].setImage(units.pawn1);
            this.p2Pawn[i].setImage(units.pawn2);
            this.p1Pawn[i].move=  new ChessUnitMove();
            this.p2Pawn[i].move=  new ChessUnitMove();
            this.p1Pawn[i].move.addMovement(new PawnMovement(1));
            this.p2Pawn[i].move.addMovement(new PawnMovement(0));
            
            this.p1Pawn[i].position.row=1;
            this.p1Pawn[i].position.colum=i;
            this.p1Pawn[i].position.x=i*(squareWidth);
            this.p1Pawn[i].position.y= squareHeight;
            
            this.p2Pawn[i].position.row=6;
            this.p2Pawn[i].position.colum=i;
            this.p2Pawn[i].position.x=i*(squareWidth);
            this.p1Pawn[i].position.y= 6*squareHeight;
            
            this.board.chessSquare[1][i].unit=this.p1Pawn[i];
            this.board.chessSquare[6][i].unit=this.p2Pawn[i];
        }
        
        for(int i=0; i<2; i++)
        {
            this.p1Bishop[i] = new ChessUnit(1);
            this.p2Bishop[i] = new ChessUnit(2);
            this.p1Bishop[i].setImage(units.bishop1);
            this.p2Bishop[i].setImage(units.bishop2);
            this.p1Bishop[i].move = new ChessUnitMove();
            this.p2Bishop[i].move = new ChessUnitMove();
            this.p1Bishop[i].move.addMovement(new BishopMovement());
            this.p2Bishop[i].move.addMovement(new BishopMovement());
            
            this.p1Bishop[i].position.row=0;
            this.p1Bishop[i].position.colum=(i*3)+2;
            this.p2Bishop[i].position.row=7;
            this.p2Bishop[i].position.colum=(i*3)+2;
            
            this.p1Knight[i] = new ChessUnit(1);
            this.p2Knight[i] = new ChessUnit(2);
            this.p1Knight[i].setImage(units.knight1);
            this.p2Knight[i].setImage(units.knight2);
            this.p1Knight[i].move = new ChessUnitMove();
            this.p2Knight[i].move = new ChessUnitMove();
            this.p1Knight[i].move.addMovement(new KnightMovement());
            this.p2Knight[i].move.addMovement(new KnightMovement());
            
            this.p1Knight[i].position.row=0;
            this.p1Knight[i].position.colum=(i*5)+1;
            this.p2Knight[i].position.row=7;
            this.p2Knight[i].position.colum=(i*5)+1;
            
            this.p1Rook[i] = new ChessUnit(1);
            this.p2Rook[i] = new ChessUnit(2);
            this.p1Rook[i].setImage(units.rook1);
            this.p2Rook[i].setImage(units.rook2);
            this.p1Rook[i].move = new ChessUnitMove();
            this.p2Rook[i].move = new ChessUnitMove();
            this.p1Rook[i].move.addMovement(new RookMovement());
            this.p2Rook[i].move.addMovement(new RookMovement());
            
            this.p1Rook[i].position.row=0;
            this.p1Rook[i].position.colum=(i*7);
            this.p2Rook[i].position.row=7;
            this.p2Rook[i].position.colum=(i*7);
            
            this.board.chessSquare[0][i*7].unit=this.p1Rook[i];
            this.board.chessSquare[7][i*7].unit=this.p2Rook[i];
            this.board.chessSquare[0][(i*5)+1].unit= this.p1Knight[i];
            this.board.chessSquare[7][(i*5)+1].unit= this.p2Knight[i];
            this.board.chessSquare[0][(i*3)+2].unit= this.p1Bishop[i];
            this.board.chessSquare[7][(i*3)+2].unit= this.p2Bishop[i];
        }
        
        this.p1King = new ChessUnit(1);
        this.p2King = new ChessUnit(2);
        this.p1King.setImage(units.king1);
        this.p2King.setImage(units.king2);
        this.p1King.move = new ChessUnitMove();
        this.p2King.move = new ChessUnitMove();
        this.p1King.move.addMovement(new KingMovement());
        this.p2King.move.addMovement(new KingMovement());
        this.p1King.position.row=0;
        this.p1King.position.colum=3;
        this.p2King.position.row=7;
        this.p2King.position.colum=3;
        
        this.p1Queen = new ChessUnit(1);
        this.p2Queen = new ChessUnit(2);
        this.p1Queen.setImage(units.queen1);
        this.p2Queen.setImage(units.queen2);
        this.p1Queen.move = new ChessUnitMove();
        this.p2Queen.move = new ChessUnitMove();
        this.p1Queen.move.addMovement(new QueenMovement());
        this.p2Queen.move.addMovement(new QueenMovement());
        this.p1Queen.position.row=0;
        this.p1Queen.position.colum=4;
        this.p2Queen.position.row=7;
        this.p2Queen.position.colum=4;
        
        this.board.chessSquare[0][4].unit=this.p1Queen;
        this.board.chessSquare[7][4].unit=this.p2Queen;
        this.board.chessSquare[0][3].unit=this.p1King;
        this.board.chessSquare[7][3].unit=this.p2King;
    
    }
    
    /**
     * 
     * @return the arrays of chessUnits of player one. 
     */
    public ChessUnit[] getPlayerOne()
    {
        ChessUnit[] pOne = new ChessUnit[16];
        int i=0,j=0;
        
        while( i<8) pOne[i] = this.p1Pawn[i++];
        while( i<10) pOne[i++] = this.p1Bishop[j++];
        j=0;
        while(i<12) pOne[i++] = this.p1Knight[j++];
        j=0;
        while(i<14) pOne[i++] = this.p1Rook[j++];
        pOne[i++]=this.p1King;
        pOne[i] = this.p1Queen;
        
        return pOne;
    }
    
    /**
     * 
     * @return  the arrays of chessUnits of player two.
     */
    public ChessUnit[] getPlayerTwo()
    {
        ChessUnit[] pTwo = new ChessUnit[16];
        int i=0,j=0;
        
        while( i<8) pTwo[i] = this.p2Pawn[i++];
        while( i<10) pTwo[i++] = this.p2Bishop[j++];
        j=0;
        while(i<12) pTwo[i++] = this.p2Knight[j++];
        j=0;
        while(i<14) pTwo[i++] = this.p2Rook[j++];
        pTwo[i++]=this.p2King;
        pTwo[i] = this.p2Queen;
        
        return pTwo;
    }
    
    /**
     * 
     * @return player one's king piece.
     */
    public ChessUnit getFirstKing()
    {
        return this.p1King;
    }
    
    /**
     * 
     * @return player  two's king piece.  
     */
    public ChessUnit getSecondKing()
    {
        return this.p2King;
    }
    
}
