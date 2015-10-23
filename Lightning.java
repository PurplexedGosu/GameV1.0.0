import greenfoot.*;
//Bill's class
/**
 * Functionality in this class:
 */
public class Lightning extends Projectiles
{
    private double creationTime;
    private int xDifference;
    private int yDifference;
    boolean created = false;
    boolean real;
    //private GreenfootImage up1 = new GreenfootImage("Ninja2/Ninja Up/Ninja Up. Left Step.png");
    public Lightning()
    {
        //sword = new GreenfootImage();
        creationTime = System.currentTimeMillis();
    }
    
    public void creation()
    {
            Kyobashi kyo = (Kyobashi) getWorld();
            xDifference = kyo.getNinja().getX()-this.getX();
            yDifference = kyo.getNinja().getY()-this.getY();
            created = true;
            real = true;
    }
    
    public void act() 
    {
        if(!created)
            creation();
        Actor NPCS = getOneIntersectingObject(NPCS.class);
            if (NPCS!=null){
                //getWorld().removeObject(NPCS);
                getWorld().removeObject(this);
                real = false;
            }
        if(real)
        {
            Kyobashi kyo = (Kyobashi) getWorld();
            setLocation(kyo.getNinja().getX()-xDifference,kyo.getNinja().getY()-yDifference);
            if((System.currentTimeMillis()-creationTime)>100)
                getWorld().removeObject(this);
        }
    }    
}