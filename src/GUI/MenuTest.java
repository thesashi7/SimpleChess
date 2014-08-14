/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author thapaliya
 */
public class MenuTest extends JFrame 
{
    
     public JButton singlePlayer, multiPlayer, exit;
     
     public MenuTest()
     {
         JPanel panel1 = new JPanel();
         JPanel panel2 = new JPanel();
         
         singlePlayer = new JButton("SinglePlayer");
         multiPlayer = new JButton("Multiplayer");
         exit = new JButton("Exit");
         
         
         panel1.add(exit);
         panel1.setLocation(this.getWidth()/2, this.getHeight()/2);
        
        // panel1.setLayout(new GridLayout());
         
         panel1.setPreferredSize(new Dimension(50,50));
         this.add(panel1, BorderLayout.NORTH);
         this.getContentPane().setBackground(Color.yellow);
         
         
     
     }
    
}


class tst
{

    public static void main(String[]args)
    {
        MenuTest menu = new MenuTest();
        
        //menu.getContentPane().setBackground(Color.BLACK);
        menu.setSize(600, 600);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    }

}
