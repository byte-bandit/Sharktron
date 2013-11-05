package sharktron.ai;

import java.util.Iterator;
import java.util.LinkedList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import sharktron.logic.IUpdateable;
import sharktron.rendering.IDrawable;

/**
 * This class represents a wave - a group of swarms, dispatched sequentially.
 *
 * @author Kna
 */
public class Wave implements IDrawable, IUpdateable
{

    private LinkedList<Swarm> swarms;
    private Iterator<Swarm> iterator;
    private Swarm currentSwarm;
    private boolean disposable;
    
    /**
     * Creates a new Wave.
     */
    public Wave()
    {
        this.swarms = new LinkedList<>();
    }

    /**
     * Gets all swarms of the wave.
     *
     * @return the value of swarms
     */
    public LinkedList<Swarm> getSwarms()
    {
        return swarms;
    }

    /**
     * Adds a swarm to the wave.
     *
     * @param s The swarm to sadd
     */
    public void addSwarm(Swarm s)
    {
        this.swarms.add(s);
    }

    /**
     * Removes a swarm from the wave
     *
     * @param s The swarm to remove
     */
    public void removeSwarm(Swarm s)
    {
        this.swarms.remove(s);
    }

    /**
     * Gets the next (or first) swarm in the wave.
     *
     * @return The next swarm to be dispatched - null if all swarms have been
     *         dispatched
     */
    public Swarm getNextSwarm()
    {
        if (iterator == null)
        {
            iterator = this.swarms.iterator();
        }

        if (iterator.hasNext())
        {
            this.setCurrentSwarm(iterator.next());
            return this.getCurrentSwarm();
        }
        else
        {
            return null;
        }
    }

    /**
     * Get the currently dispatched / dispatching swarm
     *
     * @return the value of currentSwarm
     */
    public Swarm getCurrentSwarm()
    {
        return currentSwarm;
    }

    @Override
    public void dispose()
    {
        this.disposable = true;
    }

    @Override
    public void draw(Graphics g)
    {
        this.currentSwarm.draw(g);
    }

    @Override
    public void update(GameContainer gc, int delta)
    {
        this.currentSwarm.update(gc, delta);
    }

    @Override
    public boolean isDisposable()
    {
        return this.disposable;
    }

    /**
     * Set the currently dispatched / dispatching swarm
     *
     * @param currentSwarm new value of currentSwarm
     */
    private void setCurrentSwarm(Swarm currentSwarm)
    {
        this.currentSwarm = currentSwarm;
    }
}
