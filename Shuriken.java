import greenfoot.*; 

/**
 * Write a description of class Shuriken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shuriken extends Projectiles
{
    private int st = 0;
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
         st++;
         if (st >= 0 && st < 12)
         {
             move (8);
         }
         else if (st >= 12 && st < 24)
         {
             move(7);
             turn(1);
         }
         else if (st >= 24 && st < 36)
         {
             move(6);
             turn(-2);
         }
         else if (st >= 36 && st < 48)
         {
             move(5);
             turn(1);
         }
         else if (st >= 48 && st < 54)
         {
             move(4);
             turn(-2);
         }
         else if (st >= 60 && st < 72)
         {
             move(3);
             turn(1);
         }
         else if (st >= 72 && st < 84)
         {
             move(2);
             turn(-1);
         }
         else if (st > 84 && st < 140)
         {
             move(1);
             turn(1);
         }
         else
         {
             move(0);
         }
         if (st > 114)
         {
             getWorld().removeObject(this);
         }
         //if (st >70)
         {
             //move(-1);
         }
         
    }    
}