
package Engine;

import GUI.*;
import Board.ChessBoard;
import Movement.PawnMovement;
import Unit.ChessUnit;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

/**
 * This a Mover class and implements drawer and is specially built for chess game.
 * And, this class basically moves the chess unit if the move is perfectly valid in a chess game.
 * @author thapaliya
 */
public class Mover implements Drawer
{
    public ChessUnit  recentlyMovedUnit, recentlySelectedUnit;
    public boolean moved;
    public ChessBoard board;
    public boolean pawn;
    
    /**
     * 
     * @param b is a ChessBoard object 
     */
    public Mover(ChessBoard b)
    {
        this.board=b;
        this.moved=false;
        this.pawn=false;
    }
    
    /**
     * Moves the selected Unit to the desired row and colum if and only if the move is completely valid.
     * @param r is the row to move
     * @param c is the colum to move
     * @param contr is a Controller object
     */
    public void move(int r, int c, Controller contr)
    {
     
        this.moved=false;
        this.recentlySelectedUnit=Selector.selectedUnit;
        // handling turns for players
        if(this.recentlyMovedUnit!= null && Selector.selectedUnit.teamNumber== this.recentlyMovedUnit.teamNumber) ;//Selector.selectedUnit=null;
        else if(validMovement(r,c))
        {
            //need to check if there is a unit at the desired position.
            
             System.out.printf("Unit fromm [%d,%d] move to [%d,%d]\n", Selector.selectedUnit.position.row
                        ,Selector.selectedUnit.position.colum, r,c);
             
             Selector.selectedUnit.position.row=r;
             Selector.selectedUnit.position.colum=c;
             this.board.chessSquare[Selector.selectedRow][Selector.selectedColum].unit=null;
             this.board.chessSquare[r][c].unit=Selector.selectedUnit;
             this.recentlyMovedUnit=Selector.selectedUnit;
             this.moved=true;
             if(this.pawn)
             {
                 contr.promoteIfPromotable(r, recentlyMovedUnit);
                 this.pawn=false;
             }
             
        }
      
       contr.update(this);
       Selector.selectedUnit=null; 
        
    }
    
    /*
     * returns true if the move for the selected unit is valid to the given position
     * or else false
     */
    public boolean validMovement(int r, int c)
    {
        boolean valid;
        valid =false;
                
        if(Selector.selectedUnit.moveTo(r, c) )
        {
            if(validMove(r,c) && validPosition(r,c))
                valid=true;
           
        }
       
        return valid;
    }
    
    /*
     * returns true if there is no freindly unit at the given position 
     * Or else returns false
     */
    private boolean validPosition(int r , int c)
    {
     // have to use board to find if there is a unit at the given position
        boolean valid;
        valid =false;
        System.out.println("validPosition()");
        if(this.board.chessSquare[r][c].unit==null) valid=true;
        else if(Selector.selectedUnit.teamNumber!= this.board.chessSquare[r][c].unit.teamNumber)
        {
            this.board.chessSquare[r][c].unit.alive=false;
            valid=true;
        }
        return valid;
    }
    
    /*
     *  returns true if the unit does not illegaly jumps over or takes other units  
     *  or else false
     */
    private boolean validMove(int r, int c)
    {
        boolean valid;
        int rDiff, cDiff;
        valid = true;
        rDiff = r-Selector.selectedRow;
        cDiff = c-Selector.selectedColum;
        
        System.out.println("validMove()......");
        //System.out.printf("rDiff=%d,  cDiff=%d\n", rDiff,cDiff);
         
        if(Selector.selectedUnit.move.move instanceof PawnMovement)
        {
            if(Math.abs(cDiff)== Math.abs(rDiff)) valid=pawnDiagnolMove(r,c);
            else if (Math.abs(rDiff)>=1 && cDiff==0)
            {
                if(this.board.chessSquare[r][c].unit !=null) valid=false;
            }
            this.pawn=true;
        }
        else if((cDiff>1||cDiff<-1) && rDiff==0) valid= validHorizontal(c, cDiff); //check for horizontal movement
        else if(cDiff==0 && (rDiff>1 ||rDiff<-1)) valid= validVertical(r, rDiff); //check for vertical movement
        else if(Math.abs(cDiff)== Math.abs(rDiff) && (cDiff>1||cDiff<-1)) valid = validDiagnol(rDiff, cDiff); // check for diagnol movement
     
        
        return valid;
    
    }
    
    /*
     * returns true if the unit doesn't illegaly jump over other units on its horizontal movement
     * or else false
     */
    private boolean validHorizontal( int c, int diff)
    {
        boolean valid;
        valid = true;
        
        
        if(diff>0) //if positive
        {
            for(int i= Selector.selectedColum+1; i<c; i++)
            {
                if(this.board.chessSquare[Selector.selectedRow][i].unit!=null)
                {
                    valid =false;
                    break;
                }
            }
        }
        else  //if negative
        {
            for(int i= Selector.selectedColum-1; i>c; i--)
            {
                if(this.board.chessSquare[Selector.selectedRow][i].unit!=null)
                {
                    valid =false;
                    break;
                }
            }
        
        } 
        return valid;
    }
            
    /*
     * returns true if the unit doesn't illegaly jump over other units on its vertical movement
     * or else false
     */
    private boolean validVertical( int r, int diff)
    {
        boolean valid;
        valid = true;
        
        
        if(diff>0) //if positive
        {
            for(int i= Selector.selectedRow+1; i<r; i++)
            {
                if(this.board.chessSquare[i][Selector.selectedColum].unit!=null)
                {
                    valid =false;
                    break;
                }
            }
        }
        else //if negative
        {
            for(int i= Selector.selectedRow-1; i>r; i--)
            {
                if(this.board.chessSquare[i][Selector.selectedColum].unit!=null)
                {
                    valid =false;
                    break;
                }
            }
        
        } 
        return valid;
    }
    
    /*
     * returns true if the unit doesn't illegaly jump over other units on its vertical movement
     * or else false
     */
    private boolean validDiagnol( int rDiff, int cDiff)
    {
        boolean valid;
        valid = true;
        
        //if row diff is positive
        if(rDiff>0)
        {
           //if colum diff is positive
           if(cDiff>0)
           {
               for(int i=1; i<cDiff; i++)
               {
                   if(this.board.chessSquare[Selector.selectedRow+i][Selector.selectedColum+i].unit!=null)
                   {
                       valid=false;
                       break;
                   }
               }
           }
           else //if colum diff is negative
           {
             for(int i=1; i< (-1*cDiff); i++) // cDiff is negative so making it positive
               {
                   if(this.board.chessSquare[Selector.selectedRow+i][Selector.selectedColum-i].unit!=null)
                   {
                       valid=false;
                       break;
                   }
               }
           }
        }
        else //if row diff is negative
        {
           if(cDiff>0) //if colum diff is positive
           {
               for(int i=1; i<cDiff; i++)
               {
                   if(this.board.chessSquare[Selector.selectedRow-i][Selector.selectedColum+i].unit!=null)
                   {
                       valid=false;
                       break;
                   }
               }
           }
           else //if colum diff is negative
           {
             for(int i=1; i<(-1*cDiff); i++)
               {
                   if(this.board.chessSquare[Selector.selectedRow-i][Selector.selectedColum-i].unit!=null)
                   {
                       valid=false;
                       break;
                   }
               }
           }
        
        } 
        return valid;
    }
    
    /*
     * returns true if pawn's diagnol move is valid 
     * or else false
     */
    private boolean pawnDiagnolMove(int r, int c)
    {
        boolean valid;
        
        valid =true;
        
        System.out.println("pawnDiagnolMove()");
        if(this.board.chessSquare[r][c].unit==null) valid=false;
        
        
        return valid;
    }

    /**
     * Draws the selected units on their current position.
     * So, if a unit has moved then this will reflect that change on the graphics frame.
     * @param g
     * @param img 
     */
    public void draw(Graphics g, ImageObserver img) 
    {
        this.board.draw(g, img, Selector.selectedRow, Selector.selectedColum);
        
        if(moved)
        {
            this.board.draw(g, img, this.recentlyMovedUnit.position.row, this.recentlyMovedUnit.position.colum);
            this.recentlyMovedUnit.drawImage(g, img);
        }
        else this.recentlySelectedUnit.drawImage(g, img);
        
    }
    
}
