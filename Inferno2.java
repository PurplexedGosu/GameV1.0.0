import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inferno2 extends Trap
{
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    public Inferno2(Ninja ninja)
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
        addObject(healthCounter, 70, 730);
        
        addObject(shurikenCounter, 225, 730);
        addObject(powerCounter, 500, 730);
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(1);
        addObject(ninja, 75, 75);
        
        npcs = getObjects(NPCS.class);
       for(int i = 0; i<npcs.size(); i++)
       {
           TempText2 text = new TempText2(npcs.get(i));
           addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
       }
       
        for(int i = 0; i<11; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+25, 125);
        }

        for(int i = 0; i<5; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 500+50*i+25, /*175*/ 400 -50*i);
        }
        for(int i = 0; i<5; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+25, /*175*/ 300+ 50*i);
        }
        InfernoDoor infernoDoor = new InfernoDoor();
        addObject(infernoDoor, 687, 687);
        Firebat firebat = new Firebat(8, 4);
        addObject(firebat, 429, 398);
        Firebat firebat2 = new Firebat(8, 4);
        addObject(firebat2, 216, 350);
        Firebat firebat3 = new Firebat(8, 4);
        addObject(firebat3, 358, 330);
        firebat3.setLocation(354, 311);
        Firebat firebat4 = new Firebat(8, 4);
        addObject(firebat4, 594, 617);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 37, 426);
        Firebat firebat5 = new Firebat(8, 4);
        addObject(firebat5, 69, 505);
        HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 37, 200);
        Firebat firebat6 = new Firebat(8, 4);
        addObject(firebat6, 632, 145);
        instaPower instapower = new instaPower();
        addObject(instapower, 517, 190);
        
        npcs = getObjects(NPCS.class);
       for(int i = 0; i<npcs.size(); i++)
       {
           TempText2 text = new TempText2(npcs.get(i));
           addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
       }
    }
    public void act()
    {
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
    }
    public void checkDoor()
    {
        if(ninja.checkInfernoDoor()==true)
            Greenfoot.setWorld(new Inferno3(ninja));
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
       Greenfoot.setWorld(new Inferno2(ninja));
    }
}