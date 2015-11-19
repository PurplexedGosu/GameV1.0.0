import greenfoot.*;
import java.util.*;

/**
 * Functionality in this class:
 */
public class LavaMonster extends RangedMinion  //RM Stands for Ranged Minion
{
    int delay = 0;
    private int imageTimer;
    // Sprite taken from http://www.spriters-resource.com/snes/stoneprotectors/sheet/39048/
    private GreenfootImage walk1 = new GreenfootImage("LavaMonster/walk1.png");
    private GreenfootImage walk2 = new GreenfootImage("LavaMonster/walk2.png");
    private GreenfootImage walk3 = new GreenfootImage("LavaMonster/walk3.png");
    private GreenfootImage walk4 = new GreenfootImage("LavaMonster/walk4.png");
    private GreenfootImage walk5 = new GreenfootImage("LavaMonster/walk5.png");
    
    private GreenfootImage attack1 = new GreenfootImage("LavaMonster/Attack1.png");
    private GreenfootImage attack2 = new GreenfootImage("LavaMonster/Attack2.png");
    
    private GreenfootImage hit1 = new GreenfootImage("LavaMonster/Hit1.png");
    
    private GreenfootImage death1 = new GreenfootImage("LavaMonster/Death1.png");
    private GreenfootImage death2 = new GreenfootImage("LavaMonster/Death2.png");
    
    private int attackCounter = 0;
    private int movingCounter = 0;
    private boolean moving = true;
    private int attackCounter2 = 0;
    private int deathCounter = 0;
    public LavaMonster(int RMHP, int damage)
    {
        super(RMHP, damage);
    }
    public void act() 
    {
       
       animate();
       detect();
       ninjaattack();
       RMDied();
    }    
    public void RMDied()
    {
        if (RMHP <= 0)
        {
            setImage(death1);
            deathCounter++;
            if (deathCounter >= 8)
            setImage(death2);
            if (deathCounter >= 12)
            {
            Trap trap = (Trap) getWorld();
            trap.getNinja().setPoints(trap.getNinja().getPoints()+1);
            getWorld().removeObject(this);
            }
        }
    }
    public void detect()
    {
        imageTimer++;
        delay++; 
        List<Ninja> list = getObjectsInRange(100, Ninja.class);
        if (list.size()>0 )
        {
            if (delay > 200)
            {
                moving = false;
                setImage(attack1);
                turnTowards(list.get(0).getX(), list.get(0).getY());
                double x = getRotation();
                SecondFireball secondFireball= new SecondFireball(this.getDamage());
                getWorld().addObject(secondFireball, getX(), getY());
                secondFireball.turnTowards(list.get(0).getX(), list.get(0).getY());
                delay = 0;
                setRotation(0);
           }
        }
        else moving = true;
             
    }
    private void animate()
    {
        int span = 15;
        if(imageTimer == span && moving == true)
        setImage(walk1);
        if(imageTimer == 2*span && moving == true)
        setImage(walk2);
        if(imageTimer == 3*span && moving == true)
        setImage(walk3);
        if(imageTimer == 4*span && moving == true)
        setImage(walk4);
        if(imageTimer == 5*span && moving == true)
        setImage(walk5);
        if(imageTimer >= 6*span && moving == true)
        imageTimer = 0;
    }
}