
package Movement;

/**
 * This is a sub class of ChessUnitMovement which is especially built to handle Knights movement.
 * @author thapaliya
 */
public class KnightMovement extends ChessUnitMovement{

    @Override
    public boolean acceptMove(int currentRow, int currentColum, int desiredRow, int desiredColum) 
    {
        int rowDiff, colDiff;
        rowDiff = Math.abs(desiredRow-currentRow);
        colDiff = Math.abs(desiredColum-currentColum);
        
        if(rowDiff==2 && colDiff==1 || (rowDiff==1 && colDiff==2)) return true;
        return false;
    }
    
}
