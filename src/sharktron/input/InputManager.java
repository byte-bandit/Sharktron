package sharktron.input;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Point;
import sharktron.RuntimeConfiguration;

/**
 * Provides functionality to detect user input.
 * 
 * @author acrynx
 */
public class InputManager
{
    private static Input input;
    
    /**
     * Initializes an instance of the Slick2D Input object.
     * Must be called before any other method is called.
     */
    public static void init()
    {
        input = new Input(RuntimeConfiguration.WINDOW_SCREEN_HEIGHT);
    }
    
    /**
     * Returns the current mouse position as a Slick2D Point.
     * 
     * @return Mouse position
     */
    public static Point getMousePosition()
    {
        int x = input.getMouseX();
        int y = input.getMouseY();
        
        return new Point(x, y);
    }
    
    /**
     * Determines, if the left mouse button is pressed.
     * Returns boolean accordingly.
     * 
     * @return Left mouse button pressed
     */
    public static boolean isLeftMouseDown()
    {
         return input.isMouseButtonDown(0);
    }
    
    /**
     * Determines, if the right mouse button is pressed.
     * Returns boolean accordingly.
     * 
     * @return Right mouse button pressed
     */
    public static boolean isRightMouseDown()
    {
         return input.isMouseButtonDown(1);
    }
}
