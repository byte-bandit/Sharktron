package sharktron.gameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import sharktron.logic.IUpdateable;
import sharktron.rendering.DrawableGameComponent;
import sharktron.rendering.IDrawable;

/**
 * Defines all common methods and attributes for any NPC
 *
 * @author Kna
 */
public abstract class Bot extends DrawableGameComponent implements IDrawable, IUpdateable
{

    /**
     * Set to true to remove this object from the Update and Rendering Managers
     */
    protected boolean disposable;
    /**
     * The GFX Animation of the NPC
     */
    protected Animation gfx;
    /**
     * The speed at which the animation will play
     */
    protected int animationSpeed;

    @Override
    public void draw(Graphics g)
    {
        this.gfx.draw(this.getPosition().getX(), this.getPosition().getY(), this.filter);
    }

    @Override
    public void update(GameContainer gc, int delta)
    {
        // Implement behavior
    }

    @Override
    public boolean isDisposable()
    {
        return this.disposable;
    }
}
