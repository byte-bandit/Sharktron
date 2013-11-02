package sharktron.commonInfrastructure;

/**
 * Defines methods used by all container elements
 * @author Kna
 */
public interface IContainer
{
    /**
     * Add a child to the collection
     */
    public void AddChild(Object child);
    /**
     * Remove a child from the collection
     */
    public void RemoveChild(Object child);
}
