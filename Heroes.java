import greenfoot.*;
/**
 * Functionality in this class:
 * Hero movement (Includes key state)
 * General Animation
 * Fence hit detection
 */
public class Heroes extends Actor
{
    private double frame = 1; // Used for animation
    private int moveState = 0; // Used for movement, Up/Down/Left/Right
    private int keysPressed = 0; // Used to tally number of movement keys pressed
    private int up = 0; // Up key pressed in the number of movement keys pressed
    private int down = 0; // Down key pressed in the number of movement keys pressed
    private int left = 0; // Left key pressed in the number of movement keys pressed
    private int right = 0; // Right key pressed in the number of movement keys pressed
    
    // Checks which key is pressed first for movement Start [Sean]
    public void keyState()
    {
        keysPressed = up + down + left + right;
        if (keysPressed == 0)
        {
            if (Greenfoot.isKeyDown("w"))
            {
                moveState = 1;
                up = 1;
            }
            else if (Greenfoot.isKeyDown("s"))
            {
                moveState = 2;
                down = 1;
            }
            else if (Greenfoot.isKeyDown("a"))
            {
                moveState = 3;
                left = 1;
            }
            else if (Greenfoot.isKeyDown("d"))
            {
                moveState = 4;
                right = 1;
            }
        }
        if(!(Greenfoot.isKeyDown("w")))
        {
            up = 0;
        }
        if(!(Greenfoot.isKeyDown("s")))
        {
            down = 0;
        }
        if(!(Greenfoot.isKeyDown("a")))
        {
            left = 0;
        }
        if(!(Greenfoot.isKeyDown("d")))
        {
            right = 0;
        }
        if(!(Greenfoot.isKeyDown("w")) && !(Greenfoot.isKeyDown("s")) && !(Greenfoot.isKeyDown("a")) && !(Greenfoot.isKeyDown("d")))
        {
            moveState = 0;
        }
    }
    // Checks which key is pressed first for movement End [Sean]
    // Ninja movement implementing animation Start [Sean] + Debugged [Bill]
    public void betaMovement(int speedMultiplier, GreenfootImage up1, GreenfootImage up2, GreenfootImage down1, GreenfootImage down2, GreenfootImage left1, GreenfootImage left2, GreenfootImage right1, GreenfootImage right2)
    {
        // Main up
        if (moveState == 1)
        {
            if (Greenfoot.isKeyDown("a") && canMoveLeft() && canMoveUp())
            {
                setLocation(getX() - 1*speedMultiplier, getY() - 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("d") && canMoveRight() && canMoveUp())
            {
                setLocation(getX() + 1*speedMultiplier, getY() - 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("d") && canMoveRight())
            {
                setLocation(getX() + 1*speedMultiplier, getY());
            }
            else if (Greenfoot.isKeyDown("a") && canMoveLeft())
            {
                setLocation(getX() - 1*speedMultiplier, getY());
            }
            else if(canMoveUp())
            {
                setLocation(getX(), getY() - 1*speedMultiplier);
            }
            animateUp(up1, up2);
        }
        // Main down
        else if (moveState == 2)
        {   
            if (Greenfoot.isKeyDown("a") && canMoveLeft() && canMoveDown())
            {
                setLocation(getX() - 1*speedMultiplier, getY() + 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("d") && canMoveRight() && canMoveDown())
            {
                setLocation(getX() + 1*speedMultiplier, getY() + 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("a") && canMoveLeft())
            {
                setLocation(getX() - 1*speedMultiplier, getY());
            }
            else if (Greenfoot.isKeyDown("d") && canMoveRight())
            {
                setLocation(getX() + 1*speedMultiplier, getY());
            }
            else if (canMoveDown())
            {
                setLocation(getX(), getY() + 1*speedMultiplier);
            }
            animateDown(down1, down2);
        }
        // Main left
        else if (moveState == 3)
        {
            if (Greenfoot.isKeyDown("w") && canMoveUp() && canMoveLeft())
            {
                setLocation(getX() - 1*speedMultiplier, getY() - 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("s") && canMoveDown() && canMoveLeft())
            {
                setLocation(getX() - 1*speedMultiplier, getY() + 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("w") && canMoveUp())
            {
                setLocation(getX(), getY() - 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("s") && canMoveDown())
            {
                setLocation(getX(), getY() + 1*speedMultiplier);
            }
            else if (canMoveLeft())
            {
                setLocation(getX() - 1*speedMultiplier, getY());
            }
            animateLeft(left1, left2);
        }
        // Main right
        else if (moveState == 4)
        {   
            if (Greenfoot.isKeyDown("w") && canMoveUp() && canMoveRight())
            {
                setLocation(getX() + 1*speedMultiplier, getY() - 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("s") && canMoveDown() && canMoveRight())
            {
                setLocation(getX() + 1*speedMultiplier, getY() + 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("w") && canMoveUp())
            {
                setLocation(getX(), getY() - 1*speedMultiplier);
            }
            else if (Greenfoot.isKeyDown("s") && canMoveDown())
            {
                setLocation(getX(), getY() + 1*speedMultiplier);
            }
            else if (canMoveRight())
            {
                setLocation(getX() + 1*speedMultiplier, getY());
            }
            animateRight(right1, right2);
        }
    }
    // Ninja movement implementing animation End [Sean] + Debugged [Bill]
    // Animation System Start [Sean]
    public void animateUp(GreenfootImage up1, GreenfootImage up2)
    {
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
                frame = 1;
                return;
            }
            frame+=0.25;
    }
    
    public void animateDown(GreenfootImage down1, GreenfootImage down2)
    {
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
                frame = 1;
                return;
            }
            frame+=0.25;
    }
    
    public void animateLeft(GreenfootImage left1, GreenfootImage left2)
    {
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
            else if (frame == 5)
            {
                frame = 1;
                return;
            }
            frame+=0.25;
    }
    
    public void animateRight(GreenfootImage right1, GreenfootImage right2)
    {
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
    // Animation System End [Sean]
    // Hit Detection System Start [Bill]
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
    // Hit Detection System End [Bill]
}