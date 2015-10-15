import greenfoot.*;

/**
 * Write a description of class Ninja here.
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Ninja extends Heroes
{
    static int speedMultiplier = 2;
    private int delay = 21;
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
        
        moveUp(speedMultiplier, up1, up2);
        moveDown(speedMultiplier, down1, down2);
        moveLeft(speedMultiplier, left1, left2);
        moveRight(speedMultiplier, right1, right2);
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
        if (useSpacebar() == true  && delay>20)
        {
            Shuriken s1 = new Shuriken();
            getWorld().addObject(s1, getX(), getY());
            s1.setRotation(getRotation() -90);
            delay = 0;
        }
        delay++;
    }
}
