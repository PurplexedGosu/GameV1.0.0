import greenfoot.*;
/**
 * Functionality in this class:
 */
public class NPCS extends Actor
{
    public int RMHP = 3;
    private int delay = 61;
    
    public NPCS()
    {
        
    }
    
    
    public void act() 
    {
        ninjaattack();
        RMDied();
    }    
        
    public void ninjaattack(){
       // if (delay >=60){         
            Actor shurikin = getOneIntersectingObject(Shuriken.class);
            Actor lightning = getOneIntersectingObject(Lightning.class);
            if (shurikin != null || lightning != null){
             RMHP--;
            }
       //}
    }
        public void RMDied()
    {
        if (RMHP <= 0)
        {
            getWorld().removeObject(this);
        }
    }
}
