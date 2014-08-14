/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.imageio.ImageIO;


/**
 * This is a class for a ChessBoard. 
 * Uses ChessSquare objects as squares. 
 * @author thapaliya
 */
public class ChessBoard 
{
    private int boardWidth, boardHeight;
    public static ChessSquare chessSquare[][];
    
    
    /**
      * Constructor for the ChessBoard 
      * Takes in the width and height of the board from the parameter.
      * w is the width of the board
      * h is the height of the board
    **/
    public ChessBoard(int w, int h)
    {
        this.boardWidth=w;
        this.boardHeight=h;
        
        initSquare();
      
    }
    
    /*
     * Initializes or sets up all the required squares of the board.
     */
    private void initSquare()
    {
        Image board;
        BufferedImage bBoard;
        int  width,height;
        
        try
        {
            board = ImageIO.read(this.getClass().getClassLoader().getResource("resources/Board.gif"));
            board = board.getScaledInstance(boardWidth, boardHeight, 1);
           
            // Create a buffered image with transparency
            bBoard = new BufferedImage(board.getWidth(null), board.getHeight(null), BufferedImage.TYPE_INT_ARGB);

            // Draw the image on to the buffered image
            Graphics2D g = bBoard.createGraphics();
            g.drawImage(board, 0, 0, null);
            g.dispose();
            
            width = board.getWidth(null)/8;
            height = board.getHeight(null)/8;
            this.chessSquare = new ChessSquare[8][8];
            ChessSquare.width = width;
            ChessSquare.height = height;
            
           // System.out.println("BoardWidth = "+board.getWidth(null)+" BoardHeight="+ board.getHeight(null));
            //System.out.println("Width = "+width+" Height="+ height);
            
            for(int r=0; r<8; r++)
            { 
                for(int c=0; c<8; c++)
                {
                    this.chessSquare[r][c]= new ChessSquare(bBoard.getSubimage(r*height, c*width, width, height),r,c,c*width,r*height);
                    
                       
                }
            }
               
           
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
    
    /**
     * Draws the board with all the squares. 
     * 
    **/
    public void draw(Graphics g, ImageObserver imgObs)
    {
        for(int r=0; r<this.chessSquare.length; r++)
        {   
            for(int c=0; c< this.chessSquare.length; c++)
                this.chessSquare[r][c].draw(g, imgObs);
        }
    }
    
    /**
     * Draws the square at the specefic row and colum
     * @param g
     * @param imgObs
     * @param row
     * @param colum 
     */
    public void draw(Graphics g, ImageObserver imgObs, int row, int colum)
    {
        this.chessSquare[row][colum].draw(g, imgObs);
    }



}
