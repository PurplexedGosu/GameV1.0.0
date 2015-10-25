import greenfoot.*; 

/**
 * Functionality in this class:
 */
public class Shuriken2 extends Projectiles
{
    private int st = 0;
    GreenfootSound sliceSound = new GreenfootSound("slice.mp3");
    GreenfootImage darkness1 = new GreenfootImage("Darkness/Darkness1.png");
    GreenfootImage darkness2 = new GreenfootImage("Darkness/Darkness2.png");
    GreenfootImage darkness3 = new GreenfootImage("Darkness/Darkness3.png");
    GreenfootImage darkness4 = new GreenfootImage("Darkness/Darkness4.png");
    private double frame = 1;
    public Shuriken2()
    {
        setImage(darkness1);
    }
    public void act() 
    {
        if (frame == 1)
        {
            setImage(darkness1);
        }
        else if (frame == 3)
        {
            setImage(darkness2);
        }
        else if (frame == 5)
        {
            setImage(darkness3);
        }
        else if (frame == 7)
        {
            setImage(darkness4);
        }
        else if (frame == 9)
        {
            frame = 1;
            return;
        }
        frame+=0.25;
        
        Actor ninja = getOneIntersectingObject(Ninja.class);
            if (ninja != null){
                getWorld().removeObject(ninja);
                getWorld().removeObject(this);
                sliceSound.setVolume(15);
                sliceSound.play();
            }
            else if (atWorldEdge())
            getWorld().removeObject(this);
         st++;
         if (st >= 0 && st < 12)
         {
             move (4);
         }
         else if (st >= 12 && st < 24)
         {
             move(3);
             //turn(1);
         }
         else if (st >= 24 && st < 36)
         {
             move(2);
             //turn(-2);
         }
         else if (st >= 36 && st < 48)
         {
             move(1);
             //turn(1);
         }
         else if (st >= 48 && st < 54)
         {
             move(1);
             getWorld().removeObject(this);
             //turn(-2);
         }
         
    }    
}