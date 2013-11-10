/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sharktron.logic;

import org.newdawn.slick.geom.Point;

/**
 * Used to update bot movement and shooting behavior
 * @author Kna
 */
public interface IBotBehavior
{
    /**
     * Calculates the next position of the bot
     * @return The new position of the bot displayed as a slick2d point
     */
    public Point GetNextPosition();
    
    /**
     * Gets the duration until the bot shoots again
     * @return Returns a timer when to shoot
     */
    public int GetShootingTimer();
    
    /**
     * Returns a value whether the bot is shooting at the player at all
     * @return false, if the bot won't shoot at the player, true if it will
     */
    public boolean IsShooting();
    
    /**
     * Calculates the new position based on the given values.
     * @return The new Position as a Slick2D Point.
     */
    public Point CalculatePosition(Point pos);
}
