package sharktron.gameObjects.bots;

import org.newdawn.slick.Animation;
import sharktron.rendering.GFXLib;

public class Jack extends Bot
{
    
    public Jack()
    {
        super();
        
        this.animationSpeed = 100;
        this.gfx = new Animation(GFXLib.getJackSpriteSheet(), this.animationSpeed);
    }

}
