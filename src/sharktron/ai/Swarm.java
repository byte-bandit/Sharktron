package sharktron.ai;

import java.util.LinkedList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import sharktron.gameObjects.Bot;
import sharktron.logic.IUpdateable;
import sharktron.rendering.DrawableGameComponent;
import sharktron.rendering.IDrawable;

/**
 * This class represents a swarm - a group of bots following the same pattern.
 *
 * @author Kna
 */
public class Swarm implements IDrawable, IUpdateable
{

    private LinkedList<Bot> bots;
    private boolean disposable;

    /**
     * Gets all bots of the swarm
     *
     * @return the value of bots
     */
    public LinkedList<Bot> getBots()
    {
        return bots;
    }

    /**
     * Adds a bot to the swarm
     *
     * @param b The bot to add
     */
    public void addBot(Bot b)
    {
        this.bots.add(b);
    }

    /**
     * Removes a bot from the swarm
     *
     * @param b The bot to remove
     */
    public void removeBot(Bot b)
    {
        this.bots.remove(b);
    }

    @Override
    public void draw(Graphics g)
    {
        for (IDrawable d : this.bots)
        {
            d.draw(g);
        }
    }

    @Override
    public void update(GameContainer gc, int delta)
    {
        // Update Bot Behavior
    }

    @Override
    public boolean isDisposable()
    {
        return this.disposable;
    }

    @Override
    public void dispose()
    {
        this.disposable = true;
    }
}
