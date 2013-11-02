package sharktron.rendering;

import java.util.LinkedList;
import org.newdawn.slick.Graphics;

/**
 * This class provides bootstrap functionality for rendering purposes
 * @author Kna
 */
public class RenderingManager
{
    
    private static LinkedList<IDrawable> children = new LinkedList<IDrawable>();
    
    /**
     * Add a child to the manager
     * @param child The child to add
     */
    public static void addChild(IDrawable child)
    {
        children.add(child);
    }
    
    /**
     * Remove a child from the manager
     * @param child The child to remove
     */
    public static void removeChild(IDrawable child)
    {
        children.remove(child);  
    }
    
    /**
     * Will call the render method to all of its children
     * @param g The graphics module of the main frame
     */
    public static void render(Graphics g)
    {
        for(IDrawable d : children)
        {
            d.draw(g);
        }
    }
}
