
package Movement;



/**
 * This is a sub class of ChessUnitMovement which is especially built to handle King movement.
 * @author thapaliya
 */
public class KingMovement extends ChessUnitMovement
{

    @Override
    public boolean acceptMove(int currentRow, int currentColum, int desiredRow, int desiredColum) 
    {
        int rowDiff, columDiff;
        rowDiff = Math.abs(desiredRow-currentRow);
        columDiff = Math.abs(desiredColum-currentColum);
        
        if((rowDiff==1 && columDiff==0) || (rowDiff==0 && columDiff==1) || (rowDiff==1 && columDiff==1)) return true;
        return false;
    }
    
}
