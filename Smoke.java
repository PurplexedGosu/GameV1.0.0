import greenfoot.*;

/**
 * Write a description of class Smoke here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smoke extends Objects
{
    /**
     * Act - do whatever the Smoke wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
