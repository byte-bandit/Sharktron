package sharktron.rendering;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import sharktron.RuntimeConfiguration;

/**
 * Can be used to get an image at any given time.
 * @author Kna
 */
public class GFXLib
{
    
    private static SpriteSheet imgPlayer;
    private static Image imgRedBullet;
    private static SpriteSheet imgJack;
    
    /**
     * Initializes the GFX Library and loads all image data from the harddrive
     */
    public static void init()
    {
        try
        {
            imgPlayer = new SpriteSheet(RuntimeConfiguration.PATH_TO_GFX + "player.png", 54, 102);
            imgJack = new SpriteSheet(RuntimeConfiguration.PATH_TO_GFX + "jack.png", 32, 32);
            imgRedBullet = new Image(RuntimeConfiguration.PATH_TO_GFX + "redBullet.png");
                
        }
        catch (SlickException ex)
        {
            Logger.getLogger(GFXLib.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Returns the Player GFX
     * @return Player GFX
     */
    public static SpriteSheet getPlayerSpriteSheet()
    {
        return imgPlayer;
    }
    
    /**
     * Returns the Jack GFX
     * @return Jack GFX
     */
    public static SpriteSheet getJackSpriteSheet()
    {
        return imgJack;
    }
    
    /**
     * Returns an image of a red bullet.
     * @return The red bullet.
     */
    public static Image getBulletRed()
    {
        return imgRedBullet;
    }

}
