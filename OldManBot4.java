import greenfoot.*;

/**
 * Write a description of class OldManBot4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OldManBot4 extends Animated
{
    public int omb4hp=1;
    private int delay = 0;
    /**
     * Act - do whatever the OldManBot4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        ninjaattack();
        OMB4Died();
    }    
    public void ninjaattack(){
        // if (delay >=60){         
        Shuriken shuriken =(Shuriken) getOneIntersectingObject(Shuriken.class);
        Actor lightning = getOneIntersectingObject(Lightning.class);
        if (shuriken != null && delay==0){
            Trap trap = (Trap) getWorld();
            {
                omb4hp = omb4hp-shuriken.getDamage();
                delay = 11; 
            }
        }
        else if(lightning != null && delay==0)
        {
            Trap trap = (Trap) getWorld();
            if(trap.getNinja().getPower3())
            {
                omb4hp = omb4hp-trap.getNinja().getMeleeDamage()*2;
                delay = 11;
                trap.getNinja().setPower(trap.getNinja().getPower()-25);
            }
            else
            {
                omb4hp = omb4hp-trap.getNinja().getMeleeDamage();
                delay = 11;
            }
        }
        else if(delay>0){
            delay--;
        }
        
    }
    public void OMB4Died(){
        if (omb4hp <= 0)
        {
            Trap trap = (Trap) getWorld();
            trap.getNinja().setPoints(trap.getNinja().getPoints()+50);
            getWorld().removeObject(this);
            InfernoDoor door1 = new InfernoDoor();
            getWorld().addObject(door1, 660, 375);
            EndStoryKyo3 esk3= new EndStoryKyo3();
            getWorld().addObject(esk3, 620, 200);
            
        }
    }
}
