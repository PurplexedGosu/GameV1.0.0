import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inferno1 extends Trap
{
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    Ninja ninja;
    private int delay = 11;
    private int fireballDelay = 11;
    public Inferno1(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }
    private void prepare()
    {
        Door door = new Door();
        addObject(door, 663, 651);
        
        for(int i = 0; i<15; i++)
           for(int j = 0; j<2; j++)
            {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 25+j*700, 50*i+25);
            }
        for(int i = 1;i<15; i++)
            for(int j = 0; j<2; j++)
            {
                InfernoFence infernoFence = new InfernoFence();
                addObject(infernoFence, 50*i+25, 25+j*700);
            }
            
            
        for(int i = 0; i<12; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+25, 125);
        }
        for(int i = 0; i<11; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+175, 225);
        }
        Firebat firebat = new Firebat(8, 3);
        addObject(firebat, 541, 652);
        
        Firebat firebat2 = new Firebat(8, 3);
        addObject(firebat2, 561, 625);
        
        Firebat firebat3 = new Firebat(8, 3);
        addObject(firebat3, 588, 584);
        
        Firebat firebat4 = new Firebat(8, 3);
        addObject(firebat4, 629, 569);
        
        Firebat firebat5 = new Firebat(8, 3);
        addObject(firebat5, 203, 608);
        
        Firebat firebat6 = new Firebat(8, 3);
        addObject(firebat6, 484, 388);
        
        Firebat firebat7 = new Firebat(8, 3);
        addObject(firebat7, 320, 350);
        
        InfernoFence infernoFence = new InfernoFence();
        addObject(infernoFence, 133, 417);
        
        InfernoFence infernoFence2 = new InfernoFence();
        addObject(infernoFence2, 256, 334);
        
        InfernoFence infernoFence3 = new InfernoFence();
        addObject(infernoFence3, 164, 571);
        
        InfernoFence infernoFence4 = new InfernoFence();
        addObject(infernoFence4, 301, 489);
        
        InfernoFence infernoFence5 = new InfernoFence();
        addObject(infernoFence5, 429, 360);
        
        InfernoFence infernoFence6 = new InfernoFence();
        addObject(infernoFence6, 325, 669);
        
        InfernoFence infernoFence7 = new InfernoFence();
        addObject(infernoFence7, 472, 571);
        
        InfernoFence infernoFence8 = new InfernoFence();
        addObject(infernoFence8, 602, 322);
        
        addObject(healthCounter, 70, 730);
        
        addObject(shurikenCounter, 225, 730);
        addObject(powerCounter, 500, 730);
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(1);
        addObject(ninja, 100, 100);
        ninja.setLocation(100, 75);
        
        
        
       npcs = getObjects(NPCS.class);
       for(int i = 0; i<npcs.size(); i++)
       {
           TempText2 text = new TempText2(npcs.get(i));
           addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
       }
    }
    public void act()
    {
       makeSmokeFireball();
       if (Greenfoot.isKeyDown("j")&&delay>10) 
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
        if(ninja.checkDoor()==true)
            Greenfoot.setWorld(new Inferno2(ninja));
    }
   public Ninja getNinja()
   {
       return ninja;
   }
   public Trap getThisWorld()
   {
       return this;
   }
    
}