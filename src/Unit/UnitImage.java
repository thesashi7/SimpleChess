
package Unit;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * This is a UnitImage class. 
 * Basically, this class is a stores all the images of the chess piece units to be used in the game.
 * By using this class the other classes will not have to worry about getting the image directly.
 * @author thapaliya
 */
public class UnitImage 
{
    public static Image units, queen1,king1, bishop1, knight1, rook1,pawn1, queen2,king2, bishop2, knight2, rook2,pawn2;
   
    public UnitImage()
    {
        BufferedImage bImage;
        
        try
        {
            units = (Image)ImageIO.read(this.getClass().getClassLoader().getResource("resources/units.png"));
            bImage = new BufferedImage(units.getWidth(null), units.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = bImage.createGraphics();
            g.drawImage(this.units, 0, 0, null);
            g.dispose();
            initUnits(bImage);
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
    
    public void initUnits(BufferedImage bImg)
    {
        int width, height;
        width = bImg.getWidth()/6;
        height = bImg.getHeight()/2;
        
        queen1 = bImg.getSubimage(5*width,0, width, height);
        king1 = bImg.getSubimage(4*width,0, width, height);
        rook1 = bImg.getSubimage(3*width,0, width, height);
        knight1 = bImg.getSubimage(2*width,0, width, height);
        bishop1 = bImg.getSubimage(width,0, width, height);
        pawn1 = bImg.getSubimage(0,0, width, height);
        
        queen2 = bImg.getSubimage(5*width,height, width, height);
        king2 = bImg.getSubimage(4*width,height, width, height);
        rook2 = bImg.getSubimage(3*width,height, width, height);
        knight2 = bImg.getSubimage(2*width,height, width, height);
        bishop2 = bImg.getSubimage(width,height, width, height);
        pawn2 = bImg.getSubimage(0,height, width, height);
        
    }
   
}
