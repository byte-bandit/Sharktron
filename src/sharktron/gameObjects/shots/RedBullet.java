package sharktron.gameObjects.shots;

import org.newdawn.slick.geom.Point;
import sharktron.rendering.GFXLib;

/**
 * The red shot class provides the functionality used to create and update a red laser
 * bullet.
 * @author Kna
 */
public class RedBullet extends Shot
{

    /**
     * Creates a new instance at the given position
     * @param x The X coordinate
     * @param y The Y coordinate
     */
        public RedBullet(int x, int y)
    {
        super(x, y);
        init();
    }
    
    /**
     * Creates a new instance at the given position
     * @param pos The Slick2D Point holding the spawn position coordiates
     */
    public RedBullet(Point pos)
    {
        super(pos);
        init();
    }

    @Override
    protected void init()
    {
        this.gfx = GFXLib.getBulletRed();
        
        // This bullet travels only on the X axis.
        this.velocity = new Point(10,0);
        
        super.init();
    }
}
