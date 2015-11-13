import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inferno3 extends Trap
{
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    public Inferno3(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        addObject(ninja, 50, 50);
        prepare();
    }

    private void prepare()
    {
        addObject(healthCounter, 70, 730);
        
        addObject(shurikenCounter, 225, 730);
        addObject(powerCounter, 500, 730);
        
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(1);
       for(int i = 0; i<11; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+25, 125);
        }
        for(int i = 0; i<5; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+25, /*175*/ 500+ -50*i);
        }

        InfernoDoor infernodoor = new InfernoDoor();
        addObject(infernodoor, 71, 646);
        Firebat firebat = new Firebat(8, 4);
        addObject(firebat, 68, 324);
        Firebat firebat2 = new Firebat(8, 4);
        addObject(firebat2, 185, 609);
        BlueRM bluerm = new BlueRM(8, 2);
        addObject(bluerm, 550, 581);
        BlueRM bluerm2 = new BlueRM(8, 2);
        addObject(bluerm2, 391, 481);
        BlueRM bluerm3 = new BlueRM(8, 2);
        addObject(bluerm3, 264, 355);
        Firebat firebat3 = new Firebat(8, 4);
        addObject(firebat3, 279, 458);
        Firebat firebat4 = new Firebat(8, 4);
        addObject(firebat4, 459, 569);
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
            Greenfoot.setWorld(new Inferno4(ninja));
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
       Greenfoot.setWorld(new Inferno3(ninja));
    }
}