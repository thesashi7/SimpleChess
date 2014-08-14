/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Board.ChessBoard;
//import Chess.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;



/**
 *
 * @author thapaliya
 */
public class MainMenu extends JApplet
{
   
    public MenuPanel menuPanel;
   // public CardLayout frames = new CardLayout();
    
    public void init(int width, int height)
    {
        menuPanel = new MenuPanel();

        this.setSize(width,height);
        this.setVisible(true);
        
        initBackground(width, height);
        this.setLayout(new GridLayout(3,1));
        initMenuPanel(width, height);
        
        this.add(new JLabel());
        this.add(menuPanel);
        
      
     }
    
    @Override
    public void init()
    {
        int width,height;
        width=800;
        height =600;
        
        menuPanel = new MenuPanel();
        this.setSize(width,height);
        
        initBackground(width, height);
        this.setLayout(new GridLayout(3,1));
        initMenuPanel(width, height);
    }
    
    
    private void initBackground(int w, int h)
    {
        Image bgImage;
        
        try 
        {
            bgImage = ImageIO.read(this.getClass().getResource("chessg.jpg"));
            bgImage = bgImage.getScaledInstance(w, h, 1);
            this.setLayout(new BorderLayout());
            this.setContentPane(new JLabel(new ImageIcon(bgImage)));
            this.setLayout(new FlowLayout());
            this.setSize(w-1,h-1);
            this.setSize(w,h);
        } catch (IOException ex) 
        {
           System.err.println(ex.toString());
        }
    }
    
    private void initMenuPanel(int w, int h)
    {
        GridLayout gridLayout = new GridLayout(3,1);
        gridLayout.setVgap(50);
        gridLayout.setHgap(50);
        
        this.menuPanel.singlePlayer.addActionListener(new SinglePlayerListner());
        this.menuPanel.multiPlayer.addActionListener(new MultiPlayerListner());
        
        //menuPanel.setBorder(new BevelBorder(1, Color.LIGHT_GRAY,Color.LIGHT_GRAY));
        try
        {
            menuPanel.setLayout(gridLayout);
            menuPanel.setBackground(Color.DARK_GRAY);
            menuPanel.panel[0].setBackground(Color.DARK_GRAY);
            menuPanel.panel[1].setBackground(Color.DARK_GRAY);
            menuPanel.panel[2].setBackground(Color.DARK_GRAY);

        }
        catch(Exception ex)
        {
            System.err.println(ex.toString());
        }
    }
 

    
    
    class SinglePlayerListner implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
           
            
        }
    }
    
    class MultiPlayerListner implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
        
        }
    }
    
    
}
/*
class Test
{
    public static void main(String[]args)
    {
            int w,h;
        JFrame f;
        MainMenu gm;
        
        gm =  new MainMenu();
        f = new JFrame("Chess");
        w=800;
        h=600;
        
        gm.init();
        
        f.addWindowListener(new WindowAdapter() {});
        f.getContentPane().add("Center", gm);
        f.pack();
        f.setVisible(true);
        f.setSize(w+15, h+32);
       // f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
  
    
    }

}*/