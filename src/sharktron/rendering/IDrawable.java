package sharktron.rendering;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

/**
 * Defines all methods needed to draw
 * @author Kna
 */
public interface IDrawable
{
    /**
     * Draw the component
     * @param g The graphics of the main module
     */
    public void draw(Graphics g);
}
