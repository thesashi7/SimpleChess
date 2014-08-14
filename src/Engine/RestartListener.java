
package Engine;

import GUI.*;

/**
 * This is an interface RestartListener. 
 * This is a general abstraction for a restart event. So, can be implemented by any object that wants to restart a process.
 * @author thapaliya
 */
public interface RestartListener 
{
    /**
     * The implementing class is responsible to cause a restart of some process through this function.
     */
    public void restart();
    
}
