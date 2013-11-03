package sharktron.gameObjects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;
import sharktron.logic.IUpdateable;
import sharktron.rendering.DrawableGameComponent;
import sharktron.rendering.IDrawable;

/**
 * Abstract class defining all common methods and attributes for any type of projectile.
 * @author Kna
 */
public abstract class Shot extends DrawableGameComponent implements IDrawable, IUpdateable
{
    
    /**
     * The velocity of a shot is stored inside a point as vector mathematics. X and Y values of the point
     * symbolize the X and Y velocity the bullet will receive in each update call.
     */
    protected Point velocity;
    
    /**
     * Creates a new instance.
     */
    public Shot()
    {
        super();
    }
    
    /**
     * Creates a new instance at the given position.
     * @param x X spawn coordinate
     * @param y Y spawn coordinate
     */
    public Shot(int x, int y)
    {
        super(x, y);
    }
    
    /**
     * Creates a new instance at the given position.
     * @param pos The Slick2D Point holding the spawn position coordinates.
     */
    public Shot(Point pos)
    {
        super(pos);
    }
    
    /**
     * Return the acceleration velocity as a point - handled as a vector.
     * @return The acceleration.
     */
    public Point getVelocity()
    {
        return this.velocity;
    }
    

    @Override
    public void draw(Graphics g)
    {
        ((Image)this.gfx).draw(this.getPosition().getX(), this.getPosition().getY(), this.filter);
    }

    /**
     * Updates the shot logic, applies velocity,
     * @param gc
     * @param delta
     */
    @Override
    public void update(GameContainer gc, int delta)
    {
        super.update(gc, delta);
        
        this.getPosition().setX(this.getPosition().getX() + this.getVelocity().getX());
        this.getPosition().setY(this.getPosition().getY() + this.getVelocity().getY());
        
        // Remove Shot if out of boundaries
        if (this.getPosition().getX() > gc.getWidth() + ((Image)this.gfx).getWidth())
        {
            this.dispose();
        }
        else
        {
            // Check for collision with enemies
            checkForCollision();
        }
    }
    
    /**
     * Checks for collision with enemy units
     */
    public void checkForCollision()
    {
        
    }

}
