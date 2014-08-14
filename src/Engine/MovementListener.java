/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import GUI.*;
import Board.ChessSquare;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This is a MovementListener class that extends MouseAdapter and is specifically built for Chess Game.
 * But, it can be used for any GUI that requires the account of a row an colum position in the frame.
 * @author thapaliya
 */
public class MovementListener extends MouseAdapter 
{
    public int scalingWidth, scalingHeight;
    public Controller controller;
    
    /**
     * 
     * @param ctr is a Controller object
     * @param w
     * @param h 
     */
    public MovementListener(Controller ctr, int w, int h)
    {
       this.controller=ctr;
       this.scalingWidth=w;
       this.scalingHeight=h;
    }
    

    
    @Override
    public void mouseClicked(MouseEvent me)
    {
        int row, colum;
        
        row=me.getY()/this.scalingHeight;
        colum=me.getX()/this.scalingWidth;
        System.out.printf("row = %d, colum=%d\n",row, colum);
        
        this.controller.click(row,colum);
    }
    
    
    
}
