import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inferno4 extends Trap
{
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    public Inferno4(Ninja ninja)
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
        levelCounter.setValue(4);
        addObject(ninja, 75, 75);
        for(int i = 0; i<11; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 50*i+25, 125);
        }
        for(int i = 0; i<5; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 100+50*i+25, /*175*/ 375+ -50*i);
        }
        for(int i = 0; i<5; i++)
        {
            InfernoFence infernoFence = new InfernoFence();
            addObject(infernoFence, 400+50*i+25, /*175*/ 700+ -50*i);
        }
        InfernoDoor infernodoor = new InfernoDoor();
        addObject(infernodoor, 76, 226);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 574, 678);
        instaPower instapower = new instaPower();
        addObject(instapower, 396, 188);
        Firebat firebat = new Firebat(8, 4);
        addObject(firebat, 61, 421);
        BlueRM bluerm = new BlueRM(8, 2);
        addObject(bluerm, 682, 657);
        bluerm.setLocation(688, 671);
        Firebat firebat2 = new Firebat(8, 4);
        addObject(firebat2, 402, 389);
        BlueRM bluerm2 = new BlueRM(8, 2);
        addObject(bluerm2, 185, 498);
        BlueRM bluerm3 = new BlueRM(8, 2);
        addObject(bluerm3, 350, 588);
        Firebat firebat3 = new Firebat(8, 4);
        addObject(firebat3, 603, 137);
        Firebat firebat4 = new Firebat(8, 4);
        addObject(firebat4, 704, 198);
        BlueRM bluerm4 = new BlueRM(8, 2);
        addObject(bluerm4, 597, 263);
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
            Greenfoot.setWorld(new InfernoBossLevel(ninja));
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
       Greenfoot.setWorld(new Inferno4(ninja));
    }
}