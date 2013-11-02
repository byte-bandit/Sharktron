package sharktron.logic;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class is managing all levels (stages) of the game, returning them in the
 * correct order.
 *
 * @author Kna
 */
public class GameProgressionManager
{

    private static LinkedList<Stage> stages;
    private static Iterator<Stage> iterator;
    private static Stage currentStage;

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
}
