import java.util.*;
import greenfoot.*;

/**
 * Functionality in this class:
 */
public class RedMM extends MeleeMinion //RM Stands for Ranged Minion
{
    //RangedMinion redrm = new RangedMinion();
    int delay = 0;
    
    private GreenfootImage up1 = new GreenfootImage("RedDragon/RedDragon Up/RedDragon_Up_Left.png");
    private GreenfootImage up2 = new GreenfootImage("RedDragon/RedDragon Up/RedDragon_Up_Center.png");
    private GreenfootImage up3 = new GreenfootImage("RedDragon/RedDragon Up/RedDragon_Up_right.png");
    
    private GreenfootImage down1 = new GreenfootImage("RedDragon/RedDragon Down/RedDragon_Down_Left.png");
    private GreenfootImage down2 = new GreenfootImage("RedDragon/RedDragon Down/RedDragon_Down_Center.png");
    private GreenfootImage down3 = new GreenfootImage("RedDragon/RedDragon Down/RedDragon_Down_Right.png");
    
    private GreenfootImage left1 = new GreenfootImage("RedDragon/RedDragon Left/RedDragon_Left_Left.png");
    private GreenfootImage left2 = new GreenfootImage("RedDragon/RedDragon Left/RedDragon_Left_Center.png");
    private GreenfootImage left3 = new GreenfootImage("images/RedDragon/RedDragon Left/RedDragon_Left_Right.png");
    
    private GreenfootImage right1 = new GreenfootImage("RedDragon/RedDragon Right/RedDragon_Right_Left.png");
    private GreenfootImage right2 = new GreenfootImage("RedDragon/RedDragon Right/RedDragon_Right_Center.png");
    private GreenfootImage right3 = new GreenfootImage("RedDragon/RedDragon Right/RedDragon_Right_Right.png");
    
    public RedMM()
    {
        super();
    }
    public void act() 
    {
        /*
        moveUp(up1, up2, up3);
        moveDown(down1, down2, down3);
        moveLeft(left1, left2, left3);
        moveRight(right1, right2, right3);
        */
       detect();
    }    
    public void detect()
    {
        List<Ninja> list = getObjectsInRange(5000, Ninja.class);
        if (list.size()>0&&delay>100)
        {
            turnTowards(list.get(0).getX(), list.get(0).getY());
            double x = getRotation();
            Shuriken2 shuriken = new Shuriken2();
            getWorld().addObject(shuriken, getX(), getY());
            shuriken.turnTowards(list.get(0).getX(), list.get(0).getY());
            delay = 0;
            setRotation(0);
        }
        delay++;       
    }
}