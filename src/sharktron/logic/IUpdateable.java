/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sharktron.logic;

import org.newdawn.slick.GameContainer;

/**
 * Defines functionality for a game element that can be updated.
 * @author Kna
 */
public interface IUpdateable
{
    /**
     *
     * @param gc
     * @param delta
     */
    public void update(GameContainer gc, int delta);
    /**
     * Called by the UpdateManager to determine whether this object can be removed from the list.
     * @return
     */
    public boolean isDisposable();
    
    /**
     * Called to allow the Update Manager to dispose the object.
     */
    public void dispose();
}
