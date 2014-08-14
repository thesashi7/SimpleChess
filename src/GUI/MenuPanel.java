
package GUI;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author thapaliya
 */
public class MenuPanel extends JPanel 
{
    public JButton singlePlayer, multiPlayer, exit;
    public JPanel []panel;
    public Image bgImage;        
    
    public MenuPanel()
    {
        singlePlayer  = new JButton("SinglePlayer");
        multiPlayer = new JButton("Multiplayer");
        exit = new JButton("Exit");
        panel = new JPanel[3];
    
        panel[0]= new JPanel();
        panel[1]= new JPanel();
        panel[2]= new JPanel();
        
        panel[0].add(singlePlayer);
        panel[1].add(multiPlayer);
        panel[2].add(exit);
        this.add(panel[0]);
        this.add(panel[1]);
        this.add(panel[2]);
    }
    public void setBackgroundImage (Image bg) 
    {
        this.bgImage=bg;
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, null);
    }
}
