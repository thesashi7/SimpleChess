
package Engine;

/**
 * This is a Position class. 
 * Especially built to represent position of a ChessUnit with rows and columns.
 * But, this can be used for other types of units or objects with rows, columns, 
 * x, and y axis.
 * @author thapaliya
 */
public class Position {

    public int x, y,row, colum;
    
    /**
     * Default Constructor
     **/
    public Position()
    {}
    
    /**
     * CONSTURCTOR
     * @param r is th row 
     * @param c is th colum
     */
    public Position(int r, int c)
    {
        this.row=r;
        this.colum=c;
    }
    
    /**
     * Sets the row of this position 
     * @param r 
     */
    public void setRow(int r)
    {
        this.row=r;
    }
    
    /**
     * Sets the colum of this position.
     * @param c 
     */
    public void setColum(int c)
    {
        this.colum=c;
    }
}
