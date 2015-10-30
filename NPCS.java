import greenfoot.*;
/**
 * Functionality in this class:
 */
public class NPCS extends Actor
{
    public int RMHP = 2;
    private int delay = 0;
   
    
    public NPCS()
    {
        
    }
    
    
    public void act() 
    {
        ninjaattack();
        RMDied();
        delay++;
    }    
        
    public void ninjaattack(){
       // if (delay >=60){         
            Actor shuriken = getOneIntersectingObject(Shuriken.class);
            Actor lightning = getOneIntersectingObject(Lightning.class);
            if (shuriken != null || lightning != null && delay==0){
             RMHP--;
             delay=11;
            }
       //}
       else if(delay>0){
          
           delay--;
        }
        
    }
    public void RMDied()
    {
        if (RMHP <= 0)
        {
            getWorld().removeObject(this);
        }
    }
}
