import greenfoot.*;

/**
 * Functionality in this class:
 */
public class Smoke extends Objects
{
    private int speed;
    public Smoke(int speed)
    {
        this.speed = speed;
    }
    public void act() 
    {
        move(speed);
        RemoveCloud();
    }    

    public void RemoveCloud()
    {
        if (getX() >= 1000)
        {
            getWorld().removeObject(this);
        }
    }
}
