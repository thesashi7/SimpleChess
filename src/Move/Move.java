
package Move;


/**
 * This is an abstract Move class that implements the Moveable interface.
 * So, this needs be extended to handle proper specific movement.
 * @author thapaliya
 */
public abstract class Move implements Moveable{
    
    public Object move; // object that handles the movement
    
    @Override
    public void addMovement(Object mov)
    {
        this.move= mov;
    }

}
