package sharktron.rendering;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Point;

/**
 * Represents the base class of a drawable game component and features attributes such as the position
 * @author Kna
 */
public abstract class DrawableGameComponent
{
    protected Point position;
    protected Color filter = Color.white;
    
    /**
     * Creates a new Instance.
     */
    public DrawableGameComponent()
    {
        this.position = new Point(0, 0);
    }
    
    /**
     * Creates a new Instance at the given position.
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public DrawableGameComponent(int x, int y)
    {
        this.position = new Point(x, y);
    }
    
    /**
     * Creates a new Instance at the given position.
     * @param pos The Slick2D Point holding the positions x and y coordinates
     */
    public DrawableGameComponent(Point pos)
    {
        this.position = new Point(pos.getX(), pos.getY());
    }
         
    /**
     * Get the value of position
     *
     * @return the value of position
     */
    public Point getPosition()
    {
        return position;
    }
    
    /**
     * Get the X value of position
     *
     * @return the X value of position
     */
    public int getPositionX()
    {
        return (int) position.getX();
    }
    
    /**
     * Get the Y value of position
     *
     * @return the Y value of position
     */
    public int getPositionY()
    {
        return (int) position.getY();
    }
}
