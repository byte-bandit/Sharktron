package sharktron.gameObjects;

import java.util.concurrent.TimeUnit;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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
    
    private Animation gfx;
    private Color filter;
    private boolean disposable;

    private final int animSpeed = 70;
    
    /**
     * Creates a new player.
     * @param x The x coordinate where the player will spawn.
     * @param y The y coordinate where the player will spawn.
     */
    public Player(int x, int y)
    {
        this.gfx = new Animation(GFXLib.getPlayerSpriteSheet(), this.animSpeed);
        this.gfx.stopAt(0);
        
        this.filter = Color.white;
        this.position = new Point(x, y);
    }
    
    
    /**
     * Will draw the player image to the screen
     */
    @Override
    public void draw(Graphics g)
    {
        if (this.gfx.isStopped())
        {
            this.gfx.getCurrentFrame().draw(this.getPosition().getX(), this.getPosition().getY(), this.filter);
        }
        else
        {
            this.gfx.draw(this.getPosition().getX(), this.getPosition().getY(), this.filter);
        }
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
        
        if (InputManager.isLeftMouseDown() || InputManager.isRightMouseDown())
        {
            this.gfx.start();
            this.gfx.stopAt(3);
        }
        else
        {
            this.gfx.start();
            this.gfx.stopAt(0);
        }
        
        
        if (InputManager.isLeftMouseDown())
        {
            int bulletX = this.getPositionX() + 52;
            int bulletY = this.getPositionY();
            
            RedBullet b = new RedBullet(bulletX, bulletY);
            RenderingManager.addChild(b);
            UpdateManager.addChild(b);
            
            b = new RedBullet(bulletX, bulletY);
            b.getVelocity().setY(1);
            RenderingManager.addChild(b);
            UpdateManager.addChild(b);
            
            b = new RedBullet(bulletX, bulletY);
            b.getVelocity().setY(-1);
            RenderingManager.addChild(b);
            UpdateManager.addChild(b);
            
            // Sound testing
            SoundManager.playAsSoundEffect(SoundLibrary.getSound(SoundLibrary.LASER));
        }
        
        // Still testing sound
        if (InputManager.isRightMouseDown())
        {
            SoundManager.playAsSoundEffect(SoundLibrary.getSound(SoundLibrary.ROCKET));
        }
    }

    @Override
    public boolean isDisposable()
    {
        return this.disposable;
    }

}
