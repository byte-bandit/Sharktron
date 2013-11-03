package sharktron.sound;

import java.io.IOException;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;
import static sharktron.RuntimeConfiguration.PATH_TO_SFX;

/**
 * Provides functionality to access sound effects and music.
 * 
 * @author acrynx
 */
public class SoundLibrary
{
    private static Audio sound;
    
    /**
     * Loads and returns a sound effect or music track with the given file name.
     * 
     * @param fileName Name of sound file
     * @return Sound as Audio object
     */
    public static Audio getSound(String fileName)
    {
        loadSound(fileName);
        return sound;
    }
    
    /**
     * Loads a sound effect or music track with the given file name.
     */
    private static void loadSound(String fileName)
    {
        try
        {
            sound = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream(PATH_TO_SFX + fileName + ".ogg"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
