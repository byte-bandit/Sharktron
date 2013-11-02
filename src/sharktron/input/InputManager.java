package sharktron.input;

import org.lwjgl.input.Keyboard;
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
        input = RuntimeConfiguration.GAME_CONTAINER.getInput();
    }
    
    /**
     * Returns the current absolute mouse position as a Slick2D Point.
     * 
     * @return Mouse position
     */
    public static Point getAbsoluteMousePosition()
    {
        int x = input.getAbsoluteMouseX();
        int y = input.getAbsoluteMouseY();
        
        return new Point(x, y);
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
     * Determines, if the left mouse button is down.
     * 
     * @return Left mouse button pressed
     */
    public static boolean isLeftMouseDown()
    {
         return input.isMouseButtonDown(0);
    }
    
    /**
     * Determines, if the left mouse button is pressed.
     * 
     * @return Left mouse button pressed
     */
    public static boolean isLeftMousePressed()
    {
         return input.isMousePressed(0);
    }
    
    /**
     * Determines, if the right mouse button is down.
     * 
     * @return Right mouse button down
     */
    public static boolean isRightMouseDown()
    {
         return input.isMouseButtonDown(1);
    }
    
    /**
     * Determines, if the right mouse button is pressed.
     * 
     * @return Right mouse button pressed
     */
    public static boolean isRightMousePressed()
    {
         return input.isMousePressed(1);
    }
    
    /**
     * Determines, if the Escape key is down.
     * 
     * @return Escape key down
     */
    public static boolean isEscKeyDown()
    {
        return input.isKeyDown(Keyboard.KEY_ESCAPE);
    }
    
    /**
     * Determines, if the Escape key is pressed.
     * 
     * @return Escape key pressed
     */
    public static boolean isEscKeyPressed()
    {
        return input.isKeyPressed(Keyboard.KEY_ESCAPE);
    }
    
    /**
     * Determines, if the Space key is down.
     * 
     * @return Space key down
     */
    public static boolean isSpaceKeyDown()
    {
        return input.isKeyDown(Keyboard.KEY_SPACE);
    }
    
    /**
     * Determines, if the Space key is pressed.
     * 
     * @return Space key pressed
     */
    public static boolean isSpaceKeyPressed()
    {
        return input.isKeyPressed(Keyboard.KEY_SPACE);
    }
    
    /**
     * Determines, if the Return key is down.
     * 
     * @return Return key down
     */
    public static boolean isReturnKeyDown()
    {
        return input.isKeyDown(Keyboard.KEY_RETURN);
    }
    
    /**
     * Determines, if the Return key is pressed.
     * 
     * @return Return key pressed
     */
    public static boolean isReturnKeyPressed()
    {
        return input.isKeyPressed(Keyboard.KEY_RETURN);
    }
    
    /**
     * Passes the instance of the Slick2D Input object to the outside world.
     * 
     * @return Instance of Slick2D Input
     */
    public static Input getInput()
    {
        return input;
    }
}
