
package Move;

/**
 * This is an interface Moveable which can be implemented by any Object that has the 
 * ability to move
 * @author thapaliya
 */
public interface Moveable
{
    /**
     * Sets the movement object as the parameter mov which should be the object that will be responsible for
     * movement.
     * @param mov 
     */
    public abstract void addMovement(Object mov);
}
