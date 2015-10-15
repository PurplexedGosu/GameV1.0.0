import greenfoot.*; 

/**
 * Write a description of class Shuriken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shuriken extends Projectiles
{
    GreenfootSound sliceSound = new GreenfootSound("slice.mp3");
    public void act() 
    {
        Actor NPCS = getOneIntersectingObject(NPCS.class);
            if (NPCS!=null){
                getWorld().removeObject(NPCS);
                getWorld().removeObject(this);
                sliceSound.setVolume(15);
                sliceSound.play();
            }
            else if (atWorldEdge())
            getWorld().removeObject(this);
         move(6);
    }    
}