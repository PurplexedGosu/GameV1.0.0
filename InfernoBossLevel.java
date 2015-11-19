import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InfernoBossLevel extends Trap
{
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    private List<Bosses> infernoboss;
    Ninja ninja;
    private int delay = 11;
    private int fireballDelay = 11;
    public InfernoBossLevel(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
        
    }
    
    private void prepare()
    {
        for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence inferoFence = new InfernoFence();
                addObject(inferoFence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<24; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence inferoFence = new InfernoFence();
                addObject(inferoFence, 50*i+25, 25+j*700);
        }
        InfernoBoss infernoboss = new InfernoBoss(10);
        addObject(infernoboss, getWidth()/2 , getHeight()/2);

        InfernoFence infernofence = new InfernoFence();
        addObject(infernofence, 148, 119);
        InfernoFence infernofence2 = new InfernoFence();
        addObject(infernofence2, 630, 139);
        InfernoFence infernofence3 = new InfernoFence();
        addObject(infernofence3, 622, 601);
        InfernoFence infernofence4 = new InfernoFence();
        addObject(infernofence4, 162, 563);
        infernofence4.setLocation(160, 538);
        infernofence3.setLocation(596, 521);
        infernofence2.setLocation(582, 145);
        infernofence.setLocation(120, 114);
        infernofence4.setLocation(137, 530);
        infernofence4.setLocation(129, 531);
        infernofence3.setLocation(618, 530);
        infernofence3.setLocation(647, 568);
        infernofence4.setLocation(109, 565);
        infernofence4.setLocation(101, 499);
        infernofence2.setLocation(599, 179);
        infernofence.setLocation(152, 95);
        ArmPool armpool = new ArmPool(true);
        addObject(armpool, 347, 434);
        armpool.setLocation(155, 468);
        armpool.setLocation(150, 492);
        ArmPool armpool2 = new ArmPool(true);
        addObject(armpool2, 219, 101);
        ArmPool armpool3 = new ArmPool(true);
        addObject(armpool3, 616, 234);
        ArmPool armpool4 = new ArmPool(true);
        addObject(armpool4, 584, 542);
        armpool4.setLocation(579, 536);
        armpool3.setLocation(629, 213);
        armpool2.setLocation(213, 99);
        armpool.setLocation(166, 504);
        infernofence2.setLocation(628, 136);
        armpool3.setLocation(649, 185);
        infernofence3.setLocation(647, 602);
        armpool4.setLocation(581, 566);

        addObject(healthCounter, 70, 730);
        addObject(shurikenCounter, 225, 730);
        addObject(powerCounter, 500, 730);

        addObject(levelCounter, 355, 730);
        levelCounter.setValue(5);
        addObject(ninja, 100, 100);
        ninja.setLocation(100, 75);

        
        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText2 text = new TempText2(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
        }

        TempText4 text = new TempText4(infernoboss);
        addObject(text, infernoboss.getX(), infernoboss.getY()-20);
    }

    public void act()
    {
       //makeSmokeFireball();
       if (Greenfoot.isKeyDown("h")&&delay>10) 
       {
           Menu menu = new Menu(getThisWorld());
           Greenfoot.setWorld(menu);
           delay = 0;
           
       }
        if(getObjects(Ninja.class).size() != 0)
        {
        healthCounter.setValue(ninja.getNINJAHP());
        shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
        powerCounter.setValue(ninja.getPOWERBAR());
        checkDoor();
        /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       
       /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
       }
       delay++;
       fireballDelay++;
    }
    public void makeSmokeFireball()
    {
        if (delay > 100)
        {
            int randomNumber = Greenfoot.getRandomNumber(1000);
            if (randomNumber < 50)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 500, 475);
                delay = 0;
            }
            if (randomNumber >= 50 && randomNumber < 100)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 95, 661);
                delay = 0;
            }
            if (randomNumber >= 100 && randomNumber < 150)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 160, 493);
                delay = 0;
            }
            if (randomNumber >= 150 && randomNumber < 200)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 637, 423);
                delay = 0;
            }
            if (randomNumber >= 200 && randomNumber < 250)
            {
                SmokeFireball smokeFireball = new SmokeFireball();
                addObject(smokeFireball, 422, 285);
                delay = 0;
            }
        }
    }
    public void checkDoor()
    {
        if(ninja.checkInfernoDoor()==true)
            Greenfoot.setWorld(new Cinematic1(ninja));
    }
   public Ninja getNinja()
   {
       return ninja;
   }
   public Trap getThisWorld()
   {
       return this;
   }
   public void gameover(){
       ninja.setHP(ninja.getArmor());
       Greenfoot.setWorld(new InfernoBossLevel(ninja));
    }
}