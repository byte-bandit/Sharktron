/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sharktron.controlling;

import org.newdawn.slick.GameContainer;

/**
 * Defines functionality for a game element that can be updated.
 * @author Kna
 */
public interface IUpdateable
{
    public void update(GameContainer gc, int delta);
}
