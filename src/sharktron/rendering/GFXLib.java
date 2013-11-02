package sharktron.rendering;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import sharktron.RuntimeConfiguration;

public class GFXLib
{
    
    private static Image imgPlayer;
    
    /**
     * Initializes the GFX Library and loads all image data from the harddrive
     */
    public static void init()
    {
        try
        {
            imgPlayer = new Image(RuntimeConfiguration.PATH_TO_GFX + "left-0.png");
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
    public static Image player()
    {
        return imgPlayer;
    }

}
