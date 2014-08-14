
package Movement;



/**
 * This is an abstract class ChessUnitMovement. 
 * It is built to handle chess units movement.
 * This class must be implemented to support a units movement.
 * @author thapaliya
 */
public abstract class ChessUnitMovement
{
    /**
     * 
     * @param currentRow of the unit
     * @param currentColum of the unit
     * @param desiredRow for the unit
     * @param desiredColum for the unit
     * @return true if the move of this chess unit from the current position to the 
     * desired position is valid for this unit.
     */
    public abstract boolean acceptMove( int currentRow, int currentColum, int desiredRow, int desiredColum);
}
