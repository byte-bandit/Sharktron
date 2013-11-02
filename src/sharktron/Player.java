package sharktron;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;
import sharktron.controlling.IUpdateable;
import sharktron.input.InputManager;
import sharktron.rendering.GFXLib;
import sharktron.rendering.IDrawable;

/**
 * The class represents the player character in game.
 * @author Kna
 */
public class Player implements IDrawable, IUpdateable
{
    
    private Animation gfx;
    private Point position;
    private Color filter;

    private final int animSpeed = 100;
    
    /**
     * Creates a new player.
     * @param x The x coordinate where the player will spawn.
     * @param y The y coordinate where the player will spawn.
     */
    public Player(int x, int y)
    {
        this.gfx = new Animation(GFXLib.getPlayerSpriteSheet(), this.animSpeed);
        this.filter = Color.white;
        this.position = new Point(x, y);
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
     * Will draw the player image to the screen
     */
    @Override
    public void draw(Graphics g)
    {
        this.gfx.draw(this.getPosition().getX(), this.getPosition().getY(), this.filter);
    }

    /**
     * Updates the player logic.
     * @param gc Game Controller from main function
     * @param delta The passed time since the last iteration
     */
    @Override
    public void update(GameContainer gc, int delta)
    {
        
        this.getPosition().setX(InputManager.getMousePosition().getX());
        this.getPosition().setY(InputManager.getMousePosition().getY());
        
        // Cap the player in certain boundaries
        // Rectangle at : 10, 10
        // Width = Screen Width - Image height - 10
        // Height = Screen Height - Image height - 10
        
        if (this.getPosition().getX() < 10.0f)
        {
            this.getPosition().setX(10.0f);
        }
        else if (this.getPosition().getX() > gc.getWidth() - this.gfx.getWidth() - 10)
        {
            this.getPosition().setX(gc.getWidth() - this.gfx.getWidth() - 10);
        }
        
        if (this.getPosition().getY() < 10.0f)
        {
            this.getPosition().setY(10.0f);
        }
        else if (this.getPosition().getY() > gc.getHeight() - this.gfx.getHeight() - 10)
        {
            this.getPosition().setY(gc.getHeight() - this.gfx.getHeight() - 10);
        }
        
    }

}
