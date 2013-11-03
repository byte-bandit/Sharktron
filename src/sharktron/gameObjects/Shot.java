package sharktron.gameObjects;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;
import sharktron.logic.GameProgressionManager;
import sharktron.logic.IUpdateable;
import sharktron.logic.UpdateManager;
import sharktron.rendering.DrawableGameComponent;
import sharktron.rendering.GFXLib;
import sharktron.rendering.IDrawable;
import sharktron.rendering.RenderingManager;

/**
 * Abstract class defining all common methods and attributes for any type of projectile.
 * @author Kna
 */
public abstract class Shot extends DrawableGameComponent implements IDrawable, IUpdateable
{
    
    /**
     * Used to determine whether the Update Manager can remove the object from its list.
     */
    protected boolean disposable;
    
    /**
     * The image used by the shot.
     */
    protected Image gfx;
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
        this.gfx.draw(this.getPosition().getX(), this.getPosition().getY(), this.filter);
    }

    /**
     * Updates the shot logic, applies velocity,
     * @param gc
     * @param delta
     */
    @Override
    public void update(GameContainer gc, int delta)
    {
        this.getPosition().setX(this.getPosition().getX() + this.getVelocity().getX());
        this.getPosition().setY(this.getPosition().getY() + this.getVelocity().getY());
        
        // Remove Shot if out of boundaries
        if (this.getPosition().getX() > gc.getWidth() + this.gfx.getWidth())
        {
            this.disposable = true;
        }
        else
        {
            // Check for collision with enemies
            
        }
    }
    
    @Override
    public boolean isDisposable()
    {
        return this.disposable;
    }

}
