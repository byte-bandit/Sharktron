package sharktron.logic;

import java.util.Iterator;
import java.util.LinkedList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import sharktron.ai.Swarm;
import sharktron.ai.Wave;
import sharktron.gameObjects.bots.Bot;
import sharktron.gameObjects.bots.Jack;

/**
 * This class is managing all levels (stages) of the game, returning them in the
 * correct order.
 *
 * @author Kna
 */
public class GameProgressionManager
{

    private static LinkedList<Stage> stages;
    private static LinkedList<Bot> activeBots;
    private static Iterator<Stage> iterator;
    private static Stage currentStage;
    
    /**
     * Initializes the GameProgressionManager.
     */
    public static void init()
    {
        stages = new LinkedList<Stage>();
        activeBots = new LinkedList<Bot>();
        
        Stage firstStage = new Stage();
        Wave firstWave = new Wave();
        Swarm firstSwarm = new Swarm();
        firstSwarm.addBot(new Jack());
        firstWave.addSwarm(firstSwarm);
        firstStage.addWave(firstWave);
        
        stages.add(firstStage);
        
        getFirstStage();
        firstStage.getNextWave();
        firstWave.getNextSwarm();
    }
    
    /**
     * Gets a List of all currently active bots on screen
     * @return The list of all active bots.
     */
    public static LinkedList<Bot> getActiveBots()
    {
        return activeBots;
    }
    
    /**
     * Adds a bot to the list of currently active bots on screen
     * @param b The bot to add
     */
    public static void addBot(Bot b)
    {
        activeBots.add(b);
    }
    
    /**
     * Remove a bot from the list of currently active bots.
     * @param b The bot to remove
     */
    public static void removeBot(Bot b)
    {
        activeBots.remove(b);
    }

    /**
     * Adds a stage to the Game.
     *
     * @param s The stage to add.
     */
    public static void AddStage(Stage s)
    {
        stages.add(s);
    }

    /**
     * Remove a stage from the Game.
     *
     * @param s The stage to be removed.
     */
    public static void RemoveStage(Stage s)
    {
        stages.remove(s);
    }

    /**
     * Gets all stages of the Game as a LinkedList of stage.
     *
     * @return An enumeration of all stages in the game.
     */
    public static LinkedList<Stage> GetStages()
    {
        return stages;
    }

    /**
     * Returns the currently active stage.
     *
     * @return The currently active stage.
     */
    public static Stage getCurrentStage()
    {
        return currentStage;
    }

    /**
     * Sets the currently active stage.
     *
     * @param s The stage to be set as active
     */
    private static void setCurrentStage(Stage s)
    {
        if (currentStage != s)
        {
            currentStage = s;
        }
    }

    /**
     * Returns the first stage of the game.
     *
     * @return The first stage.
     */
    public static Stage getFirstStage()
    {
        iterator = stages.iterator();

        if (iterator.hasNext())
        {
            setCurrentStage(iterator.next());
            return getCurrentStage();
        }
        else
        {
            return null;
        }
    }

    /**
     * Returns the next (subsequential) stage of the game.
     *
     * @return The next (or first) stage, null if current stage is last stage.
     */
    public static Stage getNextStage()
    {
        if (iterator == null)
        {
            return getFirstStage();
        }
        else
        {
            if (iterator.hasNext())
            {
                setCurrentStage(iterator.next());
                return getCurrentStage();
            }
            else
            {
                return null;
            }
        }
    }
    
    /**
     * Updates the Level logic
     * @param gc
     * @param delta 
     */
    public static void update(GameContainer gc, int delta)
    {
        getCurrentStage().update(gc, delta);
    }
    
    /**
     * Calls the draw method on all elements in the current stage
     * @param g Graphics object to use for drawing
     */
    public static void draw(Graphics g)
    {
        getCurrentStage().draw(g);
    }
}
