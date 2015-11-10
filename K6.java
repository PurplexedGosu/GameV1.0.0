import greenfoot.*;
import java.util.*;
/**
 * Write a description of class K6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class K6 extends Trap
{
    Ninja ninja;
    Counter healthCounter = new Counter("Health: "); //HAYDENS
    Counter shurikenCounter = new Counter("Shurikens: ");
    Counter levelCounter = new Counter("Level: ");
    Counter powerCounter = new Counter("Power: ");
    int delay = 11;
    private List<NPCS> npcs;
    /**
     * Constructor for objects of class K6.
     * 
     */
    public K6(Ninja ninja)
    {
        super();
        this.ninja = ninja;
        prepare();
    }
        private void prepare(){
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

        
                for (int i = 0; i<7; i++)
        {
            Fence fence = new Fence();
            addObject(fence, 50*i+200, 50*i+200);
        }
        addObject(ninja, 675, 675);
        
        addObject(healthCounter, 70, 730);

        addObject(shurikenCounter, 225, 730);
        
        addObject(powerCounter, 500, 730);

        addObject(levelCounter, 355, 730);
        levelCounter.setValue(3);
        
        doorT10 doort10 = new doorT10();
        addObject(doort10, 85, 85);
        
        HealthGlobe healthglobe = new HealthGlobe();
        addObject(healthglobe, 403, 351);
        healthglobe.setLocation(396, 346);
        addShuriken addshuriken = new addShuriken();
        addObject(addshuriken, 343, 404);
        addshuriken.setLocation(351, 399);
        BlueRM bluerm = new BlueRM(3, 2);
        addObject(bluerm, 304, 245);
        BlueRM bluerm2 = new BlueRM(3, 2);
        addObject(bluerm2, 255, 300);
        bluerm2.setLocation(252, 300);
        RedMM redmm = new RedMM(2, 2);
        addObject(redmm, 444, 313);
        RedMM redmm2 = new RedMM(2, 2);
        addObject(redmm2, 317, 448);
        RedMM redmm3 = new RedMM(2, 2);
        addObject(redmm3, 164, 458);
        RedMM redmm4 = new RedMM(2, 2);
        addObject(redmm4, 451, 172);
        BlueRM bluerm3 = new BlueRM(4, 2);
        addObject(bluerm3, 88, 652);
        BlueRM bluerm4 = new BlueRM(4, 2);
        addObject(bluerm4, 649, 106);
        RedMM redmm5 = new RedMM(2, 2);
        addObject(redmm5, 537, 415);
        RedMM redmm6 = new RedMM(2, 2);
        addObject(redmm6, 420, 546);
        
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
        }
        delay++;
    }
    
    public void checkDoor()
    {
        if(ninja.checkDoor()==true)
            Greenfoot.setWorld(new K7(ninja));
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
