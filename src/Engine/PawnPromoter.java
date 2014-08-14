package Engine;

import GUI.*;
import Unit.UnitImage;
import Board.ChessBoard;
import Movement.BishopMovement;
import Movement.KnightMovement;
import Movement.QueenMovement;
import Movement.RookMovement;
import Unit.ChessUnit;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This is a PawnPromoter class that extends JFrame and implements Drawer.
 * This class is responsible for promoting Pawns.
 * Also, this acts like an external frame. 
 * @author thapaliya
 */
public class PawnPromoter extends JFrame implements Drawer
{
 
    JPanel promotioninfo = new JPanel();
    JPanel promotionSelect = new JPanel();
    ChessUnit promotablePawn;
    Controller observer;
    
    /**
     * 
     * @param w is the width of this frame
     * @param h is the height of this frame
     * @param ctr is the controller object
     */
    public PawnPromoter(int w, int h, Controller ctr)
    {
        observer =ctr;
        
        JLabel info = new JLabel();
        JButton queen = new JButton("Queen");
        JButton bishop = new JButton("Bishop");
        JButton knight = new JButton("Knight");
        JButton rook = new JButton("Rook");
        
        info.setSize(16, 16);
        info.setText("Select from the following units to promote your pawn now");
        promotioninfo.add(info);
        
        promotionSelect.setLayout(new GridLayout(1,4));
        promotionSelect.add(queen);
        promotionSelect.add(bishop);
        promotionSelect.add(knight);
        promotionSelect.add(rook);
        
        this.add(promotioninfo, BorderLayout.NORTH);
        this.add(promotionSelect);
        this.setSize(w, h);
        this.setTitle("Pawn Promotion");
        queen.addActionListener(new PawnPromoter.QueenPromotionListener());
        bishop.addActionListener(new PawnPromoter.BishopPromotionListener());
        knight.addActionListener(new PawnPromoter.KnightPromotionListener());
        rook.addActionListener(new PawnPromoter.RookPromotionListener());
        
    }
    
    /**
     * This needs to be called when a Pawn reaches the other end of the board
     * Then, this will pop up this promoter frame.
     * @param pawn is the pawn ready to be promoted
     */
    public void promote(ChessUnit pawn)
    {
        this.setVisible(true);
        this.setResizable(false);
        promotablePawn = pawn;
    }
    /**
     * Updates the pawns image to the selected unit
     */
    public void updateImage()
    {
        observer.update(this);
    }
    
    /**
     * Closes this frame
     */
    public void close()
    {
        this.dispose();
    }

    /**
     * Draws the new selected unit in place of the pawn
     * @param g is the graphics object
     * @param img is the ImageObserver object
     */
    public void draw(Graphics g, ImageObserver img) 
    {
        ChessBoard.chessSquare[promotablePawn.position.row][promotablePawn.position.colum].draw(g, img);
        promotablePawn.drawImage(g, img);
    }
    
    class QueenPromotionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            promotablePawn.move.addMovement(new QueenMovement());
            if(promotablePawn.teamNumber==1) promotablePawn.setImage(UnitImage.queen1);
            else promotablePawn.setImage(UnitImage.queen2);
            updateImage();
            close();
        }
    }
    
    class BishopPromotionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            promotablePawn.move.addMovement(new BishopMovement());
            if(promotablePawn.teamNumber==1) promotablePawn.setImage(UnitImage.bishop1);
            else promotablePawn.setImage(UnitImage.bishop2);
            updateImage();
            close();
        }
    }
    
    class KnightPromotionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            promotablePawn.move.addMovement(new KnightMovement());
            if(promotablePawn.teamNumber==1) promotablePawn.setImage(UnitImage.knight1);
            else promotablePawn.setImage(UnitImage.knight2);
            updateImage();
            close();
        }
    }
    
    class RookPromotionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            promotablePawn.move.addMovement(new RookMovement());
            if(promotablePawn.teamNumber==1) promotablePawn.setImage(UnitImage.rook1);
            else promotablePawn.setImage(UnitImage.rook2);
            updateImage();
            close();
        }
    }
}
