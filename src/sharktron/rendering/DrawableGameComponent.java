package sharktron.rendering;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import sharktron.logic.IUpdateable;

/**
 * Represents the base class of a drawable game component and features
 * attributes such as the position
 *
 * @author Kna
 */
public abstract class DrawableGameComponent implements IDrawable, IUpdateable
{

    protected Point position;
    protected Color filter = Color.white;
    protected Renderable gfx;
    protected Rectangle boundingBox;
    protected boolean disposable;

    /**
     * Creates a new Instance.
     */
    public DrawableGameComponent()
    {
        this.position = new Point(0, 0);
    }

    /**
     * Creates a new Instance at the given position.
     *
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public DrawableGameComponent(int x, int y)
    {
        this.position = new Point(x, y);
    }

    /**
     * Creates a new Instance at the given position.
     *
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
     * Return the bounding box of the gfx element.
     *
     * @return The bounding box as a Rectangle.
     */
    public Rectangle getBoundingBox()
    {
        return this.boundingBox;
    }

    /**
     * Checks whether the Component collides with another component
     *
     * @param component The component to check against
     * @return True if a collision is happening
     */
    public boolean isColliding(DrawableGameComponent component)
    {
        return this.getBoundingBox().intersects(component.getBoundingBox());
    }

    @Override
    public void update(GameContainer gc, int delta)
    {
        if (this.gfx.getClass() == Image.class)
        {
            this.boundingBox = new Rectangle(this.getPosition().getX(), this.getPosition().getY(), ((Image) this.gfx).getWidth(), ((Image) this.gfx).getHeight());
        }

    }

    @Override
    public void dispose()
    {
        this.disposable = true;
    }

    @Override
    public boolean isDisposable()
    {
        return this.disposable;
    }

    @Override
    public void draw(Graphics g)
    {
        ((Image) this.gfx).draw(this.getPosition().getX(), this.getPosition().getY(), this.filter);
    }
}
