package sharktron.controlling;

import java.util.LinkedList;
import org.newdawn.slick.GameContainer;

/**
 * This class provides bootstrap functionality for rendering purposes
 * @author Kna
 */
public class UpdateManager
{
    
    private static LinkedList<IUpdateable> children = new LinkedList<IUpdateable>();
    
    /**
     * Add a child to the manager
     * @param child The child to add
     */
    public static void addChild(IUpdateable child)
    {
        children.add(child);
    }
    
    /**
     * Remove a child from the manager
     * @param child The child to remove
     */
    public static void removeChild(IUpdateable child)
    {
        children.remove(child);  
    }
    
    /**
     * Updates all children.
     * @param gc The game controller of the main module.
     * @param delta  The delta element of the main module.
     */
    public static void update(GameContainer gc, int delta)
    {
        for(IUpdateable i : children)
        {
            i.update(gc, delta);
        }
    }
}
