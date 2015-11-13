import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class T24 extends Trap
{
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    private List<NPCS> npcs;
    Ninja ninja;
    int delay = 11;
    public T24(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }

    private void prepare()
    {
        doorT21 doort21 = new doorT21();
        addObject(doort21, 625, 125);
        for(int i = 0; i<15; i++)
            for(int j = 0; j<2; j++)
            {
                Fence fence = new Fence();
                addObject(fence, 25+j*700, 50*i+25);
        }
        for(int i = 1;i<24; i++)
            for(int j = 0; j<2; j++)
            {
                Fence fence = new Fence();
                addObject(fence, 50*i+25, 25+j*700);
        }
        for(int i = 1; i<8; i++)
        {
            BlueMM bluemm = new BlueMM(2,2);
            addObject(bluemm, 25+i*50, 425);
        }
        for(int i = 1; i<5; i++)
        {
            BlueMM bluemm = new BlueMM(2, 2);
            addObject(bluemm, 375, 675-50*i);
        }
        for(int i = 4; i<10; i++)
        {
            BlueMM bluemm = new BlueMM(2, 2);
            addObject(bluemm, 225+50*i, 225);
        }
        Teleport teleport1 = new Teleport();
        addObject(teleport1, 375, 275);
        Teleport teleport2 = new Teleport();
        addObject(teleport2, 375, 325);
        Teleport teleport3 = new Teleport();
        instaPower instaPower1 = new instaPower();
        addObject(instaPower1, 125, 675);
        instaPower instaPower2 = new instaPower();
        addObject(instaPower2, 175, 675);
        addObject(teleport3, 375, 375);
        addObject(healthCounter, 70, 730);
        addObject(shurikenCounter, 225, 730);
        addObject(powerCounter, 500, 730);
        addObject(levelCounter, 355, 730);
        levelCounter.setValue(69);
        addObject(ninja, 75, 675);
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
            ninja.setLocation(75, 675);
        }
    }

    public void checkDoorT21()
    {
         if(ninja.checkDoorT21()==true)
            Greenfoot.setWorld(new T25(ninja));
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
       Greenfoot.setWorld(new T24(ninja));
    }
}