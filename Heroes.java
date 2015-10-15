import greenfoot.*;

/**
 * Write a description of class Heroes here.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heroes extends Actor
{
    private double frame = 1;
    
    // Heroes Move
    public void moveUp(int speedMultiplier, GreenfootImage up1, GreenfootImage up2)
    {
        if (Greenfoot.isKeyDown("w")&&canMoveUp())
        {
            setLocation(getX(), getY() - 1*speedMultiplier);
            //Put rotation within if statements instead of here for smoother animation
            if (frame == 1)
            {
                setImage(up1);
                setRotation(0);
            }
            else if (frame == 3)
            {
                setImage(up2);
                setRotation(0);
            }
            else if (frame ==5)
             {
                frame = 1;
                return;
            }
            frame+=0.25;
        }
    }
    public void moveDown(int speedMultiplier, GreenfootImage down1, GreenfootImage down2)
    {
        if (Greenfoot.isKeyDown("s")&&canMoveDown())
        {
            setLocation(getX(), getY() + 1*speedMultiplier);
            //Put rotation within if statements instead of here for smoother animation
            if (frame == 1)
            {
                setRotation(180);
                setImage(down1);
            }
            else if (frame == 3)
            {
                setRotation(180);
                setImage(down2);
            }
            else if (frame ==5)
             {
                frame = 1;
                return;
            }
            frame+=0.25;
        }
    }
    public void moveLeft(int speedMultiplier, GreenfootImage left1, GreenfootImage left2)
    {
        if (Greenfoot.isKeyDown("a")&&canMoveLeft())
        {
            setLocation(getX() - 1*speedMultiplier, getY());
            //Put rotation within if statements instead of here for smoother animation
            if (frame == 1)
            {
                setRotation(-90);
                setImage(left1);
            }
            else if (frame == 3)
            {
                setRotation(-90);
                setImage(left2);
            }
            else if (frame ==5)
             {
                frame = 1;
                return;
            }
            frame+=0.25;
        }
    }
    public void moveRight(int speedMultiplier, GreenfootImage right1, GreenfootImage right2)
    {
        if (Greenfoot.isKeyDown("d")&&canMoveRight())
        {
            setLocation(getX() + 1*speedMultiplier, getY());
            //Put rotation within if statements instead of here for smoother animation
            if (frame == 1)
            {
                setImage(right1);
                setRotation(90);
            }
            else if (frame == 3)
            {
                setImage(right2);
                setRotation(90);
            }
            else if (frame ==5)
             {
                frame = 1;
                return;
            }
            frame+=0.25;
        }
    }
    //Bill's detection
    public boolean canMoveRight()
    {
        boolean good = true;
        for(int i = -20; i<21; i++)
        {
            if(getOneObjectAtOffset(25,i,Obstacles.class)!=null)
                good = false;
        }
        return good;
    }
    
    public boolean canMoveLeft()
    {
        boolean good = true;
        for(int i = -20; i<21; i++)
        {
            if(getOneObjectAtOffset(-25,i,Obstacles.class)!=null)
                good = false;
        }
        return good;
    }
  
    public boolean canMoveUp()
    {
        boolean good = true;
        for(int i = -20; i<21; i++)
        {
            if(getOneObjectAtOffset(i,-25,Obstacles.class)!=null)
                good = false;
        }
        return good;
    }
    
    public boolean canMoveDown()
    {
        boolean good = true;
        for(int i = -20; i<21; i++)
        {
            if(getOneObjectAtOffset(i,25,Obstacles.class)!=null)
                good = false;
        }
        return good;
    }
    
    //Melee Attack; Functionality of F key
    public boolean useF()
    {
        return (Greenfoot.isKeyDown("f"));
    }
    
    //Ranged Attack; Functionality of spacebar
    public boolean useSpacebar()
    {
        return ("space".equals(Greenfoot.getKey()));
    }
    
    public void act()
    {
        
    }    
}
