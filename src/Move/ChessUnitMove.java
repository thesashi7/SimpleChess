
package Move;


import Movement.ChessUnitMovement;



/**
 * This is a subclass of Move which is especially designed for Chess Units.
 * @author thapaliya
 */
public class ChessUnitMove extends Move
{
        
    @Override
    public void addMovement(Object mov)
    {
        this.move= (ChessUnitMovement)mov;
    }
      
    /**
     * Returns true if the movement of this ChessUnit from the current position to the given destinationRow and destinationColum is valid
     * Or else returns false
     * Also, validity is only checked in terms of a unit's movement rules rather than in terms of the whole game and other units. 
     * @param destinationRow
     * @param destinationColum 
     * 
     */
    public boolean move(int currentRow,int currentColum,int destinationRow, int destinationColum)
    {
       return (((ChessUnitMovement)this.move).acceptMove(currentRow, currentColum, destinationRow, destinationColum));
       
    }
}
