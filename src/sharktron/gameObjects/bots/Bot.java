package sharktron.gameObjects.bots;

import org.newdawn.slick.GameContainer;
import sharktron.logic.GameProgressionManager;
import sharktron.rendering.DrawableGameComponent;

/**
 * Defines all common methods and attributes for any NPC
 *
 * @author Kna
 */
public abstract class Bot extends DrawableGameComponent
{

    /**
     * The speed at which the animation will play
     */
    protected int animationSpeed;

    /**
     * Creates a new instance of a bot and adds it to the
     * GameProgressionManagers ActiveBotList
     */
    public Bot()
    {
        GameProgressionManager.addBot(this);
    }

    @Override
    public void update(GameContainer gc, int delta)
    {
        super.update(gc, delta);
        // Implement behavior
    }

    /**
     * Disposes the class and removes the bot from the GameProgressionManagers
     * Botlist.
     */
    @Override
    public void dispose()
    {
        GameProgressionManager.removeBot(this);
        this.disposable = true;
    }

    @Override
    public boolean isDisposable()
    {
        return this.disposable;
    }
}
