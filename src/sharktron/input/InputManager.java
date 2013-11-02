package sharktron.input;

import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Point;
import sharktron.RuntimeConfiguration;

public class InputManager
{
    private static Input input;
    
    public static void init()
    {
        input = new Input(RuntimeConfiguration.WINDOW_SCREEN_HEIGHT);
    }
    
    public static Point getMousePosition()
    {
        int x = input.getMouseX();
        int y = input.getMouseY();
        
        return new Point(x, y);
    }
    
    public static boolean isLeftMouseDown()
    {
         return input.isMouseButtonDown(0);
    }
    
    public static boolean isRightMouseDown()
    {
         return input.isMouseButtonDown(1);
    }
}
