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
    
    /**
     * Initializes the GFX Library and loads all image data from the harddrive
     */
    public static void init()
    {
        try
        {
            imgPlayer = new SpriteSheet(RuntimeConfiguration.PATH_TO_GFX + "player.png", 62, 57);
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

}
