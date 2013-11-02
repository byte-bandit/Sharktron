package sharktron.logic;

import java.util.Iterator;
import java.util.LinkedList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import sharktron.ai.Wave;
import sharktron.rendering.DrawableGameComponent;
import sharktron.rendering.IDrawable;

/**
 * This class represents a Stage - a level of the game featuring a multitude of
 * individual waves (of enemies)
 *
 * @author Kna
 */
public class Stage extends DrawableGameComponent implements IDrawable, IUpdateable
{

    private LinkedList<Wave> waves;
    private Iterator<Wave> iterator;
    private Wave currentWave;
    private boolean disposable;

    /**
     * Creates a new Stage
     */
    public Stage()
    {
        super();
    }

    /**
     * Gets all waves of the stage.
     *
     * @return the value of waves
     */
    public LinkedList<Wave> getWaves()
    {
        return waves;
    }

    /**
     * Gets the currently dispatched / dispatching Wave
     *
     * @return the value of currentWave
     */
    public Wave getCurrentWave()
    {
        return currentWave;
    }

    /**
     * Returns the next (or first) Wave of the stage.
     *
     * @return The next wave to be dispatched - null if all waves have been
     *         dispatched.
     */
    public Wave getNextWave()
    {
        if (iterator == null)
        {
            iterator = this.waves.iterator();
        }

        if (iterator.hasNext())
        {
            this.setCurrentWave(iterator.next());
            return this.getCurrentWave();
        }
        else
        {
            return null;
        }
    }

    /**
     * Set the currently dispatching / dispatched wave
     *
     * @param currentWave new value of currentWave
     */
    private void setCurrentWave(Wave currentWave)
    {
        this.currentWave = currentWave;
    }

    /**
     * Adds a wave to the stage.
     *
     * @param w The wave to add
     */
    public void addWave(Wave w)
    {
        this.waves.add(w);
    }

    /**
     * Removes a wave from the stage.
     *
     * @param w The wave to be removed
     */
    public void removeWave(Wave w)
    {
        this.waves.remove(w);
    }

    @Override
    public void update(GameContainer gc, int delta)
    {
        this.currentWave.update(gc, delta);
    }

    @Override
    public boolean isDisposable()
    {
        return this.disposable;
    }

    @Override
    public void draw(Graphics g)
    {
        this.currentWave.draw(g);
    }
}
