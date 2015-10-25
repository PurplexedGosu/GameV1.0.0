import greenfoot.*;

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Pictures
{
    public void act() 
    {
        checkNinja();
    }    
    public void checkNinja()
    {
        Actor ninja = getOneIntersectingObject(Ninja.class);
        if(ninja!= null)
        {
           Kyobashi world = (Kyobashi) getWorld();
           world.addLevel();
           //getWorld().removeObject(this);
        }
    }
}