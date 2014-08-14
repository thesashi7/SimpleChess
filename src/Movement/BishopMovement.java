
package Movement;



/**
 * This is a sub class of ChessUnitMovement which is especially built to handle Bishop's movement.
 * @author thapaliya
 */
public class BishopMovement extends ChessUnitMovement
{

    @Override
    public boolean acceptMove(int currentRow, int currentColum, int desiredRow, int desiredColum) 
    {
        int rowDiff,colDiff;
        rowDiff= Math.abs(desiredRow-currentRow);
        colDiff= Math.abs(desiredColum-currentColum);
        
        if(rowDiff==colDiff && rowDiff!=0) return true;
        return false;
    }
    
}
