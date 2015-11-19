import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class T23 extends Trap
{
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    public T23(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }

    private void prepare()
    {
        doorT21 doort21 = new doorT21();
        addObject(doort21, 125, 625);
        for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
                Stump fence = new Stump();
                addObject(fence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<24; i++)
            for(int j = 0; j<2; j++)
            {
                Stump fence = new Stump();
                addObject(fence, 50*i+25, 25+j*700);
        }
        for(int i = 1; i<7; i++)
        {
            Teleport teleport = new Teleport();
            addObject(teleport, 100*i+25, 100*i+25);
        }
        for(int i = 1; i<7; i++)
        {
            BlueRM bluerm = new BlueRM(2, 2);
            addObject(bluerm, 100*i+75, 100*i+75);
        }
        for(int i = 1; i<9; i++)
        {
            Stump fence = new Stump();
            addObject(fence, 50*i+25, 50*i+225); 
        }
        for(int i = 2; i<11; i++)
        {
            Stump fence = new Stump();
            addObject(fence, 50*i+175, 50*i+25);
        }
        instaPower instaPower1 = new instaPower();
        addObject(instaPower1, 325, 425);
        addObject(healthCounter, 70, 730);
        addObject(shurikenCounter, 225, 730);
        addObject(powerCounter, 500, 730);
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(23);
        addObject(ninja, 675, 75);
        npcs = getObjects(NPCS.class);
        for(int i = 0; i<npcs.size(); i++)
        {
            TempText2 text = new TempText2(npcs.get(i));
            addObject(text, npcs.get(i).getX(), npcs.get(i).getY()-20);
        }
    }

    public void act()
    {
        checkTeleport();
        if (Greenfoot.isKeyDown("h")&&delay>10) 
        {
            Menu menu = new Menu(getThisWorld());
            Greenfoot.setWorld(menu);
            delay = 0;

        }
        if(getObjects(Ninja.class).size() != 0)
        {
            checkDoorT21();
            healthCounter.setValue(ninja.getNINJAHP());
            shurikenCounter.setValue(ninja.getSHURIKENNUMBER());
            powerCounter.setValue(ninja.getPOWERBAR());
            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 

            /**/ // TEMPORAY FUNCTIONS FOR HAYDEN TO CHANGE LEVELS TO MAKE THEM /**/ 
        }
        delay++;
    }
    public void checkTeleport(){
        if(ninja.checkTeleport())
        {
            ninja.setLocation(675, 75);
        }
    }
    public void checkDoorT21()
    {
         if(ninja.checkDoorT21()==true)
            Greenfoot.setWorld(new T24(ninja));
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
       Greenfoot.setWorld(new T23(ninja));
    }
}