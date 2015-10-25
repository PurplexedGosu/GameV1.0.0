import greenfoot.*;
/**
 * Functionality in this class:
 * Ninja Melee
 * Ninja Ranged
 * Relationship to Melee AI "CURRENTLY CALLED RANGED AI"
 */

public class Ninja extends Heroes
{
    static int speedMultiplier = 2;
    private int delay = 21;
    // Start Hayden Variables
    public int shurikennumber = 8;
    public int getSHURIKENNUMBER(){
        return shurikennumber;
    }
    private int delay1 = 71;
    private int ninjahp = 5;
    public int getNINJAHP(){
        return ninjahp;
    }
    private int points = 0;
    private int meleeDamage = 0;
    private int rangeDamage = 0;
    private int armor = 0;
    // End Hayden Variables
    
    private int ninjaRotation = 0;
    private int swordRotation = 0;
    // Ninja sprite images Start [Tiffany]
    private GreenfootImage up1 = new GreenfootImage("Ninja2/Ninja Up/Ninja Up. Left Step.png");
    private GreenfootImage up2 = new GreenfootImage("Ninja2/Ninja Up/Ninja Up. Right Step.png");
    
    private GreenfootImage down1 = new GreenfootImage("Ninja2/Ninja Down/Ninja Down. Left Step.png");
    private GreenfootImage down2 = new GreenfootImage("Ninja2/Ninja Down/Ninja Down. Right Step.png");
    
    private GreenfootImage left1 = new GreenfootImage("Ninja2/Ninja Left/Ninja Left. Left Step.png");
    private GreenfootImage left2 = new GreenfootImage("Ninja2/Ninja Left/Ninja Left. Right Step.png");
    
    private GreenfootImage right1 = new GreenfootImage("Ninja2/Ninja Right/Ninja Right. Left Step.png");
    private GreenfootImage right2 = new GreenfootImage("Ninja2/Ninja Right/Ninja Right. Right Step.png");
    // Ninja sprite images End [Tiffany]
    
    public Ninja()
    {
    }
    public void act() 
    {
        keyState(); // Checks which movement button is pressed first
        betaMovement(speedMultiplier, up1, up2, down1, down2, left1, left2, right1, right2); // Implements movement + animation
        hitLightning(); // Implements melee attack
        shootShuriken(); // Implements ranged attack
        minionAttack();
        ninjaDied();
    }    
    // Melee Attack Start [Bill]
    public void hitLightning()
    {
        if (Greenfoot.isKeyDown("f") || Greenfoot.isKeyDown("control") && delay>20)
        {
            Lightning l1 = new Lightning(swordRotation);
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
    // Melee Attack End [Bill]
    // Ranged Attack Start [Sean]
    public void shootShuriken()
    {
        // Up Left
        if (Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 225;
            swordRotation = 0;
        }
        // Up Right
        else if (Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 315;
            swordRotation = 0;
        }
        // Down Left
        if (!Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 135;
            swordRotation = 0;
        }
        // Down Right
        else if (!Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 45;
            swordRotation = 0;
        }
        // Up
        else if (Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 270;
            swordRotation = 0;
        }
        // Down
        else if (!Greenfoot.isKeyDown("w") && Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 90;
            swordRotation = 0;
        }
        // Left
        else if (!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 180;
            swordRotation = 90;
        }
        // Right
        else if (!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("d"))
        {
            ninjaRotation = 360;
            swordRotation = 0;
        }
        if (Greenfoot.isKeyDown("space")  && delay> 50 && shurikennumber >0)
        {
            Shuriken s1 = new Shuriken();
            shurikennumber--;
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
            s1.setRotation(ninjaRotation);
            delay = 0;
        }
        delay++;
    }
    // Ranged Attack End [Sean]
    
    // "Currently under ranged minion" Melee minion AI Reaction Start [Hayden] 
    public void minionAttack()
    {
        delay1++;
        if (delay1 >= 70){
            delay1 = 0;
           if (getOneIntersectingObject(RangedMinion.class) != null){
            ninjahp--;
           }
        }
    }
    public void ninjaDied()
    {
        if (ninjahp <= 0)
        {
            Kyobashi world = (Kyobashi)getWorld();
            world.infernostart();
        }
    }
    /*    public void ninjaK1K2()
    {
        if (getX() >= 100 && getY() >= 100)
        {
            Kyobashi world = (Kyobashi)getWorld();
            world.infernostart();
        }
    }*/
    // If ninja hits edge of world
    
    public int getMeleeDamage()
    {
        return meleeDamage;
    }
    
    public int getRangeDamage()
    {
        return rangeDamage;
    }
    
    public int getArmor()
    {
        return armor;
    }
    
    public void setMeleeDamage(int a)
    {
        meleeDamage = a;
    }
    
    public void setRangeDamage(int a)
    {
        rangeDamage = a;
    }
    
    public void setArmor(int a)
    {
        armor = a;
    }
    // "Currently under ranged minion" Melee minion AI End [Hayden] 
}
