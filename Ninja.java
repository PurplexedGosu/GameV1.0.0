import greenfoot.*;
/**
 * Functionality in this class:
 * Ninja Melee
 * Ninja Ranged
 * Relationship to Melee AI "CURRENTLY CALLED RANGED AI"
 */

public class Ninja extends Heroes
{
   private int progress = 0;
   private boolean powerUpTwo = false;
    
    private boolean transparent = false;
   private int transparentDelay = 36;
    
    static int speedMultiplier = 2;
    private int delay = 21;
    // Start Hayden Variables
    public int powerBar = 100;
    public int powerBarDelay = 0;
    
    public int shurikennumber = 8;
    
    private int delay1 = 71;
    private int ninjahp = 5;
    
    private int points = 0;
    private int meleeDamage = 1;
    private int rangeDamage = 1;
    private int armor = 5;
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
        keyState(up1, down1, left1, right1); // Checks which movement button is pressed first
        betaMovement(speedMultiplier, up1, up2, down1, down2, left1, left2, right1, right2); // Implements movement + animation
        hitLightning(); // Implements melee attack
        shootShuriken(); // Implements ranged attack
        minionAttack();
        damageRangedMinion();
        transparent();
        powerBarCount();
        addPower();
        addShuriken();
        addHealth();
        powerUpOne();
        powerUpTwo();
        ninjaDied();
    }    
    public void powerBarCount(){
        powerBarDelay++;
        if (powerBarDelay >= 60){
            powerBarDelay = 0;
            if (powerBar < 100){
                powerBar++;
            }
        }
    }
    
    // Melee Attack Start [Bill]
    public void hitLightning()
    {
        if ((Greenfoot.isKeyDown("enter") && delay>40))
        {
            Lightning l1 = new Lightning(swordRotation);
            SwordSwing swordSwing = new SwordSwing(getSwordRotation());
            if(this.getImage()==up1||this.getImage()==up2)
            {
                getWorld().addObject(l1, getX(), getY()-20);
                l1.setRotation(getRotation() -90); 
                getWorld().addObject(swordSwing, getX(), getY() - 20);
            }
            else if(this.getImage()==down1||this.getImage()==down2)
            {
                getWorld().addObject(l1, getX(), getY()+20);
                l1.setRotation(getRotation() -90);
                getWorld().addObject(swordSwing, getX(), getY() + 20);
            }
            else if(this.getImage()==left1||this.getImage()==left2)
            {
                getWorld().addObject(l1, getX()-20, getY());
                l1.setRotation(getRotation() -90);
                getWorld().addObject(swordSwing, getX() - 20, getY());
            }
            else if(this.getImage()==right1||this.getImage()==right2)
            {
                getWorld().addObject(l1, getX()+20, getY());
                l1.setRotation(getRotation() -90);
                getWorld().addObject(swordSwing, getX() + 20, getY());
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
        if (Greenfoot.isKeyDown("shift")  && delay> 50 && shurikennumber >0)
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
        if (delay1 >= 35){
            delay1 = 0;
            NPCS actor = (NPCS) getOneIntersectingObject(MeleeMinion.class);
           if (actor != null&&!powerUpTwo)
           {
                ninjahp-= actor.getDamage();
                transparentDelay = 0;
                NinjaBlood ninjaBlood = new NinjaBlood();
                getWorld().addObject(ninjaBlood, getX(), getY());
           }
           if (actor != null)
           {
               MinionClaw minionClaw = new MinionClaw();
               getWorld().addObject(minionClaw, getX(), getY());
           }
        }
    }
    public void transparent()
    {
        if(transparentDelay<35)
        {
            getImage().setTransparency(100);
        }
        if(transparentDelay>34)
        {
            getImage().setTransparency(255);
        }
        transparentDelay++;
    }
    
    public void ninjaDied()
    {
        if (ninjahp <= 0)
        {
            //Trap trapWorld = (Trap)getWorld();
            //trapWorld.infernostart();
            Greenfoot.setWorld(new Inferno(this));
        }
    }
   
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
    public int getSHURIKENNUMBER(){
        return shurikennumber;
    }
    public int getNINJAHP(){
        return ninjahp;
    }
        public int getPOWERBAR(){
        return powerBar;
    }
    public boolean checkDoor()
    {
        if(getWorld().getObjects(Ninja.class).size()!=0)
        {
        Actor actor = getOneIntersectingObject(Door.class);
        if(actor!=null)
            return true;
        else 
            return false;
        }
        return false;
    }
    public void damageRangedMinion()
    {
        Darkness darkness = (Darkness) getOneIntersectingObject(Darkness.class);
        if(darkness!=null&&!powerUpTwo)
        {
            ninjahp-=darkness.getDamage();
            NinjaBlood ninjaBlood = new NinjaBlood();
            getWorld().addObject(ninjaBlood, getX(), getY());
        }
    }
    // "Currently under ranged minion" Melee minion AI End [Hayden] 
       public void powerUpOne(){
        if (powerBar >= 1  && (canMoveUp() || canMoveDown() || canMoveLeft() || canMoveRight())){
            
            if (Greenfoot.isKeyDown("space"))
            {
                powerBar -= 1;
                speedMultiplier = 4;
            }
            else
            {
                speedMultiplier = 2;
            }
        }
        else
        {
            speedMultiplier = 2;
        }
    }
        public void powerUpTwo(){
            if(powerBar>0&&(Greenfoot.isKeyDown("'") || Greenfoot.isKeyDown("r")))
            {
                getImage().setTransparency(100);
                powerBar-=1;
                powerUpTwo = true;
            }
            else
                powerUpTwo = false;
    }
        public void powerUpThree(){
        if (powerBar >= 100){
            
            powerBar=0;
        }
    }
        public void addShuriken(){
        Actor SP  = getOneIntersectingObject(addShuriken.class);
        if (SP != null){
            shurikennumber += 3;
            getWorld().removeObject(SP);
        }
    } 
            public void addPower(){
        Actor PP  = getOneIntersectingObject(instaPower.class);
        if (PP != null){
            if (powerBar <= 50)
            {
                powerBar += 50;
            }
            else
            {
                powerBar+= (100-powerBar);
            }
            
            getWorld().removeObject(PP);
        }
    }
    public void addHealth(){
        Actor HP  = getOneIntersectingObject(HealthGlobe.class);
        if (HP != null){
            ninjahp += 3;
            getWorld().removeObject(HP);
            if(ninjahp>armor)
                ninjahp = armor;
        }
    }
    public void setPoints(int a)
    {
        points = a;
    }
    public int getPoints()
    {
        return points;
    }
    public int getHP()
    {
        return ninjahp;
    }
    public void setHP(int a)
    {
        ninjahp = a;
    }
    public void setProgress(int a)
    {
        progress = a;
    }
    public int getProgress(int a)
    {
        return progress;
    }
}
