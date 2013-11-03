package sharktron.gameObjects;

/**
 * Resembles a shot fired by an enemy unit
 * @author Kna
 */
public abstract class EnemyShot extends Shot
{

    /**
     * Checks for collision with the player
     */
    @Override
    public void checkForCollision()
    {
        // Todo: Handle collision with player
    }
}
