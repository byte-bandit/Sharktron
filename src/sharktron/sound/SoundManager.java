package sharktron.sound;

import org.newdawn.slick.openal.Audio;

/**
 * Provides functionality to use sound effects and music.
 * 
 * @author acrynx
 */
public class SoundManager
{

    /**
     * Plays a given Audio object as sound effect.
     * Effect is not looped.
     * 
     * @param sound Sound as Audio object
     */
    public static void playAsSoundEffect(Audio sound)
    {
        sound.playAsSoundEffect(1.0f, 1.0f, false);
    }
    
    /**
     * Plays a given Audio object as music track.
     * Music is looped.
     * 
     * @param sound Sound as Audio object
     */
    public static void playAsMusic(Audio sound)
    {
        sound.playAsMusic(1.0f, 1.0f, true);
    }
}
