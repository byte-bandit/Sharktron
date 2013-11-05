package sharktron;

//~--- non-JDK imports --------------------------------------------------------

import sharktron.gameObjects.Player;
import org.newdawn.slick.*;

import sharktron.logic.UpdateManager;
import sharktron.input.InputManager;
import sharktron.logic.GameProgressionManager;

import sharktron.rendering.GFXLib;
import sharktron.rendering.RenderingManager;
import sharktron.sound.SoundLibrary;

/**
 * Main Class
 * @author Kna
 */
public class Sharktron extends BasicGame {
    private Player player;

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

        // Always keep this first!
        loadRuntimeConfiguration(gc);

        // Always keep this second!
        GFXLib.init();
        SoundLibrary.init();
        
        InputManager.init();
        GameProgressionManager.init();
        
        player = new Player(100, 100);
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
        UpdateManager.update(gc, delta);
        GameProgressionManager.update(gc, delta);
        
        player.update(gc, delta);
        
        if (InputManager.isEscKeyDown())
        {
            gc.exit();
        }
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
        RenderingManager.render(g);
        player.draw(g);
        
        g.drawString("UpdateManager: " + UpdateManager.size(), 10, 32);
        g.drawString("RenderManager: " + RenderingManager.size(), 10, 64);
    }

    /**
     *
     * @param args
     * @throws SlickException
     */
    public static void main(String[] args) throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new Sharktron());

        app.setVSync(true);
        app.setSmoothDeltas(true);
        app.setTargetFrameRate(60);
        app.setDisplayMode(800, 600, false);
        app.setMouseGrabbed(true);
        app.start();
    }

    /**
     * Loads all relevant runtime information into the config
     */
    private void loadRuntimeConfiguration(GameContainer gc)
    {
        RuntimeConfiguration.WINDOW_ASPECT_RATIO  = gc.getAspectRatio();
        RuntimeConfiguration.WINDOW_HEIGHT        = gc.getHeight();
        RuntimeConfiguration.WINDOW_WIDTH         = gc.getWidth();
        RuntimeConfiguration.WINDOW_SCREEN_HEIGHT = gc.getScreenHeight();
        RuntimeConfiguration.WINDOW_SCREEN_WIDTH  = gc.getScreenWidth();
        RuntimeConfiguration.GAME_CONTAINER       = gc;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
