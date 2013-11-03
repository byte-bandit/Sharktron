package sharktron.gameObjects;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Point;
import sharktron.logic.IUpdateable;
import sharktron.input.InputManager;
import sharktron.logic.UpdateManager;
import sharktron.rendering.DrawableGameComponent;
import sharktron.rendering.GFXLib;
import sharktron.rendering.IDrawable;
import sharktron.rendering.RenderingManager;
import sharktron.sound.SoundLibrary;
import sharktron.sound.SoundManager;

/**
 * The class represents the player character in game.
 * @author Kna
 */
public class Player extends DrawableGameComponent implements IDrawable, IUpdateable
{
    
    // private Animation gfx;
    private Color filter;
    private boolean disposable;

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
     * Will draw the player image to the screen
     */
    @Override
    public void draw(Graphics g)
    {
        ((Animation)this.gfx).draw(this.getPosition().getX(), this.getPosition().getY(), this.filter);
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
        else if (this.getPosition().getX() > gc.getWidth() - ((Animation)this.gfx).getWidth() - 10)
        {
            this.getPosition().setX(gc.getWidth() - ((Animation)this.gfx).getWidth() - 10);
        }
        
        if (this.getPosition().getY() < 10.0f)
        {
            this.getPosition().setY(10.0f);
        }
        else if (this.getPosition().getY() > gc.getHeight() - ((Animation)this.gfx).getHeight() - 10)
        {
            this.getPosition().setY(gc.getHeight() - ((Animation)this.gfx).getHeight() - 10);
        }
        
        
        // Some Shoot Testing
        if (InputManager.isLeftMouseDown())
        {
            RedBullet b = new RedBullet(this.getPosition());
            RenderingManager.addChild(b);
            UpdateManager.addChild(b);
            
            b = new RedBullet(this.getPosition());
            b.getVelocity().setY(1);
            RenderingManager.addChild(b);
            UpdateManager.addChild(b);
            
            b = new RedBullet(this.getPosition());
            b.getVelocity().setY(-1);
            RenderingManager.addChild(b);
            UpdateManager.addChild(b);
            
            // Sound testing
            SoundManager.playAsSoundEffect(SoundLibrary.getSound("laser"));
        }
    }

    @Override
    public boolean isDisposable()
    {
        return this.disposable;
    }

}
