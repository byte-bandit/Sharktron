package sharktron;

import org.newdawn.slick.*;


/**
 * Main Class
 * @author Kna
 */
public class Sharktron extends BasicGame
{
	
  	/**
	 * Konstruktor
	 */
	public Sharktron()
    {
        super("Hello World");
    }
 
  	/**
	 *
	 * @param gc The game Controller
	 * @throws SlickException
	 */
	@Override
    public void init(GameContainer gc) throws SlickException
    {
        loadRuntimeConfiguration(gc);

        System.out.println(System.getProperty("user.dir"));
        // GFXLibrary.init();
    }
 
  	/**
	 *
	 * @param gc
	 * @param delta
	 * @throws SlickException
	 */
	@Override
    public void update(GameContainer gc, int delta) throws SlickException
    {
	  
    }
 
  	/**
	 *
	 * @param gc
	 * @param g
	 * @throws SlickException
	 */
	@Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        
    }
 
  	/**
	 *
	 * @param args
	 * @throws SlickException
	 */
	public static void main(String[] args) throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new Sharktron());
        app.setDisplayMode(800, 600, false);
        app.start();
    }

    /**
     * Loads all relevant runtime information into the config
     */
    private void loadRuntimeConfiguration(GameContainer gc)
    {
        RuntimeConfiguration.WINDOW_ASPECT_RATIO = gc.getAspectRatio();
        RuntimeConfiguration.WINDOW_HEIGHT = gc.getHeight();
        RuntimeConfiguration.WINDOW_WIDTH = gc.getWidth();
        RuntimeConfiguration.WINDOW_SCREEN_HEIGHT = gc.getScreenHeight();
        RuntimeConfiguration.WINDOW_SCREEN_WIDTH = gc.getScreenWidth();
    }
}