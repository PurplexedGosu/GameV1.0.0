import greenfoot.*;
//import Math;

/**
 * Write a description of class Ninja here.
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Ninja extends Heroes
{
    static int speedMultiplier = 2;
    private int delay = 21;
    
    private int ninjaRotation = 0;
    private GreenfootImage up1 = new GreenfootImage("Ninja/Ninja Up/ninja_sprites_up_stance_left_step2.png");
    private GreenfootImage up2 = new GreenfootImage("Ninja/Ninja Up/ninja_sprites_up_stance_right_step2.png");
    
    private GreenfootImage down1 = new GreenfootImage("Ninja/Ninja Down/ninja_sprites_down_stance_left_step2.png");
    private GreenfootImage down2 = new GreenfootImage("Ninja/Ninja Down/ninja_sprites_down_stance_right_step2.png");
    
    private GreenfootImage left1 = new GreenfootImage("Ninja/Ninja Left/ninja_sprites_left_stance_left_step2.png");
    private GreenfootImage left2 = new GreenfootImage("Ninja/Ninja Left/ninja_sprites_left_stance2.png");
    
    private GreenfootImage right1 = new GreenfootImage("Ninja/Ninja Right/ninja_sprites_right_stance_left_step2.png");
    private GreenfootImage right2 = new GreenfootImage("Ninja/Ninja Right/ninja_sprites_right_stance2.png");
    
    public Ninja()
    {
        GreenfootImage image = getImage();
        image.scale(40, 40);
        setImage(image);
    }
    public void act() 
    {
        //animateMovement(speedMultiplier, up1, up2, down1, down2, left1, left2, right1, right2);
        keyState();
        betaMovement(speedMultiplier, up1, up2, down1, down2, left1, left2, right1, right2);
        hitLightning();
        shootShuriken();
    }    
    // Melee Attack, Bill's
    public void hitLightning()
    {
        if (useF() == true&&delay>20)
        {
            Lightning l1 = new Lightning();
            if(getImage()==up1||getImage()==up2)
            {
                getWorld().addObject(l1, getX(), getY()-20);
                l1.setRotation(getRotation() -90);          
            }
            if(getImage()==down1||getImage()==down2)
            {
                getWorld().addObject(l1, getX(), getY()+20);
                l1.setRotation(getRotation() -90);
            }
            if(getImage()==left1||getImage()==left2)
            {
                getWorld().addObject(l1, getX()-20, getY());
                l1.setRotation(getRotation() -90);
            }
            if(getImage()==right1||getImage()==right2)
            {
                getWorld().addObject(l1, getX()+20, getY());
                l1.setRotation(getRotation() -90);
            }
            delay = 0;
        }
        delay++;
    }
    // Ranged Attack
    public void shootShuriken()
    {
        // Up Left
        if (Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 225;
        }
        // Up Right
        else if (Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 315;
        }
        // Down Left
        if (!Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 135;
        }
        // Down Right
        else if (!Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 45;
        }
        // Up
        else if (Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 270;
        }
        // Down
        else if (!Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 90;
        }
        // Left
        else if (!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 180;
        }
        // Right
        else if (!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 360;
        }
        if (useSpacebar() == true  && delay>20)
        {
            Shuriken s1 = new Shuriken();
            // Convert to cart sqrt
            // get x^2 + get y^2 = R
            // add 10 to R
            // get rotation
            if (ninjaRotation == 225)
            {
                getWorld().addObject(s1, getX() - 15, getY() - 15);
            }
            else if (ninjaRotation == 315)
            {
                getWorld().addObject(s1, getX() + 15, getY() - 15);
            }
            else if (ninjaRotation == 135)
            {
                getWorld().addObject(s1, getX() - 15, getY() + 15);
            }
            else if (ninjaRotation == 45)
            {
                getWorld().addObject(s1, getX() + 15, getY() + 15);
            }
            else if (ninjaRotation == 270)
            {
                getWorld().addObject(s1, getX(), getY() - 15);
            }
            else if (ninjaRotation == 90)
            {
                getWorld().addObject(s1, getX(), getY() + 15);
            }
            else if (ninjaRotation == 180)
            {
                getWorld().addObject(s1, getX() - 15, getY());
            }
            else if (ninjaRotation == 360)
            {
                getWorld().addObject(s1, getX() + 15, getY());
            }
            //getWorld().addObject(s1, getX(), getY());
            s1.setRotation(ninjaRotation);
            delay = 0;
        }
        delay++;
    }
}
