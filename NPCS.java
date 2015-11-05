import greenfoot.*;
/**
 * Functionality in this class:
 */
public class NPCS extends Actor
{
    public int RMHP;
    private int delay = 0;
    private int damage;
    public NPCS(int RMHP, int damage)
    {
        this.RMHP = RMHP;
        this.damage = damage;
    }
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
            if (shuriken != null && delay==0){
             Trap trap = (Trap) getWorld();
             RMHP = RMHP-trap.getNinja().getRangeDamage();
             delay = 11;
            }
            else if(lightning != null && delay==0)
            {
                Trap trap = (Trap) getWorld();
                RMHP = RMHP-trap.getNinja().getMeleeDamage();
                delay = 11;
            }
            else if(delay>0){
           delay--;
           }
        
    }
    public void RMDied()
    {
        if (RMHP <= 0)
        {
            Trap trap = (Trap) getWorld();
            trap.getNinja().setPoints(trap.getNinja().getPoints()+1);
            getWorld().removeObject(this);
        }
    }
    public int getDamage()
    {
        return damage;
    }
    public int getHealth()
    {
        return RMHP;
    }
    public NPCS getThis()
    {
        return this;
    }
}
