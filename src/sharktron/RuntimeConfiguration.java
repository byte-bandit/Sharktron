package sharktron;

import org.newdawn.slick.GameContainer;

/**
 * The configuration class serves as a database for 
 * @author kna
 */
public class RuntimeConfiguration
{
	public static float WINDOW_ASPECT_RATIO;
	public static int WINDOW_HEIGHT;
	public static int WINDOW_WIDTH;
	public static int WINDOW_SCREEN_HEIGHT;
	public static int WINDOW_SCREEN_WIDTH;
    public static GameContainer GAME_CONTAINER;
    
    public static final String PATH_TO_GFX = System.getProperty("user.dir") + "\\gfx\\";
}
