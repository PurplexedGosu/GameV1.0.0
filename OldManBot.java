import greenfoot.*;

/**
 * Write a description of class OldMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OldManBot extends Animated
{
    private double time = 0;

    // Sprites taken from http://kamuipsyus.deviantart.com/art/LOZ-Sprite-Old-Man-Robe-433458612

    private GreenfootImage up1 = new GreenfootImage("Master/Master Up/Master Up. Left Step.png");
    private GreenfootImage up3 = new GreenfootImage("Master/Master Up/Master Up.png");
    private GreenfootImage up2 = new GreenfootImage("Master/Master Up/Master Up. Right Step.png");

    private GreenfootImage down1 = new GreenfootImage("Master/Master Down/Master Down Stance Left Step.png");
    private GreenfootImage down3 = new GreenfootImage("Master/Master Down/Master Down.png");
    private GreenfootImage down2 = new GreenfootImage("Master/Master Down/Master Down Stance Right Step.png");

    private GreenfootImage left1 = new GreenfootImage("Master/Master Left/Master Left. Right Step.png");
    private GreenfootImage left3 = new GreenfootImage("Master/Master Left/Master Left.png");
    private GreenfootImage left2 = new GreenfootImage("Master/Master Left/Master Left. Left Step.png");

    private GreenfootImage right1 = new GreenfootImage("Master/Master Right/Master Right. Left Step.png");
    private GreenfootImage right3 = new GreenfootImage("Master/Master Right/Master Right.png");
    private GreenfootImage right2 = new GreenfootImage("Master/Master Right/Master Right. Right Step.png");

    private double frame = 1;
    public OldManBot(/*Counter healthCounter*/)
    {
        //counter1 = healthCounter;
    }

    // Heroes Move
    public void act()
    {
        time += 0.01602;
        if (time >= 5 && time <=6.75)
        {
            moveLeft(left1, left2, left3);
        }
        if (time >= 7.15 && time <= 8)
        {
            moveUp(up1, up2, up3);
        }
        if(time >= 8 && time <= 8.2)
        {
            moveRight(right1, right2, right3);
        }
    
        if (time >= 15 && time <= 51){
            moveRight(right1, right2, right3);
        }
    }

    public void moveUp(GreenfootImage up1, GreenfootImage up2, GreenfootImage up3)
    {
        setLocation(getX(), getY() - 1);
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
        else if (frame == 5)
        {
            setRotation(0);
            setImage(up3);
        }
        else if (frame ==7)
         {
            frame = 1;
            return;
        }
        frame+=0.25;
        
    }
    public void moveDown(GreenfootImage down1, GreenfootImage down2, GreenfootImage down3)
    {
        setLocation(getX(), getY() + 2);
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
        else if (frame == 5)
        {
            setRotation(180);
            setImage(down3);
        }
        else if (frame ==7)
         {
            frame = 1;
            return;
        }
        frame+=0.25;
    }
    public void moveLeft(GreenfootImage left1, GreenfootImage left2, GreenfootImage left3)
    {
        
            setLocation(getX() - 3, getY());
            //Put rotation within if statements instead of here for smoother animation
            if (frame == 1)
            {
                
                setImage(left1);
            }
            else if (frame == 3)
            {
                
                setImage(left2);
            }
            else if (frame == 5)
            {
                
                setImage(left3);
            }
            else if (frame ==7)
             {
                frame = 1;
                return;
            }
            frame+=0.25;
        
    }
    public void moveRight(GreenfootImage right1, GreenfootImage right2, GreenfootImage right3)
    {
        
            setLocation(getX() + 1, getY());
            //Put rotation within if statements instead of here for smoother animation
            if (frame == 1)
            {
                setImage(right1);
                
            }
            else if (frame == 3)
            {
                setImage(right2);
                
            }
            else if (frame == 5)
            {
                
                setImage(right3);
            }
            else if (frame ==7)
             {
                frame = 1;
                return;
            }
            frame+=0.25;
        
    }

    //Melee Attack
    public boolean useF()
    {
        return (Greenfoot.isKeyDown("f"));
    }

    //Ranged Attack
    public boolean useSpacebar()
    {
        return ("space".equals(Greenfoot.getKey()));
    }

}
