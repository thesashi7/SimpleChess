
package Movement;

/**
 * This is a sub class of ChessUnitMovement which is especially built to handle Pawn's movement.
 * @author thapaliya
 */
public class PawnMovement extends ChessUnitMovement{
    
    public byte firstMove; // to handle pawns intial movement which can be two steps forward
    private int moveDown;  // to handle the direction of the pawns movement as it does not move backward
    
    /**
     * Gets 1 for move if pawn is facing down or else 0
     * @param move 
     */
    public PawnMovement(int move)
    {
        this.moveDown=move;
        this.firstMove=0;
    }


    @Override
    public boolean acceptMove(int currentRow, int currentColum, int desiredRow, int desiredColum) 
    {
        int rowDiff,colDiff;
        rowDiff = desiredRow-currentRow;
        colDiff = Math.abs(desiredColum-currentColum);
        
        if(moveDown==1) return movingDown(rowDiff, colDiff);
        else return movingUp(rowDiff, colDiff);
        
    }
    
    private boolean movingUp(int rowDiff, int colDiff)
    {
        if(rowDiff==-1 && (colDiff==0||colDiff==1))
        {
            firstMove=1;
            return true;
        }
        else if(firstMove==0 && (rowDiff==-2 && colDiff==0))
        {
            firstMove=1;
            return true;
        }
        
       return false;  
    }
    
    
    private boolean movingDown(int rowDiff, int colDiff)
    {
        if(rowDiff==1 && (colDiff==0||colDiff==1))
        {
            firstMove=1;
            return true;
        }
        else if (firstMove==0 && (rowDiff==2 && colDiff==0)) 
        {
            firstMove=1;
            return true;
        }
        return false;
    }
    
}
