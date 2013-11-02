package sharktron.rendering;

import java.util.Iterator;
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
     * Returns the number of children.
     * @return The number of children.
     */
    public static int size()
    {
        return children.size();
    }
    
    /**
     * Will call the render method to all of its children
     * @param g The graphics module of the main frame
     */
    public static void render(Graphics g)
    {
        Iterator<IDrawable> i = children.iterator();
        
        while(i.hasNext())
        {
            i.next().draw(g);
        }
    }
}
