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
     * 
     * @param sound  Sound as Audio object
     */
    public static void playAsSoundEffect(Audio sound)
    {
        sound.playAsSoundEffect(1.0f, 1.0f, false);
    }
    
    /**
     * Plays a given Audio object as sound effect.
     * 
     * @param sound  Sound as Audio object
     * @param volume Volume from 0.0 to 1.0
     */
    public static void playAsSoundEffect(Audio sound, float volume)
    {
        sound.playAsSoundEffect(1.0f, volume, false);
    }
    
    /**
     * Plays a given Audio object as sound effect.
     * 
     * @param sound  Sound as Audio object
     * @param loop   Loop this sound sample
     */
    public static void playAsSoundEffect(Audio sound, boolean loop)
    {
        sound.playAsSoundEffect(1.0f, 1.0f, loop);
    }
    
    /**
     * Plays a given Audio object as sound effect.
     * 
     * @param sound  Sound as Audio object
     * @param volume Volume from 0.0 to 1.0
     * @param loop   Loop this sound sample
     */
    public static void playAsSoundEffect(Audio sound, float volume, boolean loop)
    {
        sound.playAsSoundEffect(1.0f, volume, loop);
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
    
    /**
     * Plays a given Audio object as music track.
     * Music is looped.
     * 
     * @param sound Sound as Audio object
     * @param volume Volume from 0.0 to 1.0
     */
    public static void playAsMusic(Audio sound, float volume)
    {
        sound.playAsMusic(1.0f, volume, true);
    }
    
    /**
     * Plays a given Audio object as music track.
     * Music is looped.
     * 
     * @param sound Sound as Audio object
     * @param loop   Loop this sound sample
     */
    public static void playAsMusic(Audio sound, boolean loop)
    {
        sound.playAsMusic(1.0f, 1.0f, loop);
    }
    
    /**
     * Plays a given Audio object as music track.
     * Music is looped.
     * 
     * @param sound Sound as Audio object
     * @param volume Volume from 0.0 to 1.0
     * @param loop   Loop this sound sample
     */
    public static void playAsMusic(Audio sound, float volume, boolean loop)
    {
        sound.playAsMusic(1.0f, volume, loop);
    }
}
