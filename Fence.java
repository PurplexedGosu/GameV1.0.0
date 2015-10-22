import greenfoot.*;

/**
 * Write a description of class Fence here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fence extends Obstacles
{
    /**
     * Act - do whatever the Fence wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Bill's
    public Fence()
    {
        GreenfootImage image = getImage();
        image.scale(40, 40);
        setImage(image);
    }
    public void act() 
    {
        Actor Projectiles = getOneIntersectingObject (Projectiles. class);
        if(Projectiles!= null){
            getWorld(). removeObject (Projectiles);
            Actor ator= getOneIntersectingObject (Fence.class);
        }
    }    
}